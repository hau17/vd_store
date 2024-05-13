-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for phone_store
CREATE DATABASE IF NOT EXISTS `phone_store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `phone_store`;

-- Dumping structure for table phone_store.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `brand_id` int(11) NOT NULL,
  `brand_name` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.brand: ~4 rows (approximately)
INSERT INTO `brand` (`brand_id`, `brand_name`, `status`) VALUES
	(1, 'iphone', 'active'),
	(2, 'xiaomi', 'active'),
	(3, 'samsung', 'active'),
	(4, 'oneplus', 'disable');

-- Dumping structure for table phone_store.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.customer: ~9 rows (approximately)
INSERT INTO `customer` (`customer_id`, `customer_name`, `phone_number`, `address`, `status`) VALUES
	(1, 'Customer 1', '1234567890', 'Address 1', 'active'),
	(2, 'Customer 2', '1234567891', 'Address 2', 'active'),
	(3, 'Customer 3', '1234567892', 'Address 3', 'active'),
	(4, 'Customer 4', '1234567893', 'Address 4', 'active'),
	(5, 'Customer 5', '1234567894', 'Address 555', 'active'),
	(6, 'Customer 6', '1234567896', 'Address 666', 'active'),
	(7, 'Customer 7', '1234567897', 'Address 777', 'disable'),
	(8, 'Customer 8', '1234567897', 'Address 777', 'active'),
	(9, 'Customer 9', '123456789', 'asfd', 'active');

-- Dumping structure for table phone_store.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `grn_id` int(11) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `input_day` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`grn_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `GoodReceivedNote_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  CONSTRAINT `GoodReceivedNote_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.grn: ~12 rows (approximately)
INSERT INTO `grn` (`grn_id`, `supplier_id`, `input_day`, `user_id`, `total_amount`, `status`) VALUES
	(1, 1, '2024-04-01', 2, 5000.00, 1),
	(2, 2, '2024-04-02', 2, 3000.00, 1),
	(3, 3, '2024-04-03', 2, 2000.00, 1),
	(4, 2, '2024-04-03', 3, 500.00, 1),
	(5, 2, '2024-04-03', 3, 500.00, 0),
	(6, 2, '2024-04-03', 3, 500.00, 0),
	(7, 2, '2024-04-04', 3, 500.00, 0),
	(8, 16, '2024-04-05', 1, 500.00, 0),
	(9, 16, '2024-04-06', 1, 1.00, 0),
	(10, 3, '2024-05-09', 1, 50.00, 0),
	(11, 16, '2024-05-09', 1, 1000.00, 0),
	(12, 2, '2024-05-13', 1, 8000.00, 1);

