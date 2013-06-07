--
-- Create schema crud_cliente
--

CREATE DATABASE IF NOT EXISTS crud_cliente;
USE crud_cliente;

--
-- Definition of table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `id_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` bigint(10) unsigned DEFAULT NULL,
  `cpf` double DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `datanascimento` date DEFAULT NULL,
  PRIMARY KEY (`id_cliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cliente`
--

/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` (`id_cliente`,`nome`,`email`,`telefone`,`cpf`,`sexo`,`salario`,`datanascimento`) VALUES 
 (1,'Caelum15','contato@caelum.com.br',NULL,NULL,NULL,NULL,NULL),
 (2,'Caelum15','contato@caelum.com.br',98763456,NULL,NULL,NULL,NULL),
 (3,'Caelum15','contato@caelum.com.br',98763456,NULL,NULL,NULL,NULL),
 (4,'Wesley Praxedes 20','wesleyprofile@gmail.com',9876,NULL,NULL,NULL,NULL),
 (5,'Caelum15','contato@caelum.com.br',0,NULL,NULL,NULL,NULL),
 (8,'Wesley Praxedes 1','contato@caelum.com.br',0,NULL,NULL,NULL,NULL),
 (9,'Wesley Praxedes 1','contato@caelum.com.br',0,NULL,NULL,NULL,NULL),
 (10,'Caelum15','contato@caelum.com.br',98761234,NULL,NULL,NULL,NULL),
 (11,'Caelum15','contato@caelum.com.br',206098761234,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;