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
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `fecha` datetime DEFAULT NULL,
  `liga_id` varchar(45) DEFAULT NULL,
  `url` varchar(100) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (4,'Liga Cesar del Vecchio Serie \"B\" Grupo \"C\" Jornada 11.','2013-05-04 19:30:00','3','https://www.youtube.com/v/GJxlMLYWSjA','Loyola FC vs Caracas SC Del Vecchio Serie B Grupo C Jornada 11 Pre-Infantil A'),(6,'Liga Don Bosco ','2013-05-11 19:30:00',NULL,'http://www.youtube.com/v/msDYPtnV4_8&feature=youtube_gdata','Don Bosco vs Junquito SC Pre-Infantil Sabado 11-05-13'),(7,'Don Bosco vs Junquito SC, Liga Don Bosco, CategorÃ­a Pre-Infantil, Sabado 11/05/13','2013-05-12 19:30:00',NULL,'http://www.youtube.com/v/CcyrK3BNe-s','La entrevista de la jornada'),(8,'Liga Cesar del Vecchio Serie \"A\", categoria Pre-Infantil A Grupo B.','2013-05-18 19:30:00','1','https://www.youtube.com/v/SLcNiztFe9Q','Deportivo Galicia vs Los Arcos Del Vecchio Serie A Pre-Infantil A Sabado 18 de Mayo'),(9,'Liga Cesar del Vecchio Serie A Sabado 18 de Mayo.','2013-05-19 19:30:00','1','http://www.youtube.com/v/pGX2n2gZBDE&feature=em-upload_owner','Entrevistas Galicia y Los Arcos Pre-Infantil A'),(10,'Del Vecchio Serie A Categoria Pre-Infantil B','2013-05-25 19:30:00','1','https://www.youtube.com/v/oIM1YKP384U&feature=em-upload_owner','San Agustin vs Real Esppor Del Vecchio Serie A Categoria Pre-B'),(11,'San Agustin vs Real Esppor, Categoria Pre-Infantil B, Del Vecchio Serie A.','2013-05-26 19:30:00','1','https://www.youtube.com/v/2LUbCghTSBw','Entrevistas en el Paraiso a los protagonistas '),(12,'Del Vecchio Serie A Categoria Pre-Infantil A Grupo B','2013-06-01 19:30:00','1','http://www.youtube.com/v/az9I4C00_Cc&feature=youtube_gdata','La Salle vs Fratelsa SC '),(13,'Liga RÃ³mulo HernÃ¡ndez, Cancha Montalban.',NULL,NULL,'http://www.youtube.com/v/FdXlebmSH-k&feature=youtube_gdata','Escuela Libertador vs Selimen Sub 10'),(14,'Liga Romulo Hernandez, cancha Montalban.','2013-06-08 19:30:00','10','http://www.youtube.com/v/FdXlebmSH-k&feature=youtube_gdata','Escuela Libertador vs Selimen Sub 10'),(15,'Liga Romulo Hernandez Categoria Sub 10.','2013-06-09 19:30:00','10','http://www.youtube.com/v/why3woBXlCg','Entrevistas Libertador vs Selimen'),(16,'San Agustin vs Los Arcos, Categoria Pre-Infantil \"B\".','2013-07-15 19:30:00','1','http://www.youtube.com/v/T_Aq7DnW7gk&feature=youtu.be','Final Del Vecchio Serie \"A\" , San Agustin Vs Los Arcos'),(17,'Categoria Pre-Infantil B de la Liga Cesar Del Vecchio Serie A.','2014-01-19 19:30:00','1','http://www.youtube.com/v/bNJlH43IiuE&feature=youtu.be','Caracas Sport Club vs Colegio Los Arcos'),(18,'Liga Cesar del Vecchio.','2014-01-26 19:30:00','3','http://www.youtube.com/v/g95RTRShi4E&feature=em-upload_owner','Agustinos vs Macarao, Pre-B Del Vecchio Serie B'),(19,'Liga Cesar del Vecchio.','2014-02-01 19:30:00','1','http://www.youtube.com/v/vOj-1OFjO4g&feature=youtu.be','La Salle vs Loyola Pre-B Del Vecchio Serie A Jornada 3 Grupo B'),(20,'Liga Cesar del Vecchio.','2014-02-02 19:30:00','1','http://www.youtube.com/v/L_Yhr3lOPWQ&feature=youtu.be','Entrevistas a los jugadores del Loyola FC de la categoria Pre-Infantil B. Del Vecchio Serie A '),(21,'Liga Cesar del Vecchio','2014-02-03 19:30:00','1','http://www.youtube.com/v/3HYAGY1gpcs&feature=em-upload_owner','Entrevistas a los jugadores de La Salle categoria Pre-Infantil B. Del Vecchio Serie A'),(22,'Liga Cesar Del Vecchio','2014-02-09 19:30:00','3','http://www.youtube.com/v/LSP03OhxvRM&feature=youtu.be','Emmanuel vs Fratesa SC Pre-B Del Vecchio Serie B Jornada 4 Grupo A '),(23,'Liga Cesar del Vecchio','2014-02-09 19:30:00','3','http://www.youtube.com/v/4XlX9-k85fo&feature=youtu.be','Entrevistas a los jugadores de Emmanuel categoria Pre-Infantil B. Del Vecchio Serie B Jornada 4'),(24,'Liga Cesar del Vecchio','2014-02-09 19:30:00','3','http://www.youtube.com/v/n8uJleknSWY&feature=youtu.be','Entrevistas a los jugadores de Fratelsa SC categoria Pre-Infantil B. Del Vecchio Serie B Jornada 4'),(25,'Liga Cesar del Vecchio.','2014-02-15 19:30:00','1','http://www.youtube.com/v/J6rpGUQbeDU&feature=youtu.be','Caracas SC vs Deportivo Galicia Pre-B Del Vecchio Serie A Jornada 6 Grupo A '),(26,'Liga Cesar del Vecchio.','2014-02-17 19:30:00','1','http://www.youtube.com/v/AXD3sYyY9-k&feature=youtu.be','Caracas SC vs Galicia, entrevistas a los protagonistas.'),(27,'Liga Cesar del Vecchio','2014-03-23 19:30:00','3','https://www.youtube.com/v/8PxVuF1H3OQ&feature=youtu.be','Deportivo Agustinos vs EF Jachico Pre-B Del Vecchio Serie B Jornada 6 Grupo C'),(28,'Liga Deportiva Colegial de Caracas Division \"C\" ','2014-04-27 19:30:00','5','https://www.youtube.com/v/k7bR1el0zJ8&feature=youtu.be','ICC vs Real Esppor Pre-B Colegial Division C');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-30 15:00:25
