create table Login(
	login_id varchar(10),
	password varchar(10)
	
);



select ssnId,customerId,customerName,age,concat((concat((concat(addressLine1,', ')),(concat(addressLine2,', ')))),city) as address from customerDetails where ssnId=121212 and customerId=104

select * from accountStatus where customerId=104;

delete  from accountStatus

		update accountDetails set amount =2000 where accountId=42;

select * from ACCOUNTDETAILS

select seq_acntId.nextval from dual


delete from transactionDetails where accountId=61
delete from accountDetails where customerId=207 and accountId=61

select * from accountDetails where customerId=509
select * from accountStatus
select customerId from customerDetails where customerId=8752
create table accountDetails(customerId number(15)not null,
accountId number(15)not null primary key,
accountType varchar2(50) not null,amount number(12),
accountStatus varchar2(50)not null,
message varchar2(100),
lastUpdated timestamp);
select customerId from customerDetails where customerId=207

select * from accountDetails

select accountId from accountStatus


insert into Login values('sumanth','yadav');
select * from Login

create table customerDetails(ssnId number(9) primary key,
customerName varchar2(30) not null,customerId number(9),
age number(2) not null,
addressLine1 varchar2(100),
addressLine2 varchar2(100),
city varchar2(50),state varchar2(20));
--display the customer id after creation--

alter table customerDetails add lastUpdated timestamp;

select*from customerDetails;
select * from ACCOUNTDETAILS

create table customerStatus(ssnId number(9) not null,
customerId number(15) not null primary key,
customerStatus varchar2(50) not null,
lastUpdated timestamp,
foreign key(ssnId)references customerDetails(ssnId));


select*from customerStatus;


insert into customerStatus values (121212,104,'active',CURRENT_TIMESTAMP);

delete from customerStatus


create sequence cus_id
start with 100
increment by 1;

create table accountStatus(customerId number(15)not null,
accountId number(15)not null primary key,
accountType varchar2(50) not null,
accountStatus varchar2(50)not null,
message varchar2(100),
accountBalance number(20),
lastUpdated timestamp,
foreign key(customerId)references customerStatus(customerId));
insert into ACCOUNTSTATUS values(104,5,'Savings','In Progress','hello',1000,current_timestamp)
insert into ACCOUNTSTATUS values(104,6,'Current','In Progress','hello',1000,current_timestamp)


create sequence acc_id
start with 1000
increment by 1;

select * from accountstatus;

update accountStatus set accountBalance = (accountBalance+3000) where accountId= 1001;


create table userStore(loginId varchar2(20) primary key,
password varchar2(20) not null,
time_stamp timestamp,
userType varchar2(15) not null)

alter table userStore
add constraint checktype check(userType='executive' or userType='cashier' or userType='teller');

insert into userStore values(1,'aa',current_timestamp,'executive');
insert into userStore values(2,'bb',current_timestamp,'cashier');
insert into userStore values(3,'cc',current_timestamp,'teller');
insert into userStore values(4,'dd',current_timestamp,'cashier');


insert into userStore values(1334820,'parvathy')

create table customerDetails(ssnId number(9) primary key,
customerName varchar2(30) not null,customerId number(9),
age number(2) not null,
addressLine1 varchar2(100),
addressLine2 varchar2(100),
city varchar2(50),state varchar2(20));

insert into customerDetails values(3456,'paru',110,24,'erebrb','rtrhtj','kochi','kerala',current_timestamp);

select * from ACCOUNTDETAILS where customerId=104
create sequence seq_custId 
start with 1 increment by 1

create table customerStatus(ssnId number(9) not null,
customerId number(15) not null primary key,
customerStatus varchar2(50) not null,
message varchar2(100),
lastUpdated timestamp);


select * from customerDetails

alter table customerStatus
add constraint fkeycust foreign key(ssnId)references customerDetails(ssnId);

insert into CUSTOMERSTATUS values(123456789,2,'active','msg',current_timestamp);


create table accountDetails(customerId number(15)not null,
accountId number(15)not null primary key,
accountType varchar2(50) not null,amount number(12),
accountStatus varchar2(50)not null,
message varchar2(100),
lastUpdated timestamp);

alter table accountDetails
add constraint fkeyacnt foreign key(customerId)references customerStatus(customerId);

create sequence seq_acntId 
start with 1 increment by 1

insert into customerDetails values(112345,'vani',seq_custId.nextval,25,'ghg','gfyf','kochi','ekm');
select * from CUSTOMERDETAILS
insert into customerStatus values(112345,1,'active','in progress',current_timestamp);

delete from ACCOUNTDETAILS where accountId=123
select * from ACCOUNTDETAILS

select * from TRANSACTIONDETAILS

DELETE FROM TRANSACTIONDETAILS WHERE ACCOUNTID=121

insert into ACCOUNTDETAILS values(2,seq_acntId.nextval,'Current',7000,'In progress','Account Creation','2012-01-12 10:11:00');

select accountType from accountDetails where customerId=1

select * from accountDetails where customerId=1 and accountType='Current'

update accountDetails set accountStatus='Completed',lastUpdated=current_timestamp where customerId=1 and accountId=41;

update accountDetails set accountStatus='Completed',lastUpdated=current_timestamp where customerId=? and accountId=?";

select current_timestamp-lastUpdated as difference from ACCOUNTDETAILS where accountId=102

  SELECT EXTRACT(HOUR FROM TIMESTAMP '2012-01-12 10:11:00') FROM dual;
  
 select extract(hour from (current_timestamp-lastUpdated))hrs from ACCOUNTDETAILS where accountId=102;
  

create table transactionDetails(
transactionId number(5) primary key,
DandT timestamp,
transactionType varchar(10) check(transactionType in('credit','debit')),
accountId number(10) not null,
balance number(10) not null,

foreign key(accountId)references accountDetails(accountId)
);

update accountStatus set accountBalance = (accountBalance+200) where accountId = 1023;

create sequence transac_id
start with 2000 
increment by 10;

alter table transactionDetails
drop column message;

select * from transactionDetails;

select accountBalance from accountStatus where accountId = 2356;








select * from USERSTORE

create table userStore(loginId varchar2(20) primary key,
password varchar2(20) not null,
time_stamp timestamp,
userType varchar2(15) not null)

alter table userStore
add constraint checktype check(userType='executive' or userType='cashier' or userType='teller');

insert into userStore values(1,'aa',current_timestamp,'executive');
insert into userStore values(2,'bb',current_timestamp,'cashier');
insert into userStore values(3,'cc',current_timestamp,'teller');
insert into userStore values(4,'dd',current_timestamp,'cashier');













delete from accountStatus where accountId = 1020;
select*from TRANSACTIONDETAILS where accountId=1040 and DandT>'2017-12-19 08:00:00:000'
select * from transactionDetails where accountId=1023 and DandT>='2017-12-18 08:00:00:000' and DantT<='2017-12-20' and order by DandT desc;
select * from transactionDetails where accountId=1040 and DandT>to_timestamp('19-12-2017', 'dd-mm-yyyy') order by DandT desc;


select * from transactionDetails where accountId=1023 and (DandT>='12-10-2017') ;

select * from transactionDetails where accountId = 1023 and DandT between '2017/12/18' and '2017/12/20';


update accountStatus set accountBalance = accountBalance + 1000 where accountId= 1001;

select accountBalance from accountStatus where accountId = 1020;-- and accountId = 1020;