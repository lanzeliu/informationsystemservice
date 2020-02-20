package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfessorService {

    private Map<Long, Professor> professorMap = InMemoryDatabase.getProfessorMap();

    public ProfessorService() {

    }

    public List<Professor> getAllProfessors() {
        return new ArrayList<>(professorMap.values());
    }

    public Professor getOneProfessor(long professorId) {
        return professorMap.get(professorId);
    }

    public Professor postProfessor(Professor professor) {
        professor.setProfessorId(professorMap.size() + 1);
        professorMap.put(professor.getProfessorId(), professor);
        return professor;
    }

    public Professor putProfessor(Professor professor) {
        if (professor.getProfessorId() <= 0) {
            return null;
        }
        professorMap.put(professor.getProfessorId(), professor);
        return professor;
    }

    public Professor deleteProfessor(long professorId) {
        return professorMap.remove(professorId);
    }

    public List<Professor> getProfessorsByDepartment(String department) {
        List<Professor> professorsByDepartmentArrayList = new ArrayList<>();
        for (Professor professor : professorMap.values()) {
            if (professor.getDepartment() == department) {
                professorsByDepartmentArrayList.add(professor);
            }
        }
        return professorsByDepartmentArrayList;
    }
}
