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
INSERT INTO `bookingproject`.`roomclasses`
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
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 215,
  `person_count`    = 3,
  `price_per_day`   =  175.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 216,
  `person_count`    = 4,
  `price_per_day`   =  45.5,
  `description_text` = "Good pay sfdfsdfgood day",
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 217,
  `person_count`    = 2,
  `price_per_day`   =  152.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 218,
  `person_count`    = 4,
  `price_per_day`   =  15,
  `description_text` = "Good pay good day",
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");

INSERT INTO `bookingproject`.`rooms`
SET
  `room_number`     = 219,
  `person_count`    = 1,
  `price_per_day`   =  5.5,
  `description_text` = "Good pay good day",
  `roomClass_id`     = (SELECT id from roomclasses where class_name = "Brutal"),
  `hotel_id`         = (SELECT id FROM hotels WHERE address = "Bullu street 45");
-- Room data end

-- Clients data
INSERT INTO clients
    SET 
      name = "Janis",
      surname = "Berzins",
      email = "janis.berzins@gmail.com",
      tele = "23456789",
      reg_num = "12121212",
      pers_num = "250181-111111",
      corp = "EvilCorp";

INSERT INTO clients
SET
  name = "Janis",
  surname = "Krumins",
  email = "janis.krumins@gmail.com",
  tele = "23456729",
  reg_num = "12121212",
  pers_num = "250181-111113",
  corp = "EvilCorp";

INSERT INTO clients
SET
  name = "Edgars",
  surname = "Berzins",
  email = "edgars.berzins@gmail.com",
  tele = "23556789",
  reg_num = "12121212",
  pers_num = "150181-111111",
  corp = "EvilCorp";
-- clients data end

-- reservations data
INSERT INTO reservations
    SET 
      from_date = CURRENT_DATE,
      till_date = (DATE_ADD(CURRENT_DATE, INTERVAL 1 DAY)),
      person_count = 2,
      room_id = (SELECT id FROM rooms WHERE room_number = 214),
      client_id = (SELECT id FROM clients WHERE pers_num = "250181-111111");

INSERT INTO reservations
SET
  from_date = CURRENT_DATE,
  till_date = (DATE_ADD(CURRENT_DATE, INTERVAL 1 DAY)),
  person_count = 1,
  room_id = (SELECT id FROM rooms WHERE room_number = 215),
  client_id = (SELECT id FROM clients WHERE pers_num = "250181-111113");

INSERT INTO reservations
SET
  from_date = CURRENT_DATE,
  till_date = (DATE_ADD(CURRENT_DATE, INTERVAL 1 DAY)),
  person_count = 2,
  room_id = (SELECT id FROM rooms WHERE room_number = 216),
  client_id = (SELECT id FROM clients WHERE pers_num = "150181-111111");
-- reservations data end

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;