# Customer Microservices

Microservicio de ejemplo para gestionar órdenes de clientes, construido con **Spring Boot** y **Java 17**.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.4
- Spring Data JPA
- Maven
- H2 Database (en entorno dev)
- Lombok
- MapStruct

## 📦 Estructura del Proyecto

customer-microservices/
├── src/main/java
│ └── com.experis.test
│ ├── controller
│ ├── service
│ ├── dto
│ ├── entity
│ └── repository
└── src/test/java

##  Endpoints principales
POST /api/orders
Crea una nueva orden.

🔸 Request:

{
  "clientName": "Juan",
  "clientEmail": "juan@mail.com",
  "products": [
    {"name": "Teclado", "quantity": 2, "unitPrice": 25.5},
    {"name": "Mouse", "quantity": 1, "unitPrice": 15.0}
  ]
}

🔸 Respuesta exitosa

{
    "total": 66.0,
    "createdAt": "2025-07-25T12:42:38.4518832"
}

 Respuesta de error (400 Bad Request):

 {
    "timestamp": "2025-07-25T12:54:24.8056659",
    "status": 400,
    "error": "Bad Request",
    "message": "Cantidad debe ser mayor a 0",
    "path": "/api/orders"
}
