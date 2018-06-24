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
-- Table structure for table `logops`
--

DROP TABLE IF EXISTS `logops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logops` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `logContent` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logops`
--

LOCK TABLES `logops` WRITE;
/*!40000 ALTER TABLE `logops` DISABLE KEYS */;
INSERT INTO `logops` VALUES (1,'hlzou','/index','2018-05-12 22:00:23'),(2,'zou','/groupmanger','2018-05-12 22:00:23'),(3,'admin','/groupManager','2018-06-24 12:05:31'),(4,'admin','/userManager','2018-06-24 12:06:04'),(5,'admin','/alertManager','2018-06-24 12:06:48'),(6,'admin','/logManager','2018-06-24 12:06:58'),(7,'admin','/logManager','2018-06-24 12:08:33'),(8,'admin','/deviceManager','2018-06-24 12:08:40'),(9,'admin','/deviceManager','2018-06-24 12:08:44'),(10,'admin','/sensorManager','2018-06-24 12:08:46'),(11,'admin','/logManager','2018-06-24 12:08:48'),(12,'admin','/faultManager','2018-06-24 12:11:46'),(13,'admin','/deviceManager','2018-06-24 12:11:50'),(14,'admin','/logManager','2018-06-24 12:11:52'),(15,'admin','/topManager','2018-06-24 12:14:06'),(16,'admin','/userManager','2018-06-24 12:14:07'),(17,'admin','/groupManager','2018-06-24 12:14:08'),(18,'admin','/alertManager','2018-06-24 12:14:10'),(19,'admin','/groupManager','2018-06-24 12:14:15'),(20,'admin','/userManager','2018-06-24 12:14:16'),(21,'admin','/topManager','2018-06-24 12:14:19'),(22,'admin','/dataRetrieveByAppEui','2018-06-24 12:15:37'),(23,'admin','/groupManager','2018-06-24 12:15:48'),(24,'admin','/userManager','2018-06-24 12:15:48'),(25,'admin','/alertManager','2018-06-24 12:15:49'),(26,'admin','/logManager','2018-06-24 12:15:50'),(27,'admin','/deviceManager','2018-06-24 12:15:52'),(28,'admin','/sensorManager','2018-06-24 12:15:52'),(29,'admin','/alertManager','2018-06-24 12:15:54'),(30,'admin','/topManager','2018-06-24 12:15:55'),(31,'admin','/startReceiveData','2018-06-24 12:15:57'),(32,'admin','/dataRetrieveByAppEui','2018-06-24 12:16:05'),(33,'admin','/dataRetrieveByAppEui','2018-06-24 12:16:25'),(34,'admin','/dataRetrieveByAppEui','2018-06-24 12:16:46'),(35,'admin','/dataRetrieveByAppEui','2018-06-24 12:17:06'),(36,'admin','/dataRetrieveByAppEui','2018-06-24 12:17:26'),(37,'admin','/dataRetrieveByAppEui','2018-06-24 12:17:47'),(38,'admin','/dataRetrieveByAppEui','2018-06-24 12:18:07'),(39,'admin','/dataRetrieveByAppEui','2018-06-24 12:18:27'),(40,'admin','/dataRetrieveByAppEui','2018-06-24 12:18:48'),(41,'admin','/dataRetrieveByAppEui','2018-06-24 12:19:08'),(42,'admin','/dataRetrieveByAppEui','2018-06-24 12:19:28'),(43,'admin','/dataRetrieveByAppEui','2018-06-24 12:19:49'),(44,'admin','/dataRetrieveByAppEui','2018-06-24 12:20:09'),(45,'admin','/dataRetrieveByAppEui','2018-06-24 12:20:29'),(46,'admin','/dataRetrieveByAppEui','2018-06-24 12:20:49'),(47,'admin','/dataRetrieveByAppEui','2018-06-24 12:21:10'),(48,'admin','/dataRetrieveByAppEui','2018-06-24 12:21:31'),(49,'admin','/dataRetrieveByAppEui','2018-06-24 12:21:51'),(50,'admin','/dataRetrieveByAppEui','2018-06-24 12:22:11'),(51,'admin','/dataRetrieveByAppEui','2018-06-24 12:22:31'),(52,'admin','/dataRetrieveByAppEui','2018-06-24 12:22:52'),(53,'admin','/dataRetrieveByAppEui','2018-06-24 12:23:12'),(54,'admin','/dataRetrieveByAppEui','2018-06-24 12:23:32'),(55,'admin','/dataRetrieveByAppEui','2018-06-24 12:23:53'),(56,'admin','/dataRetrieveByAppEui','2018-06-24 12:24:13'),(57,'admin','/dataRetrieveByAppEui','2018-06-24 12:24:33'),(58,'admin','/dataRetrieveByAppEui','2018-06-24 12:24:54'),(59,'admin','/dataRetrieveByAppEui','2018-06-24 12:25:14'),(60,'admin','/dataRetrieveByAppEui','2018-06-24 12:25:34'),(61,'admin','/dataRetrieveByAppEui','2018-06-24 12:25:55'),(62,'admin','/dataRetrieveByAppEui','2018-06-24 12:26:15'),(63,'admin','/dataRetrieveByAppEui','2018-06-24 12:26:36'),(64,'admin','/dataRetrieveByAppEui','2018-06-24 12:26:56'),(65,'admin','/dataRetrieveByAppEui','2018-06-24 12:27:16'),(66,'admin','/dataRetrieveByAppEui','2018-06-24 12:27:36'),(67,'admin','/dataRetrieveByAppEui','2018-06-24 12:27:57'),(68,'admin','/dataRetrieveByAppEui','2018-06-24 12:28:17'),(69,'admin','/dataRetrieveByAppEui','2018-06-24 12:28:37'),(70,'admin','/dataRetrieveByAppEui','2018-06-24 12:28:57'),(71,'admin','/dataRetrieveByAppEui','2018-06-24 12:29:18'),(72,'admin','/dataRetrieveByAppEui','2018-06-24 12:29:38'),(73,'admin','/dataRetrieveByAppEui','2018-06-24 12:29:58'),(74,'admin','/dataRetrieveByAppEui','2018-06-24 12:30:18'),(75,'admin','/dataRetrieveByAppEui','2018-06-24 12:30:38'),(76,'admin','/dataRetrieveByAppEui','2018-06-24 12:30:59'),(77,'admin','/dataRetrieveByAppEui','2018-06-24 12:31:19'),(78,'admin','/dataRetrieveByAppEui','2018-06-24 12:31:39'),(79,'admin','/dataRetrieveByAppEui','2018-06-24 12:32:00'),(80,'admin','/dataRetrieveByAppEui','2018-06-24 12:32:20'),(81,'admin','/dataRetrieveByAppEui','2018-06-24 12:32:40'),(82,'admin','/dataRetrieveByAppEui','2018-06-24 12:33:00'),(83,'admin','/dataRetrieveByAppEui','2018-06-24 12:33:21'),(84,'admin','/dataRetrieveByAppEui','2018-06-24 12:33:41'),(85,'admin','/dataRetrieveByAppEui','2018-06-24 12:34:01'),(86,'admin','/dataRetrieveByAppEui','2018-06-24 12:34:21'),(87,'admin','/alertManager','2018-06-24 12:46:24'),(88,'admin','/dealAlert','2018-06-24 12:46:35'),(89,'admin','/dealAlert','2018-06-24 12:46:38'),(90,'admin','/topManager','2018-06-24 13:16:13'),(91,'admin','/userManager','2018-06-24 13:16:14'),(92,'admin','/deviceManager','2018-06-24 13:16:18'),(93,'admin','/sensorManager','2018-06-24 13:16:22'),(94,'admin','/groupManager','2018-06-24 13:38:33'),(95,'admin','/deviceManager','2018-06-24 13:38:39'),(96,'admin','/sensorManager','2018-06-24 13:38:41'),(97,'admin','/deviceManager','2018-06-24 13:39:50'),(98,'admin','/sensorManager','2018-06-24 13:39:52'),(99,'admin','/deviceManager','2018-06-24 13:45:54'),(100,'admin','/sensorManager','2018-06-24 13:45:55'),(101,'admin','/topManager','2018-06-24 13:47:35'),(102,'admin','/deviceManager','2018-06-24 13:47:38'),(103,'admin','/sensorManager','2018-06-24 13:47:39'),(104,'admin','/sensorUpdateAndInsert','2018-06-24 13:47:53'),(105,'admin','/sensorUpdateAndInsert','2018-06-24 13:47:55'),(106,'admin','/sensorUpdateAndInsert','2018-06-24 13:48:38'),(107,'admin','/sensorUpdateAndInsert','2018-06-24 13:51:15'),(108,'admin','/sensorUpdateAndInsert','2018-06-24 13:51:30'),(109,'admin','/deviceManager','2018-06-24 13:52:14'),(110,'admin','/sensorManager','2018-06-24 13:52:30'),(111,'admin','/sensorUpdateAndInsert','2018-06-24 13:52:42'),(112,'admin','/sensorUpdateAndInsert','2018-06-24 13:53:08'),(113,'admin','/sensorManager','2018-06-24 13:55:43'),(114,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:50'),(115,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:51'),(116,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:51'),(117,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:52'),(118,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:52'),(119,'admin','/sensorUpdateAndInsert','2018-06-24 13:55:52'),(120,'admin','/sensorUpdateAndInsert','2018-06-24 13:56:02'),(121,'admin','/sensorUpdateAndInsert','2018-06-24 13:56:46'),(122,'admin','/sensorManager','2018-06-24 13:58:29'),(123,'admin','/sensorUpdateAndInsert','2018-06-24 13:58:37'),(124,'admin','/sensorManager','2018-06-24 13:58:38'),(125,'admin','/groupManager','2018-06-24 13:59:09'),(126,'admin','/topManager','2018-06-24 13:59:09'),(127,'admin','/sensorManager','2018-06-24 13:59:35'),(128,'admin','/deviceManager','2018-06-24 13:59:47'),(129,'admin','/sensorManager','2018-06-24 13:59:51'),(130,'admin','/deviceManager','2018-06-24 13:59:52'),(131,'admin','/topManager','2018-06-24 13:59:55'),(132,'admin','/sensorManager','2018-06-24 14:01:12'),(133,'admin','/topManager','2018-06-24 14:02:11'),(134,'admin','/sensorManager','2018-06-24 14:02:22'),(135,'admin','/dataRetrieveByAppEui','2018-06-24 14:02:27'),(136,'admin','/alertManager','2018-06-24 14:02:37'),(137,'admin','/sensorManager','2018-06-24 14:02:53'),(138,'admin','/sensorUpdateAndInsert','2018-06-24 14:03:00'),(139,'admin','/sensorManager','2018-06-24 14:03:01'),(140,'admin','/alertManager','2018-06-24 14:17:28'),(141,'admin','/topManager','2018-06-24 14:17:31'),(142,'admin','/startReceiveData','2018-06-24 14:17:34'),(143,'admin','/topManager','2018-06-24 14:19:29'),(144,'admin','/dataRetrieveByAppEui','2018-06-24 14:19:32'),(145,'admin','/dataRetrieveByAppEui','2018-06-24 14:19:53'),(146,'admin','/sensorManager','2018-06-24 14:20:04'),(147,'admin','/dataRetrieveByAppEui','2018-06-24 14:20:20'),(148,'admin','/deviceManager','2018-06-24 14:20:37'),(149,'admin','/sensorManager','2018-06-24 14:20:38');
/*!40000 ALTER TABLE `logops` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-24 14:22:16
