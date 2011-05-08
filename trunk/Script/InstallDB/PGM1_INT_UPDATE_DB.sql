/***********************************************************************************
 NAME:       PGM1_INT_UPDATE_DB.SQL
  

   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        24/12/2010  AR     					 CREATED SCRIPT

   NOTES:  

   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_UPDATE_DB.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:

*********************************************************************************/

SPOOL &Logfile
SET linesize 200
set echo off
set feedback off

prompt Create Index ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_UPDATE_INDEX.sql
prompt ... Completed

prompt Update PKG ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_PKG.sql
prompt ... Completed

prompt Updated PKG BODIES ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_PKG_BODIES.sql
prompt ... Completed


