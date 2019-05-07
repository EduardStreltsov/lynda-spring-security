create table user (
	id       bigint AUTO_INCREMENT PRIMARY KEY,
	username varchar(128) not null unique,
	password varchar(256) not null unique);
