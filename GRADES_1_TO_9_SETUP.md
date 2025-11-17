# School API - Grades 1-9 Complete Setup Guide

## Overview
This guide provides CURL commands to create all grades (1-9) with students, schedules, and grade records.

---

## GRADE 1 Setup

### Create Students Grade 1

**Student 1: STU01001 - María Gómez López**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID101",
    "name": "María",
    "lastName": "Gómez López",
    "email": "maria.gomez@school.edu",
    "phone": "3001234601",
    "birthDate": "2017-03-15",
    "gender": "FEMALE",
    "address": "Calle 31 #155-310",
    "active": true,
    "studentId": "STU01001",
    "grade": "GRADE_1",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU01002 - Luis Martínez Pérez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID102",
    "name": "Luis",
    "lastName": "Martínez Pérez",
    "email": "luis.martinez@school.edu",
    "phone": "3001234602",
    "birthDate": "2017-04-20",
    "gender": "MALE",
    "address": "Calle 32 #160-320",
    "active": true,
    "studentId": "STU01002",
    "grade": "GRADE_1",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 1
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G1_001",
    "subjectCode": "ESP101",
    "classroomCode": "AULA101",
    "dayOfWeek": "MONDAY",
    "startTime": "08:00",
    "endTime": "09:30"
  }'
```

### Create Grade Records Grade 1
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G1_001",
    "studentId": "STU01001",
    "subjectCode": "ESP101",
    "grade": 88,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 2 Setup

### Create Students Grade 2

**Student 1: STU02001 - Pedro Rodríguez Silva**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID201",
    "name": "Pedro",
    "lastName": "Rodríguez Silva",
    "email": "pedro.rodriguez@school.edu",
    "phone": "3001234701",
    "birthDate": "2016-05-10",
    "gender": "MALE",
    "address": "Calle 33 #165-330",
    "active": true,
    "studentId": "STU02001",
    "grade": "GRADE_2",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU02002 - Ana García Flores**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID202",
    "name": "Ana",
    "lastName": "García Flores",
    "email": "ana.garcia@school.edu",
    "phone": "3001234702",
    "birthDate": "2016-06-12",
    "gender": "FEMALE",
    "address": "Calle 34 #170-340",
    "active": true,
    "studentId": "STU02002",
    "grade": "GRADE_2",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 2
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G2_001",
    "subjectCode": "MAT101",
    "classroomCode": "AULA102",
    "dayOfWeek": "TUESDAY",
    "startTime": "09:30",
    "endTime": "11:00"
  }'
```

### Create Grade Records Grade 2
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G2_001",
    "studentId": "STU02001",
    "subjectCode": "MAT101",
    "grade": 92,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 3 Setup

### Create Students Grade 3

**Student 1: STU03001 - Carlos López Sánchez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID301",
    "name": "Carlos",
    "lastName": "López Sánchez",
    "email": "carlos.lopez@school.edu",
    "phone": "3001234801",
    "birthDate": "2015-07-08",
    "gender": "MALE",
    "address": "Calle 35 #175-350",
    "active": true,
    "studentId": "STU03001",
    "grade": "GRADE_3",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU03002 - Sofía Díaz Morales**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID302",
    "name": "Sofía",
    "lastName": "Díaz Morales",
    "email": "sofia.diaz@school.edu",
    "phone": "3001234802",
    "birthDate": "2015-08-14",
    "gender": "FEMALE",
    "address": "Calle 36 #180-360",
    "active": true,
    "studentId": "STU03002",
    "grade": "GRADE_3",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 3
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G3_001",
    "subjectCode": "BIO101",
    "classroomCode": "AULA201",
    "dayOfWeek": "WEDNESDAY",
    "startTime": "11:00",
    "endTime": "12:30"
  }'
