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
-- Table structure for table `cancha`
--

DROP TABLE IF EXISTS `cancha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancha` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `direccion_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cancha_direccion1_idx` (`direccion_id`),
  CONSTRAINT `fk_cancha_direccion1` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancha`
--

LOCK TABLES `cancha` WRITE;
/*!40000 ALTER TABLE `cancha` DISABLE KEYS */;
INSERT INTO `cancha` VALUES (1,'Universidad Santa María',2),(2,'La Carlota',3),(3,'Cumbres Curumo',4),(4,'Fray Luis 1',5),(5,'Erwin Fernández',6),(6,'Ciudad Casarapa',7),(7,'Colegio La Salle',8),(8,'Colegio Arcos',9),(9,'Colegio Loyola',10),(10,'Colegio San Agustín ',11),(11,'Aquino-Sta.Inés',12),(12,'Sierra Maestra',13),(13,'Caracas Sport Club',14),(14,'Montalbán',15),(15,'Valle Fresco',16),(16,'Universidad Metropolitana',17),(17,'Fray Luis 2',18),(18,'C.S.C.D Hebraica',31),(19,'Cocodrilos Sport Park',34),(20,'Academia Washington',61),(21,'La Guacamaya',62),(22,'Colegio Champagnat',63),(23,'Instituto ICC',64),(24,'Paraíso',65),(25,'Colegio Sta. Rosa',66),(26,'Colegio Los Arcos',67),(27,'Colegio Belagua',68),(28,'Colegio Loyola',69),(29,'La Trinidad',70),(30,'Colegio San Luis',74),(31,'Caricuao',75),(32,'Guido Blanco',76),(33,'Asopar',77),(34,'CIV Caracas',79),(35,'Colegio Claret',84),(36,'La Concepción',85),(37,'Colegio Calasanz',107),(38,'Seminario',108),(39,'El Marques',109),(41,'Macarao',111),(42,'Los Castores',112),(43,'Eleggua',113),(44,'San José Teques',114),(45,'Los Naranjos',115),(46,'Colegio Jefferson',116),(47,'Internacional de Caracas',117),(48,'Colegio Claret',118),(49,'Tirso de Molina',119),(50,'E.C.A.',120),(51,'Mercado de Coche',121),(52,'Colegio Británico',125),(53,'Facultad de Ciencias',133),(54,'Urbanización Miranda',134),(55,'Castillejo',135),(56,'Universidad S. Bolívar',136),(57,'Sebucan',138),(58,'Matías Núñez',139),(59,'Oropeza Castillo',170),(60,'Ciencias (UCV)',175),(61,'Charallave',177),(62,'UCAB Los Teques II',181),(63,'Valle Arrriba',182),(64,'Lecumberry',183),(65,'Zona Rental',184),(66,'UCAB Los Teques',186);
/*!40000 ALTER TABLE `cancha` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-30 15:00:26
