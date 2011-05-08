create or replace
PACKAGE BODY attip_core IS
/******************************************************************************
PACKAGE NAME: ATTIP_Core

    Package body with core functionality on aTTIP infrastructure

   REVISIONS:

   Ver        Date        Author           Description

   ---------  ----------  ---------------  ------------------------------------

   1.0        03/06/2010  PL		   Created this package
   1.1        01/07/2010  PL       Introduced tracing for msgSpecificProperties

******************************************************************************/

/******************************************************************************
   NAME:       UpdateStateOnResponse
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/06/2010  PL		   Created this procedure.

   NOTES:  Update event state
           Used on component service side
           Return OUT_RET_CODE = 0  if not duplicate
                                 -1 if catched any error

   Automatically available Auto Replace Keywords:
      Object Name:     UpdateStateOnResponse
      Sysdate:         03/06/2010
      Date and Time:   03/06/2010 , 9.28.40
      Username:        OSB

******************************************************************************/
PROCEDURE UpdateStatusOnResponse(IN_ATTIP_REQUEST_ID IN VARCHAR2, IN_STATUS IN NUMBER
                                ,OUT_TS_CREATED OUT TIMESTAMP,OUT_TS_UPDATED OUT TIMESTAMP,OUT_SOURCE_SYSTEM OUT VARCHAR2
                                ,OUT_CORRELATION_ID OUT VARCHAR2,OUT_REQUEST_ID OUT VARCHAR2,OUT_SERVICE OUT VARCHAR2
                                ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2)  AS
  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_cur_step VARCHAR2(20);
  l_id NUMBER;
  l_count NUMBER;

BEGIN
    --OUT_TS_CREATED := NULL;
    --OUT_TS_UPDATED := NULL;
    OUT_SOURCE_SYSTEM := NULL;
    OUT_CORRELATION_ID := NULL;
    OUT_REQUEST_ID := NULL;
    OUT_SERVICE := NULL;
    OUT_RET_CODE := '0';
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(UpdateStateOnResponse) Started!';
    SAVEPOINT RESTORETRANS;

    /*CHECK VALIDATION INPUT PARAMETERS */
    IF ((IN_ATTIP_REQUEST_ID IS NULL OR IN_ATTIP_REQUEST_ID = '') OR (IN_STATUS IS NULL OR IN_STATUS < L_STATUS_INPROGRESS OR IN_STATUS > L_STATUS_NOTRESUBMITABLE))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-100002';
      OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(UpdateStateOnResponse) VALIDATION ERROR OF INPUT PARAMETERS (STATUS-' || TO_CHAR(IN_STATUS) || ',REQUEST_ID-' || IN_ATTIP_REQUEST_ID || ')!';
      RETURN;
    END IF;

        l_cur_step := 'UPD_STATE';

        UPDATE ATTIP_IDEMPOTENCE
        SET STATUS = IN_STATUS
            ,TS_UPDATED=SYSTIMESTAMP
        WHERE ATTIP_REQUEST_ID = IN_ATTIP_REQUEST_ID --ID = l_id
              AND STATUS NOT IN (L_STATUS_SUCCESS, L_STATUS_NOTRESUBMITABLE) -- Block any tentative to update final states.
        RETURNING ID,TS_CREATED,TS_UPDATED,SRC_SYSTEM,CORRELATION_ID,REQUEST_ID,SERVICE
                  INTO l_id,OUT_TS_CREATED,OUT_TS_UPDATED,OUT_SOURCE_SYSTEM,OUT_CORRELATION_ID,OUT_REQUEST_ID,OUT_SERVICE
        ;

        l_count:= SQL%ROWCOUNT;

        IF l_count <> 1 THEN
            ROLLBACK TO RESTORETRANS;
            OUT_RET_CODE   := -1;
            OUT_ERROR_CODE := 'SOA-000007';
            OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', ATTIP_REQUEST_ID: '|| IN_ATTIP_REQUEST_ID ||',' || l_count || ') Event don''t found!';
            RETURN;
        END IF;

      OUT_RET_CODE   := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(UpdateStateOnResponse) Event identified ('|| IN_ATTIP_REQUEST_ID ||')!';


    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000007';
      OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', ATTIP_REQUEST_ID: '|| IN_ATTIP_REQUEST_ID ||') Event don''t found!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000007';
      OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', ATTIP_REQUEST_ID: '|| IN_ATTIP_REQUEST_ID ||') Too many events found!';
      RETURN;
    WHEN OTHERS THEN
      OUT_RET_CODE:= -1;
      OUT_ERROR_CODE := 'SOA-000001';
      OUT_ERROR_DESC := 'SOA-000001: Generic Error - (UpdateStateOnResponse)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_ATTIP_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END UpdateStatusOnResponse;

/******************************************************************************
   NAME:       UpdateStateOnRequest
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        13/09/2010  PL		   Created this procedure.

   NOTES:  Update event state
           Used on adapter service side
           Return OUT_RET_CODE = 0  if not duplicate
                                 -1 if catched any error

   Automatically available Auto Replace Keywords:
      Object Name:     UpdateStateOnResponse
      Sysdate:         13/09/2010
      Date and Time:   13/09/2010 , 20.46.40
      Username:        OSB

******************************************************************************/
PROCEDURE UpdateStatusOnRequest(IN_REQUEST_ID IN VARCHAR2, IN_STATUS IN NUMBER
                                ,OUT_TS_CREATED OUT TIMESTAMP,OUT_TS_UPDATED OUT TIMESTAMP,OUT_SOURCE_SYSTEM OUT VARCHAR2
                                ,OUT_CORRELATION_ID OUT VARCHAR2,OUT_REQUEST_ID OUT VARCHAR2,OUT_SERVICE OUT VARCHAR2
                                ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2)  AS
  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_cur_step VARCHAR2(20);
  l_id NUMBER;
  l_count NUMBER;

BEGIN
    --OUT_TS_CREATED := NULL;
    --OUT_TS_UPDATED := NULL;
    OUT_SOURCE_SYSTEM := NULL;
    OUT_CORRELATION_ID := NULL;
    OUT_REQUEST_ID := NULL;
    OUT_SERVICE := NULL;
    OUT_RET_CODE := '0';
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(UpdateStateOnResponse) Started!';
    SAVEPOINT RESTORETRANS;

    /*CHECK VALIDATION INPUT PARAMETERS */
    IF ((IN_REQUEST_ID IS NULL OR IN_REQUEST_ID = '') OR (IN_STATUS IS NULL OR IN_STATUS < L_STATUS_INPROGRESS OR IN_STATUS > L_STATUS_NOTRESUBMITABLE))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-100002';
      OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(UpdateStateOnResponse) VALIDATION ERROR OF INPUT PARAMETERS (STATUS-' || TO_CHAR(IN_STATUS) || ',REQUEST_ID-' || IN_REQUEST_ID || ')!';
      RETURN;
    END IF;

        l_cur_step := 'UPD_STATE';

        UPDATE ATTIP_IDEMPOTENCE
        SET STATUS = IN_STATUS
            ,TS_UPDATED=SYSTIMESTAMP
        WHERE REQUEST_ID = REQUEST_ID --ID = l_id
              AND STATUS NOT IN (L_STATUS_SUCCESS, L_STATUS_NOTRESUBMITABLE) -- Block any tentative to update final states.
        RETURNING ID,TS_CREATED,TS_UPDATED,SRC_SYSTEM,CORRELATION_ID,REQUEST_ID,SERVICE
                  INTO l_id,OUT_TS_CREATED,OUT_TS_UPDATED,OUT_SOURCE_SYSTEM,OUT_CORRELATION_ID,OUT_REQUEST_ID,OUT_SERVICE
        ;

        l_count:= SQL%ROWCOUNT;

        IF l_count <> 1 THEN
            ROLLBACK TO RESTORETRANS;
            OUT_RET_CODE   := -1;
            OUT_ERROR_CODE := 'SOA-000007';
            OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', REQUEST_ID: '|| IN_REQUEST_ID ||',' || l_count || ') Event don''t found!';
            RETURN;
        END IF;

      OUT_RET_CODE   := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(UpdateStateOnResponse) Event identified ('|| IN_REQUEST_ID ||')!';


    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000007';
      OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', REQUEST_ID: '|| IN_REQUEST_ID ||') Event don''t found!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000007';
      OUT_ERROR_DESC := 'SOA-000007: Service not found or inconsistent - (UpdateStateOnResponse)(' || l_cur_step || ', REQUEST_ID: '|| IN_REQUEST_ID ||') Too many events found!';
      RETURN;
    WHEN OTHERS THEN
      OUT_RET_CODE:= -1;
      OUT_ERROR_CODE := 'SOA-000001';
      OUT_ERROR_DESC := 'SOA-000001: Generic Error - (UpdateStateOnResponse)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END UpdateStatusOnRequest;


