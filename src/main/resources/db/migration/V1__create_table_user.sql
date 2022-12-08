CREATE TABLE user(
	uuid varchar(255) primary key,
    login varchar(255) not null unique,
    password varchar(255) not null,
    name varchar(255)
);