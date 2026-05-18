# Proyecto Semestral: 777

**Integrantes:** Nicolas Ortega, Jairo Cid, Anita Olivares

**Estado del Sistema (Hito Final - 10 Microservicios)**

| Microservicio | Puerto | DB Name | Funcionalidad |
| :--- | :--- | :--- | :--- |
| Módulo de Registro | 8082 | universidad_backend | CRUD de usuarios y autenticación. |
| Módulo de Catálogo | 8081 | universidad_backend | CRUD de Productos (Prendas). |
| Módulo de Carrito | 8084 | universidad_backend | CRUD de ItemCarrito y persistencia de compra. |
| Módulo de Favoritos | 8080 | universidad_backend | CRUD de productos favoritos por usuario. |
| Módulo de Notificaciones | 8085 | universidad_backend | CRUD de alertas y mensajes push al cliente. |
| Módulo de Descuentos | 8086 | universidad_backend | CRUD de cupones y reglas de ofertas. |
| Módulo de Ventas | 8087 | universidad_backend | CRUD de historial de ventas y generación de boletas. |
| Módulo de Pagos | 8088 | universidad_backend | Gestión de transacciones y estados de pago. |
| Módulo de Órdenes | 8089 | universidad_backend | Gestión de pedidos y estados del flujo de compra. |
| Módulo de Envíos | 8090 | universidad_backend | Logística, direcciones y seguimiento de despachos. |

**Despliegue Técnico**

* **Instancia:** AWS EC2 t3.large (Ubuntu 24.04)
* **Orquestación:** Docker Compose (11 contenedores: 10 APIs + 1 MySQL)
* **Comando de inicio:** `docker compose up -d`
* **Base de Datos:** MySQL 8.0 con volumen persistente.