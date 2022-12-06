package com.github.Fa2bio.TicTacToe.model;

public class Player {
	private int numOfMoves=0;
	private boolean winner=false;
	private String charac;
	private boolean turn;
	
	public Player(String charac, boolean turn){
		this.charac = charac;
		this.turn = turn;
	}

	public int getNumOfMoves() {
		return numOfMoves;
	}

	public boolean isWinner() {
		return winner;
	}

	public String getCharac() {
		return charac;
	}

	public boolean isTurn() {
		return turn;
	}

	public void addNumOfMoves() {
		this.numOfMoves += 1;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public void setCharac(String charac) {
		this.charac = charac;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	
}
