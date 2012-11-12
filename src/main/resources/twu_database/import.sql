use IOUdb;


insert into UserTable(email,username,password,phoneNumber) values('sajacobs@thoughtworks.com','Sam Jacobs','1234','999-9999');
insert into UserTable(email,username,password,phoneNumber) values('rahlawat@thoughtworks.com','Renu Ahlawat','1234','999-9999');
insert into UserTable(email,username,password,phoneNumber) values('yding@thoughtworks.com', 'Yue', 'yue123','13991871507');

insert into connections(user_email,connection_email) values ('yding@thoughtworks.com','faris@thoughtworks.com');
insert into connections(user_email,connection_email) values ('yding@thoughtworks.com','sam@thoughtworks.com');
insert into connections(user_email,connection_email) values ('yding@thoughtworks.com','renu@thoughtworks.com');