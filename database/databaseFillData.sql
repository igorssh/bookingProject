SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

USE `bookingproject`;

  INSERT INTO `bookingproject`.`hotels`
  SET
    `label`     = "images/apartments/thumbs/drak150x100.png",
    `address`   = "Bullu street 45",
    `rating`   =  5,
    `desc_text` = "Good pay good day";

  INSERT INTO `bookingproject`.`hotels`
  SET
    `label`     = "images/apartments/thumbs/vanap150x100.png",
    `address`   = "Stabu street 6",
    `rating`   =  4,
    `desc_text` = "For average person";

  INSERT INTO `bookingproject`.`hotels`
  SET
    `label`     = "images/apartments/thumbs/stud150x100.png",
    `address`   = "Putina street 10",
    `rating`   =  1,
    `desc_text` = "For poor person, .. students ant other";

-- Extras data start

INSERT INTO `bookingproject`.`extras`
SET
  `label`     = "Rent exotic car",
  `desc_text`   = "Since the passenger jet went missing nearly 17 months ago with 239 people aboard, there have been frequent false alarms amid the far-flung efforts to locate it. Objects initially flagged as possible plane debris turned out to be plain old flotsam and jetsam.

Following that pattern, a metal item found Sunday on Reunion -- described by authorities as an  drew a lot of attention until officials dismissed it as part of a household ladder.",
  `cost`   =  240.00,
  `pic` = "images/extras/MadMaxCars.jpg";

INSERT INTO `bookingproject`.`extras`
SET
  `label`     = "Gay wedding",
  `desc_text`   = "Since the passenger jet went missing nearly 17 months ago with 239 people aboard, there have been frequent false alarms amid the far-flung efforts to locate it. Objects initially flagged as possible plane debris turned out to be plain old flotsam and jetsam.

Following that pattern, a metal item found Sunday on Reunion -- described by authorities as an  drew a lot of attention until officials dismissed it as part of a household ladder.",
  `cost`   =  55.00,
  `pic` = "images/extras/wedding-cake.jpg";


INSERT INTO `bookingproject`.`extras`
SET
  `label`     = "Get vip pass",
  `desc_text`   = "Since the passenger jet went missing nearly 17 months ago with 239 people aboard, there have been frequent false alarms amid the far-flung efforts to locate it. Objects initially flagged as possible plane debris turned out to be plain old flotsam and jetsam.

Following that pattern, a metal item found Sunday on Reunion -- described by authorities as an  drew a lot of attention until officials dismissed it as part of a household ladder.",
  `cost`   =  1000.00,
  `pic` = "images/extras/VIP_OWTFF-300x300.jpg";

  INSERT INTO `bookingproject`.`extras`
SET
  `label`     = "Bad spirit exterminator",
  `desc_text`   = "Since the passenger jet went missing nearly 17 months ago with 239 people aboard, there have been frequent false alarms amid the far-flung efforts to locate it. Objects initially flagged as possible plane debris turned out to be plain old flotsam and jetsam.

Following that pattern, a metal item found Sunday on Reunion -- described by authorities as an  drew a lot of attention until officials dismissed it as part of a household ladder.",
  `cost`   =  482.00,
  `pic` = "images/extras/bad_spirit_by_polawat.jpg";


INSERT INTO `bookingproject`.`extras`
SET
  `label`     = "Chack Noris as your guard",
  `desc_text`   = "Since the passenger jet went missing nearly 17 months ago with 239 people aboard, there have been frequent false alarms amid the far-flung efforts to locate it. Objects initially flagged as possible plane debris turned out to be plain old flotsam and jetsam.

Following that pattern, a metal item found Sunday on Reunion -- described by authorities as an  drew a lot of attention until officials dismissed it as part of a household ladder.",
  `cost`   =  9666.00,
  `pic` = "images/extras/security-guard-picture.png";


-- Extras data end

-- Room data start
INSERT INTO `bookingproject`.`oomclasses`
SET
  `class_id`     =   1,
  `class_name`    = "Brutal",
  `desc_text`   =  "Good pay good day";




INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 214,
  `person_count`    = 4,
  `price_per_day`   =  15.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 215,
  `person_count`    = 3,
  `price_per_day`   =  175.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 216,
  `person_count`    = 4,
  `price_per_day`   =  45.5,
  `description_text` = "Good pay sfdfsdfgood day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 217,
  `person_count`    = 2,
  `price_per_day`   =  152.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 218,
  `person_count`    = 4,
  `price_per_day`   =  15,
  `description_text` = "Good pay good day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 219,
  `person_count`    = 1,
  `price_per_day`   =  5.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = 1173,
  `hotel_id`         = 1174;
-- Room data end

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;