use master
create database Weathers

--ƒл€ погоды необходимо хранить: 
--Ч регион; 
--Ч дату; 
--Ч температуру; 
--Ч осадки. 
--ƒл€ регионов необходимо хранить: 
--Ч название; 
--Ч площадь; 
--Ч тип жителей. 
--ƒл€ типов жителей необходимо хранить: 
--Ч название; 
--Ч €зык общени€.

use Weathers
create table Citizen_type
(
name char(20) primary key,
language char(20)
)

create table Region
(
name char(20) primary key,
square int,
citizen_type char(20) foreign key references Citizen_type(name)
)

create table Weather
(
region char(20) foreign key references Region(name),
_date date primary key,
temperature real,
precipitation real
)
insert into Citizen_type values
('беларусы', 'беларуский'),
('украинцы', 'украинский'),
('русские', 'русский'),
('пол€ки', 'польский'),
('литовцы', 'литовский')

insert into Region values
('ћинск', 2009786 , 'беларусы'),
(' иев', 2962180 , 'украинцы'),
('ћосква', 12635466 , 'русские'),
('¬аршава', 1794166 , 'пол€ки'),
('¬ильнюс', 588412 , 'литовцы')

insert into Weather values
('ћинск', '2022-04-21', 7 , 737 ),
(' иев', '2021-12-03' , -8 , 360 ),
('ћосква', '2022-01-07' , -9 , 18 ),
('¬аршава', '2022-02-15' , -5 , 174 ),
('¬ильнюс', '2021-07-21' , 23 , 9 )