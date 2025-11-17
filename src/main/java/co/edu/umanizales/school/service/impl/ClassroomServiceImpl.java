package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.Classroom;
import co.edu.umanizales.school.repository.ClassroomCsvRepository;
import co.edu.umanizales.school.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomCsvRepository classroomRepository;

    @Autowired
    public ClassroomServiceImpl(ClassroomCsvRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(String id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom update(String id, Classroom classroom) {
        return classroomRepository.update(id, classroom);
    }

    @Override
    public void delete(String id) {
        classroomRepository.delete(id);
    }
}
