
Microservicio Spring Boot para la gestión de órdenes de clientes con seguimiento de productos y totalización automática.

## 📋 Tabla de Contenidos
- [Tecnologías](#-tecnologías-utilizadas)
- [Estructura](#-estructura-del-proyecto)
- [Endpoints](#-endpoints)
- [Ejemplos](#-ejemplos-de-uso)

## 🚀 Tecnologías Utilizadas

- **Core**: 
  - Java 17
  - Spring Boot 3.5.4
  - Maven

- **Persistencia**:
  - Spring Data JPA
  - H2 Database (DEV)

- **Utilidades**:
  - Lombok
  - MapStruct
  - Validación Spring

## 📦 Estructura del Proyecto

customer-microservices/
├── src/
│ ├── main/java/com/experis/test/
│ │ ├── controller/ # Capa de endpoints
│ │ ├── service/ # Lógica de negocio
│ │ ├── repository/ # Acceso a datos
│ │ ├── entity/ # Entidades JPA
│ │ ├── dto/ # Objetos de transferencia
│ │ └── config/ # Configuraciones
│ └── test/ # Pruebas unitarias
└── pom.xml # Configuración Maven


## 📌 Endpoints Principales

### 🔹 Crear Orden
`POST /api/orders`

Crea una nueva orden con validación automática de datos.

#### Parámetros de Entrada:
```json
{
  "clientName": "string (requerido)",
  "clientEmail": "string (formato email)",
  "products": [
    {
      "name": "string (requerido)",
      "quantity": "number > 0",
      "unitPrice": "number positivo"
    }
  ]
}

✅ Éxito (200):
{
  "total": 66.0,
  "createdAt": "2025-07-25T12:42:38.4518832"
}

❌ Error (400):
{
  "timestamp": "2025-07-25T12:54:24.8056659",
  "status": 400,
  "error": "Bad Request",
  "message": "Cantidad debe ser mayor a 0",
  "path": "/api/orders"
}

## 🏃 Ejecución del Proyecto

### Requisitos Previos
- Java 17 JDK instalado
- Maven 3.6+ instalado
- (Opcional) IDE como IntelliJ IDEA o VS Code

### 1. Ejecución Local (desarrollo)
```bash
# Clonar repositorio
git clone [url-del-repositorio]
cd customer-microservices

# Compilar y ejecutar
mvn spring-boot:run

El servicio estará disponible en:
🌐 http://localhost:8081/api/orders
