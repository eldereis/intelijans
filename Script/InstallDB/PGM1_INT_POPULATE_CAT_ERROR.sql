/***********************************************************************************
 NAME:       PGM1_INT_POPULATE_CAT_ERROR.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR               CREATED SCRIPT
   2.0        05/11/2010  AR               ALIGNING FOR UAT ENV                                    
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_POPULATE_CAT_ERROR.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

prompt Populating table (ATTIP_CAT_ERROR)...
delete from ATTIP_CAT_ERRMAP;
delete from ATTIP_CAT_ERROR;

commit;

insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100009, systimestamp, null, 'SOA-100009', 'Sequence ordering issue', 'BUSINESS ERROR', 'OSB', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (1, systimestamp, null, 'SOA-000001', 'Generic Error ', 'SYSTEM ERROR', 'OSB', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (2, systimestamp,  null, 'SOA-000002', 'SOAP HTTP timeout', 'SYSTEM ERROR', 'OSB', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (3, systimestamp, null, 'SOA-000003', 'Database  timeout', 'SYSTEM ERROR', 'OSB/SOA', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (4, systimestamp, null, 'SOA-000004', 'Component Service down', 'SYSTEM ERROR', 'SOA', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (5, systimestamp, null, 'SOA-000005', 'Business Service down', 'SYSTEM ERROR', 'OSB', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (6, systimestamp, null, 'SOA-000006', 'JMS Response timeout ', 'SYSTEM ERROR', 'OSB/SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (7, systimestamp, null, 'SOA-000007', 'Service not found or inconsistent', 'SYSTEM ERROR', 'SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (8, systimestamp, null, 'SOA-000008', 'Database  error ', 'SYSTEM ERROR', 'OSB/SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100001, systimestamp, null, 'SOA-100001', 'Validation exception on CDM Message - ', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100002, systimestamp, null, 'SOA-100002', 'Business data validation exception ', 'BUSINESS ERROR', 'SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100003, systimestamp, null, 'SOA-100003', 'Entity  doesnt exist', 'BUSINESS ERROR', 'SOA', 'Y', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100004, systimestamp, null, 'SOA-100004', 'Event is not recognized', 'BUSINESS ERROR', 'SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100006, systimestamp, null, 'SOA-100006', 'Validation exception on Custom Message - ', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100007, systimestamp, null, 'SOA-100007', 'Business consistency error ', 'BUSINESS ERROR', 'OSB/SOA', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100008, systimestamp, null, 'SOA-100008', 'Duplicate event', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100011, systimestamp, null, 'SOA-100011', 'Customer not found', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100012, systimestamp, null, 'SOA-100012', 'Subscriber not found', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (100013, systimestamp, null, 'SOA-100013', 'Service Request not found', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (124011, systimestamp, null, 'SOA-124011', 'Message is longer than maximum length', 'BUSINESS ERROR', 'OSB', 'N', 'Y');
insert into ATTIP_CAT_ERROR (ID, TS_CREATED, TS_UPDATED, ERRCODE, ERRDESC, TYPE, NOTES, RETRIABLE, IS_ENABLE)
values (124012, systimestamp, null, 'SOA-124012', 'MSISDN format is not acceptable', 'BUSINESS ERROR', 'OSB', 'N', 'Y');

commit;
REM INSERTING into ATTIP_CAT_ERROR
commit;
prompt ... Completed