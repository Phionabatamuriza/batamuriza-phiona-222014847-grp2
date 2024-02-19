-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:21 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company_managemaent_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(79) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(29) DEFAULT NULL,
  `martial_status` varchar(35) DEFAULT NULL,
  `DoB` varchar(24) DEFAULT NULL,
  `email` varchar(79) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('', '', '', 'Male', '', '', '', ''),
('solange', 'mutesi', '07342656666', 'Female', 'married', '2002', 'solangmutes@gmail.com', '55555'),
('mizero', 'aime', '0798989898', 'Female', 'engaed', '1997', 'mizeroaime', 'mize'),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', ''),
('', '', '', 'Male', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_Id` int(11) NOT NULL,
  `First_Name` varchar(120) DEFAULT NULL,
  `Last_Name` varchar(100) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phone_Number` varchar(15) DEFAULT NULL,
  `Gender` varchar(76) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_Id`, `First_Name`, `Last_Name`, `Email`, `Phone_Number`, `Gender`) VALUES
(1, 'mutesi', 'emme', 'emmemutsi@gmail.com', '078998999', 'Female'),
(2, 'rugema', 'phiona', 'phionabatamuriza25@gmail.com', '07806333307', 'Male'),
(5, 'rutambi', 'trand', 'sad@gmail.com', '07856777', 'Male'),
(6, 'kiki', 'emme', 'emmki@gmail.com', '0723334443', 'Male'),
(7, 'batamuriza', 'phiona', 'phionabatamuriza25@gmail.com', '0780633330', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Department_Id` int(11) NOT NULL,
  `Department_Name` varchar(76) DEFAULT NULL,
  `Department_Location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Department_Id`, `Department_Name`, `Department_Location`) VALUES
(1, 'Marketing', 'Kigali'),
(2, 'Finance', 'Kabare');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_Id` int(11) NOT NULL,
  `Department_Id` int(11) DEFAULT NULL,
  `First_Name` varchar(78) DEFAULT NULL,
  `Last_Name` varchar(98) DEFAULT NULL,
  `Email` varchar(70) DEFAULT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `Gender` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_Id`, `Department_Id`, `First_Name`, `Last_Name`, `Email`, `Position`, `Gender`) VALUES
(2, 2, 'fifi', 'angel', 'angelfif!@gmail.com', 'Accountant', 'Female'),
(3, 1, 'elia', 'mugwaneza', 'mugwelia@gmail.com', 'Security', 'Male'),
(6, 2, 'GY', NULL, 'GGY', 'FFDDD', 'Male'),
(7, 2, 'Gadh', NULL, 'asdfgh@gmail.com', 'hr', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_Id` int(11) NOT NULL,
  `Product_Name` varchar(90) DEFAULT NULL,
  `Product_Price` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_Id`, `Product_Name`, `Product_Price`) VALUES
(1, 'computer', '50,000F'),
(2, 'telephone', '100k');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_Id` int(11) NOT NULL,
  `Product_Id` int(11) DEFAULT NULL,
  `Supplier_Name` varchar(100) DEFAULT NULL,
  `Supplier_Phone` varchar(15) DEFAULT NULL,
  `Email` varchar(70) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_Id`, `Product_Id`, `Supplier_Name`, `Supplier_Phone`, `Email`, `Gender`) VALUES
(2, 1, 'eric', '0789899888', 'eric@gmail.com', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_Id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Department_Id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_Id`),
  ADD KEY `Department_Id` (`Department_Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_Id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_Id`),
  ADD KEY `Product_Id` (`Product_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `Department_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Employee_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `Supplier_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Department_Id`) REFERENCES `department` (`Department_Id`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
