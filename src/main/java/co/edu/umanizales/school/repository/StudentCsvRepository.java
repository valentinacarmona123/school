package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.Gender;
import co.edu.umanizales.school.model.Grade;
import co.edu.umanizales.school.model.Student;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Repository
public class StudentCsvRepository implements CsvRepository<Student, String> {
    private final String CSV_FILE_PATH = "data/students.csv";
    private final Map<String, Student> students = new HashMap<>();

    public StudentCsvRepository() {
        loadFromCsv();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Student save(Student student) {
        if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
            throw new IllegalArgumentException("Student ID is required");
        }
        students.put(student.getStudentId(), student);
        saveToCsv();
        return student;
    }

    @Override
    public Student update(String id, Student student) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        if (!id.equals(student.getStudentId())) {
            throw new IllegalArgumentException("ID in path does not match student ID");
        }
        students.put(id, student);
        saveToCsv();
        return student;
    }

    @Override
    public void delete(String id) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        students.remove(id);
        saveToCsv();
    }

    @Override
    public void loadFromCsv() {
        File file = new File(CSV_FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] line;
            boolean isFirstLine = true;
            while ((line = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                if (line.length >= 11) {
                    Student student = new Student();
                    student.setId(line[0]);
                    student.setName(line[1]);
                    student.setLastName(line[2]);
                    student.setEmail(line[3]);
                    student.setPhone(line[4]);
                    student.setBirthDate(LocalDate.parse(line[5]));
                    student.setGender(Gender.valueOf(line[6]));
                    student.setAddress(line[7]);
                    student.setActive(Boolean.parseBoolean(line[8]));
                    student.setStudentId(line[9]);
                    student.setGrade(Grade.fromText(line[10]));
                    students.put(student.getStudentId(), student);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading students from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"id", "name", "lastName", "email", "phone", "birthDate", "gender", "address", "active", "studentId", "grade"};
            writer.writeNext(header);

            for (Student student : students.values()) {
                String[] data = {
                    student.getId(),
                    student.getName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getPhone(),
                    student.getBirthDate().toString(),
                    student.getGender().toString(),
                    student.getAddress(),
                    String.valueOf(student.isActive()),
                    student.getStudentId(),
                    student.getGrade().toString()
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving students to CSV: " + e.getMessage());
        }
    }
}
