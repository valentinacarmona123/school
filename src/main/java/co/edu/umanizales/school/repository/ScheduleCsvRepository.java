package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.Schedule;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

@Repository
public class ScheduleCsvRepository implements CsvRepository<Schedule, String> {
    private final String CSV_FILE_PATH = "data/schedules.csv";
    private final Map<String, Schedule> schedules = new HashMap<>();
    private final ClassroomCsvRepository classroomRepository;

    @Autowired
    public ScheduleCsvRepository(ClassroomCsvRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
        loadFromCsv();
    }

    @Override
    public List<Schedule> findAll() {
        return new ArrayList<>(schedules.values());
    }

    @Override
    public Optional<Schedule> findById(String id) {
        return Optional.ofNullable(schedules.get(id));
    }

    @Override
    public Schedule save(Schedule schedule) {
        if (schedule.getId() == null || schedule.getId().isEmpty()) {
            throw new IllegalArgumentException("Schedule ID is required");
        }
        schedules.put(schedule.getId(), schedule);
        saveToCsv();
        return schedule;
    }

    @Override
    public Schedule update(String id, Schedule schedule) {
        if (!schedules.containsKey(id)) {
            throw new NoSuchElementException("Schedule not found with id: " + id);
        }
        if (!id.equals(schedule.getId())) {
            throw new IllegalArgumentException("ID in path does not match schedule ID");
        }
        schedules.put(id, schedule);
        saveToCsv();
        return schedule;
    }

    @Override
    public void delete(String id) {
        if (!schedules.containsKey(id)) {
            throw new NoSuchElementException("Schedule not found with id: " + id);
        }
        schedules.remove(id);
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
                // Expected columns: id, classroomCode, dayOfWeek, startTime, endTime
                if (line.length >= 5) {
                    Schedule schedule = new Schedule();
                    schedule.setId(line[0]);
                    String classroomCode = line[1];
                    classroomRepository.findById(classroomCode)
                            .ifPresent(schedule::setClassroom);
                    schedule.setDayOfWeek(DayOfWeek.valueOf(line[2]));
                    schedule.setStartTime(LocalTime.parse(line[3]));
                    schedule.setEndTime(LocalTime.parse(line[4]));
                    schedules.put(schedule.getId(), schedule);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading schedules from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"id", "classroomCode", "dayOfWeek", "startTime", "endTime"};
            writer.writeNext(header);

            for (Schedule schedule : schedules.values()) {
                String classroomCode = schedule.getClassroom() != null ? schedule.getClassroom().getCode() : "";
                String[] data = {
                    schedule.getId(),
                    classroomCode,
                    schedule.getDayOfWeek().toString(),
                    schedule.getStartTime().toString(),
                    schedule.getEndTime().toString()
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving schedules to CSV: " + e.getMessage());
        }
    }
}
