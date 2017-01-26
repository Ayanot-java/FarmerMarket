-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.16-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for farmermarket
CREATE DATABASE IF NOT EXISTS `farmermarket` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `farmermarket`;

-- Dumping structure for table farmermarket.buyer
CREATE TABLE IF NOT EXISTS `buyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `btype` int(11) NOT NULL DEFAULT '0',
  `address` varchar(500) NOT NULL DEFAULT '',
  `phone` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.buyer: ~0 rows (approximately)
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT IGNORE INTO `buyer` (`id`, `name`, `btype`, `address`, `phone`) VALUES
  (1, 'Moshe', 1, 'Israel', ''),
  (2, 'Avi', 3, 'Israel', '');
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;

-- Dumping structure for table farmermarket.buyertype
CREATE TABLE IF NOT EXISTS `buyertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.buyertype: ~3 rows (approximately)
/*!40000 ALTER TABLE `buyertype` DISABLE KEYS */;
INSERT IGNORE INTO `buyertype` (`id`, `name`) VALUES
  (1, 'makolet'),
  (2, 'default\r\n\r\n'),
  (3, 'kolhoz');
/*!40000 ALTER TABLE `buyertype` ENABLE KEYS */;

-- Dumping structure for table farmermarket.farmer
CREATE TABLE IF NOT EXISTS `farmer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `ftype` tinyint(4) NOT NULL DEFAULT '0',
  `address` varchar(500) NOT NULL DEFAULT '0',
  `phone` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.farmer: ~8 rows (approximately)
/*!40000 ALTER TABLE `farmer` DISABLE KEYS */;
INSERT IGNORE INTO `farmer` (`id`, `name`, `ftype`, `address`, `phone`) VALUES
  (1, 'Yuval', 1, 'Moshe Dayan 87', '04-811-65-89'),
  (2, 'Muhamed', 1, 'Peretz 40', '04-811-65-89'),
  (3, 'Avi', 1, 'Derech Lod 7', '04-811-65-89'),
  (4, 'Yossy', 3, 'Levi 87', '03-511-65-69'),
  (5, 'Atanas', 3, 'Luii V 87', '03-565-65-69'),
  (6, 'Dan', 4, 'Levi 87', '08-911-65-69'),
  (7, 'Dan', 4, 'Levi 87', '08-911-65-69'),
  (8, 'Dan', 4, 'Levi 87', '08-911-65-69'),
  (9, 'Dan', 4, 'Levi 87', '08-911-65-69');
/*!40000 ALTER TABLE `farmer` ENABLE KEYS */;

-- Dumping structure for table farmermarket.farmertype
CREATE TABLE IF NOT EXISTS `farmertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.farmertype: ~4 rows (approximately)
/*!40000 ALTER TABLE `farmertype` DISABLE KEYS */;
INSERT IGNORE INTO `farmertype` (`id`, `name`) VALUES
  (1, 'thai'),
  (2, 'bedouin'),
  (3, 'kibutz'),
  (4, 'moshav');
/*!40000 ALTER TABLE `farmertype` ENABLE KEYS */;

-- Dumping structure for table farmermarket.pack
CREATE TABLE IF NOT EXISTS `pack` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.pack: ~0 rows (approximately)
/*!40000 ALTER TABLE `pack` DISABLE KEYS */;
/*!40000 ALTER TABLE `pack` ENABLE KEYS */;

-- Dumping structure for table farmermarket.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `ptype` tinyint(4) NOT NULL DEFAULT '0',
  `image` varchar(250) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.product: ~3 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT IGNORE INTO `product` (`id`, `name`, `ptype`, `image`) VALUES
  (1, 'Antonovka', 2, '0'),
  (2, 'Red Delicious', 2, '0'),
  (3, 'Ieriho', 1, '0');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table farmermarket.producttype
CREATE TABLE IF NOT EXISTS `producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `image` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.producttype: ~3 rows (approximately)
/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
INSERT IGNORE INTO `producttype` (`id`, `name`, `image`) VALUES
  (1, 'Banana', NULL),
  (2, 'Apple', NULL),
  (3, 'Orange', NULL);
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;

-- Dumping structure for table farmermarket.purchase
CREATE TABLE IF NOT EXISTS `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer` int(11) NOT NULL DEFAULT '0',
  `pdate` datetime NOT NULL,
  `total` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.purchase: ~1 rows (approximately)
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT IGNORE INTO `purchase` (`id`, `buyer`, `pdate`, `total`) VALUES
  (1, 1, '2017-01-23 07:21:32', 22);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;

-- Dumping structure for table farmermarket.purchasedetails
CREATE TABLE IF NOT EXISTS `purchasedetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase` int(11) NOT NULL DEFAULT '0',
  `pack` int(11) NOT NULL DEFAULT '0',
  `qnt` float NOT NULL DEFAULT '0',
  `pPrice` float NOT NULL DEFAULT '0',
  `supplydetails` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.purchasedetails: ~2 rows (approximately)
/*!40000 ALTER TABLE `purchasedetails` DISABLE KEYS */;
INSERT IGNORE INTO `purchasedetails` (`id`, `purchase`, `pack`, `qnt`, `pPrice`, `supplydetails`) VALUES
  (1, 1, 1, 50, 0.5, 1),
  (2, 1, 2, 10, 0.8, 2);
/*!40000 ALTER TABLE `purchasedetails` ENABLE KEYS */;

-- Dumping structure for table farmermarket.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) DEFAULT NULL,
  `supplydetail` int(11) DEFAULT NULL,
  `qnt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.stock: ~0 rows (approximately)
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;

-- Dumping structure for table farmermarket.supply
CREATE TABLE IF NOT EXISTS `supply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmer` int(11) NOT NULL,
  `sdate` datetime NOT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.supply: ~3 rows (approximately)
/*!40000 ALTER TABLE `supply` DISABLE KEYS */;
INSERT IGNORE INTO `supply` (`id`, `farmer`, `sdate`, `total`) VALUES
  (1, 1, '2017-01-23 07:22:44', NULL),
  (2, 1, '2017-01-23 17:56:26', NULL),
  (3, 6, '2017-01-23 18:07:36', NULL);
/*!40000 ALTER TABLE `supply` ENABLE KEYS */;

-- Dumping structure for table farmermarket.supplydetails
CREATE TABLE IF NOT EXISTS `supplydetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supply` int(11) NOT NULL DEFAULT '0',
  `product` int(11) NOT NULL DEFAULT '0',
  `qnt` float NOT NULL DEFAULT '0',
  `pack` int(11) NOT NULL DEFAULT '0',
  `sprice` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.supplydetails: ~4 rows (approximately)
/*!40000 ALTER TABLE `supplydetails` DISABLE KEYS */;
INSERT IGNORE INTO `supplydetails` (`id`, `supply`, `product`, `qnt`, `pack`, `sprice`) VALUES
  (1, 1, 1, 20, 0, 54),
  (2, 1, 2, 30, 0, 5.7),
  (3, 3, 1, 22.5, 0, 0.75),
  (4, 3, 2, 30.5, 0, 1.25);
/*!40000 ALTER TABLE `supplydetails` ENABLE KEYS */;

-- Dumping structure for table farmermarket.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `pass` varchar(50) NOT NULL,
  `utype` enum('Admin','Farmer','Buyer') NOT NULL DEFAULT 'Farmer',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table farmermarket.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
