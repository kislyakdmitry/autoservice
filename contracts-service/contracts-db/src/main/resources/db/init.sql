insert into employees(first_name, last_name, username, password) values('Jon','Snow','employee1', 'pass1');
insert into employees(first_name, last_name, username, password) values('Tyrion','Lannister','employee2', 'pass2');
insert into employees(first_name, last_name, username, password) values('Daenerys','Targaryen','employee3', 'pass3');
insert into employees(first_name, last_name, username, password) values('Ned','Stark','employee4', 'pass4');

insert into customers(first_name, last_name) values('Theon','Greyjoy');

insert into contracts(start_time, end_time, employee_id, customer_id) values(current_timestamp, current_timestamp, 1, 1);