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


insert into `address` VALUES (10000,"100 Dummy St","Madison","WI","53701");
insert into `address` VALUES (10001,"121 Anderson Ave","Madison","WI","53704");
insert into `address` VALUES (10002,"232 Bluebird Ct","Madison","WI","53714");
insert into `address` VALUES (10003,"343 Cambridge Rd","Madison","WI","53703");
insert into `address` VALUES (10004,"454 Diamond Dr","Madison","WI","53718");
insert into `address` VALUES (10005,"565 Edgehill Pky","Madison","WI","53794");
insert into `address` VALUES (10006,"676 Fairfax Ln","Madison","WI","53726");
insert into `address` VALUES (10007,"787 Gingergrass Wy","Madison","WI","53713");
insert into `address` VALUES (10008,"898 Heartland Trl","Madison","WI","53711");
insert into `address` VALUES (10009,"123 Idledale Cir","Madison","WI","53719");
insert into `address` VALUES (10010,"234 Jenewein Rd","Sun Prairie","WI","53596");
insert into `address` VALUES (10011,"345 Karmichael Ct","Sun Prairie","WI","53596");
insert into `address` VALUES (10012,"456 Lakeview Blvd","Sun Prairie","WI","53590");
insert into `address` VALUES (10013,"678 Manitowoc Pky","Sun Prairie","WI","53590");
insert into `address` VALUES (10014,"789 Newhaven Cir","Lake Mills","WI","53551");
insert into `address` VALUES (10015,"102 Oakridge Ave","Waterloo","WI","53594");
insert into `address` VALUES (10016,"203 Parkwood St","Johnson Creek","WI","53038");
insert into `address` VALUES (10017,"304 Quarterdeck Dr","Fort Atkinson","WI","53538");
insert into `address` VALUES (10018,"405 Ridgewood Wy","Dodgeville","WI","53595");
insert into `address` VALUES (10019,"506 Silverstone Ln","Dodgeville","WI","53533");
insert into `address` VALUES (10020,"607 Twilight Trl","Mineral Point","WI","53565");
insert into `address` VALUES (10021,"708 Underdahl Rd","Highland","WI","53543");
insert into `address` VALUES (10022,"908 Virginia Ter","Black Earth","WI","53515");
insert into `address` VALUES (10023,"607 Walbridge Ave","Cambridge","WI","53523");
insert into `address` VALUES (10024,"708 Yellowcress Dr","Middleton","WI","53562");
insert into `address` VALUES (10025,"908 Zuercher Ct","Verona","WI","53593");
insert into `address` VALUES (10026,"999 Dummy St","Madison","WI","53701");

insert into `staff` VALUES (20000,"Dummy","Staff",'1969-01-01',"(608)101-1000","dummy@abovecare.com","S01","Care Giver",0.0,null,"6-8am MWF",10000);
insert into `staff` VALUES (20001,"Pablo","Cataggatan",'1969-01-01',"(608)101-1001","pcataggatan@abovecare.com","S01","Care Giver",0.0,null,"6-8am MWF",10001);
insert into `staff` VALUES (20002,"Corazon","Acosta",'1969-02-01',"(608)101-1002","cacosta@abovecare.com","S02","Care Giver",0.0,null,"7-10am M-F; 5-8pm TTh",10003);
insert into `staff` VALUES (20003,"Leah","Bagunu",'1969-03-01',"(608)101-1003","lbagunu@abovecare.com","S03","Lic Pract Nurse",0.0,null,"6-10pm MWThSu",10006);
insert into `staff` VALUES (20004,"Cathy","Guingab",'1969-04-01',"(608)101-1004","cbaricaua@abovecare.com","S04","Care Giver",0.0,null,"10-12am M-F",10008);
insert into `staff` VALUES (20005,"Audrey","Bautista",'1969-05-01',"(608)101-1005","abautista@abovecare.com","S05","Reg Nurse",0.0,null,"7-10am MW; 6-8am TTh; 1-4 SSu",10010);
insert into `staff` VALUES (20006,"Rowena","Castaneda",'1969-06-01',"(608)101-1006","rcastaneda@abovecare.com","S06","Cert Nurse Asst",0.0,null,"5-9pm MWFS",10014);
insert into `staff` VALUES (20007,"Rosalinda","Saquing",'1969-07-01',"(608)101-1007","rsaquing@abovecare.com","S07","Cert Nurse Asst",0.0,null,"5-8am MWFS",10016);
insert into `staff` VALUES (20008,"Jesusa","Beltran",'1969-08-01',"(608)101-1008","jbeltran@abovecare.com","S08","Lic Pract Nurse",0.0,null,"6-10pm M-S",10018);
insert into `staff` VALUES (20009,"Almarie","Quilang",'1969-09-01',"(608)101-1009","aquilang@abovecare.com","S09","Care Giver",0.0,null,"4-8pm TWFS",10020);
insert into `staff` VALUES (20010,"Vrenelli","Velasco",'1969-10-01',"(608)101-1010","vvelasco@abovecare.com","S10","Reg Nurse",0.0,null,"7-9am M-F",10022);
insert into `staff` VALUES (20011,"Emily","Jacinto",'1969-11-01',"(608)101-1011","ejacinto@abovecare.com","S11","Reg Nurse",0.0,null,"6-9am M-Su",10024);

insert into `client` VALUES (30000,"Dummy","Client",'1950-01-01',"(608)909-9000","abc0@xyz.com","C01",null,10026,20000);
insert into `client` VALUES (30001,"John","Smith",'1951-01-01',"(608)909-9001","bcd1@xyz.com","C01",null,10002,20001);
insert into `client` VALUES (30002,"Mary","Jensen",'1940-02-01',"(608)909-9002","cde2@xyz.com","C02",null,10004,20002);
insert into `client` VALUES (30003,"Patricia","Brown",'1941-03-01',"(608)909-9003","def3@xyz.com","C03",null,10005,20002);
insert into `client` VALUES (30004,"Barbara","Lewis",'1955-04-01',"(608)909-9004","efg4@xyz.com","C04",null,10007,20003);
insert into `client` VALUES (30005,"Charles","Williams",'1953-05-01',"(608)909-9005","fgh5@xyz.com","C05",null,10009,20004);
insert into `client` VALUES (30006,"Trevor","Mulder",'1954-06-01',"(608)909-9006","ghi6@xyz.com","C06",null,10011,20005);
insert into `client` VALUES (30007,"Stephanie","Knapp",'1955-07-01',"(608)909-9007","hij7@xyz.com","C07",null,10012,20005);
insert into `client` VALUES (30008,"Shanna","Reynolds",'1944-07-01',"(608)909-9008","jkl8@xyz.com","C08",null,10013,20005);
insert into `client` VALUES (30009,"Matthew","Allen",'1945-07-01',"(608)909-9009","klm9@xyz.com","C09",null,10015,20006);
insert into `client` VALUES (30010,"Desiree","Odom",'1946-07-01',"(608)909-9010","mno10@xyz.com","C02",null,10017,20007);
insert into `client` VALUES (30011,"Barry","Palmer",'1947-07-01',"(608)909-9011","opq11@xyz.com","C04",null,10019,20008);
insert into `client` VALUES (30012,"Tracy","Schroeder",'1950-07-01',"(608)909-9012","qrs12@xyz.com","C06",null,10021,20009);
insert into `client` VALUES (30013,"Paul","Nigel",'1951-07-01',"(608)909-9013","stu13@xyz.com","C08",null,10023,20010);
insert into `client` VALUES (30014,"Michelle","Lundquist",'1952-07-01',"(608)909-9014","tuv14@xyz.com","C11",null,10025,20011);

