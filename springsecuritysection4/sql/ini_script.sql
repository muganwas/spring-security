drop database if exists eazybank;

create database eazybank;

use eazybank;

create table users(
    id int not null auto_increment primary key,
	username varchar(50) not null,
	password varchar(500) not null,
	enabled int not null
);

create table authorities (
    id int not null auto_increment primary key,
	username varchar(50) not null,
	authority varchar(50) not null
);

create table customer(
    id int not null auto_increment primary key,
	email varchar(50) not null,
	pwd varchar(500) not null,
	role varchar(45) not null
);

insert IGNORE into customer values(null, 'badpunter256@gmail.com', 'dev1234.', 'admin');
insert IGNORE into users values(null, 'happy', '12345', '1');
insert IGNORE into authorities values(null, 'happy', 'write');