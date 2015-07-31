SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

USE `bookingproject`;

INSERT INTO `bookingproject`.`hotels`
SET
  `label`     = "images/apartments/thumbs/drak150x100.png",
  `address`   = "Bullu street 45",
  `desc_text` = "Good pay good day";

INSERT INTO `bookingproject`.`hotels`
SET
  `label`     = "images/apartments/thumbs/vanap150x100.png",
  `address`   = "Stabu street 6",
  `desc_text` = "For average person";

INSERT INTO `bookingproject`.`hotels`
SET
  `label`     = "images/apartments/thumbs/stud150x100.png",
  `address`   = "Putina street 10",
  `desc_text` = "For poor person, .. students ant other";


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;