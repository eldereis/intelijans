/***********************************************************************************
 NAME:       PGM1_INT_CREATE_TABLESPACE.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR               CREATED SCRIPT
                                       
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_TABLESPACE.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating tablespace...
CREATE TABLESPACE &nameTablespace
  DATAFILE '&dataFileName'
  SIZE 50M
  AUTOEXTEND ON 
  MAXSIZE UNLIMITED;
prompt ... Created