```

### Create Grade Records Grade 3
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G3_001",
    "studentId": "STU03001",
    "subjectCode": "BIO101",
    "grade": 85,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 4 Setup

### Create Students Grade 4

**Student 1: STU04001 - Diego Fernández Ruiz**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID401",
    "name": "Diego",
    "lastName": "Fernández Ruiz",
    "email": "diego.fernandez@school.edu",
    "phone": "3001234901",
    "birthDate": "2014-09-18",
    "gender": "MALE",
    "address": "Calle 37 #185-370",
    "active": true,
    "studentId": "STU04001",
    "grade": "GRADE_4",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU04002 - Valentina Castillo Vega**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID402",
    "name": "Valentina",
    "lastName": "Castillo Vega",
    "email": "valentina.castillo@school.edu",
    "phone": "3001234902",
    "birthDate": "2014-10-22",
    "gender": "FEMALE",
    "address": "Calle 38 #190-380",
    "active": true,
    "studentId": "STU04002",
    "grade": "GRADE_4",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 4
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G4_001",
    "subjectCode": "ENG101",
    "classroomCode": "AULA101",
    "dayOfWeek": "THURSDAY",
    "startTime": "13:00",
    "endTime": "14:30"
  }'
```

### Create Grade Records Grade 4
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G4_001",
    "studentId": "STU04001",
    "subjectCode": "ENG101",
    "grade": 90,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 5 Setup

### Create Students Grade 5

**Student 1: STU05001 - Andrés Navarro Jiménez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID501",
    "name": "Andrés",
    "lastName": "Navarro Jiménez",
    "email": "andres.navarro@school.edu",
    "phone": "3001235001",
    "birthDate": "2013-11-25",
    "gender": "MALE",
    "address": "Calle 39 #195-390",
    "active": true,
    "studentId": "STU05001",
    "grade": "GRADE_5",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU05002 - Camila Reyes Domínguez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID502",
    "name": "Camila",
    "lastName": "Reyes Domínguez",
    "email": "camila.reyes@school.edu",
    "phone": "3001235002",
    "birthDate": "2013-12-30",
    "gender": "FEMALE",
    "address": "Calle 40 #200-400",
    "active": true,
    "studentId": "STU05002",
    "grade": "GRADE_5",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 5
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G5_001",
    "subjectCode": "CHEM101",
    "classroomCode": "AULA102",
    "dayOfWeek": "FRIDAY",
    "startTime": "14:30",
    "endTime": "16:00"
  }'
```

### Create Grade Records Grade 5
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G5_001",
    "studentId": "STU05001",
    "subjectCode": "CHEM101",
    "grade": 87,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 6 Setup

### Create Students Grade 6

**Student 1: STU06001 - Javier Acuña Méndez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID601",
    "name": "Javier",
    "lastName": "Acuña Méndez",
    "email": "javier.acuna@school.edu",
    "phone": "3001235101",
    "birthDate": "2012-01-14",
    "gender": "MALE",
    "address": "Calle 41 #205-410",
    "active": true,
    "studentId": "STU06001",
    "grade": "GRADE_6",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU06002 - Lucía Vargas Herrera**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID602",
    "name": "Lucía",
    "lastName": "Vargas Herrera",
    "email": "lucia.vargas@school.edu",
    "phone": "3001235102",
    "birthDate": "2012-02-18",
    "gender": "FEMALE",
    "address": "Calle 42 #210-420",
    "active": true,
    "studentId": "STU06002",
    "grade": "GRADE_6",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 6
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G6_001",
    "subjectCode": "MAT102",
    "classroomCode": "AULA201",
    "dayOfWeek": "MONDAY",
    "startTime": "08:00",
    "endTime": "09:30"
  }'
```

### Create Grade Records Grade 6
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G6_001",
    "studentId": "STU06001",
    "subjectCode": "MAT102",
    "grade": 89,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 7 Setup

### Create Students Grade 7

**Student 1: STU07001 - Mateo Soto Campos**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID701",
    "name": "Mateo",
    "lastName": "Soto Campos",
    "email": "mateo.soto@school.edu",
    "phone": "3001235201",
    "birthDate": "2011-03-22",
    "gender": "MALE",
    "address": "Calle 43 #215-430",
    "active": true,
    "studentId": "STU07001",
    "grade": "GRADE_7",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU07002 - Isabella Ortiz Mendoza**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID702",
    "name": "Isabella",
    "lastName": "Ortiz Mendoza",
    "email": "isabella.ortiz@school.edu",
    "phone": "3001235202",
    "birthDate": "2011-04-26",
    "gender": "FEMALE",
    "address": "Calle 44 #220-440",
    "active": true,
    "studentId": "STU07002",
    "grade": "GRADE_7",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 7
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G7_001",
    "subjectCode": "ESP102",
    "classroomCode": "AULA102",
    "dayOfWeek": "TUESDAY",
    "startTime": "09:30",
    "endTime": "11:00"
  }'
