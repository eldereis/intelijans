/***********************************************************************************
 NAME:       PGM1_INT_CREATE_TABLES.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        02/06/2010  PC               CREATED SCRIPT
   1.1        03/06/2010  PL               UPDATED ATTIP_IDEMPOTENCE WITH CONSTRAINTS
   1.2				27/07/2010	AR							 CREATED ATTIP_CAT_ERRMAP SCRIPT
   1.3				06/09/2010  AR							 UPDATED ATTIP_IDEMPOTENCE WITHOUT PARTITIONS
                                       
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_TABLES.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

--spool &Logfile
--set linesize 200
set echo off
set feedback off

prompt Creating table (ATTIP_IDEMPOTENCE)...
CREATE TABLE ATTIP_IDEMPOTENCE (
  ID               NUMBER          NOT NULL,
  TS_CREATED       TIMESTAMP       DEFAULT SYSTIMESTAMP NOT NULL,
  TS_UPDATED       TIMESTAMP       NULL,
  PARTITION_DATE   CHAR(6)         NOT NULL,
  SRC_SYSTEM       VARCHAR2(5)     NULL,
  DEST_SYSTEM      VARCHAR2(5)     NULL,
  CORRELATION_ID   VARCHAR2(255)   NULL,
  BUSINESS_ID      VARCHAR2(255)   NULL,
  CONVERSATION_ID  VARCHAR2(255)   NULL,
  REQUEST_ID       VARCHAR2(255)   NULL,
  MESSAGE_ID       VARCHAR2(255)   NULL,
  SERVICE          VARCHAR2(255)   NULL, -- Service name
  PXNAME           VARCHAR2(255)   NULL, -- PXNAME FOR DYNAMIC DISPATCHING (specific for Component Service)
  DIRECTION        VARCHAR2(50)    NULL, -- INBOUND, OUTBOUND
  VERSION          VARCHAR2(50)    NULL, -- Service version (extracted by Header message)
  ATTIP_REQUEST_ID VARCHAR2(255)   NULL,
  PROPERTIES       CLOB            NULL, -- Structure msgSpecificProperty include on header
  STATUS           NUMBER          default 1 NULL, -- 1 - in Progress
  RETRIES	         NUMBER          NULL  -- REtries for resubmition on fault management
)
PARTITION BY RANGE (PARTITION_DATE)(
PARTITION P_201009 VALUES LESS THAN ('101001') TABLESPACE &tablespaceT09 NOCOMPRESS, 
PARTITION P_201010 VALUES LESS THAN ('101101') TABLESPACE &tablespaceT10 NOCOMPRESS, 
PARTITION P_201011 VALUES LESS THAN ('101201') TABLESPACE &tablespaceT11 NOCOMPRESS, 
PARTITION P_201012 VALUES LESS THAN ('110101') TABLESPACE &tablespaceT12 NOCOMPRESS,
PARTITION P_MAX VALUES LESS THAN (MAXVALUE) TABLESPACE &tablespaceDEF NOCOMPRESS
);
prompt ... Created table (ATTIP_IDEMPOTENCE)

prompt Creating PK (ATTIP_IDEMPOTENCE_PK)...
ALTER TABLE ATTIP_IDEMPOTENCE ADD CONSTRAINT ATTIP_IDEMPOTENCE_PK PRIMARY KEY (ID)
USING INDEX ENABLE;
prompt ... Created PK (ATTIP_IDEMPOTENCE_PK)

prompt Creating UK (ATTIP_IDEMPOTENCE_REQID_UK)...
ALTER TABLE ATTIP_IDEMPOTENCE ADD CONSTRAINT ATTIP_IDEMPOTENCE_REQID_UK UNIQUE (ATTIP_REQUEST_ID)
  USING INDEX ENABLE;
prompt ... Created PK (ATTIP_IDEMPOTENCE_REQID_UK)

prompt Creating table (ATTIP_CAT_ERROR)...
CREATE TABLE ATTIP_CAT_ERROR
(
  ID         NUMBER NOT NULL,
  TS_CREATED TIMESTAMP(6) DEFAULT SYSTIMESTAMP NOT NULL,
  TS_UPDATED TIMESTAMP(6),
  ERRCODE    VARCHAR2(25),
  ERRDESC    VARCHAR2(250),
  TYPE       VARCHAR2(50),
  NOTES      VARCHAR2(250),
  RETRIABLE  CHAR(1) DEFAULT 'N' NOT NULL,
  IS_ENABLE  CHAR(1) DEFAULT 'N' NOT NULL
);
prompt ... Created table (ATTIP_CAT_ERROR)

prompt Creating PK (ATTIP_CATERROR_PK)... 
ALTER TABLE ATTIP_CAT_ERROR
  ADD CONSTRAINT ATTIP_CATERROR_PK PRIMARY KEY (ID)
  USING INDEX ENABLE;
prompt ... Created PK (ATTIP_CATERROR_PK)

prompt Creating table (ATTIP_CAT_ERRMAP)...
CREATE TABLE ATTIP_CAT_ERRMAP
(
  ID          NUMBER NOT NULL,
  TS_CREATED  TIMESTAMP(6) NOT NULL,
  TS_UPDATED  TIMESTAMP(6),
  SYSTEM      VARCHAR2(5) NOT NULL,
  CONTEXT     VARCHAR2(25) NOT NULL,
  EXT_ERRCODE VARCHAR2(50) NOT NULL,
  EXT_ERRDESC VARCHAR2(250),
  ID_CATERROR NUMBER NOT NULL,
  TYPE        VARCHAR2(50),
  NOTE        VARCHAR2(250),
  RETRIABLE   CHAR(1) DEFAULT 'N' NOT NULL,
  IS_ENABLE   CHAR(1) DEFAULT 'N' NOT NULL
);
prompt ... Created table (ATTIP_CAT_ERRMAP)

prompt Creating PK (ATTIP_CATERRMAP_PK)...
ALTER TABLE ATTIP_CAT_ERRMAP
  ADD CONSTRAINT ATTIP_CATERRMAP_PK PRIMARY KEY (SYSTEM, CONTEXT, EXT_ERRCODE)
  USING INDEX ENABLE;
prompt ... Created PK (ATTIP_CATERRMAP_PK)

prompt Creating FK (ATTIP_CATERROR_CATERRMAP_FK1)...
ALTER TABLE ATTIP_CAT_ERRMAP
  ADD CONSTRAINT ATTIP_CATERROR_CATERRMAP_FK1 FOREIGN KEY (ID_CATERROR)
  REFERENCES ATTIP_CAT_ERROR (ID);
prompt ... Created FK (ATTIP_CATERROR_CATERRMAP_FK1)