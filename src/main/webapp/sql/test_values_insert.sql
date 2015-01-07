/*회원정보*/
Insert into TB_USER_INFO (USER_ID,USER_NAME,USER_PHONE,USER_SEX,USER_AGE,USER_POINT)
Values('yoona','임윤아','01077778888','여','1990',0);

Insert into TB_USER_INFO (USER_ID,USER_NAME,USER_PHONE,USER_SEX,USER_AGE,USER_POINT)
Values('taeyeon','김태연','01012123434','여','1989',0);

/*회사정보*/
Insert into TB_COMPANY_INFO (COMPANY_ID, COMPANY_NAME, COMPANY_EMAIL,COMPANY_PHONE,COMPANY_LETTER,COMPANY_TOTAL_CASH,COMPANY_CASH_NUM)
Values('goodface','굿페이스','goodface@nate.com','01020304050','01022334456',1000000,'235-3538-3538-38');

/*이벤트정보*/
Insert into TB_EVENT (EVENT, COMPANY_ID, EVE_START_DATE,CS_COUNT,DB_PRICE,EVE_STATE,CS_NOTE)
Values('사과같은 내얼굴','goodface',now(),0,20000,1,'테스트');

Insert into TB_EVENT (EVENT, COMPANY_ID, EVE_START_DATE,CS_COUNT,DB_PRICE,EVE_STATE,CS_NOTE)
Values('소녀시대 다리라인','goodface',now(),0,20000,1,'테스트');

/*이벤트 신청정보*/
Insert into TB_EVE_REQ (USER_ID, CS_TIME, CS_DATE,CS_STATE,EVENT,COMPANY_ID)
Values('yoona','16:00~17:00',now(),1,'사과같은 내얼굴','goodface');

Insert into TB_EVE_REQ (USER_ID, CS_TIME, CS_DATE,CS_STATE,EVENT,COMPANY_ID)
Values('taeyeon','10:00~11:00',now(),1,'사과같은 내얼굴','goodface');

/*충전금 내역*/
Insert into TB_COMPANY_CASH (COMPANY_ID, CHAR_CASH, CHAR_DATE,TAKE_PRICE,TAKE_DATE)
Values('goodface',20000,now(),10000,now());


select req.USER_ID as USER_ID, CS_TIME, CS_DATE,CS_STATE,EVENT,COMPANY_ID, USER_NAME, USER_PHONE
			from 
			(select * from TB_EVE_REQ where company_id=#{company_id}) req inner join TB_USER_INFO userinfo
			on req.user_id = userinfo.user_id 
				
