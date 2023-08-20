package com.github.Fa2bio.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.github.Fa2bio.TicTacToe.observers.EventField;
import com.github.Fa2bio.TicTacToe.observers.EventResult;
import com.github.Fa2bio.TicTacToe.observers.ObserverField;

public class Board implements ObserverField{
	private final int lines = 3;
	private final int columns = 3;
	
	private static int scoreX = 0;
	private static int scoreO = 0;
	
	private final List<Field> fields = new ArrayList<Field>();
	private final List<Consumer<EventResult>> observers = new ArrayList<Consumer<EventResult>>();
	
	public Board(){		
		generateFields();

	}
	
	private void generateFields() {
		for (int line = 0; line < lines; line++) {
			for (int column = 0; column < columns; column++) {
				Field field = new Field(line, column);
				field.registerObserver(this);
				fields.add(field);
			}
		}
	}
	
	public void forEachFields(Consumer<Field> function) {
		fields.forEach(function);
	}
	
	
	public boolean achievedGoal(Player player) {
		boolean goal = false;
		int acumulator;
		int acumulatorD2=0;
		int i=0;
		Field f;
		
		for (int line = 0; line < lines; line++) {
			acumulator=0;
			for (int column = 0; column < columns; column++) {
				f = fields.get(i);
				if(f.getCharac() != null) {
					if(f.getCharac().equalsIgnoreCase(player.getCharac())) 	acumulator++;
					else acumulator=0;
					i++;
				}
				
			}
			if(acumulator==3) {
				return true;
			}else goal = false;
		}
		
		for (int column = 0; column < columns; column++) {
			i=column;
			acumulator=0;
			for (int line = 0; line < lines; line++) {
				f = fields.get(i);
				if(f.getCharac() != null) {
					if(f.getCharac().equalsIgnoreCase(player.getCharac())) 	acumulator++;
					i+=3;
				}
			}
			if(acumulator==3) {
				return true;
			}else goal = false;
			
		}
		
		i=0;
		acumulator=0;
		for (int column = 0; column < columns; column++) {			
			for (int line = 0; line < lines; line++) {
				if(line==column) {
					f = fields.get(i);
					if(f.getCharac().equalsIgnoreCase(player.getCharac())) acumulator++;
				}
				if((line==0&&column==2)||(line==1&&column==1)||(line==2&&column==0)) {
					f = fields.get(i);
					if(f.getCharac() != null) {
						if(f.getCharac().equalsIgnoreCase(player.getCharac())) acumulatorD2++;
					}
				}
				i++;
			}
			if(acumulator==3||acumulatorD2==3) {

				goal = true;
			}else goal = false;
			
		}
		
		return goal;
	}
	
	public void restart() {
		fields.stream().forEach(c -> c.restart());
	}
	
	
	public int getLines() {
		return this.lines;
	}
	
	public int getColumns() {
		return this.columns;
	}
	
	public int getPlacarX() {
		return Board.scoreX;
	}
	
	public int getPlacarO() {
		return Board.scoreO;
	}
	
	public boolean tiedMatch() {
		int ac = 0;
		for (Field field : fields) {
			if(!field.getCharac().equalsIgnoreCase(" ")) ac++;
		}
		if(ac==9) return true;
		return false;
	}

	@Override
	public void eventHappened(Field field, EventField event) {

		if(event == EventField.MARKED && (!achievedGoal(new Player("X"))) || !achievedGoal(new Player("O")) ) {
			notifyObservers(false, false, false);
		}
		
		if(event == EventField.MARKED && (achievedGoal(new Player("X"))) && !achievedGoal(new Player("O"))) {
			scoreX++;
			notifyObservers(true, false, false);
			return;
		}
		
		if(event == EventField.MARKED && (!achievedGoal(new Player("X"))) && achievedGoal(new Player("O"))) {
			scoreO++;
			notifyObservers(false, true, false);	
			return;
		}
		
		if(event == EventField.MARKED && tiedMatch()) {
			notifyObservers(false, false, true);
		}
	}
	
	public void registerObserver(Consumer<EventResult> observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(boolean winnerPlayOne, boolean winnerPlayTwo, boolean tied) {
		observers.stream()
			.forEach(o -> o.accept(new EventResult(winnerPlayOne, winnerPlayTwo, tied)));
	}
	

}
