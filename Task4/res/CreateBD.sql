
DROP DATABASE IF EXISTS `railwaydb`;

CREATE DATABASE `railwaydb`;

USE `railwaydb`;


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



DROP TABLE IF EXISTS `type_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_seat`(
  `id_type_seat` int(11) NOT NULL AUTO_INCREMENT,
  `name_type_seat` varchar(50) NOT NULL,
  PRIMARY KEY (`id_type_seat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `type_seat` WRITE;
/*!40000 ALTER TABLE `type_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_seat` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `wagon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wagon` (
  `id_wagon` int(11) NOT NULL AUTO_INCREMENT,
  `number_wagon` int(11) NOT NULL DEFAULT '1',
  `number_of_seats` int(11) NOT NULL DEFAULT '0',
  `id_type_seat_FK` int(11) NOT NULL DEFAULT '0',
  `id_train_FK` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_wagon`),
  KEY `id_train` (`id_train_FK`),
  KEY `id_type_seat_FK` (`id_type_seat_FK`),
  CONSTRAINT `wagon_ibfk_1` FOREIGN KEY (`id_train_FK`) REFERENCES `train` (`id_train`),
  CONSTRAINT `wagon_ibfk_2` FOREIGN KEY (`id_type_seat_FK`) REFERENCES `type_seat` (`id_type_seat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `wagon` WRITE;
/*!40000 ALTER TABLE `wagon` DISABLE KEYS */;
/*!40000 ALTER TABLE `wagon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
--
-- Dumping data for table `wagon`
--

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `id_station` int(11) NOT NULL AUTO_INCREMENT,
  `name_station` varchar(50) NOT NULL,
  PRIMARY KEY (`id_station`),
  UNIQUE KEY `unique_name_station` (`name_station`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `id_train` int(11) NOT NULL AUTO_INCREMENT,
  `name_train` varchar(20) NOT NULL,
  PRIMARY KEY (`id_train`),
  UNIQUE KEY `unique_name_train` (`name_train`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` INT (11) NOT NULL DEFAULT '1',
  UNIQUE KEY `unique_login` (`login`),
  PRIMARY KEY (`id_user`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
  
--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
    `id_client` INT(11) NOT NULL AUTO_INCREMENT,
    `surname` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `patronymic` VARCHAR(50) NOT NULL,
    `telephone` VARCHAR(20) NOT NULL,
    `id_user_FK` INT(11) NOT NULL DEFAULT '1',
    PRIMARY KEY (`id_client`),
    KEY `id_user_FK` (`id_user_FK`),
    CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_user_FK`)
        REFERENCES `user` (`id_user`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



DROP TABLE IF EXISTS `route_fragment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_fragment` (
  `id_route_fragment` int(11) NOT NULL AUTO_INCREMENT,
  `id_train_FK` int(11) NOT NULL,
  `id_start_station_FK` int(11) DEFAULT NULL,
  `id_finish_station_FK` int(11) DEFAULT NULL,
  `time_departure` time NOT NULL,
  `time_travel` time NOT NULL,
  `distance` int(11) NOT NULL, 
  PRIMARY KEY (`id_route_fragment`),
  KEY `id_start_station_FK` (`id_start_station_FK`),
  KEY `id_finish_station_FK` (`id_finish_station_FK`),
  KEY `id_train_FK` (`id_train_FK`),
  CONSTRAINT `route_fragment_ibfk_1` FOREIGN KEY (`id_start_station_FK`) REFERENCES `station` (`id_station`),
  CONSTRAINT `route_fragment_ibfk_2` FOREIGN KEY (`id_finish_station_FK`) REFERENCES `station` (`id_station`),
  CONSTRAINT `route_fragment_ibfk_3` FOREIGN KEY (`id_train_FK`) REFERENCES `train` (`id_train`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */
;
DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id_schedule` int(11) NOT NULL AUTO_INCREMENT,
  `datetime_start` datetime NOT NULL,
  `id_route_fragment_FK` int(11) NOT NULL,
  PRIMARY KEY (`id_schedule`),
  KEY `id_route_fragment_FK` (`id_route_fragment_FK`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`id_route_fragment_FK`) REFERENCES `route_fragment` (`id_route_fragment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Dump completed on 2015-06-18 23:02:17
--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `datetime_begin` datetime NOT NULL,
  `datetime_end` datetime NOT NULL,
  `number_wagon` int(11) NOT NULL,
  `number_seat` int(11) NOT NULL,
  `id_type_seat_FK` int(11) NOT NULL DEFAULT '0',
  `price` decimal(10,2) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',/* 0- оклонен 1 - неопределен 2- принят*/ 
  `id_client_FK` int(11) NOT NULL,
  `id_route_fragment_FK` int(11) NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_client_FK` (`id_client_FK`),
  KEY `id_type_seat_FK` (`id_type_seat_FK`),
  KEY `id_route_fragment_FK` (`id_route_fragment_FK`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_client_FK`) REFERENCES `client` (`id_client`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_type_seat_FK`) REFERENCES `type_seat` (`id_type_seat`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`id_route_fragment_FK`) REFERENCES `route_fragment` (`id_route_fragment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;


   


DROP USER 'UserRailway'@'localhost';
CREATE USER 'UserRailway'@'localhost' IDENTIFIED BY '12345';
GRANT SELECT ON `railwaydb`.* TO 'UserRailway'@'localhost';
GRANT INSERT,UPDATE ON `railwaydb`.`client` TO 'UserRailway'@'localhost';
GRANT INSERT,UPDATE ON `railwaydb`.`ticket` TO 'UserRailway'@'localhost';


DROP USER 'AdminRailway'@'localhost';
CREATE USER 'AdminRailway'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON `railwaydb`.* TO 'AdminRailway'@'localhost';