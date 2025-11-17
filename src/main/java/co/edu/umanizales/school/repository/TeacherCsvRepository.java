package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.Gender;
import co.edu.umanizales.school.model.Teacher;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Repository
public class TeacherCsvRepository implements CsvRepository<Teacher, String> {
    private final String CSV_FILE_PATH = "data/teachers.csv";
    private final Map<String, Teacher> teachers = new HashMap<>();

    public TeacherCsvRepository() {
        loadFromCsv();
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teachers.values());
    }

    @Override
    public Optional<Teacher> findById(String id) {
        return Optional.ofNullable(teachers.get(id));
    }

    @Override
    public Teacher save(Teacher teacher) {
        if (teacher.getTeacherId() == null || teacher.getTeacherId().isEmpty()) {
            throw new IllegalArgumentException("Teacher ID is required");
        }
        teachers.put(teacher.getTeacherId(), teacher);
        saveToCsv();
        return teacher;
    }

    @Override
    public Teacher update(String id, Teacher teacher) {
        if (!teachers.containsKey(id)) {
            throw new NoSuchElementException("Teacher not found with id: " + id);
        }
        if (!id.equals(teacher.getTeacherId())) {
            throw new IllegalArgumentException("ID in path does not match teacher ID");
        }
        teachers.put(id, teacher);
        saveToCsv();
        return teacher;
    }

    @Override
    public void delete(String id) {
        if (!teachers.containsKey(id)) {
            throw new NoSuchElementException("Teacher not found with id: " + id);
        }
        teachers.remove(id);
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
                if (line.length >= 12) {
                    Teacher teacher = new Teacher();
                    teacher.setId(line[0]);
                    teacher.setName(line[1]);
                    teacher.setLastName(line[2]);
                    teacher.setEmail(line[3]);
                    teacher.setPhone(line[4]);
                    teacher.setBirthDate(LocalDate.parse(line[5]));
                    teacher.setGender(Gender.valueOf(line[6]));
                    teacher.setAddress(line[7]);
                    teacher.setActive(Boolean.parseBoolean(line[8]));
                    teacher.setTeacherId(line[9]);
                    teacher.setSpecialization(line[10]);
                    teacher.setFullTime(Boolean.parseBoolean(line[11]));
                    if (line.length > 12) {
                        teacher.setSalary(Double.parseDouble(line[12]));
                    }
                    teachers.put(teacher.getTeacherId(), teacher);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading teachers from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"id", "name", "lastName", "email", "phone", "birthDate", "gender", "address", "active", "teacherId", "specialization", "fullTime", "salary"};
            writer.writeNext(header);

            for (Teacher teacher : teachers.values()) {
                String[] data = {
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getLastName(),
                    teacher.getEmail(),
                    teacher.getPhone(),
                    teacher.getBirthDate().toString(),
                    teacher.getGender().toString(),
                    teacher.getAddress(),
                    String.valueOf(teacher.isActive()),
                    teacher.getTeacherId(),
                    teacher.getSpecialization(),
                    String.valueOf(teacher.isFullTime()),
                    String.valueOf(teacher.getSalary())
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving teachers to CSV: " + e.getMessage());
        }
    }
}
