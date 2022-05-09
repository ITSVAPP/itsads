create table issues (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
summary VARCHAR(256) NOT NULL,
description VARCHAR(256) NOT NULL,
createdday DATE NOT NULL DEFAULT (CURRENT_DATE),
deadline DATE,
completionday DATE,
createuser VARCHAR(100),
status INTEGER NOT NULL DEFAULT 0
);