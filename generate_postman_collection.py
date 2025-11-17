#!/usr/bin/env python3
import json

# Base structure
collection = {
    "info": {
        "_postman_id": "school-api-complete",
        "name": "School API - Complete Collection",
        "description": "Colección completa: 4 profesores, 3 aulas, 8 asignaturas, 30 estudiantes (15 G10 + 15 G11), horarios y calificaciones",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [],
    "variable": [
        {"key": "base_url", "value": "http://localhost:8080", "type": "string"}
    ]
}

# Teachers
teachers_data = [
    {"id": "TEACH001", "name": "Carlos", "lastName": "García Rodríguez", "email": "carlos.garcia@school.edu", "phone": "3001234567", "birthDate": "1985-05-20", "gender": "MALE", "address": "Calle 5 #10-15", "active": True, "teacherId": "TEACH001", "specialization": "Matemáticas", "teachingSubjectIds": ["MAT101", "MAT102"], "fullTime": True, "salary": 2500000},
    {"id": "TEACH002", "name": "María", "lastName": "López Martínez", "email": "maria.lopez@school.edu", "phone": "3002234567", "birthDate": "1988-03-15", "gender": "FEMALE", "address": "Calle 10 #20-30", "active": True, "teacherId": "TEACH002", "specialization": "Español", "teachingSubjectIds": ["ESP101", "ESP102"], "fullTime": True, "salary": 2400000},
    {"id": "TEACH003", "name": "John", "lastName": "Smith", "email": "john.smith@school.edu", "phone": "3003234567", "birthDate": "1990-07-22", "gender": "MALE", "address": "Calle 15 #25-40", "active": True, "teacherId": "TEACH003", "specialization": "Inglés", "teachingSubjectIds": ["ENG101", "ENG102"], "fullTime": True, "salary": 2600000},
    {"id": "TEACH004", "name": "Ana", "lastName": "Fernández Gómez", "email": "ana.fernandez@school.edu", "phone": "3004234567", "birthDate": "1987-11-10", "gender": "FEMALE", "address": "Calle 20 #30-45", "active": True, "teacherId": "TEACH004", "specialization": "Ciencias", "teachingSubjectIds": ["BIO101", "CHEM101"], "fullTime": True, "salary": 2450000}
]

teachers_section = {"name": "1. Teachers", "item": []}
for teacher in teachers_data:
    teachers_section["item"].append({
        "name": f"Create Teacher - {teacher['specialization']}",
        "request": {
            "method": "POST",
            "header": [{"key": "Content-Type", "value": "application/json"}],
            "body": {"mode": "raw", "raw": json.dumps(teacher)},
            "url": {"raw": "{{base_url}}/api/teachers", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "teachers"]}
        }
    })
teachers_section["item"].append({
    "name": "Get All Teachers",
    "request": {"method": "GET", "header": [], "url": {"raw": "{{base_url}}/api/teachers", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "teachers"]}}
})
collection["item"].append(teachers_section)

# Classrooms
classrooms_data = [
    {"code": "AULA101", "building": "Edificio A", "floor": 1, "capacity": 40, "equipments": ["Proyector", "Pizarra Inteligente", "Computadora"], "hasProjector": True, "hasAirConditioning": True},
    {"code": "AULA102", "building": "Edificio A", "floor": 1, "capacity": 35, "equipments": ["Proyector", "Pizarra"], "hasProjector": True, "hasAirConditioning": True},
    {"code": "AULA201", "building": "Edificio B", "floor": 2, "capacity": 40, "equipments": ["Proyector", "Pizarra Inteligente", "Laboratorio"], "hasProjector": True, "hasAirConditioning": True}
]

classrooms_section = {"name": "2. Classrooms", "item": []}
for classroom in classrooms_data:
    classrooms_section["item"].append({
        "name": f"Create Classroom - {classroom['code']}",
        "request": {
            "method": "POST",
            "header": [{"key": "Content-Type", "value": "application/json"}],
            "body": {"mode": "raw", "raw": json.dumps(classroom)},
            "url": {"raw": "{{base_url}}/api/classrooms", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "classrooms"]}
        }
    })
