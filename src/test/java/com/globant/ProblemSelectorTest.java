package com.globant.tests;

import com.globant.controllers.ProblemSelector;
import com.globant.controllers.ProblemSelectorImpl;
import com.globant.model.Problem;
import com.globant.model.Skill;
import com.globant.model.Student;
import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for ProblemSelector.
 */
public class ProblemSelectorTest {
    private final double SCORE_THRESHOLD = 95;
    /**
     * Tests the selectProblem method of ProblemSelector.
     * This test case sets up a student with specific skills and a list of problems,
     * then verifies that the correct problem is selected based on the student's skills.
     */
    @Test
    public void testSelectProblem1() {
        // Create a map of skills for the student
        Map<String, Skill> skills = new HashMap<>();
        skills.put("add-decimals", new Skill("add-decimals", 33.0));
        skills.put("multiply-decimals", new Skill("multiply-decimals", 47.0));
        skills.put("add-fractions", new Skill("add-fractions", 96.0));

        // Create a student with the given skills
        Student student = new Student(skills);

        // Create a list of problems
        List<Problem> problems = new ArrayList<>();
        problems.add(new Problem("prob1", Set.of("add-decimals")));
        problems.add(new Problem("prob2", Set.of("add-decimals", "multiply-decimals")));
        problems.add(new Problem("prob3", Set.of("add-fractions")));
        problems.add(new Problem("prob5", Set.of("multiply-decimals", "multiply-fractions")));

        // Create a ProblemSelector with a threshold of 95
        ProblemSelector selector = new ProblemSelectorImpl(SCORE_THRESHOLD);

        // Select a problem for the student
        Problem selected = selector.selectProblem(student, problems);

        // Print the selected problem
        System.out.println("A student with scores {add-decimals="
                + skills.get("add-decimals").getScore()
                + "%, add-fractions=" + skills.get("add-fractions").getScore()
                + "%, multiply-fractions="
                + skills.get("multiply-decimals").getScore()
                + "%} should get " + selected.getName() + ".");

        // Assert that the selected problem is "prob2"
        assertEquals("prob2", selected.getName());
    }

    /**
     * Tests the selectProblemWithoutStreams method of ProblemSelector.
     * This test case sets up a student with specific skills and a list of problems,
     * then verifies that the correct problem is selected based on the student's skills.
     */
    @Test
    public void testSelectProblem2() {
        // Create a map of skills for the student
        Map<String, Skill> skills = new HashMap<>();
        skills.put("add-decimals", new Skill("add-decimals", 97.0));
        skills.put("add-fractions", new Skill("add-fractions", 17.0));
        skills.put("multiply-fractions", new Skill("multiply-fractions", 53.0));

        // Create a student with the given skills
        Student student = new Student(skills);

        // Create a list of problems
        List<Problem> problems = new ArrayList<>();
        problems.add(new Problem("prob1", Set.of("add-decimals")));
        problems.add(new Problem("prob2", Set.of("add-decimals", "multiply-decimals")));
        problems.add(new Problem("prob3", Set.of("add-fractions")));
        problems.add(new Problem("prob4", Set.of("add-fractions", "multiply-fractions")));
        problems.add(new Problem("prob5", Set.of("multiply-decimals", "multiply-fractions")));

        // Create a ProblemSelector with a threshold of 95
        ProblemSelector selector = new ProblemSelectorImpl(SCORE_THRESHOLD);

        // Select a problem for the student
        Problem selected = selector.selectProblem(student, problems);

        // Print the selected problem
        System.out.println("A student with scores {add-decimals="
                + skills.get("add-decimals").getScore()
                + "%, add-fractions=" + skills.get("add-fractions").getScore()
                + "%, multiply-fractions="
                + skills.get("multiply-fractions").getScore()
                + "%} should get " + selected.getName() + ".");

        // Assert that the selected problem is "prob4"
        assertEquals("prob4", selected.getName());
    }
}