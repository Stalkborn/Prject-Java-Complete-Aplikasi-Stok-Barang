-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2023 at 08:50 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_barang`
--

-- --------------------------------------------------------

--
-- Table structure for table `datalogin`
--

CREATE TABLE `datalogin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datalogin`
--

INSERT INTO `datalogin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tabelbarang`
--

CREATE TABLE `tabelbarang` (
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `perushaan` varchar(20) NOT NULL,
  `harga_beli` varchar(20) NOT NULL,
  `harga_jual` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabelbarang`
--

INSERT INTO `tabelbarang` (`id_barang`, `nama_barang`, `perushaan`, `harga_beli`, `harga_jual`) VALUES
('1', 'sunsilk(shampoo)', 'unilever', '2000', '1000'),
('2', 'milo', 'nestle', '2000', '500');

-- --------------------------------------------------------

--
-- Table structure for table `tabelpelanggan`
--

CREATE TABLE `tabelpelanggan` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(10) NOT NULL,
  `alamat` varchar(10) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabelpelanggan`
--

INSERT INTO `tabelpelanggan` (`id`, `nama`, `alamat`, `no_hp`, `email`) VALUES
('1', 'zulfikri', 'keudah', '089665185374', 'stalkborn@gmail.com'),
('2', 'pixelart', 'sigli', '0011122', 'shifi@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datalogin`
--
ALTER TABLE `datalogin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tabelbarang`
--
ALTER TABLE `tabelbarang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tabelpelanggan`
--
ALTER TABLE `tabelpelanggan`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
