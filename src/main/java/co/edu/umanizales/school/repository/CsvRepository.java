package co.edu.umanizales.school.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface for CSV-based persistence operations
 */
public interface CsvRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    T update(ID id, T entity);
    void delete(ID id);
    void loadFromCsv();
    void saveToCsv();
}
