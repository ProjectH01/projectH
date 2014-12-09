/*회원정보*/
Insert into TB_USER_INFO (USER_ID,USER_NAME,USER_PHONE,USER_SEX,USER_AGE,USER_POINT)
Values('usertest','홍길순','01054621111','여','1996',0);

/*회사정보*/
Insert into TB_COMPANY_INFO (COMPANY_ID, COMPANY_NAME, COMPANY_EMAIL,COMPANY_PHONE,COMPANY_LETTER,COMPANY_TOTAL_CASH,COMPANY_CASH_NUM)
Values('막장주식','김갑판','jjjj@nate.com','01020304050','01022334456',1000000,'235-3538-3538-38');


/*이벤트정보*/
Insert into TB_EVENT (EVENT, COMPANY_ID, EVE_START_DATE,CS_COUNT,DB_PRICE,EVE_STATE,CS_NOTE)
Values('얼굴을타일처럼','막장주식',now(),0,20000,1,'테스트');

/*이벤트 신청정보*/
Insert into TB_EVE_REQ (USER_ID, CS_TIME, CS_DATE,CS_STATE,EVENT,COMPANY_ID)
Values('홍길순','16:00~17:00',now(),1,'얼굴을타일처럼','막장주식');

/*충전금 내역*/
Insert into TB_COMPANY_CASH (COMPANY_ID, CHAR_CASH, CHAR_DATE,TAKE_PRICE,TAKE_DATE)
Values('막장주식',20000,now(),10000,now());