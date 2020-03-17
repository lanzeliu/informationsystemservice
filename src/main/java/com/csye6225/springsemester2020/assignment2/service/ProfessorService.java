package com.csye6225.springsemester2020.assignment2.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.csye6225.springsemester2020.assignment2.database.DynamoDBConnector;
import com.csye6225.springsemester2020.assignment2.model.Professor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorService {
    private static DynamoDBMapper mapper = DynamoDBConnector.getMapper();

    public List<Professor> getAllProfessors() {
        return new ArrayList<>(mapper.scan(Professor.class, new DynamoDBScanExpression()));
    }

    public Professor getProfessor(String id) {
        return mapper.load(Professor.class, id);
    }

    public Professor addProfessor(Professor professor) {
        mapper.save(professor);
        return mapper.load(Professor.class, professor.getProfessorId());
    }

    public void updateProfessor(Professor professor) {
        mapper.save(professor);
    }

    public DynamoDBSaveExpression buildDynamoDBSaveExpression(Professor professor) {
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("professorId", new ExpectedAttributeValue(new AttributeValue(String.valueOf(professor.getProfessorId()))));
        saveExpression.setExpected(expectedAttributeValueMap);
        return saveExpression;
    }

    public void deleteProfessor(String professorId) {
        Professor p = mapper.load(Professor.class, professorId);
        if (p != null) {
            mapper.delete(p);
        }
    }

}
