
insert into order_table (id,customer_name,amount,order_date)
values(20001, 'UmaVeera',1000, '2020-11-11');

insert into order_table (id,customer_name,amount,order_date)
values(20002, 'Veera',85, '2020-11-12');

insert into order_table (id,customer_name,amount,order_date)
values(20003, 'epam',23, '2020-11-15');

insert into address (id,address_type,state,pincode,address_line1,city,mobile_number,order_id)
values(30001, 'shipping', 'Telangana',500032, 'Flat-404 Gachibowli','Hyderabad',9951424500,20001);

insert into address (id,address_type,state,pincode,address_line1,city,mobile_number,order_id)
values(30002, 'billing', 'Telangana',500032, 'Flat-404 Gachibowli','Hyderabad',9951424500,20001);