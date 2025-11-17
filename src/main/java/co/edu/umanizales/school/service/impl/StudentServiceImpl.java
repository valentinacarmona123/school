package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.Student;
import co.edu.umanizales.school.repository.StudentCsvRepository;
import co.edu.umanizales.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentCsvRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentCsvRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(String id, Student student) {
        return studentRepository.update(id, student);
    }

    @Override
    public void delete(String id) {
        studentRepository.delete(id);
    }
}
