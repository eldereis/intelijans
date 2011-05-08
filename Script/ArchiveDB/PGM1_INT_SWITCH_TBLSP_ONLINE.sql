SET verify off
SET head off
SET feed off
SET PAGESIZE 100
SET serveroutput ON
WHENEVER SQLERROR EXIT SQL.SQLCODE

DECLARE

  TABLESPACENAME VARCHAR2(200);
  ALTER_APP VARCHAR2(200);
  l_errmsg varchar2(4000);
  l_PartitionOK    NUMBER := 0;
  
BEGIN

  TABLESPACENAME := '&Tablespace';
  
  DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE ONLINE - SWITCH ONLINE TABLESPACE: '||TABLESPACENAME);
  
  BEGIN 
  
    -- STEP1- CHECK tablespace (exists or not)
    select count(*) into l_PartitionOK
    from user_tablespaces
    where tablespace_name = (TABLESPACENAME) and status = 'OFFLINE';
  
    -- STEP2 - CHECK SWITCH MODE (NORMAL,TEMPORARY,IMMEDIATE)
    IF(l_PartitionOK > 0) THEN
        BEGIN
        
            --STEP3 - RUN DDL
            ALTER_APP := 'ALTER TABLESPACE '||TABLESPACENAME||' ONLINE';
            EXECUTE IMMEDIATE (ALTER_APP);
            DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE ONLINE - SUCCESSFULL');
            
            -- Error Management
            EXCEPTION WHEN OTHERS THEN
                l_errmsg := SUBSTR (SQLERRM, 1, 200);
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE ONLINE - ERROR: ('||l_errmsg ||')');
                RETURN;
            END;
        ELSE
            DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE OFFLINE - ERROR: TABLESPACE not found');
    END IF;
  END;
  RETURN;
END;
/