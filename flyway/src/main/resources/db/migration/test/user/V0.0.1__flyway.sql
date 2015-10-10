CREATE TABLE user (
  LOGICAL_SHARD_ID INT(11) NOT NULL,
  USER_ID BIGINT(20) NOT NULL,
  EMAIL VARCHAR(100) COLLATE utf8_general_ci NOT NULL,
  FIRST_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(50) NOT NULL,
  MOBILE VARCHAR(20) DEFAULT NULL,
  COUNTRY VARCHAR(2) DEFAULT NULL,
  BIRTHDAY DATE DEFAULT NULL,
  CREATE_DATE DATETIME DEFAULT NULL,
  MODIFIED_DATE DATETIME DEFAULT NULL,
  MODIFIED_BY VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (USER_ID),
  INDEX EMAIL (EMAIL)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE user_password (
  LOGICAL_SHARD_ID INT(11) NOT NULL,
  USER_ID BIGINT(20) NOT NULL,
  PASSWORD VARCHAR(256) NOT NULL,
  SALT VARCHAR(50) NOT NULL,
  VERSION TINYINT(3) NOT NULL,
  CREATE_DATE DATETIME DEFAULT NULL,
  MODIFIED_DATE DATETIME DEFAULT NULL,
  MODIFIED_BY VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;