```

### Create Grade Records Grade 7
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G7_001",
    "studentId": "STU07001",
    "subjectCode": "ESP102",
    "grade": 91,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 8 Setup

### Create Students Grade 8

**Student 1: STU08001 - Nicolás Sánchez Vázquez**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID801",
    "name": "Nicolás",
    "lastName": "Sánchez Vázquez",
    "email": "nicolas.sanchez@school.edu",
    "phone": "3001235301",
    "birthDate": "2010-05-30",
    "gender": "MALE",
    "address": "Calle 45 #225-450",
    "active": true,
    "studentId": "STU08001",
    "grade": "GRADE_8",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU08002 - Daniela Fuentes Herrera**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID802",
    "name": "Daniela",
    "lastName": "Fuentes Herrera",
    "email": "daniela.fuentes@school.edu",
    "phone": "3001235302",
    "birthDate": "2010-06-08",
    "gender": "FEMALE",
    "address": "Calle 46 #230-460",
    "active": true,
    "studentId": "STU08002",
    "grade": "GRADE_8",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 8
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G8_001",
    "subjectCode": "BIO101",
    "classroomCode": "AULA201",
    "dayOfWeek": "WEDNESDAY",
    "startTime": "11:00",
    "endTime": "12:30"
  }'
```

### Create Grade Records Grade 8
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G8_001",
    "studentId": "STU08001",
    "subjectCode": "BIO101",
    "grade": 86,
    "period": "FIRST_PERIOD"
  }'
```

---

## GRADE 9 Setup

### Create Students Grade 9

**Student 1: STU09001 - Cristian Mendoza López**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID901",
    "name": "Cristian",
    "lastName": "Mendoza López",
    "email": "cristian.mendoza@school.edu",
    "phone": "3001235401",
    "birthDate": "2009-07-12",
    "gender": "MALE",
    "address": "Calle 47 #235-470",
    "active": true,
    "studentId": "STU09001",
    "grade": "GRADE_9",
    "enrolledSubjects": [],
    "grades": []
  }'
```

**Student 2: STU09002 - Valeria Acosta García**
```bash
curl -X POST http://localhost:8080/api/students \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "ID902",
    "name": "Valeria",
    "lastName": "Acosta García",
    "email": "valeria.acosta@school.edu",
    "phone": "3001235402",
    "birthDate": "2009-08-16",
    "gender": "FEMALE",
    "address": "Calle 48 #240-480",
    "active": true,
    "studentId": "STU09002",
    "grade": "GRADE_9",
    "enrolledSubjects": [],
    "grades": []
  }'
```

### Create Schedule Grade 9
```bash
curl -X POST http://localhost:8080/api/schedules \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "SCHED_G9_001",
    "subjectCode": "CHEM101",
    "classroomCode": "AULA102",
    "dayOfWeek": "THURSDAY",
    "startTime": "13:00",
    "endTime": "14:30"
  }'
```

### Create Grade Records Grade 9
```bash
curl -X POST http://localhost:8080/api/grade-records \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "GRADE_G9_001",
    "studentId": "STU09001",
    "subjectCode": "CHEM101",
    "grade": 93,
    "period": "FIRST_PERIOD"
  }'
```

---

## Summary

| Grade | Students | Schedules | Grade Records |
|-------|----------|-----------|---------------|
| 1 | 2 | 1 | 1 |
| 2 | 2 | 1 | 1 |
| 3 | 2 | 1 | 1 |
| 4 | 2 | 1 | 1 |
| 5 | 2 | 1 | 1 |
| 6 | 2 | 1 | 1 |
| 7 | 2 | 1 | 1 |
| 8 | 2 | 1 | 1 |
| 9 | 2 | 1 | 1 |
| **TOTAL** | **18** | **9** | **9** |

**Total Students Created: 18 (Grades 1-9)**
**Total Schedules Created: 9 (one per grade)**
**Total Grade Records Created: 9 (one per grade)**
