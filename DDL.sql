create schema gta;

use gta;

create user 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on gta.* to user@'localhost';

create table character(
    id bigint not null auto_increment,
    name varchar(200) not null,
    primary key(id),
);

create table group(
    id bigint not null auto_increment,
    code varchar(100) not null,
    name varchar(200) not null,
    primary key(id),
);

create table group_character(
    id bigint not null auto_increment,
    characterId bigint not null,
    groupId bigint not null,
    primary key(id),
    foreign key (groupId) references group(id),  
    foreign key (characterId) references character(id),  
);
