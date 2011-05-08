SET verify off
SET head off
SET feed off
SET PAGESIZE 100
SET serveroutput ON
WHENEVER SQLERROR EXIT SQL.SQLCODE

DECLARE

  TABLESPACENAME VARCHAR2(200);
  SWITCH_MODE VARCHAR2(200);
  ALTER_APP VARCHAR2(200);
  l_errmsg varchar2(4000);
  l_PartitionOK    NUMBER := 0;
  
BEGIN
  
  TABLESPACENAME := '&Tablespace';
  SWITCH_MODE := UPPER('&Switch_Mode');
  
  DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE OFFLINE - SWITCH OFFLINE TABLESPACE: '||TABLESPACENAME||' ON MODE: '||SWITCH_MODE);
  
  BEGIN 
  
    BEGIN
        
        -- STEP1- CHECK tablespace (exists or not)
        select count(*) into l_PartitionOK
        from user_tablespaces
        where tablespace_name = (TABLESPACENAME) and status = 'ONLINE';
        
        -- STEP2 - CHECK SWITCH MODE (NORMAL,TEMPORARY,IMMEDIATE)
        IF(l_PartitionOK > 0 and (SWITCH_MODE = 'NORMAL' OR SWITCH_MODE = 'TEMPORARY' OR SWITCH_MODE = 'IMMEDIATE')) THEN
            BEGIN
                
                --STEP3 - RUN DDL
                ALTER_APP := 'ALTER TABLESPACE '||TABLESPACENAME||' OFFLINE '||SWITCH_MODE;
                EXECUTE IMMEDIATE (ALTER_APP);
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE OFFLINE - SUCCESSFULL');
                
                -- Error Management
                EXCEPTION WHEN OTHERS THEN
                    l_errmsg := SUBSTR (SQLERRM, 1, 200);
                    DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE OFFLINE - ERROR: ('||l_errmsg ||')');
                    RETURN;
            END;
            ELSE 
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||'] TABLESPACE OFFLINE - ERROR: TABLESPACE or MODE not found');
        END IF;
    END;
  END;
  RETURN;
END;
/