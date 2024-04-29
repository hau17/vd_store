-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2024 at 06:40 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phone_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `brand_id` int(11) NOT NULL,
  `brand_name` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`brand_id`, `brand_name`, `status`) VALUES
(1, 'iphone', 'active'),
(2, 'xiaomi', 'active'),
(3, 'samsung', 'active'),
(4, 'oneplus', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `phone_number`, `address`, `status`) VALUES
(1, 'Customer 1', '1234567890', 'Address 1', 'active'),
(2, 'Customer 2', '1234567891', 'Address 2', 'active'),
(3, 'Customer 3', '1234567892', 'Address 3', 'active'),
(4, 'Customer 4', '1234567893', 'Address 4', 'active'),
(5, 'Customer 5', '1234567894', 'Address 5', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `goodreceivednote`
--

CREATE TABLE `goodreceivednote` (
  `grn_id` int(11) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `input_day` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `total_amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `goodreceivednote`
--

INSERT INTO `goodreceivednote` (`grn_id`, `supplier_id`, `input_day`, `user_id`, `total_amount`) VALUES
(1, 1, '2024-04-01', 2, 5000),
(2, 2, '2024-04-02', 2, 3000),
(3, 3, '2024-04-03', 2, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `grndetail`
--

CREATE TABLE `grndetail` (
  `grn_details_id` int(11) NOT NULL,
  `grn_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price_grn` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grndetail`
--

INSERT INTO `grndetail` (`grn_details_id`, `grn_id`, `quantity`, `product_id`, `price_grn`) VALUES
(1, 1, 1, 1, 10000000.00),
(2, 2, 2, 2, 20000000.00),
(3, 3, 3, 3, 15000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `customer_id`, `user_id`, `invoice_date`, `total_amount`, `status`) VALUES
(1, 1, 4, '2022-01-01', 100.00, 1),
(2, 2, 5, '2022-01-02', 200.00, 1),
(3, 3, 4, '2022-01-03', 150.00, 1),
(4, 4, 5, '2022-01-04', 120.00, 0),
(5, 5, 4, '2022-01-05', 180.00, 0),
(6, 2, 1, '2024-04-29', 50.00, 1);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_detail`
--

CREATE TABLE `invoice_detail` (
  `invoice_detail_id` int(11) NOT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice_detail`
--

INSERT INTO `invoice_detail` (`invoice_detail_id`, `invoice_id`, `quantity`, `product_id`, `price`) VALUES
(1, 1, 3, 1, 10),
(2, 1, 2, 2, 15),
(3, 2, 5, 1, 10),
(4, 3, 1, 3, 20);

-- --------------------------------------------------------

--
-- Table structure for table `origin`
--

CREATE TABLE `origin` (
  `origin_id` int(11) NOT NULL,
  `origin_name` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `origin`
--

INSERT INTO `origin` (`origin_id`, `origin_name`, `status`) VALUES
(1, 'Vietnam', 'active'),
(2, 'China', 'active'),
(3, 'USA', 'active'),
(4, 'India', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `ram` varchar(20) DEFAULT NULL,
  `rom` varchar(20) DEFAULT NULL,
  `battery_capacity` varchar(20) DEFAULT NULL,
  `chip` varchar(20) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `origin_id` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `image_path` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `ram`, `rom`, `battery_capacity`, `chip`, `brand_id`, `origin_id`, `status`, `image_path`) VALUES
(1, 'iPhone 12', '4GB', '64GB', '2815mAh', 'A14 Bionic', 1, 1, 'active', 'C:\\Users\\congh\\OneDrive\\Pictures\\ayaya.jpg'),
(2, 'Redmi Note 10', '6GB', '128GB', '5000mAh', 'Snapdragon 678', 2, 2, 'active', 'C:\\Users\\congh\\OneDrive\\Pictures\\yoimiya.jpg'),
(3, 'Galaxy S21', '8GB', '128GB', '4000mAh', 'Exynos 2100', 3, 3, 'active', 'C:\\Users\\congh\\OneDrive\\Pictures\\luminxamber.jpg'),
(4, 'OnePlus 9 Pro', '12GB', '256GB', '4500mAh', 'Snapdragon 888', 4, 1, 'active', 'C:\\Users\\congh\\OneDrive\\Pictures\\anis.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `description`) VALUES
(1, 'customer', 'Customer role'),
(2, 'admin', 'Admin role'),
(3, 'staff', 'Staff role');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(20) DEFAULT NULL,
  `email_address` varchar(30) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `email_address`, `phone_number`, `address`, `status`) VALUES
(1, 'Supplier 1', 'supplier1@example.com', '9876543210', 'Supplier Address 1', 1),
(2, 'Supplier 2', 'supplier2@example.com', '9876543211', 'Supplier Address 2', 1),
(3, 'Supplier 3', 'supplier3@example.com', '9876543212', 'Supplier Address 3', 1),
(4, 'Supplier 4', 'supplier3@example.com', '9876543212', 'Supplier Address 4', 1),
(5, '555', '555', '5555', '5555', 1),
(6, '66', '66', '66', '66', 0),
(7, 'dsfd', 'afds', 'asfdsa', 'asf', 1),
(8, '888', '88', '888', '888', 1),
(9, '99', '99', '99', '99', 0),
(10, '1', '1', '1', '1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `password`, `full_name`, `date_of_birth`, `phone_number`, `email_address`, `role_id`, `status`) VALUES
(1, 'customer1', 123, 'Customer 1', '1990-01-01', '1234567890', 'customer1@example.com', 1, 1),
(2, 'customer2', 123, 'Customer 2', '1990-01-02', '1234567891', 'customer2@example.com', 1, 1),
(3, 'admin', 123, 'Admin', '1980-01-01', '9876543210', 'admin@example.com', 2, 1),
(4, 'staff1', 123, 'Staff 1', '1995-01-01', '0123456789', 'staff1@example.com', 3, 1),
(5, 'staff2', 123, 'Staff 2', '1995-01-02', '0123456788', 'staff2@example.com', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`product_id`, `quantity`, `price`) VALUES
(1, 9, 3000000.00),
(2, 18, 6000000.00),
(3, 30, 9000000.00),
(4, 40, 12000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `warranty`
--

CREATE TABLE `warranty` (
  `warranty_id` int(11) NOT NULL,
  `invoice_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `warranty_period` varchar(20) DEFAULT NULL,
  `customer_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `warranty`
--

INSERT INTO `warranty` (`warranty_id`, `invoice_id`, `product_id`, `start_date`, `end_date`, `product_name`, `warranty_period`, `customer_name`) VALUES
(1, 1, 1, NULL, NULL, 'iPhone 12', '1 year', 'NARUTO'),
(2, 2, 2, NULL, NULL, 'Redmi Note 10', '2 years', 'SASUKE'),
(3, 3, 3, NULL, NULL, 'Galaxy S21', '1 year', 'SUNEO'),
(4, 4, 4, NULL, NULL, 'OnePlus 9 Pro', '2 years', 'heheboiz');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`brand_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `goodreceivednote`
--
ALTER TABLE `goodreceivednote`
  ADD PRIMARY KEY (`grn_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `grndetail`
--
ALTER TABLE `grndetail`
  ADD PRIMARY KEY (`grn_details_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD PRIMARY KEY (`invoice_detail_id`),
  ADD KEY `invoice_id` (`invoice_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `origin`
--
ALTER TABLE `origin`
  ADD PRIMARY KEY (`origin_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `origin_id` (`origin_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `warranty`
--
ALTER TABLE `warranty`
  ADD PRIMARY KEY (`warranty_id`),
  ADD KEY `invoice_id` (`invoice_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `goodreceivednote`
--
ALTER TABLE `goodreceivednote`
  ADD CONSTRAINT `GoodReceivedNote_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`),
  ADD CONSTRAINT `GoodReceivedNote_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD CONSTRAINT `invoice_detail_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  ADD CONSTRAINT `invoice_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `Product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  ADD CONSTRAINT `Product_ibfk_2` FOREIGN KEY (`origin_id`) REFERENCES `origin` (`origin_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `warranty`
--
ALTER TABLE `warranty`
  ADD CONSTRAINT `Warranty_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  ADD CONSTRAINT `Warranty_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
