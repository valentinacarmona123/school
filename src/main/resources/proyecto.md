Enunciado del proyecto: Desarrollar una API REST
en Java (versión superior a Java 23) utilizando 
Spring Boot y Lombok, para la gestión académica y 
administrativa de un colegio. El sistema deberá 
permitir registrar, consultar, actualizar y eliminar 
información relacionada con la institución educativa, 
incluyendo estudiantes, profesores, materias, cursos, 
calificaciones, asignaturas, horarios, aulas, matrículas
y personal administrativo. Toda la información se almacenará 
en un archivo CSV (valores separados por comas) en lugar
de una base de datos relacional. El diseño del proyecto 
debe demostrar la aplicación de los principios fundamentales 
de la Programación Orientada a Objetos (POO), implementando:
• Encapsulamiento para proteger los atributos y controlar su acceso.
• Herencia para modelar jerarquías (por ejemplo, una clase abstracta
Persona heredada por Profesor y Estudiante).
• Polimorfismo para redefinir o sobrecargar métodos según 
el tipo de objeto (por ejemplo, distintos modos de evaluación o registro). 
• Interfaces para definir comportamientos comunes (como Evaluable, 
Asistible o Registrable). 
• Composición y agregación para representar relaciones entre objetos 
(por ejemplo, un Curso contiene varias Asignaturas y varios Estudiantes).
El sistema deberá incluir al menos 10 clases dentro de su modelo,
pudiendo incorporar records, enumeraciones y clases abstractas 
según sea necesario para representar estructuras o comportamientos
propios del dominio educativo.