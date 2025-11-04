package co.edu.umanizales.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a grade level in the school system.
 * This is an immutable class that provides predefined grade levels.
 */
@Getter
@AllArgsConstructor
public class Grade {
    private final int level;
    private final String name;
    
    // Common grade levels
    public static final Grade FIRST_GRADE = new Grade(1, "First Grade");
    public static final Grade SECOND_GRADE = new Grade(2, "Second Grade");
    public static final Grade THIRD_GRADE = new Grade(3, "Third Grade");
    public static final Grade FOURTH_GRADE = new Grade(4, "Fourth Grade");
    public static final Grade FIFTH_GRADE = new Grade(5, "Fifth Grade");
    
    private static final Grade[] GRADES = {
        null,           // index 0 (unused)
        FIRST_GRADE,   // index 1
        SECOND_GRADE,  // index 2
        THIRD_GRADE,   // index 3
        FOURTH_GRADE,  // index 4
        FIFTH_GRADE    // index 5
    };
    
    /**
     * Returns the Grade corresponding to the specified level.
     * @param level the grade level (1-5)
     * @return the corresponding Grade instance
     * @throws IllegalArgumentException if the level is not between 1 and 5
     */
    public static Grade fromLevel(int level) {
        if (level < 1 || level > 5) {
            throw new IllegalArgumentException("Grade level must be between 1 and 5, but was: " + level);
        }
        return GRADES[level];
    }
    
    @Override
    public String toString() {
        return name;
    }
}
