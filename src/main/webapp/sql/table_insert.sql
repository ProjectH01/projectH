create TABLE TB_USER_INFO(/*회원정보*/
USER_ID VARCHAR(50) PRIMARY KEY /* 유저아이디*/
,USER_NAME VARCHAR(20) NOT NULL /* 이름 */
,USER_PHONE VARCHAR(30) NOT NULL /* 폰번호*/
,USER_SEX	VARCHAR(10) NOT NULL /* 성별 */
,USER_AGE	INTEGER     NOT NULL /* 연령 */
,USER_POINT	INTEGER   DEFAULT 0  /* 포인트 */
);

select * from TB_USER_INFO;

CREATE TABLE TB_COMPANY_INFO(/*회사,기획자 정보*/
COMPANY_ID VARCHAR(50) PRIMARY KEY /*기획자 아이디 */
,COMPANY_NAME VARCHAR(50) NOT NULL /* 상호명,이름 */	
,COMPANY_EMAIL VARCHAR(50) NOT NULL /* 이메일 */
,COMPANY_PHONE VARCHAR(30) NOT NULL	/*전화상담번호*/
,COMPANY_LETTER	VARCHAR(30) NOT NULL	/*문자상담번호*/
,COMPANY_TOTAL_CASH INTEGER DEFAULT 0 /*총 충전금액*/
,COMPANY_CASH_NUM VARCHAR(30) 	/*기관계좌번호*/
);

alter table TB_COMPANY_INFO add COMPANY_PWD varchar(50) not null;
describe TB_COMPANY_INFO;
select * from TB_COMPANY_INFO;
update TB_COMPANY_INFO set company_total_cash=300000 where company_id='admin';

CREATE TABLE TB_EVENT(/*이벤트 테이블*/
EVENT VARCHAR(100) PRIMARY KEY /*이벤트명(PK)*/	
,COMPANY_ID	VARCHAR(50) /*아이디(PK)(FK)*/	
,EVE_START_DATE	DATE /*이벤트 시작일*/	
,CS_COUNT	INTEGER /*상담건수*/	
,DB_PRICE	INTEGER /*DB단가*/	
,EVE_STATE	INTEGER /*상태(시작/종료)*/	
,CS_NOTE	VARCHAR(100)/*비고*/
);

alter table TB_EVENT add BANNER_IMAGE varchar(100);
alter table TB_EVENT add DETAIL_IMAGE varchar(100);


select * from TB_EVENT;

update TB_EVENT set company_id='admin' where db_price=20000


CREATE TABLE TB_EVE_REQ(/*이벤트 신청*/
USER_ID	VARCHAR(50) /*아이디(FK)*/
,CS_TIME	VARCHAR(20) NOT NULL/*상담요청시간*/
,CS_DATE	DATE NOT NULL/*신청일*/
,CS_STATE	INTEGER DEFAULT 0/*CS현황(신규,재상담)*/
,EVENT	VARCHAR(100) NOT NULL/*이벤트명(FK)*/
,COMPANY_ID	VARCHAR(50) NOT NULL/*상호 아이디(FK)*/
);

select * from TB_EVE_REQ;

CREATE TABLE TB_COMPANY_CASH(/*충전금 내역*/
COMPANY_ID	VARCHAR(50) PRIMARY KEY/*아이디(PK)*/	
,CHAR_CASH	INTEGER /*충전금액*/	
,CHAR_DATE	DATE /*충전날짜*/	
,TAKE_PRICE	INTEGER /*차감금액*/	
,TAKE_DATE	DATE /*차감날짜*/	
);

select * from TB_COMPANY_INFO;
drop table TB_EVE_REQ;
