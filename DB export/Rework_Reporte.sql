-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Rework
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `Reporte`
--

DROP TABLE IF EXISTS `Reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reporte` (
  `idReporte` int(11) NOT NULL AUTO_INCREMENT,
  `tec_Id` int(11) NOT NULL,
  `ProdNo` varchar(30) NOT NULL,
  `SerialNo` varchar(45) NOT NULL,
  `rty_Id` varchar(30) NOT NULL,
  `rep_Desc` varchar(200) NOT NULL,
  `rwk_Id` int(11) DEFAULT NULL,
  `Idle_S_Time` datetime NOT NULL,
  `Idle_E_A_S_Time` datetime DEFAULT NULL,
  `Activity_E_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`idReporte`),
  KEY `fk_tec_idx` (`tec_Id`),
  KEY `fk_Prod_idx` (`ProdNo`),
  KEY `fk_rty_idx` (`rty_Id`),
  KEY `fk_rwk_idx` (`rwk_Id`),
  CONSTRAINT `fk_Prod` FOREIGN KEY (`ProdNo`) REFERENCES `ProdNo` (`idProdNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rty` FOREIGN KEY (`rty_Id`) REFERENCES `ReworkType` (`rty_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rwk` FOREIGN KEY (`rwk_Id`) REFERENCES `Rework` (`rwk_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tec` FOREIGN KEY (`tec_Id`) REFERENCES `Tecnico` (`tec_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reporte`
--

LOCK TABLES `Reporte` WRITE;
/*!40000 ALTER TABLE `Reporte` DISABLE KEYS */;
INSERT INTO `Reporte` VALUES (7,742463,'ASM1512','1512-00255','Change Component','Change U17',NULL,'2017-06-28 11:22:17',NULL,NULL);
/*!40000 ALTER TABLE `Reporte` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-28 11:29:03
