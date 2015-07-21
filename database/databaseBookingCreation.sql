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

--
-- Table `apartaments`
--
CREATE SCHEMA IF NOT EXISTS `BookingProject` DEFAULT CHARACTER SET utf8 ;
USE `BookingProject` ;


CREATE TABLE IF NOT EXISTS `apartaments` (
`id` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `desc_text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `apclasses`
--

CREATE TABLE IF NOT EXISTS `apclasses` (
`id` int(11) NOT NULL,
  `classId` tinyint(4) NOT NULL DEFAULT '1',
  `desc_text` text CHARACTER SET utf32 NOT NULL,
  `num_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
`id` int(11) unsigned NOT NULL,
  `head` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `klient_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `extras`
--

CREATE TABLE IF NOT EXISTS `extras` (
`id` int(11) unsigned NOT NULL,
  `label` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `cost` double NOT NULL DEFAULT '0',
  `pic` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `extra_rezervation_relations`
--

CREATE TABLE IF NOT EXISTS `extra_rezervation_relations` (
`id` int(11) NOT NULL,
  `rez_id` int(11) NOT NULL,
  `extra_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `functions`
--

CREATE TABLE IF NOT EXISTS `functions` (
`id` int(11) NOT NULL,
  `label` varchar(100) NOT NULL,
  `desc_text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `klients`
--

CREATE TABLE IF NOT EXISTS `klients` (
`id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf32 NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(100) NOT NULL,
  `reg_num` varchar(100) NOT NULL,
  `pers_num` varchar(100) NOT NULL,
  `corp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `paiments`
--

CREATE TABLE IF NOT EXISTS `paiments` (
`id` int(11) NOT NULL,
  `money` double NOT NULL DEFAULT '0',
  `desc_text` text NOT NULL,
  `pay_type` tinyint(4) NOT NULL DEFAULT '1',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `referent` varchar(255) NOT NULL,
  `klient_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `rezervations`
--

CREATE TABLE IF NOT EXISTS `rezervations` (
`id` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `p_count` int(11) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `room_id` int(11) NOT NULL,
  `klient_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
`id` int(11) NOT NULL,
  `label` varchar(100) NOT NULL,
  `desc_text` text CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL,
  `func_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
`id` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `p_count` int(11) NOT NULL,
  `price_per_day` double NOT NULL,
  `desc_text` text NOT NULL,
  `texn_repo` date NOT NULL,
  `apclass_id` int(11) NOT NULL,
  `ap_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `thumbs`
--

CREATE TABLE IF NOT EXISTS `thumbs` (
`id` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `desc_text` text NOT NULL,
  `orig` varchar(255) NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_modify` date NOT NULL,
  `pub_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes
--

--
-- Index `apartaments`
--
ALTER TABLE `apartaments`
 ADD PRIMARY KEY (`id`);

--
-- Index `apclasses`
--
ALTER TABLE `apclasses`
 ADD PRIMARY KEY (`id`), ADD KEY `num_id` (`num_id`);

--
-- Index `comments`
--
ALTER TABLE `comments`
 ADD PRIMARY KEY (`id`), ADD KEY `klient_id` (`klient_id`);

--
-- Index `extras`
--
ALTER TABLE `extras`
 ADD PRIMARY KEY (`id`);

--
-- Index `extra_rezervation_relations`
--
ALTER TABLE `extra_rezervation_relations`
 ADD PRIMARY KEY (`id`), ADD KEY `rez_id` (`rez_id`,`extra_id`);

--
-- Index `functions`
--
ALTER TABLE `functions`
 ADD PRIMARY KEY (`id`);

--
-- Index `klients`
--
ALTER TABLE `klients`
 ADD PRIMARY KEY (`id`);

--
-- Index `paiments`
--
ALTER TABLE `paiments`
 ADD PRIMARY KEY (`id`), ADD KEY `klient_id` (`klient_id`);

--
-- Index `rezervations`
--
ALTER TABLE `rezervations`
 ADD PRIMARY KEY (`id`), ADD KEY `room_id` (`room_id`), ADD KEY `klient_id` (`klient_id`);

--
-- Index `roles`
--
ALTER TABLE `roles`
 ADD PRIMARY KEY (`id`), ADD KEY `func_id` (`func_id`);

--
-- Index `rooms`
--
ALTER TABLE `rooms`
 ADD PRIMARY KEY (`id`), ADD KEY `apclass_id` (`apclass_id`), ADD KEY `ap_id` (`ap_id`);

--
-- Index `thumbs`
--
ALTER TABLE `thumbs`
 ADD PRIMARY KEY (`id`), ADD KEY `room_id` (`room_id`);

--
-- Index `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`), ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT 
--

--
-- AUTO_INCREMENT for `apartaments`
--
ALTER TABLE `apartaments`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `apclasses`
--
ALTER TABLE `apclasses`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `comments`
--
ALTER TABLE `comments`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `extras`
--
ALTER TABLE `extras`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `extra_rezervation_relations`
--
ALTER TABLE `extra_rezervation_relations`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `functions`
--
ALTER TABLE `functions`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `klients`
--
ALTER TABLE `klients`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `paiments`
--
ALTER TABLE `paiments`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `rezervations`
--
ALTER TABLE `rezervations`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `roles`
--
ALTER TABLE `roles`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `rooms`
--
ALTER TABLE `rooms`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `thumbs`
--
ALTER TABLE `thumbs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Foreign key
--

--
-- Foreign key `comments`
--
ALTER TABLE `comments`
ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klients` (`id`);

--
-- Foreign key `paiments`
--
ALTER TABLE `paiments`
ADD CONSTRAINT `paiments_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klients` (`id`);

--
-- Foreign key `rezervations`
--
ALTER TABLE `rezervations`
ADD CONSTRAINT `rezervations_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
ADD CONSTRAINT `rezervations_ibfk_2` FOREIGN KEY (`klient_id`) REFERENCES `klients` (`id`);

--
-- Foreign key `roles`
--
ALTER TABLE `roles`
ADD CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`func_id`) REFERENCES `functions` (`id`);

--
-- Foreign key `rooms`
--
ALTER TABLE `rooms`
ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`ap_id`) REFERENCES `apartaments` (`id`),
ADD CONSTRAINT `rooms_ibfk_2` FOREIGN KEY (`apclass_id`) REFERENCES `apclasses` (`id`);

--
-- Foreign key `thumbs`
--
ALTER TABLE `thumbs`
ADD CONSTRAINT `thumbs_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`);

--
-- Foreign key `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
