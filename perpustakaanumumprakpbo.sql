-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 06:09 AM
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
-- Database: `perpustakaanumumprakpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `dataperpus`
--

CREATE TABLE `dataperpus` (
  `id` int(11) NOT NULL,
  `judul` varchar(77) NOT NULL,
  `genre` varchar(77) NOT NULL,
  `penulis` varchar(77) NOT NULL,
  `penerbit` varchar(77) NOT NULL,
  `lokasi` varchar(77) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dataperpus`
--

INSERT INTO `dataperpus` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) VALUES
(1, 'Macan Yang Berkokok', 'Romansa', 'Valentino Abinata', 'UPNVY', 'Jakal', 68),
(2, 'Ayam yang berkokok', 'Realistis', 'Agung', 'Bumi', 'Bumi', 1),
(3, 'Beruang yang menghemat listrik', 'Humor', 'Badut', 'The Clown', 'Jalan Kaliurang', 6),
(4, 'Macan yang Menge moo', 'Humor', 'Valentino Abinata', 'UPNVY', 'Jakal', 3),
(5, 'Ayam yang Mengaung', 'Horor', 'Bukan Valentino', 'asda', 'ja', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dataperpus`
--
ALTER TABLE `dataperpus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dataperpus`
--
ALTER TABLE `dataperpus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
