create database minifactura;
use minifactura;

create table moneda(
    id int not null primary key auto_increment,
    denominacion varchar(10),
    tipo_cambio decimal(11,2),
    simbolo varchar(10),
    estado char(1) default '1'
);
insert into moneda values (1,'SOLES',1.0,'S/.','1'), (2,'DOLARES',3.61,'$','1');

create table cliente(
    id int not null primary key auto_increment,
    nombre varchar(30),
    apellido_paterno varchar(30),
    apellido_materno varchar(30),
    estado char(1) default '1'
);
insert into cliente values (1,'OSCAR','cristia','tapia','1'), (2,'RENATO','cardenas','soto','1'), (3,'CHARLES','málaga','di maría','1');

create table marca(
    id int not null primary key auto_increment,
    denominacion varchar(20),
    estado char(1) default '1'
);
insert into marca values (1,'Xiaomi',1);

create table modelo(
    id int not null primary key auto_increment,
    marca_id int,
    denominacion varchar(20),
    estado char(1) default '1',
    foreign key (marca_id) references marca(id)  ON DELETE NO ACTION ON UPDATE NO ACTION
);
insert into modelo values (1,1,'Redmi Note 10',1);

create table producto(
    id int not null primary key auto_increment,
    marca_id int,
    modelo_id int,
    denominacion varchar(100),
    precio_unitario decimal(11,2),
    color varchar (10),
    estado char(1) default '1',
    foreign key (marca_id) references marca(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    foreign key (modelo_id) references modelo(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
insert into producto values 
(1,1,1,'Xiaomi Redmi Note 10 4GB 64GB - Gris',699.90,'Gris','1'),
(2,1,1,'Xiaomi Redmi Note 10 4GB 128GB - Gris',799.90,'Gris','1'),
(3,1,1,'Xiaomi Redmi Note 10 4GB 64GB - Verde',699.90,'Verde','1');

create table factura(
    id int not null primary key auto_increment,
    cliente_id int,
    moneda_id int,
    numero varchar(30),
    fecha varchar(10),
    monto decimal(11,2),
    estado char(1) default 1,
    foreign key (cliente_id) references cliente(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    foreign key (moneda_id) references moneda(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
insert into factura values(1,1,1,'F1', '18/04/2021',699.90,'1'),(2,2,1,'F2', '18/04/2021',799.90,'1'),(3,3,1,'F3', '18/04/2021',699.90,'1');

create table factura_detalle(
    id int not null primary key auto_increment,
    factura_id int,
    producto_id int,
    precio_unitario decimal(11,2),
    precio_parcial decimal(11,2),
    cantidad int,
    foreign key (factura_id) references factura(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    foreign key (producto_id) references producto(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
insert into factura_detalle values(1,1,1,699.90,699.90,1), (2,2,3,799.90,799.90,1), (3,3,3,699.90,699.90,1);

CREATE TABLE factura_factura_detalle (
  factura_entity_id bigint(20) NOT NULL,
  factura_detalle_id bigint(20) NOT NULL
) ENGINE=MyISAM;

ALTER TABLE factura_factura_detalle
  ADD UNIQUE KEY UK_rl454gcdou1twk5emndrqthn0 (factura_detalle_id),
  ADD KEY FKae37j5xg9owiqoyr90i3bixgj (factura_entity_id);
