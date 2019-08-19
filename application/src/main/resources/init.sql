insert into cars(name, price, created, ordered) values('Audi A4', 100, current_timestamp, true);
insert into cars(name, price, created, ordered) values('Chevrolet Niva', 100, current_timestamp, true);
insert into cars(name, price, created, ordered) values('Lada Largus', 100, current_timestamp, true);
insert into cars(name, price, created, ordered) values('Lada 4x4', 100, current_timestamp, true);
insert into cars(name, price, created, ordered) values('Toyota RAV 4', 100, current_timestamp, true);
insert into cars(name, price, created) values('Lada Vesta', 100, current_timestamp);
insert into cars(name, price, created) values('Renault Duster', 100, current_timestamp);
insert into cars(name, price, created) values('KIA Rio', 100, current_timestamp);
insert into cars(name, price, created) values('Lada Granta', 100, current_timestamp);

insert into employees(first_name, last_name, username, password, role) values('Jon','Snow','employee1', '$2y$08$p52qv7Gn1ay7wx6dXOZAIusKtdwiKcFfaxszDmcbcAnkpM2Odqsk6', 'EMPLOYEE');
insert into employees(first_name, last_name, username, password, role) values('Tyrion','Lannister','employee2', '$2y$08$p52qv7Gn1ay7wx6dXOZAIusKtdwiKcFfaxszDmcbcAnkpM2Odqsk6', 'EMPLOYEE');
insert into employees(first_name, last_name, username, password, role) values('Daenerys','Targaryen','employee3', '$2y$08$p52qv7Gn1ay7wx6dXOZAIusKtdwiKcFfaxszDmcbcAnkpM2Odqsk6', 'EMPLOYEE');
insert into employees(first_name, last_name, username, password, role) values('Ned','Stark','employee4', '$2y$08$p52qv7Gn1ay7wx6dXOZAIusKtdwiKcFfaxszDmcbcAnkpM2Odqsk6', 'EMPLOYEE');

insert into customers(first_name, last_name, username, password, role) values('Theon','Greyjoy','user1', '$2y$08$p52qv7Gn1ay7wx6dXOZAIusKtdwiKcFfaxszDmcbcAnkpM2Odqsk6', 'CUSTOMER');

insert into contracts(start_time, end_time, employee_id, customer_id) values(current_timestamp, current_timestamp, 1, 1);

insert into contracts_cars(contract_id, car_id) values(1,1);
insert into contracts_cars(contract_id, car_id) values(1,2);
insert into contracts_cars(contract_id, car_id) values(1,3);
insert into contracts_cars(contract_id, car_id) values(1,4);
insert into contracts_cars(contract_id, car_id) values(1,5);