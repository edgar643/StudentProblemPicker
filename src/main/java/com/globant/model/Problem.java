package com.globant.model;

import java.util.Set;
/**
 * Represents a problem with a name and a set of required skills.
 */
public class Problem {
    private String name;
    private Set<String> skills;

    /**
     * Constructs a new Problem with the specified name and skills.
     *
     * @param name   the name of the problem
     * @param skills the set of skills required for the problem
     */
    public Problem(String name, Set<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    /**
     * Returns the name of the problem.
     *
     * @return the name of the problem
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the set of skills required for the problem.
     *
     * @return the set of skills required for the problem
     */
    public Set<String> getSkills() {
        return skills;
    }
}