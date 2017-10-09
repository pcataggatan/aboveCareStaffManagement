
drop table if exists `client`;
drop table if exists `staff`;

CREATE TABLE `staff` (
`staff_id`        int(11) NOT NULL auto_increment,
`first_name`      varchar(25) NOT NULL,
`last_name`       varchar(30) NOT NULL,
`birth_dt`        date NOT NULL DEFAULT '1900-01-01',
`st_addr1`        varchar(40) NOT NULL,
`st_addr2`        varchar(40) DEFAULT NULL,
`city`            varchar(25) NOT NULL,
`state`           varchar(2) NOT NULL,
`zipcode`         varchar(5) NOT NULL,
`phone_nr`        varchar(15) NOT NULL,
`email`           varchar(50) DEFAULT NULL,
`pay_cd`          varchar(03) NOT NULL,
`hours_worked`    int(2) NOT NULL DEFAULT 0,
PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=latin1;

CREATE TABLE `client` (
`client_id`       int(11) NOT NULL auto_increment,
`first_name`      varchar(25) NOT NULL,
`last_name`       varchar(30) NOT NULL,
`birth_dt`        date NOT NULL DEFAULT '1900-01-01',
`st_addr1`        varchar(40) NOT NULL,
`st_addr2`        varchar(40) NULL DEFAULT NULL,
`city`            varchar(25) NOT NULL,
`state`           varchar(2) NOT NULL,
`zipcode`         varchar(5) NOT NULL,
`phone_nr`        varchar(15) NOT NULL,
`email`           varchar(50) DEFAULT NULL,
`bill_cd`         varchar(03) NOT NULL,
`staff_id`        int(11) NULL DEFAULT NULL,
`sched1`          varchar(25) NULL DEFAULT NULL,
`sched2`          varchar(25) NULL DEFAULT NULL,
`sched3`          varchar(25) NULL DEFAULT NULL,
PRIMARY KEY (`client_id`),
INDEX `fk_staffT` (`staff_id`),
CONSTRAINT `fk-staff`
FOREIGN KEY (`staff_id`)
REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50001 DEFAULT CHARSET=latin1;


insert into `staff` VALUES (10001,"Corazon","Acosta",'1969-01-01',"123 Intellij Avenue",NULL,"Madison","WI","53701","(608) 101-1001","cacosta@abovecare.com","S01",0);
insert into `staff` VALUES (10002,"Leah","Bagunu",'1969-02-01',"123 Intellij Lane",NULL,"Madison","WI","53702","(608) 101-1002","lbagunu@abovecare.com","S02",0);
insert into `staff` VALUES (10003,"Catherine","Baricaua",'1969-03-01',"123 Intellij St",NULL,"Madison","WI","53703","(608) 101-1003","cbaricaua@abovecare.com","S03",0);
insert into `staff` VALUES (10004,"Audrey","Bautista",'1969-04-01',"123 Intellij Rd",NULL,"Madison","WI","53704","(608) 101-1004","abautista@abovecare.com","S04",0);
insert into `staff` VALUES (10005,"Rowena","Castaneda",'1969-04-01',"123 Intellij Rd",NULL,"Sun Prairie","WI","53590","(608) 101-1004","abautista@abovecare.com","S05",0);

insert into `client` VALUES (50000,"Dumb","Dumber",'1950-01-01',"123 Java Word",NULL,"Madison","WI","53718","(608) 909-9001","abc1@xyz.com","C01",NULL,NULL,NULL,NULL);
insert into `client` VALUES (50001,"John","Smith",'1950-01-01',"123 Java Lane",NULL,"Madison","WI","53718","(608) 909-9001","abc1@xyz.com","C01",10001,"6-8a M/W/F",NULL,NULL);
insert into `client` VALUES (50002,"Mary","Johnson",'1940-02-01',"123 Java Ct",NULL,"Cottage Grove","WI","53527","(608) 909-9002","abc2@xyz.com","C02",10002,"8-10a M/W/F",NULL,NULL);
insert into `client` VALUES (50003,"Patricia","Brown",'1941-03-01',"1234 Java Rd",NULL,"Sun Prairie","WI","53590","(608) 909-9003","abc3@xyz.com","C01",10002,"1-4p T/Th/Sa",NULL,NULL);
insert into `client` VALUES (50004,"Barbara","Tucker",'1955-04-01',"123 Java Pkwy",NULL,"De Forest","WI","53532","(608) 909-9004","abc4@xyz.com","C02",10003,"5-8a M/T/W","5-7p Th/F",NULL);
insert into `client` VALUES (50005,"Charles","Williams",'1941-05-01',"123A Java St",NULL,"Lake Mills","WI","53551","(608) 909-9005","abc5@xyz.com","C03",10004,"6-10a M-Su",NULL,NULL);