classrooms_section["item"].append({
    "name": "Get All Classrooms",
    "request": {"method": "GET", "header": [], "url": {"raw": "{{base_url}}/api/classrooms", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "classrooms"]}}
})
collection["item"].append(classrooms_section)

# Subjects
subjects_data = [
    {"code": "MAT101", "name": "Matemáticas I", "description": "Álgebra y Geometría básica", "credits": 4, "targetGrade": "GRADE_10", "teacherId": "TEACH001", "schedules": [], "active": True},
    {"code": "MAT102", "name": "Matemáticas II", "description": "Cálculo y Trigonometría", "credits": 4, "targetGrade": "GRADE_11", "teacherId": "TEACH001", "schedules": [], "active": True},
    {"code": "ESP101", "name": "Español I", "description": "Literatura y Composición", "credits": 3, "targetGrade": "GRADE_10", "teacherId": "TEACH002", "schedules": [], "active": True},
    {"code": "ESP102", "name": "Español II", "description": "Análisis Crítico y Redacción", "credits": 3, "targetGrade": "GRADE_11", "teacherId": "TEACH002", "schedules": [], "active": True},
    {"code": "ENG101", "name": "English I", "description": "Gramática y Conversación Básica", "credits": 3, "targetGrade": "GRADE_10", "teacherId": "TEACH003", "schedules": [], "active": True},
    {"code": "ENG102", "name": "English II", "description": "Escritura y Literatura en Inglés", "credits": 3, "targetGrade": "GRADE_11", "teacherId": "TEACH003", "schedules": [], "active": True},
    {"code": "BIO101", "name": "Biología I", "description": "Célula y Genética", "credits": 4, "targetGrade": "GRADE_10", "teacherId": "TEACH004", "schedules": [], "active": True},
    {"code": "CHEM101", "name": "Química I", "description": "Estructura Atómica y Reacciones", "credits": 4, "targetGrade": "GRADE_11", "teacherId": "TEACH004", "schedules": [], "active": True}
]

subjects_section = {"name": "3. Subjects", "item": []}
for subject in subjects_data:
    subjects_section["item"].append({
        "name": f"Create Subject - {subject['code']}",
        "request": {
            "method": "POST",
            "header": [{"key": "Content-Type", "value": "application/json"}],
            "body": {"mode": "raw", "raw": json.dumps(subject)},
            "url": {"raw": "{{base_url}}/api/subjects", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "subjects"]}
        }
    })
subjects_section["item"].append({
    "name": "Get All Subjects",
    "request": {"method": "GET", "header": [], "url": {"raw": "{{base_url}}/api/subjects", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "subjects"]}}
})
collection["item"].append(subjects_section)

# Students Grade 10
students_g10_names = [
    ("Juan", "Pérez García"), ("María", "López Martínez"), ("Carlos", "Rodríguez Sánchez"),
    ("Ana", "Fernández Gómez"), ("David", "Morales Ruiz"), ("Laura", "Jiménez Castro"),
    ("Roberto", "Díaz López"), ("Patricia", "Vargas Flores"), ("Miguel", "Ramírez Herrera"),
    ("Sofía", "Gutiérrez Mendoza"), ("Francisco", "Navarro Reyes"), ("Valentina", "Soto Vega"),
    ("Andrés", "Castro Molina"), ("Camila", "Ortiz Domínguez"), ("Javier", "Ponce Acuña")
]

