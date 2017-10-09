drop table if exists `sched`;
drop table if exists `assignment`;
drop table if exists `client`;
drop table if exists `staff`;

create table staff (
     staff_id        int(11) NOT NULL auto_increment,
     first_name      varchar(25) NOT NULL,
     last_name       varchar(30) NOT NULL,
     birth_date      date NOT NULL,
     st_addr1        varchar(40) NOT NULL,
     st_addr2        varchar(40) DEFAULT NULL,
     city            varchar(25) NOT NULL,
     state           varchar(2) NOT NULL,
     zipcode         varchar(5) NOT NULL,
     phone_nr        varchar(15) NOT NULL,
     email           varchar(60) DEFAULT NULL,
     job_title        varchar(30) NOT NULL,
     rate_cd         varchar(03) NOT NULL,
     eff_dt          date NOT NULL ,
     end_dt          date DEFAULT NULL,
     PRIMARY KEY  (staff_id)
); ENGINE=INNODB;

create table client (
     client_id       int(11) NOT NULL auto_increment,
     first_name      varchar(25) NOT NULL,
     last_name       varchar(30) NOT NULL,
     birth_date      date NOT NULL,
     st_addr1        varchar(40) NOT NULL,
     st_addr2        varchar(40) DEFAULT NULL,
     city            varchar(25) NOT NULL,
     state           varchar(2) NOT NULL,
     zipcode         varchar(5) NOT NULL,
     phone_nr        varchar(15) NOT NULL,
     email           varchar(60) DEFAULT NULL,
     rate_cd         varchar(03) NOT NULL,
     eff_dt          date NOT NULL,
     end_dt          date DEFAULT NULL,
     PRIMARY KEY  (client_id)
) ENGINE=INNODB;

create table assignment (
     assign_id       int(11) NOT NULL auto_increment,
     staff_id        int(11) NOT NULL,
     client_id       int(11) NOT NULL,
     PRIMARY KEY  (assign_id),
     INDEX fk_staff (staff_id),
     INDEX fk_client (client_id),
     CONSTRAINT fk_staff
     FOREIGN KEY (staff_id)
     REFERENCES staff (staff_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE,
     CONSTRAINT fk_client
     FOREIGN KEY (client_id)
     REFERENCES client (client_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
) ENGINE=INNODB;

create table sched (
     sched_id        int(11) NOT NULL auto_increment,
     assign_id       int(11) NOT NULL,
     start_tm        TIME NOT NULL,
     end_tm          TIME NOT NULL,
     days_of_wk      varchar(10) NOT NULL,
     PRIMARY KEY (sched_id),
     INDEX fk_assign (assign_id),
     CONSTRAINT fk_assign
     FOREIGN KEY (assign_id)
     REFERENCES assignment (assign_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
) ENGINE=INNODB;


insert into staff VALUES (10001,"Corazon","Acosta",'1969-01-01',"123 Intellij Avenue",NULL,"Madison","WI","53701","(608) 101-1001","cacosta@abovecare.com","Care Giver","S01",'2017-01-01',NULL);
insert into staff VALUES (10002,"Leah","Bagunu",'1969-02-01',"123 Intellij Lane",NULL,"Madison","WI","53702","(608) 101-1002","lbagunu@abovecare.com","Care Giver","S02",'2017-01-01',NULL);
insert into staff VALUES (10003,"Catherine","Baricaua",'1969-03-01',"123 Intellij St",NULL,"Madison","WI","53703","(608) 101-1003","cbaricaua@abovecare.com","Care Giver","S02",'2017-01-01',NULL);
insert into staff VALUES (10004,"Audrey","Bautista",'1969-04-01',"123 Intellij Rd",NULL,"Madison","WI","53704","(608) 101-1004","abautista@abovecare.com","Care Giver","S02",'2017-01-01',NULL);
insert into staff VALUES (10005,"Rowena","Castaneda",'1969-04-01',"123 Intellij Rd",NULL,"Sun Prairie","WI","53590","(608) 101-1004","abautista@abovecare.com","Care Giver","S01",'2017-01-01',NULL);

insert into client VALUES (20000,"Dumb","Dumber",'1950-01-01',"123 Java Word",NULL,"Madison","WI","53718","(608) 909-9001","abc1@xyz.com","C01",'2017-01-01',NULL);
insert into client VALUES (20001,"John","Smith",'1950-01-01',"123 Java Lane",NULL,"Madison","WI","53718","(608) 909-9001","abc1@xyz.com","C01",'2017-01-01',NULL);
insert into client VALUES (20002,"Mary","Johnson",'1940-02-01',"123 Java Ct",NULL,"Cottage Grove","WI","53527","(608) 909-9002","abc2@xyz.com","C02",'2017-01-01',NULL);
insert into client VALUES (20003,"Patricia","Brown",'1941-03-01',"1234 Java Rd",NULL,"Sun Prairie","WI","53590","(608) 909-9003","abc3@xyz.com","C01",'2017-01-01',NULL);
insert into client VALUES (20004,"Barbara","Tucker",'1955-04-01',"123 Java Pkwy",NULL,"De Forest","WI","53532","(608) 909-9004","abc4@xyz.com","C02",'2017-01-01',NULL);
insert into client VALUES (20005,"Charles","Williams",'1941-05-01',"123A Java St",NULL,"Lake Mills","WI","53551","(608) 909-9005","abc5@xyz.com","C03",'2017-01-01',NULL);

insert into assignment VALUES (30001,10001,20001);
insert into assignment VALUES (30002,10002,20002);
insert into assignment VALUES (30003,10003,20003);
insert into assignment VALUES (30004,10004,20003);
insert into assignment VALUES (30005,10005,20004);
insert into assignment VALUES (30006,10005,20005);

insert into sched VALUES (40001,30001,'6:00','9:00',"MWF");
insert into sched VALUES (40002,30002,'8:00','10:00',"MWF");
insert into sched VALUES (40003,30002,'4:00','6:00',"TThSa");
insert into sched VALUES (40004,30003,'7:00','9:00',"MWF");
insert into sched VALUES (40005,30004,'7:00','9:00',"TTh");
insert into sched VALUES (40006,30005,'8:00','10:00',"MWF");
insert into sched VALUES (40007,30006,'8:00','10:00',"MWF");