/******************************************************************************
   NAME:       CheckDuplicate
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        03/06/2010  PL		           Created this procedure.
   1.1        15/06/2010  PL               Integrated PXNAME and DIRECTION
   1.2        16/06/2010  PL               Check on DIRECTION INBOUND for duplicate events
   1.3        01/07/2010  PL               Integrated IN_PROPERTIES to trace Header's msgSpecificProperty

   NOTES:  Check duplicate resubmition on aTTIP infrastructure
           Return OUT_RET_CODE = 0 if not duplicate
                                 1 if duplicate
                                 -1 if catched any error
          Values for IN_DIRECTION:
            - INBOUND and OUTBOUND

******************************************************************************/
PROCEDURE CheckDuplicate(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2, IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_id NUMBER;
  l_STATUS NUMBER;
  l_retries NUMBER;
  l_attip_requestid VARCHAR2(255);
  l_conversationid VARCHAR2(255);
  l_tscreated timestamp;
  l_cur_step VARCHAR2(20);
  l_id_idempotence NUMBER;
  l_count NUMBER;

BEGIN
  OUT_RETRIES:=0;
  OUT_RET_CODE := 0;
  OUT_ERROR_CODE:= NULL;
  OUT_ERROR_DESC:= NULL;

  l_id := 0;
  l_STATUS := 0;
  l_id_idempotence := 0;

  SAVEPOINT RESTORETRANS;

  /*CHECK VALIDATION INPUT PARAMETERS */
   IF ((IN_SOURCE_SYSTEM IS NULL OR IN_SOURCE_SYSTEM = '') OR (IN_BUSINESS_ID IS NULL OR IN_BUSINESS_ID = '') OR (IN_CONVERSATION_ID IS NULL OR IN_CONVERSATION_ID = '')
      OR (IN_REQUEST_ID IS NULL OR IN_REQUEST_ID = '') OR (IN_MESSAGE_ID IS NULL OR IN_MESSAGE_ID = '') OR (IN_SERVICE IS NULL OR IN_SERVICE = '') OR (IN_DIRECTION NOT IN ('INBOUND_REQUEST') OR IN_DIRECTION IS NULL))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-100002';
      OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(CheckDuplicate) VALIDATION ERROR OF INPUT PARAMETERS (SOURCE_SYSTEM-' || TO_CHAR(IN_SOURCE_SYSTEM) || ',REQUEST_ID-' || IN_REQUEST_ID || ')!';
      RETURN;
   END IF;

   /*CHECK DUPLICATE*/
   l_cur_step := 'DUPL_SRC_REQ';
   SELECT ID,STATUS,RETRIES,ATTIP_REQUEST_ID,TS_CREATED
   INTO l_id,l_STATUS,l_retries,l_attip_requestid,l_tscreated
   FROM ATTIP_IDEMPOTENCE
   WHERE SRC_SYSTEM = IN_SOURCE_SYSTEM
         --AND BUSINESS_ID = IN_BUSINESS_ID
         AND REQUEST_ID = IN_REQUEST_ID
         AND DIRECTION ='INBOUND_REQUEST';

   l_count := SQL%ROWCOUNT;

   IF (l_count >= 1 AND l_STATUS != L_STATUS_RESUBMITABLE ) THEN -- STATUS = 3 [FAULT RESUBMITABLE]
      --OUT_DUPLICATE:= 'YES';
      OUT_RET_CODE:= 1;
      OUT_ERROR_CODE:= 'SOA-100008';
      OUT_ERROR_DESC := 'SOA-100008: Duplicate event - (CheckDuplicate)(' || l_cur_step || ')(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
      OUT_ATTIPREQUESTID := l_attip_requestid;
      OUT_TS_CREATED:= l_tscreated;
      OUT_STATUS:= l_STATUS;
      OUT_RETRIES:= l_retries;
      RETURN;
   END IF;

   IF (l_count >= 1) AND (l_STATUS=L_STATUS_RESUBMITABLE) THEN
      l_cur_step := 'UPD_IDEMPOTENCE';
      UPDATE ATTIP_IDEMPOTENCE
          SET
              TS_UPDATED=SYSTIMESTAMP,
              CORRELATION_ID = NVL(IN_CORRELATION_ID,CORRELATION_ID),
              BUSINESS_ID = NVL(IN_BUSINESS_ID,BUSINESS_ID),
              CONVERSATION_ID = NVL(IN_CONVERSATION_ID,CONVERSATION_ID),
              MESSAGE_ID = NVL(IN_MESSAGE_ID,MESSAGE_ID),
              SERVICE =  NVL(IN_SERVICE,SERVICE),
              PXNAME = IN_PXNAME,
              DIRECTION = IN_DIRECTION,
              VERSION = IN_VERSION,
              PROPERTIES = IN_PROPERTIES,
              ATTIP_REQUEST_ID = sys_guid(),
              STATUS = L_STATUS_INPROGRESS, -- IN_PROGRESS
              RETRIES = RETRIES+1
          WHERE
              ID = l_id and STATUS=L_STATUS_RESUBMITABLE and DIRECTION ='INBOUND_REQUEST'
          RETURNING ATTIP_REQUEST_ID,STATUS,RETRIES,TS_CREATED INTO l_attip_requestid,l_STATUS,l_retries,l_tscreated;

      --OUT_DUPLICATE := 'NO';
      OUT_RET_CODE := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(' || l_cur_step || IN_CONVERSATION_ID || l_count ||')';
      OUT_ATTIPREQUESTID := l_attip_requestid;
      OUT_TS_CREATED:= l_tscreated;
      OUT_STATUS:= l_STATUS;
      OUT_RETRIES:= l_retries;
      RETURN;
   END IF;

   EXCEPTION
      WHEN NO_DATA_FOUND THEN -- RECORD NOT FOUND
          BEGIN
              SAVEPOINT RESTORETRANS;

               /*CHECK CONVERSATION ID*/
               l_cur_step := 'DUPL_SRC_CONV';
               SELECT /*+ index(ATTIP_IDEMPOTENCE ) */
                  COUNT(1)
               INTO l_count
               FROM ATTIP_IDEMPOTENCE
               WHERE SRC_SYSTEM = IN_SOURCE_SYSTEM
                AND CONVERSATION_ID = IN_CONVERSATION_ID
                AND DIRECTION ='INBOUND_REQUEST';

               --l_count := SQL%ROWCOUNT;
               IF (l_count >= 1 AND (l_STATUS = L_STATUS_INPROGRESS OR l_STATUS = L_STATUS_NOTRESUBMITABLE)) THEN -- STATUS = 3 [FAULT RESUBMITABLE]
                  --OUT_DUPLICATE:= 'YES';
                  OUT_RET_CODE:= 1;
                  OUT_ERROR_CODE:= 'SOA-100008';
                  OUT_ERROR_DESC := 'SOA-100008: Duplicate event, an event with the same conversation_id is already running or not resubmittable - (CheckDuplicate)(' || l_cur_step || ')(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',CONVERSATIONID-' || IN_CONVERSATION_ID || ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
                  OUT_ATTIPREQUESTID := l_attip_requestid;
                  OUT_TS_CREATED:= l_tscreated;
                  OUT_STATUS:= l_STATUS;
                  OUT_RETRIES:= l_retries;
                  RETURN;
               END IF;

              /* GENERATE ID_IDEMPOTENCE_SEQ */
              l_cur_step := 'ID_IDEMPOTENCE_SEQ';
              SELECT ATTIP_IDEMPOTENCE_ID_SEQ.NEXTVAL
              INTO l_id_idempotence FROM dual;
              IF l_id_idempotence = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000008';
                  OUT_ERROR_DESC := 'SOA-000008: Database  error - (CheckDuplicate) Error on ID sequence.';
                  ROLLBACK TO RESTORETRANS;
                  RETURN;
              END IF;

              /* INSERT ROW */
              l_cur_step :='INSERT_ROW';
              INSERT INTO ATTIP_IDEMPOTENCE
                  (ID, TS_CREATED, TS_UPDATED, PARTITION_DATE, SRC_SYSTEM, DEST_SYSTEM, CORRELATION_ID, BUSINESS_ID, CONVERSATION_ID, REQUEST_ID
                   , MESSAGE_ID, SERVICE, ATTIP_REQUEST_ID, STATUS, RETRIES
                   , PXNAME, DIRECTION, VERSION, PROPERTIES)
                  VALUES (l_id_idempotence, SYSTIMESTAMP, SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP,'yymmdd'), IN_SOURCE_SYSTEM, IN_DEST_SYSTEM, IN_CORRELATION_ID, IN_BUSINESS_ID, IN_CONVERSATION_ID,IN_REQUEST_ID
                          , IN_MESSAGE_ID, IN_SERVICE, sys_guid(), L_STATUS_INPROGRESS, 0
                          , IN_PXNAME, IN_DIRECTION, IN_VERSION, IN_PROPERTIES)
                RETURNING ATTIP_REQUEST_ID,STATUS,RETRIES,TS_CREATED INTO l_attip_requestid,l_STATUS,l_retries,l_tscreated;

              IF SQL%ROWCOUNT = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000008';
                  OUT_ERROR_DESC := 'SOA-000008: Database  error - (CheckDuplicate) Not possible to trace new event (REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
                  --ROLLBACK TO RESTORETRANS;
                  RETURN;
              END IF;

              --OUT_DUPLICATE := 'NO';
              OUT_RET_CODE := 0;
              OUT_ERROR_CODE := NULL;
              OUT_ERROR_DESC := '(' || l_cur_step || ')';
              OUT_ATTIPREQUESTID := l_attip_requestid;
              OUT_TS_CREATED:= l_tscreated;
              OUT_STATUS:= l_STATUS;
              OUT_RETRIES:= l_retries;
              RETURN;
              EXCEPTION
                WHEN OTHERS THEN
                    OUT_RET_CODE:= -1;
                    OUT_ERROR_CODE := 'SOA-000001';
                    OUT_ERROR_DESC := 'SOA-000001: Generic Error - (CheckDuplicate)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
                    RETURN;
          END;
      WHEN TOO_MANY_ROWS THEN
           --OUT_DUPLICATE:= 'YES';
           OUT_RET_CODE:= 1;
           OUT_ERROR_CODE:= 'SOA-100008';
           OUT_ERROR_DESC := 'SOA-100008: Duplicate event - (CheckDuplicate)(' || l_cur_step || ')(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
           RETURN;
      WHEN OTHERS THEN
            OUT_RET_CODE:= -1;
            OUT_ERROR_CODE := 'SOA-000001';
            OUT_ERROR_DESC := 'SOA-000001: Generic Error - (CheckDuplicate)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
            RETURN;
 END CheckDuplicate;



