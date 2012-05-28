-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
--la creacion del usuario principal
insert into direccion (id, barrio, calle, ciudad, codigopostal, numero, pais, telefonocelular, telefonofijo, resident_id) values (1, 'Motupe', 'CHANTACO Y AV. 8 DE DICIEMBRE','LOJA', NULL,NULL, 'ECUADOR', '087567242', '2540302',NULL);
insert into resident 
(residenttype, id, email, fecharegistro, nombre, nombrecomercial, numeroidentificacion, tipoidentificacion, apellidos, birthday, estadocivil, genero, isdiscapacitado, nombres, numerodiscapacidad, codigo, fechaconstitucion, tipoentidadlegal, currentdireccion_id) 
values 
('N',1,'richardmijo@hotmail.com','2012-09-22','RICHARD FRANCISCO ARMIJOS MERINO',null,'1104111271','CEDULA','ARMIJOR MERINO','2012-09-22','SOLTERO','MASCULINO',FALSE,'RICHARD FRANCISCO',null,null,null,null,1);
insert into usuario (id, expirationdate, isactive, name, password, person_id ) values (1,'2012-09-22',TRUE,'mijo','pris1',1);
-- para las acciones
insert into action (id,icon,name,priority,url,parent_id) values (1,'','Administracion',0,'#',null); 
insert into action (id,icon,name,priority,url,parent_id) values (2,'','Acciones',2,'/security/ActionList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (3,'','Roles',1,'/security/RoleList.xhtml',null);
insert into action (id,icon,name,priority,url,parent_id) values (4,'','Usuarios',3,'/security/UserList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (5,'','Inventario',0,'#',null);
insert into action (id,icon,name,priority,url,parent_id) values (6,'','Tipo de Registro',1,'/inventario/TipoRegistroList.xhtml',5);
insert into action (id,icon,name,priority,url,parent_id) values (7,'','Linea',2,'/inventario/LineaList.xhtml',5);
insert into action (id,icon,name,priority,url,parent_id) values (8,'','Contribuyentes/Proveedores',2,'#',null);
insert into action (id,icon,name,priority,url,parent_id) values (9,'','Gestion',0,'/comun/ResidentList.xhtml',8);
insert into action (id,icon,name,priority,url,parent_id) values (10,'','Ganancia',3,'/inventario/GananciaList.xhtml',5);
insert into action (id,icon,name,priority,url,parent_id) values (11,'','Productos',4,'/inventario/ArticuloList.xhtml',5);
insert into action (id,icon,name,priority,url,parent_id) values (12,'','Dia de Trabajo',4,'/venta/DiaTrabajoList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (13,'','Sucursal',5,'/venta/SucursalList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (14,'','Tipo Pago',6,'/venta/TipoPagoList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (15,'','Impuestos',7,'/comun/ImpuestoList.xhtml',1);
insert into action (id,icon,name,priority,url,parent_id) values (16,'','Tipo de Comprobante',8,'/comun/TipoComprobanteList.xhtml',1);

-- para los roles por dejecto
insert into role (id, description, name) values (1, 'Super Administrador', 'Super Administrador');
insert into role_usuario (roles_id, users_id) values (1, 1);

insert into permission (id, expirationdate, permissiontype, action_id, role_id) values (1,'2012-05-23 19:03:00.72',null,1,1);
insert into permission (id, expirationdate, permissiontype, action_id, role_id) values (2,'2012-05-23 19:10:08.093',null,5,1);
insert into permission (id, expirationdate, permissiontype, action_id, role_id) values (3,'2012-05-24 10:20:33.722',null,8,1);