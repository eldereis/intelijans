create or replace TRIGGER "TRG_CONSISTENCYBAM" BEFORE
  INSERT OR
  UPDATE ON "_TemplateSRR_DO" REFERENCING OLD AS OLD NEW AS NEW FOR EACH ROW DECLARE newExecutionTime INTEGER;
  newFixedTime                                                                                        INTEGER;
  stato                                                                                               VARCHAR(1);
  BEGIN
    newFixedTime    :=0;
    newExecutionTime:=0;
    stato           :='I';
    IF INSERTING THEN
      IF :new."_CreationDate" IS NULL THEN
        :new."_CreationDate"  :=:new."_LastUpdate";
      END IF;
    ELSIF UPDATING THEN
      /*select
      NVL((extract(hour from :new."_LastUpdate"- :new."_CreationDate"))*3600+
      (extract(minute from :new."_LastUpdate"- :new."_CreationDate"))*60+
      (extract(second from :new."_LastUpdate"-:new."_CreationDate")) ,0) ET,
      NVL(
      (extract(hour from :new."_ErrorFD"- :new."_ErrorCD"))*3600+
      (extract(minute from :new."_ErrorFD"- :new."_ErrorCD"))*60+
      (extract(second from :new."_ErrorFD"- :new."_ErrorCD")),0) FT
      into newExecutionTime, newFixedTime
      from DUAL;*/      
      IF :new."_Status"='Successfull' and :new."_LastUpdate"<:old."_LastUpdate" then
         :new."_LastUpdate":=systimestamp;
      end IF;
      IF ((:old."_Status"  ='Successful') AND (:new."_Status" ='Running' OR :new."_Status" ='Started')) -- BLOCK
        OR ((:old."_Status"='Running' OR :old."_Status"='Error') AND ((:new."_Status" ='Running' OR :new."_Status" ='Started' ) AND :new."_CreationDate"<>:old."_CreationDate" )) OR (:new."_CodeError" = 'SOA-100008' AND (:new."_Type" <>'Component Service' OR :new."_TypeOfService"<>'Component Service')) THEN
        /*insert into LOG_TemplateSRR_DO
        ("_IntegrationFlow", "_ServiceName", "_Type", "_SubType", "_Status", "_CreationDate", "_LastUpdate", "_System", "SysIterID", "SysIterTrID",
        "SysIterTotalsChild",  "_InstanceID",  "_ErrorCD",  "_ErrorFD",  "_TypeError",  "_CodeError",  "_TypeOfService",action)
        values
        (:new."_IntegrationFlow", :new."_ServiceName", :new."_Type", :new."_SubType", :new."_Status", :new."_CreationDate", :new."_LastUpdate", :new."_System", :new."SysIterID", :new."SysIterTrID",
        :new."SysIterTotalsChild",  :new."_InstanceID",  :new."_ErrorCD",  :new."_ErrorFD",  :new."_TypeError",  :new."_CodeError",  :new."_TypeOfService", 'DISCARDED')
        ;*/
        :new."_IntegrationFlow"   := :old."_IntegrationFlow";
        :new."_ServiceName"       := :old."_ServiceName";
        :new."_Type"              := :old."_Type";
        :new."_SubType"           := :old."_SubType";
        :new."_Status"            := :old."_Status";
        :new."_CreationDate"      := :old."_CreationDate";
        :new."_LastUpdate"        := :old."_LastUpdate";
        :new."_System"            := :old."_System";
        :new."SysIterID"          := :old."SysIterID";
        :new."SysIterTrID"        := :old."SysIterTrID";
        :new."SysIterTotalsChild" := :old."SysIterTotalsChild";
        :new."_InstanceID"        := :old."_InstanceID";
        :new."_ErrorCD"           := :old."_ErrorCD";
        :new."_ErrorFD"           := :old."_ErrorFD";
        :new."_CodeError"         := :old."_CodeError";
        :new."_TypeOfService"     := :old."_TypeOfService";
      END IF;
      
      IF :new."_ErrorFD"   IS NOT NULL AND :old."_ErrorFD" IS NULL AND :old."_CreationDate">:new."_ErrorCD" THEN
        :new."_ErrorCD"       := :new."_LastUpdate";
      END IF;
      IF :new."_ErrorCD"   IS NOT NULL AND :new."_ErrorFD" IS NOT NULL THEN
        :new."_ErrorCD"       := :old."_ErrorCD";
      END IF;
      IF :new."_ErrorCD"   IS NOT NULL AND :new."_LastUpdate" <:new."_ErrorCD" THEN
        :new."_LastUpdate"    := :new."_ErrorCD";
      END IF;
      IF :new."_ErrorFD"   IS NOT NULL AND :new."_LastUpdate" <:new."_ErrorFD" THEN
        :new."_LastUpdate"    := :new."_ErrorCD";
      END IF;
      IF :new."_ErrorFD"   IS NOT NULL AND :old."_ErrorCD">:new."_ErrorFD" THEN
        :new."_ErrorFD"       := :new."_LastUpdate";
      END IF;
      IF :new."_ErrorCD"    > :new."_ErrorFD" THEN
        :new."_ErrorFD"       := :new."_LastUpdate";
      END IF;
      IF :new."_LastUpdate" < :old."_LastUpdate" THEN
       :new."_LastUpdate" := :old."_LastUpdate";
			END IF;
      IF :new."_LastUpdate" < :new."_ErrorCD" THEN
			 :new."_LastUpdate" := :new."_ErrorCD";			 
			END IF;
      IF :new."_LastUpdate"<:new."_ErrorFD"  THEN
			 :new."_LastUpdate" := :new."_ErrorFD";              
      END IF;
      IF :new."_CreationDate" < :old."_CreationDate" THEN
        :new."_CreationDate"    := :old."_CreationDate";
      END IF;
    END IF;
  END;
/
  