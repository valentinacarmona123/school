package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.GradeRecord;
import co.edu.umanizales.school.model.GradeType;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Repository
public class GradeRecordCsvRepository implements CsvRepository<GradeRecord, String> {
    private final String CSV_FILE_PATH = "data/grade_records.csv";
    private final Map<String, GradeRecord> gradeRecords = new HashMap<>();

    public GradeRecordCsvRepository() {
        loadFromCsv();
    }

    @Override
    public List<GradeRecord> findAll() {
        return new ArrayList<>(gradeRecords.values());
    }

    @Override
    public Optional<GradeRecord> findById(String id) {
        return Optional.ofNullable(gradeRecords.get(id));
    }

    @Override
    public GradeRecord save(GradeRecord gradeRecord) {
        if (gradeRecord.getId() == null || gradeRecord.getId().isEmpty()) {
            throw new IllegalArgumentException("GradeRecord ID is required");
        }
        gradeRecords.put(gradeRecord.getId(), gradeRecord);
        saveToCsv();
        return gradeRecord;
    }

    @Override
    public GradeRecord update(String id, GradeRecord gradeRecord) {
        if (!gradeRecords.containsKey(id)) {
            throw new NoSuchElementException("GradeRecord not found with id: " + id);
        }
        if (!id.equals(gradeRecord.getId())) {
            throw new IllegalArgumentException("ID in path does not match grade record ID");
        }
        gradeRecords.put(id, gradeRecord);
        saveToCsv();
        return gradeRecord;
    }

    @Override
    public void delete(String id) {
        if (!gradeRecords.containsKey(id)) {
            throw new NoSuchElementException("GradeRecord not found with id: " + id);
        }
        gradeRecords.remove(id);
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
                if (line.length >= 5) {
                    GradeRecord gradeRecord = new GradeRecord();
                    gradeRecord.setId(line[0]);
                    gradeRecord.setStudentId(line[1]);
                    gradeRecord.setSubjectCode(line[2]);
                    gradeRecord.setGradeType(GradeType.fromCode(line[3]));
                    gradeRecord.setScore(Double.parseDouble(line[4]));
                    if (line.length > 5) {
                        gradeRecord.setDate(LocalDate.parse(line[5]));
                    }
                    gradeRecords.put(gradeRecord.getId(), gradeRecord);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading grade records from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"id", "studentId", "subjectCode", "gradeType", "score", "date"};
            writer.writeNext(header);

            for (GradeRecord gradeRecord : gradeRecords.values()) {
                String[] data = {
                    gradeRecord.getId(),
                    gradeRecord.getStudentId(),
                    gradeRecord.getSubjectCode(),
                    gradeRecord.getGradeType().getCode(),
                    String.valueOf(gradeRecord.getScore()),
                    gradeRecord.getDate() != null ? gradeRecord.getDate().toString() : ""
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving grade records to CSV: " + e.getMessage());
        }
    }
}
