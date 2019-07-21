create table parking_order (
    id int PRIMARY KEY auto_increment,
    park_name varchar not null,
    car_number varchar not null,
    create_time varchar not null,
    end_time varchar,
    status int not null default 1
);