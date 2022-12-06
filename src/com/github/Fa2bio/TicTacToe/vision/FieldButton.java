package com.github.Fa2bio.TicTacToe.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.github.Fa2bio.TicTacToe.model.Field;
import com.github.Fa2bio.TicTacToe.model.Player;
import com.github.Fa2bio.TicTacToe.observers.EventField;
import com.github.Fa2bio.TicTacToe.observers.ObserverField;

@SuppressWarnings("serial")
public class FieldButton 
	extends JButton implements ObserverField, MouseListener{
	
	private Field field;
	
	private static boolean playerOneTurn = true;
	private static boolean playerTwoTurn = !playerOneTurn;
	
	public FieldButton(Field field) {
		this.field = field;
		addMouseListener(this);
		field.registerObserver(this);
	}

	@Override
	public void eventHappened(Field field, EventField event) {
		switch(event) {
		case TOGGLECHARACPLAYERONE:
			applyToggleCharacStylePlayerOne();
			break;
		case TOGGLECHARACPLAYERTWO:
			applyToggleCharacStylePlayerTwo();
			break;
		case RESTART:
			aplyDefaultStyle();
			break;
		default:
			break;
		}
		
	}
	

	private void applyToggleCharacStylePlayerOne() {
		setForeground(Color.BLACK);
		setText("X");
		getFont();
		setFont(new Font("Arial", Font.BOLD, 40));
		playerOneTurn = false;
		playerTwoTurn = !playerOneTurn;
	}
	
	private void applyToggleCharacStylePlayerTwo() {
		setForeground(Color.RED);
		setText("O");
		setFont(new Font("Arial", Font.BOLD, 40));
		playerTwoTurn = false;
		playerOneTurn = !playerTwoTurn;
	}
	private void aplyDefaultStyle() {
		setText("");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==1 && playerOneTurn) {
			field.toMark(new Player("X", true));
			field.toggleMarcked();
		}
		else{
			if(playerTwoTurn) {
				field.toMark(new Player("O", true));
				field.toggleMarcked();
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
