USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_avion` AS select `keed_moviles`.`avion`.`id` AS `id`,`keed_moviles`.`avion`.`anio` AS `anio`,`keed_moviles`.`avion`.`modelo` AS `modelo`,`keed_moviles`.`avion`.`marca` AS `marca`,`keed_moviles`.`avion`.`can_asientos` AS `can_asientos` from `keed_moviles`.`avion`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_cliente` AS select `keed_moviles`.`cliente`.`id` AS `id`,`keed_moviles`.`cliente`.`contrasena` AS `contrasena`,`keed_moviles`.`cliente`.`rol` AS `rol`,`keed_moviles`.`cliente`.`nombre` AS `nombre`,`keed_moviles`.`cliente`.`apellidos` AS `apellidos`,`keed_moviles`.`cliente`.`correo` AS `correo`,`keed_moviles`.`cliente`.`fec_naci` AS `fec_naci`,`keed_moviles`.`cliente`.`direccion` AS `direccion`,`keed_moviles`.`cliente`.`tel_trabajo` AS `tel_trabajo`,`keed_moviles`.`cliente`.`tel_cel` AS `tel_cel` from `keed_moviles`.`cliente`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_destinos` AS select `keed_moviles`.`destinos`.`codigo` AS `codigo`,`keed_moviles`.`destinos`.`nombre` AS `nombre` from `keed_moviles`.`destinos`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_horario` AS select `keed_moviles`.`horario`.`id` AS `id`,`keed_moviles`.`horario`.`dia_semana` AS `dia_semana`,`keed_moviles`.`horario`.`hora_salida` AS `hora_salida`,`keed_moviles`.`horario`.`hora_llegada` AS `hora_llegada`,`keed_moviles`.`horario`.`Ruta_codigo` AS `Ruta_codigo` from `keed_moviles`.`horario`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_horario_commleto` AS select `vh`.`id` AS `id`,`vh`.`dia_semana` AS `dia_semana`,`vh`.`hora_salida` AS `hora_salida`,`vh`.`hora_llegada` AS `hora_llegada`,`vh`.`Ruta_codigo` AS `Ruta_codigo`,concat_ws(' - ',`d1`.`nombre`,`d2`.`nombre`) AS `tayecto` from (((`keed_moviles`.`destinos` `d1` join `keed_moviles`.`destinos` `d2`) join `keed_moviles`.`ruta` `r1`) join `keed_moviles`.`vista_horario` `vh`) where ((`d1`.`codigo` = `r1`.`origen`) and (`r1`.`codigo` = `vh`.`Ruta_codigo`) and (`d2`.`codigo` = `r1`.`destino`) and (`r1`.`codigo` = `vh`.`Ruta_codigo`))
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_reservacion` AS select `keed_moviles`.`reservacion`.`id` AS `id`,`keed_moviles`.`reservacion`.`ida` AS `ida`,`keed_moviles`.`reservacion`.`vuelta` AS `vuelta`,`keed_moviles`.`reservacion`.`Cliente_id` AS `Cliente_id` from `keed_moviles`.`reservacion`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_reservacion_completa` AS select distinct `vr`.`id` AS `id`,concat_ws(' ',`vc`.`nombre`,`vc`.`apellidos`) AS `Nombre_cliente`,`vtc1`.`id` AS `id_ida`,`vtc1`.`ruta` AS `ruta_ida`,`vtc1`.`numero_asiento` AS `asiento_ida`,`vtc1`.`id_avion` AS `id_avion_ida`,`vtc1`.`Avion` AS `Avion_ida`,`vr`.`vuelta` AS `vuelta`,if((`vr`.`vuelta` is not null),`vtc2`.`id`,NULL) AS `id_vuelta`,if((`vr`.`vuelta` is not null),`vtc2`.`ruta`,NULL) AS `ruta_vuelta`,if((`vr`.`vuelta` is not null),`vtc2`.`numero_asiento`,NULL) AS `asiento_vuelta`,if((`vr`.`vuelta` is not null),`vtc2`.`id_avion`,NULL) AS `id_avion_vuelta`,if((`vr`.`vuelta` is not null),`vtc2`.`Avion`,NULL) AS `Avion_vuelta` from (((`keed_moviles`.`vista_tiquete_completo` `vtc1` join `keed_moviles`.`vista_tiquete_completo` `vtc2`) join `keed_moviles`.`vista_reservacion` `vr`) join `keed_moviles`.`vista_cliente` `vc`) where ((`vr`.`Cliente_id` = `vc`.`id`) and (`vtc1`.`id` = `vr`.`ida`) and ((`vtc2`.`id` = `vr`.`vuelta`) or (`vr`.`vuelta` is null)))
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_reservacion_completa_solo_ida` AS select `vr`.`id` AS `id`,concat_ws(' ',`vc`.`nombre`,`vc`.`apellidos`) AS `Nombre_cliente`,`vtc1`.`id` AS `id_ida`,`vtc1`.`ruta` AS `ruta_ida`,`vtc1`.`numero_asiento` AS `asiento_ida`,`vtc1`.`id_avion` AS `id_avion_ida`,`vtc1`.`Avion` AS `Avion_ida` from ((`keed_moviles`.`vista_tiquete_completo` `vtc1` join `keed_moviles`.`vista_cliente` `vc`) join `keed_moviles`.`vista_reservacion` `vr`) where ((`vtc1`.`id` = `vr`.`ida`) and (`vr`.`vuelta` is null) and (`vr`.`Cliente_id` = `vc`.`id`))
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_ruta` AS select `keed_moviles`.`ruta`.`codigo` AS `codigo`,`keed_moviles`.`ruta`.`origen` AS `origen`,`keed_moviles`.`ruta`.`destino` AS `destino`,`keed_moviles`.`ruta`.`duracionMin` AS `duracionMin`,`keed_moviles`.`ruta`.`precio` AS `precio`,`keed_moviles`.`ruta`.`descuento` AS `descuento` from `keed_moviles`.`ruta`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_ruta_completa` AS select `vr`.`codigo` AS `codigo`,`d1`.`nombre` AS `origen`,`d2`.`nombre` AS `destino`,`vr`.`duracionMin` AS `duracionMIn`,`vr`.`precio` AS `precio`,`vr`.`descuento` AS `descuento` from ((`keed_moviles`.`destinos` `d1` join `keed_moviles`.`destinos` `d2`) join `keed_moviles`.`vista_ruta` `vr`) where ((`d1`.`codigo` = `vr`.`origen`) and (`d2`.`codigo` = `vr`.`destino`))
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_tiquete` AS select `keed_moviles`.`tiquete`.`id` AS `id`,`keed_moviles`.`tiquete`.`Vuelo_id` AS `Vuelo_id`,`keed_moviles`.`tiquete`.`Cliente_id` AS `Cliente_id`,`keed_moviles`.`tiquete`.`numero_asiento` AS `numero_asiento` from `keed_moviles`.`tiquete`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_tiquete_completo` AS select `vt`.`id` AS `id`,concat_ws(' ',`vc`.`nombre`,`vc`.`apellidos`) AS `Nombre_completo`,`vc`.`id` AS `Cliente_id`,concat_ws(' - ',`vvc`.`Ruta`,`vvc`.`trayecto`) AS `ruta`,`vt`.`numero_asiento` AS `numero_asiento`,`va`.`id` AS `id_avion`,concat_ws(' - ',`va`.`marca`,`va`.`modelo`) AS `Avion` from (((`keed_moviles`.`vista_tiquete` `vt` join `keed_moviles`.`vista_cliente` `vc`) join `keed_moviles`.`vista_vuelo_completo` `vvc`) join `keed_moviles`.`vista_avion` `va`) where ((`vt`.`Vuelo_id` = `vvc`.`id`) and (`vt`.`Cliente_id` = `vc`.`id`) and (`vvc`.`Avion_id` = `va`.`id`))
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_vuelo` AS select `keed_moviles`.`vuelo`.`id` AS `id`,`keed_moviles`.`vuelo`.`Horario_id` AS `Horario_id`,`keed_moviles`.`vuelo`.`Ruta_codigo` AS `Ruta_codigo`,`keed_moviles`.`vuelo`.`Avion_id` AS `Avion_id` from `keed_moviles`.`vuelo`
USE `keed_moviles`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `keed_moviles`.`vista_vuelo_completo` AS select `vv`.`id` AS `id`,`vv`.`Horario_id` AS `Horario_id`,concat_ws(' - ',`vh`.`dia_semana`,`vh`.`hora_salida`) AS `Ruta`,`vv`.`Ruta_codigo` AS `Ruta_codigo`,`vh`.`tayecto` AS `trayecto`,`vv`.`Avion_id` AS `Avion_id` from (`keed_moviles`.`vista_vuelo` `vv` join `keed_moviles`.`vista_horario_commleto` `vh`) where (`vv`.`Horario_id` = `vh`.`id`)

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_avion_anio`(in id_avion int, in anio_nuevo int)
BEGIN
update avion set anio = anio_nuevo
where id = id_avion;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_avion_can_asientos`(in id_avion int, in can_asientos_nuevo int)
BEGIN
update avion set can_asientos = can_asientos_nuevo where id = id_avion;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_avion_marca`(in id_avion int, in marca_nueva int)
BEGIN
update avion set marca = marca_nueva where id = id_avion;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_avion_modelo`(in id_avion int, in modelo_nuevo int)
BEGIN
update avion set modelo = modelo_nuevo where id = id_avion;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_avion`(in id_avion int)
BEGIN
delete from avion where id = id_avion; 
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente`(in id_cliente int)
BEGIN
delete from cliente where id = id_cliente;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_detino`(in id_destino int)
BEGIN
delete from destinos where id = id_destino;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_horario`(in id_horario int)
BEGIN
delete from horario where id = id_horario;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_reservacion`(in id_reservacion int)
BEGIN
delete from reservacion where id = id_reservacion;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_ruta`(in id_ruta int)
BEGIN
delete from ruta where id = id_ruta;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_tiquete`(in id_tiquete int)
BEGIN
delete from tiquete where id = id_tiquete;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_avion`(in Anio int, in Modelo varchar(20), in Marca varchar(45), in Can_asientos int )
BEGIN
insert into avion(anio, modelo, marca, can_asientos) values (Anio, Modelo, Marca, Can_asientos);
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
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
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_destino`(in Nombre varchar(45))
BEGIN
insert into destinos(nombre) values (Nombre); 
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_horario`(in Dia_semana varchar(45), in Hora_salida time, in  ruta_codigo int)
BEGIN
insert into horario(dia_semana, hora_salida, hora_llegada, Ruta_codigo) values (Dia_semana, Hora_salida, addtime(Hora_salida ,  seleccionar_minutos_ruta(ruta_codigo) ) ,  ruta_codigo);
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_reservacion_ida`(in Ida int)
BEGIN
insert into reservacion(ida, Cliente_id)values(
Ida,

seleccionar_id_cliente_de_acuerdo_tiquete(Ida) 
 );
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_reservacion_ida_vuelta`(in Ida int, in Vuelta int)
BEGIN
insert into reservacion(ida, vuelta, Cliente_id)values(
Ida,
 Vuelta, 
 seleccionar_id_cliente_de_acuerdo_tiquete(Ida) );
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ruta`(in Origen int, in Destino int, in DuracionMin time(0), in Precio float, in Descuento float)
BEGIN
insert into ruta(origen, destino, duracionMin, precio, descuento) values(Origen, Destino, DuracionMin, Precio, Descuento);
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tiquete`(in vuelo_id int, in cliente_id int, in Numero_asiento int)
BEGIN
insert  into tiquete(Vuelo_id, Cliente_id, numero_asiento) values(vuelo_id, cliente_id, Numero_asiento);
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_vuelo`(in id_horario int, in avion_id int)
BEGIN
insert into vuelo(Horario_id, Ruta_codigo, Avion_id) values(id_horario, seleccionar_ruta_de_acuerdo_horario(id_horario) , avion_id);
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostar_tiquete_x_id`(in Id int)
BEGIN
SELECT * FROM vista_tiquete_completo where Cliente_id= Id; 
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_id_cliente_de_acuerdo_tiquete`(id_tiquete int) RETURNS int
    DETERMINISTIC
BEGIN
declare id_Cliente int;
select Cliente_id into id_Cliente from tiquete where id = id_tiquete;
RETURN id_Cliente;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_minutos_ruta`(id_ruta int) RETURNS time
    DETERMINISTIC
BEGIN
declare dura time;
select duracionMin into dura from ruta where codigo = id_ruta;
RETURN dura ;
END$$

DELIMITER ;

DELIMITER $$
USE `keed_moviles`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `seleccionar_ruta_de_acuerdo_horario`(id_horario int) RETURNS int
    DETERMINISTIC
BEGIN
declare ruta_id int;
select Ruta_codigo into ruta_id from horario where id = id_horario;
RETURN ruta_id;
END$$

DELIMITER ;

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













