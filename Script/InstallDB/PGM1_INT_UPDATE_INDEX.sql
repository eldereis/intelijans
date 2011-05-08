/***********************************************************************************
 NAME:       PGM1_INT_UPDATE_INDEX.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        25/01/2011  AR               ADDED ATTIP_IDEMPOT_CONVERSATION_IDX
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_UPDATE_INDEX.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating index (ATTIP_IDEMPOT_CONVERSATION_IDX)...
CREATE INDEX ATTIP_IDEMPOT_CONVERSATION_IDX on ATTIP_IDEMPOTENCE (CONVERSATION_ID);
prompt ... Created