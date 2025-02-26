
<h1 align="center">
    Animalia :paw_prints:
</h1>

## Descripción :pencil2:
El proyecto animalia consiste en desarrollar una API REST para una red social dedicada a animales. Esta plataforma permitirá a los usuarios registrar perfiles de sus mascotas, compartir publicaciones e interactuar con otros amantes de los animales.

## Funcionamiento :clipboard:
Este proyecto tiene como objetivo principal la creación de una **red social de animales** que permitirá:
- **Registro de mascotas:** Los usuarios podrán crear perfiles para sus animales con detalles como nombre, especie, edad y fotos.
- **Publicaciones:** Compartir fotos o textos sobre sus mascotas y experiencias.
- **Comentarios:** Los usuarios pueden realizar comentarios en las publicaciones que hayan subido otros usuarios.
- **Like:** Los usuarios pueden realizar likes en las publicaciones que hayan subido otros usuarios.
  
## Producto Final :raised_hands:
El resultado de este proyecto será una **API REST** implementada con **Spring Boot 3** y las siguientes tecnologías:

- **Persistencia de datos**: Spring Data JPA y PostgreSQL.
- **Documentación de API**: OpenAPI, Swagger y Springdoc.
- **Pruebas de API**: Postman.
-  **Contenedores**: `Docker Compose` para la configuración y despliegue automático de `PostgreSQ`, `pgAdmin` y la `API`.

Con Animalia buscamos ofrecer un espacio divertido y funcional para los amantes de los animales, aplicando tecnología moderna para construir una experiencia interactiva y dinámica.


## Modelo de Datos :chart_with_upwards_trend:
El diseño del modelo de datos incluye las siguientes entidades y relaciones clave:

1. **Usuario**: :woman:
   - Roles: `ADMIN` o `USER`.
   - Puede gestionar una o más mascotas y realizar publicaciones, comentarios y dar me gusta a una publicación.

2. **Mascota**: :cat:
   - Relacionada con un usuario propietario, una raza y una espcie.
   - Puede tener publicaciones asociadas.

3. **Raza**: :penguin:
   - Relacionada con una mascota

4. **Especie**: :frog:
   - Relacionada con una mascota

5. **Publicación**: :camera_flash:
   - Relacionada con una mascota, usuario, puede tener comentarios y likes.
   - El usuario realiza la publicación.
     
6. **Comentario**: :speech_balloon:
   - Relacionada con una publicación y realizada por un usuario.

Este modelo está diseñado para ser escalable y adaptarse a las necesidades de una red social en crecimiento.

## Instalación y Configuración :closed_lock_with_key:

### Requisitos previos
1. Tener instalado:
   - Java 17 o superior.
   - Maven.
   - PostgreSQL.
    
## Configuración de Docker-compose :whale:
- El proyecto incluye un archivo docker-compose.yml para configurar y levantar los servicios necesarios para el entorno de desarrollo. Los servicios configurados son:
  
1. **PostgreSQL** :elephant:
   * Imagen: postgres:16-alpine
   * Usuario: animalia
   * Contraseña: 87654321
   * Puerto mapeado: 5433 (local) → 5432 (contenedor)
  
2. **pgAdmin** :elephant:
   * Imagen: dpage/pgadmin4
   * Correo de acceso: admin@admin.com
   * Contraseña: 1
   * Puerto mapeado: 5050 (local) → 80 (contenedor)
  
3. **Api** :elephant:
   * Construida desde el Dockerfile.
   * Imagen: bellsoft/liberica-openjdk-alpine:17
   * Puerto mapeado: 8081 (local) → 8080 (contenedor)
   * Conexión a PostgreSQL mediante variables de entorno (SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD)
  
4. Para levantar los contenedores, simplemente ejecuta:
   - docker-compose up -d, esto tambien levanta la imagen que hemos creado, así nos ahorramos de realzar un docker build -t

## Construcción con Dockerfile :hammer:
El proyecto incluye un Dockerfile con dos etapas:
  * **Build:** Usa `bellsoft/liberica-openjdk-alpine:17` para compilar la aplicación con Maven.
  * **Runtime:** Copia el `.jar` generado y lo ejecuta en un contenedor ligero.
- La imagen se genera automáticamente al ejecutar `docker-compose up -d`, pero también puedes construirla manualmente con:
  * docker build -t animalia-api .

## Documentación de la API  :clipboard:
* La documentación de la API se genera automáticamente utilizando Swagger. Una vez iniciada la aplicación, puedes acceder a la documentación en:
   * http://localhost:8081/swagger-ui/index.html#/
 
## Dependencias :pencil:
   * En SQL (H2 Database y Spring Data JPA)
   * Lombook
   * Spring web
   * Postgresql
   * Sendgrid
   * Tika
   * Spring Security
