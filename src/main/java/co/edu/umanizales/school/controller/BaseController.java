package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class BaseController<T, ID> {
    protected abstract BaseService<T, ID> getService();

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optional = getService().findById(id);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Resource not found with id: " + id);
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T saved = getService().save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        T updated = getService().update(id, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
