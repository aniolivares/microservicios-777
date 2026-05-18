CREATE DATABASE IF NOT EXISTS db_favoritos;
CREATE DATABASE IF NOT EXISTS db_catalogo;
CREATE DATABASE IF NOT EXISTS db_registro;
CREATE DATABASE IF NOT EXISTS db_carrito;
CREATE DATABASE IF NOT EXISTS db_notificaciones;
CREATE DATABASE IF NOT EXISTS db_descuentos;
CREATE DATABASE IF NOT EXISTS db_ventas;
CREATE DATABASE IF NOT EXISTS db_pagos;
CREATE DATABASE IF NOT EXISTS db_ordenes;
CREATE DATABASE IF NOT EXISTS db_envios;


GRANT ALL PRIVILEGES ON db_favoritos.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_catalogo.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_registro.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_carrito.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_notificaciones.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_descuentos.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_ventas.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_pagos.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_ordenes.* TO 'desarrollador'@'%';
GRANT ALL PRIVILEGES ON db_envios.* TO 'desarrollador'@'%';

FLUSH PRIVILEGES;