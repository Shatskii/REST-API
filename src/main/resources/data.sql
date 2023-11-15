

INSERT INTO tasks (description, date, status)
VALUES ('reading', '2020-01-01', false);
INSERT INTO tasks (description, date, status)
VALUES ('writing', '2020-01-02', true);
INSERT INTO tasks (description, date, status)
VALUES ('listening', '2020-01-03', false);
INSERT INTO tasks (description, date, status)
VALUES ('repeating', '2020-01-04', true);
INSERT INTO tasks (description, date, status)
VALUES ('repeating', '2020-01-05', false);
INSERT INTO tasks (description, date, status)
VALUES ('repeating', '2020-01-06', true);
INSERT INTO tasks (description, date, status)
VALUES ('reading', '2020-01-07', true);

SELECT *
FROM tasks;
--
--
create table users
(
    id       serial PRIMARY KEY,
    name     varchar not null,
    password varchar not null
);

create table roles
(
    id   serial primary key,
    name varchar not null
);

create table users_roles
(
    user_id int references users (id),
    role_id int references roles (id),
    primary key (user_id, role_id)
);

insert into users(name, password)
VALUES ('user', '$2y$10$JQD2PS7jSK/Zu0aGW94UY.HgCLHhQ879nrxNr.NqsRJ8fKve.Jjcu');-- пароль:12345
insert into roles (name)
values ('ROLE_USER');
insert into users_roles (user_id, role_id)
VALUES (1, 1);
--
--
insert into users(name, password)
VALUES ('admin', '$2y$10$Yhch3MDxVtq9lZ04C01FrOW2/xBgz3f/6Ki5kmgKlu80EZmShg7eG');-- пароль:09876
insert into roles (name)
values ('ROLE_ADMIN');
insert into users_roles (user_id, role_id)
VALUES (2, 2);
--
--
select *
from roles;
select *
from users_roles;
select *
from users;
