create DATABASE appdb;

create table person (
    id int GENERATED by DEFAULT as IDENTITY,
    username varchar(100) NOT NULL UNIQUE,
    year_of_birth int NOT NULL,
    password varchar NOT NULL
);

alter table person add column role varchar(100) not null;