create sequence if not exists teachers_seq
    start 1;

create table if not exists teachers
(
    id   bigint not null          default nextval('teachers_seq' :: regclass),
    last_name   text   not null,
    first_name  text   not null,
    middle_name text not null,
    chair_id bigint not null,
    constraint teachers_id_pk
    primary key (id),
    constraint teachers_chair_id_fk
    foreign key (chair_id)
    references chairs (id)
    );

comment on table teachers is 'Информация о преподавателях';

comment on column teachers.id is 'Идентификатор преподавателя';
comment on column teachers.last_name is 'Фамилия преподавателя';
comment on column teachers.first_name is 'Имя преподавателя';
comment on column teachers.middle_name is 'Отчество преподавателя';
comment on column teachers.chair_id is 'Ссылка на кафедру';