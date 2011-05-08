/***********************************************************************************
 NAME:       PGM1_INT_CREATE_USER.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR               CREATED SCRIPT
                                       
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_USER.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating user...
CREATE USER &nameUser
IDENTIFIED BY &pwdUser;
prompt ... Created

prompt Select DEFAULT TABLESPACE
ALTER USER &&nameUser 
DEFAULT TABLESPACE &dafaultTablespace;
prompt ... Selected

prompt Set GRANT... 
GRANT CONNECT TO &&nameUser;
GRANT RESOURCE TO &&nameUser;
prompt ... Setted