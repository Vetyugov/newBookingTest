
create table cities
(
    id         bigserial primary key,
    city       varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into cities (city)
values
('Moscow'),
('Saint-Petersburg'),
('Petergof'),
('Vyborg'),
('Krasnodar'),
('Kazan');











