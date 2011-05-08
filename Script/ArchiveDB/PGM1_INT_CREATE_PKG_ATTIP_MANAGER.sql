CREATE OR REPLACE PACKAGE attip_manager authid current_user
IS

 /******************************************************************************
   NAME:       MoveEvents
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/12/2010  Luongo           Created this definition.
   2.0        06/12/2010  Rocco            Updated this definition.
   
   NOTES:


   INPUT
      PartitionName    :

      PartitionDateNew :

      rown             :

******************************************************************************/
   PROCEDURE MoveEvents (IN_PartitionName IN VARCHAR2,IN_PartitionDateNew In VARCHAR2, IN_Rown NUMBER default 0, IN_Commit IN char default 'Y');

END;
/



CREATE OR REPLACE PACKAGE BODY ATTIP_MANAGER
IS

 /******************************************************************************
   NAME:       MoveEvents
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/12/2010  Luongo           Created this procedure.
   2.0        06/12/2010  Rocco            Updated this procedure.

   NOTES:

   INPUT
      PartitionName    : partition name to archive

      PartitionDateNew : new partition date 'YYMMDD'. Example: '101206'

      rown             : events number to archive (optional)

******************************************************************************/
PROCEDURE MoveEvents(IN_PartitionName IN VARCHAR2,IN_PartitionDateNew In VARCHAR2, IN_Rown NUMBER, IN_Commit IN char)
IS

 TYPE l_cursor_type  IS REF CURSOR;
 l_numeventiStart NUMBER := 0;
 l_errmsg         VARCHAR2 (200);
 l_curstep        VARCHAR2(200):= '';
 l_MAX_Lotto      NUMBER := 100;

 l_query_count	VARCHAR2(4000):='SELECT count(1) FROM TMP_MOV_TABAPP TMP';
 l_query_event  VARCHAR2(4000):='SELECT business_id,id FROM TMP_MOV_TABAPP';

 l_query_tab VARCHAR2(4000):= 'CREATE TABLE TMP_MOV_TABAPP NOLOGGING AS
                SELECT * FROM (
                  SELECT id,business_id FROM ATTIP_IDEMPOTENCE PARTITION ('|| IN_PartitionName ||') WHERE status IN (1,3)
                ) T
                WHERE 1=1';

 -- Cursors definition
 l_crs_evento      l_cursor_type;
 l_crs_conteggio   l_cursor_type;

 -- Variables definition
 l_IdEvent 		ATTIP_IDEMPOTENCE.ID%type;
 l_BID          ATTIP_IDEMPOTENCE.Business_id%type;

 -- Variable check partition
 l_PartitionOK    NUMBER := 0;
 
 -- Variable commit
 l_contatore      NUMBER := 0;
 l_tot_count      NUMBER := 0;

 TABLE_OR_VIEW_DOES_NOT_EXIST exception;
 pragma exception_init( TABLE_OR_VIEW_DOES_NOT_EXIST, -942 );

BEGIN
      l_curstep:= 'START';
      DBMS_OUTPUT.enable(2000000);
      DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - started');

        -- STEP1 - DROP temporary table
        BEGIN
              l_curstep:= 'DROP TABLE TMP_MOV_TABAPP';
              DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - drop temporary table');
              EXECUTE IMMEDIATE ('DROP TABLE TMP_MOV_TABAPP');
              DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - temporary table dropped');
        EXCEPTION
            WHEN TABLE_OR_VIEW_DOES_NOT_EXIST THEN
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS  - ERROR: TMP_MOV_TABAPP not found');
        END;

        -- STEP2 - CHECK partition (exists or not)
      l_curstep:= 'VERIFY_PARTITIONS';
      DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - existing control partition '||UPPER(IN_PartitionName));
      select count(*) into l_PartitionOK
      from USER_TAB_PARTITIONS
      where PARTITION_NAME = UPPER(IN_PartitionName);
      DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - found: ' ||l_PartitionOK|| ' partition with the same name');

      IF(l_PartitionOK > 0) THEN
        BEGIN
          BEGIN
                -- STEP3 - CREATE TEMPORARY TABLE
                l_curstep:= 'CREATE TAB TMP_MOV_TABAPP';
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - create temporary table');

                IF ((IN_Rown is not null) AND IN_Rown > 0) THEN
                     l_query_tab := l_query_tab || ' AND ROWNUM <= ' || IN_Rown;
                END IF;
                EXECUTE IMMEDIATE(l_query_tab);
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - temporary table created');
                
                -- Error Management
                EXCEPTION WHEN OTHERS THEN
                    l_errmsg := SUBSTR (SQLERRM, 1, 200);
                    DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - ERROR: create TMP_MOV_TABAPP ('||l_errmsg ||')');
                    RETURN;
          END;

          l_curstep:= 'QUERY_SELECTION';
          DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - query:' || l_query_event );

            -- STEP4 - CHECK how many values
          l_curstep:= 'QUERY_COUNTING';
	        OPEN l_crs_conteggio FOR l_query_count;
          LOOP
                FETCH l_crs_conteggio
                INTO l_numeventiStart;
                EXIT WHEN l_crs_conteggio%NOTFOUND;
          END LOOP;
          CLOSE l_crs_conteggio;
          DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - events number:' ||l_numeventiStart );

          l_tot_count := 0;
          l_contatore := 0;
          IF l_numeventiStart > 0 THEN
                    --STEP5 - UPDATE events with new Partition Date
                l_curstep:= 'QUERY_CRS_EVENTO';
                OPEN l_crs_evento FOR l_query_event;
                LOOP
                    l_curstep:= 'UPDATING...STARTLOOP';
                    FETCH l_crs_evento
                    INTO l_BID,l_IdEvent;
                    EXIT WHEN l_crs_evento%NOTFOUND;

                    l_curstep:= 'UPDATING...ATTIP_IDEMPOTENCE (' || l_IDEvent || ')';
                    UPDATE ATTIP_IDEMPOTENCE
                      SET PARTITION_DATE = IN_PartitionDateNew
                      WHERE ID = l_IDEvent;

                    l_curstep:= 'UPDATING...completed! (' || l_IDEvent || ')';
                        --STEP6 - LOOP for commit events
                    IF (l_contatore > l_MAX_Lotto )
                    THEN
                        l_curstep:= 'STEP_COMMIT';
                        l_contatore := 0;
                        IF (IN_Commit = 'Y') THEN COMMIT; ELSE ROLLBACK; END IF;
                        DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - committed loop (tot: ' || l_tot_count || ')' );
                    ELSE
                        l_contatore := l_contatore + 1;
                        l_tot_count := l_tot_count + 1;
                    END IF;
                END LOOP;
                CLOSE l_crs_evento;

                l_curstep:= 'COMMIT_POSTLOOP';
                IF (IN_Commit = 'Y') THEN COMMIT; ELSE ROLLBACK; END IF;

                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - committed (tot: ' || l_tot_count || ')' );

            ELSE
                DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - nothing to move, events: '||l_numeventiStart);
            END IF;

          END;
          ELSE
             DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - partition name ' || IN_PartitionName ||' not identified');
             RETURN;
          END IF;

          DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - done SUCCESS');
        
        -- Error Management
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        l_errmsg := SUBSTR (SQLERRM, 1, 200);
        DBMS_OUTPUT.PUT_LINE('['|| TO_CHAR (SYSDATE, 'dd/mm/yyyy HH24:MI:SS') ||',' ||l_curstep ||'] MOVING-FLOWS - ERROR: ('||l_errmsg ||')');
        RETURN;

END;

END;
/