
create database if not exists IOUdb;

use IOUdb;


drop table if exists bill;
drop table if exists UserTable;
drop table if exists connections;


create table if not exists UserTable(
  email varchar(50) primary key,
  username varchar(50),
  password varchar(25),
  phoneNumber varchar(15)
);

create table if not exists bill(
   description varchar(80) not null,
   amount float not null
);

create table if not exists connections(
   userEmail varchar(50) not null,
   connectionEmail varchar(50) not null,
   primary key(userEmail, connectionEmail)

 );

