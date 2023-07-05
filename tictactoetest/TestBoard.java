package com.techlabs.tictactoetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.CellAlreadyMarkedException;
import com.techlabs.tictactoe.InvalidLocationException;
import com.techlabs.tictactoe.MarkType;

class TestBoard {

	 private Board board;

	    @BeforeEach
	    public void init() {
	        board = new Board();
	    }

	    @Test
	    public void testIsBoardFull() {
	        Assertions.assertFalse(board.isBoardFull());
	        try {
	            board.setCellMark(0, MarkType.X);
	            board.setCellMark(1, MarkType.O);
	            board.setCellMark(2, MarkType.X);
	            board.setCellMark(3, MarkType.O);
	            board.setCellMark(4, MarkType.X);
	            board.setCellMark(5, MarkType.O);
	            board.setCellMark(6, MarkType.X);
	            board.setCellMark(7, MarkType.O);
	            board.setCellMark(8, MarkType.X);
	        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
	            Assertions.fail("Unexpected exception: " + e.getMessage());
	        }
	        Assertions.assertTrue(board.isBoardFull());
	    }

	    @Test
	    public void testSetCellMark() {
	        try {
	            board.setCellMark(0, MarkType.O);
	            Assertions.assertEquals(MarkType.O, board.getMark(0));
	        } catch (InvalidLocationException | CellAlreadyMarkedException e) {
	            Assertions.fail("Unexpected exception: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testSetCellMark_InvalidLocation() {
	        Assertions.assertThrows(InvalidLocationException.class, () -> board.setCellMark(9, MarkType.X));
	    }

	    @Test
	    public void testGetMark_InvalidLocation() {
	        Assertions.assertThrows(InvalidLocationException.class, () -> board.getMark(9));
	    }

}
