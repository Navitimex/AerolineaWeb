CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_avion` AS
    SELECT 
        `avion`.`id` AS `id`,
        `avion`.`anio` AS `anio`,
        `avion`.`modelo` AS `modelo`,
        `avion`.`marca` AS `marca`,
        `avion`.`can_asientos` AS `can_asientos`
    FROM
        `avion`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_cliente` AS
    SELECT 
        `cliente`.`id` AS `id`,
        `cliente`.`contrasena` AS `contrasena`,
        `cliente`.`rol` AS `rol`,
        `cliente`.`nombre` AS `nombre`,
        `cliente`.`apellidos` AS `apellidos`,
        `cliente`.`correo` AS `correo`,
        `cliente`.`fec_naci` AS `fec_naci`,
        `cliente`.`direccion` AS `direccion`,
        `cliente`.`tel_trabajo` AS `tel_trabajo`,
        `cliente`.`tel_cel` AS `tel_cel`
    FROM
        `cliente`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_destinos` AS
    SELECT 
        `destinos`.`codigo` AS `codigo`,
        `destinos`.`nombre` AS `nombre`
    FROM
        `destinos`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_horario` AS
    SELECT 
        `horario`.`id` AS `id`,
        `horario`.`dia_semana` AS `dia_semana`,
        `horario`.`hora_salida` AS `hora_salida`,
        `horario`.`hora_llegada` AS `hora_llegada`,
        `horario`.`Ruta_codigo` AS `Ruta_codigo`
    FROM
        `horario`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_reservacion` AS
    SELECT 
        `reservacion`.`id` AS `id`,
        `reservacion`.`ida` AS `ida`,
        `reservacion`.`vuelta` AS `vuelta`,
        `reservacion`.`Cliente_id` AS `Cliente_id`
    FROM
        `reservacion`

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_ruta` AS
    SELECT 
        `ruta`.`codigo` AS `codigo`,
        `ruta`.`origen` AS `origen`,
        `ruta`.`destino` AS `destino`,
        `ruta`.`duracionMin` AS `duracionMin`,
        `ruta`.`precio` AS `precio`,
        `ruta`.`descuento` AS `descuento`
    FROM
        `ruta`		
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_tiquete` AS
    SELECT 
        `tiquete`.`id` AS `id`,
        `tiquete`.`Vuelo_id` AS `Vuelo_id`,
        `tiquete`.`Cliente_id` AS `Cliente_id`,
        `tiquete`.`numero_asiento` AS `numero_asiento`
    FROM
        `tiquete`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_vuelo` AS
    SELECT 
        `vuelo`.`id` AS `id`,
        `vuelo`.`Horario_id` AS `Horario_id`,
        `vuelo`.`Ruta_codigo` AS `Ruta_codigo`,
        `vuelo`.`Avion_id` AS `Avion_id`
    FROM
        `vuelo`
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_ruta_completa` AS
    SELECT 
        `vr`.`codigo` AS `codigo`,
        `d1`.`nombre` AS `origen`,
        `d2`.`nombre` AS `destino`,
        `vr`.`duracionMin` AS `duracionMIn`,
        `vr`.`precio` AS `precio`,
        `vr`.`descuento` AS `descuento`
    FROM
        ((`destinos` `d1`
        JOIN `destinos` `d2`)
        JOIN `vista_ruta` `vr`)
    WHERE
        ((`d1`.`codigo` = `vr`.`origen`)
            AND (`d2`.`codigo` = `vr`.`destino`))

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_horario_commleto` AS
    SELECT 
        `vh`.`id` AS `id`,
        `vh`.`dia_semana` AS `dia_semana`,
        `vh`.`hora_salida` AS `hora_salida`,
        `vh`.`hora_llegada` AS `hora_llegada`,
        `vh`.`Ruta_codigo` AS `Ruta_codigo`,
        CONCAT_WS(' - ', `d1`.`nombre`, `d2`.`nombre`) AS `tayecto`
    FROM
        (((`destinos` `d1`
        JOIN `destinos` `d2`)
        JOIN `ruta` `r1`)
        JOIN `vista_horario` `vh`)
    WHERE
        ((`d1`.`codigo` = `r1`.`origen`)
            AND (`r1`.`codigo` = `vh`.`Ruta_codigo`)
            AND (`d2`.`codigo` = `r1`.`destino`)
            AND (`r1`.`codigo` = `vh`.`Ruta_codigo`))

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_vuelo_completo` AS
    SELECT 
        `vv`.`id` AS `id`,
        `vv`.`Horario_id` AS `Horario_id`,
        CONCAT_WS(' - ',
                `vh`.`dia_semana`,
                `vh`.`hora_salida`) AS `Ruta`,
        `vv`.`Ruta_codigo` AS `Ruta_codigo`,
        `vh`.`tayecto` AS `trayecto`,
        `vv`.`Avion_id` AS `Avion_id`
    FROM
        (`vista_vuelo` `vv`
        JOIN `vista_horario_commleto` `vh`)
    WHERE
        (`vv`.`Horario_id` = `vh`.`id`)

		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_tiquete_completo` AS
    SELECT 
        `vt`.`id` AS `id`,
        CONCAT_WS(' ', `vc`.`nombre`, `vc`.`apellidos`) AS `Nombre_completo`,
        `vc`.`id` AS `Cliente_id`,
        `vvc`.`id` AS `Vuelo_id`,
        CONCAT_WS(' - ', `vvc`.`Ruta`, `vvc`.`trayecto`) AS `ruta`,
        `vt`.`numero_asiento` AS `numero_asiento`,
        `va`.`id` AS `id_avion`,
        CONCAT_WS(' - ', `va`.`marca`, `va`.`modelo`) AS `Avion`
    FROM
        (((`vista_tiquete` `vt`
        JOIN `vista_cliente` `vc`)
        JOIN `vista_vuelo_completo` `vvc`)
        JOIN `vista_avion` `va`)
    WHERE
        ((`vt`.`Vuelo_id` = `vvc`.`id`)
            AND (`vt`.`Cliente_id` = `vc`.`id`)
            AND (`vvc`.`Avion_id` = `va`.`id`))		
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_reservacion_completa` AS
    SELECT DISTINCT
        `vr`.`id` AS `id`,
        `vc`.`id` AS `id_cliente`,
        CONCAT_WS(' ', `vc`.`nombre`, `vc`.`apellidos`) AS `Nombre_cliente`,
        `vtc1`.`id` AS `id_ida`,
        `vtc1`.`ruta` AS `ruta_ida`,
        `vtc1`.`numero_asiento` AS `asiento_ida`,
        `vtc1`.`id_avion` AS `id_avion_ida`,
        `vtc1`.`Avion` AS `Avion_ida`,
        `vr`.`vuelta` AS `vuelta`,
        IF((`vr`.`vuelta` IS NOT NULL),
            `vtc2`.`id`,
            NULL) AS `id_vuelta`,
        IF((`vr`.`vuelta` IS NOT NULL),
            `vtc2`.`ruta`,
            NULL) AS `ruta_vuelta`,
        IF((`vr`.`vuelta` IS NOT NULL),
            `vtc2`.`numero_asiento`,
            NULL) AS `asiento_vuelta`,
        IF((`vr`.`vuelta` IS NOT NULL),
            `vtc2`.`id_avion`,
            NULL) AS `id_avion_vuelta`,
        IF((`vr`.`vuelta` IS NOT NULL),
            `vtc2`.`Avion`,
            NULL) AS `Avion_vuelta`
    FROM
        (((`vista_tiquete_completo` `vtc1`
        JOIN `vista_tiquete_completo` `vtc2`)
        JOIN `vista_reservacion` `vr`)
        JOIN `vista_cliente` `vc`)
    WHERE
        ((`vr`.`Cliente_id` = `vc`.`id`)
            AND (`vtc1`.`id` = `vr`.`ida`)
            AND ((`vtc2`.`id` = `vr`.`vuelta`)
            OR (`vr`.`vuelta` IS NULL)))

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_reservacion_completa_solo_ida` AS
    SELECT 
        `vr`.`id` AS `id`,
        CONCAT_WS(' ', `vc`.`nombre`, `vc`.`apellidos`) AS `Nombre_cliente`,
        `vtc1`.`id` AS `id_ida`,
        `vtc1`.`ruta` AS `ruta_ida`,
        `vtc1`.`numero_asiento` AS `asiento_ida`,
        `vtc1`.`id_avion` AS `id_avion_ida`,
        `vtc1`.`Avion` AS `Avion_ida`
    FROM
        ((`vista_tiquete_completo` `vtc1`
        JOIN `vista_cliente` `vc`)
        JOIN `vista_reservacion` `vr`)
    WHERE
        ((`vtc1`.`id` = `vr`.`ida`)
            AND (`vr`.`vuelta` IS NULL)
            AND (`vr`.`Cliente_id` = `vc`.`id`))			
		
CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_id_cliente_de_acuerdo_tiquete`(id_tiquete int) RETURNS int
    DETERMINISTIC
BEGIN
declare id_Cliente int;
select Cliente_id into id_Cliente from tiquete where id = id_tiquete;
RETURN id_Cliente;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_minutos_ruta`(id_ruta int) RETURNS time
    DETERMINISTIC
BEGIN
declare dura time;
select duracionMin into dura from ruta where codigo = id_ruta;
RETURN dura ;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_ruta_de_acuerdo_horario`(id_horario int) RETURNS int
    DETERMINISTIC
BEGIN
declare ruta_id int;
select Ruta_codigo into ruta_id from horario where id = id_horario;
RETURN ruta_id;
END		
		
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_avion`(in id_avion int, in anio_nuevo int, in modelo_nuevo varchar(20), in marca_nueva varchar(45),  in can_asientos_nuevo int )
BEGIN
update avion set anio = anio_nuevo, modelo = modelo_nuevo, marca = marca_nueva, can_asientos = can_asientos_nuevo

where id = id_avion;
END

		
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cliente`(in ID_A int,
 in Contrasena_nuevo varchar(45), 
 in Nombre_nuevo varchar(45), 
 in Apellidos_nuevo varchar(45), 
 in Correo_nuevo varchar(45), 
 in Fec_nacimiento_nuevo date,  
 in Direecion_nuevo varchar(45), 
 in Tel_trabajo_nuevo varchar(45), 
 in Tel_cel_nuevo varchar(45)    )
BEGIN
update 
cliente set 
contrasena = Contrasena_nuevo,
nombre = Nombre_nuevo, 
apellidos = Apellidos_nuevo,
correo = Correo_nuevo,
fec_nacimiento = Fec_nacimiento_nuevo,
direccion = Direccion_nuevo,
tel_trabajo = Tel_trabajo_nuevo,
tel_cel = Tel_cel_nuevo
where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_destinos`(in ID_A int, in Nombre_nuevo varchar(45))
BEGIN
update destinos set nombre = Nombre_nuevo where codigo = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_horario`(in ID_A int, in Dia_semana_nuevo varchar(45), in Hora_salida_nuevo time, in Hora_llegada_nuevo time, in ruta_codigo_nuevo int )
BEGIN
update horario set 
dia_semana = Dia_semana_nuevo,
hora_salida = Hora_salida_nuevo,
hora_llegada = Hora_llegada_nuevo, 
Ruta_codigo = ruta_codigo_nuevo
where
id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_reservacion`(in ID_A int,in Ida_nuevo int, in Vuelta_nuevo int)
BEGIN
update reservacion set ida = Ida_nuevo, vuelta = Vuelta_nuevo where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_ruta`(in ID_A int, in Origen_nuevo int, in Destino_nuevo int, in Duracion_nuevo time, in Precio_nuevo float, in Descuento_nuevo float)
BEGIN
update ruta set origen = Origen_nuevo, destino = Destino_nuevo, duracionMin = Duracion_nuevo, precio = Precio_nuevo, descuento = Descuento_nuevo where codigo = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_tiquete`(in Id_A int, in vuelo_id_nuevo int, in cliente_id_nuevo int, in Numero_asiento_nuevo int)
BEGIN
update tiquete set 
Vuelo_id = vuelo_id_nuevo,
Cliente_id = cliente_id_nuevo,
numero_asiento = Numero_asiento_nuevo
where 
id = Id_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_vuelo`(in ID_A int, in horario_nuevo int, in avion_id_nuevo int )
BEGIN
update vuelo set Horario = horario_nuevo, Avion_id_nuevo = avion_id_nuevo where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_avion`(in id_avion int)
BEGIN
delete from avion where id = id_avion; 
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente`(in id_cliente int)
BEGIN
delete from cliente where id = id_cliente;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_detino`(in id_destino int)
BEGIN
delete from destinos where id = id_destino;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_horario`(in id_horario int)
BEGIN
delete from horario where id = id_horario;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_reservacion`(in id_reservacion int)
BEGIN
delete from reservacion where id = id_reservacion;
END
		
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_ruta`(in id_ruta int)
BEGIN
delete from ruta where id = id_ruta;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_tiquete`(in id_tiquete int)
BEGIN
delete from tiquete where id = id_tiquete;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_avion`(in Anio int, in Modelo varchar(20), in Marca varchar(45), in Can_asientos int )
BEGIN
insert into avion(anio, modelo, marca, can_asientos) values (Anio, Modelo, Marca, Can_asientos);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cliente`(
in Contrasena varchar(45), 
in Rol tinyint, 
in Nombre varchar(45), 
in Apellidos varchar(45), 
in Correo varchar(45),
in Fecha_nacimiento date,
in Direccion varchar(45),
in Tel_trabajo varchar(45),
in Tel_cel varchar(45)
 )
