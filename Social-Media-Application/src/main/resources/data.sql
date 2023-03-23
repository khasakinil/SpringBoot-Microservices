insert into user_details(user_id, date_of_birth, name)
values(100001, current_date(), 'Sanjay');

insert into user_details(user_id, date_of_birth, name)
values(100002, current_date(), 'Ajay');

insert into user_details(user_id, date_of_birth, name)
values(100003, current_date(), 'Kartik');

insert into user_details(user_id, date_of_birth, name)
values(100004, current_date(), 'Aman');

insert into user_posts(id, description, user_user_id)
values(20001, 'Learning GCP', 100001);

insert into user_posts(id, description, user_user_id)
values(20002, 'Learning AWS', 100002);

insert into user_posts(id, description, user_user_id)
values(20003, 'Learning Machine Learning', 100003);

insert into user_posts(id, description, user_user_id)
values(20004, 'Learning Java', 100004);

insert into user_posts(id, description, user_user_id)
values(20005, 'Learning Python', 100004);
