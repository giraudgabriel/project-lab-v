drop schema if exists gta;
create schema if not exists gta;

use gta;

create user if not exists 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on gta.* to user@'localhost';

create table if not exists cha_character (
  cha_id bigint not null auto_increment,
  cha_name VARCHAR(200) not null,
  cha_password VARCHAR(100) not null,
  primary key(cha_id)
);


create table if not exists gro_group(
    gro_id bigint not null auto_increment,
    gro_code varchar(100) not null,
    gro_name VARCHAR(200) not null,
    primary key(gro_id)
);

create table if not exists grc_group_character(
    grc_id bigint not null auto_increment,
    grc_character_id bigint not null,
    grc_group_id bigint not null,
    primary key(grc_id),
    constraint fk_group_character_group foreign key (grc_group_id) references gro_group(gro_id),  
    constraint fk_group_character_character foreign key (grc_character_id) references cha_character(cha_id)
);

create table if not exists bkc_bank_character(
    bkc_id bigint not null auto_increment,
    bkc_balance bigint not null,
    bkc_character_id bigint not null,
    primary key(bkc_id),
    constraint fk_bank_character foreign key (bkc_character_id) references cha_character(cha_id)
);

insert into cha_character (cha_name, cha_password) values ('Giraud', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into cha_character (cha_name, cha_password) values ('usuario', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into gro_group (gro_name, gro_code) values ('Polícia', 'policia');
insert into gro_group (gro_name, gro_code) values ('Administrador', 'admin');
insert into grc_group_character (grc_character_id, grc_group_id) values (1,1);
insert into grc_group_character (grc_character_id, grc_group_id) values (1,2);
insert into bkc_bank_character (bkc_balance, bkc_character_id) values (5000,1);