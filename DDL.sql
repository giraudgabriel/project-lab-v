create schema if not exists gta;

use gta;

create user if not exists 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on gta.* to user@'localhost';

create table if not exists `character` (
  id bigint not null auto_increment,
  `name` VARCHAR(200) not null,
  primary key(id)
);


create table if not exists `group`(
    id bigint not null auto_increment,
    `code` varchar(100) not null,
    `name` VARCHAR(200) not null,
    primary key(id)
);

create table if not exists group_character(
    id bigint not null auto_increment,
    characterId bigint not null,
    groupId bigint not null,
    primary key(id),
    foreign key (groupId) references `group`(id),  
    foreign key (characterId) references `character`(id)
);

create table if not exists bank_character(
    id bigint not null auto_increment,
    balance bigint not null,
    characterId bigint not null,
    primary key(id),
    foreign key (characterId) references `character`(id)
);
