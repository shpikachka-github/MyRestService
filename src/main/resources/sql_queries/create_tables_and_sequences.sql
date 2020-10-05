create sequence students_id_seq start with 1 increment by 1;
create sequence specialties_id_seq start with 1 increment by 1;

create table students (
   id bigint not null primary key,
   full_name varchar(256) not null,
   date_of_birth date not null
);

create table specialties (
    id integer not null primary key,
    specialty_name text not null
);

create table students_specialties (
	student_id bigint not null references students(id),
	specialty_id integer not null references specialties(id)
);

insert into students
	values (nextval('students_id_seq'), 'Tom', '1999-8-1');
insert into students
	values (nextval('students_id_seq'), 'Jerry', '1997-12-12');
insert into students
	values (nextval('students_id_seq'), 'Donald', '1998-8-24');

insert into specialties
	values (nextval('specialties_id_seq'), 'Writing');
insert into specialties
	values (nextval('specialties_id_seq'), 'Architecture');
insert into specialties
	values (nextval('specialties_id_seq'), 'Programming');
insert into specialties
	values (nextval('specialties_id_seq'), 'Chemistry');

insert into students_specialties
	values (1, 1);
insert into students_specialties
	values (2, 2);
insert into students_specialties
	values (3, 3);
insert into students_specialties
	values (2, 4);
