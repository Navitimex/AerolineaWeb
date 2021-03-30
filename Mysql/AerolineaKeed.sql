-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Keed_moviles
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Keed_moviles
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Keed_moviles` DEFAULT CHARACTER SET utf8 ;
USE `Keed_moviles` ;

-- -----------------------------------------------------
-- Table `Keed_moviles`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Cliente` (
  `id` INT NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `rol` TINYINT(2) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fec_naci` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `tel_trabajo` VARCHAR(45) NOT NULL,
  `tel_cel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Avion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Avion` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Avion` (
  `id` VARCHAR(20) NOT NULL,
  `anio` INT NOT NULL,
  `modelo` VARCHAR(20) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `can_asientos` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Destinos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Destinos` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Destinos` (
  `codigo` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Ruta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Ruta` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Ruta` (
  `codigo` VARCHAR(15) NOT NULL,
  `origen` VARCHAR(10) NOT NULL,
  `destino` VARCHAR(10) NOT NULL,
  `duracionMin` TIME NOT NULL,
  `precio` FLOAT NOT NULL,
  `descuento` FLOAT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Ruta_Ciudad1_idx` (`origen` ASC) VISIBLE,
  INDEX `fk_Ruta_Ciudad2_idx` (`destino` ASC) VISIBLE,
  CONSTRAINT `fk_Ruta_Ciudad1`
    FOREIGN KEY (`origen`)
    REFERENCES `Keed_moviles`.`Destinos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ruta_Ciudad2`
    FOREIGN KEY (`destino`)
    REFERENCES `Keed_moviles`.`Destinos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Horario` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Horario` (
  `id` INT NOT NULL,
  `dia_semana` VARCHAR(45) NOT NULL,
  `hora_salida` TIME NOT NULL,
  `hora_llegada` TIME NOT NULL,
  `Ruta_codigo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Horario_Ruta1_idx` (`Ruta_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Horario_Ruta1`
    FOREIGN KEY (`Ruta_codigo`)
    REFERENCES `Keed_moviles`.`Ruta` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Vuelo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Vuelo` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Vuelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Horario_id` INT NOT NULL,
  `Ruta_codigo` VARCHAR(15) NOT NULL,
  `Avion_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vuelo_Horario1_idx` (`Horario_id` ASC) VISIBLE,
  INDEX `fk_Vuelo_Ruta1_idx` (`Ruta_codigo` ASC) VISIBLE,
  INDEX `fk_Vuelo_Avion1_idx` (`Avion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Vuelo_Horario1`
    FOREIGN KEY (`Horario_id`)
    REFERENCES `Keed_moviles`.`Horario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vuelo_Ruta1`
    FOREIGN KEY (`Ruta_codigo`)
    REFERENCES `Keed_moviles`.`Ruta` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vuelo_Avion1`
    FOREIGN KEY (`Avion_id`)
    REFERENCES `Keed_moviles`.`Avion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Tiquete`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Tiquete` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Tiquete` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Vuelo_id` INT NOT NULL,
  `Cliente_id` INT NOT NULL,
  `numero_asiento` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Tiquete_Vuelo1_idx` (`Vuelo_id` ASC) VISIBLE,
  INDEX `fk_Tiquete_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Tiquete_Vuelo1`
    FOREIGN KEY (`Vuelo_id`)
    REFERENCES `Keed_moviles`.`Vuelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tiquete_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Keed_moviles`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Keed_moviles`.`Reservacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Keed_moviles`.`Reservacion` ;

CREATE TABLE IF NOT EXISTS `Keed_moviles`.`Reservacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ida` INT NOT NULL,
  `vuelta` INT NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reservacion_Tiquete1_idx` (`ida` ASC) VISIBLE,
  INDEX `fk_Reservacion_Tiquete2_idx` (`vuelta` ASC) VISIBLE,
  INDEX `fk_Reservacion_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Reservacion_Tiquete1`
    FOREIGN KEY (`ida`)
    REFERENCES `Keed_moviles`.`Tiquete` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservacion_Tiquete2`
    FOREIGN KEY (`vuelta`)
    REFERENCES `Keed_moviles`.`Tiquete` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservacion_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Keed_moviles`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Usuarios de Prueba
-- -----------------------------------------------------
INSERT INTO `keed_moviles`.`cliente` (`id`, `contrasena`, `rol`, `nombre`, `apellidos`, `correo`, `fec_naci`, `direccion`, `tel_trabajo`, `tel_cel`) VALUES ('402390969', '12345678', '1', 'kevin', 'artavia', 'kevinartavia29@hotmail.com', '1995-01-29', 'asda', '88857993', '22613697');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
