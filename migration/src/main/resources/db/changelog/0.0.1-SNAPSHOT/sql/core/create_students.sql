create sequence if not exists students_seq
    start 1;

create table if not exists students
(
    id   bigint not null          default nextval('students_seq' :: regclass),
    last_name   text   not null,
    first_name  text   not null,
    middle_name text not null,
    speciality_id bigint not null,
    course   int   not null,
    constraint students_id_pk
    primary key (id),
    constraint students_speciality_id_fk
    foreign key (speciality_id)
    references specialities (id)
);

comment on table students is 'Информация о студентах';

comment on column students.id is 'Идентификатор студента';
comment on column students.last_name is 'Фамилия студента';
comment on column students.first_name is 'Имя студента';
comment on column students.middle_name is 'Отчество студента';
comment on column students.speciality_id is 'Ссылка на специальность';
comment on column students.course is 'Курс студента';