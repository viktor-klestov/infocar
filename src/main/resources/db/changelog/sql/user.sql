--liquibase formatted sql
--changeset klestov_v:user
create table "user"
(
    id   bigserial primary key,
    name text not null unique
);

insert into "user"(name)
values ('Teet Järveküla'),
       ('Pille Purk'),
       ('Mati Kaal'),
       ('Külli Kukk'),
       ('Teet Kruus');

--changeset klestov_v:cars_of_users
create table user_car
(
    user_id bigint,
    car_id  bigint,
    primary key (user_id, car_id)
);

insert into user_car
values (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9);