create sequence if not exists chairs_seq
    start 1;

create table if not exists chairs
(
    id   bigint not null          default nextval('chairs_seq' :: regclass),
    description  text   not null,
    constraint chairs_id_pk
    primary key (id)
    );

comment on table chairs is 'Информация о кафедрах';

comment on column chairs.id is 'Идентификатор кафедры';
comment on column chairs.description is 'Описание кафедры';