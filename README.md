🚀 Challenge: Foro Hub

Esta es mi versión del Challenge: "Foro Hub" para el curso ONE de Alura!

Es un sistema que permite interactuar con una API REST para gestionar tópicos en un foro educativo. Los usuarios pueden crear, consultar, actualizar y eliminar tópicos relacionados con cursos y dudas de la comunidad. Además, la API incluye autenticación con JWT para proteger los endpoints y garantizar que solo usuarios validados puedan realizar acciones en el foro.

Tecnologías Utilizadas 🛠️

Backend: Java, Spring Boot, Spring Data JPA

Persistencia: MySQL (plantilla configurable para cada usuario)

JSON: Jackson

Seguridad: Spring Security, JWT

IDE: IntelliJ IDEA

Instalación

Clona o descarga los archivos del proyecto en tu máquina.
Configura la base de datos MySQL a modo plantilla:
Crea una base de datos (por ejemplo forohub_db).
Configura url, username y password en src/main/resources/application.properties.
Abre el proyecto con IntelliJ IDEA y ejecuta la clase principal ForoHubApplication.java.
Para generar un token de autenticación, envía un POST a:
POST http://localhost:8080/login
Content-Type: application/json
Copia el token JWT recibido y úsalo en los headers de tus solicitudes CRUD.

Funcionalidades:

Crear un nuevo tópico.

Listar todos los tópicos.

Consultar un tópico específico por ID.

Actualizar un tópico existente.

Eliminar un tópico por ID.

Autenticación mediante JWT para proteger el acceso a los endpoints.

Validación de campos obligatorios y control de tópicos duplicados.

Hecho por Antonio Ismael Vargas Nava, para el curso ONE de Alura. Cualquiera puede usar este programa y adaptarlo a sus necesidades.
