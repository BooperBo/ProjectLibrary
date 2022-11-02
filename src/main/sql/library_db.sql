CREATE TABLE Person (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name varchar(100) NOT NULL UNIQUE,
    year_of_birth int NOT NULL
);

CREATE TABLE Book (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year int NOT NULL,
    taken_at timestamp,
    person_id int REFERENCES Person(id) ON DELETE SET NULL,
    library_id int REFERENCES Library(id) On DELETE SET NULL
);


CREATE TABLE City(
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(100) UNIQUE NOT NULL
);

insert into City(name) values ('Челябинск');
insert into City(name) values ('Екатеринбург');
select * from City;

CREATE TABLE Library(
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(100) UNIQUE NOT NULL,
    address varchar(100) UNIQUE NOT NULL,
    city_id int REFERENCES City(id) ON DELETE SET NULL
);

insert into Library(name, address, city_id) VALUES ('Центральная библиотека им. А.С. Пушкина',
                                                    'ул. Коммуны 69',1);

insert into Library(name, address, city_id) VALUES ('Библиотека № 32 им. А.М. Горького',
                                                    'Проспект Ленина 5',1);

insert into Library(name, address, city_id) VALUES ('Центральная городская библиотке им. А.И. Герцена',
                                                    'ул. Чапаева 5',2);

insert into Library(name, address, city_id) VALUES ('Библиотека № 17',
                                                    'Проспект Ленина 70',2);

select * from library;

drop table Person;
drop table Book;

alter table book add column taken_at timestamp;