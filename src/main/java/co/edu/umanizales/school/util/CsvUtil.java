package co.edu.umanizales.school.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    
    private CsvUtil() {
        // Private constructor to prevent instantiation
    }
    
    public static <T> List<T> readFromCsv(InputStream inputStream, Class<T> clazz) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
    }
    
    public static <T> List<T> readFromCsv(String filePath, Class<T> clazz) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
    }
    
    public static <T> void writeToCsv(String filePath, List<T> items, Class<T> clazz) throws IOException, CsvException {
        Path path = Paths.get(filePath);
        Path parentDir = path.getParent();
        
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
        
        try (Writer writer = Files.newBufferedWriter(path)) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(items);
        }
    }
    
    public static <T> void appendToCsv(String filePath, T item, Class<T> clazz) throws IOException, CsvException {
        List<T> items = new ArrayList<>();
        if (Files.exists(Paths.get(filePath))) {
            items = readFromCsv(filePath, clazz);
        }
        items.add(item);
        writeToCsv(filePath, items, clazz);
    }
    
    public static <T, ID> void deleteFromCsv(String filePath, ID id, Class<T> clazz, java.util.function.Predicate<T> predicate) 
            throws IOException, CsvException {
        List<T> items = readFromCsv(filePath, clazz);
        items.removeIf(predicate);
        writeToCsv(filePath, items, clazz);
    }
    
    public static <T, ID> void updateInCsv(String filePath, ID id, T updatedItem, Class<T> clazz, 
                                         java.util.function.Predicate<T> predicate) 
            throws IOException, CsvException {
        List<T> items = readFromCsv(filePath, clazz);
        boolean found = false;
        
        for (int i = 0; i < items.size(); i++) {
            if (predicate.test(items.get(i))) {
                items.set(i, updatedItem);
                found = true;
                break;
            }
        }
        
        if (found) {
            writeToCsv(filePath, items, clazz);
        }
    }
}
