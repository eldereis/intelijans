/***********************************************************************************
 NAME:       PGM1_INT_INSTALL_DB.SQL
  

   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR     					 CREATED SCRIPT

   NOTES:  

   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_INSTALL_DB.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:

*********************************************************************************/

SPOOL &Logfile
SET linesize 200
set echo off
set feedback off

prompt Crating Tables ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_TABLES.sql
prompt ... Created

prompt Crating Index ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_INDEX.sql
prompt ... Created

prompt Crating Sequences ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_SEQUENCES.sql
prompt ... Created

prompt Crating PKG ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_PKG.sql
prompt ... Created

prompt Crating PKG BODIES ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_CREATE_PKG_BODIES.sql
prompt ... Created

prompt Populating Table CAT_ERROR ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_POPULATE_CAT_ERROR.sql
prompt ... Completed

prompt Populating Table CAT_ERRMAP ...
@C:\SRC\Utilities\Script\InstallDB\PGM1_INT_POPULATE_CAT_ERRMAP.sql
prompt ... Completed
