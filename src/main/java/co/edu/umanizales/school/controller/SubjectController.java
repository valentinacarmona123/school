package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.model.Subject;
import co.edu.umanizales.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<java.util.List<Subject>> getAll() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Subject> getById(@PathVariable String code) {
        Subject entity = subjectService.findById(code).orElse(null);
        if (entity == null) {
            throw new java.util.NoSuchElementException("Resource not found with id: " + code);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody Subject entity) {
        Subject saved = subjectService.save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Subject> update(@PathVariable String code, @RequestBody Subject entity) {
        Subject updated = subjectService.update(code, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        subjectService.delete(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
