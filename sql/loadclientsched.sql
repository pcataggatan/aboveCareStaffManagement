drop table if exists `sched`;
drop table if exists `client`;

create table client (
     client_id       int(11) NOT NULL auto_increment,
     first_name      varchar(25) NOT NULL,
     last_name       varchar(30) NOT NULL,
     birth_date      date NOT NULL,
     st_addr1        varchar(40) NOT NULL,
     st_addr2        varchar(40),
     city            varchar(25) NOT NULL,
     state           varchar(2) NOT NULL,
     zipcode         varchar(5) NOT NULL,
     phone_nr        varchar(15) NOT NULL,
     email           varchar(60),
     rate_cd         varchar(03) NOT NULL,
     eff_dt          date NOT NULL,
     end_dt          date,
     PRIMARY KEY  (client_id)
 ) ENGINE=INNODB;


insert into client VALUES (90000,"Open","Client",'1900-01-01',"111 Java World",NULL,"Madison","WI","53704","(608) 900-9000","abc0@xyz.com","C00",'2017-01-01',NULL);
insert into client VALUES (90001,"John","Smith",'1950-01-01',"123 Java Lane",NULL,"Madison","WI","53718","(608) 909-9001","abc1@xyz.com","C01",'2017-01-01',NULL);
insert into client VALUES (90002,"Mary","Johnson",'1940-02-01',"123 Java Ct",NULL,"Cottage Grove","WI","53527","(608) 909-9002","abc2@xyz.com","C02",'2017-01-01',NULL);
insert into client VALUES (90003,"Patricia","Brown",'1941-03-01',"1234 Java Rd",NULL,"Sun Prairie","WI","53590","(608) 909-9003","abc3@xyz.com","C01",'2017-01-01',NULL);
insert into client VALUES (90004,"Barbara","Tucker",'1955-04-01',"123 Java Pkwy",NULL,"De Forest","WI","53532","(608) 909-9004","abc4@xyz.com","C02",'2017-01-01',NULL);
insert into client VALUES (90005,"Charles","Williams",'1941-05-01',"123A Java St",NULL,"Lake Mills","WI","53551","(608) 909-9005","abc5@xyz.com","C03",'2017-01-01',NULL);


create table sched (
     sched_id        int(11) NOT NULL auto_increment,
     staff_id        int(11) NOT NULL,
     client_id       int(11) NOT NULL,
     days_of_wk      varchar(7),
     start_tm        TIME NOT NULL,
     end_tm          TIME NOT NULL,
     FOREIGN KEY (staff_id)
     REFERENCES staff (staff_id)
          ON DELETE CASCADE,
     FOREIGN KEY (client_id)
     REFERENCES client (client_id)
          ON DELETE CASCADE,
     PRIMARY KEY  (sched_id)
) ENGINE=INNODB;


insert into sched VALUES (1,10001,90001, "135", '6:00', '9:00');
insert into sched VALUES (2,10001,90000, "135", '13:00', '18:00');
insert into sched VALUES (3,10001,90000, "2467", '6:00', '18:00');
