package com.globant.controllers;
import com.globant.model.Problem;
import com.globant.model.Skill;
import com.globant.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Implementation of ProblemSelector that selects the most appropriate problem for a student.
 */
public class ProblemSelectorImpl implements ProblemSelector {
    private final double SCORE_THRESHOLD;

    public ProblemSelectorImpl(double SCORE_THRESHOLD) {
        this.SCORE_THRESHOLD = SCORE_THRESHOLD;
    }

    /**
     * Selects the most appropriate problem for the given student from the provided list of problems.
     *
     * @param student  the student for whom the problem is to be selected
     * @param problems the list of available problems
     * @return the selected problem for the student
     */
    @Override
    public Problem selectProblem(Student student, List<Problem> problems) {
    // Retrieve the student's skills
    Map<String, Skill> studentSkills = student.getSkills();

    // Find the problem with the maximum number of skills that the student has but are below the score threshold
    return problems.stream()
            .max((p1, p2) -> {
                // Count the number of skills in problem 1 that the student has and are below the score threshold
                long count1 = p1.getSkills().stream()
                        .filter(skill -> studentSkills.containsKey(skill) && studentSkills.get(skill).getScore() < SCORE_THRESHOLD)
                        .count();
                // Count the number of skills in problem 2 that the student has and are below the score threshold
                long count2 = p2.getSkills().stream()
                        .filter(skill -> studentSkills.containsKey(skill) && studentSkills.get(skill).getScore() < SCORE_THRESHOLD)
                        .count();
                // Compare the counts to determine which problem is more appropriate
                return Long.compare(count1, count2);
            })
            // Return the problem with the highest count, or null if no problems are found
            .orElse(null);
}

@Override
public Problem selectProblemWithoutStreams(Student student, List<Problem> problems) {
        Problem bestProblem = null;
        int maxSkillCount = 0;

        for (Problem problem : problems) {
            int count = 0;
            for (String skill : problem.getSkills()) {
                Skill studentSkill = student.getSkill(skill);
                if (studentSkill != null && studentSkill.getScore() < SCORE_THRESHOLD) {
                    count++;
                }
            }

            if (count > maxSkillCount) {
                maxSkillCount = count;
                bestProblem = problem;
            }
        }

        return bestProblem;
    }
}