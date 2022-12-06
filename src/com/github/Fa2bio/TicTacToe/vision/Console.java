package com.github.Fa2bio.TicTacToe.vision;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.github.Fa2bio.TicTacToe.exceptions.ExitException;
import com.github.Fa2bio.TicTacToe.model.Board;
import com.github.Fa2bio.TicTacToe.model.Player;

public class Console {
//	private Board board;
//	private Scanner entry = new Scanner(System.in);
//	
//	public Console(Board board) {
//		this.board = board;
//		runGame();
//	}
//
//	private void runGame() {
//		try {
//			boolean continueStatus = true;
//			while(continueStatus) {
//				gameCycle();
//				System.out.print("Another game? (S/n): ");
//				String answer = entry.nextLine();
//				if(answer.equalsIgnoreCase("n")) {
//					continueStatus = false;
//				}else {
//					board.restart();
//				}
//			}
//		} catch (ExitException exit) {
//			System.out.println("Over");
//		} finally {
//			entry.close();
//		}
//		
//	}
//
//	private void gameCycle() {
//		Player playerOne = new Player("X",true);
//		Player playerTwo = new Player("O",false);
//		boolean loop = true;
//		while(loop) {
//			System.out.println(board);
//			
//			Iterator<Integer> xy;
//			
//			if(playerOne.isTurn()) {
//				String typed = captureTypedValue("Player One, type (x,y): ");
//				xy = Arrays.stream(typed.split(","))
//						.map(e -> Integer.parseInt(e.trim())).iterator();
//				board.toMark(xy.next(), xy.next(),playerOne);
//				
//				if(playerOne.getNumOfMoves()>=3) {
//					if(board.achievedGoal(playerOne)) {
//						loop = false;
//						System.out.println(board);
//						System.out.println("Player One is the Winner");
//					}
//				}
//				playerOne.setTurn(false);
//				playerTwo.setTurn(true);
//				
//			}else if(playerTwo.isTurn()){
//				String typed = captureTypedValue("Player Two, type (x,y): ");
//				xy = Arrays.stream(typed.split(","))
//						.map(e -> Integer.parseInt(e.trim())).iterator();
//				board.toMark(xy.next(), xy.next(),playerTwo);
//				
//				if(playerTwo.getNumOfMoves()>=3) {
//					if(board.achievedGoal(playerTwo)) {
//						loop = false;
//						System.out.println(board);
//						System.out.println("Player Two is the Winner");
//					}
//				}
//				playerTwo.setTurn(false);
//				playerOne.setTurn(true);
//			}
//			if(playerOne.getNumOfMoves()==5 || playerTwo.getNumOfMoves()==5) {
//				System.out.println(board);
//				System.out.println("Tie match");
//				loop = false;
//				
//			}
//			
//		}
//		
//	}
//
//	private String captureTypedValue(String text) {
//		System.out.print(text);
//		String Typed = entry.nextLine();
//		
//		if(Typed.equalsIgnoreCase("exit")) {
//			throw new ExitException();
//		}
//		
//		return Typed;
//	}
}
