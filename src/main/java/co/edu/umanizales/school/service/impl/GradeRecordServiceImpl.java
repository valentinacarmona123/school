package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.GradeRecord;
import co.edu.umanizales.school.repository.GradeRecordCsvRepository;
import co.edu.umanizales.school.service.GradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GradeRecordServiceImpl implements GradeRecordService {
    private final GradeRecordCsvRepository gradeRecordRepository;

    @Autowired
    public GradeRecordServiceImpl(GradeRecordCsvRepository gradeRecordRepository) {
        this.gradeRecordRepository = gradeRecordRepository;
    }

    @Override
    public List<GradeRecord> findAll() {
        return gradeRecordRepository.findAll();
    }

    @Override
    public Optional<GradeRecord> findById(String id) {
        return gradeRecordRepository.findById(id);
    }

    @Override
    public GradeRecord save(GradeRecord gradeRecord) {
        return gradeRecordRepository.save(gradeRecord);
    }

    @Override
    public GradeRecord update(String id, GradeRecord gradeRecord) {
        return gradeRecordRepository.update(id, gradeRecord);
    }

    @Override
    public void delete(String id) {
        gradeRecordRepository.delete(id);
    }
}
