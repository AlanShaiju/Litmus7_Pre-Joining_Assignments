create database RetailDB;

use RetailDB;

create table Product (ProductID int primary key, Name varchar(35) not null,Category varchar(35) not null, Price double(10,2) not null, StockQuantity int not null);
