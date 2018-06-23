create database bair;

use bair;

CREATE TABLE `lugar` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NombreResponsable` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Router` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
