package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //no escribir getters, setters, toString
@NoArgsConstructor //constructores vacios
@AllArgsConstructor //constructores con todos los atributos
public abstract class Person {//clase base abstracta que representa una persona
    protected String id;
    protected String name;
    protected String lastName;
    protected String email;
    protected String phone;
    protected LocalDate birthDate;
    protected Gender gender;
    protected String address;
    protected boolean active;
}
