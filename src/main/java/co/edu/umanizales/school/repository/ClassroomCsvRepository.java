package co.edu.umanizales.school.repository;

import co.edu.umanizales.school.model.Classroom;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository
public class ClassroomCsvRepository implements CsvRepository<Classroom, String> {
    private final String CSV_FILE_PATH = "data/classrooms.csv";
    private final Map<String, Classroom> classrooms = new HashMap<>();

    public ClassroomCsvRepository() {
        loadFromCsv();
    }

    @Override
    public List<Classroom> findAll() {
        return new ArrayList<>(classrooms.values());
    }

    @Override
    public Optional<Classroom> findById(String id) {
        return Optional.ofNullable(classrooms.get(id));
    }

    @Override
    public Classroom save(Classroom classroom) {
        if (classroom.getCode() == null || classroom.getCode().isEmpty()) {
            throw new IllegalArgumentException("Classroom code is required");
        }
        classrooms.put(classroom.getCode(), classroom);
        saveToCsv();
        return classroom;
    }

    @Override
    public Classroom update(String id, Classroom classroom) {
        if (!classrooms.containsKey(id)) {
            throw new NoSuchElementException("Classroom not found with code: " + id);
        }
        if (!id.equals(classroom.getCode())) {
            throw new IllegalArgumentException("Code in path does not match classroom code");
        }
        classrooms.put(id, classroom);
        saveToCsv();
        return classroom;
    }

    @Override
    public void delete(String id) {
        if (!classrooms.containsKey(id)) {
            throw new NoSuchElementException("Classroom not found with code: " + id);
        }
        classrooms.remove(id);
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
                    Classroom classroom = new Classroom();
                    classroom.setCode(line[0]);
                    classroom.setBuilding(line[1]);
                    classroom.setFloor(Integer.parseInt(line[2]));
                    classroom.setCapacity(Integer.parseInt(line[3]));
                    classroom.setHasProjector(Boolean.parseBoolean(line[4]));
                    classroom.setHasAirConditioning(Boolean.parseBoolean(line[5]));
                    
                    if (line.length > 6 && !line[6].isEmpty()) {
                        String[] equipments = line[6].split(";");
                        classroom.setEquipments(Arrays.asList(equipments));
                    }
                    classrooms.put(classroom.getCode(), classroom);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error loading classrooms from CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveToCsv() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
            String[] header = {"code", "building", "floor", "capacity", "hasProjector", "hasAirConditioning", "equipments"};
            writer.writeNext(header);

            for (Classroom classroom : classrooms.values()) {
                String equipmentsStr = classroom.getEquipments() != null ? 
                    String.join(";", classroom.getEquipments()) : "";
                
                String[] data = {
                    classroom.getCode(),
                    classroom.getBuilding(),
                    String.valueOf(classroom.getFloor()),
                    String.valueOf(classroom.getCapacity()),
                    String.valueOf(classroom.isHasProjector()),
                    String.valueOf(classroom.isHasAirConditioning()),
                    equipmentsStr
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.err.println("Error saving classrooms to CSV: " + e.getMessage());
        }
    }
}
