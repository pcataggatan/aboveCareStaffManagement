drop table if exists `client`;

create table client (
     client_id       int(11) NOT NULL auto_increment,
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
     rate_cd         varchar(03),
     eff_dt          date,
     end_dt          date,
     PRIMARY KEY  (client_id)
 );

insert into client VALUES
(1
,"John"
,"Smith"
,'1950-01-01'
,"123 Java Lane"
,NULL
,"Madison"
,"WI"
,"53718"
,"(608) 123-4567"
,"abc@xyz.com"
,"C01"
,"2017-01-01"
,NULL
);

