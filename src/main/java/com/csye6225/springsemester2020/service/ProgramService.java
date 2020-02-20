package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Professor;
import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgramService {

    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();

    public ProgramService() {

    }

    public List<Program> getAllPrograms() {
        return new ArrayList<>(programMap.values());
    }

    public Program getOneProgram(long programId) {
        return programMap.get(programId);
    }

    public Program addProgram(Program program) {
        program.setProgramId(programMap.size() + 1);
        programMap.put(program.getProgramId(), program);
        return program;
    }

    public Program updateProgram(Program program) {
        if (program.getProgramId() <= 0) {
            return null;
        }

        for (Course c : programMap.get(program.getProgramId()).getHavingCourses().values()) {
            c.setPossessedProgramName(program.getName());
        }

        for (Student s : programMap.get(program.getProgramId()).getHavingStudents().values()) {
            s.setProgramName(program.getName());
        }

        for (Professor p : programMap.get(program.getProgramId()).getHavingProfessors().values()) {
            p.setBelongedProgramName(program.getName());
        }

        program.setHavingCourses(programMap.get(program.getProgramId()).getHavingCourses());
        program.setHavingStudents(programMap.get(program.getProgramId()).getHavingStudents());
        program.setHavingProfessors(programMap.get(program.getProgramId()).getHavingProfessors());

        programMap.put(program.getProgramId(), program);

        return program;
    }

    public Program deleteProgram(long programId) {
        for (Course c : programMap.get(programId).getHavingCourses().values()) {
            c.setPossessedProgramName(null);
        }

        for (Student s : programMap.get(programId).getHavingStudents().values()) {
            s.setProgramName(null);
        }

        for (Professor p : programMap.get(programId).getHavingProfessors().values()) {
            p.setBelongedProgramName(null);
        }
        
        return programMap.remove(programId);
    }
}
