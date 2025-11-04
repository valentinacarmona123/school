package co.edu.umanizales.school.model;

import lombok.Getter;

/**
 * Enum representing different gender options.
 */
public enum Gender {
    MALE("M", "Male"),
    FEMALE("F", "Female"),
    OTHER("O", "Other");

    @Getter
    private final String code;
    
    @Getter
    private final String description;

    Gender(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Get the Gender enum constant corresponding to the given code.
     * @param code the gender code (M, F, or O)
     * @return the corresponding Gender enum constant, or OTHER if no match is found
     */
    public static Gender fromCode(String code) {
        if (code == null) {
            return OTHER;
        }
        
        for (Gender gender : values()) {
            if (gender.getCode().equalsIgnoreCase(code)) {
                return gender;
            }
        }
        return OTHER;
    }
}
