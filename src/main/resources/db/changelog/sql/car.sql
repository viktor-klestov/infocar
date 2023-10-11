--liquibase formatted sql
--changeset klestov_v:car
create table car
(
    id          bigserial primary key,
    make        text not null,
    model       text not null,
    numberplate text not null unique
);

insert into car(make, model, numberplate)
values ('Lada', '2101', '123ASD'),
       ('Kia', 'Sorento', '534TTT'),
       ('Skoda', 'Octavia', '999GLF'),
       ('Kia', 'Sorento', '555TFF'),
       ('Lada', '2101', '445KKK'),
       ('Audi', 'A6', '997HHH'),
       ('BMW', '760', '444RRR'),
       ('Audi', 'A6', '876OUI'),
       ('BMW', '740', '112YUI')
;