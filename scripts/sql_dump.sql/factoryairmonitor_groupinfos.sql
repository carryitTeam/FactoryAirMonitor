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
  `factoryDiagramPath` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupinfos`
--

LOCK TABLES `groupinfos` WRITE;
/*!40000 ALTER TABLE `groupinfos` DISABLE KEYS */;
INSERT INTO `groupinfos` VALUES (1,'武汉市XXX公司','武汉市江夏区藏龙大道100号',NULL,'2018-06-23 21:12:48','2018-07-01 11:26:30','大奔','111111111','http://5b0988e595225.cdn.sohucs.com/images/20170907/73a47a287e63440192d173f5d317891b.jpeg'),(2,'武汉新能源研究院','武汉市东湖新技术开发区未来科技城',NULL,'2018-06-27 14:34:21','2018-07-01 11:52:54','罗小盛','23211253556','http://5b0988e595225.cdn.sohucs.com/images/20170907/73a47a287e63440192d173f5d317891b.jpeg');
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

-- Dump completed on 2018-07-01 16:14:06
