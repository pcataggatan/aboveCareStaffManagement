drop table if exists `staff`;

create table staff (
  staff_id        int(11) NOT NULL auto_increment,
  first_name      varchar(25),
  last_name       varchar(30),
  birth_date      date,
  st_addr1        varchar(40),
  st_addr2        varchar(40),
  city            varchar(25),
  state           varchar(2),
  zipcode         varchar(5),
  phone_nr        varchar(15),
  email           varchar(60),
  job_title        varchar(30),
  rate_cd         varchar(03),
  eff_dt          date,
  end_dt          date,
  PRIMARY KEY  (staff_id)
); ENGINE=INNODB;

insert into staff VALUES
(10001,"Corazon","Acosta",'1969-01-01',"123 Intellij Avenue",NULL,"Madison","WI","53701"
  ,"(608) 101-1001","cacosta@abovecare.com","Care Giver","S01",'2017-01-01',NULL);

insert into staff VALUES
(10002,"Leah","Bagunu",'1969-02-01',"123 Intellij Lane",NULL,"Madison","WI","53702"
,"(608) 101-1002","lbagunu@abovecare.com","Care Giver","S02",'2017-01-01',NULL);

insert into staff VALUES
(10003,"Catherine", "Baricaua",'1969-03-01',"123 Intellij St",NULL,"Madison","WI","53703"
,"(608) 101-1003","cbaricaua@abovecare.com","Care Giver","S02",'2017-01-01',NULL);

insert into staff VALUES
(10004, "Audrey", "Bautista",'1969-04-01',"123 Intellij Rd",NULL,"Madison","WI","53704"
,"(608) 101-1004","abautista@abovecare.com","Care Giver","S02",'2017-01-01',NULL);

insert into staff VALUES
(10005,"Rowena", "Castaneda",'1969-04-01',"123 Intellij Rd",NULL,"Sun Prairie","WI","53590"
,"(608) 101-1004","abautista@abovecare.com","Care Giver","S01",'2017-01-01',NULL);
