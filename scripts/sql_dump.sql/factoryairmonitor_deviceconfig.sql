-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 47.96.185.51    Database: factoryairmonitor
-- ------------------------------------------------------
-- Server version	5.6.40

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
  `devEui` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `groupId` int(11) DEFAULT '-1',
  `deviceType` varchar(45) DEFAULT NULL,
  `deviceName` varchar(45) DEFAULT NULL,
  `deviceComment` varchar(100) DEFAULT NULL,
  `parentId` int(11) DEFAULT '-1',
  `devicePort` varchar(45) DEFAULT '0',
  `deviceLevel` varchar(45) DEFAULT '1',
  `payload` varchar(200) DEFAULT NULL,
  `alertField` varchar(45) DEFAULT 'unknown',
  `alertNumber` decimal(10,2) DEFAULT '1000000.00',
  `leftX` int(11) DEFAULT '100',
  `topY` int(11) DEFAULT '50',
  `excludeAlert` varchar(45) DEFAULT 'yes',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deviceconfig`
--

LOCK TABLES `deviceconfig` WRITE;
/*!40000 ALTER TABLE `deviceconfig` DISABLE KEYS */;
INSERT INTO `deviceconfig` VALUES (1,'2c26c5045c000002','4a770066003091','2018-06-23 21:15:09',1,'device','XXX传感器','XXXdd',-1,NULL,'1',NULL,'unknown',1000000.00,280,269,'no'),(3,'2c26c5045c000002','4a7700660030b1','2018-06-23 21:17:55',-1,'sensor','XXX联动设备',NULL,1,'10','2','6B000303FF209016  ','40015',1000.00,91,110,'yes');
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

-- Dump completed on 2018-07-01 16:14:04
