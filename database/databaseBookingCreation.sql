-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Time: 21 2015
-- server: 5.6.21
-- PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `BookingProject`
--

-- --------------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `bookingproject` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `bookingproject` ;

--
-- Table `apartments`
--

CREATE TABLE IF NOT EXISTS `apartments` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `apclasses`
--

CREATE TABLE IF NOT EXISTS `apclasses` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `classId` tinyint(4) NOT NULL DEFAULT '1',
  `desc_text` text NOT NULL,
  `num_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `num_id` (`num_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(100) NOT NULL,
  `reg_num` varchar(100) NOT NULL,
  `pers_num` varchar(100) NOT NULL,
  `corp` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `head` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `client_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `comments_ibfk_1`
    FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `extras`
--

CREATE TABLE IF NOT EXISTS `extras` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `cost` double NOT NULL DEFAULT '0',
  `pic` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `extra_reservation_relations`
--

CREATE TABLE IF NOT EXISTS `extra_reservation_relations` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `res_id` int(11) NOT NULL,
  `extra_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `res_id` (`res_id`, `extra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `functions`
--

CREATE TABLE IF NOT EXISTS `functions` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  `desc_text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL DEFAULT '0',
  `desc_text` text NOT NULL,
  `pay_type` tinyint(4) NOT NULL DEFAULT '1',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `referent` varchar(255) NOT NULL,
  `client_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `payments_ibfk_1`
    FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  `desc_text` text NOT NULL,
  `func_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `func_id` (`func_id`),
  CONSTRAINT `roles_ibfk_1`
  FOREIGN KEY (`func_id`) REFERENCES `functions` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `p_count` int(11) NOT NULL,
  `price_per_day` double NOT NULL,
  `desc_text` text NOT NULL,
  `texn_repo` date NOT NULL,
  `apclass_id` int(11) UNSIGNED NOT NULL,
  `ap_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `apclass_id` (`apclass_id`),
  KEY `ap_id` (`ap_id`),
  CONSTRAINT `rooms_ibfk_1`
  FOREIGN KEY (`ap_id`) REFERENCES `apartments` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `rooms_ibfk_2`
  FOREIGN KEY (`apclass_id`) REFERENCES `apclasses` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `p_count` int(11) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `room_id` int(11) UNSIGNED NOT NULL,
  `client_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `reservations_ibfk_1`
    FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `reservations_ibfk_2`
    FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `thumbs`
--

CREATE TABLE IF NOT EXISTS `thumbs` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `orig` varchar(255) NOT NULL,
  `room_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `thumbs_ibfk_1`
    FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_modify` date NOT NULL,
  `pub_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1`
    FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