/******************************************************************************
   NAME:       CheckSequencing
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        18/10/2010  PL		           Created this procedure.

   NOTES:  Extend CheckDuplicate with checking sequence order on inbound events on aTTIP infrastructure.
           If sequence order is not respected the next event will be traced as RESUBMITABLE (status 3) and
           Error SOA-100009 will be propagated to caller.
           Return OUT_RET_CODE = 0 if not duplicate
                                 1 if duplicate
                                 -1 if catched any error
          Values for IN_DIRECTION:
            - INBOUND and OUTBOUND

    STEPs
    1. CheckSequencing
        1.1 IF the couple BID,SERVICE is into the table IDEMPOTENCE
          1.1.1 IF all request are closed, continue with CheckDuplicate (step 2) without blocking event for sequence ordering
            /-
                  L_STATUS_INPROGRESS NUMBER := 1;      -- LOCK SEQUENCING
                  L_STATUS_SUCCESS NUMBER:=2;           -- CLOSE
                  L_STATUS_RESUBMITABLE NUMBER := 3;    -- LOCK SEQUENCING
                  L_STATUS_NOTRESUBMITABLE NUMBER := 4; -- CLOSE
            -/
          1.1.2 IF there's an INPROGRESS request will be inserted a record with status RESUBMITABLE and returned to caller
                a SOA ATTIP error SOA-100009.
    2. CheckDuplicate

******************************************************************************/
PROCEDURE CheckSequencing(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2, IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_id NUMBER;
  l_STATUS NUMBER;
  l_retries NUMBER;
  l_attip_requestid VARCHAR2(255);
  l_conversationid VARCHAR2(255);
  l_tscreated timestamp;
  l_cur_step VARCHAR2(20);
  l_id_idempotence NUMBER;
  l_count NUMBER;
  -- SEQUENCING integration
  l_seq_id NUMBER;
  l_seq_status VARCHAR(20);
  l_seq_BLOCK CHAR :='N';
  CURSOR csr_sequence (p_bid VARCHAR2, p_service VARCHAR2, p_convid VARCHAR2,p_requestid VARCHAR2)
     IS
       SELECT id
        ,case when status in (1, -- IN PROGRESS
                              3  -- RESUBMITABLE
                              ) and conversation_id <> p_convid and request_id <> p_requestid  then 'BLOCK' else 'CLOSED' end STATUS
        FROM ATTIP_IDEMPOTENCE
        WHERE business_id = p_bid and service=p_service
        ORDER BY 2
        FOR UPDATE;

BEGIN
  OUT_RETRIES:=0;
  OUT_RET_CODE := 0;
  OUT_ERROR_CODE:= NULL;
  OUT_ERROR_DESC:= NULL;

  l_id := 0;
  l_STATUS := 0;
  l_id_idempotence := 0;

  SAVEPOINT RESTORETRANS;

  /*CHECK VALIDATION INPUT PARAMETERS */
   IF ((IN_SOURCE_SYSTEM IS NULL OR IN_SOURCE_SYSTEM = '') OR (IN_BUSINESS_ID IS NULL OR IN_BUSINESS_ID = '') OR (IN_CONVERSATION_ID IS NULL OR IN_CONVERSATION_ID = '')
      OR (IN_REQUEST_ID IS NULL OR IN_REQUEST_ID = '') OR (IN_MESSAGE_ID IS NULL OR IN_MESSAGE_ID = '') OR (IN_SERVICE IS NULL OR IN_SERVICE = '') OR (IN_DIRECTION NOT IN ('INBOUND_REQUEST') OR IN_DIRECTION IS NULL))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-100002';
      OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(CheckSequencing) VALIDATION ERROR OF INPUT PARAMETERS (SOURCE_SYSTEM-' || TO_CHAR(IN_SOURCE_SYSTEM) || ',REQUEST_ID-' || IN_REQUEST_ID || ')!';
      RETURN;
   END IF;

  /* CHECK SEQUENCING */
  IF (IN_SOURCE_SYSTEM NOT IN ('TAS') ) THEN  -- Avoid CheckSequencing for some source system
       BEGIN
        dbms_output.put_line('CHECK SEQUENCING: ' || IN_BUSINESS_ID || ','|| IN_SERVICE);
         l_cur_step := 'CHECK_SEQ';
         l_seq_BLOCK := 'N';
         OPEN csr_sequence(IN_BUSINESS_ID,IN_SERVICE,IN_CONVERSATION_ID,IN_REQUEST_ID);
         LOOP
            --dbms_output.put_line('Block0: ' || l_seq_BLOCK);
            FETCH csr_sequence INTO l_seq_id,l_seq_status;
            --dbms_output.put_line('CHECK SEQUENCING record: ' || l_seq_id || ','|| l_seq_status);
            EXIT WHEN csr_sequence%NOTFOUND;
            IF l_seq_status = 'BLOCK' THEN l_seq_BLOCK:='Y';  END IF;
            dbms_output.put_line('Block: ' || l_seq_BLOCK);
            EXIT;
         END LOOP;
         CLOSE csr_sequence;
         EXCEPTION WHEN OTHERS THEN
          begin
            --dbms_output.put_line('CHECK SEQUENCING2: ' || l_seq_BLOCK);
            NULL;
          end;
       END;
   END IF;

   /*CHECK DUPLICATE*/
   l_cur_step := 'DUPL_SRC_REQ';
   SELECT ID,STATUS,RETRIES,ATTIP_REQUEST_ID,TS_CREATED
   INTO l_id,l_STATUS,l_retries,l_attip_requestid,l_tscreated
   FROM ATTIP_IDEMPOTENCE
   WHERE SRC_SYSTEM = IN_SOURCE_SYSTEM
         --AND BUSINESS_ID = IN_BUSINESS_ID
         AND REQUEST_ID = IN_REQUEST_ID
         AND DIRECTION ='INBOUND_REQUEST';

   l_count := SQL%ROWCOUNT;

   IF (l_count >= 1 AND l_STATUS != L_STATUS_RESUBMITABLE ) THEN -- STATUS = 3 [FAULT RESUBMITABLE]
      --OUT_DUPLICATE:= 'YES';
      OUT_RET_CODE:= 1;
      OUT_ERROR_CODE:= 'SOA-100008';
      OUT_ERROR_DESC := 'SOA-100008: Duplicate event - (CheckSequencing)(' || l_cur_step || ')(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
      OUT_ATTIPREQUESTID := l_attip_requestid;
      OUT_TS_CREATED:= l_tscreated;
      OUT_STATUS:= l_STATUS;
      OUT_RETRIES:= l_retries;
      RETURN;
   END IF;

   IF (l_count >= 1) AND (l_STATUS=L_STATUS_RESUBMITABLE) THEN
      l_cur_step := 'UPD_IDEMPOTENCE';
      UPDATE ATTIP_IDEMPOTENCE
          SET
              TS_UPDATED=SYSTIMESTAMP,
              CORRELATION_ID = NVL(IN_CORRELATION_ID,CORRELATION_ID),
              BUSINESS_ID = NVL(IN_BUSINESS_ID,BUSINESS_ID),
              CONVERSATION_ID = NVL(IN_CONVERSATION_ID,CONVERSATION_ID),
              MESSAGE_ID = NVL(IN_MESSAGE_ID,MESSAGE_ID),
              SERVICE =  NVL(IN_SERVICE,SERVICE),
              PXNAME = IN_PXNAME,
              DIRECTION = IN_DIRECTION,
              VERSION = IN_VERSION,
              PROPERTIES = IN_PROPERTIES,
              ATTIP_REQUEST_ID = sys_guid(),
              STATUS = L_STATUS_INPROGRESS, -- IN_PROGRESS
              RETRIES = RETRIES+1
          WHERE
              ID = l_id and STATUS=L_STATUS_RESUBMITABLE and DIRECTION ='INBOUND_REQUEST'
          RETURNING ATTIP_REQUEST_ID,STATUS,RETRIES,TS_CREATED INTO l_attip_requestid,l_STATUS,l_retries,l_tscreated;

      --OUT_DUPLICATE := 'NO';
      OUT_RET_CODE := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(' || l_cur_step || IN_CONVERSATION_ID || l_count ||')';
      OUT_ATTIPREQUESTID := l_attip_requestid;
      OUT_TS_CREATED:= l_tscreated;
      OUT_STATUS:= l_STATUS;
      OUT_RETRIES:= l_retries;
      RETURN;
   END IF;

   EXCEPTION
      WHEN NO_DATA_FOUND THEN -- RECORD NOT FOUND
          BEGIN
              SAVEPOINT RESTORETRANS;

               /*CHECK CONVERSATION ID*/
               l_cur_step := 'DUPL_SRC_CONV';
               SELECT /*+ index(ATTIP_IDEMPOTENCE ) */
                    COUNT(1)
               INTO l_count
               FROM ATTIP_IDEMPOTENCE
               WHERE SRC_SYSTEM = IN_SOURCE_SYSTEM
                AND CONVERSATION_ID = IN_CONVERSATION_ID
                AND DIRECTION ='INBOUND_REQUEST';

               --l_count := SQL%ROWCOUNT;
               IF (l_count >= 1 AND (l_STATUS = L_STATUS_INPROGRESS OR l_STATUS = L_STATUS_NOTRESUBMITABLE)) THEN -- STATUS = 3 [FAULT RESUBMITABLE]
                  --OUT_DUPLICATE:= 'YES';
                  OUT_RET_CODE:= 1;
                  OUT_ERROR_CODE:= 'SOA-100008';
                  OUT_ERROR_DESC := 'SOA-100008: Duplicate event, an event with the same conversation_id is already running or not resubmittable - (CheckSequencing)(' || l_cur_step || ')(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',CONVERSATIONID-' || IN_CONVERSATION_ID || ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
                  OUT_ATTIPREQUESTID := l_attip_requestid;
                  OUT_TS_CREATED:= l_tscreated;
                  OUT_STATUS:= l_STATUS;
                  OUT_RETRIES:= l_retries;
                  RETURN;
               END IF;

              /* GENERATE ID_IDEMPOTENCE_SEQ */
              l_cur_step := 'ID_IDEMPOTENCE_SEQ';
              SELECT ATTIP_IDEMPOTENCE_ID_SEQ.NEXTVAL
              INTO l_id_idempotence FROM dual;
              IF l_id_idempotence = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000008';
                  OUT_ERROR_DESC := 'SOA-000008: Database  error - (CheckSequencing) Error on ID sequence.';
                  ROLLBACK TO RESTORETRANS;
                  RETURN;
              END IF;

              /* INSERT ROW */
              l_cur_step :='INSERT_ROW';
              INSERT INTO ATTIP_IDEMPOTENCE
                  (ID, TS_CREATED, TS_UPDATED, PARTITION_DATE, SRC_SYSTEM, DEST_SYSTEM, CORRELATION_ID, BUSINESS_ID, CONVERSATION_ID, REQUEST_ID
                   , MESSAGE_ID, SERVICE, ATTIP_REQUEST_ID, STATUS, RETRIES
                   , PXNAME, DIRECTION, VERSION, PROPERTIES)
                  VALUES (l_id_idempotence, SYSTIMESTAMP, SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP,'yymmdd'), IN_SOURCE_SYSTEM, IN_DEST_SYSTEM, IN_CORRELATION_ID, IN_BUSINESS_ID, IN_CONVERSATION_ID,IN_REQUEST_ID
                          , IN_MESSAGE_ID, IN_SERVICE, sys_guid(), case when l_seq_BLOCK <> 'Y' then L_STATUS_INPROGRESS else L_STATUS_RESUBMITABLE end, 0
                          , IN_PXNAME, IN_DIRECTION, IN_VERSION, IN_PROPERTIES)
              RETURNING ATTIP_REQUEST_ID,STATUS,RETRIES,TS_CREATED INTO l_attip_requestid,l_STATUS,l_retries,l_tscreated;

              IF SQL%ROWCOUNT = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000008';
                  OUT_ERROR_DESC := 'SOA-000008: Database  error - (CheckSequencing) Not possible to trace new event (REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
                  --ROLLBACK TO RESTORETRANS;
                  RETURN;
              ELSE
                IF l_seq_BLOCK = 'Y' THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-100009';
                  OUT_ERROR_DESC := 'SOA-100009: Sequence ordering issue - (CheckSequencing) Not possible to propagate until the previuos correlated event is not completed(REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ')!';
                  --ROLLBACK TO RESTORETRANS;
                  RETURN;
                END IF;
              END IF;

              --OUT_DUPLICATE := 'NO';
              OUT_RET_CODE := 0;
              OUT_ERROR_CODE := NULL;
              OUT_ERROR_DESC := '(' || l_cur_step || ')';
              OUT_ATTIPREQUESTID := l_attip_requestid;
              OUT_TS_CREATED:= l_tscreated;
              OUT_STATUS:= l_STATUS;
              OUT_RETRIES:= l_retries;
              RETURN;
              EXCEPTION
                WHEN OTHERS THEN
                    OUT_RET_CODE:= -1;
                    OUT_ERROR_CODE := 'SOA-000001';
                    OUT_ERROR_DESC := 'SOA-000001: Generic Error - (CheckSequencing)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
                    RETURN;
          END;
      WHEN TOO_MANY_ROWS THEN
           --OUT_DUPLICATE:= 'YES';
           OUT_RET_CODE:= 1;
           OUT_ERROR_CODE:= 'SOA-100008';
           OUT_ERROR_DESC := 'SOA-100008: Duplicate event - (CheckSequencing)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
           RETURN;
      WHEN OTHERS THEN
            OUT_RET_CODE:= -1;
            OUT_ERROR_CODE := 'SOA-000001';
            OUT_ERROR_DESC := 'SOA-000001: Generic Error - (CheckSequencing)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
            RETURN;
 END CheckSequencing;


 /******************************************************************************
   NAME:       InsertEvent
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        17/06/2010  PL		           Created this procedure.
   1.2        01/07/2010  PL		           Integrate IN_PROPERTIES CLOB
   1.3        30/08/2010  PL		           Removed constraint on OUTBOUND_REQUEST to allow tracing on SRR responses


   NOTES:  Insert new event on aTTIP infrastructure. It will be used for correlation scope.
           Generally is used only for OUTBOUND events.

******************************************************************************/
PROCEDURE InsertEvent(IN_SOURCE_SYSTEM IN VARCHAR2, IN_DEST_SYSTEM IN VARCHAR2, IN_CORRELATION_ID IN VARCHAR2, IN_BUSINESS_ID IN VARCHAR2
                          ,IN_CONVERSATION_ID IN VARCHAR2,IN_REQUEST_ID IN VARCHAR2, IN_MESSAGE_ID IN VARCHAR2, IN_SERVICE IN VARCHAR2
                          ,IN_PXNAME IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_VERSION IN VARCHAR2,IN_PROPERTIES IN CLOB
                          ,OUT_ATTIPREQUESTID OUT VARCHAR2,OUT_TS_CREATED OUT TIMESTAMP, OUT_STATUS OUT NUMBER, OUT_RETRIES OUT NUMBER
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_id NUMBER;
  l_STATUS NUMBER;
  l_retries NUMBER;
  l_attip_requestid VARCHAR2(255);
  l_tscreated timestamp;
  l_cur_step VARCHAR2(20);
  l_id_idempotence NUMBER;
  l_count NUMBER;
  l_corr_response VARCHAR2(255);
  l_corr_appo VARCHAR2(255);
  l_direction_update VARCHAR2(1);
  l_direction VARCHAR2(255);

BEGIN
  OUT_RETRIES:=0;
  OUT_RET_CODE := 0;
  OUT_ERROR_CODE:= NULL;
  OUT_ERROR_DESC:= NULL;

  l_id := 0;
  l_STATUS := 0;
  l_id_idempotence := 0;
  l_direction_update :='N';
  l_direction := IN_DIRECTION;

  SAVEPOINT RESTORETRANS;

  /*CHECK VALIDATION INPUT PARAMETERS */
   IF ((IN_SOURCE_SYSTEM IS NULL OR IN_SOURCE_SYSTEM = '') OR (IN_BUSINESS_ID IS NULL OR IN_BUSINESS_ID = '') OR (IN_CONVERSATION_ID IS NULL OR IN_CONVERSATION_ID = '')
        OR (IN_REQUEST_ID IS NULL OR IN_REQUEST_ID = '') OR (IN_MESSAGE_ID IS NULL OR IN_MESSAGE_ID = '') OR (IN_SERVICE IS NULL OR IN_SERVICE = '') OR (IN_DIRECTION IS NULL OR IN_DIRECTION = '') -- OR IN_DIRECTION NOT IN ('OUTBOUND_REQUEST') REMOVED TO ALLOW TRACING ON SRR request/response
      )
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-100002';
      OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(InsertEvent) VALIDATION ERROR OF INPUT PARAMETERS (SOURCE_SYSTEM-' || TO_CHAR(IN_SOURCE_SYSTEM) || ',REQUEST_ID-' || IN_REQUEST_ID || ',IN_DIRECTION-' || IN_DIRECTION || ',IN_SERVICE-' || IN_SERVICE || ',IN_MESSAGE_ID-' || IN_MESSAGE_ID || ',IN_BUSINESS_ID-' || IN_BUSINESS_ID || ',IN_CONVERSATION_ID-' || IN_CONVERSATION_ID ||')!';
      RETURN;
   END IF;

              /* GENERATE ID_IDEMPOTENCE_SEQ */
              l_cur_step := 'ID_IDEMPOTENCE_SEQ';
              SELECT ATTIP_IDEMPOTENCE_ID_SEQ.NEXTVAL
              INTO l_id_idempotence FROM dual;

              IF l_id_idempotence = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000007';
                  OUT_ERROR_DESC := 'SOA-000007: Database  error - (InsertEvent) Error on ID sequence.';
                  ROLLBACK TO RESTORETRANS;
                  RETURN;
              END IF;
              /* INSERT ROW */
              l_cur_step :='INSERT_ROW';
              l_corr_response:=sys_guid();
              if IN_DIRECTION='OUTBOUND_REQUEST_SRR_COR' THEN
                l_corr_response:= IN_REQUEST_ID;
              END IF;

              IF IN_DIRECTION='OUTBOUND_REQUEST_FF' THEN
                l_direction := 'OUTBOUND_REQUEST';
                l_direction_update:= 'Y';
              END IF;

              IF IN_SERVICE='ManageServiceOrder' THEN
                l_corr_appo:=sys_guid();
                UPDATE ATTIP_IDEMPOTENCE
                SET ATTIP_REQUEST_ID = l_corr_response || '#' || l_corr_appo,TS_UPDATED=SYSTIMESTAMP
                WHERE ATTIP_REQUEST_ID = l_corr_response;
              END IF;
              
              INSERT INTO ATTIP_IDEMPOTENCE
                  (ID, TS_CREATED, TS_UPDATED, PARTITION_DATE, SRC_SYSTEM, DEST_SYSTEM, CORRELATION_ID, BUSINESS_ID, CONVERSATION_ID, REQUEST_ID
                   , MESSAGE_ID, SERVICE, ATTIP_REQUEST_ID, STATUS, RETRIES
                   , PXNAME, DIRECTION, VERSION, PROPERTIES)
                  VALUES (l_id_idempotence, SYSTIMESTAMP, SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP,'yymmdd'), IN_SOURCE_SYSTEM, IN_DEST_SYSTEM, IN_CORRELATION_ID, IN_BUSINESS_ID, IN_CONVERSATION_ID,IN_REQUEST_ID
                          , IN_MESSAGE_ID, IN_SERVICE,l_corr_response, L_STATUS_INPROGRESS, 0
                          , IN_PXNAME, l_direction, IN_VERSION,IN_PROPERTIES)
              RETURNING ATTIP_REQUEST_ID,STATUS,RETRIES,TS_CREATED INTO l_attip_requestid,l_STATUS,l_retries,l_tscreated;

              IF SQL%ROWCOUNT = 0 THEN
                  OUT_RET_CODE := -1;
                  OUT_ERROR_CODE := 'SOA-000007';
                  OUT_ERROR_DESC := 'SOA-000007: Database  error - (InsertEvent) Not possible to trace new event (REQUEST_ID-' || TO_CHAR(IN_REQUEST_ID)|| ',BUSINESSID-' || IN_BUSINESS_ID || ',MESSAGEID-' || IN_MESSAGE_ID ||')!';
                  --ROLLBACK TO RESTORETRANS;
                  RETURN;
              END IF;

              IF l_direction_update = 'Y' THEN
                UPDATE ATTIP_IDEMPOTENCE
                  SET STATUS = 2
                      ,TS_UPDATED=SYSTIMESTAMP
                WHERE CONVERSATION_ID = IN_CONVERSATION_ID
                  AND STATUS NOT IN (L_STATUS_SUCCESS, L_STATUS_NOTRESUBMITABLE); --AND DIRECTION='INBOUND_RESPONSE'; -- Block any tentative to update final states.
              END IF;

              --OUT_DUPLICATE := 'NO';
              OUT_RET_CODE := 0;
              OUT_ERROR_CODE := NULL;
              OUT_ERROR_DESC := '(' || l_cur_step || ')';
              OUT_ATTIPREQUESTID := l_attip_requestid;
              OUT_TS_CREATED:= l_tscreated;
              OUT_STATUS:= l_STATUS;
              OUT_RETRIES:= l_retries;
              RETURN;
              EXCEPTION
                WHEN OTHERS THEN
                    OUT_RET_CODE:= -1;
                    OUT_ERROR_CODE := 'SOA-000001';
                    OUT_ERROR_DESC := 'SOA-000001: Generic Error - (InsertEvent)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_REQUEST_ID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
                    RETURN;
 END InsertEvent;


