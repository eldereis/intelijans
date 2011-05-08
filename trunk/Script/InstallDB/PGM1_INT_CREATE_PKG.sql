CREATE OR REPLACE PACKAGE attip_core IS
/******************************************************************************
PACKAGE NAME: ATTIP_Core

    Package specification with core functionality on aTTIP infrastructure

   REVISIONS:

   Ver        Date        Author           Description

   ---------  ----------  ---------------  ------------------------------------
   1.0        03/06/2010  PL		           Created this package
   1.1        15/06/2010  PL               Integrated Error Catalogue retrieve

 ******************************************************************************/


/******************************************************************************
   NAME:       UpdateStatusOnResponse
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/06/2010  PL		   Created this procedure.

   NOTES:  Update event status

******************************************************************************/
PROCEDURE UpdateStatusOnResponse(IN_ATTIP_REQUEST_ID IN VARCHAR2, IN_STATUS IN NUMBER
                                ,OUT_TS_CREATED OUT TIMESTAMP,OUT_TS_UPDATED OUT TIMESTAMP,OUT_SOURCE_SYSTEM OUT VARCHAR2
                                ,OUT_CORRELATION_ID OUT VARCHAR2,OUT_REQUEST_ID OUT VARCHAR2,OUT_SERVICE OUT VARCHAR2
                                ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);

/******************************************************************************
   NAME:       UpdateStatusOnRequest
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        13/09/2010  PL		   Created this procedure.

   NOTES:  Update event status

******************************************************************************/
PROCEDURE UpdateStatusOnRequest(IN_REQUEST_ID IN VARCHAR2, IN_STATUS IN NUMBER
                                ,OUT_TS_CREATED OUT TIMESTAMP,OUT_TS_UPDATED OUT TIMESTAMP,OUT_SOURCE_SYSTEM OUT VARCHAR2
                                ,OUT_CORRELATION_ID OUT VARCHAR2,OUT_REQUEST_ID OUT VARCHAR2,OUT_SERVICE OUT VARCHAR2
                                ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);


/******************************************************************************
   NAME:       CheckDuplicate
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/06/2010  PL		           Created this procedure.
   1.1        15/06/2010  PL               Integrated PXNAME and DIRECTION
   1.2        16/06/2010  PL               Check on DIRECTION INBOUND for duplicate events

   NOTES:  Check duplicate resubmition on aTTIP infrastructure
           Return OUT_RET_CODE = 0 if not duplicate
                                 1 if duplicate
                                 -1 if catched any error
          Values for IN_DIRECTION:
            - INBOUND and OUTBOUND

******************************************************************************/
PROCEDURE CheckDuplicate(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2, IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);



/******************************************************************************
   NAME:       CheckSequencing
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        18/10/2010  PL		           Created this procedure.

   NOTES:  Extend CheckDuplicate with checking sequence order on inbound events on aTTIP infrastructure.
           If sequence order is not respected the next event will be traced as RESUBMITABLE (status 3) and
           Error SOA-100009 will be propagated to caller.
           Return OUT_RET_CODE = 0 if not duplicate
                                 1 if duplicate
                                 -1 if catched any error
          Values for IN_DIRECTION:
            - INBOUND and OUTBOUND

    STEPs
    1. CheckSequencing
        1.1 IF the couple BID,SERVICE is into the table IDEMPOTENCE
          1.1.1 IF all request are closed, continue with CheckDuplicate (step 2) without blocking event for sequence ordering
            /-
                  L_STATUS_INPROGRESS NUMBER := 1;      -- LOCK SEQUENCING
                  L_STATUS_SUCCESS NUMBER:=2;           -- CLOSE
                  L_STATUS_RESUBMITABLE NUMBER := 3;    -- LOCK SEQUENCING
                  L_STATUS_NOTRESUBMITABLE NUMBER := 4; -- CLOSE
            -/
          1.1.2 IF there's an INPROGRESS request will be inserted a record with status RESUBMITABLE and returned to caller
                a SOA ATTIP error SOA-100009.
    2. CheckDuplicate
******************************************************************************/
PROCEDURE CheckSequencing(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2, IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);


/******************************************************************************
   NAME:       InsertEvent
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        17/06/2010  PL		           Created this procedure.
   1.1        01/07/2010  PL               Integrated IN_PROPERTIES

   NOTES:  Insert new event on aTTIP infrastructure. It will be used for correlation scope.
           Generally is used only for OUTBOUND events.

******************************************************************************/
PROCEDURE InsertEvent(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2,IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);


