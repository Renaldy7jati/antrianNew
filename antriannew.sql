-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2024 at 05:12 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `antriannew`
--

-- --------------------------------------------------------

--
-- Table structure for table `td_antrian_harian`
--

CREATE TABLE `td_antrian_harian` (
  `ID_ANTRIAN_HARIAN` varchar(255) NOT NULL,
  `KODE_ANTRIAN` varchar(5) NOT NULL,
  `NOMOR_ANTRIAN` int(255) NOT NULL,
  `STATUS` char(3) DEFAULT NULL,
  `WAKTU_AMBIL_ANTRIAN` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `td_antrian_harian`
--

INSERT INTO `td_antrian_harian` (`ID_ANTRIAN_HARIAN`, `KODE_ANTRIAN`, `NOMOR_ANTRIAN`, `STATUS`, `WAKTU_AMBIL_ANTRIAN`) VALUES
('100787832569725665', 'LK001', 1, 'Y', '2024-04-07 03:59:15'),
('100787832569725666', 'LK001', 2, 'Y', '2024-04-07 03:59:16'),
('100787832569725667', 'LK001', 3, 'Y', '2024-04-07 03:59:16'),
('100787832569725669', 'LK001', 4, 'Y', '2024-04-07 03:59:16'),
('100787832569725672', 'LK001', 5, 'Y', '2024-04-07 03:59:16'),
('100787832569725676', 'LK002', 1, 'Y', '2024-04-07 03:59:17'),
('100787832569725677', 'LK002', 2, 'Y', '2024-04-07 03:59:17'),
('100788151773036544', 'LK001', 6, NULL, '2024-04-07 15:03:55'),
('100788151773036549', 'LK002', 3, NULL, '2024-04-07 15:03:57'),
('100788151773036551', 'LK003', 1, NULL, '2024-04-07 15:03:59'),
('100788151773036552', 'LK004', 1, NULL, '2024-04-07 15:04:01'),
('100788151773036553', 'LK005', 1, NULL, '2024-04-07 15:04:02'),
('100788931661922304', 'LK001', 1, 'Y', '2024-04-07 20:23:13'),
('100788931661922305', 'LK002', 1, 'Y', '2024-04-07 20:23:14'),
('100788931661922306', 'LK003', 1, NULL, '2024-04-07 20:23:15'),
('100788931661922307', 'LK001', 2, 'Y', '2024-04-07 20:23:16'),
('100788931661922308', 'LK001', 3, 'Y', '2024-04-07 20:23:16'),
('100788931661922310', 'LK001', 4, NULL, '2024-04-07 20:23:17'),
('100788931661922313', 'LK001', 5, NULL, '2024-04-07 20:23:17'),
('100788931661922317', 'LK001', 6, NULL, '2024-04-07 20:23:17'),
('100788931661922322', 'LK001', 7, NULL, '2024-04-07 20:23:18'),
('100788931661922328', 'LK001', 8, NULL, '2024-04-08 08:11:36'),
('100788931661922335', 'LK002', 2, NULL, '2024-04-08 08:11:36'),
('100788931661922336', 'LK001', 9, NULL, '2024-04-08 08:11:38'),
('100788931661922344', 'LK002', 3, NULL, '2024-04-08 08:11:39'),
('100788931661922346', 'LK001', 10, NULL, '2024-04-08 08:11:39'),
('100788931661922355', 'LK002', 4, NULL, '2024-04-08 08:11:39'),
('100788931661922358', 'LK001', 11, NULL, '2024-04-08 08:11:40'),
('100788931661922368', 'LK002', 5, NULL, '2024-04-08 08:11:40'),
('100788931661922372', 'LK001', 12, NULL, '2024-04-08 08:11:40'),
('100788931661922383', 'LK002', 6, NULL, '2024-04-08 08:11:41'),
('100788931661922388', 'LK001', 13, NULL, '2024-05-14 08:11:41'),
('100788931661922400', 'LK002', 7, NULL, '2024-04-08 08:11:41'),
('100792582837108736', 'LK001', 1, 'Y', '2024-04-10 08:49:20'),
('100792582837108737', 'LK001', 2, NULL, '2024-04-10 08:49:20'),
('100792582837108738', 'LK001', 3, NULL, '2024-04-10 08:49:21'),
('100792582837108740', 'LK001', 4, NULL, '2024-04-10 08:49:21'),
('100792582837108743', 'LK002', 1, 'Y', '2024-04-10 08:49:21'),
('100792582837108744', 'LK002', 2, NULL, '2024-04-10 08:49:21'),
('100792582837108745', 'LK002', 3, NULL, '2024-04-10 08:49:22'),
('100792582837108747', 'LK002', 4, NULL, '2024-04-10 08:49:22'),
('100792582837108750', 'LK002', 5, NULL, '2024-04-10 08:49:22'),
('100792582837108754', 'LK002', 6, NULL, '2024-04-10 08:49:22'),
('100792582837108759', 'LK003', 1, NULL, '2024-04-10 08:49:23'),
('100792582837108760', 'LK003', 2, NULL, '2024-04-10 08:49:23'),
('100792582837108761', 'LK003', 3, NULL, '2024-04-10 08:49:23'),
('100792582837108763', 'LK003', 4, NULL, '2024-04-10 08:49:23'),
('100792582837108766', 'LK003', 5, NULL, '2024-04-10 08:49:23'),
('100792582837108770', 'LK004', 1, NULL, '2024-04-10 08:49:24'),
('100792582837108771', 'LK004', 2, NULL, '2024-04-10 08:49:24'),
('100792582837108772', 'LK004', 3, NULL, '2024-04-10 08:49:24'),
('100792582837108774', 'LK005', 1, NULL, '2024-04-10 08:49:25'),
('100792582837108775', 'LK005', 2, NULL, '2024-04-10 08:49:25'),
('100792582837108776', 'LK005', 3, NULL, '2024-04-10 08:49:25'),
('100792582837108778', 'LK005', 4, NULL, '2024-04-10 08:49:25'),
('100806986530029568', 'LK001', 1, 'Y', '2024-04-20 12:35:11'),
('100806986530029569', 'LK001', 2, 'Y', '2024-04-20 12:35:20'),
('100806986530029570', 'LK001', 3, 'Y', '2024-04-20 12:35:20'),
('100842196369932288', 'LK002', 1, NULL, '2024-05-14 14:49:36'),
('100842196369932289', 'LK001', 14, NULL, '2024-05-14 14:49:36'),
('100842196369932290', 'LK001', 15, NULL, '2024-05-14 14:50:32'),
('100842196369932292', 'LK001', 16, NULL, '2024-05-14 15:00:14'),
('100842196369932295', 'LK001', 17, NULL, '2024-05-14 15:00:14'),
('100843617232355328', 'LK001', 1, NULL, '2024-05-15 13:46:01'),
('100843617232355329', 'LK001', 2, NULL, '2024-05-15 13:47:16'),
('100843617232355330', 'LK002', 1, NULL, '2024-05-15 13:54:49'),
('100843617232355331', 'LK001', 3, NULL, '2024-05-15 13:54:52'),
('100843617232355333', 'LK001', 4, NULL, '2024-05-15 14:01:18'),
('100843617232355336', 'LK002', 2, NULL, '2024-05-15 14:01:20'),
('100843617232355337', 'LK003', 1, NULL, '2024-05-15 14:01:22'),
('100843617232355338', 'LK004', 1, NULL, '2024-05-15 14:01:22'),
('100843617232355339', 'LK001', 5, NULL, '2024-05-15 14:13:18'),
('100843617232355343', 'LK001', 6, NULL, '2024-05-15 14:13:41'),
('100843617232355348', 'LK001', 7, NULL, '2024-05-15 14:21:52'),
('100843617232355354', 'LK001', 8, NULL, '2024-05-15 14:22:12'),
('100843617232355361', 'LK001', 9, NULL, '2024-05-15 14:24:13'),
('100843617232355369', 'LK001', 10, NULL, '2024-05-15 14:25:07'),
('100843617232355378', 'LK001', 11, NULL, '2024-05-15 14:39:45'),
('100843617232355388', 'LK002', 3, NULL, '2024-05-15 14:39:49'),
('100843617232355390', 'LK003', 2, NULL, '2024-05-15 14:39:50'),
('100843617232355391', 'LK001', 12, NULL, '2024-05-15 14:39:50'),
('100843617232355402', 'LK002', 4, NULL, '2024-05-15 14:39:51'),
('100843617232355405', 'LK001', 13, NULL, '2024-05-15 14:40:26'),
('100843617232355417', 'LK001', 14, NULL, '2024-05-15 14:40:27'),
('100843617232355430', 'LK001', 15, NULL, '2024-05-15 14:40:53'),
('100843617232355444', 'LK002', 5, NULL, '2024-05-15 14:40:54'),
('100843617232355448', 'LK003', 3, NULL, '2024-05-15 14:40:55'),
('100843617232355450', 'LK003', 4, NULL, '2024-05-15 14:40:55'),
('100843617232355453', 'LK001', 16, NULL, '2024-05-15 14:40:57'),
('100843617232355468', 'LK002', 6, NULL, '2024-05-15 14:40:57'),
('100843617232355473', 'LK003', 5, NULL, '2024-05-15 14:40:58'),
('100843617232355477', 'LK001', 17, NULL, '2024-05-15 14:42:22'),
('100843617232355493', 'LK002', 7, NULL, '2024-05-15 14:42:24'),
('100843617232355499', 'LK003', 6, NULL, '2024-05-15 14:42:25'),
('100843617232355504', 'LK004', 2, NULL, '2024-05-15 14:42:25'),
('100843617232355505', 'LK002', 8, NULL, '2024-05-15 14:42:26'),
('100843617232355512', 'LK001', 18, NULL, '2024-05-15 14:42:27'),
('100843617232355529', 'LK001', 19, NULL, '2024-05-15 14:43:10'),
('100843617232355547', 'LK001', 20, NULL, '2024-05-15 14:50:02'),
('100843617232355566', 'LK001', 21, NULL, '2024-05-15 14:52:42'),
('100843617232355586', 'LK001', 22, NULL, '2024-05-15 14:54:30'),
('100843617232355607', 'LK001', 23, NULL, '2024-05-15 14:54:55'),
('100843617232355629', 'LK001', 24, NULL, '2024-05-15 14:55:22'),
('100843617232355652', 'LK001', 25, NULL, '2024-05-15 14:55:23'),
('100843617232355676', 'LK001', 26, NULL, '2024-05-15 15:02:08'),
('100843617232355701', 'LK001', 27, NULL, '2024-05-15 15:02:33'),
('100843617232355727', 'LK001', 28, NULL, '2024-05-15 15:02:34'),
('100843617232355754', 'LK001', 29, NULL, '2024-05-15 15:03:36'),
('100843617232355782', 'LK002', 9, NULL, '2024-05-15 15:03:37'),
('100843617232355790', 'LK003', 7, NULL, '2024-05-15 15:03:38'),
('100845057506017280', 'LK001', 1, NULL, '2024-05-16 13:36:24'),
('100845057506017281', 'LK001', 2, NULL, '2024-05-16 13:37:31'),
('100845057506017282', 'LK001', 3, NULL, '2024-05-16 13:53:11'),
('100845057506017284', 'LK002', 1, NULL, '2024-05-16 13:53:14'),
('100845057506017285', 'LK001', 4, NULL, '2024-05-16 14:16:00'),
('100845057506017288', 'LK002', 2, NULL, '2024-05-16 14:16:02'),
('100845057506017289', 'LK001', 5, NULL, '2024-05-16 14:16:03'),
('100845057506017293', 'LK001', 6, NULL, '2024-05-16 14:23:11'),
('100845057506017298', 'LK001', 1, NULL, '2024-05-17 16:03:26'),
('100845057506017299', 'LK001', 2, NULL, '2024-05-17 16:03:47'),
('100845057506017300', 'LK002', 1, NULL, '2024-05-17 16:03:53'),
('100845057506017301', 'LK001', 3, NULL, '2024-05-17 16:04:00'),
('100845057506017303', 'LK001', 4, NULL, '2024-05-17 16:35:35'),
('100845057506017306', 'LK001', 5, NULL, '2024-05-17 16:40:34'),
('100845057506017310', 'LK002', 2, NULL, '2024-05-17 16:40:36'),
('100845057506017311', 'LK001', 6, NULL, '2024-05-17 16:41:23'),
('100845057506017316', 'LK001', 7, NULL, '2024-05-17 16:45:58'),
('100845057506017322', 'LK001', 8, NULL, '2024-05-17 16:46:45'),
('100845057506017329', 'LK001', 9, NULL, '2024-05-17 16:57:24'),
('100845057506017337', 'LK001', 10, NULL, '2024-05-17 16:57:25'),
('100845057506017346', 'LK001', 11, NULL, '2024-05-17 16:57:26'),
('100845057506017356', 'LK001', 12, NULL, '2024-05-17 16:57:26'),
('100845057506017367', 'LK001', 13, NULL, '2024-05-17 16:57:26'),
('100845057506017379', 'LK001', 14, NULL, '2024-05-17 16:57:26'),
('100845057506017392', 'LK001', 15, NULL, '2024-05-17 16:57:26'),
('100845057506017406', 'LK002', 3, NULL, '2024-05-17 16:57:27'),
('100845057506017408', 'LK002', 4, NULL, '2024-05-17 16:57:27'),
('100845057506017411', 'LK002', 5, NULL, '2024-05-17 16:57:27'),
('100845057506017415', 'LK002', 6, NULL, '2024-05-17 16:57:27'),
('100845057506017420', 'LK001', 1, NULL, '2024-05-17 17:04:20'),
('100845057506017421', 'LK001', 2, NULL, '2024-05-17 17:08:27'),
('100845057506017422', 'LK002', 1, NULL, '2024-05-17 17:08:28'),
('100845057506017423', 'LK003', 1, NULL, '2024-05-17 17:08:30'),
('100845057506017424', 'LK001', 3, NULL, '2024-05-17 17:18:05'),
('100845057506017426', 'LK001', 4, NULL, '2024-05-17 17:30:35'),
('100845057506017429', 'LK001', 5, NULL, '2024-05-17 17:33:01'),
('100845057506017433', 'LK002', 2, NULL, '2024-05-17 17:33:02'),
('100845057506017434', 'LK002', 3, NULL, '2024-05-17 17:33:03'),
('100845057506017436', 'LK001', 6, NULL, '2024-05-17 17:49:02'),
('100845057506017441', 'LK001', 7, NULL, '2024-05-17 17:59:46'),
('100845057506017447', 'LK002', 4, NULL, '2024-05-17 17:59:47'),
('100845057506017450', 'LK003', 2, NULL, '2024-05-17 17:59:48'),
('100845057506017451', 'LK001', 8, NULL, '2024-05-17 18:03:44'),
('100845057506017458', 'LK002', 5, NULL, '2024-05-17 18:03:46'),
('100845057506017462', 'LK001', 9, NULL, '2024-05-17 18:04:54'),
('100845057506017470', 'LK001', 10, NULL, '2024-05-17 18:04:55'),
('100845057506017479', 'LK001', 11, NULL, '2024-05-17 18:05:30'),
('100845057506017489', 'LK002', 6, NULL, '2024-05-17 18:05:31'),
('100845057506017494', 'LK003', 3, NULL, '2024-05-17 18:05:31'),
('100848772115857408', 'LK001', 1, NULL, '2024-05-19 03:07:00'),
('100848772115857409', 'LK002', 1, NULL, '2024-05-19 03:07:06'),
('100848772115857410', 'LK001', 2, NULL, '2024-05-19 03:07:08'),
('100848772115857411', 'LK002', 2, NULL, '2024-05-19 03:07:09'),
('100848772115857412', 'LK001', 3, NULL, '2024-05-19 03:07:10'),
('100848772115857414', 'LK002', 3, NULL, '2024-05-19 03:07:10'),
('100848772115857416', 'LK001', 4, NULL, '2024-05-19 03:07:10'),
('100848772115857419', 'LK002', 4, NULL, '2024-05-19 03:07:11'),
('100848772115857422', 'LK001', 5, NULL, '2024-05-19 03:07:11'),
('100848772115857426', 'LK002', 5, NULL, '2024-05-19 03:07:11'),
('100848772115857430', 'LK001', 6, NULL, '2024-05-19 03:07:12'),
('100848772115857435', 'LK002', 6, NULL, '2024-05-19 03:07:12'),
('100848772115857440', 'LK001', 7, NULL, '2024-05-19 03:07:12'),
('100848772115857446', 'LK002', 7, NULL, '2024-05-19 03:07:12'),
('100848772115857452', 'LK001', 8, NULL, '2024-05-19 03:07:13'),
('100848772115857459', 'LK002', 8, NULL, '2024-05-19 03:07:13'),
('100848772115857466', 'LK001', 9, NULL, '2024-05-19 03:07:13'),
('100848772115857474', 'LK002', 9, NULL, '2024-05-19 03:07:13'),
('100848772115857482', 'LK002', 10, NULL, '2024-05-19 03:07:14'),
('100855027047858176', 'LK001', 1, NULL, '2024-05-24 04:55:15'),
('100855027047858177', 'LK001', 2, NULL, '2024-05-24 04:57:08'),
('100855027047858178', 'LK001', 3, NULL, '2024-05-24 04:57:59'),
('100855027047858180', 'LK001', 4, NULL, '2024-05-24 05:25:17'),
('100855027047858183', 'LK001', 5, NULL, '2024-05-24 05:25:38'),
('100855027047858187', 'LK002', 1, NULL, '2024-05-24 05:34:05'),
('100855027047858188', 'LK001', 6, NULL, '2024-05-24 05:35:09'),
('100855027047858193', 'LK002', 2, NULL, '2024-05-24 05:37:13'),
('100855027047858194', 'LK003', 1, NULL, '2024-05-24 05:37:17'),
('100855027047858195', 'LK001', 7, NULL, '2024-05-24 05:37:34'),
('100855027047858201', 'LK001', 8, NULL, '2024-05-24 06:23:04'),
('100863892095238144', 'LK001', 1, NULL, '2024-05-29 13:26:24'),
('100863892095238145', 'LK002', 1, NULL, '2024-05-29 13:26:26'),
('100863892095238146', 'LK003', 1, NULL, '2024-05-29 13:26:28'),
('100863892095238147', 'LK001', 2, NULL, '2024-05-29 13:26:29'),
('100868211171393536', 'LK001', 1, 'Y', '2024-06-01 13:05:17'),
('100868211171393537', 'LK001', 2, 'Y', '2024-06-01 14:25:43'),
('100868211171393538', 'LK001', 3, NULL, '2024-06-01 14:25:45'),
('100868211171393540', 'LK002', 1, 'Y', '2024-06-01 14:25:52'),
('100868211171393541', 'LK001', 4, NULL, '2024-06-01 14:25:58'),
('100868211171393544', 'LK001', 5, NULL, '2024-06-01 14:25:59'),
('100868211171393548', 'LK001', 6, NULL, '2024-06-01 14:25:59'),
('100868211171393553', 'LK001', 7, NULL, '2024-06-01 14:26:00');

-- --------------------------------------------------------

--
-- Table structure for table `td_user`
--

CREATE TABLE `td_user` (
  `ID_USER` varchar(255) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `NAMA` varchar(255) NOT NULL,
  `ID_ROLE` varchar(255) NOT NULL,
  `WAKTU_UPDATE` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `td_user`
--

INSERT INTO `td_user` (`ID_USER`, `USER_NAME`, `PASSWORD`, `NAMA`, `ID_ROLE`, `WAKTU_UPDATE`) VALUES
('022de577-f8a9-11ee-bada-00090ffe0001', 'LOKET1', 'CCC', 'USER LOKET1', 'f6851fdc-f8a8-11ee-bada-00090ffe0001', '2024-04-12 15:45:26'),
('100793784656199680', 'FNLI', 'Tahutempe1!', 'Renauldy', '1', '2024-04-11 15:23:21'),
('100795463636090881', 'ADMIN', 'ADMIN024', 'ALDY23', '2a18be43-f8a8-11ee-bada-00090ffe0001', '2024-04-12 16:15:46'),
('100799565145309184', 'AMBIL_ANTRIAN', '123456', 'AMBIL ANTRIAN', 'bba94566-faed-11ee-8b53-00090ffe0001', '2024-04-15 13:09:03'),
('100799565145309185', 'LAYAR', '123456', 'LAYAR', '205cc0e8-faf0-11ee-8b53-00090ffe0001', '2024-04-15 13:19:51');

-- --------------------------------------------------------

--
-- Table structure for table `tr_antrian`
--

CREATE TABLE `tr_antrian` (
  `ID_ANTRIAN` varchar(26) NOT NULL,
  `KODE_ANTRIAN` varchar(5) NOT NULL,
  `URAIAN_ANTRIAN` text NOT NULL,
  `WAKTU_UPDATE` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tr_antrian`
--

INSERT INTO `tr_antrian` (`ID_ANTRIAN`, `KODE_ANTRIAN`, `URAIAN_ANTRIAN`, `WAKTU_UPDATE`) VALUES
('100777344108593159', 'LK001', 'PENAGIHAN 2', '2024-03-31 07:17:24'),
('100787104740540491', 'LK002', 'PEMBAYARAN', '2024-04-06 15:03:18');

-- --------------------------------------------------------

--
-- Table structure for table `tr_role`
--

CREATE TABLE `tr_role` (
  `ID_ROLE` varchar(255) NOT NULL,
  `NAMA_ROLE` varchar(255) NOT NULL,
  `URAIAN` varchar(255) NOT NULL,
  `WAKTU_UPDATE` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tr_role`
--

INSERT INTO `tr_role` (`ID_ROLE`, `NAMA_ROLE`, `URAIAN`, `WAKTU_UPDATE`) VALUES
('205cc0e8-faf0-11ee-8b53-00090ffe0001', 'LAYAR', 'USER UNTUK LAYAR', '2024-04-15 13:19:33'),
('2a18be43-f8a8-11ee-bada-00090ffe0001', 'ADMINISTRATOR', 'ADMINISTRATOR', '2024-04-12 15:39:23'),
('bba94566-faed-11ee-8b53-00090ffe0001', 'AMBIL_ANTRIAN', 'USER UNTUK AMBIL ANTRIAN', '2024-04-15 13:02:25'),
('f6851fdc-f8a8-11ee-bada-00090ffe0001', 'LOKET', 'USER LOKET', '2024-04-12 15:45:06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `td_antrian_harian`
--
ALTER TABLE `td_antrian_harian`
  ADD PRIMARY KEY (`ID_ANTRIAN_HARIAN`);

--
-- Indexes for table `td_user`
--
ALTER TABLE `td_user`
  ADD PRIMARY KEY (`ID_USER`),
  ADD UNIQUE KEY `USER_NAME` (`USER_NAME`);

--
-- Indexes for table `tr_antrian`
--
ALTER TABLE `tr_antrian`
  ADD PRIMARY KEY (`ID_ANTRIAN`);

--
-- Indexes for table `tr_role`
--
ALTER TABLE `tr_role`
  ADD PRIMARY KEY (`ID_ROLE`),
  ADD UNIQUE KEY `NAMA_ROLE` (`NAMA_ROLE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;