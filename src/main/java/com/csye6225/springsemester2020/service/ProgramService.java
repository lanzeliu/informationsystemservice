package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Course;
//import com.csye6225.springsemester2020.model.Professor;
import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgramService {

    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();
    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();
    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();
    private static long generateId = InMemoryDatabase.getProgramMap().size();

    public ProgramService() {

    }

    public List<Program> getAllPrograms() {
        return new ArrayList<>(programMap.values());
    }

    public Program getOneProgram(long programId) {
        return programMap.get(programId);
    }

    public Program addProgram(Program program) {
        program.setProgramId(++generateId);
        programMap.put(program.getProgramId(), program);
        return program;
    }

    public Program updateProgram(Program program) {
        if (program.getProgramId() <= 0) {
            return null;
        }

        Program p = programMap.get(program.getProgramId());
        p.setName(program.getName());

        for (Course c : programMap.get(program.getProgramId()).getHavingCourses().values()) {
            c.setProgramName(program.getName());
        }
        for (Student s : programMap.get(program.getProgramId()).getHavingStudents().values()) {
            s.setProgramName(program.getName());
        }

        return program;
    }

    public Program deleteProgram(long programId) {
        if (!programMap.containsKey(programId)) {
            return null;
        }

        for (long courseKey : programMap.get(programId).getHavingCourses().keySet()) {
            for (long studentKey : courseMap.get(courseKey).getHavingStudents().keySet()) {
                studentMap.get(studentKey).getEnrolledCourses().remove(courseKey);
            }
            courseMap.remove(courseKey);
        }

        for (long studentKey : programMap.get(programId).getHavingStudents().keySet()) {
            for (long courseKey : studentMap.get(studentKey).getEnrolledCourses().keySet()) {
                courseMap.get(courseKey).getHavingStudents().remove(studentKey);
            }
            studentMap.remove(studentKey);
        }
        
        return programMap.remove(programId);
    }
}
