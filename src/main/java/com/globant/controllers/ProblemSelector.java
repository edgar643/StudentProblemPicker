package com.globant.controllers;
import com.globant.model.Problem;
import com.globant.model.Student;

import java.util.List;

/**
 * Interface for selecting a problem for a student from a list of problems.
 */
public interface ProblemSelector {
    /**
     * Selects a problem for the given student from the provided list of problems.
     *
     * @param student  the student for whom the problem is to be selected
     * @param problems the list of available problems
     * @return the selected problem for the student
     */
    Problem selectProblem(Student student, List<Problem> problems);
}