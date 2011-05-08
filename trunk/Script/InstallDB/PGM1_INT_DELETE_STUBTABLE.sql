/***********************************************************************************
 NAME:       PGM1_INT_DELETE_STUBTABLE.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        02/09/2010  AR               CREATED SCRIPT
                                        
                                        
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_DELETE_STUBTABLE.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

DELETE FROM STUBTABLE;
commit;
prompt ... STUBTABLE - deleted all records