students_g10_section = {"name": "4. Students Grade 10", "item": []}
for idx, (name, lastname) in enumerate(students_g10_names, 1):
    student_id = f"STU10{idx:03d}"
    id_num = f"ID{idx:03d}"
    student = {
        "id": id_num,
        "name": name,
        "lastName": lastname,
        "email": f"{name.lower()}.{lastname.split()[0].lower()}@school.edu",
        "phone": f"300123450{idx}",
        "birthDate": f"2008-{(idx % 12) + 1:02d}-{(idx * 2) % 28 + 1:02d}",
        "gender": "MALE" if idx % 2 == 1 else "FEMALE",
        "address": f"Calle {idx} #{idx*5}-{idx*10}",
        "active": True,
        "studentId": student_id,
        "grade": "GRADE_10",
        "enrolledSubjects": [],
        "grades": []
    }
    students_g10_section["item"].append({
        "name": f"{student_id} - {name} {lastname}",
        "request": {
            "method": "POST",
            "header": [{"key": "Content-Type", "value": "application/json"}],
            "body": {"mode": "raw", "raw": json.dumps(student)},
            "url": {"raw": "{{base_url}}/api/students", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "students"]}
        }
    })
students_g10_section["item"].append({
    "name": "Get All Students G10",
    "request": {"method": "GET", "header": [], "url": {"raw": "{{base_url}}/api/students", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "students"]}}
})
collection["item"].append(students_g10_section)

# Students Grade 11
students_g11_names = [
    ("Alejandro", "Ruiz Campos"), ("Gabriela", "Torres Silva"), ("Mateo", "González Peña"),
    ("Isabela", "Rojas Medina"), ("Nicolás", "Sánchez Vázquez"), ("Daniela", "Fuentes Herrera"),
    ("Cristian", "Mendoza López"), ("Valeria", "Acosta García"), ("Sergio", "Flores Ramírez"),
    ("Martina", "Núñez Castillo"), ("Diego", "Varela Soto"), ("Catalina", "Reyes Domínguez"),
    ("Pablo", "Ibáñez Moreno"), ("Lucía", "Delgado Vega"), ("Tomás", "Espinoza Navarro")
]

students_g11_section = {"name": "5. Students Grade 11", "item": []}
for idx, (name, lastname) in enumerate(students_g11_names, 1):
    student_id = f"STU11{idx:03d}"
    id_num = f"ID{15 + idx:03d}"
    student = {
        "id": id_num,
        "name": name,
        "lastName": lastname,
        "email": f"{name.lower()}.{lastname.split()[0].lower()}@school.edu",
        "phone": f"300123451{idx}",
        "birthDate": f"2007-{(idx % 12) + 1:02d}-{(idx * 2) % 28 + 1:02d}",
        "gender": "MALE" if idx % 2 == 1 else "FEMALE",
        "address": f"Calle {15 + idx} #{(15 + idx)*5}-{(15 + idx)*10}",
        "active": True,
        "studentId": student_id,
        "grade": "GRADE_11",
        "enrolledSubjects": [],
        "grades": []
    }
    students_g11_section["item"].append({
        "name": f"{student_id} - {name} {lastname}",
        "request": {
            "method": "POST",
            "header": [{"key": "Content-Type", "value": "application/json"}],
            "body": {"mode": "raw", "raw": json.dumps(student)},
            "url": {"raw": "{{base_url}}/api/students", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "students"]}
        }
    })
students_g11_section["item"].append({
    "name": "Get All Students G11",
    "request": {"method": "GET", "header": [], "url": {"raw": "{{base_url}}/api/students", "protocol": "http", "host": ["{{base_url}}"], "path": ["api", "students"]}}
})
collection["item"].append(students_g11_section)

# Save to file
output_path = "src/main/resources/School_API_Complete.json"
with open(output_path, 'w', encoding='utf-8') as f:
    json.dump(collection, f, indent=2, ensure_ascii=False)

print(f"[OK] Coleccion de Postman generada: {output_path}")
print(f"  - 4 Profesores")
print(f"  - 3 Aulas")
print(f"  - 8 Asignaturas")
print(f"  - 30 Estudiantes (15 Grado 10 + 15 Grado 11)")
