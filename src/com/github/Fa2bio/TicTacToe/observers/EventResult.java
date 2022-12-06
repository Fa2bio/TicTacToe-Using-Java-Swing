package com.github.Fa2bio.TicTacToe.observers;

public class EventResult {
	private final boolean winnerPlayOne;
	private final boolean winnerPlayTwo;
	private final boolean tied;
	
	public EventResult(boolean winnerPlayOne, boolean winnerPlayTwo, boolean tied) {
		this.winnerPlayOne = winnerPlayOne;
		this.winnerPlayTwo = winnerPlayTwo;
		this.tied = tied;
	}

	public boolean playerOneisWinner() {
		return winnerPlayOne;
	}
	
	public boolean playerTwoisWinner() {
		return winnerPlayTwo;
	}
	
	public boolean isTied() {
		return tied;
	}
}
