create table brand_group (
    id int not null primary key,
    name varchar(64) not null,
    description varchar(255)
);

create table prices (
     id int not null primary key,
     price_list int,
     brand_id int not null,
     start_date timestamp,
     end_date timestamp,
     product_id int not null,
     priority int,
     price float not null,
     currency varchar(255),
     foreign key (brand_id) references brand_group(id)
);

insert into brand_group
(id, name, description)
values
(1, 'ZARA','Products from ZARA');


insert into prices
(id, price_list, brand_id, start_date, end_date, product_id, priority, price, currency)
values
(1, 1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35455, 0, 35.50, 'EUR'),
(2, 2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 35455, 1, 25.45, 'EUR'),
(3, 3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 35455, 1, 30.50, 'EUR'),
(4, 4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 35455, 1, 38.95, 'EUR');