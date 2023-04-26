Proyecto de integrador back-end
Documentación de referencia
Para mayor referencia, por favor considere las siguientes secciones:

Documentación oficial de Apache Maven
Guía de referencia del complemento Spring Boot Maven
Crear una imagen OCI
JPA de datos de primavera
Herramientas de desarrollo Spring Boot
Telaraña de primavera
Guías
Las siguientes guías ilustran cómo usar algunas características concretamente:

Acceso a datos con JPA
Creación de un servicio web REST
Sirviendo contenido web con Spring MVC
Creación de servicios REST con Spring
Sistema de Reserva de Turnos
Se desea implementar un sistema que permita gestionar la reserva de turnos para una clínica dental. Este debe cumplir con los siguientes requisitos:

Gestión de datos de dentistas: enumerar, agregar, modificar y eliminar dentistas. Registrar apellido, nombre y matrícula del mismo.
Gestión de datos de pacientes: enumerar, añadir, modificar y eliminar pacientes. Para cada uno se almacenan: nombre, apellidos, dirección, DNI y fecha de registro.
Registrar turno: debe ser posible permitir que a un paciente se le asigne un turno con un odontólogo en una fecha y hora determinadas.
Login: validar el ingreso al sistema mediante un login con usuario y contraseña. Cualquier usuario que haya iniciado sesión (ROLE_USER) debe poder registrar una cita, pero solo aquellos con un rol de administrador (ROLE_ADMIN) para poder gestionar dentistas y pacientes. Un usuario puede tener un solo rol y se ingresará directamente en la base de datos.
Requerimientos técnicos
La aplicación debe desarrollarse por capas:

Capa de entidades de negocio: son las clases Java de nuestro negocio modeladas a través del paradigma orientado a objetos.
Capa de acceso a datos (Repositorio): son las clases que se encargarán de acceder a la base de datos.
Capa de datos (base de datos): es la base de datos de nuestro sistema modelada a través de un modelo entidad-relación. Usaremos la base H2 por su practicidad.
Capa de negocio: son las clases de servicio que se encargan de desacoplar el acceso a los datos de la vista.
Capa de presentación: estas son las pantallas web que tendremos que desarrollar usando el framework Spring Boot MVC con los controladores y una de estas dos opciones: HTML+JavaScript o React para la vista.
Es importante manejar las excepciones registrando cualquier excepción que pueda generarse y realizando pruebas unitarias para garantizar la calidad de los desarrollos.

Progreso
La obra tendrá una sola entrega final, pero para ayudarte a organizarte, te sugerimos que avances de la siguiente manera:

Sprint 0 (Inicio)
Una vez iniciado el curso con los conocimientos ya adquiridos en Programación Orientada a Objetos, Base de Datos I y Front End I, podrás comenzar a construir tu modelo UML de las clases que necesitarás para el proyecto integrador así como todo lo relacionado con el tablas de la base de datos relacional que necesitarás para persistir los datos y las pantallas HTML con sus estilos para ingresarlas. ¡¡¡No te preocupes que a lo largo del curso aprenderás a integrar todas estas partes!!!

Sprint 1 (Inicio de la semana 1 al final de la semana 2)
Con lo aprendido durante estas semanas podrás realizar pruebas unitarias de las clases Java que hayas programado. Para asegurarse a partir de ahora de que con cada cambio su software sigue funcionando, las pruebas unitarias son muy importantes.

Sprint 2 (desde el inicio de la semana 3 hasta el final de la semana 4)
Durante este sprint con todo lo aprendido durante el curso en la clase 18 podrás trabajar con Maven en tu proyecto para referenciar tus librerías y con lo que vimos en la clase 14 podrás construir tus clases DAO (capa de acceso a datos con JDBC ) y las clases de servicio (capa de negocio) para cada una de las entidades de tu proyecto, pudiendo siempre garantizar el funcionamiento de todo lo que construyas mediante pruebas unitarias.

Sprint 3 (Inicio de la semana 5 al final de la semana 6)
A lo largo de este sprint, refactorizará la capa de acceso a datos para poder acceder a ellos y recuperarlos a través de un ORM. Crear los mapeos y las clases del Repositorio que serán reemplazados por el DAO cumpliendo la misma función. Con todo lo aprendido en las clases 25, 27 y 28 podrás construir las APIs durante este sprint (mediante el desarrollo de los controladores) y la integración con la capa de presentación, es decir, las pantallas HTML, a través de javascript.

Sprint 4 (Inicio de la semana 7 al final de la semana 8)
Lo más sencillo queda para el final. Con los conocimientos adquiridos en la clase 43, puede agregar muy fácilmente un inicio de sesión con Spring Security a su proyecto. Entrega clase 48. Tendrás tiempo a lo largo del día para entregar hasta las 23:59