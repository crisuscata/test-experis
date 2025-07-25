# 🛒 Microservicio de Órdenes de Clientes

Microservicio Spring Boot para gestión completa de órdenes con validación automática y cálculo de totales.

## 📋 Tabla de Contenidos
- [Tecnologías](#-tecnologías-utilizadas)
- [Estructura](#-estructura-del-proyecto)
- [API](#-endpoints-de-la-api)
- [Ejemplos](#-ejemplos-prácticos)
- [Ejecución](#-ejecución-del-proyecto)
- [Configuración](#-configuración-avanzada)

## 🚀 Tecnologías Utilizadas

| Categoría       | Tecnologías                              |
|-----------------|------------------------------------------|
| **Core**        | Java 17, Spring Boot 3.5.4, Maven       |
| **Persistencia**| Spring Data JPA, H2 (DEV), MySQL (PROD) |
| **Utilidades**  | Lombok, MapStruct, Validación Spring     |
| **Pruebas**     | JUnit 5, Mockito        |

## 📦 Estructura del Proyecto

```bash
src/
├── main/
│   ├── java/com/experis/order/
│   │   ├── config/       # Configuraciones Spring
│   │   ├── controller/   # REST endpoints
│   │   ├── service/      # Lógica de negocio
│   │   ├── repository/   # Acceso a datos
│   │   ├── model/        # Entidades y DTOs
│   │   └── exception/    # Manejo de errores
│   └── resources/        # Properties y templates
└── test/                # Pruebas unitarias e integración


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