/******************************************************************************
   NAME:       GetErrorMapping
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        15/06/2010  PL		           Created this procedure.

   NOTES:  Retrieve Error mapping on catalogue

******************************************************************************/
PROCEDURE GetErrorMapping(IN_ERRORCODE IN VARCHAR2, IN_SRCSYSTEM IN VARCHAR2, IN_CONTEXT IN VARCHAR2
                          ,OUT_EXTERRORCODE OUT VARCHAR2,OUT_DESCRIPTION OUT VARCHAR2, OUT_RETRIABLE OUT VARCHAR2, OUT_ERRORTYPE OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  l_cur_step VARCHAR2(20);
  l_count NUMBER;

BEGIN
    OUT_EXTERRORCODE := NULL;
    OUT_DESCRIPTION := NULL;
    OUT_RETRIABLE := NULL;
    OUT_ERRORTYPE := NULL;
    OUT_RET_CODE := '0';
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(GetErrorMapping) Started!';

    /*CHECK VALIDATION INPUT PARAMETERS */
    IF ((IN_ERRORCODE IS NULL OR IN_ERRORCODE = '') OR (IN_SRCSYSTEM IS NULL OR IN_SRCSYSTEM =''))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database  error - (GetErrorMapping) VALIDATION ERROR ON INPUT PARAMETERS (IN_ERRORCODE-' || NVL(IN_ERRORCODE,'') || ',IN_SRCSYSTEM-' || NVL(IN_SRCSYSTEM,'') || ',IN_CONTEXT-' || NVL(IN_CONTEXT,'') || ')!';
      RETURN;
    END IF;

        l_cur_step := 'GET_MAPPING';

        SELECT ACE.ERRCODE, ACE.ERRDESC,
               CASE
                  WHEN ACEM.RETRIABLE IS NULL OR ACEM.RETRIABLE ='' THEN NVL(ACE.RETRIABLE,'N')
                  ELSE NVL(ACEM.RETRIABLE,'N')
               END RETRIABLE,
               CASE
                  WHEN ACEM.TYPE IS NULL OR ACEM.TYPE ='' THEN CASE WHEN ACE.TYPE ='SYSTEM ERROR' THEN 1 ELSE 2 END
                  ELSE CASE WHEN ACEM.TYPE ='SYSTEM ERROR' THEN 1 ELSE 2 END
                  --(CASE WHEN ACEM.TYPE ='SYSTEM ERROR' THEN 1 ELSE 2)
              END TYPE
        INTO  OUT_EXTERRORCODE,OUT_DESCRIPTION, OUT_RETRIABLE, OUT_ERRORTYPE
        FROM ATTIP_CAT_ERROR ACE,
             ATTIP_CAT_ERRMAP ACEM
        WHERE
          ACEM.EXT_ERRCODE = UPPER(IN_ERRORCODE)
          AND ACEM.SYSTEM = UPPER(IN_SRCSYSTEM)
          AND ACEM.CONTEXT = NVL(UPPER(IN_CONTEXT),'DEFAULT')
          AND ACEM.ID_CATERROR = ACE.ID
        ;
        l_count:= SQL%ROWCOUNT;
        IF l_count <> 1 THEN
            OUT_RET_CODE   := -1;
            OUT_ERROR_CODE := 'SOA-000008';
            OUT_ERROR_DESC := 'SOA-000008: Database error - (GetErrorMapping)(' || l_cur_step || ', IN_ERRORCODE: '|| IN_ERRORCODE ||',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_CONTEXT: '|| IN_CONTEXT ||',' || l_count || ') Not found correct mapping!';
            RETURN;
        END IF;

      OUT_RET_CODE   := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetErrorMapping) Error identified ('|| IN_ERRORCODE || ',' || OUT_EXTERRORCODE ||')!';

  /*  END IF; /*END IF ROWCOUNT */

    EXCEPTION
    WHEN NO_DATA_FOUND THEN  -- NOT FOUND SPECIFIC MAPPING THEN IS APPLIED GENERIC MAPPING FOR INTERNAL/EXTERNAL ERROR CODES
      IF IN_SRCSYSTEM in ('ATTIP','MRNS') THEN
          OUT_EXTERRORCODE := 'SOA-000001';
          OUT_DESCRIPTION := 'Generic Error - ';
          OUT_RETRIABLE := 'N';
          OUT_ERRORTYPE := '1';
      ELSE
          OUT_EXTERRORCODE := 'SOA-100002';
          OUT_DESCRIPTION := 'Business data validation exception - ';
          OUT_RETRIABLE := 'N';
          OUT_ERRORTYPE := '1';
      END IF;
      OUT_RET_CODE   := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetErrorMapping)(' || l_cur_step || ', IN_ERRORCODE: '|| IN_ERRORCODE || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM || ', IN_CONTEXT: '|| IN_CONTEXT ||',' || l_count || ') Not found correct mapping!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN -- Doesn't possible to distinguish correct mapping
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (GetErrorMapping)(' || l_cur_step || ', IN_ERRORCODE: '|| IN_ERRORCODE || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM || ', IN_CONTEXT: '|| IN_CONTEXT ||',' || l_count || ') Found too many mappings!';
      RETURN;
    WHEN OTHERS THEN -- Mapped with generic error code
      IF IN_SRCSYSTEM = 'ATTIP' THEN
          OUT_EXTERRORCODE := 'SOA-000001';
          OUT_DESCRIPTION := 'Generic Error - ';
          OUT_RETRIABLE := 'N';
          OUT_ERRORTYPE := '1';
      ELSE
          OUT_EXTERRORCODE := 'SOA-100002';
          OUT_DESCRIPTION := 'Business data validation exception - ';
          OUT_RETRIABLE := 'N';
          OUT_ERRORTYPE := '1';
      END IF;
      OUT_RET_CODE:= 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetErrorMapping)(' || l_cur_step || ')(ERRORCODE:' || NVL(IN_ERRORCODE,'') || ',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_CONTEXT: '|| IN_CONTEXT || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END;

/******************************************************************************
   NAME:       GetRequestIDCorrelated
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        16/06/2010  PL		           Created this procedure.

   NOTES:  Get RequestIDs correlated, starting on RequestID or ATTIP_RequestID

******************************************************************************/
PROCEDURE GetRequestIDCorrelated(INOUT_INPUT_REQUESTID IN OUT VARCHAR2, INOUT_OUTPUT_REQUESTID IN OUT VARCHAR2
                          ,OUT_CORRELATIONID OUT VARCHAR2, OUT_STATUS OUT VARCHAR2,OUT_PXNAME OUT VARCHAR2, OUT_SERVICE OUT VARCHAR2, OUT_VERSION OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  l_cur_step VARCHAR2(20);
  l_count NUMBER;

BEGIN
    OUT_STATUS := NULL;
    OUT_PXNAME := NULL;
    OUT_CORRELATIONID:= NULL;
    OUT_SERVICE := NULL;
    OUT_VERSION := NULL;
    OUT_RET_CODE := '0';
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(GetRequestIDCorrelated) Started!';

    /*CHECK VALIDATION INPUT PARAMETERS */
    IF ((INOUT_INPUT_REQUESTID IS NULL OR INOUT_INPUT_REQUESTID = '') AND (INOUT_OUTPUT_REQUESTID IS NULL OR INOUT_OUTPUT_REQUESTID =''))
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database  error - (GetRequestIDCorrelated) VALIDATION ERROR ON INPUT PARAMETERS (IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ')!';
      RETURN;
    END IF;
    IF (LENGTH(INOUT_INPUT_REQUESTID)>0 AND LENGTH(INOUT_OUTPUT_REQUESTID)>0) -- Error if both valued
      THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database  error - (GetRequestIDCorrelated) VALIDATION ERROR ON INPUT PARAMETERS (IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ') Too many requestIDs provided!';
      RETURN;
    END IF;

    l_cur_step := 'GET_REQUESTIDs';

    SELECT REQUEST_ID,ATTIP_REQUEST_ID,STATUS,PXNAME,SERVICE,VERSION,CORRELATION_ID
    INTO INOUT_INPUT_REQUESTID,INOUT_OUTPUT_REQUESTID,OUT_STATUS,OUT_PXNAME,OUT_SERVICE,OUT_VERSION,OUT_CORRELATIONID
    FROM ATTIP_IDEMPOTENCE
    WHERE
          (INOUT_INPUT_REQUESTID IS NOT NULL AND REQUEST_ID = INOUT_INPUT_REQUESTID)
          OR (INOUT_OUTPUT_REQUESTID IS NOT NULL AND ATTIP_REQUEST_ID = INOUT_OUTPUT_REQUESTID);

    l_count := SQL%ROWCOUNT;

    IF l_count <> 1 THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (GetRequestIDCorrelated)(' || l_cur_step || ', IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ',' || l_count || ') Correlation don''t found!';
      RETURN;
    END IF;

    OUT_RET_CODE   := 0;
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(GetRequestIDCorrelated) (IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ')';

    EXCEPTION
    WHEN NO_DATA_FOUND THEN  -- NOT FOUND SPECIFIC MAPPING THEN IS APPLIED GENERIC MAPPING FOR INTERNAL/EXTERNAL ERROR CODES
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (GetRequestIDCorrelated)(' || l_cur_step || ', IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ',' || l_count || ') Correlation don''t found!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN -- Doesn't possible to distinguish correct mapping
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (GetRequestIDCorrelated)(' || l_cur_step || ', IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ',' || l_count || ') Too many correlations found!';
      RETURN;
    WHEN OTHERS THEN -- Mapped with generic error code
      OUT_RET_CODE:= -1;
      OUT_ERROR_CODE := 'SOA-000001';
      OUT_ERROR_DESC := 'SOA-000001: Generic Error - (GetRequestIDCorrelated)(' || l_cur_step || ', IN_INPUT_REQUESTID-' || NVL(INOUT_INPUT_REQUESTID,'') || ',IN_OUTPUT_REQUESTID-' || NVL(INOUT_OUTPUT_REQUESTID,'') || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END;

/******************************************************************************
   NAME:       InsertResponse
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        21/06/2010  PL		           Created this procedure.
   1.1        30/06/2010  PL               Added OUT_REQ_SOURCE_SYSTEM,OUT_REQ_DEST_SYSTEM
   1.2        01/07/2010  PL               Integrated OUT_REQ_PROPERTIES and IN_RES_PROPERTIES to trace Header's msgSpecificProperty

   NOTES:  Insert Response and Get RequestIDs correlated, starting on RequestID or ATTIP_RequestID. Used only for response tracing and correlation
   Warning: for IN_RES_DIRECTION value accepted are:
              ¿INBOUND_RESPONSE¿ (for response we have sent to initial consumer: ATTIP -> CONSUMER)
              ¿OUTBOUND_RESPONSE¿ (for response we have received by backend system)


******************************************************************************/
PROCEDURE InsertResponse(IN_RES_REQUESTID IN VARCHAR2
                          ,IN_RES_SOURCE_SYSTEM IN VARCHAR2, IN_RES_DEST_SYSTEM IN VARCHAR2, IN_RES_CORRELATION_ID IN VARCHAR2
                          ,IN_RES_BUSINESS_ID IN VARCHAR2,IN_RES_CONVERSATION_ID IN VARCHAR2, IN_RES_MESSAGE_ID IN VARCHAR2
                          ,IN_RES_DIRECTION IN VARCHAR2 -- INBOUND_RESPONSE, OUTBOUND_RESPONSE
                          ,IN_RES_PROPERTIES IN CLOB
                          ,OUT_RES_TS_CREATED OUT TIMESTAMP, OUT_RES_STATUS OUT NUMBER
                          ,OUT_REQ_SOURCE_SYSTEM OUT VARCHAR2, OUT_REQ_DEST_SYSTEM OUT VARCHAR2,OUT_REQ_REQUESTID OUT VARCHAR2
                          ,OUT_REQ_CORRELATIONID OUT VARCHAR2,OUT_REQ_CONVERSATIONID OUT VARCHAR2, OUT_REQ_STATUS OUT VARCHAR2,OUT_REQ_PXNAME OUT VARCHAR2
                          ,OUT_REQ_SERVICE OUT VARCHAR2, OUT_REQ_VERSION OUT VARCHAR2
                          ,OUT_REQ_PROPERTIES OUT CLOB
                          ,OUT_RET_CODE OUT NUMBER,OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  L_STATUS_INPROGRESS NUMBER := 1;
  L_STATUS_SUCCESS NUMBER:=2;
  L_STATUS_RESUBMITABLE NUMBER := 3;
  L_STATUS_NOTRESUBMITABLE NUMBER := 4;
  l_id NUMBER;
  --l_RES_STATUS NUMBER;
  l_REQ_STATUS NUMBER;
  --l_retries NUMBER;
  l_attip_requestid VARCHAR2(255);
  --l_RES_tscreated timestamp;
  l_id_idempotence NUMBER;

  l_cur_step VARCHAR2(20);
  l_count NUMBER;

  l_service VARCHAR2(200);

  l_direction VARCHAR2(255);
  l_direction2 VARCHAR2(255);
  l_direction_update VARCHAR2(1);

BEGIN
  --OUT_RETRIES:=0;
  OUT_RET_CODE := 0;
  OUT_ERROR_CODE:= NULL;
  OUT_ERROR_DESC:= NULL;

  l_id := 0;
  --l_STATUS := 0;
  l_id_idempotence := 0;
  l_direction2 := IN_RES_DIRECTION;

  SAVEPOINT RESTORETRANS;
  l_cur_step := 'VALIDATE_INPUTS';


-- Get CorrelationID
    OUT_REQ_STATUS := NULL;
    OUT_REQ_PXNAME := NULL;
    OUT_REQ_CORRELATIONID:= NULL;
    OUT_REQ_CONVERSATIONID:= NULL;
    OUT_REQ_SERVICE := NULL;
    OUT_REQ_VERSION := NULL;

    l_cur_step := 'GET_REQUESTIDs';

    IF IN_RES_DIRECTION='OUTBOUND_RESPONSE_FF' THEN
      l_direction2 := 'OUTBOUND_RESPONSE';
      l_direction_update := 'Y';
    END IF;

    IF IN_RES_DIRECTION = 'INBOUND_RESPONSE#MNO' THEN
      SELECT REQUEST_ID,STATUS,PXNAME,SERVICE,VERSION,CORRELATION_ID,CONVERSATION_ID,SRC_SYSTEM,DEST_SYSTEM,PROPERTIES
      INTO OUT_REQ_REQUESTID,OUT_REQ_STATUS,OUT_REQ_PXNAME,OUT_REQ_SERVICE,OUT_REQ_VERSION,OUT_REQ_CORRELATIONID, OUT_REQ_CONVERSATIONID
           ,OUT_REQ_SOURCE_SYSTEM, OUT_REQ_DEST_SYSTEM,OUT_REQ_PROPERTIES
      FROM ATTIP_IDEMPOTENCE
      WHERE (IN_RES_CONVERSATION_ID IS NOT NULL AND CONVERSATION_ID = IN_RES_CONVERSATION_ID AND
             IN_RES_BUSINESS_ID IS NOT NULL AND BUSINESS_ID = IN_RES_BUSINESS_ID AND
             DIRECTION = 'INBOUND_REQUEST');
      l_direction2 := 'INBOUND_RESPONSE';
    ELSE
      SELECT REQUEST_ID,STATUS,PXNAME,SERVICE,VERSION,CORRELATION_ID,CONVERSATION_ID,SRC_SYSTEM,DEST_SYSTEM,PROPERTIES
      INTO OUT_REQ_REQUESTID,OUT_REQ_STATUS,OUT_REQ_PXNAME,OUT_REQ_SERVICE,OUT_REQ_VERSION,OUT_REQ_CORRELATIONID, OUT_REQ_CONVERSATIONID
           ,OUT_REQ_SOURCE_SYSTEM, OUT_REQ_DEST_SYSTEM,OUT_REQ_PROPERTIES
      FROM ATTIP_IDEMPOTENCE
      WHERE (IN_RES_REQUESTID IS NOT NULL AND ATTIP_REQUEST_ID = IN_RES_REQUESTID);
      --l_direction := l_direction2;
    END IF;
    l_count := SQL%ROWCOUNT;

    IF l_count <> 1 THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (InsertResponse)(' || l_cur_step || ', Request_ID-' || NVL(IN_RES_REQUESTID,'') || ',' || l_count || ') Correlation don''t found!';
      RETURN;
    END IF;

    BEGIN /*START GROUP INSERTING RESPONSE */
      /*CHECK VALIDATION INPUT PARAMETERS */
       IF ((IN_RES_SOURCE_SYSTEM IS NULL OR IN_RES_SOURCE_SYSTEM = '') OR (IN_RES_BUSINESS_ID IS NULL OR IN_RES_BUSINESS_ID = '') OR (IN_RES_CONVERSATION_ID IS NULL OR IN_RES_CONVERSATION_ID = '')
          OR (IN_RES_REQUESTID IS NULL OR IN_RES_REQUESTID = '') OR (IN_RES_MESSAGE_ID IS NULL OR IN_RES_MESSAGE_ID = '')
          OR (l_direction2 IS NULL OR l_direction2 NOT IN ('INBOUND_RESPONSE','OUTBOUND_RESPONSE', 'OUTBOUND_RESPONSE_SRR_COR', 'OUTBOUND_RESPONSE_FF'))
          )
          THEN
          OUT_RET_CODE   := -1;
          OUT_ERROR_CODE := 'SOA-100002';
          OUT_ERROR_DESC := 'SOA-100002: Business data validation exception -(InsertResponse) VALIDATION ERROR OF INPUT PARAMETERS (SOURCE_SYSTEM-' || TO_CHAR(IN_RES_SOURCE_SYSTEM) || ',REQUEST_ID-' || IN_RES_REQUESTID || ',l_direction2-' || l_direction2 || ')!';
          RETURN;
       END IF;

       /* GENERATE ID_IDEMPOTENCE_SEQ */
       l_cur_step := 'ID_IDEMPOTENCE_SEQ';
       SELECT ATTIP_IDEMPOTENCE_ID_SEQ.NEXTVAL
       INTO l_id_idempotence FROM dual;

       IF l_id_idempotence = 0 THEN
         OUT_RET_CODE := -1;
         OUT_ERROR_CODE := 'SOA-000007';
         OUT_ERROR_DESC := 'SOA-000007: Database  error - (InsertResponse) Error on ID sequence.';
         ROLLBACK TO RESTORETRANS;
         RETURN;
       END IF;

       /*SELECT service INTO l_service
       FROM attip_idempotence
       WHERE business_id=IN_RES_BUSINESS_ID
       AND conversation_id=IN_RES_CONVERSATION_ID and direction='INBOUND_REQUEST'*/

       /* INSERT ROW */
       l_cur_step :='INSERT_ROW';
       INSERT INTO ATTIP_IDEMPOTENCE
             (ID, TS_CREATED, TS_UPDATED, PARTITION_DATE, SRC_SYSTEM
              , DEST_SYSTEM, CORRELATION_ID, BUSINESS_ID, CONVERSATION_ID, REQUEST_ID
              , MESSAGE_ID, SERVICE, ATTIP_REQUEST_ID, STATUS, RETRIES
              , DIRECTION, PROPERTIES)
             VALUES (l_id_idempotence, SYSTIMESTAMP, SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP,'yymmdd'), IN_RES_SOURCE_SYSTEM
                     , IN_RES_DEST_SYSTEM
                     ,CASE WHEN l_direction2 = 'INBOUND_RESPONSE' THEN OUT_REQ_CORRELATIONID
                           ELSE IN_RES_CORRELATION_ID
                      END
                     , IN_RES_BUSINESS_ID, IN_RES_CONVERSATION_ID
                     ,CASE WHEN l_direction2 = 'INBOUND_RESPONSE' THEN OUT_REQ_REQUESTID
                           ELSE IN_RES_REQUESTID
                      END
                     , IN_RES_MESSAGE_ID, OUT_REQ_SERVICE,null, L_STATUS_SUCCESS, 0
                     , l_direction2, IN_RES_PROPERTIES)
       RETURNING STATUS,TS_CREATED INTO OUT_RES_STATUS,OUT_RES_TS_CREATED;

       IF SQL%ROWCOUNT = 0 THEN
          OUT_RET_CODE := -1;
          OUT_ERROR_CODE := 'SOA-000007';
          OUT_ERROR_DESC := 'SOA-000007: Database  error - (InsertResponse) Not possible to trace new response (REQUEST_ID-' || TO_CHAR(IN_RES_REQUESTID)|| ',BUSINESSID-' || IN_RES_BUSINESS_ID || ',MESSAGEID-' || IN_RES_MESSAGE_ID ||')!';
          --ROLLBACK TO RESTORETRANS;
          RETURN;
       END IF;

      IF l_direction2 = 'INBOUND_RESPONSE' OR l_direction_update = 'Y' THEN
        UPDATE ATTIP_IDEMPOTENCE
          SET STATUS = 2
              ,TS_UPDATED=SYSTIMESTAMP
          WHERE CONVERSATION_ID = IN_RES_CONVERSATION_ID
              AND STATUS NOT IN (L_STATUS_SUCCESS, L_STATUS_NOTRESUBMITABLE); --AND DIRECTION='INBOUND_RESPONSE'; -- Block any tentative to update final states.
       END IF;

       OUT_ERROR_DESC := '(' || l_cur_step || ')';

       EXCEPTION
         WHEN OTHERS THEN
           OUT_RET_CODE:= -1;
           OUT_ERROR_CODE := 'SOA-000001';
           OUT_ERROR_DESC := 'SOA-000001: Generic Error - (InsertResponse)(' || l_cur_step || ')(Request_ID:' || TO_CHAR(IN_RES_REQUESTID) || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
           RETURN;
   END; -- Group INSERTING RESPONSE CLOSED


    OUT_RET_CODE   := 0;
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(InsertResponse) (Request_ID-' || NVL(IN_RES_REQUESTID,'') || ')';

    EXCEPTION
    WHEN NO_DATA_FOUND THEN  -- NOT FOUND SPECIFIC MAPPING THEN IS APPLIED GENERIC MAPPING FOR INTERNAL/EXTERNAL ERROR CODES
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (InsertResponse)(' || l_cur_step || ', Request_ID-' || NVL(IN_RES_REQUESTID,'') || ',' || l_count || ') Correlation don''t found!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN -- Doesn't possible to distinguish correct mapping
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (InsertResponse)(' || l_cur_step || ', Request_ID-' || NVL(IN_RES_REQUESTID,'')  || ',' || l_count || ') Too many correlations found!';
      RETURN;
    WHEN OTHERS THEN -- Mapped with generic error code
      OUT_RET_CODE:= -1;
      OUT_ERROR_CODE := 'SOA-000001';
      OUT_ERROR_DESC := 'SOA-000001: Generic Error - (InsertResponse)(' || l_cur_step || ', Request_ID-' || NVL(IN_RES_REQUESTID,'') || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END InsertResponse;

/******************************************************************************
   NAME:       GetIdsEvent
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        04/12/2010  EL		           Created this procedure.

   NOTES:  Retrieve id event

******************************************************************************/
PROCEDURE GetIdsEvent(IN_BUSINESSID IN VARCHAR2, IN_CONVERSATIONID IN VARCHAR2, IN_SRCSYSTEM IN VARCHAR2, IN_DESTSYSTEM IN VARCHAR2, IN_DIRECTION IN VARCHAR2, IN_EXT_FIELD IN VARCHAR2
                          ,OUT_BUSINESSID OUT VARCHAR2, OUT_CONVERSATIONID OUT VARCHAR2, OUT_MESSAGEID OUT VARCHAR2, OUT_REQUESTID OUT VARCHAR2
                          ,OUT_CORRELATIONID OUT VARCHAR2, OUT_SERVICE OUT VARCHAR2, OUT_DIRECTION OUT VARCHAR2, OUT_STATUS OUT VARCHAR2, OUT_ATTIPREQUESTID OUT VARCHAR2, OUT_EXT_FIELD OUT VARCHAR2
                          ,OUT_RET_CODE OUT NUMBER, OUT_ERROR_CODE OUT VARCHAR2,OUT_ERROR_DESC OUT VARCHAR2) IS

  l_cur_step VARCHAR2(20);
  l_count NUMBER;

BEGIN
    OUT_BUSINESSID := NULL;
    OUT_CONVERSATIONID := NULL;
    OUT_MESSAGEID := NULL;
    OUT_REQUESTID := NULL;
    OUT_CORRELATIONID := NULL;
    OUT_SERVICE := NULL;
    OUT_DIRECTION := NULL;
    OUT_STATUS := NULL;
    OUT_RET_CODE := '0';
    OUT_ERROR_CODE := NULL;
    OUT_ERROR_DESC := '(GetIdsEvent) Started!';

    /*CHECK VALIDATION INPUT PARAMETERS */
    /*IF (IN_BUSINESSID IS NULL OR IN_CONVERSATIONID IS NULL OR IN_SRCSYSTEM IS NULL OR IN_DESTSYSTEM IS NULL OR IN_DIRECTION IS NULL) THEN
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database  error - (GetIdsEvent) VALIDATION ERROR ON INPUT PARAMETERS (IN_BUSINESSID-' || NVL(IN_BUSINESSID,'') || ',IN_CONVERSATIONID-' || NVL(IN_CONVERSATIONID,'') || ',IN_SRCSYSTEM-' || NVL(IN_SRCSYSTEM,'') || ',IN_DESTSYSTEM-' || NVL(IN_DESTSYSTEM,'') || ',IN_DIRECTION-' || NVL(IN_DIRECTION,'') || ',IN_EXT_FIELD-' || NVL(IN_EXT_FIELD,'') || ')!';
      RETURN;
    END IF;*/

        l_cur_step := 'GET_EVENT';

        SELECT BUSINESS_ID, CONVERSATION_ID, MESSAGE_ID, REQUEST_ID, CORRELATION_ID, SERVICE, DIRECTION, STATUS, ATTIP_REQUEST_ID, PXNAME
        INTO  OUT_BUSINESSID,OUT_CONVERSATIONID, OUT_MESSAGEID, OUT_REQUESTID, OUT_CORRELATIONID, OUT_SERVICE, OUT_DIRECTION, OUT_STATUS, OUT_ATTIPREQUESTID, OUT_EXT_FIELD
        FROM ATTIP_IDEMPOTENCE
        WHERE
          (IN_BUSINESSID IS NULL OR BUSINESS_ID = IN_BUSINESSID)
          AND (IN_CONVERSATIONID IS NULL OR CONVERSATION_ID = IN_CONVERSATIONID)
          AND (IN_SRCSYSTEM IS NULL OR SRC_SYSTEM = IN_SRCSYSTEM)
          AND (IN_DESTSYSTEM IS NULL OR DEST_SYSTEM = IN_DESTSYSTEM)
          AND (IN_DIRECTION IS NULL OR DIRECTION = IN_DIRECTION)
          AND (IN_EXT_FIELD IS NULL OR PXNAME = IN_EXT_FIELD);

        l_count:= SQL%ROWCOUNT;
        IF l_count <> 1 THEN
            OUT_RET_CODE   := -1;
            OUT_ERROR_CODE := 'SOA-000008';
            OUT_ERROR_DESC := 'SOA-000008: Database error - (GetIdsEvent)(' || l_cur_step || ', IN_BUSINESSID: '|| IN_BUSINESSID ||',' || ', IN_CONVERSATIONID: '|| IN_CONVERSATIONID ||',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_DESTSYSTEM: '|| IN_DESTSYSTEM ||',' || ', IN_DIRECTION: '|| IN_DIRECTION ||',' || ',IN_EXT_FIELD-' || NVL(IN_EXT_FIELD,'') || l_count || ')  Found too many rows!';
            RETURN;
        END IF;

      OUT_RET_CODE   := 1;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetIdsEvent) Event identified!';

  /*  END IF; /*END IF ROWCOUNT */

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      OUT_RET_CODE   := 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetIdsEvent)(' || l_cur_step || ', IN_BUSINESSID: '|| IN_BUSINESSID ||',' || ', IN_CONVERSATIONID: '|| IN_CONVERSATIONID ||',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_DESTSYSTEM: '|| IN_DESTSYSTEM ||',' || ', IN_DIRECTION: '|| IN_DIRECTION ||',' || ',IN_EXT_FIELD-' || NVL(IN_EXT_FIELD,'') || l_count || ') Not found any row!';
      RETURN;
    WHEN TOO_MANY_ROWS THEN -- Doesn't possible to distinguish correct mapping
      OUT_RET_CODE   := -1;
      OUT_ERROR_CODE := 'SOA-000008';
      OUT_ERROR_DESC := 'SOA-000008: Database error - (GetIdsEvent)(' || l_cur_step || ', IN_BUSINESSID: '|| IN_BUSINESSID ||',' || ', IN_CONVERSATIONID: '|| IN_CONVERSATIONID ||',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_DESTSYSTEM: '|| IN_DESTSYSTEM ||',' || ', IN_DIRECTION: '|| IN_DIRECTION ||',' || ',IN_EXT_FIELD-' || NVL(IN_EXT_FIELD,'') || l_count || ') Found too many rows!';
      RETURN;
    WHEN OTHERS THEN
      OUT_RET_CODE:= 0;
      OUT_ERROR_CODE := NULL;
      OUT_ERROR_DESC := '(GetErrorMapping)(' || l_cur_step || ', IN_BUSINESSID: '|| IN_BUSINESSID ||',' || ', IN_CONVERSATIONID: '|| IN_CONVERSATIONID ||',' || ', IN_SRCSYSTEM: '|| IN_SRCSYSTEM ||',' || ', IN_DESTSYSTEM: '|| IN_DESTSYSTEM ||',' || ', IN_DIRECTION: '|| IN_DIRECTION ||',' || ',IN_EXT_FIELD-' || NVL(IN_EXT_FIELD,'') || l_count || ')[' || TO_CHAR(SQLCODE) || '-' || SQLERRM ||']';
      RETURN;
END;

END ATTIP_Core;
/