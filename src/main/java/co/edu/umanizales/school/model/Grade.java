package co.edu.umanizales.school.model;

/**
 * Enumeration representing grade levels in the school system.
 */
public enum Grade { //clase con valores fijos
    GRADE_1("First Grade", 1),
    GRADE_2("Second Grade", 2),
    GRADE_3("Third Grade", 3),
    GRADE_4("Fourth Grade", 4),
    GRADE_5("Fifth Grade", 5),
    GRADE_6("Sixth Grade", 6),
    GRADE_7("Seventh Grade", 7),
    GRADE_8("Eighth Grade", 8),
    GRADE_9("Ninth Grade", 9),
    GRADE_10("Tenth Grade", 10),
    GRADE_11("Eleventh Grade", 11),
    GRADE_12("Twelfth Grade", 12);

    private final String displayName; //como se muestra (First Grade)
    private final int level; // el nivel (1), final es que no puede cambiar

    Grade(String displayName, int level) { //constructor que recibe los valores definidos arriba
        this.displayName = displayName;
        this.level = level;
    }

    public String getDisplayName() {
        return displayName;
    } //retorna el valor de displayName

    public int getLevel() {
        return level;
    } //retorna el valor de level

    /**
     * Returns the Grade corresponding to the specified level.
     * @param level the grade level (1-12)
     * @return the corresponding Grade enum
     * @throws IllegalArgumentException if the level is not between 1 and 12
     */
    //convierte un numero en el enum
    public static Grade fromLevel(int level) { //metodo que permite buscar el grado por el numero
        for (Grade grade : Grade.values()) { //lista todos los grados del enum los reccore
            if (grade.level == level) {
                return grade;
            }
        }
        // lanza un error si no encuentra el grado
        throw new IllegalArgumentException("Grade level must be between 1 and 12, but was: " + level);
    }

    /**
     * Parse a grade from text. Accepts:
     * - enum name (e.g., "GRADE_10")
     * - display name (e.g., "Tenth Grade")
     * - numeric level (e.g., "10")
     */
    // convierte texto en el numero del grado
    public static Grade fromText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Grade text cannot be null");
        }
        String key = text.trim();

        // con el nombre del enum
        for (Grade grade : Grade.values()) {
            if (grade.name().equalsIgnoreCase(key)) {
                return grade;
            }
        }

        // con el nombre del grado
        for (Grade grade : Grade.values()) {
            if (grade.getDisplayName().equalsIgnoreCase(key)) {
                return grade;
            }
        }

        // convertirlo a numero
        try {
            int level = Integer.parseInt(key);
            return fromLevel(level);
        } catch (NumberFormatException ignore) {
            // fallthrough
        }
//si no funciono nada, error
        throw new IllegalArgumentException("Unknown grade: " + text);
    }

    @Override //sobreescribe el metodo toString
    public String toString() {
        return displayName;
    } //retorna el valor de displayName
}
