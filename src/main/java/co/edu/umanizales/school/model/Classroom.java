package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data //genera getters and setters y el toString
@NoArgsConstructor //crea constructor vacio
@AllArgsConstructor //crea constructor con todos los atributos
public class Classroom { //clase que representa un salon
    private String code;
    private String building;
    private int floor;
    private int capacity;
    private List<String> equipments = new ArrayList<>(); //lista de equipos
    private boolean hasProjector;
    private boolean hasAirConditioning;

    //revisa si todos los estudiantes pueden entrar
    public boolean canAccommodate(int numberOfStudents) {
        return numberOfStudents <= capacity;
    }


    //agrega un equipo si no estaba
    public void addEquipment(String item) {
        if (!equipments.contains(item)) {
            equipments.add(item);
        }
    }

    //elimina un equipo si estaba
    public void removeEquipment(String item) {
        equipments.remove(item);
    }
}
