

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

create table customerDetails(ssnId number(9) primary key,
customerName varchar2(30) not null,customerId number(9),
age number(2) not null,
addressLine1 varchar2(100),
addressLine2 varchar2(100),
city varchar2(50),state varchar2(20));

insert into customerDetails values(123456789,'paru',seq_custId.nextval,24,'erebrb','rtrhtj','kochi','kerala');


create sequence seq_custId 
start with 1 increment by 1

create table customerStatus(ssnId number(9) not null,
customerId number(15) not null primary key,
customerStatus varchar2(50) not null,
message varchar2(100),
lastUpdated timestamp);


select * from customerStatus

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

delete from ACCOUNTDETAILS where accountType='Select'
select * from ACCOUNTDETAILS

insert into ACCOUNTDETAILS values(2,seq_acntId.nextval,'Current',7000,'In progress','Account Creation','2012-01-12 10:11:00');

select accountType from accountDetails where customerId=1

select * from accountDetails where customerId=1 and accountType='Current'

update accountDetails set accountStatus='Completed',lastUpdated=current_timestamp where customerId=1 and accountId=41;

update accountDetails set accountStatus='Completed',lastUpdated=current_timestamp where customerId=? and accountId=?";

select current_timestamp-lastUpdated as difference from ACCOUNTDETAILS where accountId=102

  SELECT EXTRACT(HOUR FROM TIMESTAMP '2012-01-12 10:11:00') FROM dual;
  
 select extract(hour from (current_timestamp-lastUpdated))hrs from ACCOUNTDETAILS where accountId=102;
 select customerId,accountId,accountType,amount from accountDetails where customerId=266 and accountType='Savings'
  