insert into user (user_name, password) values ('user1', '$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi');
insert into user (user_name, password) values ('user2', '$2a$11$3NO32OV1TGjap3xMpAEjmuiizitWuaSwUYz42aMtlxRliwJ8zm4Sm');
-- insert into auth_user_group (id, user_name, auth_group) values ('1', 'user1', 'user');
-- insert into auth_user_group (id, user_name, auth_group) values ('2', 'user1', 'admin');
-- insert into auth_user_group (id, user_name, auth_group) values ('3', 'user2', 'user');
insert into auth_user_group ( user_name, auth_group) values ('user1', 'user');
insert into auth_user_group ( user_name, auth_group) values ('user1', 'admin');
insert into auth_user_group ( user_name, auth_group) values ('user2', 'user');