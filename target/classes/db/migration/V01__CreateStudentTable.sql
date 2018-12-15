-- -----------------------------------------------------
-- Table student
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS student (
  student_id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  last_name VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  identity_document VARCHAR(8) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  active BIT(1) NOT NULL,
  student_type CHAR(3),
  created_at_utc DATETIME NOT NULL,
  updated_at_utc DATETIME NOT NULL,
  PRIMARY KEY (student_id),
  UNIQUE INDEX UQ_customer_identity_document (identity_document ASC) VISIBLE,
  INDEX IX_customer_last_first_name (last_name ASC, first_name ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 230001
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table undergrade_student
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS undergrade_student (
  student_id BIGINT(20) UNSIGNED NOT NULL,
  major VARCHAR(45) NULL,
  PRIMARY KEY (student_id),
  INDEX fk_undergrade_student_student_idx (student_id ASC) VISIBLE,
  CONSTRAINT fk_undergrade_student_student
    FOREIGN KEY (student_id)
    REFERENCES student (student_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table doctorate_student
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS doctorate_student (
  student_id BIGINT(20) UNSIGNED NOT NULL,
  major VARCHAR(45) NULL,
  postgrade_major VARCHAR(45) NULL,
  undergrade_maypr VARCHAR(45) NULL,
  PRIMARY KEY (student_id),
  CONSTRAINT fk_doctorate_student_student1
    FOREIGN KEY (student_id)
    REFERENCES student (student_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table postgrade_student
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS postgrade_student (
  student_id BIGINT(20) UNSIGNED NOT NULL,
  major VARCHAR(45) NULL,
  undergrade_major VARCHAR(45) NULL,
  PRIMARY KEY (student_id),
  CONSTRAINT fk_postgrade_student_student1
    FOREIGN KEY (student_id)
    REFERENCES student (student_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

