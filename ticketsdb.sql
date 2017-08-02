-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ticketsdb
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `EventID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Place` varchar(45) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `OnlineFee` int(11) NOT NULL,
  PRIMARY KEY (`EventID`),
  UNIQUE KEY `EventID_UNIQUE` (`EventID`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=1000046 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1000038,'WANDERLAND 2017 MUSIC & ARTS FESTIVAL','Filinvest City Event Grounds Alabang','Attractions','With thousands of festival goers each year, Wanderland has since become one of the most awaited musi',50),(1000039,'Neverland Manila 2016','Mall of Asia Concert Grounds','Music & Concerts','It has been our pleasure and pride to be able to bring the list of international DJs to you and Manila.',100),(1000042,'PBA PHILIPPINE CUP','Mall of Asia Arena','Sports','PHOENIX FUEL MASTERS vs STAR HOTSHOTS',50),(1000043,'THE WONDERFUL WORLD OF DISNEY ON ICE','MOA Arena','Family','Disney on ICE!',100),(1000044,'Paramount Care','MedAsia Hospitals','Others','Get guaranteed prompt medical treatment with PARAMOUNT\'S ER CARD 700',20);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitem` (
  `TransID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TicketID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
INSERT INTO `lineitem` VALUES (50,9,9000043),(50,10,9000042),(51,1,9000050),(51,1,9000051),(51,1,9000052),(51,1,9000053),(51,1,9000054),(51,1,9000055),(51,1,9000056),(51,1,9000057),(52,10,9000044),(52,9,9000045),(52,8,9000046),(52,7,9000047),(52,7,9000048),(55,10,9000050),(56,10,9000042),(56,10,9000043),(59,1,9000044),(59,2,9000045),(59,3,9000046),(59,4,9000047),(60,2,9000050),(60,2,9000051),(61,1,9000050),(62,1,9000050),(63,1,9000044),(64,6,9000044),(65,10,9000042),(65,10,9000043),(66,3,9000050),(66,6,9000051),(66,9,9000052),(67,2,9000050),(67,2,9000051),(68,3,9000042),(68,4,9000043),(69,10,9000044),(70,8,9000044),(80,9,9000050),(80,8,9000051),(80,7,9000052),(80,9,9000050),(80,8,9000051),(80,7,9000052),(82,5,9000043),(83,3,9000043),(84,1,9000057),(85,1,9000044),(85,3,9000045),(86,9,9000044),(86,8,9000045),(91,5,9000061),(94,5,9000067),(94,4,9000068),(94,3,9000069),(95,4,9000050),(95,4,9000051);
/*!40000 ALTER TABLE `lineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtime`
--

DROP TABLE IF EXISTS `showtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showtime` (
  `ShowID` int(11) NOT NULL AUTO_INCREMENT,
  `DateTime` datetime NOT NULL,
  `EventID` int(11) NOT NULL,
  PRIMARY KEY (`ShowID`),
  UNIQUE KEY `ShowID_UNIQUE` (`ShowID`)
) ENGINE=InnoDB AUTO_INCREMENT=5000048 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime`
--

LOCK TABLES `showtime` WRITE;
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` VALUES (5000040,'2017-03-04 13:00:00',1000038),(5000041,'2016-12-09 16:00:00',1000039),(5000042,'2016-12-10 17:00:00',1000042),(5000043,'2016-12-25 11:00:00',1000043),(5000044,'2016-12-25 15:00:00',1000043),(5000045,'2016-12-25 19:00:00',1000043),(5000046,'2016-12-30 19:00:00',1000043),(5000047,'2016-12-31 10:00:00',1000044);
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `TicketID` int(11) NOT NULL AUTO_INCREMENT,
  `TicketName` varchar(45) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `ShowID` int(11) NOT NULL,
  PRIMARY KEY (`TicketID`),
  UNIQUE KEY `TicketID_UNIQUE` (`TicketID`)
) ENGINE=InnoDB AUTO_INCREMENT=9000071 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (9000042,'Wanderbuddies',19350,50000,5000040),(9000043,'Wanderer',5915,492,5000040),(9000044,'VIP 2 Day Pass',6000,990,5000041),(9000045,'VIP Day 1 Pass',6000,989,5000041),(9000046,'VIP Day 2 Pass',6000,1000,5000041),(9000047,'GOLD 2 Day Pass',5800,1000,5000041),(9000048,'Gold Day 1 Pass',3500,1000,5000041),(9000049,'Gold Day 2 Pass',3500,1000,5000041),(9000050,'PATRON VIP',950,238,5000042),(9000051,'PATRON A',800,480,5000042),(9000052,'PATRON B',750,486,5000042),(9000053,'LOWER BOX A',500,1000,5000042),(9000054,'LOWER BOX B',450,1000,5000042),(9000055,'LOWER BOX C',400,1000,5000042),(9000056,'UPPER BOX',175,2000,5000042),(9000057,'GENERAL ADMISSION',75,1999,5000042),(9000058,'SVIP',5000,250,5000043),(9000059,'VIP',4000,500,5000043),(9000060,'General Admission',190,1000,5000043),(9000061,'SVIP',5000,245,5000044),(9000062,'VIP',4000,500,5000044),(9000063,'General Admission',190,1000,5000044),(9000064,'SVIP',5000,250,5000045),(9000065,'VIP',4000,250,5000045),(9000066,'General Admission',190,1000,5000045),(9000067,'SVIP',5000,245,5000046),(9000068,'VIP',4000,246,5000046),(9000069,'General Admission',190,997,5000046),(9000070,'ER CARD 700',700,15000,5000047);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `TransDateTime` datetime NOT NULL,
  `total` double NOT NULL,
  `BuyerID` varchar(45) NOT NULL,
  PRIMARY KEY (`TransactionID`),
  UNIQUE KEY `TransactionID_UNIQUE` (`TransactionID`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (55,'2016-04-08 21:28:27',10000,'User'),(56,'2016-05-08 21:28:38',253650,'User'),(59,'2016-06-08 21:30:14',62700,'User'),(60,'2016-07-08 22:09:39',3700,'User'),(61,'2016-08-08 23:39:58',1000,'User'),(62,'2016-09-08 23:41:03',1000,'Admin'),(63,'2016-10-08 23:41:11',9050,'Admin'),(64,'2016-01-09 00:02:33',54300,'User'),(65,'2016-02-09 00:12:52',253650,'User'),(66,'2016-11-09 00:51:44',15300,'User'),(67,'2016-01-09 00:59:45',3700,'Admin'),(68,'2016-03-09 01:00:11',82060,'Admin'),(69,'2016-03-09 03:13:09',61000,'Admin'),(70,'2016-12-09 03:41:59',48800,'User'),(80,'2016-12-09 04:15:36',42800,'User'),(82,'2016-12-09 04:21:19',29825,'User'),(83,'2016-12-09 04:22:05',17895,'User'),(84,'2016-12-09 04:25:54',125,'User'),(85,'2016-12-09 04:26:27',24400,'User'),(86,'2016-10-09 05:27:00',103700,'User'),(94,'2016-05-09 07:27:24',42770,'User'),(95,'2016-12-09 07:34:39',7400,'User');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Username` varchar(45) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `MiddleName` varchar(40) DEFAULT NULL,
  `Password` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `MobileNum` bigint(20) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Country` varchar(40) NOT NULL,
  `State` varchar(40) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `CivilStatus` varchar(9) NOT NULL,
  `Type` varchar(5) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `MobileNum_UNIQUE` (`MobileNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Admin','Ong','Nixon','San Buena','admin','nixon_sb17@yahoo.com',9157331127,'805 Masangkay','Philippines','NCR','1998-11-27','Male','Separated','Admin'),('Bill123','Gates','Bill',NULL,'billisnumber1','bill@microsoft.com',7573545354,'32A Shibuya','Japan','Hokkaido','1966-06-06','Male','Married','Admin'),('BlackWidow','Widow','Black ','Johansson','scarlett','bw1@avengers.com',6553453452,'Forbidden Palace','China','Xi Zhuan','1982-05-31','Female','Widowed','User'),('JohnSmith1','Smith','John','','js1','johnsmith1@yahoo.com',23423442443,'737 Boeing','Russia','Moscow','1999-01-01','Male','Widowed','User'),('User','Ive','John','HAHA','user','ive@apple.com',3422534345,'1 Infinite Loop','USA','CA','1998-09-02','Male','Single','User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-09  8:02:28
