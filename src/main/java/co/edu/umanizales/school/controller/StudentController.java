package co.edu.umanizales.school.controller;

import co.edu.umanizales.school.model.Student;
import co.edu.umanizales.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.umanizales.school.dto.DetalleEstadoDTO;
import co.edu.umanizales.school.dto.DiaReporteDTO;
import co.edu.umanizales.school.dto.ReporteEstudiantesDTO;
import co.edu.umanizales.school.dto.ReporteEstudiantesWrapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<java.util.List<Student>> getAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        Student entity = studentService.findById(id).orElse(null);
        if (entity == null) {
            throw new java.util.NoSuchElementException("Resource not found with id: " + id);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student entity) {
        Student saved = studentService.save(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable String id, @RequestBody Student entity) {
        Student updated = studentService.update(id, entity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/report")
    public ResponseEntity<ReporteEstudiantesWrapper> getReport(
            @RequestParam("fechaInicial") String fechaInicial,
            @RequestParam("fechaFinal") String fechaFinal
    ) {
        LocalDate start = LocalDate.parse(fechaInicial);
        LocalDate end = LocalDate.parse(fechaFinal);

        List<Student> students = studentService.findAll();
        int activos = (int) students.stream().filter(Student::isActive).count();
        int noActivos = (int) students.stream().filter(s -> !s.isActive()).count();
        int total = activos + noActivos;

        List<DiaReporteDTO> dias = new ArrayList<>();
        for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
            List<DetalleEstadoDTO> detalle = Arrays.asList(
                    new DetalleEstadoDTO("Activo", activos),
                    new DetalleEstadoDTO("No activo", noActivos)
            );
            dias.add(new DiaReporteDTO(d, total, detalle));
        }

        ReporteEstudiantesDTO reporte = new ReporteEstudiantesDTO(start, end, dias);
        ReporteEstudiantesWrapper wrapper = new ReporteEstudiantesWrapper(reporte);
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
