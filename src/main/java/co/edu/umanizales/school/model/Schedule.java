package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private String id;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Classroom classroom;

    //over>sirve para saber si dos horarios se cruzan
    public boolean overlapsWith(Schedule other) {
        return false;
    }

    public void setSubjectCode(String s) { //vacio por si se quiere asignar una materia por su codigo
    }

    public void setClassroomCode(String s) { //vacio por si se quiere asignar un salon por su codigo
    }
}
