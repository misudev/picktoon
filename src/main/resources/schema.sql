DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS new_webtoon;
DROP TABLE IF EXISTS my_webtoon;
DROP TABLE IF EXISTS webtoon_day;
DROP TABLE IF EXISTS webtoon_genre;
DROP TABLE IF EXISTS webtoon_image;
DROP TABLE IF EXISTS webtoon_keyword;
DROP TABLE IF EXISTS webtoon_state;
DROP TABLE IF EXISTS keyword;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS day;
DROP TABLE IF EXISTS webtoon;
DROP TABLE IF EXISTS platform;
DROP TABLE IF EXISTS user;
-- -----------------------------------------------------
-- Table `webtoondb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  id BIGINT(20) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  passwd VARCHAR(255) NOT NULL,
  nickname VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
 );


-- -----------------------------------------------------
-- Table `webtoondb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS role (
  id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(45) NOT NULL UNIQUE ,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `webtoondb`.`platform`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS platform (
  id INT NOT NULL AUTO_INCREMENT,
  platform_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `webtoondb`.`webtoon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS webtoon (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  state VARCHAR(45) NOT NULL,
  see_age VARCHAR(45) NOT NULL DEFAULT '전체관람가',
  link VARCHAR(255) NOT NULL,
  subscription INT NOT NULL DEFAULT 0,
  description LONGTEXT NULL,
  platform_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_webtoon_platform
  FOREIGN KEY (platform_id)
  REFERENCES platform (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `webtoondb`.`webtoon_state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS webtoon_state (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  update_state TINYINT(1) NULL,
  updated_date DATETIME NULL,
  total_count VARCHAR(255) NULL,
  webtoon_id BIGINT(20) NOT NULL,
  CONSTRAINT fk_webtoon_state_webtoon
  FOREIGN KEY (webtoon_id)
  REFERENCES webtoon(id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table `webtoondb`.`webtoon_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS webtoon_image (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  mime_type VARCHAR(45) NULL,
  length BIGINT(20) NULL,
  name VARCHAR(45) NULL,
  save_file_name VARCHAR(255) NULL,
  webtoon_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_webtoon_image_webtoon
  FOREIGN KEY (webtoon_id)
  REFERENCES webtoon(id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `webtoondb`.`new_webtoon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS new_webtoon (
  id INT NOT NULL AUTO_INCREMENT,
  ordering INT NULL,
  webtoon_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_new_webtoon_webtoon
  FOREIGN KEY (webtoon_id)
  REFERENCES webtoon(id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `webtoondb`.`keyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS keyword (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  keyword_value VARCHAR(45) NOT NULL,
  keyword_type INT NOT NULL,
  ordering INT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `webtoondb`.`my_webtoon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS my_webtoon(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  webtoon_id BIGINT(20) NOT NULL,
  alarm TINYINT NULL,
  user_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_my_webtoon_webtoon
  FOREIGN KEY (webtoon_id)
  REFERENCES webtoon (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT fk_my_webtoon_user
  FOREIGN KEY (user_id)
  REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE);



-- -----------------------------------------------------
-- Table `webtoondb`.`webtoon_keyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS webtoon_keyword (
  webtoon_id BIGINT(20) NOT NULL,
  keyword_id BIGINT(20) NOT NULL,
  PRIMARY KEY(webtoon_id, keyword_id),
  CONSTRAINT fk_webtoon_keyword_webtoon
  FOREIGN KEY (webtoon_id)
  REFERENCES webtoon (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT fk_webtoon_keyword_keyword
  FOREIGN KEY (keyword_id)
  REFERENCES keyword (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `webtoondb`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user_role (
  user_id BIGINT(20) NOT NULL,
  role_id INT NOT NULL,
  CONSTRAINT fk_user_role_user
  FOREIGN KEY (user_id)
  REFERENCES user (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT fk_user_role_role
  FOREIGN KEY (role_id)
  REFERENCES role (id)
  ON DELETE CASCADE
  ON UPDATE CASCADE);


