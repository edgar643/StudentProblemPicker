package com.globant.model;

import java.util.Map;

/**
 * Represents a student with a set of skills.
 */
public class Student {
    private Map<String, Skill> skills;

    /**
     * Constructs a new Student with the specified skills.
     *
     * @param skills the map of skills associated with the student
     */
    public Student(Map<String, Skill> skills) {
        this.skills = skills;
    }

    /**
     * Returns the map of skills associated with the student.
     *
     * @return the map of skills
     */
    public Map<String, Skill> getSkills() {
        return skills;
    }

    /**
     * Returns the skill associated with the specified skill name.
     *
     * @param skillName the name of the skill to retrieve
     * @return the skill associated with the specified skill name
     */
    public Skill getSkill(String skillName) {
        return skills.get(skillName);
    }
}