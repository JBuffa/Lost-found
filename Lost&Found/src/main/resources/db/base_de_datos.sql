-- AVISOS

CREATE SEQUENCE public."Avisos_id_seq"
    INCREMENT 1
    START 12
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public."Avisos_id_seq"
    OWNER TO postgres;
    
-- Table: public.avisos

-- DROP TABLE public.avisos;

CREATE TABLE public.avisos
(
    id integer NOT NULL DEFAULT nextval('"Avisos_id_seq"'::regclass),
    img_avisos text COLLATE pg_catalog."default",
    detalles text COLLATE pg_catalog."default",
    titulo text COLLATE pg_catalog."default",
    CONSTRAINT "Avisos_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.avisos
    OWNER to postgres;
    
INSERT INTO avisos (img_avisos ,titulo, detalles) VALUES ('https://res.cloudinary.com/dfwlfvd87/image/upload/v1528926106/31277546_1730480766990215_2245429208954175488_n.jpg', 'FESTEJÁ EL DÍA DEL ANIMAL VACUNANDO A TU MASCOTA', 'El domingo 29 de abril celebramos el Día del Animal con una jornada de vacunación antirrábica gratuita en la Reserva. Recordá que es necesario presentar DNI y un servicio que acredite tu domicilio en Morón.');
INSERT INTO avisos (img_avisos ,titulo, detalles) VALUES ('https://res.cloudinary.com/dfwlfvd87/image/upload/v1528926106/31963901_1744544998917125_5035053352954626048_n.jpg', '¡TRAÉ A TU MASCOTA!', 'La vacuna antirrábica se aplica sin turno previo y las castraciones son con cupos limitados, reservando turno 10 a 13.30h en el mismo lugar donde se realizará la intervención. Durante la semana la atención será de 9 a 12.30h. Recordá que tenés que presentar el DNI y un servicio que acredite el domicilio en Morón. Para más información comunicarse al 4645-1264/1726 o vía mail a cemsa@moron.gob.ar. Se suspende por lluvia. ¡Te esperamos!');
INSERT INTO avisos (img_avisos ,titulo, detalles) VALUES ('https://res.cloudinary.com/dfwlfvd87/image/upload/v1528926104/30727798_1723981230973502_7741493034222616576_n.jpg', 'Turno telefónicamente para castrar', 'Podes sacar turno telefónicamente para castrar a tu/s Perros y/o Gato/s. Acordate que tenes que tener domicilio dentro de Gobierno de Morón');    
    
    
    -- MASCOTA


CREATE SEQUENCE public.mascota_id_seq
    INCREMENT 1
    START 3
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.mascota_id_seq
    OWNER TO postgres;    
    
-- Table: public.mascota

-- DROP TABLE public.mascota;

CREATE TABLE public.mascota
(
    id integer NOT NULL DEFAULT nextval('mascota_id_seq'::regclass),
    nombre_mascota text COLLATE pg_catalog."default",
    edad text COLLATE pg_catalog."default",
    raza text COLLATE pg_catalog."default",
    vacuna text COLLATE pg_catalog."default",
    castrado text COLLATE pg_catalog."default",
    refugio text COLLATE pg_catalog."default",
    encargado text COLLATE pg_catalog."default",
    img_mascota text COLLATE pg_catalog."default",
    adoptante text COLLATE pg_catalog."default" DEFAULT 'nadie'::text,
    adoptado boolean,
    clasificacion text COLLATE pg_catalog."default",
    CONSTRAINT mascota_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.mascota
    OWNER to postgres;
    
 
INSERT INTO mascota (nombre_mascota, edad, clasificacion , raza, vacuna, castrado, refugio, encargado, img_mascota, adoptante, adoptado) VALUES ('Tamy', '4', 'perro', 'desconocida', 'completas', 'si', 'refugio101', 'Fran2014', 'https://res.cloudinary.com/dfwlfvd87/image/upload/v1529285848/LostFound/mascota/25550167_2306464702704362_7298319902006946966_n.jpg','nadie', false);    
INSERT INTO mascota (nombre_mascota, edad, clasificacion , raza, vacuna, castrado, refugio, encargado, img_mascota, adoptante, adoptado) VALUES ('Milu', '3', 'gato', 'desconocida', 'completas', 'si', 'refugio101', 'Fran2014', 'https://res.cloudinary.com/dfwlfvd87/image/upload/v1529285850/LostFound/mascota/27654886_10212745960901949_1083474735139589798_n.jpg','nadie', false);    
  
    
    
    -- PERDIDOS

CREATE SEQUENCE public."Perdidos_id_seq"
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public."Perdidos_id_seq"
    OWNER TO postgres;
    
-- Table: public.perdidos

-- DROP TABLE public.perdidos;

CREATE TABLE public.perdidos
(
    id integer NOT NULL DEFAULT nextval('"Perdidos_id_seq"'::regclass),
    img_perdido text COLLATE pg_catalog."default",
    descripcion text COLLATE pg_catalog."default",
    usuario text COLLATE pg_catalog."default",
    titulo text COLLATE pg_catalog."default",
    encontrado boolean
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.perdidos
    OWNER to postgres;
    
INSERT INTO perdidos (img_perdido ,titulo, descripcion, usuario) VALUES ('https://res.cloudinary.com/dfwlfvd87/image/upload/v1528926107/26904094_559780924379914_7230938535129990424_n.jpg', 'AYUDAR A PAMELA A ENCONTRAR A SU PERRITA MÍA', 'Estoy cansada de publicar y que no me den pelota , la quiero encontrar y nadie ni siquiera apreta compartir , lo hacen con todos y a mi ni mg le ponen a la publi ?? voy a ponerlo una vez mas , se llama mia y desaparecio en ramos mejia la calle sgto cabral y rawson , responde a su nombre y hace 4 semanas no se nada de ella , se crio conmigo y no tenerla me hace mal saben? Porfavor difundanlo y si saben algo mi numero es 1534950474 ( pamela) y otro es 1554850134 (teresa) gracias...', '1');
INSERT INTO perdidos (img_perdido ,titulo, descripcion, usuario) VALUES ('https://res.cloudinary.com/dfwlfvd87/image/upload/v1528926107/26167290_10215601649333834_878326526294533597_n.jpg', 'Perdido en Haedo', 'Amigos Tobi se fue de casa ayer a la madrugada, en la zona de Haedo Norte. Si alguno lo ve ya sea en la calle o en alguna pagina de perros encontrados me pega un llamadito? 155455-8556. Muchas gracias', '3');

    
    
    -- REFUGIO

CREATE SEQUENCE public."Refugio_id_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public."Refugio_id_seq"
    OWNER TO postgres;
    
-- Table: public.refugio

-- DROP TABLE public.refugio;

CREATE TABLE public.refugio
(
    id integer NOT NULL DEFAULT nextval('"Refugio_id_seq"'::regclass),
    nombre_refugio text COLLATE pg_catalog."default",
    contrasenia text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    telefono text COLLATE pg_catalog."default",
    direccion text COLLATE pg_catalog."default",
    barrio text COLLATE pg_catalog."default",
    encargado text COLLATE pg_catalog."default",
    admin_refugio boolean,
    codigo text COLLATE pg_catalog."default",
    img_refugio text COLLATE pg_catalog."default",
    facebook text COLLATE pg_catalog."default",
    CONSTRAINT "Refugio_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.refugio
    OWNER to postgres;
    
INSERT INTO refugio (nombre_refugio , contrasenia, email, telefono, barrio, direccion, admin_refugio, img_refugio, encargado, facebook) VALUES ('refugio101', '123', 'fran_2014@gmail.com', '4459 2250', 'Moron', 'Rivadavia 22222', true, 'https://res.cloudinary.com/dfwlfvd87/image/upload/v1528968398/1360351510_895606_1360351712_noticia_normal.jpg', 'Susana Miler', 'https://www.facebook.com/GatosYPerrosPerdidosEnMoron/');
INSERT INTO refugio (nombre_refugio , contrasenia, email, telefono, barrio, direccion, admin_refugio, img_refugio, encargado) VALUES ('Casa chica', '333', 'Sandro.p@gmail.com',  '4455 7788', 'Merlo', 'Rivadavia 40000', true,'https://res.cloudinary.com/dfwlfvd87/image/upload/v1529545526/LostFound/refugio/597a05a93a18d.jpg', 'Sandro Perez');
    
    
    -- USUARIO
    
CREATE SEQUENCE public."Usuarios_id_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public."Usuarios_id_seq"
    OWNER TO postgres;
    
-- Table: public.usuarios

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios
(
    id integer NOT NULL DEFAULT nextval('"Usuarios_id_seq"'::regclass),
    contrasenia text COLLATE pg_catalog."default",
    administrador boolean,
    codigo text COLLATE pg_catalog."default",
    correo text COLLATE pg_catalog."default" NOT NULL,
    imagen_de_perfil text COLLATE pg_catalog."default",
    nick text COLLATE pg_catalog."default",
    nombre text COLLATE pg_catalog."default",
    apellido text COLLATE pg_catalog."default",
    CONSTRAINT "Usuarios_pkey" PRIMARY KEY (id, correo)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuarios
    OWNER to postgres;
    
    
    
    -- COMENTARIO
