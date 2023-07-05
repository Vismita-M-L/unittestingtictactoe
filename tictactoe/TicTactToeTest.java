package com.techlabs.tictactoe;

import java.util.Scanner;

public class TicTactToeTest {

	public static void main(String[] args) throws InvalidLocationException{

		 Scanner scanner = new Scanner(System.in);
	        Board board = new Board();
	        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
	        Player[] players = new Player[2];

	        players[0] = new Player("Vismita", MarkType.O);
	        players[1] = new Player("Varun", MarkType.X);
	        int currentPlayerIndex = 0;

	        while (resultAnalyzer.analyzeResult() == ResultType.PROGRESS) {
	            board.printBoard();
	            Player currentPlayer = players[currentPlayerIndex];

	            System.out.println(currentPlayer.getName() + ", it's your turn.");
	            System.out.println("Please select a number from 1 to 9 to mark your move:");

	            int selectedCell;
	            try {
	                selectedCell = scanner.nextInt();
	                if (selectedCell < 1 || selectedCell > 9) {
	                    System.out.println("Invalid cell selection. Please try again.");
	                    continue;
	                }
	            } catch (Exception e) {
	                System.out.println("Invalid input. Please try again.");
	                scanner.nextLine();
	                continue;
	            }

	            try {
	                board.setCellMark(selectedCell - 1, currentPlayer.getMark());
	            } catch (InvalidLocationException e) {
	                System.out.println("Invalid cell location. Please try again.");
	                continue;
	            } catch (CellAlreadyMarkedException e) {
	                System.out.println("Cell already marked. Please try again.");
	                continue;
	            }

	            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
	        }

	        board.printBoard();
	        ResultType result = resultAnalyzer.analyzeResult();

	        if (result == ResultType.WIN) {
	            Player winner = players[(currentPlayerIndex + 1) % 2];
	            System.out.println("Congratulations! " + winner.getName() + " wins!");
	        } else if (result == ResultType.DRAW) {
	            System.out.println("It's a draw!");
	        } else {
	            System.out.println("Game in progress...");
	        }

	        System.out.println("Game Over.");
	        scanner.close();
	    }
}