/******************************************************************************
   NAME:       GetErrorMapping
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        15/06/2010  PL		           Created this procedure.

   NOTES:  Retrieve Error mapping on catalogue
            IN_ERRORCODE  -- Error code to mapping
            IN_SRCSYSTEM  -- System has generated ErrorCode (aTTIP for internal SOA/OSB errors)
            IN_CONTEXT    -- Context to define correct mapping on external error code.



******************************************************************************/
PROCEDURE GetErrorMapping(IN_ERRORCODE IN VARCHAR2, IN_SRCSYSTEM IN VARCHAR2, IN_CONTEXT IN VARCHAR2
                          ,OUT_EXTERRORCODE OUT VARCHAR2,OUT_DESCRIPTION OUT VARCHAR2,OUT_RETRIABLE OUT VARCHAR2, OUT_ERRORTYPE OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);

/******************************************************************************
   NAME:       GetRequestIDCorrelated
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        16/06/2010  PL		           Created this procedure.

   NOTES:  Get RequestIDs correlated, starting on RequestID or ATTIP_RequestID. For response use procedure InsertResponse.


PROCEDURE GetRequestIDCorrelated(INOUT_INPUT_REQUESTID IN OUT VARCHAR2, INOUT_OUTPUT_REQUESTID IN OUT VARCHAR2
                          ,OUT_CORRELATIONID OUT VARCHAR2,OUT_STATUS OUT VARCHAR2,OUT_PXNAME OUT VARCHAR2, OUT_SERVICE OUT VARCHAR2, OUT_VERSION OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);
******************************************************************************/

/******************************************************************************
   NAME:       InsertResponse
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        21/06/2010  PL		           Created this procedure.
   1.1        30/06/2010  PL               Added OUT_REQ_SOURCE_SYSTEM,OUT_REQ_DEST_SYSTEM
   1.2        01/07/2010  PL               Integrated IN_RES_PROPERTIES,OUT_REQ_PROPERTIES

   NOTES:  Insert Response and Get RequestIDs correlated, starting on RequestID or ATTIP_RequestID. Used only for response tracing and correlation

******************************************************************************/
PROCEDURE InsertResponse(IN_RES_REQUESTID IN VARCHAR2
                          ,IN_RES_SOURCE_SYSTEM IN VARCHAR2, IN_RES_DEST_SYSTEM IN VARCHAR2, IN_RES_CORRELATION_ID IN VARCHAR2
                          ,IN_RES_BUSINESS_ID IN VARCHAR2,IN_RES_CONVERSATION_ID IN VARCHAR2, IN_RES_MESSAGE_ID IN VARCHAR2
                          ,IN_RES_DIRECTION IN VARCHAR2 -- INBOUND_RESPONSE, OUTBOUND_RESPONSE
                          ,IN_RES_PROPERTIES IN CLOB
                          ,OUT_RES_TS_CREATED OUT TIMESTAMP, OUT_RES_STATUS OUT NUMBER
                          ,OUT_REQ_SOURCE_SYSTEM OUT VARCHAR2, OUT_REQ_DEST_SYSTEM OUT VARCHAR2,OUT_REQ_REQUESTID OUT VARCHAR2
                          ,OUT_REQ_CORRELATIONID OUT VARCHAR2,OUT_REQ_CONVERSATIONID OUT VARCHAR2, OUT_REQ_STATUS OUT VARCHAR2,OUT_REQ_PXNAME OUT VARCHAR2
                          ,OUT_REQ_SERVICE OUT VARCHAR2, OUT_REQ_VERSION OUT VARCHAR2
                          ,OUT_REQ_PROPERTIES OUT CLOB
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);

/******************************************************************************
   NAME:       GetIdsEvent
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        04/12/2010  EL		           Created this procedure.

   NOTES:  Retrieve id event

******************************************************************************/
PROCEDURE GetIdsEvent(IN_BUSINESSID IN VARCHAR2, IN_CONVERSATIONID IN VARCHAR2, IN_SRCSYSTEM IN VARCHAR2, IN_DESTSYSTEM IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_EXT_FIELD IN VARCHAR2
                          ,OUT_BUSINESSID OUT VARCHAR2, OUT_CONVERSATIONID OUT VARCHAR2, OUT_MESSAGEID OUT VARCHAR2, OUT_REQUESTID OUT VARCHAR2
                          ,OUT_CORRELATIONID OUT VARCHAR2, OUT_SERVICE OUT VARCHAR2, OUT_DIRECTION OUT VARCHAR2, OUT_STATUS OUT VARCHAR2, OUT_ATTIPREQUESTID OUT VARCHAR2, OUT_EXT_FIELD OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2);
END ATTIP_Core;
/