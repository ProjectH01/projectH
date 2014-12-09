ALTER DATABASE projecth CHARACTER SET utf8 COLLATE utf8_general_ci;
/*DB언어를 UTF-8로 설정*/

/**/
create table test(
test_no int primary key
,test_name varchar(30) not null
);

insert into test values(1,'테스트');

