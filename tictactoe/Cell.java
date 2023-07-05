package com.techlabs.tictactoe;

public class Cell {
	private MarkType mark;

    public Cell() {
        mark = MarkType.EMPTY;
    }

    public boolean isEmpty() {
        return mark == MarkType.EMPTY;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws CellAlreadyMarkedException {
        if (!isEmpty()) {
            throw new CellAlreadyMarkedException("Cell already marked!");
        }
        this.mark = mark;
    }
}


