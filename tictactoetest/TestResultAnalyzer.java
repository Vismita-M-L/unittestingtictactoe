package com.techlabs.tictactoetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.CellAlreadyMarkedException;
import com.techlabs.tictactoe.InvalidLocationException;
import com.techlabs.tictactoe.MarkType;
import com.techlabs.tictactoe.ResultAnalyzer;
import com.techlabs.tictactoe.ResultType;

class TestResultAnalyzer {
	private Board board;
    private ResultAnalyzer resultAnalyzer;

    @BeforeEach
    public void setUp() {
        board = new Board();
        resultAnalyzer = new ResultAnalyzer(board);
    }

    @Test
    public void testAnalyzeResult_Win() {
      
        try {
            board.setCellMark(0, MarkType.X);
            board.setCellMark(1, MarkType.X);
            board.setCellMark(2, MarkType.X);
        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
            Assertions.fail("Exception should not be thrown");
        }

        ResultType result;
        try {
            result = resultAnalyzer.analyzeResult();
            Assertions.assertEquals(ResultType.WIN, result);
        } catch (InvalidLocationException e) {
            Assertions.fail("Exception should not be thrown");
        }
    }
    @Test
    public void testAnalyzeResult_Draw() {
       
        try {
            board.setCellMark(0, MarkType.X);
            board.setCellMark(1, MarkType.O);
            board.setCellMark(2, MarkType.X);
            board.setCellMark(3, MarkType.X);
            board.setCellMark(4, MarkType.O);
            board.setCellMark(5, MarkType.X);
            board.setCellMark(6, MarkType.O);
            board.setCellMark(7, MarkType.X);
            board.setCellMark(8, MarkType.O);
        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
            Assertions.fail("Exception should not be thrown");
        }

        ResultType result;
        try {
            result = resultAnalyzer.analyzeResult();
            Assertions.assertEquals(ResultType.DRAW, result);
        } catch (InvalidLocationException e) {
            Assertions.fail("Exception should not be thrown");
        }
    }
    @Test
    public void testAnalyzeResult_InProgress() {
        
        try {
            board.setCellMark(0, MarkType.X);
            board.setCellMark(1, MarkType.O);
            board.setCellMark(2, MarkType.X);
            board.setCellMark(3, MarkType.O);
            board.setCellMark(4, MarkType.EMPTY);
            board.setCellMark(5, MarkType.X);
            board.setCellMark(6, MarkType.EMPTY);
            board.setCellMark(7, MarkType.O);
            board.setCellMark(8, MarkType.EMPTY);
        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
            Assertions.fail("Exception should not be thrown");
        }

        ResultType result;
        try {
            result = resultAnalyzer.analyzeResult();
            Assertions.assertEquals(ResultType.PROGRESS, result);
        } catch (InvalidLocationException e) {
            Assertions.fail("Exception should not be thrown");
        }
    }
    @Test
    public void testCheckWin_TopRow() {
        try {
            board.setCellMark(0, MarkType.X);
            board.setCellMark(1, MarkType.X);
            board.setCellMark(2, MarkType.X);

            boolean result = resultAnalyzer.checkWin(MarkType.X);
            Assertions.assertTrue(result);
        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
            Assertions.fail("Exception should not be thrown");
        }
    }

    @Test
    public void testCheckWin_MiddleColumn() {
        try {
            board.setCellMark(1, MarkType.O);
            board.setCellMark(4, MarkType.O);
            board.setCellMark(7, MarkType.O);

            boolean result = resultAnalyzer.checkWin(MarkType.O);
            Assertions.assertTrue(result);
        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
            Assertions.fail("Exception should not be thrown");
        }
    }


	

}
