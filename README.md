# 📦 Gestión de Pedidos API

API REST desarrollada con Spring Boot para la gestión de clientes, categorías, productos y pedidos.

---

# 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring AOP
- MySQL
- Maven
- Postman

---

# 🗄️ Base de Datos

Nombre de la base de datos:

```sql
evaluacion_springboot_relaciones
```

---

# ⚙️ Configuración del proyecto

## Clonar repositorio

```bash
git clone https://github.com/anngiepp/EV02.git
```

## Entrar al proyecto

```bash
cd gestion-pedidos
```

## Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/evaluacion_springboot_relaciones
spring.datasource.username=root
spring.datasource.password=
```

## Ejecutar proyecto

```bash
mvn spring-boot:run
```

---

# 🔐 Seguridad implementada

## Usuarios

| Usuario | Contraseña | Rol |
|---|---|---|
| admin | admin123 | ADMIN |
| user | user123 | USER |

## Permisos

- GET → ADMIN y USER
- POST → ADMIN
- PUT → ADMIN
- DELETE → ADMIN

---

# 📌 Endpoints principales

## Clientes

| Método | Endpoint |
|---|---|
| GET | /clientes |
| POST | /clientes |
| PUT | /clientes/{id} |
| DELETE | /clientes/{id} |

---

## Productos

| Método | Endpoint |
|---|---|
| GET | /productos |
| POST | /productos |
| PUT | /productos/{id} |
| DELETE | /productos/{id} |

---

## Pedidos

| Método | Endpoint |
|---|---|
| GET | /pedidos |
| POST | /pedidos |

---

# 🧪 Evidencias

## Tablas relacionadas

![Tablas](img/tablas.png)

---

## CRUD de clientes

![Cliente POST](img/crear-cliente-post.png)

![Cliente GET](img/get-cliente.png)

![Cliente PUT](img/put-cliente.png)

![Cliente DELETE](img/delete-cliente.png)

---

## CRUD de productos

![Producto POST](img/crear-producto-post.png)

![Producto GET](img/get-productos.png)

![Producto PUT](img/put-productos.png)

![Producto DELETE](img/delete-productos.png)

---

## Registro de pedidos

![Pedido](img/registrar-pedido-post.png)

---

## Disminución automática de stock

![Stock](img/verificar-stock-get.png)

---

## Validaciones funcionando

![Validaciones](img/probar-validaciones-post.png)

---

## Seguridad implementada

![Seguridad GET](img/probar-seguridad-user%20get.png)

![Seguridad POST](img/probar-seguridad-user%20post.png)

---

## Registro de auditoría

![Auditoria](img/auditoria.png)

---

# 👩‍💻 Autor

Angie Maribel Portocarrero Parra