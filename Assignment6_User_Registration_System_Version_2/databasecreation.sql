create database userregistration;

user userregistration;

create table User(UserId int primary key auto_increment, Username varchar(50) not null, Age int not null, Email varchar(60) not null unique, Password varchar(60) not null);


