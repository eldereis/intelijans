package com.turktelekom.attip.cfm.sendjms;

import java.util.ArrayList;
import java.util.Map;

import java.util.Properties;
import java.util.Set;

import weblogic.jndi.Environment;

import javax.jms.*;
import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.spi.InitialContextFactory;

import org.apache.log4j.Logger;
import oracle.integration.platform.faultpolicy.IFaultRecoveryContext;
import oracle.integration.platform.faultpolicy.IFaultRecoveryJavaClass;

import oracle.tip.mediator.common.api.CalloutMediatorMessage;
import oracle.tip.mediator.common.error.recovery.MediatorRecoveryContext;
import oracle.tip.mediator.utils.XmlUtils;

import org.w3c.dom.Node;

/**
 * by Ivan Lichner, Oracle, 2010
 *
 * This class is used as an SOA Suite fault policy recovery action.
 * It sends the original payload of faulted composite component (Mediator or BPEL flow) to dedicated JMS Error queue.
 * JMS queue details are defined in fault policy properties.
 *
 * To DEPLOY this Java class, package it as a JAR file and use instructions provided in http://download.oracle.com/docs/cd/E12839_01/integration.1111/e10224/bp_java.htm#BABCBEJJ,
 * Oracle� Fusion Middleware Developer's Guide for Oracle SOA Suite 11g Release 1 (11.1.1), section 13.3 Adding Custom Classes and JAR Files
 *
 * 1) build JAR file
 * 2) copy JAR to /product/Middleware/Oracle_SOA1/soa/modules/oracle.soa.ext_11.1.1
 * 3) cd /product/Middleware/Oracle_SOA1/soa/modules/oracle.soa.ext_11.1.1
 * 4) /product/Middleware/modules/org.apache.ant_1.7.1/bin/ant
 * 5) restart SOA managed server
 *
 */
public class SendJmsFaultRecovery implements IFaultRecoveryJavaClass {
  
  private static final Logger LOGGER = Logger.getLogger(SendJmsFaultRecovery.class);

  private static final String SUCCESS = "OK";
  private static final String ERROR = "ERROR";
  
  private static final String PROP_CF_JNDI = "ConnectionFactoryJndi";
  private static final String PROP_QUEUE_JNDI = "QueueJndi";
  private static final String PROVIDERURL = "providerUrl";
  private static final String CREDENTIAL = "credential";
  private static final String PRINCIPAL = "principal";
  
  public SendJmsFaultRecovery() {
    super();
  }

  public void handleRetrySuccess(IFaultRecoveryContext ifc) {
    LOGGER.info("handleRetrySuccess");
    handleFault(ifc);
  }

  public String handleFault(IFaultRecoveryContext ifc) {
    String resp;
    try {
      resp = handleFaultHelper(ifc);
    }
    catch (Exception e) {
      LOGGER.error("Exception during SendJms fault recovery action", e);
      resp = ERROR;
    }
    
    return resp;
  }
  
  private String handleFaultHelper(IFaultRecoveryContext ifc) throws Exception {
    //TODO remove if apache log works
    System.out.println("=========== SendJmsFaultRecovery ===========");

    Map props = ifc.getProperties();
    Set<Map.Entry> setting = props.entrySet();
    String cfJndiName="";
    String queueJndiName="";
    String providerUrl="";
    String principal="";
    String credential="";
        try {
            for (Map.Entry entry : setting) {
                if (entry.getKey().equals(PROP_CF_JNDI)) cfJndiName = ((ArrayList)entry.getValue()).get(0).toString();
                 
                if (entry.getKey().equals(PROP_QUEUE_JNDI)) queueJndiName = ((ArrayList)entry.getValue()).get(0).toString();
               
                if (entry.getKey().equals(PROVIDERURL)) providerUrl = ((ArrayList)entry.getValue()).get(0).toString();
                 
                if (entry.getKey().equals(CREDENTIAL)) credential = ((ArrayList)entry.getValue()).get(0).toString();
                 
                if (entry.getKey().equals(PRINCIPAL)) principal = ((ArrayList)entry.getValue()).get(0).toString();
                 
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            LOGGER.error("Exception during recovery of fault policy properties: " + e.getMessage());
          throw new Exception("Exception during recovery of fault policy properties:");
        }
 

    
    LOGGER.info("SendJmsFaultRecovery java action handling the fault: ");
    LOGGER.info("  policyId = " + ifc.getPolicyId());
    
    if (ifc instanceof MediatorRecoveryContext) {
      MediatorRecoveryContext mrc = (MediatorRecoveryContext)ifc;
      CalloutMediatorMessage msg = mrc.getMediatorMessage();
      Map payloadMap = msg.getPayload();
      Set<Map.Entry> set = payloadMap.entrySet();
      
      for (Map.Entry entry : set) {
        LOGGER.info("Part: " + entry.getKey());
        String sPayload = XmlUtils.convertDomNodeToString((Node)entry.getValue());
        LOGGER.info("Payload: " + sPayload);

        try {
                    sendJms(cfJndiName, queueJndiName, sPayload,principal,credential,providerUrl);
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                  System.out.println("catch sendJms  " + e.getMessage());
                }
      }
    }
    else {
      throw new Exception("FaultRecoveryContext is not a Mediator context.");
    }
    
    return SUCCESS;
  }

  private void sendJms(String cfJndiName, String queueJndiName, String message,String principal, String credential, String providerurl) throws Exception {
    Environment env = new Environment();

    Properties p = new Properties();
       p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");          
       p.put(Context.SECURITY_PRINCIPAL,principal);
       p.put(Context.SECURITY_CREDENTIALS,credential);
       p.put(Context.PROVIDER_URL,providerurl);
       InitialContext ic = new InitialContext(p); 

    System.out.println("Provider url" + providerurl);
    System.out.println("PRINCIPAL" + principal);
    System.out.println("Credential" + credential);
    System.out.println("Connecction Factory " + cfJndiName);
    System.out.println("Queue  " + queueJndiName);

    QueueConnectionFactory qcf = (QueueConnectionFactory) ic.lookup(cfJndiName);
    QueueConnection queueConn = qcf.createQueueConnection();

    QueueSession queueSession = queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    Queue queue = (Queue) ic.lookup(queueJndiName);
    QueueSender queueSender = queueSession.createSender(queue);

    queueConn.start();
    
    TextMessage jmsMessage = queueSession.createTextMessage(message);
    
    System.out.println("--- Sender ---");
    System.out.println("Sending MSG " + jmsMessage);
   
    
    queueSender.send(jmsMessage);
    
    System.out.println("Sent MSG  " + jmsMessage);
  }

}
