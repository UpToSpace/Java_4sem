use master
create database Weathers

--��� ������ ���������� �������: 
--� ������; 
--� ����; 
--� �����������; 
--� ������. 
--��� �������� ���������� �������: 
--� ��������; 
--� �������; 
--� ��� �������. 
--��� ����� ������� ���������� �������: 
--� ��������; 
--� ���� �������.

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
('��������', '����������'),
('��������', '����������'),
('�������', '�������'),
('������', '��������'),
('�������', '���������')

insert into Region values
('�����', 2009786 , '��������'),
('����', 2962180 , '��������'),
('������', 12635466 , '�������'),
('�������', 1794166 , '������'),
('�������', 588412 , '�������')

insert into Weather values
('�����', '2022-04-21', 7 , 737 ),
('����', '2021-12-03' , -8 , 360 ),
('������', '2022-01-07' , -9 , 18 ),
('�������', '2022-02-15' , -5 , 174 ),
('�������', '2021-07-21' , 23 , 9 )