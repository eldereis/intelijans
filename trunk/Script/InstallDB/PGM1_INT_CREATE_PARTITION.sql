/***********************************************************************************
 NAME:       PGM1_INT_CREATE_PARTITION.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        30/08/2010  AR               CREATED SCRIPT
                                       
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_PARTITION.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating partition...
ALTER TABLE &nameTable ADD PARTITION &namePartition VALUES LESS THAN (&values) TABLESPACE &tablespaceName;
prompt ... Created