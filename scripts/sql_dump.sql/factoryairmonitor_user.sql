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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) NOT NULL,
  `userPwd` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userRole` varchar(20) DEFAULT NULL,
  `appEui` varchar(100) DEFAULT NULL,
  `changeTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `groupId` int(11) DEFAULT '-1',
  PRIMARY KEY (`userId`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (17,'1111111111 ','333333','11111111111','44444','user',NULL,'2018-05-12 18:09:33','2018-03-04 12:14:45',1),(16,'1234','1234','1234','124dddd','user',NULL,'2018-05-12 18:09:45','2018-03-04 11:56:09',1),(13,'admin','admin','admin','admin@qq.com','superAdmin',NULL,'2018-03-03 20:07:14','2018-03-03 20:07:14',5),(10,'hai','123456','hai','hai@cc.com','user',NULL,'2018-05-12 18:10:05','2018-03-03 20:05:52',7),(18,'hlzou','123456','zouhailin','598871671@qq.com','admin',NULL,'2018-05-12 18:15:00','2018-05-12 18:15:00',4),(11,'lin','123456','lin','lin@qq.com','user','123456','2018-03-03 20:06:09','2018-03-03 20:06:09',7),(14,'user1','123456','user1','user1@qq.com','user','2c26c5045c000002','2018-03-03 20:08:21','2018-03-03 20:08:21',6),(19,'zhl123','123456','hlzou','598871671@qq.com','user',NULL,'2018-05-25 02:35:30','2018-05-25 02:35:30',2),(12,'zou','123456','zou','zou@qq.com','admin','','2018-03-03 20:06:38','2018-03-03 20:06:38',6);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
