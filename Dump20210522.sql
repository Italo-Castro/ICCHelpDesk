-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: icchelpdesk
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atendimento`
--

DROP TABLE IF EXISTS `atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atendimento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(25) DEFAULT NULL,
  `relato` varchar(500) DEFAULT NULL,
  `observacao` varchar(500) DEFAULT NULL,
  `observacao2` varchar(500) DEFAULT NULL,
  `solucao` varchar(500) DEFAULT NULL,
  `assunto` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `nomeContato` varchar(40) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `transferencia` varchar(50) DEFAULT NULL,
  `idTransferido` int NOT NULL,
  `obsTransferencia` varchar(500) DEFAULT NULL,
  `motivoPausa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimento`
--

LOCK TABLES `atendimento` WRITE;
/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
INSERT INTO `atendimento` VALUES (1,'TESTE5','fgasdfasdfasdfasdfasdfsdfasd','','','','CONTABIL','PAUSADO','SUPORTE','Arthur Belato','2021-04-28 06:48:01','TRANSFERENCIA DEVOLVIDA',2,'Teste obs trans',NULL),(3,'','','','','','','INICIADO','SUPORTE','','2021-04-28 06:59:21',NULL,0,NULL,NULL),(4,'TESTE3','KGHGHH','','','',' ','PAUSADO','SUPORTE','JHKGHKGH','2021-04-28 06:59:42','TRANSFERENCIA DEVOLVIDA',6,'',NULL),(7,'TESTE4','ASDFASDFASDFASDF','','','',' ','TRANSFERIDO','ITALO','FSDFASDF','2021-04-28 07:07:38','Atendimento transferido para SUPORTE',8,'',NULL),(8,'TESTE4','ASDFASDFASDFASDF','','','',' ','PAUSADO','SUPORTE','FSDFASDF','2021-04-28 07:07:38','TRANSFERENCIA DE ACEITA',7,'',NULL),(9,'TESTE2','GHKGHKHJH','','','',' ','PAUSADO','ITALO','JKG','2021-05-22 13:47:37',NULL,0,NULL,'HORARIO DE ALMOÇO'),(11,'TESTE3','FASDFASDFASDFSDAF','','','',' ','TRANSFERIDO','SUPORTE','DFSADFASD','2021-04-28 07:20:52','Atendimento transferido para ITALO',12,'FASDFASDFASDF',NULL),(15,'','','','','','','INICIADO','ITALO','','2021-05-22 13:22:55',NULL,0,NULL,NULL),(16,'','','','','','','INICIADO','ITALO','','2021-05-22 13:24:37',NULL,0,NULL,NULL),(17,'','','','','','','INICIADO','ITALO','','2021-05-22 13:30:25',NULL,0,NULL,NULL),(18,'TESTE4','','','','',' ','PAUSADO','ITALO',' fhfdhf','2021-05-22 13:47:06',NULL,0,NULL,'HORARIO DE ALMOÇO');
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(16) DEFAULT NULL,
  `nomeEmpresarial` varchar(20) DEFAULT NULL,
  `nomeFantasia` varchar(15) DEFAULT NULL,
  `telefone_1` varchar(10) DEFAULT NULL,
  `telefone_2` varchar(10) DEFAULT NULL,
  `responsavel` varchar(15) DEFAULT NULL,
  `nf_e` tinyint DEFAULT NULL,
  `nfc_e` tinyint DEFAULT NULL,
  `ct_e` tinyint DEFAULT NULL,
  `mdf_e` tinyint DEFAULT NULL,
  `informacoes` varchar(500) DEFAULT NULL,
  `menut` tinyint DEFAULT NULL,
  `menuEfd` tinyint DEFAULT NULL,
  `menuCX` tinyint DEFAULT NULL,
  `mercurio` tinyint DEFAULT NULL,
  `menuped` tinyint DEFAULT NULL,
  `edsys` tinyint DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `bairro` varchar(25) DEFAULT NULL,
  `logradouro` varchar(40) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'TESTE','TESTE','TESTE','TESTE','TESTE','TESTE',0,0,0,0,'',0,0,0,0,0,0,NULL,'35570-142','Formiga','Centro','Rua ',0,'Acre (AC)'),(2,'123456789','TESTE2','TESTE2','TESTE2','TESTE2','TESTE2',0,0,0,0,'TESTE2',1,0,0,0,0,0,NULL,'35570-280','Formiga','Vila Ferreira','Rua Primeiro de Abril',1,'Acre (AC)'),(3,'123456789','TESTE3','TESTE3','TESTE3','TESTE3','TESTE3',0,0,0,0,'TESTE3',1,0,0,0,0,0,NULL,'35570-142','Formiga','Centro','Rua Presidente Kenedy',0,'Amapá (AP)'),(4,'123456789','TESTE4','TESTE4','TESTE4','TESTE4','TESTE4',0,0,0,0,'TESTE4',1,0,0,0,0,0,NULL,'35570-142','Formiga','Centro','Rua Presidente Kenedy',0,'Ceará (CE)'),(5,'123456789','TESTE5','TESTE5','TESTE5','TESTE5','TESTE5',0,0,0,0,'TESTE5',1,0,0,0,0,0,NULL,'35570-148','Formiga','Centro','Avenida Guiomar Garcia Neto',0,'Alagoas (AL)'),(6,'123456','TESTE6','TESTE6','TESTE6','TESTE6','TESTE6',1,1,1,1,'TESTE6',1,1,1,1,1,1,NULL,'35570-146','Formiga','Centro','Rua Coronel José Gonçalves D\'Amarante',0,'Amapá (AP)'),(7,'000000','JGJFGJ','','SDAFA','','G',0,0,0,0,'',0,0,0,0,0,0,NULL,'     -   ','GHDFHGFH','','',2,'Amapá (AP)');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `possiveisclientes`
--

DROP TABLE IF EXISTS `possiveisclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `possiveisclientes` (
  `nome` varchar(20) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `relatoCliente` varchar(500) DEFAULT NULL,
  `solucao` varchar(500) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `cidade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `possiveisclientes`
--

LOCK TABLES `possiveisclientes` WRITE;
/*!40000 ALTER TABLE `possiveisclientes` DISABLE KEYS */;
INSERT INTO `possiveisclientes` VALUES ('ANA','37 98845-8588','Cliente utiliza um sistema ERP conconrrente, e o contador indicou o MENUT para ela trabalhar','Pedi ao Vinicius para entrar em contato','ESPRANDO LIGAÇÃO DO VINICIUS',1,'ESQUECI'),('','','','','',2,''),('Ç~KLÇ~KLÇ~KLÇ','~LK~','','','~KL~KL~KLÇKLÇ',3,'~LÇK~LÇ~KL');
/*!40000 ALTER TABLE `possiveisclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) DEFAULT NULL,
  `codigo` varchar(10) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `permissao` int NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `perfil` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ITALO','ITALO','','ATIVO',NULL,10,NULL,'DEV'),(2,'teste','teste','','A',NULL,0,NULL,'TESTE'),(3,'SUPORTE','SUPORTE','ENTRAR2014','A',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-22 23:00:05
