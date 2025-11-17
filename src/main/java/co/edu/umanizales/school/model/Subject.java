package co.edu.umanizales.school.model;

import lombok.Getter;

import java.util.*;
import java.util.Objects;

/**
 * Represents an academic subject in the school system.
 * Each subject has a unique code, name, description, credit value,
 * target grade level, assigned teacher, and scheduled class times.
 */
public class Subject {
    /**
     * -- GETTER --
     *
     */
    @Getter
    private String code;
    private String name;
    private String description;
    private int credits;
    private Grade targetGrade;
    private String teacherId;
    private final List<Schedule> schedules;
    private boolean active;

    /**
     * Creates a new active subject with default values.
     * The schedules list is initialized as an empty ArrayList.
     */
    public Subject() {
        this.schedules = new ArrayList<>();
        this.active = true;
    }

    // Getters and Setters

    /**
     * Sets the subject code.
     * @param code Must not be null or empty (after trimming)
     * @throws IllegalArgumentException if code is null or empty
     */
    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code is required");
        }
        this.code = code.trim();
    }

    /**
     * @return The name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the subject name.
     * @param name Must not be null or empty (after trimming)
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name is required");
        }
        this.name = name.trim();
    }

    /**
     * @return The subject description, or null if not set
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the subject description.
     * @param description The description (can be null or empty)
     */
    public void setDescription(String description) {
        this.description = description != null ? description.trim() : null;
    }

    /**
     * @return The number of credits this subject is worth
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits for this subject.
     * @param credits Must be a positive number
     * @throws IllegalArgumentException if credits is not positive
     */
    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        this.credits = credits;
    }

    /**
     * @return The target grade level for this subject
     */
    public Grade getTargetGrade() {
        return targetGrade;
    }

    /**
     * Sets the target grade level for this subject.
     * @param targetGrade The grade level (can be null)
     */
    public void setTargetGrade(Grade targetGrade) {
        this.targetGrade = targetGrade;
    }

    /**
     * @return The ID of the teacher assigned to this subject
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * Sets the teacher ID for this subject.
     * @param teacherId Must not be null or empty (after trimming)
     * @throws IllegalArgumentException if teacherId is null or empty
     */
    public void setTeacherId(String teacherId) {
        if (teacherId == null || teacherId.trim().isEmpty()) {
            throw new IllegalArgumentException("Teacher ID is required");
        }
        this.teacherId = teacherId.trim();
    }

    /**
     * @return An unmodifiable view of the subject's schedules
     */
    public List<Schedule> getSchedules() {
        return Collections.unmodifiableList(schedules);
    }

    /**
     * Replaces all schedules with the provided list.
     * @param schedules The new list of schedules (null is treated as empty list)
     */
    public void setSchedules(Collection<Schedule> schedules) {
        this.schedules.clear();
        if (schedules != null) {
            this.schedules.addAll(schedules);
        }
    }

    /**
     * @return true if the subject is currently active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether the subject is active.
     * @param active The active status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    // Business Logic Methods

    /**
     * Adds a schedule to this subject if not already present.
     * @param schedule The schedule to add
     * @return true if the schedule was added, false if it was already present
     * @throws IllegalArgumentException if schedule is null
     */
    public boolean addSchedule(Schedule schedule) {
        Objects.requireNonNull(schedule, "Schedule cannot be null");
        return !schedules.contains(schedule) && schedules.add(schedule);
    }

    /**
     * Removes a schedule from this subject.
     * @param schedule The schedule to remove
     * @return true if the schedule was found and removed, false otherwise
     */
    public boolean removeSchedule(Schedule schedule) {
        return schedule != null && schedules.remove(schedule);
    }

    // Object Overrides

    /**
     * Compares subjects based on their code.
     * @param o The object to compare with
     * @return true if the objects are equal (same class and code)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return code.equals(subject.code);
    }

    /**
     * @return A hash code based on the subject's code
     */
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    /**
     * @return A string representation of the subject
     */
    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", targetGrade=" + targetGrade +
                ", teacherId='" + teacherId + '\'' +
                ", active=" + active +
                '}';
    }
}
