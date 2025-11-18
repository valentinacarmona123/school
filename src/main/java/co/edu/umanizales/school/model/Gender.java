package co.edu.umanizales.school.model;

import lombok.Getter; //crea los getters sin escribirlos

/**
 * Enum representing different gender options.
 */
public enum Gender { //enum con valores fijos, generos permitidos
    MALE("M", "Male"),
    FEMALE("F", "Female"),
    OTHER("O", "Other");

    @Getter
    private final String code; //guardarlo con un codigo
    
    @Getter
    private final String description; //guardarlo con una descripcion

    Gender(String code, String description) { //constructor que guarda los valores
        this.code = code;
        this.description = description;
    }

    /**
     * Get the Gender enum constant corresponding to the given code.
     * @param code the gender code (M, F, or O)
     * @return the corresponding Gender enum constant, or OTHER if no match is found
     */
    public static Gender fromCode(String code) { //metodo paraconvertir el codigo en el enum
        if (code == null) {
            return OTHER;//si tiene null retorna OTHER
        }
        
        for (Gender gender : values()) { //recorre todos los valores del enum
            if (gender.getCode().equalsIgnoreCase(code)) { //compara el codigo con el codigo del enum
                return gender; //retorna el enum
            }
        }
        return OTHER; //si no encuentra nada retorna OTHER
    }
}
