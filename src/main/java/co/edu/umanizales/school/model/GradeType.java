package co.edu.umanizales.school.model;

import lombok.Getter;

/**
 * Enum representing different types of grades and their weights in the final grade calculation.
 */
public enum GradeType { //lista de opcioness predefinidas
    QUIZ("QUIZ", "Quiz", "Short assessment", 0.15),
    HOMEWORK("HW", "Homework", "Take-home assignment", 0.20),
    MIDTERM("MID", "Midterm Exam", "Midterm examination", 0.25),
    FINAL("FINAL", "Final Exam", "Final examination", 0.30),
    PROJECT("PROJ", "Project", "Class project", 0.10);

    @Getter
    private final String code;
    
    @Getter//crea los getters para no sobreescribirlos, se puede pedir cualquier cosa de GradeType
    private final String name;//son final porque no se cambian
    
    @Getter
    private final String description;
    
    @Getter
    private final double weight; // Weight in final grade calculation (0.0 to 1.0)

    GradeType(String code, String name, String description, double weight) { //constructor
        this.code = code;
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Get the GradeType enum constant corresponding to the given code.
     * @param code the grade type code (e.g., "QUIZ", "HW", "MID", etc.)
     * @return the corresponding GradeType enum constant
     * @throws IllegalArgumentException if the code is null or doesn't match any GradeType
     */
    public static GradeType fromCode(String code) { //constructor para convertir el codigo en el enum
        if (code == null) {
            throw new IllegalArgumentException("Grade type code cannot be null"); //si mandan null, lanza error
        }

        String key = code.trim();//quita espacios
        for (GradeType type : values()) { //recorre todos los valores del enum
            if (type.getCode().equalsIgnoreCase(key) //no importa si está en mayúsculas o minúsculas
                || type.getName().equalsIgnoreCase(key) //el usuario escribe el nombre en vez del código
                || type.name().equalsIgnoreCase(key)) { //intenta convertir exactamente el nombre del enum
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown grade type: " + code); //
    }

    @Override
    public String toString() {
        return this.name;
    }
}
