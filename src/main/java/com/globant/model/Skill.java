package com.globant.model;

/**
 * Represents a skill with a name and a score.
 */
public class Skill {
    private String name;
    private double score;

    /**
     * Constructs a new Skill with the specified name and score.
     *
     * @param name  the name of the skill
     * @param score the score of the skill
     */
    public Skill(String name, double score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns the name of the skill.
     *
     * @return the name of the skill
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the score of the skill.
     *
     * @return the score of the skill
     */
    public double getScore() {
        return score;
    }

    /**
     * Sets the score of the skill.
     *
     * @param score the new score of the skill
     */
    public void setScore(double score) {
        this.score = score;
    }
}