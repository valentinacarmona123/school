package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.model.GradeRecord;
import co.edu.umanizales.school.service.GradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade-records")
public class GradeRecordController {

    private final GradeRecordService gradeRecordService;

    @Autowired
    public GradeRecordController(GradeRecordService gradeRecordService) {
        this.gradeRecordService = gradeRecordService;
    }

    @GetMapping
    public ResponseEntity<java.util.List<GradeRecord>> getAll() {
        return new ResponseEntity<>(gradeRecordService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeRecord> getById(@PathVariable String id) {
        GradeRecord entity = gradeRecordService.findById(id).orElse(null);
        if (entity == null) {
            throw new java.util.NoSuchElementException("Resource not found with id: " + id);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GradeRecord> create(@RequestBody GradeRecord entity) {
        GradeRecord saved = gradeRecordService.save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeRecord> update(@PathVariable String id, @RequestBody GradeRecord entity) {
        GradeRecord updated = gradeRecordService.update(id, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        gradeRecordService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
