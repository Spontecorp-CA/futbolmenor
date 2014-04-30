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
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `club` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `logo` varchar(45) DEFAULT NULL,
  `direccion_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_club_direccion1_idx` (`direccion_id`),
  CONSTRAINT `fk_club_direccion1` FOREIGN KEY (`direccion_id`) REFERENCES `direccion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (7,'Loyola Fútbol Club','7.png',25),(8,'Universidad Central de Venezuela','8.png',26),(9,'Santo Tomas de Villanueva','9.png',27),(10,'Estudiantes de Caracas','10.jpg',28),(11,'C.S.C.D Hebraica A.C','11.jpg',30),(12,'Emmanuel Fútbol Club','12.jpg',32),(13,'Real Esppor Club','13.png',33),(15,'Caracas Fútbol Club','15.png',36),(16,'Deportivo Galicia','16.png',37),(17,'Escuela de Fútbol Virgen de Fátima','17.jpg',38),(18,'Caracas Sport Club','18.gif',39),(19,'Colegio La Salle','19.gif',40),(20,'Casarapa Sport Club','20.jpg',41),(21,'Instituto Cumbres de Caracas','21.jpg',42),(22,'Colegio Champagnat','22.jpg',43),(23,'Colegio Santiago de León','23.jpg',44),(24,'Colegio San Luis','24.jpg',45),(25,'Colegio Belagua','25.jpg',46),(26,'San Agustin del Paraiso','26.png',47),(27,'Santo Tomas de Aquino','27.jpg',48),(28,'Escuela de Fútbol Montalbán','28.jpg',49),(29,'Fratelsa Sport Club','29.png',50),(30,'Talentos Franco Rizzi','30.jpg',51),(31,'Colegio Los Arcos','31.jpg',52),(32,'Academia Washington','32.jpg',53),(33,'Colegio Santa Rosa de Lima','33.jpg',54),(34,'Colegio San Agustín de Caricuao','34.jpg',55),(35,'Colegio Claret','35.jpg',56),(36,'Colegio Henry Clay','36.jpg',71),(37,'Colegio Jefferson','37.jpg',72),(38,'Colegio La Concepción de Montalbán','38.jpg',73),(39,'Centro Italo Venezolano','39.png',78),(40,'Colegio Integral del Avila','40.jpg',80),(41,'Todos Estrellas','41.jpg',81),(42,'Instituto Escuelas Asociados','42.jpg',82),(43,'Colegio Fray Luis de León','43.jpg',83),(44,'Colegio Británico',NULL,86),(45,'Colegio Tirso de Molina ','45.jpg',87),(46,'Universidad Simón Bolívar','46.jpg',88),(47,'Colegio San Agustín del Marques','47.png',89),(48,'Los Castores','48.jpg',90),(49,'Escuela de Fútbol Junior Los Teques','49.jpg',91),(50,'Central Madeirense','50.png',92),(51,'Cristo Te Ama','51.jpg',93),(52,'Dios Admirable','52.jpg',94),(53,'Colegio San José de los Teques','53.jpg',95),(54,'Colegio Cristo Rey','54.png',96),(55,'Centro Hispano Los Teques','55.jpg',97),(56,'Escuela de Fútbol Pito Useche','56.png',98),(57,'Escuela de Fútbol Macarao','57.jpg',99),(58,'Escuela de Fútbol Jachico','58.png',100),(59,'Eleggua Fútbol Club','59.jpg',101),(60,'Colegio San José de Calasanz','60.png',102),(61,'Colegio Humboldt','61.jpg',103),(62,'Escuela de Fútbol La Rosa','62.png',104),(63,'Escuela Campo Alegre','63.jpg',105),(64,'Club Muchachos Nueva Casarapa','64.jpg',106),(65,'Liga Municipal',NULL,123),(66,'Deportivo Unión','66.jpg',124),(67,'Deportivo Gulima','67.jpg',127),(69,'Baruta Fútbol Club',NULL,129),(70,'Salernitana Fútbol Club','70.jpg',130),(71,'Atlético Sport Club',NULL,131),(72,'Deportivo Petare','72.jpg',137),(73,'Humanitas',NULL,141),(74,'Selimen',NULL,142),(75,'Escuela Libertador',NULL,143),(76,'F.D.V',NULL,144),(77,'Ursimbol',NULL,145),(78,'San Bernardino',NULL,146),(79,'Tamanaquito',NULL,147),(80,'Atlético Venezuela','80.jpg',148),(81,'Academia Venezolana de Fútbol','81.jpg',149),(82,'Catia Fútbol Club',NULL,150),(83,'Atlético Miranda','83.jpg',151),(84,'El Triunfo',NULL,152),(85,'Liceo Caracas',NULL,153),(86,'A40','86.jpg',154),(87,'Santa Fe',NULL,155),(88,'Instituto Pedagógico de Caracas',NULL,156),(89,'Emelec',NULL,157),(90,'Estrella Roja','90.jpg',158),(91,'Club Atlético López Hernández','91.jpg',159),(92,'Sporting',NULL,160),(93,'Ciencias',NULL,161),(94,'Somos Perú',NULL,162),(95,'Las Américas','95.png',163),(96,'Zadiba',NULL,164),(97,'Alianza Caracas',NULL,165),(98,'Nacional',NULL,166),(99,'Universidad Santa María','99.jpg',167),(100,'Paraíso',NULL,168),(101,'Unión Atlético Caracas',NULL,169),(102,'Futuros Vinotintos','102.jpg',171),(103,'Club Atlético Internacional','103.jpg',172),(104,'EIF. Rafael Urdaneta','104.jpg',173),(105,'Deportivo Ciencias','105.jpg',174),(106,'Nueva Generación','106.jpg',176),(107,'Club Atle. Nacional de Caracas','107.jpg',178),(108,'C.C.E.F.B.','108.jpg',179),(109,'Academia Deportiva Internacional','109.jpg',180),(110,'Xeneize FC',NULL,185);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
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
