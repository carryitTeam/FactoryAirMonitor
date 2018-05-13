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
-- Table structure for table `alarm`
--

DROP TABLE IF EXISTS `alarm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alarm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `devEui` varchar(100) DEFAULT NULL,
  `level` varchar(100) DEFAULT NULL,
  `devEuiRelate` varchar(100) DEFAULT NULL,
  `RelateNames` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `changeTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarm`
--

LOCK TABLES `alarm` WRITE;
/*!40000 ALTER TABLE `alarm` DISABLE KEYS */;
INSERT INTO `alarm` VALUES (1,'4a77006600288a','1','test1','test1name','N','2018-04-12 23:21:53','2018-04-12 23:21:53'),(2,'dd','1','ddd','dd','dd','2018-04-14 14:44:12',NULL),(3,'4a77006600288a','1','4a77006600288a','4a77006600288a','y','2018-04-14 15:01:20',NULL),(4,'4a77006600288a','2','4a77006600288a111','4a77006600288a111','n','2018-04-14 15:04:25',NULL),(5,'4a77006600288a','1','4a77006600288a1234','4a77006600288asdfsdfsd','n','2018-04-14 15:11:13',NULL),(6,'4a7700660036a7','1','4a7700660036a7erer','4a7700660036a72345','n','2018-04-14 15:13:19',NULL),(7,'4a7700660036a7','3','4a7700660036a71234234','4a7700660036a712341234','n','2018-04-14 15:16:11',NULL),(8,'4a7700660036a7','7','4a7700660036a7111111','4a7700660036a72323423','n','2018-04-14 15:18:13','2018-04-14 15:18:13');
/*!40000 ALTER TABLE `alarm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-13 21:52:20