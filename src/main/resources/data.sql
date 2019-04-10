insert into role (id, role_name) values (1, 'USER');
insert into role (id, role_name) values (2, 'ADMIN');

insert into user (id,  email, nickname, passwd) values (1, 'mimi@naver.com', '미미', '{bcrypt}$2a$10$iSjd8nYlZitpdiadODvsouFExJGWVuhnLLFOAHLkZ7QiuiO7gzop6');
insert into user (id,  email, nickname, passwd) values (2, 'test@naver.com', '테스트', '{bcrypt}$2a$10$qhp3futbDLSulrDi.X9wiO3alWNU5ZnEAtuGy7mN2DiyJXVfmrp72');

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 1);

insert into keyword (id, keyword_type, keyword_value, ordering) values (1, 1, '월', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (2, 1, '화', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (3, 1, '수', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (4, 1, '목', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (5, 1, '금', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (6, 1, '토', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (7, 1, '일', 0);

insert into keyword (id, keyword_type, keyword_value, ordering) values (8, 2, '드라마', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (9, 2, '순정', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (10, 2, '코믹', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (11, 2, '일상', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (12, 2, '판타지', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (13, 2, '액션', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (14, 2, '공포', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (15, 2, '스릴러', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (16, 2, '스포츠', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (17, 2, '시대물', 0);

insert into keyword (id, keyword_type, keyword_value, ordering) values (18, 4, '역사', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (19, 4, '싸움', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (20, 4, '좀비', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (21, 4, '타임리프', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (22, 4, '여자들', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (23, 4, '연애', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (24, 4, '개그', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (25, 4, '대학생', 1);
insert into keyword (id, keyword_type, keyword_value, ordering) values (26, 4, '학교', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (27, 4, '범죄', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (28, 4, '귀신', 0);

insert into keyword (id, keyword_type, keyword_value, ordering) values (29, 3, '교교박', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (30, 3, 'yami', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (31, 3, '여은', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (32, 3, '정이리이리', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (33, 3, '이림', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (34, 3, '김종욱', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (35, 3, '하람', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (36, 3, '김영', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (37, 3, '돌석', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (38, 3, '신영', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (39, 3, '손달섭', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (40, 3, '김철현', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (41, 3, 'ALIC', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (42, 3, '김탐미', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (43, 3, '2B', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (44, 3, '계란계란', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (45, 3, '조석', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (46, 3, '자까', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (47, 3, '이동건', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (48, 3, '오성대', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (49, 3, '이윤창', 0);
insert into keyword (id, keyword_type, keyword_value, ordering) values (50, 3, 'SIU', 0);

insert into platform (id, platform_name) values (1, '네이버');
insert into platform (id, platform_name) values (2, '다음');
insert into platform (id, platform_name) values (3, '레진코믹스');

insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (1, '굿바이 사돈', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/goodbyeinlaw', 155, '사돈 사이가 된 원수지간 남녀, 때마침 모든 걸 되돌릴 수 있는 기회가 눈앞에 찾아오는데!', 2, 0, '2019-03-03 23:59:59', '26화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (2, '일단 질러! 질렐루야', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/impulsebuyer', 100, '야미작가의 신작. 소소한 생활지름의 세계로 오라~', 2, 0, '2019-03-04 23:59:59', '126화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (3, '겟 레디 위드 미', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/getreadywithme', 3000, '뷰티 크리에이터를 제안하는 지욱과, 관심 1도 없는 그림의 메이크업 로맨스', 2, 0, '2019-03-05 23:59:59', '28화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (4, '왕 그리고 황제', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/getreadywithme', 100, '영혼이 바뀐 고종과 태종, 그들은 조선을 바꿀 수 있을까?', 2, 1, '2019-03-18 23:59:59', '96화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (5, '노인의 집', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/HeavensSoul', 200, '매우 규칙적이고 성실하게 삶을 허비하는 노인의 집에 한 아이가 들어왔다.', 2, 1, '2019-03-18 23:59:59', '46화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (6, '헤븐즈 소울', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/HeavensSoul', 1000, '괴생명체 크리쳐의 공격에 맞서는 소녀들의 이야기', 2, '2019-03-18 23:59:59', '94화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (7, '프레너미', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/Frenemy', 3000, '거만한 천재 소년과 심약한 은둔 고수와의 만남, 재능과 노력만으론 최고가 될 수 없다!', 2, '2019-03-18 23:59:59', '47화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (8, '이웃잔혹사', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/neighbordeath', 11, '복권 당첨금을 둘러싸고 이웃 간에 벌어지는 잔혹 드라마', 2, '2019-03-18 23:59:59', '14화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (9, '우리 남매의 일상은', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/brothersister', 155, '대한민국 어디에나 있을법한 남매들의 화려한 일상!', 2, 0, '2019-03-03 23:59:59', '8화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (10, '풍검', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/windsword', 100, '마계의 힘으로 인간계를 없애려는 자들과 막으려는 자들의 치열한 싸움', 2, 0, '2019-03-03 23:59:59', '73화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (11, '천연', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/heavencouple', 30, '돌이킬 수 없는 과거와 얽히는 현재. 그리고, 유동의 미래', 2, 0, '2019-03-03 23:59:59', '25화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (12, '껍데기', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/shell', 10000, '예뻐지고 싶은 태희와 성형외과 의사 도하, 그들은 껍데기만으로 행복해질 수 있을까?', 2, 0, '2019-03-03 23:59:59', '234화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (13, '퀴퀴한 일기', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/ficnonfic', 155, '사돈 사이가 된 원수지간 남녀, 때마침 모든 걸 되돌릴 수 있는 기회가 눈앞에 찾아오는데!', 2, 0, '2019-03-03 23:59:59', '40화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (14, '유사과학 탐구영역', '연재중', '전체관람가', 'http://webtoon.daum.net/webtoon/view/PseudoScience', 1, '즈질스럽고 퀴퀴한 언니의 쿰쿰한 일상다반사', 2, 0, '2019-03-03 23:59:59', '284화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (15, '마음의 소리', '연재중', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=20853&weekday=tue',123, '솔직 담백 최강의 개그 만화', 1, 1, '2019-03-18 17:51:20', '1161화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (16, '대학일기', '완결', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=679519&weekday=mon', 230, '로망이 꽃피는 캠퍼스는 없다. 극사실주의에 기반한 너무나 현실적인 우리의 대학일기', 1, 0, '2019-03-17 15:51:20', '290화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (17, '유미의 세포들', '연재중', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=651673', 123, '유미는 지금 무슨 생각을 하고 있을까? 그녀의 머릿속에서 바쁘게 움직이는 세포들 이야기!', 1, 0, '2019-03-15 02:30:30', '362화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (18, '기기괴괴', '연재중', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=557672', 18, '<절벽귀> 오성대 작가의 신작 옴니버스 미스테리 스릴러.기묘하고 괴상한 이야기들.', 1, 0, '2019-03-14 01:30:30', '254화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (19, '좀비딸', '연재중', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=715772&weekday=thu', 189, '나의 딸은 좀비다. 이 세상 마지막 남은 유일한 좀비...', 1, 0, '2019-03-16 01:20:30', '30화');
insert into webtoon (id, title, state, see_age, link, subscription, description, platform_id, update_state, updated_date, total_count)
values (20, '신의탑', '연재중', '전체관람가', 'https://comic.naver.com/webtoon/list.nhn?titleId=183559&weekday=mon',500, '자신의 모든 것이었던 소녀를 쫓아 탑에 들어온 소년 그리고 그런 소년을 시험하는 탑', 1, 1, '2019-03-18 00:33:30', '3부 2화');

insert into webtoon_keyword (webtoon_id, keyword_id) values (1, 1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2, 1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3, 2);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4, 2);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5, 3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6, 3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7, 4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8, 4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9, 5);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10, 5);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11, 6);
insert into webtoon_keyword (webtoon_id, keyword_id) values (12, 6);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13, 7);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14, 7);
insert into webtoon_keyword (webtoon_id, keyword_id) values (15, 1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16, 1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16, 3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (17, 3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (17, 6);
insert into webtoon_keyword (webtoon_id, keyword_id) values (18, 4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (19, 4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (20, 1);

insert into webtoon_keyword (webtoon_id, keyword_id) values (1,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (1,9);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,11);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3,9);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,12);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,13);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7,15);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7,16);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,18);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,17);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9,9);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10,14);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (12,15);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13,16);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14,11);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14,12);
insert into webtoon_keyword (webtoon_id, keyword_id) values (15,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (15,11);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16,11);
insert into webtoon_keyword (webtoon_id, keyword_id) values (17,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (18,14);
insert into webtoon_keyword (webtoon_id, keyword_id) values (19,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (19,14);
insert into webtoon_keyword (webtoon_id, keyword_id) values (20,12);
insert into webtoon_keyword (webtoon_id, keyword_id) values (20,13);

insert into webtoon_keyword (webtoon_id, keyword_id) values (1,18);
insert into webtoon_keyword (webtoon_id, keyword_id) values (1,19);
insert into webtoon_keyword (webtoon_id, keyword_id) values (1,20);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,21);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,22);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,23);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3,24);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3,25);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4,26);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4,27);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5,18);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5,19);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,20);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,21);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7,22);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,23);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,24);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9,25);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10,26);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10,27);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11,18);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11,19);
insert into webtoon_keyword (webtoon_id, keyword_id) values (12,20);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13,21);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14,22);
insert into webtoon_keyword (webtoon_id, keyword_id) values (15,23);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16,24);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16,25);
insert into webtoon_keyword (webtoon_id, keyword_id) values (17,26);
insert into webtoon_keyword (webtoon_id, keyword_id) values (18,28);
insert into webtoon_keyword (webtoon_id, keyword_id) values (19,20);
insert into webtoon_keyword (webtoon_id, keyword_id) values (20,19);

insert into webtoon_keyword (webtoon_id, keyword_id) values (1, 29);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2, 30);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3, 31);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4, 32);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5, 33);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5, 34);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6, 35);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6, 36);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7, 37);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8, 38);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9, 39);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10, 40);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11, 41);
insert into webtoon_keyword (webtoon_id, keyword_id) values (12, 42);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13, 43);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14, 44);
insert into webtoon_keyword (webtoon_id, keyword_id) values (15, 45);
insert into webtoon_keyword (webtoon_id, keyword_id) values (16, 46);
insert into webtoon_keyword (webtoon_id, keyword_id) values (17, 47);
insert into webtoon_keyword (webtoon_id, keyword_id) values (18, 48);
insert into webtoon_keyword (webtoon_id, keyword_id) values (19, 49);
insert into webtoon_keyword (webtoon_id, keyword_id) values (20, 50);

insert into new_webtoon(id, ordering, webtoon_id) values (1, 0, 1);
insert into new_webtoon(id, ordering, webtoon_id) values (2, 1, 2);
insert into new_webtoon(id, ordering, webtoon_id) values (3, 2, 3);


insert into my_webtoon(id, webtoon_id, alarm, user_id) values(1, 1, 0, 1);
insert into my_webtoon(id, webtoon_id, alarm, user_id) values(2, 7, 1, 1);
insert into my_webtoon(id, webtoon_id, alarm, user_id) values(3, 20, 1, 1);
insert into my_webtoon(id, webtoon_id, alarm, user_id) values(4, 11, 1, 2);

insert into my_webtoon(id, webtoon_id, alarm, user_id) values(5, 4, 0, 2);


