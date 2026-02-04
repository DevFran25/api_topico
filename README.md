# 🧠 API Tópico

API REST para un sistema de foro desarrollada con **Spring Boot**, que permite gestionar usuarios, autenticación segura con JWT, creación de tópicos, respuestas y control de acceso.

Este proyecto implementa un sistema de seguridad profesional con **Access Token + Refresh Token**, siguiendo buenas prácticas de arquitectura backend.

---

## 🚀 Tecnologías

* Java 17+
* Spring Boot
* Spring Security
* Spring Data JPA (Hibernate)
* JWT (JSON Web Token)
* MySQL
* Maven

---

## 🧱 Arquitectura del proyecto

```
api_topico/
├── controller/   # Controladores REST
├── domain/       # Entidades y lógica de dominio
├── dto/          # Objetos de transferencia de datos
├── infra/        # Seguridad, filtros, servicios JWT
├── bd/           # Scripts de base de datos
```

---

## 🔐 Seguridad

Sistema de autenticación basado en JWT con doble token:

### 🔑 Access Token

* Duración corta (15 min)
* Usado para acceder a endpoints protegidos

### Flujo:

```
Login
 ├─ accessToken
 └─ refreshToken

Access expira → /auth/refresh → nuevo accessToken
```

---

## 📌 Endpoints principales

### 🔐 Autenticación

**Login**

```
POST /auth/login
```

**Refresh Token**

```
POST /auth/refresh
```

---

## 📂 Base de datos

Script disponible en:

```
/src/main/java/com/topico/api/bd
```

Incluye:

* Usuarios
* Roles
* Refresh tokens
* Relaciones

---

## ⚙️ Configuración

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api_topico
spring.datasource.username=root
spring.datasource.password=1234

api.security.token.secret=clave_secreta_super_segura
```

---

## ▶️ Ejecución

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🧪 Pruebas

Se recomienda usar:

* Insomnia
* Postman

---

## 📈 Estado del proyecto

✔ Autenticación JWT
✔ Refresh Token
✔ Seguridad con filtros
✔ Arquitectura limpia
✔ CRUD base
✔ Persistencia JPA
✔ MySQL

---

## 🧠 Buenas prácticas implementadas

* Separación por capas
* DTOs
* Seguridad desacoplada
* Tokens revocables
* Expiración controlada
* Arquitectura escalable

---

## 📄 Licencia

Proyecto académico / educativo.
Uso libre para aprendizaje.

---

## ✍️ Autor

Desarrollado por **DevFran25** 🚀

> Proyecto backend con arquitectura profesional orientado a producción.
