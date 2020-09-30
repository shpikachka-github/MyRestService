create table student_accounts (
   id bigint not null,
   full_name varchar(256) not null,
   date_of_birth date not null,
   constraint student_accounts_pk primary key (id)
);

insert into student_accounts (id, full_name, date_of_birth) values (1, 'Tom', '1/8/1999');
insert into student_accounts (id, full_name, date_of_birth) values (2, 'Jerry', '12/12/1997');
insert into student_accounts (id, full_name, date_of_birth) values (3, 'Donald', '26/8/1998');

create sequence students_id_seq start with 4 increment by 1;