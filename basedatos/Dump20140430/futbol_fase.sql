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
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `temporada_id` int(10) unsigned NOT NULL,
  `isCurrent` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_fase_temporada1_idx` (`temporada_id`),
  CONSTRAINT `fk_fase_temporada1` FOREIGN KEY (`temporada_id`) REFERENCES `temporada` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (1,'Fase de Grupos',1,0),(3,'Primera Fase',2,0),(4,'Primera Fase',3,0),(5,'Primera Fase',4,0),(6,'Fase de Grupos',5,0),(7,'Fase de Grupos',6,0),(8,'Octavos',7,0),(9,'Cuartos',7,0),(10,'Semifinal',7,0),(11,'Tercero y Cuarto ',7,0),(12,'Final',7,1),(13,'Primera Fase',8,0),(14,'Primera Fase',9,0),(15,'Clausura 2013',10,0),(16,'Copa Categ.Grandes',3,0),(17,'Recopa Categ. Grandes',3,0),(18,'Copa Cuartos Categ. Menores',3,0),(19,'Copa Semifinales Categ. Menores',3,0),(21,'Copa Finales',3,0),(22,'Cuartos de Final',1,0),(23,'Semifinales',1,0),(24,'Fase de Grupos',11,1),(25,'Fase de Grupos',12,0),(26,'Primera Fase',13,0),(27,'Cuartos de Final',11,0),(28,'Semifinales',11,0),(29,'Finales',11,0),(30,'Recopa Cuartos Categ. Menores',3,NULL),(31,'Recopa Semifinales Categ. Menores',3,NULL),(32,'Recopa Finales',3,NULL),(33,'Finales',1,NULL);
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-30 15:00:27
