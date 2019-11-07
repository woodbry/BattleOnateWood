
/*
 *Tables needed	
 */
--employee table
create table employee( 
employee_id integer primary key,
employee_first_name varchar(20),
employee_last_name varchar(25),
employee_user_name varchar(100),
available_funds integer default 1000,
locale varchar(100)
);

--here is where roles go
create table employee_type (
employee_id integer,
employee_role varchar(10),
primary key (employee_id,employee_role)
);

--what those roles are
create table employee_role(
employee_role varchar(10) primary key,
description varchar(50)
);


--login table don't worry I'll leave it as strings for now 
--would not normally be handled this way in production, bad practice unsecure
create table login(
employee_user_name varchar(50) primary key,
employee_password varchar(25)
);

--event type table
create table event_table(
event_type varchar(50)primary key,
event_grading_format_id integer
);

--grade can be null so null returns as pass
create table grade_format(
grade_format_id integer primary key,
grade varchar,
passing_grade boolean default true
);

--look up table for the forms and employees
create table employee_forms(
employee_id integer,
form_id integer,
primary key(employee_id, form_id)
);

--grade recieved can be a null value
create table form(
form_id integer primary key,
submittor_name varchar(100),
supervisor_name varchar(50),
event_name varchar(100),
event_type varchar(50),
grade_recieved varchar(10),
supervisor_approval boolean default false,
event_cost numeric,
date_completed varchar(20),
attached_file bytea
);

/*
 *Constraints 
 */
alter table employee_type
add constraint fk_employee_role
foreign key (employee_role)
references employee_role(employee_role)
on update cascade on delete cascade;

alter table employee_type
add constraint fk_employee_id
foreign key (employee_id)
references employee(employee_id)
on update cascade on delete cascade;

alter table employee_forms
add constraint fk_form_id
foreign key (form_id)
references form(form_id)
on update cascade on delete cascade;

alter table employee_forms 
add constraint fk_employee_id
foreign key (employee_id)
references employee(employee_id)
on delete cascade on update cascade;

alter table form 
add constraint fk_event_type 
foreign key (event_type) 
references event_table(event_type) 
on update cascade on delete cascade;

alter table employee 
add constraint fk_employee_user_name
foreign key (employee_user_name)
references login(employee_user_name)
on update cascade on delete cascade;

alter table event_table 
add constraint fk_event_grading_format 
foreign key (event_grading_format_id) 
references grade_format(grade_format_id)
 on update cascade on delete cascade;

/*
 *  alter table bear add constraint fk_bear_cave foreign key(cave_id) references cave(cave_id) ;
 */


--sequence for account id's *is running already
create sequence employee_seq
	increment by -17
	start with 10101101
	minvalue 9000
	maxvalue 91010011;

--sequence for user id's *is running already
CREATE SEQUENCE form_seq
	increment by -3
	START with 13337
	MINVALUE 975
	MAXVALUE 101010;

--return set for login
CREATE TYPE login_result AS (id int,user_name text);

--return user id and username upon successful login
CREATE function employee_login(text ,text) RETURNS login_result
    AS $$ 
SELECT employee_id , employee_user_name
from employee
where employee.employee_user_name= (
		select employee_user_name 
		from login 
		where login.employee_user_name= $1 
		and 
		login.employee_password=$2
); $$
    LANGUAGE SQL;




--add generated user id upon insert
create or replace function form_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new.form_id = (select nextval('form_seq'));
	end if;
	return new;
end;
$$ language plpgsql;

--trigger for inserting into the user table
create trigger form_insert
before insert on form
for each row
execute function form_insert();

--add generated account id upon insert
create or replace function employee_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new.employee_id = (select nextval('employee_seq'));
	end if;
	return new;
end;
$$ language plpgsql;

--trigger for inserting into the user table
create trigger employee_insert
before insert on employee
for each row
execute function employee_insert();


