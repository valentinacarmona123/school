package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.Subject;
import co.edu.umanizales.school.repository.SubjectCsvRepository;
import co.edu.umanizales.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectCsvRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectCsvRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(String id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(String id, Subject subject) {
        return subjectRepository.update(id, subject);
    }

    @Override
    public void delete(String id) {
        subjectRepository.delete(id);
    }
}
