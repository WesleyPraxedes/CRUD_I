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