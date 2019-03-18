insert into role (id, role_name) values (1, 'USER');
insert into role (id, role_name) values (2, 'ADMIN');

insert into user (id,  email, nickname, passwd) values (1, 'mimi@naver.com', '미미', '1234');
insert into user (id,  email, nickname, passwd) values (2, 'test@naver.com', '테스트', '1111');

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 1);




