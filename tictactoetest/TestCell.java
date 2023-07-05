package com.techlabs.tictactoetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.techlabs.tictactoe.Cell;
import com.techlabs.tictactoe.CellAlreadyMarkedException;
import com.techlabs.tictactoe.MarkType;

class TestCell {

	private Cell cell;

    @BeforeEach
    public void init() {
        cell = new Cell();
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(cell.isEmpty());
        try {
            cell.setMark(MarkType.X);
        } catch (CellAlreadyMarkedException e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
        Assertions.assertFalse(cell.isEmpty());
    }

    @Test
    public void testSetMark() {
        try {
            cell.setMark(MarkType.O);
            Assertions.assertEquals(MarkType.O, cell.getMark());
        } catch (CellAlreadyMarkedException e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testSetMark_CellAlreadyMarked() {
        try {
            cell.setMark(MarkType.X);
            Assertions.assertThrows(CellAlreadyMarkedException.class, () -> cell.setMark(MarkType.O));
        } catch (CellAlreadyMarkedException e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
    }

}
