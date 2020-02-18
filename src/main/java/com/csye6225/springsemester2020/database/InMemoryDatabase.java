package com.csye6225.springsemester2020.database;

import com.csye6225.springsemester2020.model.Professor;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {

    private static Map<Long, Professor> professorMap = new HashMap<>();

    public InMemoryDatabase() {

    }

    public static Map<Long, Professor> getProfessorMap() {
        return professorMap;
    }
}
