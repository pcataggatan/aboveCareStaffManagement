-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: abovecare
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `staff`
--
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `staff`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (`staff_id` int(11) NOT NULL AUTO_INCREMENT,`first_name` varchar(25) NOT NULL,`last_name` varchar(30) NOT NULL,`birth_dt` date NOT NULL DEFAULT '1900-01-01',`st_addr1` varchar(40) NOT NULL,`st_addr2` varchar(40) DEFAULT NULL,`city` varchar(25) NOT NULL,`state` varchar(2) NOT NULL,`zipcode` varchar(5) NOT NULL,`phone_nr` varchar(15) NOT NULL,`email` varchar(50) DEFAULT NULL,`pay_cd` varchar(3) NOT NULL,`hours_worked` int(2) NOT NULL DEFAULT '0',PRIMARY KEY (`staff_id`)) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`staff_id`, `first_name`, `last_name`, `birth_dt`, `st_addr1`, `st_addr2`, `city`, `state`, `zipcode`, `phone_nr`, `email`, `pay_cd`, `hours_worked`) VALUES (10001,'Corazon','Acosta','1969-01-01','123 Intellij Avenue',NULL,'Madison','WI','53701','(608) 101-1001','cacosta@abovecare.com','S01',0),(10002,'Leah','Bagunu','1969-02-01','123 Intellij Lane',NULL,'Madison','WI','53702','(608) 101-1002','lbagunu@abovecare.com','S02',0),(10003,'Catherine','Baricaua','1969-03-01','123 Intellij St',NULL,'Madison','WI','53703','(608) 101-1003','cbaricaua@abovecare.com','S03',0),(10004,'Audrey','Bautista','1969-04-01','123 Intellij Rd',NULL,'Madison','WI','53704','(608) 101-1004','abautista@abovecare.com','S04',0),(10005,'Rowena','Castaneda','1969-04-01','123 Intellij Rd',NULL,'Sun Prairie','WI','53590','(608) 101-1004','abautista@abovecare.com','S05',0);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-07 23:55:27

-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: abovecare
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (`client_id` int(11) NOT NULL AUTO_INCREMENT,`first_name` varchar(25) NOT NULL,`last_name` varchar(30) NOT NULL,`birth_dt` date NOT NULL DEFAULT '1900-01-01',`st_addr1` varchar(40) NOT NULL,`st_addr2` varchar(40) DEFAULT NULL,`city` varchar(25) NOT NULL,`state` varchar(2) NOT NULL,`zipcode` varchar(5) NOT NULL,`phone_nr` varchar(15) NOT NULL,`email` varchar(50) DEFAULT NULL,`bill_cd` varchar(3) NOT NULL,`staff_id` int(11) DEFAULT NULL,`sched1` varchar(25) DEFAULT NULL,`sched2` varchar(25) DEFAULT NULL,`sched3` varchar(25) DEFAULT NULL,PRIMARY KEY (`client_id`),KEY `fk_staffT` (`staff_id`),CONSTRAINT `fk-staff` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)) ENGINE=InnoDB AUTO_INCREMENT=50006 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`client_id`, `first_name`, `last_name`, `birth_dt`, `st_addr1`, `st_addr2`, `city`, `state`, `zipcode`, `phone_nr`, `email`, `bill_cd`, `staff_id`, `sched1`, `sched2`, `sched3`) VALUES (50000,'Dumb','Dumber','1950-01-01','123 Java Word',NULL,'Madison','WI','53718','(608) 909-9001','abc1@xyz.com','C01',NULL,NULL,NULL,NULL),(50001,'John','Smith','1950-01-01','123 Java Lane',NULL,'Madison','WI','53718','(608) 909-9001','abc1@xyz.com','C01',10001,'6-8a M/W/F',NULL,NULL),(50002,'Mary','Johnson','1940-02-01','123 Java Ct',NULL,'Cottage Grove','WI','53527','(608) 909-9002','abc2@xyz.com','C02',10002,'8-10a M/W/F',NULL,NULL),(50003,'Patricia','Brown','1941-03-01','1234 Java Rd',NULL,'Sun Prairie','WI','53590','(608) 909-9003','abc3@xyz.com','C01',10002,'1-4p T/Th/Sa',NULL,NULL),(50004,'Barbara','Tucker','1955-04-01','123 Java Pkwy',NULL,'De Forest','WI','53532','(608) 909-9004','abc4@xyz.com','C02',10003,'5-8a M/T/W','5-7p Th/F',NULL),(50005,'Charles','Williams','1941-05-01','123A Java St',NULL,'Lake Mills','WI','53551','(608) 909-9005','abc5@xyz.com','C03',10004,'6-10a M-Su',NULL,NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-07 23:56:45
