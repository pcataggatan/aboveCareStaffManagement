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
 ); ENGINE=INNODB;

insert into client VALUES
(90000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

insert into client VALUES
(90001,"John","Smith",'1950-01-01',"123 Java Lane",NULL,"Madison","WI","53718"
,"(608) 909-9001","abc1@xyz.com","C01",'2017-01-01',NULL);

insert into client VALUES
(90002,"Mary","Johnson",'1940-02-01',"123 Java Ct",NULL,"Cottage Grove","WI","53527"
,"(608) 909-9002","abc2@xyz.com","C02",'2017-01-01',NULL);

insert into client VALUES
(90003,"Patricia","Brown",'1941-03-01',"1234 Java Rd",NULL,"Sun Prairie","WI","53590"
,"(608) 909-9003","abc3@xyz.com","C01",'2017-01-01',NULL);

insert into client VALUES
(90004,"Barbara","Tucker",'1955-04-01',"123 Java Pkwy",NULL,"De Forest","WI","53532"
,"(608) 909-9004","abc4@xyz.com","C02",'2017-01-01',NULL);

insert into client VALUES
(90005,"Charles","Williams",'1941-05-01',"123A Java St",NULL,"Lake Mills","WI","53551"
,"(608) 909-9005","abc5@xyz.com","C03",'2017-01-01',NULL);

