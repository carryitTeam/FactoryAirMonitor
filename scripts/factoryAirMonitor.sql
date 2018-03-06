/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.21-ctrip : Database - USE `factoryAirMonitor`;

*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`factoryAirMonitor` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `factoryAirMonitor`;

/*Table structure for table `alerthistory` */

DROP TABLE IF EXISTS `alerthistory`;

CREATE TABLE `alerthistory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `historyId` varchar(50) DEFAULT NULL,
  `userId` varchar(20) DEFAULT NULL,
  `ruleId` varchar(20) DEFAULT NULL,
  `appEui` varchar(100) DEFAULT NULL,
  `devEui` varbinary(100) DEFAULT NULL,
  `isProcess` varchar(10) DEFAULT NULL,
  `changeTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `alertrules` */

DROP TABLE IF EXISTS `alertrules`;

CREATE TABLE `alertrules` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruleId` varchar(50) DEFAULT NULL,
  `appEui` varchar(100) DEFAULT NULL,
  `devEui` varchar(100) DEFAULT NULL,
  `ruleContent` varchar(500) DEFAULT NULL,
  `changeTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `datas` */

DROP TABLE IF EXISTS `datas`;

CREATE TABLE `datas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appEui` varchar(100) NOT NULL,
  `devEui` varchar(100) NOT NULL,
  `jsonData` varchar(5000) DEFAULT NULL,
  `realData` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=641 DEFAULT CHARSET=utf8;

/*Table structure for table `deviceconfig` */

DROP TABLE IF EXISTS `deviceconfig`;

CREATE TABLE `deviceconfig` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appEui` varchar(100) NOT NULL,
  `devEui` varchar(100) NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`appEui`,`devEui`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `faultrecords` */

DROP TABLE IF EXISTS `faultrecords`;

CREATE TABLE `faultrecords` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appEui` varchar(100) DEFAULT NULL,
  `devEui` varchar(100) DEFAULT NULL,
  `faultContent` varchar(500) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `logops` */

DROP TABLE IF EXISTS `logops`;

CREATE TABLE `logops` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `logContent` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

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
  PRIMARY KEY (`userId`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
