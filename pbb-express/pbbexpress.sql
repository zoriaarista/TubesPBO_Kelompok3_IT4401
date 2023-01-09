-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2023 at 12:00 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbbexpress`
--
CREATE DATABASE IF NOT EXISTS `pbbexpress` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `pbbexpress`;

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `nomor` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `wilayah_bekerja` varchar(255) DEFAULT NULL,
  `jenis_akun_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `username`, `password`, `nama`, `nomor`, `alamat`, `wilayah_bekerja`, `jenis_akun_id`) VALUES
(1, 'john', '12345', 'John Wick', NULL, NULL, NULL, 1),
(2, 'jack', '321', 'Jack Fruit', '08999999999', 'Sukabumi', NULL, 4),
(3, 'edward', '11111', 'Edward Elric', '08919191919', 'Padang', NULL, 3),
(4, 'adi', '00000', 'Adi Sucipto', '08123456789', NULL, 'Sukabumi', 2),
(5, 'udin', '112233', 'Udin Gambut', '081234567890', 'Jakarta', NULL, 3),
(8, 'juki', '123123', 'Muhammad Marjuki', '082233445566', 'Jakarta', 'Jakarta', 2),
(9, 'edi', '123123', 'Edi Suryana', '0812345678', 'Balikpapan', NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `jenis_barang` varchar(255) NOT NULL,
  `berat_barang` int(11) NOT NULL,
  `lokasi_barang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `jenis_barang`, `berat_barang`, `lokasi_barang`) VALUES
(1, 'Pakaian', 1, 'Bandung'),
(2, 'Elektronik', 5, 'Surakarta');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_akun`
--

CREATE TABLE `jenis_akun` (
  `id` int(11) NOT NULL,
  `jenis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis_akun`
--

INSERT INTO `jenis_akun` (`id`, `jenis`) VALUES
(1, 'Admin'),
(2, 'Kurir'),
(3, 'Penerima'),
(4, 'Pengirim');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `nomor_resi` varchar(255) NOT NULL,
  `metode` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`nomor_resi`, `metode`) VALUES
('78971f38-4375-4386-89c3-4f76961686ef', 'DANA');

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id` int(11) NOT NULL,
  `barang_id` int(11) NOT NULL,
  `pengirim_id` int(11) NOT NULL,
  `penerima_id` int(11) NOT NULL,
  `tanggal_kirim` date NOT NULL,
  `biaya_kirim` int(11) NOT NULL,
  `nomor_resi` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id`, `barang_id`, `pengirim_id`, `penerima_id`, `tanggal_kirim`, `biaya_kirim`, `nomor_resi`, `status`) VALUES
(1, 1, 9, 3, '2023-01-06', 30000, '1625da4d-2099-4b93-a97d-d8d7759a5199', 'Diterima'),
(2, 2, 2, 3, '2023-01-06', 500000, '78971f38-4375-4386-89c3-4f76961686ef', 'Diterima');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `akun_pk` (`username`),
  ADD KEY `akun_jenis_akun_null_fk` (`jenis_akun_id`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jenis_akun`
--
ALTER TABLE `jenis_akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`nomor_resi`),
  ADD UNIQUE KEY `pembayaran_pk` (`nomor_resi`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pesanan_akun_penerima_fk` (`penerima_id`),
  ADD KEY `pesanan_akun_pengirim_fk` (`pengirim_id`),
  ADD KEY `pesanan_barang_null_fk` (`barang_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jenis_akun`
--
ALTER TABLE `jenis_akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `akun`
--
ALTER TABLE `akun`
  ADD CONSTRAINT `akun_jenis_akun_null_fk` FOREIGN KEY (`jenis_akun_id`) REFERENCES `jenis_akun` (`id`);

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_akun_penerima_fk` FOREIGN KEY (`penerima_id`) REFERENCES `akun` (`id`),
  ADD CONSTRAINT `pesanan_akun_pengirim_fk` FOREIGN KEY (`pengirim_id`) REFERENCES `akun` (`id`),
  ADD CONSTRAINT `pesanan_barang_null_fk` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
