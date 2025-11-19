package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.Grade;
import co.edu.umanizales.school.model.Subject;
import co.edu.umanizales.school.model.Teacher;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository
public class SubjectCsvRepository implements CsvRepository<Subject, String> {
    private final String CSV_FILE_PATH = "data/subjects.csv";
    private final Map<String, Subject> subjects = new HashMap<>();
    private final TeacherCsvRepository teacherRepository;

    public SubjectCsvRepository(TeacherCsvRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        loadFromCsv();
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects.values());
    }

    @Override
    public Optional<Subject> findById(String id) {
        return Optional.ofNullable(subjects.get(id));
    }

    @Override
    public Subject save(Subject subject) {
        if (subject.getCode() == null || subject.getCode().isEmpty()) {
            throw new IllegalArgumentException("Subject code is required");
        }
        subjects.put(subject.getCode(), subject);
        saveToCsv();
        return subject;
    }

    @Override
    public Subject update(String id, Subject subject) {
        if (!subjects.containsKey(id)) {
            throw new NoSuchElementException("Subject not found with code: " + id);
        }
        if (!id.equals(subject.getCode())) {
            throw new IllegalArgumentException("Code in path does not match subject code");
        }
        subjects.put(id, subject);
        saveToCsv();
        return subject;
    }

    @Override
    public void delete(String id) {
        if (!subjects.containsKey(id)) {
            throw new NoSuchElementException("Subject not found with code: " + id);
        }
        subjects.remove(id);
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
                if (line.length >= 7) {
                    Subject subject = new Subject();
                    subject.setCode(line[0]);
                    subject.setName(line[1]);
                    subject.setDescription(line[2]);
                    subject.setCredits(Integer.parseInt(line[3]));
                    subject.setTargetGrade(Grade.fromText(line[4]));
                    String teacherId = line[5];
                    Teacher teacher = teacherRepository.findById(teacherId).orElseGet(() -> {
                        Teacher t = new Teacher();
                        t.setTeacherId(teacherId);
                        return t;
                    });
                    subject.setTeacher(teacher);
                    subject.setActive(Boolean.parseBoolean(line[6]));
                    subjects.put(subject.getCode(), subject);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading subjects from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"code", "name", "description", "credits", "targetGrade", "teacherId", "active"};
            writer.writeNext(header);

            for (Subject subject : subjects.values()) {
                String[] data = {
                    subject.getCode(),
                    subject.getName(),
                    subject.getDescription() != null ? subject.getDescription() : "",
                    String.valueOf(subject.getCredits()),
                    subject.getTargetGrade().toString(),
                    subject.getTeacher() != null ? subject.getTeacher().getTeacherId() : "",
                    String.valueOf(subject.isActive())
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving subjects to CSV: " + e.getMessage());
        }
    }
}
