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
 
  create table documentos(
 id_documento int primary key auto_increment,
 documento varchar(25));
 
 create table expediente_alumno(
 id_documentosAlumno int primary key auto_increment,
 fk_documento int,
 estatus boolean,
 fk_alumno int,
 foreign key (fk_alumno) references alumno(id_alumno),
 foreign key (fk_documento) references documentos(id_documento));
 
 create table soli_residencia(
 id_solicitudResidencia int primary key auto_increment,
 fk_estatus int,
 fk_alumno int,
 foreign key (fk_estatus) references estatus_soli_residencia(id_estatus),
 foreign key (fk_alumno) references alumno(id_alumno));
 
 create table estatus_soli_residencia(
 id_estatus int primary key auto_increment,
 estatus varchar(25));
 
 CREATE TABLE docente (
    id_docente INT PRIMARY KEY AUTO_INCREMENT,
    n_control VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(10),
    correo VARCHAR(50),
    fk_persona INT,
    FOREIGN KEY (fk_persona) REFERENCES persona(id_persona)
);

CREATE TABLE empresa (
  id_empresa INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  contacto VARCHAR(15) NOT NULL
);

CREATE TABLE proyecto (
    id_proyecto INT AUTO_INCREMENT PRIMARY KEY,
    fk_empresa INT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    estatus ENUM('Disponible', 'No disponible') DEFAULT 'Disponible',
    FOREIGN KEY (fk_empresa) REFERENCES empresa(id_empresa)
);