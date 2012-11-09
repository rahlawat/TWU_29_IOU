
create database if not exists IOUdb;

use IOUdb;


drop table if exists bill;
drop table if exists UserTable;
drop table if exists connections;


create table if not exists UserTable(
  email varchar(25) primary key,
  username varchar(25),
  password varchar(25),
  phoneNumber varchar(15)
);

create table if not exists bill(
   description varchar(80) not null,
   amount float not null
);

 create table if not exists connections(
   user_email varchar(25) not null,
   connection_email varchar(25) not null
 );