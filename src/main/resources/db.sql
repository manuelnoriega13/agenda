create table direcciones
(
  id           int auto_increment
    primary key,
  pais         varchar(45) null,
  estado       varchar(45) null,
  ciudad       varchar(45) null,
  calle        varchar(45) null,
  numero       varchar(45) null,
  piso         varchar(45) null,
  departamento varchar(45) null,
  principal    tinyint     null,
  personas_id  int         null,
  constraint direcciones_ibfk_1
  foreign key (personas_id) references personas (id)
    on update cascade
    on delete cascade
)
  charset = utf8;

create table emails
(
  id          int auto_increment
    primary key,
  email       varchar(45) not null,
  personas_id int         null,
  constraint emails_ibfk_1
  foreign key (personas_id) references personas (id)
    on update cascade
    on delete cascade
);

create table personas
(
  id               int auto_increment
    primary key,
  nombre1          varchar(45) null,
  nombre2          varchar(45) null,
  apellido1        varchar(45) null,
  apellido2        varchar(45) null,
  fecha_nacimiento date        null,
  activo           tinyint(1)  null
);

create table telefonos
(
  id          int auto_increment
    primary key,
  numero      int null,
  personas_id int null,
  constraint telefonos_ibfk_1
  foreign key (personas_id) references personas (id)
    on update cascade
    on delete cascade
);

