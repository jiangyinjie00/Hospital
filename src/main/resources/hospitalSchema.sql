SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `Hospital` ;
CREATE SCHEMA IF NOT EXISTS `Hospital` DEFAULT CHARACTER SET utf8 ;
USE `Hospital` ;

-- -----------------------------------------------------
-- Table `Hospital`.`Cashier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`Cashier` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`Cashier` (
  `CashierID` INT(11) NOT NULL ,
  `Number` VARCHAR(45) NULL DEFAULT NULL ,
  `Password` VARCHAR(45) NULL DEFAULT NULL ,
  `Name` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`CashierID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`Patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`Patient` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`Patient` (
  `PatientID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Number` VARCHAR(45) NULL DEFAULT NULL ,
  `Sex` VARCHAR(45) NULL DEFAULT NULL ,
  `AdvancePay` FLOAT NULL DEFAULT NULL ,
  `Used` FLOAT NULL DEFAULT NULL ,
  `SelfPay` FLOAT NULL DEFAULT NULL ,
  `CreateTime` DATETIME NULL DEFAULT NULL ,
  `Name` VARCHAR(45) NULL ,
  PRIMARY KEY (`PatientID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`HospitalInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`HospitalInfo` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`HospitalInfo` (
  `HospitalInfoID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Number` VARCHAR(45) NULL DEFAULT NULL ,
  `Department` VARCHAR(45) NULL DEFAULT NULL ,
  `Room` VARCHAR(45) NULL DEFAULT NULL ,
  `BedNumber` VARCHAR(45) NULL DEFAULT NULL ,
  `Doctor` VARCHAR(45) NULL DEFAULT NULL ,
  `CreateTime` VARCHAR(45) NULL DEFAULT NULL ,
  `MarkForDelete` TINYINT(4) NULL DEFAULT '0' ,
  `PatientID` INT(11) NOT NULL ,
  PRIMARY KEY (`HospitalInfoID`) ,
  INDEX `fk_HospitalInfo_Patient_idx` (`PatientID` ASC) ,
  CONSTRAINT `fk_HospitalInfo_Patient`
    FOREIGN KEY (`PatientID` )
    REFERENCES `Hospital`.`Patient` (`PatientID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`Prescription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`Prescription` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`Prescription` (
  `PrescriptionID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Number` VARCHAR(45) NOT NULL ,
  `Name` VARCHAR(45) NOT NULL ,
  `Price` FLOAT NOT NULL ,
  `PayCoefficient` FLOAT NOT NULL ,
  `Unit` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`PrescriptionID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`PatientPrescription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`PatientPrescription` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`PatientPrescription` (
  `PatientPrescriptionID` INT(11) NOT NULL ,
  `Doctor` VARCHAR(45) NULL DEFAULT NULL ,
  `Department` VARCHAR(45) NULL DEFAULT NULL ,
  `Times` INT(11) NULL DEFAULT NULL ,
  `CreateTime` DATETIME NULL DEFAULT NULL ,
  `MarkForDelete` TINYINT(4) NULL DEFAULT '0' ,
  `NotTimes` INT(4) NULL DEFAULT NULL ,
  `PrescriptionID` INT(11) NOT NULL ,
  `PatientID` INT(11) NOT NULL ,
  PRIMARY KEY (`PatientPrescriptionID`) ,
  INDEX `fk_PatientPrescription_Prescription1_idx` (`PrescriptionID` ASC) ,
  INDEX `fk_PatientPrescription_Patient1_idx` (`PatientID` ASC) ,
  CONSTRAINT `fk_PatientPrescription_Patient1`
    FOREIGN KEY (`PatientID` )
    REFERENCES `Hospital`.`Patient` (`PatientID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PatientPrescription_Prescription1`
    FOREIGN KEY (`PrescriptionID` )
    REFERENCES `Hospital`.`Prescription` (`PrescriptionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`Project` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`Project` (
  `ProjectID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Number` VARCHAR(45) NOT NULL ,
  `Name` VARCHAR(45) NOT NULL ,
  `Price` FLOAT NOT NULL ,
  `PayCoefficient` FLOAT NOT NULL ,
  PRIMARY KEY (`ProjectID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`PatientProject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`PatientProject` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`PatientProject` (
  `PatientProjectID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Doctor` VARCHAR(45) NULL DEFAULT NULL ,
  `Department` VARCHAR(45) NULL DEFAULT NULL ,
  `Times` INT(4) NULL DEFAULT NULL ,
  `CreateTime` DATETIME NULL DEFAULT NULL ,
  `MarkForDelete` TINYINT(4) NULL DEFAULT '0' ,
  `NotTimes` INT(4) NULL DEFAULT NULL ,
  `ProjectID` INT(11) NOT NULL ,
  `PatientID` INT(11) NOT NULL ,
  PRIMARY KEY (`PatientProjectID`) ,
  INDEX `fk_PatientProject_Project1_idx` (`ProjectID` ASC) ,
  INDEX `fk_PatientProject_Patient1_idx` (`PatientID` ASC) ,
  CONSTRAINT `fk_PatientProject_Patient1`
    FOREIGN KEY (`PatientID` )
    REFERENCES `Hospital`.`Patient` (`PatientID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PatientProject_Project1`
    FOREIGN KEY (`ProjectID` )
    REFERENCES `Hospital`.`Project` (`ProjectID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Hospital`.`Receipt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospital`.`Receipt` ;

CREATE  TABLE IF NOT EXISTS `Hospital`.`Receipt` (
  `ReceiptID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Number` VARCHAR(45) NULL DEFAULT NULL ,
  `Money` FLOAT NULL DEFAULT NULL ,
  `CreateTime` DATETIME NULL DEFAULT NULL ,
  `CashierID` INT(11) NOT NULL ,
  `PatientID` INT(11) NOT NULL ,
  PRIMARY KEY (`ReceiptID`) ,
  INDEX `fk_Receipt_Cashier1_idx` (`CashierID` ASC) ,
  INDEX `fk_Receipt_Patient1_idx` (`PatientID` ASC) ,
  CONSTRAINT `fk_Receipt_Cashier1`
    FOREIGN KEY (`CashierID` )
    REFERENCES `Hospital`.`Cashier` (`CashierID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Receipt_Patient1`
    FOREIGN KEY (`PatientID` )
    REFERENCES `Hospital`.`Patient` (`PatientID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
