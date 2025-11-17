package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.Teacher;
import co.edu.umanizales.school.repository.TeacherCsvRepository;
import co.edu.umanizales.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherCsvRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherCsvRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(String id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(String id, Teacher teacher) {
        return teacherRepository.update(id, teacher);
    }

    @Override
    public void delete(String id) {
        teacherRepository.delete(id);
    }
}
