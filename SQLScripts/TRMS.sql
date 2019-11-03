--Employee table
/*
 * private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private String location;
		private int empId;
		private double availableFunds;
		private boolean isDepHead;
		private boolean isDirectSup;
		private boolean isBennyCoord;
		
		to go into a role table later
		
		is_department_head boolean default false,
		is_benny_coord boolean default false,
		
 */
create table employee( employee_id integer primary key,
employee_type_id integer,
employee_name varchar(100),
employee_user_name varchar(100),
available_funds integer default 1000
locale varchar(100)
);

--login table don't worry I'll leave it as strings for now 
--would not normally be handled this way in production, bad practice
create table login(
employee_id integer,
employee_user_name varchar(50),
employee_password varchar(25)
);

--Grading format table??
create table grade_format(
--so we know which form is which
--so we know what the reimbursement is for??? Subject to change or removal
--form_type varchar(100),
grade_recieved varchar,
grade_point numeric,
is_passing boolean
)

create table form(
form_id integer,
submittor_name varchar(100),
submittor_id integer,
supervisor_name varchar(50),
event_name varchar(100),
event_type varchar(25),
grading_format varchar(25),
grade_recieved varchar(10),
supervisor_approval boolean default false,
event_cost numeric,
date_completed varchar(20),
attached_file bytea
);



/*using the examples to jump frame up what I want DB tables to look like
create table bear_type( bear_type_id integer primary key,
bear_type_name varchar(100) );
create table cave( cave_id integer primary key,
cave_name varchar(100),
max_bears integer default 4 );
create table beehive( beehive_id integer primary key,
beehive_weight integer default 50 );
create table bear_beehive( bear_id integer,
beehive_id integer,
primary key(bear_id,
beehive_id) );
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
CREATE TYPE login_result AS (id int,uname text, myrole int);

--return user id and username upon successful login
CREATE function employee_login(text ,int) RETURNS login_result
    AS $$ 
SELECT employee_id , employee_last_name, employee_role
from employee
where employee.employee_user_name= (
		select employee_user_name 
		from login 
		where login.employee_user_name= $1 
		and 
		login.employee_password=$2
); $$
    LANGUAGE SQL;

SELECT * FROM login('test',42);



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


