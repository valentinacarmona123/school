package co.edu.umanizales.school.service.impl;

import co.edu.umanizales.school.model.Schedule;
import co.edu.umanizales.school.repository.ScheduleCsvRepository;
import co.edu.umanizales.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleCsvRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleCsvRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> findById(String id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(String id, Schedule schedule) {
        return scheduleRepository.update(id, schedule);
    }

    @Override
    public void delete(String id) {
        scheduleRepository.delete(id);
    }
}
