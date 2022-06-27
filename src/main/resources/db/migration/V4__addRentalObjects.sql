create table rental_objects
(
    id          bigserial primary key,
    title       varchar(255),
    address     varchar(255),
    numbers_of_rooms bigint not null,
    square_meters bigint not null,
    price_per_night numeric (8, 2) not null,
    is_free boolean,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into rental_objects(title, address, numbers_of_rooms, square_meters, price_per_night, is_free)
values ('Домик в деревне', 'д. Простоквашино, ул. Малиновая, дом 1', 2, 50, 2500.00, true),
       ('Дворец на Рублевке', 'г. Москва, Рублевское шоссе, дом 15', 20, 5000, 150000.00, true);