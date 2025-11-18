package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate; //clase que representa una fecha

@Data //genera getters and setters y el toString
@NoArgsConstructor //constructor vacio
@AllArgsConstructor//constructor con todos los atributos
public class GradeRecord { //clase que representa un registro de calificacion
    private String id;
    private Student student;
    private Subject subject;
    private double score;
    private LocalDate date;
    private GradeType type;
    private String comments;

    //verifica si la nota pasa
    public boolean isPassing() {
        return score >= 3.0; // Passing grade is 3.0 or higher (on a 0-5 scale)
    }

    //convierte la nota en una letra
    public String getLetterGrade() {
        if (score >= 4.5) return "A";
        if (score >= 4.0) return "B";
        if (score >= 3.0) return "C";
        if (score >= 2.0) return "D";
        return "F";
    }

//si mandan id vacio, se pone null
    public void setStudentId(String s) {
        if (s == null || s.trim().isEmpty()) { //s>quita los espacios vacios, is>mira que no quede vacio despues de mirar espacios
            this.student = null;
            return;
        }
        if (this.student == null) { //si no esta creado, lo crea
            this.student = new Student();
        }
        this.student.setStudentId(s); //asigno id
    }

    //lo mismo que estudiante pero con la materia
    public void setSubjectCode(String s) {
        if (s == null || s.trim().isEmpty()) { //s>quita los espacios vacios, is>mira que no quede vacio despues de mirar espacios
            this.subject = null;
            return;
        }
        if (this.subject == null) {
            this.subject = new Subject();
        }
        this.subject.setCode(s);
    }

    //si el estudiante no esta creado, retorna null
    public String getStudentId() {
        return this.student != null ? this.student.getStudentId() : null;
    }

    //si la materia no esta creada, retorna null
    public String getSubjectCode() {
        return this.subject != null ? this.subject.getCode() : null;
    }
//asignar el tipo de nota
    public void setGradeType(GradeType gradeType) {
        this.type = gradeType;
    }
//retorna el tipo de nota
    public GradeType getGradeType() {
        return this.type;
    }


}
