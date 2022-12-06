package com.github.Fa2bio.TicTacToe.vision;

import javax.swing.JFrame;

import com.github.Fa2bio.TicTacToe.model.Board;

@SuppressWarnings("serial")
public class MainScreen extends JFrame{

	public MainScreen() {
		
		Board board = new Board();
		add(new BoardPanel(board));
		
		setTitle("TicTacToe");
		setSize(350,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainScreen();
	}
}
