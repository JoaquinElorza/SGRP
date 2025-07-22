create table persona(
 id_persona int primary key auto_increment,
 nombre varchar(50),
 ap_paterno varchar(50),
 ap_materno varchar(50),
 status varchar(1)
 );
 
 create table roles(
 id_rol int primary key,
 nombre_rol varchar(15));
 
 create table usuario(
 id_usuario int primary key auto_increment,
 nombre_usuario varchar(50),
 contraseña varchar(8),
 fk_persona int,
 fk_rol int,
 foreign key (fk_persona) references persona(id_persona),
 foreign key (fk_rol) references roles(id_rol));
 
 create table alumno(
 id_alumno int primary key auto_increment,
 n_control varchar(9),
 telefono varchar(10),
 fk_persona int,
 correo varchar(50),
 foreign key (fk_persona) references persona(id_persona));
 
 create table expediente_alumno(
 id_documentosAlumno int primary key auto_increment,
 documento varchar(25),
 estatus boolean,
 fk_alumno int,
 foreign key (fk_alumno) references alumno(id_alumno));
 
 create table soli_residencia(
 id_solicitudResidencia int primary key auto_increment,
 fk_estatus int,
 fk_alumno int,
 foreign key (fk_estatus) references estatus_soli_residencia(id_estatus),
 foreign key (fk_alumno) references alumno(id_alumno));
 
 create table estatus_soli_residencia(
 id_estatus int primary key auto_increment,
 estatus varchar(25));