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
employee_last_name varchar(100),

available_funds integer default 1000
locale varchar(100)
);

--login table don't worry I'll leave it as strings for now 
--would not normally be handled this way in production, bad practice
create table login(
employee_id integer
);

--Grading format table??
create table grade_format(
--so we know which form is which
form_id integer primary key,
--so we know what the reimbursement is for??? Subject to change or removal
form_type varchar(100),
grade_recieved varchar,
grade_point 
)


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