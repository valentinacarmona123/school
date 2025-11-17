package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeRecord {
    private String id;
    private Student student;
    private Subject subject;
    private double score;
    private LocalDate date;
    private GradeType type;
    private String comments;

    public boolean isPassing() {
        return score >= 3.0; // Passing grade is 3.0 or higher (on a 0-5 scale)
    }

    public String getLetterGrade() {
        if (score >= 4.5) return "A";
        if (score >= 4.0) return "B";
        if (score >= 3.0) return "C";
        if (score >= 2.0) return "D";
        return "F";
    }

    public void setStudentId(String s) {
        if (s == null || s.trim().isEmpty()) {
            this.student = null;
            return;
        }
        if (this.student == null) {
            this.student = new Student();
        }
        this.student.setStudentId(s);
    }

    public void setSubjectCode(String s) {
        if (s == null || s.trim().isEmpty()) {
            this.subject = null;
            return;
        }
        if (this.subject == null) {
            this.subject = new Subject();
        }
        this.subject.setCode(s);
    }

    public String getStudentId() {
        return this.student != null ? this.student.getStudentId() : null;
    }

    public String getSubjectCode() {
        return this.subject != null ? this.subject.getCode() : null;
    }

    public void setGradeType(GradeType gradeType) {
        this.type = gradeType;
    }

    public GradeType getGradeType() {
        return this.type;
    }


}
