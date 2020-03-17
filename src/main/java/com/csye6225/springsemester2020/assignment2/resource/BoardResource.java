package com.csye6225.springsemester2020.assignment2.resource;

import com.csye6225.springsemester2020.assignment2.model.Board;
import com.csye6225.springsemester2020.assignment2.service.BoardService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dynamodb/boards")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoardResource {

    BoardService boardService = new BoardService();

    @GET
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GET
    @Path("/{boardId}")
    public Board getBoard(@PathParam("boardId") String boardId) {
        return boardService.getBoard(boardId);
    }

    @POST
    public Board addBoard(Board board) {
        return boardService.addBoard(board);
    }

    @DELETE
    @Path("/{boardId}")
    public void deleteBoard(@PathParam("boardId") String boardId) {
        boardService.deleteBoard(boardId);
    }
}
