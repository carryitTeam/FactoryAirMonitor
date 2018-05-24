-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: factoryairmonitor
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `groupinfos`
--

DROP TABLE IF EXISTS `groupinfos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupinfos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(100) DEFAULT NULL,
  `groupLocation` varchar(200) DEFAULT NULL,
  `groupComment` varchar(1000) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `changeTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `contactUserName` varchar(45) DEFAULT NULL,
  `contactTelephoneNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupinfos`
--

LOCK TABLES `groupinfos` WRITE;
/*!40000 ALTER TABLE `groupinfos` DISABLE KEYS */;
INSERT INTO `groupinfos` VALUES (1,'公司a','北京-四环','asdfasdf','2018-05-12 11:05:48','2018-05-12 14:27:40','张三','13800000000'),(2,'公司b','上海','asdfasd','2018-05-12 11:05:48','2018-05-12 11:05:48','李四','13811111111'),(3,'公司c','武汉','asdfasd','2018-05-12 12:02:39','2018-05-12 12:02:39','王五','13822222222'),(4,'公司ad','北京','asdfasdf','2018-05-12 11:05:48','2018-05-12 14:13:46','张三','13800000000'),(5,'公司b2','上海-浦东','asdfasd','2018-05-12 11:05:48','2018-05-12 14:25:17','李是是是','13811111111'),(6,'公司cd','武汉','asdfasd','2018-05-12 12:02:39','2018-05-12 12:02:39','王五','13822222222'),(7,'carryit','上海-长宁区',NULL,NULL,'2018-05-12 14:36:14','hlzou','1111111111111111111111'),(8,'carry','shanghai',NULL,'2018-05-12 14:36:57','2018-05-12 14:36:57','zhl','123412341234'),(9,'asdf','dfdf',NULL,'2018-05-12 16:59:34','2018-05-12 16:59:34','asdf','12341234'),(10,'asd','asdf',NULL,'2018-05-12 17:18:43','2018-05-12 17:18:43','asdf','asdf');
/*!40000 ALTER TABLE `groupinfos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-25  3:01:46
