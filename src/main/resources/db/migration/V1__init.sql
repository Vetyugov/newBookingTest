
create table cities
(
    id         bigserial primary key,
    city       varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
create table persons
(
    id         bigserial primary key,
    username      varchar(255),
    isadmin      boolean,

insert into cities (city)
values
('Moscow'),
('Saint-Petersburg'),
('Petergof'),
('Vyborg'),
('Krasnodar'),
('Kazan');
insert into persons (username, isadmin)
values ('Oleg Yerichev', TRUE),
       ('Eugene Alexeev', TRUE),
       ('Elena', TRUE),
       ('KuBaNa', TRUE),
       ('Nikita Vetyugov', FALSE);









