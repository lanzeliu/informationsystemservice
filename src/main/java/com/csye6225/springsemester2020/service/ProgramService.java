package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Program;

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

    public Program putProgram(Program program) {
        if (program.getProgramId() <= 0) {
            return null;
        }
        programMap.put(program.getProgramId(), program);
        return program;
    }

    public Program deleteProgram(long programId) {
        return programMap.remove(programId);
    }
}
