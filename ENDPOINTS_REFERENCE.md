# School API - Complete Endpoints Reference with CURL Commands

## Base Configuration
- **Base URL**: `http://localhost:8080`
- **Content-Type**: `application/json`

---

## TEACHERS ENDPOINTS

### 1. GET All Teachers
**CURL:**
```bash
curl -X GET http://localhost:8080/api/teachers
```

**Response (200 OK):**
```json
[
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
]
```

### 2. GET Teacher by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/teachers/TEACH001
```

**Response (200 OK):**
```json
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

### 3. CREATE Teacher
**CURL:**
```bash
curl -X POST http://localhost:8080/api/teachers \
  -H 'Content-Type: application/json' \
  -d '{
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
  }'
```

**Response (201 Created):**
```json
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

### 4. UPDATE Teacher
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/teachers/TEACH001 \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Carlos Updated",
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
    "salary": 2600000
  }'
```

**Response (200 OK):**
```json
{
  "id": "TEACH001",
  "name": "Carlos Updated",
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
  "salary": 2600000
}
```

### 5. DELETE Teacher
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/teachers/TEACH001
```

**Response (204 No Content):**
```
(empty body)
```

---

## STUDENTS ENDPOINTS

### 1. GET All Students
**CURL:**
```bash
curl -X GET http://localhost:8080/api/students
```

**Response (200 OK):**
```json
[
  {
    "id": "ID001",
    "name": "Juan",
    "lastName": "Pérez García",
    "email": "juan.pérez@school.edu",
    "phone": "3001234501",
    "birthDate": "2008-02-03",
    "gender": "MALE",
    "address": "Calle 1 #5-10",
    "active": true,
    "studentId": "STU10001",
    "grade": "GRADE_10",
    "enrolledSubjects": [],
    "grades": []
  }
]
```

### 2. GET Student by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/students/STU10001
```

**Response (200 OK):**
```json
{
  "id": "ID001",
  "name": "Juan",
  "lastName": "Pérez García",
  "email": "juan.pérez@school.edu",
  "phone": "3001234501",
  "birthDate": "2008-02-03",
  "gender": "MALE",
  "address": "Calle 1 #5-10",
  "active": true,
  "studentId": "STU10001",
  "grade": "GRADE_10",
  "enrolledSubjects": [],
  "grades": []
}
```

### 3. CREATE Student
**CURL:**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID001",
    "name": "Juan",
    "lastName": "Pérez García",
    "email": "juan.pérez@school.edu",
    "phone": "3001234501",
    "birthDate": "2008-02-03",
    "gender": "MALE",
    "address": "Calle 1 #5-10",
    "active": true,
    "studentId": "STU10001",
    "grade": "GRADE_10",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Response (201 Created):**
```json
{
  "id": "ID001",
  "name": "Juan",
  "lastName": "Pérez García",
  "email": "juan.pérez@school.edu",
  "phone": "3001234501",
  "birthDate": "2008-02-03",
  "gender": "MALE",
  "address": "Calle 1 #5-10",
  "active": true,
  "studentId": "STU10001",
  "grade": "GRADE_10",
  "enrolledSubjects": [],
  "grades": []
}
```

### 4. UPDATE Student
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/students/STU10001 \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Juan Updated",
    "lastName": "Pérez García",
    "email": "juan.pérez@school.edu",
    "phone": "3001234501",
    "birthDate": "2008-02-03",
    "gender": "MALE",
    "address": "Calle 1 #5-10",
    "active": true,
    "studentId": "STU10001",
    "grade": "GRADE_10",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Response (200 OK):**
```json
{
  "id": "ID001",
  "name": "Juan Updated",
  "lastName": "Pérez García",
  "email": "juan.pérez@school.edu",
  "phone": "3001234501",
  "birthDate": "2008-02-03",
  "gender": "MALE",
  "address": "Calle 1 #5-10",
  "active": true,
  "studentId": "STU10001",
  "grade": "GRADE_10",
  "enrolledSubjects": [],
  "grades": []
}
```

