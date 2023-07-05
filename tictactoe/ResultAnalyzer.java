package com.techlabs.tictactoe;

public class ResultAnalyzer {
	private Board board;

	public ResultAnalyzer(Board board) {
	    this.board = board;
	}

	public ResultType analyzeResult() throws InvalidLocationException {
	    if (checkWin(MarkType.X)) {
	        return ResultType.WIN;
	    } else if (checkWin(MarkType.O)) {
	        return ResultType.WIN;
	    } else if (board.isBoardFull()) {
	        return ResultType.DRAW;
	    } else {
	        return ResultType.PROGRESS;
	    }
	}

	public boolean checkWin(MarkType mark) throws InvalidLocationException {
	    return (board.getMark(0) == mark && board.getMark(1) == mark && board.getMark(2) == mark) || // Top row
	            (board.getMark(3) == mark && board.getMark(4) == mark && board.getMark(5) == mark) || // Middle row
	            (board.getMark(6) == mark && board.getMark(7) == mark && board.getMark(8) == mark) || // Bottom row
	            (board.getMark(0) == mark && board.getMark(3) == mark && board.getMark(6) == mark) || // Left column
	            (board.getMark(1) == mark && board.getMark(4) == mark && board.getMark(7) == mark) || // Middle column
	            (board.getMark(2) == mark && board.getMark(5) == mark && board.getMark(8) == mark) || // Right column
	            (board.getMark(0) == mark && board.getMark(4) == mark && board.getMark(8) == mark) || // Top-left to bottom-right diagonal
	            (board.getMark(2) == mark && board.getMark(4) == mark && board.getMark(6) == mark);   // Top-right to bottom-left diagonal
	}

}
