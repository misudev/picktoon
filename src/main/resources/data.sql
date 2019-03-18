insert into role (id, role_name) values (1, 'USER');
insert into role (id, role_name) values (2, 'ADMIN');

insert into user (id,  email, nickname, passwd) values (1, 'mimi@naver.com', '미미', '1234');
insert into user (id,  email, nickname, passwd) values (2, 'test@naver.com', '테스트', '1111');

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 1);

insert into genre (id, genre_name, ordering) values (1, "드라마", 1);
insert into genre (id, genre_name, ordering) values (2, "순정", 2);
insert into genre (id, genre_name, ordering) values (3, "코믹", 3);
insert into genre (id, genre_name, ordering) values (4, "일상", 4);
insert into genre (id, genre_name, ordering) values (5, "판타지", 5);
insert into genre (id, genre_name, ordering) values (6, "액션", 6);
insert into genre (id, genre_name, ordering) values (7, "공포", 7);
insert into genre (id, genre_name, ordering) values (8, "스릴러", 8);
insert into genre (id, genre_name, ordering) values (9, "스포츠", 9);
insert into genre (id, genre_name, ordering) values (10, "시대물", 10);

insert into day (id, day_name) values (1, "월요일");
insert into day (id, day_name) values (2, "화요일");
insert into day (id, day_name) values (3, "수요일");
insert into day (id, day_name) values (4, "목요일");
insert into day (id, day_name) values (5, "금요일");
insert into day (id, day_name) values (6, "토요일");
insert into day (id, day_name) values (7, "일요일");

insert into keyword (id, keyword_name, ordering) values (1, "역사" , 1);
insert into keyword (id, keyword_name, ordering) values (2, "싸움" , 2);
insert into keyword (id, keyword_name, ordering) values (3, "좀비" , 3);
insert into keyword (id, keyword_name, ordering) values (4, "타임리프" , 4);
insert into keyword (id, keyword_name, ordering) values (5, "여자들" , 5);
insert into keyword (id, keyword_name, ordering) values (6, "연애" , 6);
insert into keyword (id, keyword_name, ordering) values (7, "개그" , 7);
insert into keyword (id, keyword_name, ordering) values (8, "대학생" , 8);
insert into keyword (id, keyword_name, ordering) values (9, "학교" , 9);
insert into keyword (id, keyword_name, ordering) values (10, "범죄" , 10);

insert into platform (id, plateform_name) values (1, "네이버");
insert into platform (id, plateform_name) values (2, "다음");
insert into platform (id, plateform_name) values (3, "레진코믹스");

insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (1, "굿바이 사돈", "교교박", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/goodbyeinlaw", 155, "사돈 사이가 된 원수지간 남녀, 때마침 모든 걸 되돌릴 수 있는 기회가 눈앞에 찾아오는데!", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (2, "일단 질러! 질렐루야", "yami", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/impulsebuyer", 100, "야미작가의 신작. 소소한 생활지름의 세계로 오라~", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (3, "겟 레디 위드 미", "여은", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/getreadywithme", 3000, "뷰티 크리에이터를 제안하는 지욱과, 관심 1도 없는 그림의 메이크업 로맨스", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (4, "왕 그리고 황제", "정이리이리", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/getreadywithme", 100, "영혼이 바뀐 고종과 태종, 그들은 조선을 바꿀 수 있을까?", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (5, "노인의 집", "이림, 김종욱", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/HeavensSoul", 200, "매우 규칙적이고 성실하게 삶을 허비하는 노인의 집에 한 아이가 들어왔다.", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (6, "헤븐즈 소울", "하람, 김영", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/HeavensSoul", 1000, "괴생명체 크리쳐의 공격에 맞서는 소녀들의 이야기", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (7, "프레너미", "돌석", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/Frenemy", 3000, "거만한 천재 소년과 심약한 은둔 고수와의 만남, 재능과 노력만으론 최고가 될 수 없다!", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (8, "이웃잔혹사", "신영", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/neighbordeath", 11, "복권 당첨금을 둘러싸고 이웃 간에 벌어지는 잔혹 드라마", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (9, "우리 남매의 일상은", "손달섭", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/brothersister", 155, "대한민국 어디에나 있을법한 남매들의 화려한 일상!", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (10, "풍검", "김철현", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/windsword", 100, "마계의 힘으로 인간계를 없애려는 자들과 막으려는 자들의 치열한 싸움", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (11, "천연", "ALIC", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/heavencouple", 30, "돌이킬 수 없는 과거와 얽히는 현재. 그리고, 유동의 미래", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (12, "껍데기", "김탐미", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/shell", 10000, "예뻐지고 싶은 태희와 성형외과 의사 도하, 그들은 껍데기만으로 행복해질 수 있을까?", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (13, "퀴퀴한 일기", "2B", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/ficnonfic", 155, "사돈 사이가 된 원수지간 남녀, 때마침 모든 걸 되돌릴 수 있는 기회가 눈앞에 찾아오는데!", 2);
insert into webtoon (id, title, author, state, see_age, link, subscription, description, platform_id)
values (14, "유사과학 탐구영역", "계란계란", "연재중", "전체관람가", "http://webtoon.daum.net/webtoon/view/PseudoScience", 1, "즈질스럽고 퀴퀴한 언니의 쿰쿰한 일상다반사", 2);


insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (1, 0, "2019-03-03 23:59:59", "26화", 1);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (2, 0, "2019-03-04 23:59:59", "126화", 2);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (3, 0, "2019-03-05 23:59:59", "28화", 3);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (4, 1, "2019-03-18 23:59:59", "96화", 4);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (5, 1, "2019-03-18 23:59:59", "46화", 5);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (6, 1, "2019-03-18 23:59:59", "94화", 6);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (7, 1, "2019-03-18 23:59:59", "47화", 7);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (8, 1, "2019-03-18 23:59:59", "14화", 8);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (9, 0, "2019-03-03 23:59:59", "8화", 9);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (10, 0, "2019-03-03 23:59:59", "73화", 10);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (11, 0, "2019-03-03 23:59:59", "25화", 11);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (12, 0, "2019-03-03 23:59:59", "234화", 12);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (13, 0, "2019-03-03 23:59:59", "40화", 13);
insert into webtoon_state (id, update_state, updated_date, total_count, webtoon_id) values (14, 0, "2019-03-03 23:59:59", "284화", 14);

insert into webtoon_genre (webtoon_id, genre_id) values (1,1);
insert into webtoon_genre (webtoon_id, genre_id) values (1,2);
insert into webtoon_genre (webtoon_id, genre_id) values (2,3);
insert into webtoon_genre (webtoon_id, genre_id) values (2,4);
insert into webtoon_genre (webtoon_id, genre_id) values (3,2);
insert into webtoon_genre (webtoon_id, genre_id) values (4,1);
insert into webtoon_genre (webtoon_id, genre_id) values (5,1);
insert into webtoon_genre (webtoon_id, genre_id) values (6,5);
insert into webtoon_genre (webtoon_id, genre_id) values (6,6);
insert into webtoon_genre (webtoon_id, genre_id) values (7,8);
insert into webtoon_genre (webtoon_id, genre_id) values (7,9);
insert into webtoon_genre (webtoon_id, genre_id) values (8,10);
insert into webtoon_genre (webtoon_id, genre_id) values (8,9);
insert into webtoon_genre (webtoon_id, genre_id) values (9,1);
insert into webtoon_genre (webtoon_id, genre_id) values (9,2);
insert into webtoon_genre (webtoon_id, genre_id) values (9,3);
insert into webtoon_genre (webtoon_id, genre_id) values (10,7);
insert into webtoon_genre (webtoon_id, genre_id) values (11,1);
insert into webtoon_genre (webtoon_id, genre_id) values (12,8);
insert into webtoon_genre (webtoon_id, genre_id) values (13,9);
insert into webtoon_genre (webtoon_id, genre_id) values (13,1);
insert into webtoon_genre (webtoon_id, genre_id) values (14,4);
insert into webtoon_genre (webtoon_id, genre_id) values (14,5);

insert into webtoon_keyword (webtoon_id, keyword_id) values (1,1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (1,2);
insert into webtoon_keyword (webtoon_id, keyword_id) values (1,3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,5);
insert into webtoon_keyword (webtoon_id, keyword_id) values (2,6);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3,7);
insert into webtoon_keyword (webtoon_id, keyword_id) values (3,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4,9);
insert into webtoon_keyword (webtoon_id, keyword_id) values (4,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5,1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (5,2);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (6,4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (7,5);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,6);
insert into webtoon_keyword (webtoon_id, keyword_id) values (8,7);
insert into webtoon_keyword (webtoon_id, keyword_id) values (9,8);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10,9);
insert into webtoon_keyword (webtoon_id, keyword_id) values (10,10);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11,1);
insert into webtoon_keyword (webtoon_id, keyword_id) values (11,2);
insert into webtoon_keyword (webtoon_id, keyword_id) values (12,3);
insert into webtoon_keyword (webtoon_id, keyword_id) values (13,4);
insert into webtoon_keyword (webtoon_id, keyword_id) values (14,5);

insert into webtoon_day (webtoon_id, day_id) values (1,1);
insert into webtoon_day (webtoon_id, day_id) values (2,1);
insert into webtoon_day (webtoon_id, day_id) values (3,2);
insert into webtoon_day (webtoon_id, day_id) values (4,2);
insert into webtoon_day (webtoon_id, day_id) values (5,3);
insert into webtoon_day (webtoon_id, day_id) values (6,3);
insert into webtoon_day (webtoon_id, day_id) values (7,4);
insert into webtoon_day (webtoon_id, day_id) values (8,4);
insert into webtoon_day (webtoon_id, day_id) values (9,5);
insert into webtoon_day (webtoon_id, day_id) values (10,5);
insert into webtoon_day (webtoon_id, day_id) values (11,6);
insert into webtoon_day (webtoon_id, day_id) values (12,6);
insert into webtoon_day (webtoon_id, day_id) values (13,7);
insert into webtoon_day (webtoon_id, day_id) values (14,7);