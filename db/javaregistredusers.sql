-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 24, 2021 at 05:07 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaregistredusers`
--

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `roleName`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE cp1250_croatian_ci NOT NULL,
  `password` varchar(200) COLLATE cp1250_croatian_ci NOT NULL,
  `email` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `ime` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `prezime` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `drzava` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `grad` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `brojMobitela` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `pozicija` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `placaProslogMjeseca` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `putniTroskovi` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `bodovi` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `satiMjesecno` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `ukupnoStecenihRadnihSati` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `preostaliDaniGodisnjegOdmora` varchar(40) COLLATE cp1250_croatian_ci NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=cp1250 COLLATE=cp1250_croatian_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `ime`, `prezime`, `drzava`, `grad`, `brojMobitela`, `pozicija`, `placaProslogMjeseca`, `putniTroskovi`, `bodovi`, `satiMjesecno`, `ukupnoStecenihRadnihSati`, `preostaliDaniGodisnjegOdmora`, `roleId`) VALUES
(1, 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'test@gmail.com', 'testIme', 'prezime', 'drzava', 'grad', '123', '1', '2333', '234', '300', '160', '3000', '23', 1),
(25, 'proba', '37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578', 'proba@test.hr', 'probaIme', '', '', '', '', '', '', '', '', '', '', '', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
