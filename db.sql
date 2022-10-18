-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema springcourse_template
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springcourse_template
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springcourse_template` DEFAULT CHARACTER SET utf8;
USE `springcourse_template`;

-- -----------------------------------------------------
-- Table `springcourse_template`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`user`
(
    `id`    INT                                  NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(45)                          NOT NULL,
    `role`  ENUM ('ROLE_STUDENT', 'ROLE_EDITOR') NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`student`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(45) NOT NULL,
    `lastname`  VARCHAR(45) NOT NULL,
    `age`       INT         NOT NULL,
    `phone`     VARCHAR(45) NULL,
    `user_id`   INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_student_user1_idx` (`user_id` ASC),
    CONSTRAINT `fk_student_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `springcourse_template`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`skill`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `type_UNIQUE` (`type` ASC)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`opportunity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`opportunity`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45)  NOT NULL,
    `deadline`   TIMESTAMP    NOT NULL,
    `asap`       TINYINT(1)   NOT NULL DEFAULT 0,
    `content`    VARCHAR(300) NOT NULL,
    `created_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`student_has_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`student_has_skill`
(
    `student_id` INT NOT NULL,
    `skill_id`   INT NOT NULL,
    PRIMARY KEY (`student_id`, `skill_id`),
    INDEX `fk_student_has_skill_skill1_idx` (`skill_id` ASC),
    INDEX `fk_student_has_skill_student_idx` (`student_id` ASC),
    CONSTRAINT `fk_student_has_skill_student`
        FOREIGN KEY (`student_id`)
            REFERENCES `springcourse_template`.`student` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_student_has_skill_skill1`
        FOREIGN KEY (`skill_id`)
            REFERENCES `springcourse_template`.`skill` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`student_has_opportunity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`student_has_opportunity`
(
    `student_id`     INT NOT NULL,
    `opportunity_id` INT NOT NULL,
    PRIMARY KEY (`opportunity_id`, `student_id`),
    INDEX `fk_student_has_opportunity_student1_idx` (`student_id` ASC),
    INDEX `fk_student_has_opportunity_opportunity1_idx` (`opportunity_id` ASC),
    CONSTRAINT `fk_student_has_opportunity_opportunity1`
        FOREIGN KEY (`opportunity_id`)
            REFERENCES `springcourse_template`.`opportunity` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_student_has_opportunity_student1`
        FOREIGN KEY (`student_id`)
            REFERENCES `springcourse_template`.`student` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springcourse_template`.`editor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springcourse_template`.`editor`
(
    `id`      INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_editor_user1_idx` (`user_id` ASC),
    CONSTRAINT `fk_editor_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `springcourse_template`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