BEGIN
insert into cliente(contrasena, rol, nombre, apellidos, correo, fec_naci, direccion, tel_trabajo, tel_cel) values(Contrasena, Rol, Nombre, Apellidos, Correo, Fecha_nacimiento, Direccion, Tel_trabajo, Tel_cel);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_destino`(in Nombre varchar(45))
BEGIN
insert into destinos(nombre) values (Nombre); 
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_horario`(in Dia_semana varchar(45), in Hora_salida time, in  ruta_codigo int)
BEGIN
insert into horario(dia_semana, hora_salida, hora_llegada, Ruta_codigo) values (Dia_semana, Hora_salida, addtime(Hora_salida ,  seleccionar_minutos_ruta(ruta_codigo) ) ,  ruta_codigo);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_reservacion_ida`(in Ida int)
BEGIN
insert into reservacion(ida, Cliente_id)values(
Ida,

seleccionar_id_cliente_de_acuerdo_tiquete(Ida) 
 );
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_reservacion_ida_vuelta`(in Ida int, in Vuelta int)
BEGIN
insert into reservacion(ida, vuelta, Cliente_id)values(
Ida,
 Vuelta, 
 seleccionar_id_cliente_de_acuerdo_tiquete(Ida) );
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ruta`(in Origen int, in Destino int, in DuracionMin time(0), in Precio float, in Descuento float)
BEGIN
insert into ruta(origen, destino, duracionMin, precio, descuento) values(Origen, Destino, DuracionMin, Precio, Descuento);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tiquete`(in vuelo_id int, in cliente_id int, in Numero_asiento int)
BEGIN
insert  into tiquete(Vuelo_id, Cliente_id, numero_asiento) values(vuelo_id, cliente_id, Numero_asiento);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_vuelo`(in id_horario int, in avion_id int)
BEGIN
insert into vuelo(Horario_id, Ruta_codigo, Avion_id) values(id_horario, seleccionar_ruta_de_acuerdo_horario(id_horario) , avion_id);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_avion_x_id`(in id_avion int)
BEGIN
SELECT * FROM keed_moviles.vista_avion where id = id_avion ;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_cliente_x_id`(in ID_A int)
BEGIN
SELECT * FROM keed_moviles.vista_cliente where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_cliente_x_id`(in ID_A int)
BEGIN
SELECT * FROM keed_moviles.vista_cliente where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_horario_x_id`(in ID_A int)
BEGIN
SELECT * FROM keed_moviles.vista_horario_commleto where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_reservacion_x_id`(in ID_A int)
BEGIN
select * from vista_reservacion where id = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_ruta_x_id`(in ID_A int)
BEGIN
select * from vista_ruta where codigo = ID_A;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_tiquete_x_id`(in Id_A int)
BEGIN
SELECT * FROM vista_tiquete where id= Id_A; 
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_vuelo_x_id`(in ID_A int)
BEGIN
select * from vista_vuelo_completo where id = ID_A;
end

--------------------------------------------------FIN-------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		