create database if not exists IOUdb;

use IOUdb;

drop table if exists UserTable;

create table if not exists UserTable(
  email varchar(25) primary key,
  username varchar(25),
  password varchar(25),
  phoneNumber varchar(15)
)ENGINE=InnoDB;

create table if not exists Task (
    id int not null,
    name varchar(80) null,
    description varchar(300) null,
    points int null,
    code varchar(10) null,
    constraint pk_task primary key (id)
)ENGINE=InnoDB;

create table if not exists bill(
   description varchar(80) not null,
   amount float not null
)ENGINE=InnoDB;
