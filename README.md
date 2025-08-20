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
