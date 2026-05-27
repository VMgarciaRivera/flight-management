# Flight Management System

> Aplicación web de gestión de vuelos desarrollada con **Java** y **Spring Boot** siguiendo una arquitectura **MVC** (Model-View-Controller).

## 📋 Descripción del Proyecto

Este proyecto es una aplicación web educativa que replica y expande el modelo de sistemas de vuelo desarrollado en la Unidad 1 (PHP). La aplicación implementa un **CRUD completo** para la gestión de vuelos siguiendo principios de **arquitectura limpia**.

## 🎯 Objetivos de la Actividad

### 1. Aprender Desarrollo Web con Spring Boot
- Estudiar y aplicar las guías sobre desarrollo básico de aplicaciones web con Spring Boot
- Comprender la arquitectura **MVC** (Model-View-Controller)
- Estructurar correctamente las capas de la aplicación

### 2. Replicar el Modelo Base
- Replicar la estructura y modelo de las guías del profesor
- Implementar la tabla de **usuarios** con todas sus operaciones CRUD
- Aplicar estilos CSS a formularios y vistas HTML para mejorar la experiencia del usuario

### 3. Desarrollar CRUD de Vuelos
- Basarse en el mismo modelo de las guías para crear un CRUD de vuelos
- Implementar las mismas capas de la aplicación:
  - **Model**: Entidad Vuelo
  - **Repository**: Acceso a datos
  - **Service**: Lógica de negocio
  - **Controller**: Gestión de peticiones HTTP
  - **View**: Templates HTML con estilos

### 4. Flujo de Trabajo Git/GitHub
- Utilizar ramas para organizar el desarrollo
- Realizar commits **progresivos y modulares** que reflejen cambios específicos
- Hacer push pequeños (máximo 10 archivos) para mantener el historial limpio

### 5. Video de Sustentación
- Crear un video que explique el desarrollo y funcionamiento de la aplicación
- Demostrar el CRUD de usuarios (basado en las guías)
- Demostrar el CRUD de vuelos (tabla asignada)

## 🏗️ Estructura del Proyecto

```
flight-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/flight/
│   │   │       ├── model/           # Entidades (Usuario, Vuelo)
│   │   │       ├── repository/      # Interfaces de acceso a datos
│   │   │       ├── service/         # Lógica de negocio
│   │   │       ├── controller/      # Controladores MVC
│   │   │       └── Application.java # Clase principal
│   │   └── resources/
│   │       ├── templates/           # Vistas HTML (Thymeleaf)
│   │       ├── static/css/          # Estilos CSS
│   │       └── application.properties # Configuración
│   └── test/
├── pom.xml                          # Dependencias Maven
└── README.md                        # Este archivo
```

## 🔧 Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación
- **Spring Boot**: Framework web
- **Spring Data JPA**: Acceso a datos
- **postgreSQL**: Base de datos
- **Thymeleaf**: Motor de plantillas HTML
- **Maven**: Gestor de dependencias

## 📦 Dependencias Principales

Las dependencias necesarias se han instalado en el archivo `pom.xml`:

- `spring-boot-starter-web`: Desarrollo web
- `spring-boot-starter-data-jpa`: Acceso a datos
- `spring-boot-starter-thymeleaf`: Motor de plantillas
- `org.postgresql`: Driver PostgreSQL
- `spring-boot-devtools`: Herramientas de desarrollo

## ⚙️ Configuración del Proyecto

### 1. Archivo `application.properties`

```properties
spring.application.name=flight-management

# ACTUALIZAR AUTOMATICAMENTE CUANDO GUARDEMOS LOS CAMBIOS
spring.thymeleaf.cache=false

# CAMBIAR EL PUERTO DEL SERVIDOR
server.port=8080

# QUITAR EL BANNER Y LOGO DE SPRING DEL LOG
spring.main.banner-mode=off

# PARAMETROS DE CONEXION A LA BD (POSTGRESQL)
spring.datasource.url=jdbc:postgresql://localhost:5432/flight_management
spring.datasource.username=postgres
spring.datasource.password=12345

# CONFIGURACION DE HIBERNATE / ORM
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# ESTO ES PARA PODER VER EN EL LOG EL SQL QUE SE HA GENERADO EN CADA OPERACION
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### 2. Instalación de Dependencias

```bash
# Compilar el proyecto y descargar dependencias
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

## 📊 Modelos Implementados

### Modelo Usuario

| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | Integer | Identificador único |
| nombre | String | Nombre del usuario |
| email | String | Correo electrónico |
| contraseña | String | Contraseña encriptada |
| telefono | String | Número de teléfono |
| fecha_registro | LocalDateTime | Fecha de registro |

**CRUD Usuario**: Completamente implementado según las guías del profesor.

### Modelo Vuelo

| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | Integer | Identificador único |
| codigo_vuelo | String | Código del vuelo |
| origen | String | Ciudad de origen |
| destino | String | Ciudad de destino |
| fecha_salida | LocalDateTime | Fecha y hora de salida |
| fecha_llegada | LocalDateTime | Fecha y hora de llegada |
| capacidad | Integer | Número de pasajeros |
| precio | Double | Precio del vuelo |
| estado | String | Estado del vuelo |

