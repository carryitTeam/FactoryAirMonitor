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
-- Table structure for table `deviceconfig`
--

DROP TABLE IF EXISTS `deviceconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deviceconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appEui` varchar(100) NOT NULL,
  `devEui` varchar(100) NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `groupId` int(11) DEFAULT '-1',
  `deviceType` varchar(45) DEFAULT NULL,
  `deviceName` varchar(45) DEFAULT NULL,
  `deviceComment` varchar(100) DEFAULT NULL,
  `parentId` int(11) DEFAULT '-1',
  `devicePort` varchar(45) DEFAULT '0',
  PRIMARY KEY (`appEui`,`devEui`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deviceconfig`
--

LOCK TABLES `deviceconfig` WRITE;
/*!40000 ALTER TABLE `deviceconfig` DISABLE KEYS */;
INSERT INTO `deviceconfig` VALUES (5,'1234','1234','2018-05-13 20:22:08',4,'device','xxx公司XXx设备','1234',-1,'8080'),(2,'23434','11111111','2018-05-13 11:43:41',-1,'sensor','test','test1231',5,'0'),(4,'2c26c5045c000002','4a77006600288a','2018-05-13 20:08:28',-1,'sensor','气体传感器','气体传感器',3,'0'),(1,'asdfasd','sdfas','2018-05-13 10:51:13',7,'device','unknown','test',-1,'0'),(3,'asdfasdf','asdfasdfasd','2018-05-13 18:35:00',2,'device','known','test',-1,'0');
/*!40000 ALTER TABLE `deviceconfig` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-14 23:21:49
