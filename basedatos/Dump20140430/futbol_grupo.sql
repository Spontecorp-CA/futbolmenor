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
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fase_id` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_fase1_idx` (`fase_id`),
  CONSTRAINT `fk_grupo_fase1` FOREIGN KEY (`fase_id`) REFERENCES `fase` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'Grupo A',0000000001),(2,'Grupo B',0000000001),(3,'Ronda Eliminatoria',0000000003),(4,'Ronda Eliminatoria',0000000004),(5,'Ronda Eliminatoria',0000000005),(6,'Grupo A',0000000006),(7,'Grupo B',0000000006),(8,'Grupo C',0000000006),(9,'Grupo A',0000000007),(10,'Grupo B',0000000007),(11,'Ronda Clasificatoria',0000000013),(12,'Ronda Clasificatoria',0000000014),(13,'Grupo 1',0000000015),(14,'Grupo 2',0000000015),(15,'Grupo 3',0000000015),(16,'Play Off',0000000016),(17,'Ronda Final',0000000017),(18,'Grupo A',0000000024),(19,'Grupo B',0000000024),(20,'Grupo A',0000000025),(21,'Grupo B',0000000025),(22,'Grupo C',0000000025),(23,'Ronda Clasificatoria',0000000026);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
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
