/***********************************************************************************
 NAME:       PGM1_INT_CREATE_SEQUENCES.SQL


   REVISIONS:
   VER        DATE        AUTHOR           DESCRIPTION
   ---------  ----------  ---------------  ------------------------------------
   1.0        27/08/2010  AR               CREATED SCRIPT
                                       
                                           
   NOTES:  
            
            
   AUTOMATICALLY AVAILABLE AUTO REPLACE KEYWORDS:
      OBJECT NAME:     PGM1_INT_CREATE_SEQUENCES.SQL
      SYSDATE:         
      DATE AND TIME:   
      USERNAME:        
      TABLE NAME:      

*********************************************************************************/

prompt ... Creating sequence (ATTIP_IDEMPOTENCE_ID_SEQ)
CREATE SEQUENCE ATTIP_IDEMPOTENCE_ID_SEQ
  MINVALUE 1
  MAXVALUE 999999999999
  INCREMENT BY 1
  NOORDER
  CACHE 30;
prompt ... Created

prompt ... Creating sequence (ATTIP_REQUEST_ID_SEQ)
CREATE SEQUENCE ATTIP_IDEMPOTENCE_REQID_SEQ
  MINVALUE 1
  MAXVALUE 999999999999
  INCREMENT BY 1
  NOORDER
  CACHE 30;
prompt ... Created

prompt ... Creating sequence (ATTIP_CATERRMAP_ID_SEQ)
create sequence ATTIP_CATERRMAP_ID_SEQ
  MINVALUE 1
  MAXVALUE 999999999999
  INCREMENT BY 1
  NOORDER
  CACHE 30;
prompt ... Created

prompt ... Creating sequence (ATTIP_CATERROR_ID_SEQ)
create sequence ATTIP_CATERROR_ID_SEQ
  MINVALUE 1
  MAXVALUE 999999999999
  INCREMENT BY 1
  NOORDER
  CACHE 30;
prompt ... Created