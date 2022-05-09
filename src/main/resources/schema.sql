create table issues (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
summary VARCHAR(256) NOT NULL,
description VARCHAR(256) NOT NULL,
createdday date NOT NULL default (CURRENT_DATE),
deadline date,
completionday date,
createuser VARCHAR(100),
status integer NOT NULL default 0
);