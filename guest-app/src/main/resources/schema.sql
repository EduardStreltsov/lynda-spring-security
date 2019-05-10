create table user (
	id        bigint AUTO_INCREMENT PRIMARY KEY,
	user_name varchar(128) not null unique,
	password  varchar(256) not null unique);

create table auth_user_group (
	id         bigint AUTO_INCREMENT PRIMARY KEY,
	user_name  varchar(128) not null,
	auth_group varchar(128) not null,
	constraint user_auth_user_group_fk foreign key (user_name) references user (user_name),
	unique (user_name, auth_group));