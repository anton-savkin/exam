create sequence if not exists specialities_seq
    start 1;

create table if not exists specialities
(
    id   bigint not null          default nextval('specialities_seq' :: regclass),
    description  text   not null,
    constraint specialities_id_pk
    primary key (id)
    );

comment on table chairs is 'Информация о специализациях';

comment on column chairs.id is 'Идентификатор специализации';
comment on column chairs.description is 'Описание специализации';