### 5. DELETE Student
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/students/STU10001
```

**Response (204 No Content):**
```
(empty body)
```

---

## CLASSROOMS ENDPOINTS

### 1. GET All Classrooms
**CURL:**
```bash
curl -X GET http://localhost:8080/api/classrooms
```

**Response (200 OK):**
```json
[
  {
    "code": "AULA101",
    "building": "Edificio A",
    "floor": 1,
    "capacity": 40,
    "equipments": ["Proyector", "Pizarra Inteligente", "Computadora"],
    "hasProjector": true,
    "hasAirConditioning": true
  }
]
```

### 2. GET Classroom by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/classrooms/AULA101
```

**Response (200 OK):**
```json
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

### 3. CREATE Classroom
**CURL:**
```bash
curl -X POST http://localhost:8080/api/classrooms \
  -H 'Content-Type: application/json' \
  -d '{
    "code": "AULA101",
    "building": "Edificio A",
    "floor": 1,
    "capacity": 40,
    "equipments": ["Proyector", "Pizarra Inteligente", "Computadora"],
    "hasProjector": true,
    "hasAirConditioning": true
  }'
```

**Response (201 Created):**
```json
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

### 4. UPDATE Classroom
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/classrooms/AULA101 \
  -H 'Content-Type: application/json' \
  -d '{
    "code": "AULA101",
    "building": "Edificio A",
    "floor": 1,
    "capacity": 45,
    "equipments": ["Proyector", "Pizarra Inteligente", "Computadora", "Laboratorio"],
    "hasProjector": true,
    "hasAirConditioning": true
  }'
```

**Response (200 OK):**
```json
{
  "code": "AULA101",
  "building": "Edificio A",
  "floor": 1,
  "capacity": 45,
  "equipments": ["Proyector", "Pizarra Inteligente", "Computadora", "Laboratorio"],
  "hasProjector": true,
  "hasAirConditioning": true
}
```

### 5. DELETE Classroom
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/classrooms/AULA101
```

**Response (204 No Content):**
```
(empty body)
```

---

## SUBJECTS ENDPOINTS

### 1. GET All Subjects
**CURL:**
```bash
curl -X GET http://localhost:8080/api/subjects
```

**Response (200 OK):**
```json
[
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
]
```

### 2. GET Subject by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/subjects/MAT101
```

**Response (200 OK):**
```json
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

### 3. CREATE Subject
**CURL:**
```bash
curl -X POST http://localhost:8080/api/subjects \
  -H 'Content-Type: application/json' \
  -d '{
    "code": "MAT101",
    "name": "Matemáticas I",
    "description": "Álgebra y Geometría básica",
    "credits": 4,
    "targetGrade": "GRADE_10",
    "teacherId": "TEACH001",
    "schedules": [],
    "active": true
  }'
```

**Response (201 Created):**
```json
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

### 4. UPDATE Subject
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/subjects/MAT101 \
  -H 'Content-Type: application/json' \
  -d '{
    "code": "MAT101",
    "name": "Matemáticas I",
    "description": "Álgebra y Geometría básica avanzada",
    "credits": 5,
    "targetGrade": "GRADE_10",
    "teacherId": "TEACH001",
    "schedules": [],
    "active": true
  }'
```

**Response (200 OK):**
```json
{
  "code": "MAT101",
  "name": "Matemáticas I",
  "description": "Álgebra y Geometría básica avanzada",
  "credits": 5,
  "targetGrade": "GRADE_10",
  "teacherId": "TEACH001",
  "schedules": [],
  "active": true
}
```

### 5. DELETE Subject
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/subjects/MAT101
```

**Response (204 No Content):**
```
(empty body)
```

---

## SCHEDULES ENDPOINTS

### 1. GET All Schedules
**CURL:**
```bash
curl -X GET http://localhost:8080/api/schedules
```

**Response (200 OK):**
```json
[
  {
    "id": "SCHED001",
    "subjectCode": "MAT101",
    "classroomCode": "AULA101",
    "dayOfWeek": "MONDAY",
    "startTime": "08:00",
    "endTime": "09:30"
  }
]
```

### 2. GET Schedule by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/schedules/SCHED001
```

**Response (200 OK):**
```json
{
  "id": "SCHED001",
  "subjectCode": "MAT101",
  "classroomCode": "AULA101",
  "dayOfWeek": "MONDAY",
  "startTime": "08:00",
  "endTime": "09:30"
}
```

