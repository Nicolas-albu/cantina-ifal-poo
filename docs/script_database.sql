-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_cantina
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_cantina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_cantina` ;
USE `db_cantina` ;

-- -----------------------------------------------------
-- Table `db_cantina`.`TBL_FUNCIONARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cantina`.`TBL_FUNCIONARIO` (
  `cod_func` INT NOT NULL AUTO_INCREMENT,
  `txt_email` VARCHAR(200) NOT NULL,
  `pwd_func` VARCHAR(12) NOT NULL,
  `nom_func` VARCHAR(100) NULL,
  PRIMARY KEY (`cod_func`),
  UNIQUE INDEX `txt_email_UNIQUE` (`txt_email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cantina`.`TBL_PRODUTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cantina`.`TBL_PRODUTO` (
  `cod_prod` INT NOT NULL AUTO_INCREMENT,
  `nom_prod` VARCHAR(200) NOT NULL,
  `des_prod` VARCHAR(300) NULL,
  `val_preco_uni` DECIMAL(7,2) NOT NULL,
  `qtd_prod` INT NOT NULL,
  PRIMARY KEY (`cod_prod`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cantina`.`TBL_VENDA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cantina`.`TBL_VENDA` (
  `cod_venda` INT NOT NULL AUTO_INCREMENT,
  `dat_venda` DATETIME NOT NULL,
  `val_preco_total` VARCHAR(45) NOT NULL,
  `opt_forma_pagamento` ENUM("debito", "credito", "vista") NOT NULL,
  PRIMARY KEY (`cod_venda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cantina`.`TBL_CADASTRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cantina`.`TBL_CADASTRO` (
  `cod_func` INT NOT NULL,
  `cod_prod` INT NOT NULL,
  PRIMARY KEY (`cod_func`, `cod_prod`),
  INDEX `fk_produto_funcionario_cod_prod` (`cod_prod` ASC) VISIBLE,
  INDEX `fk_funcionario_produto_cod_func` (`cod_func` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_produto_cod_func`
    FOREIGN KEY (`cod_func`)
    REFERENCES `db_cantina`.`TBL_FUNCIONARIO` (`cod_func`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_funcionario_cod_prod`
    FOREIGN KEY (`cod_prod`)
    REFERENCES `db_cantina`.`TBL_PRODUTO` (`cod_prod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_cantina`.`TBL_ITENS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_cantina`.`TBL_ITENS` (
  `cod_prod` INT NOT NULL,
  `cod_venda` INT NOT NULL,
  `prc_desconto` DECIMAL(3,3) NULL,
  `qtd_itens` INT NOT NULL,
  `val_preco_compra` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`cod_prod`, `cod_venda`),
  INDEX `fk_venda_produto_cod_venda` (`cod_venda` ASC) VISIBLE,
  INDEX `fk_produto_venda_cod_prod` (`cod_prod` ASC) VISIBLE,
  CONSTRAINT `fk_produto_venda_cod_prod`
    FOREIGN KEY (`cod_prod`)
    REFERENCES `db_cantina`.`TBL_PRODUTO` (`cod_prod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_produto_cod_venda`
    FOREIGN KEY (`cod_venda`)
    REFERENCES `db_cantina`.`TBL_VENDA` (`cod_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