-- Dumping structure for table phone_store.grndetail
CREATE TABLE IF NOT EXISTS `grndetail` (
  `grn_details_id` int(11) NOT NULL,
  `grn_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price_grn` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`grn_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.grndetail: ~24 rows (approximately)
INSERT INTO `grndetail` (`grn_details_id`, `grn_id`, `quantity`, `product_id`, `price_grn`) VALUES
	(1, 1, 1, 1, 10000000.00),
	(2, 2, 2, 2, 20000000.00),
	(3, 3, 3, 3, 15000000.00),
	(4, 4, 10, 1, 10.00),
	(5, 4, 20, 2, 20.00),
	(6, 4, 30, 3, 30.00),
	(7, 4, 10, 1, 10.00),
	(8, 4, 20, 2, 20.00),
	(9, 4, 10, 1, 10.00),
	(10, 4, 20, 2, 20.00),
	(11, 4, 10, 1, 10.00),
	(12, 4, 20, 2, 20.00),
	(13, 4, 10, 1, 10.00),
	(14, 4, 20, 2, 20.00),
	(15, 4, 10, 1, 10.00),
	(16, 4, 20, 2, 20.00),
	(17, 8, 10, 1, 10.00),
	(18, 8, 20, 2, 20.00),
	(19, 9, 1, 1, 1.00),
	(20, 10, 1, 1, 10.00),
	(21, 10, 2, 2, 20.00),
	(22, 11, 6, 6, 60.00),
	(23, 11, 8, 8, 80.00),
	(24, 12, 10, 8, 800.00);

-- Dumping structure for table phone_store.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.invoice: ~26 rows (approximately)
INSERT INTO `invoice` (`invoice_id`, `customer_id`, `user_id`, `invoice_date`, `total_amount`, `status`) VALUES
	(1, 1, 2, '2022-01-01', 100.00, 0),
	(2, 2, 1, '2022-01-02', 200.00, 1),
	(3, 3, 1, '2022-01-03', 150.00, 1),
	(4, 4, 5, '2022-01-04', 120.00, 1),
	(5, 5, 4, '2022-01-05', 180.00, 1),
	(6, 2, 1, '2024-04-29', 50.00, 1),
	(10, 2, 1, '2024-04-30', 5.00, 0),
	(11, 1, 1, '2024-04-30', 500.00, 0),
	(12, 1, 1, '2024-04-30', 200.00, 0),
	(13, 3, 1, '2024-04-30', 311512.00, 0),
	(14, 1, 1, '2024-04-30', 5.00, 0),
	(15, 1, 1, '2024-04-30', 5.00, 1),
	(16, 1, 4, '2024-05-04', 40.00, 1),
	(17, 3, 4, '2024-05-04', 40.00, 0),
	(18, 1, 4, '2024-05-04', 20.00, 1),
	(19, 5, 4, '2024-05-04', 13.00, 0),
	(20, 3, 4, '2024-05-04', 5.00, 1),
	(21, 1, 4, '2024-05-04', 5.00, 1),
	(22, 2, 4, '2024-05-05', 30.00, 1),
	(23, 3, 4, '2024-05-05', 30.00, 1),
	(24, 1, 4, '2024-05-06', 190.00, 1),
	(25, 2, 4, '2024-05-06', 30.00, 1),
	(26, 1, 1, '2024-05-07', 100.00, 1),
	(27, 8, 1, '2024-05-07', 10.00, 1),
	(28, 4, 1, '2024-05-09', 160.00, 1),
	(29, 8, 1, '2024-05-12', 8.00, 1);

-- Dumping structure for table phone_store.invoice_detail
CREATE TABLE IF NOT EXISTS `invoice_detail` (
  `invoice_detail_id` int(11) NOT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_detail_id`),
  KEY `invoice_id` (`invoice_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `invoice_detail_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  CONSTRAINT `invoice_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.invoice_detail: ~46 rows (approximately)
INSERT INTO `invoice_detail` (`invoice_detail_id`, `invoice_id`, `quantity`, `product_id`, `price`) VALUES
	(1, 1, 3, 1, 10),
	(2, 1, 2, 2, 15),
	(3, 2, 5, 1, 10),
	(4, 3, 1, 3, 20),
	(5, 10, 1, 1, 1),
	(6, 10, 2, 2, 2),
	(7, 12, 2, 1, 50),
	(8, 12, 2, 2, 50),
	(9, 13, 2, 2, 77878),
	(10, 13, 2, 1, 77878),
	(11, 14, 1, 1, 1),
	(12, 14, 2, 2, 2),
	(13, 15, 1, 1, 1),
	(14, 15, 2, 2, 2),
	(15, 16, 2, 1, 20),
	(16, 17, 2, 1, 20),
	(17, 18, 1, 1, 10),
	(18, 18, 1, 3, 10),
	(19, 19, 2, 2, 2),
	(20, 19, 3, 3, 3),
	(21, 20, 2, 2, 2),
	(22, 20, 1, 1, 1),
	(23, 21, 1, 1, 1),
	(24, 21, 2, 2, 2),
	(25, 22, 1, 1, 1),
	(26, 22, 2, 2, 2),
	(27, 22, 3, 3, 3),
	(28, 22, 4, 4, 4),
	(29, 23, 1, 1, 1),
	(30, 23, 2, 2, 2),
	(31, 23, 3, 3, 3),
	(32, 23, 4, 4, 4),
	(33, 24, 2, 2, 2),
	(34, 24, 1, 1, 1),
	(35, 24, 3, 3, 3),
	(36, 24, 4, 4, 4),
	(37, 24, 4, 4, 40),
	(38, 25, 1, 1, 1),
	(39, 25, 2, 2, 2),
	(40, 25, 3, 3, 3),
	(41, 25, 4, 4, 4),
	(42, 26, 1, 6, 100),
	(43, 27, 1, 1, 10),
	(44, 28, 4, 4, 40),
	(45, 29, 2, 1, 2),
	(46, 29, 2, 2, 2);

-- Dumping structure for table phone_store.origin
CREATE TABLE IF NOT EXISTS `origin` (
  `origin_id` int(11) NOT NULL,
  `origin_name` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`origin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.origin: ~6 rows (approximately)
INSERT INTO `origin` (`origin_id`, `origin_name`, `status`) VALUES
	(1, 'Vietnam', 'active'),
	(2, 'China', 'active'),
	(3, 'USA', 'active'),
	(4, 'India', 'active'),
	(5, 'Korea', 'disable'),
	(6, 'Korea', 'active');

-- Dumping structure for table phone_store.product
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `ram` varchar(20) DEFAULT NULL,
  `rom` varchar(20) DEFAULT NULL,
  `battery_capacity` varchar(20) DEFAULT NULL,
  `chip` varchar(20) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `origin_id` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `image_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `brand_id` (`brand_id`),
  KEY `origin_id` (`origin_id`),
  CONSTRAINT `Product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `Product_ibfk_2` FOREIGN KEY (`origin_id`) REFERENCES `origin` (`origin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.product: ~9 rows (approximately)
INSERT INTO `product` (`product_id`, `product_name`, `ram`, `rom`, `battery_capacity`, `chip`, `brand_id`, `origin_id`, `status`, `image_path`) VALUES
	(1, 'iPhone 12 pro', '4GB', '64GB', '2815mAh', 'A14 Bionic', 1, 1, 'active', 'IMAGE\\null'),
	(2, 'Redmi Note 10', '6GB', '128GB', '5000mAh', 'Snapdragon 678', 2, 2, 'active', 'IMAGE\\iphone.png'),
	(3, 'Galaxy S21', '8GB', '128GB', '4000mAh', 'Exynos 2100', 3, 3, 'active', 'IMAGE\\samsung.png'),
	(4, 'OnePlus 9 Pro', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'active', 'IMAGE\\samsung.png'),
	(5, 'Redmi Note 10', '6GB', '128GB', '5000mAh', 'Snapdragon 678', 2, 2, 'disable', 'IMAGE\\yoimiya.jpg'),
	(6, 'nokia 5', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'active', 'IMAGE\\samsung.png'),
	(7, 'nokia 6', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'disable', 'IMAGE\\yoimiya.jpg'),
	(8, 'nokia 6', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'active', 'IMAGE\\samsung.png'),
	(9, 'nokia 6', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'disable', 'IMAGE\\null');

-- Dumping structure for table phone_store.role
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.role: ~3 rows (approximately)
INSERT INTO `role` (`role_id`, `role_name`, `description`) VALUES
	(1, 'admin', 'admin'),
	(2, 'Salesperson', 'Salesperson'),
	(3, 'Inventory clerk', 'Inventory clerk');

-- Dumping structure for table phone_store.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(20) DEFAULT NULL,
  `email_address` varchar(30) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.supplier: ~18 rows (approximately)
INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `email_address`, `phone_number`, `address`, `status`) VALUES
	(1, 'Supplier 1', 'supplier1@example.com', '9876543210', 'Supplier Address 1', 1),
	(2, 'Supplier 2', 'supplier2@example.com', '9876543211', 'Supplier Address 2', 1),
	(3, 'Supplier 3', 'supplier3@example.com', '9876543213', 'Supplier Address 3', 1),
	(4, 'Supplier 4', 'supplier3@example.com', '9876543212', 'Supplier Address 4', 0),
	(5, '555', '555', '5555', '5555', 0),
	(6, '66', '66', '66', '66', 0),
	(7, 'dsfd', 'afds', 'asfdsa', 'asf', 0),
	(8, '888', '88', '888', '888', 0),
	(9, '99', '99', '99', '99', 0),
	(10, '1', '1', '1', '1', 0),
	(11, 'Sup ', 'Sup11@1', '011', 'La111', 0),
	(12, 'sup12', '12@', '012', 'la12', 0),
	(13, '', '', '', '', 0),
	(14, 'sdfsd', 'hau12@gmai.com', '0337840884', 'asdf', 0),
	(15, 'ame15', '15@gmail.com', '0337483992', '1la1255', 0),
	(16, '16ne', '16ne@gmail.com', '0337840816', 'la16', 0),
	(17, '17nee', 'meo17@gmail.com', '0337840877', 'la77', 0),
	(18, '18nee', '18@gmail.com', '0337840888', '18la', 0);

-- Dumping structure for table phone_store.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `User_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.user: ~10 rows (approximately)
INSERT INTO `user` (`user_id`, `user_name`, `password`, `full_name`, `date_of_birth`, `phone_number`, `email_address`, `role_id`, `status`) VALUES
	(1, 'admin', 123, 'Raiden Shogun', '1990-01-01', '1234567890', 'customer1@example.com', 1, 1),
	(2, 'banhang1', 123, 'Sara', '1990-01-02', '1234567891', 'customer2@example.com', 2, 1),
	(3, 'nhaphang1', 123, 'Ayaka', '1980-01-01', '9876543210', 'admin@example.com', 3, 1),
	(4, 'banhang2', 123, 'Staff 1', '1995-01-01', '0123456789', 'staff1@example.com', 2, 0),
	(5, 'banhang3', 123, 'Staff 2', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0),
	(6, 'banhang4', 123, 'Staff 4', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0),
	(7, 'banhang5', 123, 'Staff 4', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0),
	(8, 'banhang6', 123, 'Staff 4', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0),
	(9, 'banhang7', 123, 'Staff 7', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0),
	(10, 'banhang8', 123, 'Staff 8', '1995-01-02', '0123456788', 'staff2@example.com', 2, 0);

-- Dumping structure for table phone_store.warehouse
CREATE TABLE IF NOT EXISTS `warehouse` (
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table phone_store.warehouse: ~7 rows (approximately)
INSERT INTO `warehouse` (`product_id`, `quantity`, `price`, `status`) VALUES
	(1, 10, 100000.00, 1),
	(2, 23, 20.00, 1),
	(3, 57, 30.00, 1),
	(4, 32, 12000000.00, 1),
	(5, 50, 15000000.00, 1),
	(6, 6, 60.00, 1),
	(8, 18, 800.00, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
