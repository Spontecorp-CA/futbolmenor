CREATE DATABASE  IF NOT EXISTS `futbol` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `futbol`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: spontedev    Database: futbol
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `llave`
--

DROP TABLE IF EXISTS `llave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `llave` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fase_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_llave_fase1_idx` (`fase_id`),
  CONSTRAINT `fk_llave_fase1` FOREIGN KEY (`fase_id`) REFERENCES `fase` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llave`
--

LOCK TABLES `llave` WRITE;
/*!40000 ALTER TABLE `llave` DISABLE KEYS */;
INSERT INTO `llave` VALUES (1,'Grupo 1A',8),(2,'Grupo 1B',8),(3,'Grupo 2A',8),(4,'Grupo 2B',8),(5,'Grupo 3A',8),(6,'Grupo 3B',8),(7,'Grupo 4A',8),(8,'Grupo 4B',8),(9,'G1',9),(10,'G2',9),(11,'G3',9),(12,'G4',9),(13,'S1',10),(14,'S2',10),(15,'P1',11),(19,'GS',12),(20,'Llave A',18),(21,'Llave B',18),(22,'Llave C',18),(23,'Llave D',18),(24,'Llave A',22),(25,'Llave B',22),(26,'Llave C',22),(27,'Llave D',22),(36,'Final ',21),(37,'Llave A',30),(38,'Llave B',30),(39,'Llave C',30),(40,'Llave D',30),(41,'Llave E',19),(42,'Llave F',19),(45,'Llave C1',27),(46,'Llave C2',27),(47,'Llave C3',27),(48,'Llave C4',27),(49,'Llave S1',28),(50,'Llave S2',28),(53,'Final 1',29),(54,'Final 2',29),(55,'Final 3',29),(56,'Final 4',29),(57,'Final 5',29);
/*!40000 ALTER TABLE `llave` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-30 15:00:29
