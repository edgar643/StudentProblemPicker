package com.globant.controllers;
import com.globant.model.Problem;
import com.globant.model.Skill;
import com.globant.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Implementation of ProblemSelector that selects the most appropriate problem for a student.
 * This is the implementation that uses streams to find the problem with the maximum number
 * of skills that the student has but are below the score threshold.
 * Could be implemented not using streams, and it can be clearer to understand
 * if functional programming is not familiar.
 */
public class ProblemSelectorImpl implements ProblemSelector {
    private final double scoreThreshold;

    public ProblemSelectorImpl(final double scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
    }

    /**
     * Selects the most appropriate problem for the given student from the provided list of problems.
     *
     * @param student  the student for whom the problem is to be selected
     * @param problems the list of available problems
     * @return the selected problem for the student
     */
    @Override
    public Problem selectProblem(final Student student, final List<Problem> problems) {
        // Retrieve the student's skills
        Map<String, Skill> studentSkills = student.getSkills();

        // Find the problem with the maximum number of skills that the student has but are below the score threshold
        return problems.stream()
                .max((p1, p2) -> {
                    // Count the number of skills in problem 1 that the student has and are below the score threshold
                    long count1 = p1.getSkills().stream()
                            .filter(skill -> studentSkills.containsKey(skill) && studentSkills.get(skill).getScore() < scoreThreshold)
                            .count();
                    // Count the number of skills in problem 2 that the student has and are below the score threshold
                    long count2 = p2.getSkills().stream()
                            .filter(skill -> studentSkills.containsKey(skill) && studentSkills.get(skill).getScore() < scoreThreshold)
                            .count();
                    // Compare the counts to determine which problem is more appropriate
                    return Long.compare(count1, count2);
                })
                // Return the problem with the highest count, or null if no problems are found
                .orElse(null);
    }
}