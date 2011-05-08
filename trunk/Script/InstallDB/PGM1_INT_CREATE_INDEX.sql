/***********************************************************************************
 NAME:       PGM1_INT_CREATE_INDEX.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR               CREATED SCRIPT
   1.1        22/10/2010  EL               ADDED ATTIP_IDEMPOT_SEQUENCING_IDX
   1.2        25/01/2011  AR               ADDED ATTIP_IDEMPOT_CONVERSATION_IDX
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_INDEX.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating index (ATTIP_IDEMPOT_SRCSYS_REQID_IDX)...
CREATE INDEX ATTIP_IDEMPOT_SRCSYS_REQID_IDX ON ATTIP_IDEMPOTENCE (SRC_SYSTEM,REQUEST_ID);
prompt ... Created

prompt Creating index (ATTIP_CATERRMAP_ERRMAPID_IDX)...
CREATE INDEX ATTIP_CATERRMAP_ERRMAPID_IDX on ATTIP_CAT_ERRMAP (ID_CATERROR);
prompt ... Created

prompt Creating index (ATTIP_IDEMPOT_REQID_IDX)...
CREATE INDEX ATTIP_IDEMPOT_REQID_IDX on ATTIP_IDEMPOTENCE (REQUEST_ID);
prompt ... Created

prompt Creating index (ATTIP_IDEMPOT_SEQUENCING_IDX)...
CREATE INDEX ATTIP_IDEMPOT_SEQUENCING_IDX on ATTIP_IDEMPOTENCE (BUSINESS_ID,SERVICE);
prompt ... Created

prompt Creating index (ATTIP_IDEMPOT_CONVERSATION_IDX)...
CREATE INDEX ATTIP_IDEMPOT_CONVERSATION_IDX on ATTIP_IDEMPOTENCE (CONVERSATION_ID);
prompt ... Created