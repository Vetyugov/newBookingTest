create table persons
(
    id         bigserial primary key,
    username      varchar(255),
    isadmin      boolean,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into persons (username, isadmin)
values ('Oleg Yerichev', TRUE),
       ('Eugene Alexeev', TRUE),
       ('Elena', TRUE),
       ('KuBaNa', TRUE),
       ('Nikita Vetyugov', FALSE);