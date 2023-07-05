package com.techlabs.tictactoe;

public class Board {
	private Cell[] cells;

    public Board() {
        cells = new Cell[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setCellMark(int loc, MarkType mark) throws InvalidLocationException, CellAlreadyMarkedException {
    	if (loc >= 0 && loc < cells.length) {
    	    cells[loc].setMark(mark);
    	} else {
    	    throw new InvalidLocationException("Invalid cell location!");
    	}
    }

    public MarkType getMark(int loc) throws InvalidLocationException {
    	if (loc >= 0 && loc <cells.length) {
    		 return cells[loc].getMark();
    	} else {
    	    throw new InvalidLocationException("Invalid cell location!");
    	}
    }


    public void printBoard() {
    	int rowCount = 0;
        int colCount = 0;
        
        for (Cell cell : cells) {
            System.out.print(cell.getMark() + " ");
            colCount++;
            
            if (colCount == 3) {
                System.out.println();
                colCount = 0;
                rowCount++;
            }
        }
    }

}
