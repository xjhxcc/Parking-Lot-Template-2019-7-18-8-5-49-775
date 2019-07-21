create table parking_lot(
    id bigint primary key,
    name varchar unique,
    parking_size int not null check (parking_size>0),
    location varchar
);