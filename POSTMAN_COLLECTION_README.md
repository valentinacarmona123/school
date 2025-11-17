# School API - Colección Completa de Postman

## Descripción
Colección completa de Postman con todos los endpoints de la API School Management System, incluyendo datos de prueba realistas.

## Contenido de la Colección

### 1. **Profesores (4 registros)**
- Carlos García Rodríguez - Matemáticas
- María López Martínez - Español
- John Smith - Inglés
- Ana Fernández Gómez - Ciencias

### 2. **Aulas (3 registros)**
- AULA101 - Edificio A, Piso 1, Capacidad 40
- AULA102 - Edificio A, Piso 1, Capacidad 35
- AULA201 - Edificio B, Piso 2, Capacidad 40

### 3. **Asignaturas (8 registros)**
- **Grado 10:**
  - MAT101 - Matemáticas I (4 créditos)
  - ESP101 - Español I (3 créditos)
  - ENG101 - English I (3 créditos)
  - BIO101 - Biología I (4 créditos)

- **Grado 11:**
  - MAT102 - Matemáticas II (4 créditos)
  - ESP102 - Español II (3 créditos)
  - ENG102 - English II (3 créditos)
  - CHEM101 - Química I (4 créditos)

### 4. **Estudiantes Grado 10 (15 registros)**
1. Juan Pérez García (STU10001)
2. María López Martínez (STU10002)
3. Carlos Rodríguez Sánchez (STU10003)
4. Ana Fernández Gómez (STU10004)
5. David Morales Ruiz (STU10005)
6. Laura Jiménez Castro (STU10006)
7. Roberto Díaz López (STU10007)
8. Patricia Vargas Flores (STU10008)
9. Miguel Ramírez Herrera (STU10009)
10. Sofía Gutiérrez Mendoza (STU10010)
11. Francisco Navarro Reyes (STU10011)
12. Valentina Soto Vega (STU10012)
13. Andrés Castro Molina (STU10013)
14. Camila Ortiz Domínguez (STU10014)
15. Javier Ponce Acuña (STU10015)

### 5. **Estudiantes Grado 11 (15 registros)**
1. Alejandro Ruiz Campos (STU11001)
2. Gabriela Torres Silva (STU11002)
3. Mateo González Peña (STU11003)
4. Isabela Rojas Medina (STU11004)
5. Nicolás Sánchez Vázquez (STU11005)
6. Daniela Fuentes Herrera (STU11006)
7. Cristian Mendoza López (STU11007)
8. Valeria Acosta García (STU11008)
9. Sergio Flores Ramírez (STU11009)
10. Martina Núñez Castillo (STU11010)
11. Diego Varela Soto (STU11011)
12. Catalina Reyes Domínguez (STU11012)
13. Pablo Ibáñez Moreno (STU11013)
14. Lucía Delgado Vega (STU11014)
15. Tomás Espinoza Navarro (STU11015)

## Cómo Importar en Postman

### Opción 1: Importar desde archivo
1. Abre **Postman**
2. Haz clic en **Import** (esquina superior izquierda)
3. Selecciona **Upload Files**
4. Busca y selecciona `School_API_Complete.json`
5. Haz clic en **Import**

### Opción 2: Importar desde carpeta
1. En Postman, ve a **File** → **Import**
2. Selecciona la carpeta `src/main/resources/`
3. Elige `School_API_Complete.json`

## Configuración de Variables

La colección incluye una variable global:
- **base_url**: `http://localhost:8080` (por defecto)

Puedes cambiarla en **Environments** si necesitas usar un servidor diferente.

## Estructura de Requests

### Crear Profesor (POST)
```
POST {{base_url}}/api/teachers
Content-Type: application/json

{
  "id": "TEACH001",
  "name": "Carlos",
  "lastName": "García Rodríguez",
  "email": "carlos.garcia@school.edu",
  "phone": "3001234567",
  "birthDate": "1985-05-20",
  "gender": "MALE",
  "address": "Calle 5 #10-15",
  "active": true,
  "teacherId": "TEACH001",
  "specialization": "Matemáticas",
  "teachingSubjectIds": ["MAT101", "MAT102"],
  "fullTime": true,
  "salary": 2500000
}
```

### Crear Estudiante (POST)
```
POST {{base_url}}/api/students
Content-Type: application/json

{
  "id": "ID001",
  "name": "Juan",
  "lastName": "Pérez García",
  "email": "juan.perez@school.edu",
  "phone": "3001234501",
  "birthDate": "2008-03-15",
  "gender": "MALE",
  "address": "Calle 1 #10-20",
  "active": true,
  "studentId": "STU10001",
  "grade": "GRADE_10",
  "enrolledSubjects": [],
  "grades": []
}
```

### Crear Asignatura (POST)
```
POST {{base_url}}/api/subjects
Content-Type: application/json

{
  "code": "MAT101",
  "name": "Matemáticas I",
  "description": "Álgebra y Geometría básica",
  "credits": 4,
  "targetGrade": "GRADE_10",
  "teacherId": "TEACH001",
  "schedules": [],
  "active": true
}
```

### Crear Aula (POST)
```
POST {{base_url}}/api/classrooms
Content-Type: application/json

{
  "code": "AULA101",
  "building": "Edificio A",
  "floor": 1,
  "capacity": 40,
  "equipments": ["Proyector", "Pizarra Inteligente", "Computadora"],
  "hasProjector": true,
  "hasAirConditioning": true
}
```

## Valores Válidos para Enumeradores

### Grade (Grado)
- GRADE_1 a GRADE_12

### Gender (Género)
- MALE
- FEMALE

### GradeType (Tipo de Calificación)
- MIDTERM
- FINAL
- QUIZ
- PROJECT

### DayOfWeek (Día de la Semana)
- MONDAY
- TUESDAY
- WEDNESDAY
- THURSDAY
- FRIDAY
- SATURDAY
- SUNDAY

## Orden Recomendado de Ejecución

1. **Crear Profesores** (1. Teachers)
2. **Crear Aulas** (2. Classrooms)
3. **Crear Asignaturas** (3. Subjects)
4. **Crear Estudiantes Grado 10** (4. Students Grade 10)
5. **Crear Estudiantes Grado 11** (5. Students Grade 11)
6. **Consultar datos** (Get All requests)

## Persistencia de Datos

Los datos se guardan automáticamente en archivos CSV en la carpeta `data/`:
- `data/teachers.csv`
- `data/classrooms.csv`
- `data/subjects.csv`
- `data/students.csv`
- `data/grade_records.csv`
- `data/schedules.csv`

## Notas Importantes

- Todos los IDs deben ser únicos
- Las fechas deben estar en formato ISO 8601 (YYYY-MM-DD)
- Los emails deben ser válidos
- Los teléfonos deben tener formato válido
- Las direcciones pueden contener caracteres especiales
- Los estudiantes deben tener un grado válido (GRADE_1 a GRADE_12)

## Generación de la Colección

La colección fue generada automáticamente usando el script `generate_postman_collection.py`.

Para regenerarla con datos diferentes, ejecuta:
```bash
python generate_postman_collection.py
```

## Soporte

Para más información sobre los endpoints, consulta la documentación de la API en:
- `http://localhost:8080/swagger-ui.html` (si Swagger está habilitado)
- Documentación del proyecto en `README.md`
