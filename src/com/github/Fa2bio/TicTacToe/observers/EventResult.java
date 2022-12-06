package com.github.Fa2bio.TicTacToe.observers;

public class EventResult {
	private final boolean winnerPlayOne;
	private final boolean winnerPlayTwo;
	private final boolean tie;
	
	public EventResult(boolean winnerPlayOne, boolean winnerPlayTwo, boolean tie) {
		this.winnerPlayOne = winnerPlayOne;
		this.winnerPlayTwo = winnerPlayTwo;
		this.tie = tie;
	}

	public boolean playerOneisWinner() {
		return winnerPlayOne;
	}
	
	public boolean playerTwoisWinner() {
		return winnerPlayTwo;
	}
	
	public boolean isTied() {
		return tie;
	}
}
