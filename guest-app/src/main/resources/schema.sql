create table user (
	id        bigint AUTO_INCREMENT PRIMARY KEY,
	user_name varchar(128) not null unique,
	password  varchar(256) not null unique);
