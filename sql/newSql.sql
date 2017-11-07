drop table if exists `client`;
drop table if exists `staff`;
drop table if exists `address`;


CREATE TABLE `address` (
  `addr_id`         int(11) NOT NULL auto_increment,
  `street`          varchar(40) NOT NULL,
  `city`            varchar(25) NOT NULL,
  `state`           varchar(2) NOT NULL,
  `zipcode`         varchar(5) NOT NULL,
  PRIMARY KEY (`addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=latin1;


CREATE TABLE `staff` (
  `staff_id`        int(11) NOT NULL auto_increment,
  `first_name`      varchar(25) NOT NULL,
  `last_name`       varchar(30) NOT NULL,
  `birth_dt`        date NOT NULL DEFAULT '1900-01-01',
  `phone_nr`        varchar(15) NOT NULL,
  `email`           varchar(50) DEFAULT NULL,
  `pay_cd`          varchar(03) NOT NULL,
  `job_title`       varchar(20) NOT NULL,
  `distance`        double (9,2) DEFAULT 0.0,
  `hourly_rate`     VARCHAR (6) DEFAULT NULL,
  `schedule`        VARCHAR(50) DEFAULT NULL,
  `addr_id`         int(11) NOT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `addr_id_fk` (`addr_id`),
    CONSTRAINT FOREIGN KEY (`addr_id`)
    REFERENCES `address` (`addr_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20001 DEFAULT CHARSET=latin1;


CREATE TABLE `client` (
  `client_id`       int(11) NOT NULL auto_increment,
  `first_name`      varchar(25) NOT NULL,
  `last_name`       varchar(30) NOT NULL,
  `birth_dt`        date NOT NULL DEFAULT '1900-01-01',
  `phone_nr`        varchar(15) NOT NULL,
  `email`           varchar(50) DEFAULT NULL,
  `bill_cd`         varchar(03) NOT NULL,
  `hourly_rate`     VARCHAR (6) DEFAULT NULL,
  `addr_id`         int(11) NOT NULL,
  `staff_id`       int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `addr_id_fk` (`addr_id`),
    CONSTRAINT FOREIGN KEY (`addr_id`)
    REFERENCES `address` (`addr_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  KEY `staff_id_fk` (`staff_id`),
    CONSTRAINT FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`staff_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30001 DEFAULT CHARSET=latin1;


insert into `address` VALUES (10001,"1021 Intellij Ave","Madison","WI","53701");
insert into `address` VALUES (10002,"1022 Intellij St","Madison","WI","53702");
insert into `address` VALUES (10003,"1023 Intellij Rd","Madison","WI","53703");
insert into `address` VALUES (10004,"1024 Intellij Pkwy","Madison","WI","53704");
insert into `address` VALUES (10005,"2101 Java Ave","Madison","WI","53718");
insert into `address` VALUES (10006,"2102 Java Ct","Cottage Grove","WI","53527");
insert into `address` VALUES (10007,"2103 Java St","Sun Prairie","WI","53590");
insert into `address` VALUES (10008,"2104 Java Ln","Lake Mills","WI","53551");
insert into `address` VALUES (10009,"2105 Java Rd","Madison","WI","53705");
insert into `address` VALUES (10010,"2106 Java Cir","Madison","WI","53705");
insert into `address` VALUES (10011,"2107 Java Pkwy","Madison","WI","53706");
insert into `address` VALUES (10012,"2108 Java Ln","Madison","WI","53707");
insert into `address` VALUES (10013,"2109 Java St","Madison","WI","53708");
insert into `address` VALUES (10014,"2110 Java Dr","Madison","WI","53709");

insert into `staff` VALUES (20000,"Dummmy","Staff",'1969-01-01',"(608)101-1001","cacosta@abovecare.com","S01","Care Giver",0.0,null,"6-8am MWF",10001);
insert into `staff` VALUES (20001,"Pablo","Cataggatan",'1969-01-01',"(608)101-1001","cacosta@abovecare.com","S03","Care Giver",0.0,null,null,10002);
insert into `staff` VALUES (20002,"Corazon","Acosta",'1969-01-01',"(608)101-1001","cacosta@abovecare.com","S02","Care Giver",0.0,null,null,10003);
insert into `staff` VALUES (20003,"Leah","Bagunu",'1969-02-01',"(608)101-1002","lbagunu@abovecare.com","S04","Lic Pract Nurse",0.0,null,"6-10pm MWThSu",10004);
insert into `staff` VALUES (20004,"Catherine","Baricaua",'1969-03-01',"(608)101-1003","cbaricaua@abovecare.com","S05","Care Giver",0.0,null,"10-12am M-F / 1-5pm SSu",10005);
insert into `staff` VALUES (20005,"Audrey","Bautista",'1969-04-01',"(608)101-1004","abautista@abovecare.com","S06","Reg Nurse",0.0,null,"7-10am TThS",10006);
insert into `staff` VALUES (20006,"Rowena","Castaneda",'1969-04-01',"(608)101-1004","abautista@abovecare.com","S07","Cert Nurse Asst",0.0,null,"5-9pm MWFS",10007);

insert into `client` VALUES (30000,"Dummy","Client",'1950-01-01',"(608)909-9001","abc1@xyz.com","C01",null,10008,20001);
insert into `client` VALUES (30001,"John","Smith",'1950-01-01',"(608)909-9001","abc1@xyz.com","C05",null,10009,null);
insert into `client` VALUES (30002,"Mary","Johnson",'1940-02-01',"(608)909-9002","abc2@xyz.com","C02",null,10010,20003);
insert into `client` VALUES (30003,"Patricia","Brown",'1941-03-01',"(608)909-9003","abc3@xyz.com","C01",null,10011,20004);
insert into `client` VALUES (30004,"Barbara","Tucker",'1955-04-01',"(608)909-9004","abc4@xyz.com","C07",null,10012,20005);
insert into `client` VALUES (30005,"Charles","Williams",'1941-05-01',"(608)909-9005","abc5@xyz.com","C09",null,10013,20005);
insert into `client` VALUES (30006,"Aaron","Briggs",'1951-05-01',"(608)909-9006","abc6@xyz.com","C06",null,10014,20006);



====================================================================================================================

CREATE TABLE `schedule` (
  `sched_id`        int(11) NOT NULL auto_increment,
  `times_of_day`    varchar(30) NOT NULL,
  `days_of_week`    varchar(30) NOT NULL,
  `staff_id`        int(11) NOT NULL,
  PRIMARY KEY (`sched_id`),

  KEY `staff_id_fk` (`staff_id`),
  CONSTRAINT FOREIGN KEY (`staff_id`)
  REFERENCES `staff` (`staff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40001 DEFAULT CHARSET=latin1;


insert into `schedule` VALUES (40001,"6-8am","MWF",20001);
insert into `schedule` VALUES (40002,"8-10am","TTh",20001);
insert into `schedule` VALUES (40003,"7-10am","MTFS",20002);
insert into `schedule` VALUES (40004,"10-12am","TThSSu",20003);
insert into `schedule` VALUES (40005,"3-5pm","M-F",20004);
insert into `schedule` VALUES (40006,"5-7pm","SSu",20004);
insert into `schedule` VALUES (40007,"2-5pm","MTThF",20005);
insert into `schedule` VALUES (40008,"6-8am","MWF",20006);
insert into `schedule` VALUES (40009,"1-4pm","T",20006);

----------------------------------------------------------------------------

CREATE TABLE `timesheet` (
  `time_id`         int(11) NOT NULL auto_increment,
  `week_period`     date NOT NULL DEFAULT '2000-01-01',
  `hours_worked`    int(2) DEFAULT 0,
  `staff_id`        int(11) DEFAULT NULL,
  PRIMARY KEY (`time_id`),

  KEY `staff_id` (`staff_id`),
  FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`staff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50001 DEFAULT CHARSET=latin1;


insert into `timesheet` VALUES (50001,'2000-01-01',36,20001);
insert into `timesheet` VALUES (50002,'2000-01-01',20,20002);
insert into `timesheet` VALUES (50003,'2000-01-01',24,20003);
insert into `timesheet` VALUES (50004,'2000-01-01',15,20004);
insert into `timesheet` VALUES (50005,'2000-01-01',30,20005);
insert into `timesheet` VALUES (50006,'2000-01-01',28,20006);