### 3. CREATE Schedule
**CURL:**
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED001",
    "subjectCode": "MAT101",
    "classroomCode": "AULA101",
    "dayOfWeek": "MONDAY",
    "startTime": "08:00",
    "endTime": "09:30"
  }'
```

**Response (201 Created):**
```json
{
  "id": "SCHED001",
  "subjectCode": "MAT101",
  "classroomCode": "AULA101",
  "dayOfWeek": "MONDAY",
  "startTime": "08:00",
  "endTime": "09:30"
}
```

### 4. UPDATE Schedule
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/schedules/SCHED001 \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED001",
    "subjectCode": "MAT101",
    "classroomCode": "AULA101",
    "dayOfWeek": "MONDAY",
    "startTime": "09:00",
    "endTime": "10:30"
  }'
```

**Response (200 OK):**
```json
{
  "id": "SCHED001",
  "subjectCode": "MAT101",
  "classroomCode": "AULA101",
  "dayOfWeek": "MONDAY",
  "startTime": "09:00",
  "endTime": "10:30"
}
```

### 5. DELETE Schedule
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/schedules/SCHED001
```

**Response (204 No Content):**
```
(empty body)
```

---

## GRADE RECORDS ENDPOINTS

### 1. GET All Grade Records
**CURL:**
```bash
curl -X GET http://localhost:8080/api/grade-records
```

**Response (200 OK):**
```json
[
  {
    "id": "GRADE001",
    "studentId": "STU10001",
    "subjectCode": "MAT101",
    "grade": 85,
    "period": "FIRST_PERIOD"
  }
]
```

### 2. GET Grade Record by ID
**CURL:**
```bash
curl -X GET http://localhost:8080/api/grade-records/GRADE001
```

**Response (200 OK):**
```json
{
  "id": "GRADE001",
  "studentId": "STU10001",
  "subjectCode": "MAT101",
  "grade": 85,
  "period": "FIRST_PERIOD"
}
```

### 3. CREATE Grade Record
**CURL:**
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE001",
    "studentId": "STU10001",
    "subjectCode": "MAT101",
    "grade": 85,
    "period": "FIRST_PERIOD"
  }'
```

**Response (201 Created):**
```json
{
  "id": "GRADE001",
  "studentId": "STU10001",
  "subjectCode": "MAT101",
  "grade": 85,
  "period": "FIRST_PERIOD"
}
```

### 4. UPDATE Grade Record
**CURL:**
```bash
curl -X PUT http://localhost:8080/api/grade-records/GRADE001 \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE001",
    "studentId": "STU10001",
    "subjectCode": "MAT101",
    "grade": 90,
    "period": "FIRST_PERIOD"
  }'
```

**Response (200 OK):**
```json
{
  "id": "GRADE001",
  "studentId": "STU10001",
  "subjectCode": "MAT101",
  "grade": 90,
  "period": "FIRST_PERIOD"
}
```

### 5. DELETE Grade Record
**CURL:**
```bash
curl -X DELETE http://localhost:8080/api/grade-records/GRADE001
```

**Response (204 No Content):**
```
(empty body)
```

---

## HTTP Status Codes Reference

| Code | Status | Description |
|------|--------|-------------|
| 200 | OK | Solicitud exitosa (GET, PUT) |
| 201 | Created | Recurso creado exitosamente (POST) |
| 204 | No Content | Solicitud exitosa sin contenido (DELETE) |
| 400 | Bad Request | Solicitud inválida |
| 404 | Not Found | Recurso no encontrado |
| 500 | Internal Server Error | Error del servidor |

---

## Quick Reference Summary

| Recurso | GET All | GET by ID | POST | PUT | DELETE |
|---------|---------|-----------|------|-----|--------|
| Teachers | `/api/teachers` | `/api/teachers/{id}` | ✓ | ✓ | ✓ |
| Students | `/api/students` | `/api/students/{id}` | ✓ | ✓ | ✓ |
| Classrooms | `/api/classrooms` | `/api/classrooms/{id}` | ✓ | ✓ | ✓ |
| Subjects | `/api/subjects` | `/api/subjects/{id}` | ✓ | ✓ | ✓ |
| Schedules | `/api/schedules` | `/api/schedules/{id}` | ✓ | ✓ | ✓ |
| Grade Records | `/api/grade-records` | `/api/grade-records/{id}` | ✓ | ✓ | ✓ |
