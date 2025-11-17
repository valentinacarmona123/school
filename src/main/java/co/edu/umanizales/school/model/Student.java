package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
    private String studentId;
    private Grade grade;
    private List<Subject> enrolledSubjects = new ArrayList<>();
    private List<GradeRecord> grades = new ArrayList<>();

    public Student(String id, String name, String lastName, String email, String phone, 
                  LocalDate birthDate, Gender gender, String address, boolean active, 
                  String studentId, Grade grade) {
        super(id, name, lastName, email, phone, birthDate, gender, address, active);
        this.studentId = studentId;
        this.grade = grade;
    }

    public void enrollSubject(Subject subject) {
        if (!enrolledSubjects.contains(subject)) {
            enrolledSubjects.add(subject);
        }
    }

    public void addGrade(GradeRecord grade) {
        this.grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        int count = 0;
        for (GradeRecord grade : grades) {
            total += grade.getScore();
            count++;
        }
        if (count == 0) {
            return 0.0;
        }
        return total / count;
    }
}
