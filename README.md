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
- **MySQL/H2**: Base de datos
- **Thymeleaf**: Motor de plantillas HTML
- **Bootstrap/CSS**: Estilos y diseño responsivo
- **Maven**: Gestor de dependencias

## 📦 Dependencias Principales

Las dependencias necesarias se han instalado en el archivo `pom.xml`:

- `spring-boot-starter-web`: Desarrollo web
- `spring-boot-starter-data-jpa`: Acceso a datos
- `spring-boot-starter-thymeleaf`: Motor de plantillas
- `mysql-connector-java`: Driver MySQL
- `spring-boot-devtools`: Herramientas de desarrollo

## ⚙️ Configuración del Proyecto

### 1. Archivo `application.properties`

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/flight_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Puerto del servidor
server.port=8080
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

## 🚀 Funcionalidades Principales

### CRUD Usuario
- ✅ **Crear**: Agregar nuevos usuarios con validación
- ✅ **Leer**: Listar todos los usuarios
- ✅ **Actualizar**: Modificar datos del usuario
- ✅ **Eliminar**: Remover usuarios de la base de datos

### CRUD Vuelo
- ✅ **Crear**: Agregar nuevos vuelos
- ✅ **Leer**: Listar todos los vuelos con opciones de filtrado
- ✅ **Actualizar**: Modificar información del vuelo
- ✅ **Eliminar**: Remover vuelos

## 🏛️ Arquitectura Limpia: Contratos, Interfaces y Separación de Responsabilidades

Este proyecto implementa principios fundamentales de **arquitectura limpia** para garantizar código mantenible, testeable y escalable.

### 🤝 Contratos mediante Interfaces

El proyecto utiliza **interfaces** como contratos que definen las responsabilidades de cada capa:

#### 1. **Repository Interfaces**
```java
// Contrato para acceso a datos
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    List<Usuario> findAll();
}

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    List<Vuelo> findByOrigen(String origen);
    List<Vuelo> findByDestino(String destino);
}
```
- Define operaciones de acceso a datos sin exponer implementación
- Facilita cambios en la fuente de datos (MySQL → MongoDB, etc.)
- Permite testing sin acceso real a BD

#### 2. **Service Interfaces**
```java
// Contrato para lógica de negocio
public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerPorId(Integer id);
    List<Usuario> listarTodos();
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
}

public interface VueloService {
    Vuelo crearVuelo(Vuelo vuelo);
    List<Vuelo> listarVuelos();
    Vuelo actualizarVuelo(Integer id, Vuelo vuelo);
    void eliminarVuelo(Integer id);
    List<Vuelo> buscarVuelosPorRuta(String origen, String destino);
}
```
- Separa contrato de implementación
- Permite múltiples implementaciones si es necesario
- Facilita inyección de dependencias

### 🎯 Separación de Responsabilidades

Cada capa tiene una responsabilidad clara y específica:

| Capa | Responsabilidad | Ejemplo |
|------|-----------------|---------|
| **Model** | Representar entidades del dominio | `Usuario`, `Vuelo` (atributos + anotaciones JPA) |
| **Repository** | Acceso a datos y persistencia | Consultas a BD, CRUD de bajo nivel |
| **Service** | Lógica de negocio y validaciones | Validar datos, aplicar reglas, orquestar operaciones |
| **Controller** | Gestionar peticiones HTTP y respuestas | Recibir requests, delegar a service, retornar responses |
| **View** | Presentación de datos al usuario | Templates HTML renderizados con Thymeleaf |

### 📋 Flujo de Datos en Arquitectura Limpia

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
Database (MySQL)
```

### ✅ Beneficios de esta Arquitectura

1. **Independencia de Frameworks**: La lógica de negocio no depende de Spring
2. **Testabilidad**: Cada capa se prueba independientemente con mocks
3. **Mantenibilidad**: Cambios en una capa no afectan otras
4. **Escalabilidad**: Fácil agregar nuevas funcionalidades
5. **Reutilización**: Services pueden ser usados por múltiples controllers
6. **Flexibilidad**: Cambiar BD, agregar caché, etc. sin tocar lógica de negocio

### 💡 Ejemplo Práctico: Creación de Vuelo

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

## 🎨 Estilos CSS

Se han aplicado estilos Bootstrap y CSS personalizado para mejorar la experiencia del usuario:
- Formularios responsive
- Tablas con diseño moderno
- Botones con efectos hover
- Notificaciones de éxito/error

## 📝 Flujo Git/GitHub

Se siguió un flujo de trabajo estructurado:

```bash
# Crear rama para nueva funcionalidad
git checkout -b feature/nombre-feature

# Commits modulares y descriptivos
git commit -m "Agregar modelo Usuario"
git commit -m "Implementar repositorio Usuario"
git commit -m "Crear controlador Usuario"
git commit -m "Agregar vistas HTML para Usuario"

# Push con máximo 10 archivos
git push origin feature/nombre-feature
```

Cada rama representa una funcionalidad específica y se han realizado commits pequeños y descriptivos para mantener un historial limpio.

## 🎥 Video de Sustentación

Se adjunta un video que demuestra:
- La estructura y configuración del proyecto
- El funcionamiento completo del **CRUD de Usuarios** (basado en guías)
- El funcionamiento completo del **CRUD de Vuelos** (tabla asignada)
- Las operaciones básicas y casos de uso

## 📚 Referencias

- Guías de Spring Boot proporcionadas por el profesor
- Documentación oficial de [Spring Boot](https://spring.io/projects/spring-boot)
- Documentación de [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/) - Motor de plantillas

## ✍️ Autor

**VMgarciaRivera**

## 📅 Fecha de Realización

2026 - Actividad Académica

---

### Notas Importantes

- ✅ El CRUD de usuarios se implementó exactamente como se especificó en las guías del profesor
- ✅ La configuración del proyecto (`application.properties`) y las dependencias (`pom.xml`) siguen las instrucciones de las guías
- ✅ El CRUD de vuelos se desarrolló replicando la misma estructura y modelo del CRUD de usuarios
- ✅ Se han realizado commits pequeños y modulares en ramas separadas
- ✅ Todos los archivos relacionados con usuarios provienen de las guías del profesor
- ✅ Se implementó arquitectura limpia con interfaces de contratos para Repository y Service
- ✅ Se separaron claramente las responsabilidades en cada capa (Model, Repository, Service, Controller, View)
- ✅ El código sigue principios SOLID para mayor mantenibilidad y testabilidad
