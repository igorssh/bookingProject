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


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `BookingProject`
--

-- --------------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `bookingproject`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_unicode_ci;
USE `bookingproject`;


--
-- DROP tables
--

DROP TABLE IF EXISTS `bookingproject`.`users`;
DROP TABLE IF EXISTS `bookingproject`.`thumbs`;
DROP TABLE IF EXISTS `bookingproject`.`permissions`;
DROP TABLE IF EXISTS `bookingproject`.`reservations`;
DROP TABLE IF EXISTS `bookingproject`.`rooms`;
DROP TABLE IF EXISTS `bookingproject`.`hotelclasses`;
DROP TABLE IF EXISTS `bookingproject`.`hotels`;
DROP TABLE IF EXISTS `bookingproject`.`roles`;
DROP TABLE IF EXISTS `bookingproject`.`payments`;
DROP TABLE IF EXISTS `bookingproject`.`extras`;
DROP TABLE IF EXISTS `bookingproject`.`extra_reservation_relations`;
DROP TABLE IF EXISTS `bookingproject`.`comments`;
DROP TABLE IF EXISTS `bookingproject`.`clients`;

--
-- Table `hotels`
--

CREATE TABLE IF NOT EXISTS `hotels` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label`     VARCHAR(255)     NOT NULL,
  `address`   VARCHAR(255)     NOT NULL,
  `desc_text` TEXT             NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `hotelclasses`
--

CREATE TABLE IF NOT EXISTS `hotelclasses` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `classRating`   INT(11)          NOT NULL DEFAULT '1',
  `desc_text` TEXT             NOT NULL,
  `num_id`    INT(11)          NOT NULL,
  PRIMARY KEY (`id`),
  KEY `num_id` (`num_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(255)     NOT NULL,
  `surname`  VARCHAR(255)     NOT NULL,
  `email`    VARCHAR(255)     NOT NULL,
  `tele`     VARCHAR(100)     NOT NULL,
  `reg_num`  VARCHAR(100)     NOT NULL,
  `pers_num` VARCHAR(100)     NOT NULL,
  `corp`     VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `head`       VARCHAR(255)     NOT NULL,
  `desc_text`  TEXT             NOT NULL,
  `time_stamp` TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `client_id`  INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `comments_ibfk_1`
  FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `extras`
--

CREATE TABLE IF NOT EXISTS `extras` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label`     VARCHAR(255)     NOT NULL,
  `desc_text` TEXT             NOT NULL,
  `cost`      DOUBLE           NOT NULL DEFAULT '0',
  `pic`       VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `extra_reservation_relations`
--

CREATE TABLE IF NOT EXISTS `extra_reservation_relations` (
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `res_id`   INT(11)          NOT NULL,
  `extra_id` INT(11)          NOT NULL,
  PRIMARY KEY (`id`),
  KEY `res_id` (`res_id`, `extra_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `amount`     DOUBLE           NOT NULL DEFAULT '0',
  `desc_text`  TEXT             NOT NULL,
  `pay_type`   INT(11)          NOT NULL DEFAULT '1',
  `time_stamp` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `referent`   VARCHAR(255)     NOT NULL,
  `client_id`  INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `payments_ibfk_1`
  FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label`     VARCHAR(100)     NOT NULL,
  `desc_text` TEXT             NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `permissions`
--

CREATE TABLE IF NOT EXISTS `permissions` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label`     VARCHAR(100)     NOT NULL,
  `desc_text` TEXT             NOT NULL,
  `role_id`   INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `permissions_ibfk_1`
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `id`               INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `room_number`      INT(11)          NOT NULL,
  `person_count`     INT(11)          NOT NULL,
  `price_per_day`    DOUBLE           NOT NULL,
  `description_text` TEXT             NOT NULL,
  `hotel_class_id`       INT(11) UNSIGNED NOT NULL,
  `hotel_id`         INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_class_id` (`hotel_class_id`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `rooms_ibfk_1`
  FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `rooms_ibfk_2`
  FOREIGN KEY (`hotel_class_id`) REFERENCES `hotelclasses` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `from_date`  DATETIME         NOT NULL,
  `to_date`    DATETIME         NOT NULL,
  `p_count`    INT(11)          NOT NULL,
  `time_stamp` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status`     TINYINT(1)       NOT NULL DEFAULT '0',
  `room_id`    INT(11) UNSIGNED NOT NULL,
  `client_id`  INT(11) UNSIGNED NOT NULL,
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
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `thumbs`
--

CREATE TABLE IF NOT EXISTS `thumbs` (
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label`     VARCHAR(255)     NOT NULL,
  `desc_text` TEXT             NOT NULL,
  `orig`      VARCHAR(255)     NOT NULL,
  `room_id`   INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `thumbs_ibfk_1`
  FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id`          INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)     NOT NULL,
  `surname`     VARCHAR(255)     NOT NULL,
  `email`       VARCHAR(255)     NOT NULL,
  `phone`       VARCHAR(100)     NOT NULL,
  `username`    VARCHAR(255)     NOT NULL,
  `password`    VARCHAR(255)     NOT NULL,
  `last_modify` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_date` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id`     INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1`
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE utf8_unicode_ci;


/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
