create table items
(itemId integer not null,
name varchar(255) not null,
price decimal(10,2) not null,
quantity integer not null,
updated_time timestamp);

insert into items (itemId,name,price,quantity,updated_time) values(10001,'lehanga','12000.00',5,CURRENT_TIMESTAMP());

insert into items (itemId,name,price,quantity,updated_time) values(10002,'lehanga','12000.00',5,CURRENT_TIMESTAMP());

insert into items (itemId,name,price,quantity,updated_time) values(10003,'lehanga','12000.00',5,CURRENT_TIMESTAMP());