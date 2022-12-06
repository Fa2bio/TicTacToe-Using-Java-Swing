package com.github.Fa2bio.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

import com.github.Fa2bio.TicTacToe.observers.EventField;
import com.github.Fa2bio.TicTacToe.observers.ObserverField;

public class Field {
	
	//position x
	private int line;
	
	//position y
	private int column;
	
	private String charac = " ";
	
	//Has the field been marked?
	private boolean marcked = false;

	private List<ObserverField> observers = new ArrayList<ObserverField>();
	
	//Class constructor
	Field(int line, int column){
		this.line = line;
		this.column = column;
	}
	
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getCharac() {
		return charac;
	}

	public boolean isMarcked() {
		return marcked;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setCharac(String charac) {
		this.charac = charac;
		
	}

	public void toggleMarcked() {
		if(!marcked) this.marcked = !marcked;
		if(marcked) notifyObservers(EventField.MARKED);
	}
	
	public void restart() {
		this.marcked = false;
		setCharac(" ");
		notifyObservers(EventField.RESTART);
	}
	
	public void toMark(Player player) {
		if(!isMarcked()) {
			toggleMarcked();

			if(player.getCharac().equalsIgnoreCase("x")) {
				setCharac("X");
				notifyObservers(EventField.TOGGLECHARACPLAYERONE);
			}else {
				setCharac("O");

				notifyObservers(EventField.TOGGLECHARACPLAYERTWO);
			}
			
		}
	}
	

	public void registerObserver(ObserverField observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(EventField event) {
		observers.stream()
			.forEach(o -> o.eventHappened(this, event));
	}
}
