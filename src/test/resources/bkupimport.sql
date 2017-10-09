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

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (`client_id` int(11) NOT NULL AUTO_INCREMENT,`first_name` varchar(25) NOT NULL,`last_name` varchar(30) NOT NULL,`birth_date` date NOT NULL,`st_addr1` varchar(40) NOT NULL,`st_addr2` varchar(40) DEFAULT NULL,`city` varchar(25) NOT NULL,`state` varchar(2) NOT NULL,`zipcode` varchar(5) NOT NULL,`phone_nr` varchar(15) NOT NULL,`email` varchar(60) DEFAULT NULL,`rate_cd` varchar(3) NOT NULL,`eff_dt` date NOT NULL,`end_dt` date DEFAULT NULL,PRIMARY KEY (`client_id`)) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`client_id`, `first_name`, `last_name`, `birth_date`, `st_addr1`, `st_addr2`, `city`, `state`, `zipcode`, `phone_nr`, `email`, `rate_cd`, `eff_dt`, `end_dt`) VALUES (20000,'Dumb','Dumber','1950-01-01','123 Java Word',NULL,'Madison','WI','53718','(608) 909-9001','abc1@xyz.com','C01','2017-01-01',NULL),(20001,'John','Smith','1950-01-01','123 Java Lane',NULL,'Madison','WI','53718','(608) 909-9001','abc1@xyz.com','C01','2017-01-01',NULL),(20002,'Mary','Johnson','1940-02-01','123 Java Ct',NULL,'Cottage Grove','WI','53527','(608) 909-9002','abc2@xyz.com','C02','2017-01-01',NULL),(20003,'Patricia','Brown','1941-03-01','1234 Java Rd',NULL,'Sun Prairie','WI','53590','(608) 909-9003','abc3@xyz.com','C01','2017-01-01',NULL),(20004,'Barbara','Tucker','1955-04-01','123 Java Pkwy',NULL,'De Forest','WI','53532','(608) 909-9004','abc4@xyz.com','C02','2017-01-01',NULL),(20005,'Charles','Williams','1941-05-01','123A Java St',NULL,'Lake Mills','WI','53551','(608) 909-9005','abc5@xyz.com','C03','2017-01-01',NULL);
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

-- Dump completed on 2017-10-07  3:13:51