**CRUD Vuelo**: Implementado siguiendo el mismo patrón del CRUD de usuarios.

## Funcionalidades Principales

### CRUD Usuario
- **Crear**: Agregar nuevos usuarios con validación
- **Leer**: Listar todos los usuarios
- **Actualizar**: Modificar datos del usuario
- **Eliminar**: Remover usuarios de la base de datos

### CRUD Vuelo
- **Crear**: Agregar nuevos vuelos
- **Leer**: Listar todos los vuelos con opciones de filtrado
- **Actualizar**: Modificar información del vuelo
- **Eliminar**: Remover vuelos

## Arquitectura Limpia: Contratos, Interfaces y Separación de Responsabilidades

Este proyecto implementa principios fundamentales de **arquitectura limpia** para garantizar código mantenible, testeable y escalable.

### Contratos mediante Interfaces

El proyecto utiliza **interfaces** como contratos que definen las responsabilidades de cada capa:

#### 1. **Repository Interfaces**
```java
// Contrato para acceso a datos
@Repository
public interface IUsuarioCrud extends CrudRepository<Usuario, String> {

}

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, UUID> {

}

```
- Define operaciones de acceso a datos sin exponer implementación
- Facilita cambios en la fuente de datos (MySQL → MongoDB, etc.)
- Permite testing sin acceso real a BD

#### 2. **Service Interfaces**
```java
// Contrato para lógica de negocio
public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();
    public void guardar (Usuario usuario);
    public void eliminar (Usuario usuario);
    public Usuario encontrarUsuario(Usuario usuario);
}

public interface VueloService {
    Optional<Vuelo> findById(UUID id);
    List<Vuelo> findAll();
    Vuelo save(Vuelo vuelo);
    void deleteById(UUID id);
}

```
- Separa contrato de implementación
- Permite múltiples implementaciones si es necesario
- Facilita inyección de dependencias

### Separación de Responsabilidades

Cada capa tiene una responsabilidad clara y específica:

| Capa | Responsabilidad | Ejemplo |
|------|-----------------|---------|
| **Model** | Representar entidades del dominio | `Usuario`, `Vuelo` (atributos + anotaciones JPA) |
| **Repository** | Acceso a datos y persistencia | Consultas a BD, CRUD de bajo nivel |
| **Service** | Lógica de negocio y validaciones | Validar datos, aplicar reglas, orquestar operaciones |
| **Controller** | Gestionar peticiones HTTP y respuestas | Recibir requests, delegar a service, retornar responses |
| **View** | Presentación de datos al usuario | Templates HTML renderizados con Thymeleaf |

### Flujo de Datos en Arquitectura Limpia

```
Cliente HTTP
    ↓
Controller (recibe y valida entrada)
    ↓
Service Interface (contrato de lógica)
    ↓
Service Implementation (ejecuta lógica de negocio)
    ↓
Repository Interface (contrato de datos)
    ↓
Repository Implementation (persiste en BD)
    ↓
Database 
```

###  Beneficios de esta Arquitectura

1. **Independencia de Frameworks**: La lógica de negocio no depende de Spring
2. **Testabilidad**: Cada capa se prueba independientemente con mocks
3. **Mantenibilidad**: Cambios en una capa no afectan otras
4. **Escalabilidad**: Fácil agregar nuevas funcionalidades
5. **Reutilización**: Services pueden ser usados por múltiples controllers
6. **Flexibilidad**: Cambiar BD, agregar caché, etc. sin tocar lógica de negocio

### Ejemplo Práctico: Creación de Vuelo

```java
// Controller - Punto de entrada
@PostMapping("/create")
public String crearVuelo(@ModelAttribute Vuelo vuelo) {
    vueloService.crearVuelo(vuelo);  // Delega a service
    return "redirect:/vuelos";
}

// Service - Lógica de negocio
@Service
public class VueloServiceImpl implements VueloService {
    @Override
    public Vuelo crearVuelo(Vuelo vuelo) {
        validarVuelo(vuelo);  // Valida
        calcularPrecio(vuelo); // Lógica
        return vueloRepository.save(vuelo);  // Persiste
    }
}

// Repository - Acceso a datos
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    // Spring Data JPA implementa automáticamente
}
```

## Referencias

- Guías de Spring Boot proporcionadas por el profesor
- Documentación oficial de [Spring Boot](https://spring.io/projects/spring-boot)
- Documentación de [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/) - Motor de plantillas

## Autor

**VMgarciaRivera**
---

### Notas Importantes

-  El CRUD de usuarios se implementó exactamente como se especificó en las guías del profesor
-  La configuración del proyecto (`application.properties`) y las dependencias (`pom.xml`) siguen las instrucciones de las guías
-  El CRUD de vuelos se desarrolló replicando la misma estructura y modelo del CRUD de usuarios
-  Se han realizado commits pequeños y modulares en ramas separadas
-  Todos los archivos relacionados con usuarios provienen de las guías del profesor
-  Se implementó arquitectura limpia con interfaces de contratos para Repository y Service
-  Se separaron claramente las responsabilidades en cada capa (Model, Repository, Service, Controller, View)
-  El código sigue principios SOLID para mayor mantenibilidad y testabilidad
