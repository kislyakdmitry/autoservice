insert into cars(name, price) values('Audi A4', 100);
insert into cars(name, price) values('Chevrolet Niva', 100);
insert into cars(name, price) values('Lada Largus', 100);
insert into cars(name, price) values('Lada 4x4', 100);
insert into cars(name, price) values('Toyota RAV 4', 100);
insert into cars(name, price) values('Lada Vesta', 100);
insert into cars(name, price) values('Renault Duster', 100);
insert into cars(name, price) values('KIA Rio', 100);
insert into cars(name, price) values('Lada Granta', 100);

insert into employees(first_name, last_name, username, password) values('Jon','Snow','employee1', 'pass1');
insert into employees(first_name, last_name, username, password) values('Tyrion','Lannister','employee2', 'pass2');
insert into employees(first_name, last_name, username, password) values('Daenerys','Targaryen','employee3', 'pass3');
insert into employees(first_name, last_name, username, password) values('Ned','Stark','employee4', 'pass4');

insert into customers(first_name, last_name) values('Theon','Greyjoy');

insert into contracts(start_time, end_time, employee_id, customer_id) values(current_timestamp, current_timestamp, 1, 1);

insert into contracts_cars(contract_id, car_id) values(1,1);
insert into contracts_cars(contract_id, car_id) values(1,2);
insert into contracts_cars(contract_id, car_id) values(1,3);
insert into contracts_cars(contract_id, car_id) values(1,4);
insert into contracts_cars(contract_id, car_id) values(1,5);