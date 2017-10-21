drop table if exists `schedule`;
drop table if exists `timesheet`;


============================================

drop table if exists `staff`;
drop table if exists `client`;
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
  `addr_id`         int(11) NOT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `addr_id_fk1` (`addr_id`),
  CONSTRAINT FOREIGN KEY (`addr_id`)
  REFERENCES `address` (`addr_id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20001 DEFAULT CHARSET=latin1;


CREATE TABLE `client` (
  `client_id`       int(11) NOT NULL auto_increment,
  `first_name`      varchar(25) NOT NULL,
  `last_name`       varchar(30) NOT NULL,
  `birth_dt`        date NOT NULL DEFAULT '1900-01-01',
  `phone_nr`        varchar(15) NOT NULL,
  `email`           varchar(50) DEFAULT NULL,
  `bill_cd`         varchar(03) NOT NULL,
  `addr_id`         int(11) NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `addr_id_fk2` (`addr_id`),
  CONSTRAINT FOREIGN KEY (`addr_id`)
  REFERENCES `address` (`addr_id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30001 DEFAULT CHARSET=latin1;

insert into `address` VALUES (10001,"121 Intellij Ave","Madison","WI","53701");
insert into `address` VALUES (10002,"122 Intellij St","Madison","WI","53702");
insert into `address` VALUES (10003,"123 Intellij Rd","Madison","WI","53703");
insert into `address` VALUES (10004,"124 Intellij Pkwy","Madison","WI","53704");
insert into `address` VALUES (10005,"2101 Java World","Madison","WI","53718");
insert into `address` VALUES (10006,"2102 Java Ct","Cottage Grove","WI","53527");
insert into `address` VALUES (10007,"2103 Java St","Sun Prairie","WI","53590");
insert into `address` VALUES (10008,"2104 Java Ln","Lake Mills","WI","53551");
insert into `address` VALUES (10009,"2104 Java Ln","Lake Mills","WI","53551");
insert into `address` VALUES (10010,"2105 Java Ln","Lake Mills","WI","53551");
insert into `address` VALUES (10011,"2105 Java Ln","Lake Mills","WI","53551");
insert into `address` VALUES (10012,"2105 Java Ln","Lake Mills","WI","53551");

insert into `staff` VALUES (20000,"Dumb","Dummy",'1969-01-01',"(608) 101-1001","cacosta@abovecare.com","S01","Care Giver",10001);
insert into `staff` VALUES (20001,"Corazon","Acosta",'1969-01-01',"(608) 101-1001","cacosta@abovecare.com","S01","Care Giver",10002);
insert into `staff` VALUES (20002,"Leah","Bagunu",'1969-02-01',"(608) 101-1002","lbagunu@abovecare.com","S02","Lic Pract Nurse",10003);
insert into `staff` VALUES (20003,"Catherine","Baricaua",'1969-03-01',"(608) 101-1003","cbaricaua@abovecare.com","S03","Care Giver",10004);
insert into `staff` VALUES (20004,"Audrey","Bautista",'1969-04-01',"(608) 101-1004","abautista@abovecare.com","S04","Reg Nurse",10005);
insert into `staff` VALUES (20005,"Rowena","Castaneda",'1969-04-01',"(608) 101-1004","abautista@abovecare.com","S05","Cert Nurse Asst",10006);

insert into `client` VALUES (30000,"Dumb","Dumber",'1950-01-01',"(608) 909-9001","abc1@xyz.com","C01",10007);
insert into `client` VALUES (30001,"John","Smith",'1950-01-01',"(608) 909-9001","abc1@xyz.com","C01",10008);
insert into `client` VALUES (30002,"Mary","Johnson",'1940-02-01',"(608) 909-9002","abc2@xyz.com","C02",10009);
insert into `client` VALUES (30003,"Patricia","Brown",'1941-03-01',"(608) 909-9003","abc3@xyz.com","C01",10010);
insert into `client` VALUES (30004,"Barbara","Tucker",'1955-04-01',"(608) 909-9004","abc4@xyz.com","C02",10011);
insert into `client` VALUES (30005,"Charles","Williams",'1941-05-01',"(608) 909-9005","abc5@xyz.com","C03",10012);


====================================================================================================================








CREATE TABLE `schedule` (
  `sched_id`        int(11) NOT NULL auto_increment,
  `time_days`       varchar(60) NOT NULL,
  `client_id`       int(11) NOT NULL,
  `staff_id`        int(11) NOT NULL,
  PRIMARY KEY (`sched_id`),

  KEY `client_id` (`client_id`),
  CONSTRAINT FOREIGN KEY (`client_id`)
    REFERENCES `client` (`client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  KEY `staff_id` (`staff_id`),
  CONSTRAINT FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`staff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40001 DEFAULT CHARSET=latin1;


CREATE TABLE `timesheet` (
  `time_id`         int(11) NOT NULL auto_increment,
  `hours_worked`    int(2) DEFAULT 0,
  `staff_id`        int(11) DEFAULT NULL,
  PRIMARY KEY (`time_id`),

  KEY `staff_id` (`staff_id`),
  FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`staff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50001 DEFAULT CHARSET=latin1;





insert into `address` VALUES (10001,"121 Intellij Ave","Madison","WI","53701");
insert into `address` VALUES (10002,"122 Intellij St","Madison","WI","53702");
insert into `address` VALUES (10003,"123 Intellij Rd","Madison","WI","53703");
insert into `address` VALUES (10004,"124 Intellij Pkwy","Madison","WI","53704");
insert into `address` VALUES (10005,"2101 Java World","Madison","WI","53718");
insert into `address` VALUES (10006,"2102 Java Ct","Cottage Grove","WI","53527");
insert into `address` VALUES (10007,"2103 Java St","Sun Prairie","WI","53590");
insert into `address` VALUES (10008,"2104 Java Ln","Lake Mills","WI","53551");

insert into `client` VALUES (30000,"Dumb","Dumber",'1950-01-01',"(608) 909-9001","abc1@xyz.com","C01",10001);
insert into `client` VALUES (30001,"John","Smith",'1950-01-01',"(608) 909-9001","abc1@xyz.com","C01",10002);
insert into `client` VALUES (30002,"Mary","Johnson",'1940-02-01',"(608) 909-9002","abc2@xyz.com","C02",10003);
insert into `client` VALUES (30003,"Patricia","Brown",'1941-03-01',"(608) 909-9003","abc3@xyz.com","C01",10004);
insert into `client` VALUES (30004,"Barbara","Tucker",'1955-04-01',"(608) 909-9004","abc4@xyz.com","C02",10005);
insert into `client` VALUES (30005,"Charles","Williams",'1941-05-01',"(608) 909-9005","abc5@xyz.com","C03",10006);

insert into `staff` VALUES (20001,"Corazon","Acosta",'1969-01-01',"(608) 101-1001","cacosta@abovecare.com","S01","Care Giver",10001);
insert into `staff` VALUES (20002,"Leah","Bagunu",'1969-02-01',"(608) 101-1002","lbagunu@abovecare.com","S02","Lic Pract Nurse",10002);
insert into `staff` VALUES (20003,"Catherine","Baricaua",'1969-03-01',"(608) 101-1003","cbaricaua@abovecare.com","S03","Care Giver",10003);
insert into `staff` VALUES (20004,"Audrey","Bautista",'1969-04-01',"(608) 101-1004","abautista@abovecare.com","S04","Reg Nurse",10004);
insert into `staff` VALUES (20005,"Rowena","Castaneda",'1969-04-01',"(608) 101-1004","abautista@abovecare.com","S05","Cert Nurse Asst",10005);


insert into `schedule` VALUES (40001,"6-8A MW",30001,20001);
insert into `schedule` VALUES (40002,"1-4P M-SU",30002,20002);
insert into `schedule` VALUES (40003,"10-12A TTH",30003,20003);
insert into `schedule` VALUES (40004,"5-7P SASU",30003,20004);
insert into `schedule` VALUES (40005,"6-8A MWF",30004,20004);
insert into `schedule` VALUES (40006,"6-8A TTH SASU",30005,20004);

insert into `timesheet` VALUES (50001,36,20001);
insert into `timesheet` VALUES (50002,20,20002);
insert into `timesheet` VALUES (50003,24,20003);
insert into `timesheet` VALUES (50004,15,20004);
insert into `timesheet` VALUES (50005,30,20005);

