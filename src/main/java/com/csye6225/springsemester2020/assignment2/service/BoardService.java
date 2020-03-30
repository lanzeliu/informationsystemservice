package com.csye6225.springsemester2020.assignment2.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.springsemester2020.assignment2.database.DynamoDBConnector;
import com.csye6225.springsemester2020.assignment2.model.Board;
import com.csye6225.springsemester2020.assignment2.model.Course;

import java.util.ArrayList;
import java.util.List;

public class BoardService {

    DynamoDBMapper mapper = DynamoDBConnector.getMapper();

    public List<Board> getAllBoards() {
        return new ArrayList<>(mapper.scan(Board.class, new DynamoDBScanExpression()));
    }

    public Board getBoard(String boardId) {
        return mapper.load(Board.class, boardId);
    }

    public Board addBoard(Board board) {
        mapper.save(board);
        return board;
    }

    /*
    public Board updateBoard(Board board) {
        Board b = mapper.load(Board.class, board.getBoardId());
        if (b != null && !b.getCourseId().equals(board.getCourseId())) {
            b.setCourseId(board.getCourseId());
            return b;
        }
        return null;
    }

     */

    public void deleteBoard(String boardId) {
        Board b = mapper.load(Board.class, boardId);
        if (b != null) {
            mapper.delete(b);
        }

    }
}
