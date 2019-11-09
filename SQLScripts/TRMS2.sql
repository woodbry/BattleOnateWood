--employee table
create table employees( 
employee_id integer primary key,
employee_first_name varchar(20),
employee_last_name varchar(25),
employee_user_name varchar(50),
employee_password varchar(50),
locale varchar(100),
available_funds integer default 1000,
is_dep_head boolean default false,
is_dir_super boolean default false,
is_ben_coord boolean default false
);

--event type table
create table event_table(
event_type varchar(50) primary key,
event_grading_format_id integer
);

--grade can be null so null returns as pass
create table grade_format(
grade_format_id integer primary key,
grade varchar,
passing_grade boolean default true
);

--grade recieved can be a null value
create table forms(
form_id integer primary key,
submittor_eid integer,
supervisor_name varchar(50),
event_name varchar(100),
event_type varchar(50),
event_cost numeric,
supervisor_approval boolean default false,
dep_head_approval boolean default false,
ben_coord_approval boolean default false,
date_completed varchar(20),
attached_file bytea
);

/*
 *Constraints 
 */
alter table forms 
add constraint fk_event_type 
foreign key (event_type) 
references event_table(event_type) 
on update cascade on delete cascade;

alter table forms
drop constraint fk_event_type;

alter table event_table 
add constraint fk_event_grading_format 
foreign key (event_grading_format_id) 
references grade_format(grade_format_id)
 on update cascade on delete cascade;
 
 alter table forms 
 add constraint fk_emp_id
 foreign key(submittor_eid)
 references employees(employee_id);
 
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
before insert on employees
for each row
execute function employee_insert();

--trigger for inserting into the user table
create trigger form_insert
before insert on forms
for each row
execute function form_insert();

--return set for login
create TYPE login_result AS (id int, user_first_name text, user_last_name text);

--return user id and username upon successful login
CREATE or replace function employee_login(text ,text) RETURNS login_result
    AS $$ 
SELECT employee_id , employee_first_name, employee_last_name
from employees
where employees.employee_user_name= $1 
		and 
		employee_password=$2
; $$
    LANGUAGE SQL;



--inputting sim forms
INSERT INTO forms values(DEFAULT,(select employee_id from employees where employees.employee_user_name='bbarker'),'Dorothy Diaz','someEvent', 'standardGrade',500, DEFAULT, default, default, '2019-11-06',null);
INSERT INTO forms values(DEFAULT,(select employee_id from employees where employees.employee_user_name='ccav'),'Dorothy Diaz','someEvent', 'standardGrade',800, DEFAULT, default, default, '2019-11-07',null);
INSERT INTO forms values(DEFAULT,(select employee_id from employees where employees.employee_user_name='iindra'),'Grant Gordon','someEvent', 'standardGrade',80, DEFAULT, default, default, '2019-12-07',null);
INSERT INTO forms values(DEFAULT,(select employee_id from employees where employees.employee_user_name='jjohnson'),'Grant Gordon','someEvent', 'standardGrade',350, DEFAULT, default, default, '2019-12-08',null);
insert into employees values(default, 'Bob', 'Barker','bbarker','1', 'tampa', default, default, default, default);
insert into employees values(default, 'Charlie', 'Cass','ccav','1', 'tampa', default, default, default, default);
insert into employees values(default, 'Dorothy', 'Diaz','ddiaz','2', 'tampa', default, default, true, default);
insert into employees values(default, 'Eugene','Eres', 'eeres','3','new york', default,true, default, default);
insert into employees values(default, 'Frank', 'Fieri', 'ffieri', '4', 'tampa', default, default, default, true);
insert into employees values(default, 'Grant', 'Gordon','ggordon', '3', 'new york', default, true, true, default);
insert into employees values(default, 'Harold', 'Holmes','hholmes','1', 'tampa', default, default, default, default);
insert into employees values(default, 'Isaiah', 'Indra','iindra','1', 'new york', default, default, default, default);
insert into employees values(default, 'Juan', 'Johnson','jjohnson','1', 'new york', default, default, default, default);
insert into employees values(default, 'Kevin', 'King','kking','1', 'tampa', default, default, default, default);
truncate table forms;
truncate table employees;
insert into event_table values('University Course', 1);
insert into event_table values('Certification Prep', 2);
insert into event_table values('Certification', 3);
insert into event_table values('Technical Training', 4);
insert into event_table values('Other', 5);

 