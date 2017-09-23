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
);

insert into staff VALUES
(1
,"Corazon"
,"Acosta"
,'1950-01-01'
,"123 Intellij Avenue"
,NULL
,"Madison"
,"WI"
,"53704"
,"(608) 101-1001"
,"corazon@abovecare.com"
,"Care Giver"
,"S01"
,"2017-01-01"
,NULL
);

