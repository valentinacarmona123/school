package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.model.Classroom;
import co.edu.umanizales.school.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<java.util.List<Classroom>> getAll() {
        return new ResponseEntity<>(classroomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Classroom> getById(@PathVariable String code) {
        Classroom entity = classroomService.findById(code).orElse(null);
        if (entity == null) {
            throw new java.util.NoSuchElementException("Resource not found with id: " + code);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Classroom> create(@RequestBody Classroom entity) {
        Classroom saved = classroomService.save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Classroom> update(@PathVariable String code, @RequestBody Classroom entity) {
        Classroom updated = classroomService.update(code, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        classroomService.delete(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
