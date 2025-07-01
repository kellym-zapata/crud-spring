CRUD de Clientes - Spring Boot

Este proyecto es una aplicación web desarrollada en Java utilizando Spring Boot. 
Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre clientes almacenados en una base de datos MySQL.

Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.3
- Spring Data JPA
- Maven
- MySQL
- Postman (para pruebas)
- Lombok
- IntelliJ IDEA

Estructura del proyecto

crud_cliente/
├── src/
│ ├── main/
│ │ ├── java/com/crud_cliente/crud/
│ │ │ ├── controller/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ └── service/
│ └── resources/
│ ├── application.properties
├── pom.xml

Configuración del proyecto

1. Base de datos

   Crea una base de datos MySQL:

   ```sql
   CREATE DATABASE crud_cliente;
   
2. Configura el archivo application.properties:
spring.application.name=crud
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/crud_cliente
spring.datasource.username=root
spring.datasource.password=123
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

3. Compilación y ejecución:
Desde terminal:
mvn clean install
mvn spring-boot:run
Desde IntelliJ IDEA: Ejecuta CrudApplication.java

4.API REST - Endpoints
Método	Endpoint	Descripción
GET	/api/v1/clientes	Listar todos los clientes
GET	/api/v1/clientes/{id}	Obtener cliente por ID
PUT	/api/v1/clientes/{id}	Crear o actualizar cliente
DELETE	/api/v1/clientes/{id}	Eliminar cliente por ID

Pruebas con Postman:

A. Crear o actualizar cliente
Método: PUT
URL: http://localhost:8080/api/v1/clientes/123

Body (JSON):
{
  "tipoDoc": "CC",
  "doc": "123",
  "nombres": "Juan",
  "apellidos": "Pérez",
  "genero": "Masculino",
  "fecNacimiento": "2000-01-01",
  "email": "juan@mail.com",
  "password": "123456",
  "telefono": "3001234567",
  "ciudad": "Bogotá",
  "barrio": "Chapinero",
  "direccion": "Calle 123"
}

B. Consultar todos los clientes
Método: GET 
URL: http://localhost:8080/api/v1/clientes

C. Consultar cliente por ID
Método: GET 
URL: http://localhost:8080/api/v1/clientes/123

D. Eliminar cliente
Método: DELETE 
URL: http://localhost:8080/api/v1/clientes/123


Nombre: Kelly Zapata
SENA - Análisis y Desarrollo de Software

Repositorio
https://github.com/kellym-zapata/crud-spring
