CREATE TABLE book(
	uuid varchar(255) primary key,
    name varchar(255) not null,
    url varchar(255),
    author varchar(255) not null,
    genre varchar(255) not null
);