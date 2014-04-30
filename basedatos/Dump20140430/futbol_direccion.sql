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
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `direccion` text,
  `telefono1` varchar(15) DEFAULT NULL,
  `telefono2` varchar(15) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `pagina_web` varchar(60) DEFAULT NULL,
  `localidad_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_direccion_localidad1_idx` (`localidad_id`),
  CONSTRAINT `fk_direccion_localidad1` FOREIGN KEY (`localidad_id`) REFERENCES `localidad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,'Instalaciones Deportivas del Fray Luis de las Mercedes, Urb. Las Mercedes. ','0414.245.24.36','0416.928.60.52','victorgordilo1994@hotmail.com','No tiene',1),(2,'Carretera Petare-Santa Lucía.',NULL,NULL,NULL,NULL,1),(3,'Aeropuerto La Carlota, Autopista del Este entre Altamira y Dos Caminos.',NULL,NULL,NULL,NULL,1),(4,'Urbanizaci�n Cumbres de Curumo.',NULL,NULL,NULL,NULL,1),(5,'Instalaciones Deportivas del Fray Luis de las Mercedes. Urbanización Las Mercedes.',NULL,NULL,NULL,NULL,1),(6,'Urbanizaci�n Oropeza Castillo. Guarenas.',NULL,NULL,NULL,NULL,3),(7,'Ciudad Casarapa. Guarenas.',NULL,NULL,NULL,NULL,3),(8,'Salida o Entrada de la cota mil, Maripérez.',NULL,NULL,NULL,NULL,1),(9,'Sector la Tahona, Caracas.',NULL,NULL,NULL,NULL,1),(10,'La Castellana.',NULL,NULL,NULL,NULL,1),(11,'Urbanizacion El Paraiso.',NULL,NULL,NULL,NULL,1),(12,'Urbanizaci�n Santa In�s, subiendo por las canchas de Tenis de Santa Rosa de Lima.',NULL,NULL,NULL,NULL,1),(13,'Universidad Central de Venezuela.',NULL,NULL,NULL,NULL,1),(14,'Urbanización el Peñon',NULL,NULL,NULL,NULL,1),(15,'Urbanización Montalbán.',NULL,NULL,NULL,NULL,1),(16,'Carretera Fila de Mariches, Sector Valle Fresco, Frente Bomba de Gasolina.',NULL,NULL,NULL,NULL,2),(17,'Sector Terrazas del Avila, Universidad Metropolitana.',NULL,NULL,NULL,NULL,1),(18,'Las Mercedes.',NULL,NULL,NULL,NULL,1),(25,'La Castellana, Colegio San Ignacio de Loyola.','','','','No tiene',1),(26,'Universidad Central de Venezuela, Sector Sierra Maestra.','','','','',1),(27,'Fray Luis de las Mercedes, Urbanización Las Mercedes.','','','','',1),(28,'Universidad Metropolitana, Sector Terrazas del Avila.','','','','',1),(29,'Colegio Jefferson, Lomas de Valle Arriba.','0414.303.97.17','0414.320.26.62','wchampone@hotmail.com','No tiene',1),(30,'Los Chorros, Club Hebraica.','','','','',1),(31,'Los Chorros, Club Hebraica.',NULL,NULL,NULL,NULL,1),(32,'Aeropuerto de la Carlota.','','','','',1),(33,'Cumbres de Curumo.','','','','',1),(34,'Cota 905 Cocodrilos Sport Park.',NULL,NULL,NULL,NULL,1),(36,'Cota 905, Cocodrilos Sport Park.','','','','',1),(37,'Fila de Mariches, Sector Valle Fresco.','','','','',1),(38,'Guarenas.','','','','',1),(39,'Urbanización el Peñón, Caracas Sport Club.','','','','',1),(40,'Cota mil, Salida de Mariperez.','','','','',1),(41,'Nueva Casarapa, Guarenas.','','','','',1),(42,'Santa Paula, Caracas.','','','','',1),(43,'Caurimare, Colegio Champagnat.','','','','',1),(44,'La Floresta, Caracas.','','','','',1),(45,'Urbanización San Luis, Caracas.','','','','',1),(46,'Guarenas, Colegio Belagua.','','','','',1),(47,'El Paraiso, Colegio San Agustin.','','','','',1),(48,'Santa Ines. Caracas.','','','','',1),(49,'Montalban, Caracas.','','','','',1),(50,'Universidad Santa María. Sector Terrazas del Avila.','','','','',1),(51,'Caracas.','','','','',1),(52,'Caracas, Sector La Tahona.','','','','',1),(53,'Caracas, Sector Valle Arriba.','','','','',1),(54,'Caracas, Sector Santa Rosa de Lima.','','','','',1),(55,'Caracas, Sector Caricuao.','','','','',1),(56,'Caracas, Sector Los Naranjos.','','','','',1),(57,'Instalaciones del Fray Luis de Las Mercedes ( La Guacamaya). Urb. Las Mercedes.','0414.245.24.36','0416.928.60.52','victorgordilo1994@hotmail.com','No tiene',1),(58,'Colegio Jefferson, Valle Arriba, Caracas.','0414.303.97.17','0414.320.26.62','wchampone@hotmail.com','No tiene',1),(59,'Colegio Jefferson, Valle Arriba, Caracas.','0414.303.97.17','0414.320.26.62','wchampone@hotmail.com','No tiene',1),(60,'Colegio Jefferson, Valle Arriba, Caracas.','0414.303.97.17','0414.320.26.62','wchampone@hotmail.com','No tiene',1),(61,'Caracas.',NULL,NULL,NULL,NULL,1),(62,'Las Mercedes.',NULL,NULL,NULL,NULL,1),(63,'Caurimare, Caracas.',NULL,NULL,NULL,NULL,1),(64,'Santa Paula, Caracas.',NULL,NULL,NULL,NULL,1),(65,'El Paraíso, Colegio San Agustín',NULL,NULL,NULL,NULL,1),(66,'Santa Rosa de Lima, Caracas.',NULL,NULL,NULL,NULL,1),(67,'La Tahona, Caracas.',NULL,NULL,NULL,NULL,1),(68,'Guarenas.',NULL,NULL,NULL,NULL,3),(69,'La Castellana, Caracas.',NULL,NULL,NULL,NULL,1),(70,'La Trinidad, Caracas.',NULL,NULL,NULL,NULL,1),(71,'Los Samanes, Caracas','','','','',1),(72,'Valle Arriba, Caracas.','','','','',1),(73,'Montalbán, Caracas.','','','','',1),(74,'Urb. San Luis, Caracas.',NULL,NULL,NULL,NULL,1),(75,'Caricuao, Caracas.',NULL,NULL,NULL,NULL,1),(76,'Guarenas.',NULL,NULL,NULL,NULL,3),(77,'La Lagunita Country Club. ',NULL,NULL,NULL,NULL,1),(78,'Parque Humboldt, Caracas.','','','','',1),(79,'Parque Humboldt, Caracas.',NULL,NULL,NULL,NULL,1),(80,'Caracas.','','','','',1),(81,'Los Naranjos, Caracas.','','','','',1),(82,'Caracas.','','','','',1),(83,'Caracas.','','','','',1),(84,'Los Naranjos, Caracas.',NULL,NULL,NULL,NULL,1),(85,'Montalb�n, Caracas.',NULL,NULL,NULL,NULL,1),(86,'Caracas.','','','','',1),(87,'San Bernardino, Caracas.','','','','',1),(88,'Sartenejas, Caracas.','','','','',1),(89,'Avenida Sanz, Caracas.','','','','',1),(90,'San Antonio de los Altos, Estado Miranda.','','','','',1),(91,'Los Teques, Estado Miranda.','','','','',1),(92,'Mercado de Coche, Caracas.','','','','',1),(93,'Caracas.','','','','',1),(94,'Caracas.','','','','',1),(95,'Los Teques, Estado Miranda.','','','','',1),(96,'Santa Mónica, Caracas.','','','','',1),(97,'Los Teques, Estado Miranda.','','','','',1),(98,'Boleíta, Centro Don Bosco, Caracas.','','','','',1),(99,'Sector Macarao, Caracas.','','','','',1),(100,'La Pastora, Caracas.','','','','',1),(101,'Guarenas, Estado Miranda.','','','','',1),(102,'Catia, Caracas.','','','','',1),(103,'La Florida, Caracas.','','','','',1),(104,'Guarenas, Estado Miranda.','','','','',1),(105,'Las Mercedes, Caracas.','','','','',1),(106,'Sector Casarapa, Guarenas, Estado Miranda.','','','','',1),(107,'Catia, Caracas.',NULL,NULL,NULL,NULL,1),(108,'La Pastora, San Jos�, Caracas.',NULL,NULL,NULL,NULL,1),(109,'Av. Sanz, El Marques, Caracas.',NULL,NULL,NULL,NULL,1),(111,'Sector Macarao, Caracas.',NULL,NULL,NULL,NULL,1),(112,'San Antonio de los Altos, Estado Miranda.',NULL,NULL,NULL,NULL,6),(113,'Guatire, Estado Miranda.',NULL,NULL,NULL,NULL,4),(114,'Los Teques, Estado Miranda.',NULL,NULL,NULL,NULL,5),(115,'Los Naranjos, Caracas.',NULL,NULL,NULL,NULL,1),(116,'Valle Arriba, Caracas.',NULL,NULL,NULL,NULL,1),(117,'Baruta, Caracas.',NULL,NULL,NULL,NULL,1),(118,'Los Naranjos, Caracas.',NULL,NULL,NULL,NULL,1),(119,'San Bernardino, Caracas.',NULL,NULL,NULL,NULL,1),(120,'Las Mercedes. Caracas.',NULL,NULL,NULL,NULL,1),(121,'Sector Coche, Caracas, Mercado de Coche.',NULL,NULL,NULL,NULL,1),(122,'Instalaciones del Fray Luis de Las Mercedes, (la Guacamaya). Urb. Las Mercedes.','0414.245.24.36','0416.928.60.52','victorgordilo1994@hotmail.com','No tiene',1),(123,'Caracas.','','','','',1),(124,'Caracas.','','','','',1),(125,'Caracas.',NULL,NULL,NULL,NULL,1),(126,'La Trinidad.','0414.989.89.45','0414.171.0365','acfutbolmenor@hotmail.com','futbolmenor.com',1),(127,'San Antonio de los Altos.','','','','',1),(129,'Baruta, Estado Miranda.','','','','',1),(130,'Urbanización Miranda, Estado Miranda.','','','','',1),(131,'Caracas.','','','','',1),(132,'Instalaciones del Fray Luis de las Mercedes, (La Guacamaya). Urb. Las Mercedes.','0414.265.69.34','','ogegaca@gmail.com','No tiene',1),(133,'Universidad Central De Venezuela, Caracas.',NULL,NULL,NULL,NULL,1),(134,'Urb. Miranda, Estado Miranda.',NULL,NULL,NULL,NULL,1),(135,'Guatire, Estado Miranda.',NULL,NULL,NULL,NULL,4),(136,'Sartenejas, Baruta, Estado Miranda.',NULL,NULL,NULL,NULL,1),(137,'Petare, Estado Miranda.','','','','',1),(138,'Los Chorros, Sebucan.',NULL,NULL,NULL,NULL,1),(139,'Vista Alegre, Caracas.',NULL,NULL,NULL,NULL,1),(140,'Estadio Nacional Brigido Iriarte, El Paraiso.','0416.724.81.84','','asofutboldc@hotmail.com','No tiene',1),(141,'Caracas','','','','',1),(142,'Caracas.','','','','',1),(143,'','','','','',1),(144,'','','','','',1),(145,'Caracas.','','','','',1),(146,'Caracas.','','','','',1),(147,'Caracas.','','','','',1),(148,'Caracas.','','','','',1),(149,'Caracas.','','','','',1),(150,'Caracas.','','','','',1),(151,'Caracas.','','','','',1),(152,'Caracas.','','','','',1),(153,'Caracas.','','','','',1),(154,'Caracas.','','','','',1),(155,'Caracas.','','','','',1),(156,'El Paraíso, Caracas.','','','','',1),(157,'Caracas.','','','','',1),(158,'Caracas.','','','','',1),(159,'Caracas.','','','','',1),(160,'Caracas.','','','','',1),(161,'Caracas.','','','','',1),(162,'Caracas.','','','','',1),(163,'Caracas.','','','','',1),(164,'Caracas.','','','','',1),(165,'Caracas.','','','','',1),(166,'Caracas.','','','','',1),(167,'Caracas.','','','','',1),(168,'Caracas.','','','','',1),(169,'Caracas.','','','','',1),(170,'Guarenas.',NULL,NULL,NULL,NULL,3),(171,'Caracas.','','','','',1),(172,'Caracas.','','','','',1),(173,'Caracas.','','','','',1),(174,'Universidad Central de Venezuela, Facultad de Ciencias.','','','','',1),(175,'Universidad Central de Venezuela (Facultad de Ciencias)',NULL,NULL,NULL,NULL,1),(176,'Colegio San Agustín de Caricuao.','','','','',1),(177,'Charallave',NULL,NULL,NULL,NULL,7),(178,'Caracas.','','','','',1),(179,'Caracas','','','','',1),(180,'Caracas.','','','','',1),(181,'Los Teques.',NULL,NULL,NULL,NULL,5),(182,'Guarenas.',NULL,NULL,NULL,NULL,3),(183,'Cua, Charallave.',NULL,NULL,NULL,NULL,7),(184,'Caracas.',NULL,NULL,NULL,NULL,1),(185,'Caracas.','','','','',1),(186,'Los Teques.',NULL,NULL,NULL,NULL,5);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
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
