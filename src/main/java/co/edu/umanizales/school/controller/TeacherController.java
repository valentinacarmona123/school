package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.model.Teacher;
import co.edu.umanizales.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<java.util.List<Teacher>> getAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable String id) {
        Teacher entity = teacherService.findById(id).orElse(null);
        if (entity == null) {
            throw new java.util.NoSuchElementException("Resource not found with id: " + id);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody Teacher entity) {
        Teacher saved = teacherService.save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable String id, @RequestBody Teacher entity) {
        // Alinear el ID del path con el body para evitar 500 por desajuste
        if (entity.getTeacherId() == null || entity.getTeacherId().trim().isEmpty()) {
            entity.setTeacherId(id);
        } else if (!id.equals(entity.getTeacherId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Teacher updated = teacherService.update(id, entity);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (java.util.NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
