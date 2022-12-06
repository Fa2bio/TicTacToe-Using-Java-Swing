package com.github.Fa2bio.TicTacToe.vision;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.github.Fa2bio.TicTacToe.model.Board;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel{
	
	public BoardPanel(Board board) {
		setLayout(new GridLayout(board.getLines(),board.getColumns()));
		
		board.forEachFields(c -> add(new FieldButton(c))); 
		
		board.registerObserver(e -> {
			SwingUtilities.invokeLater(()-> {
				if(e.playerOneisWinner()) {
					JOptionPane.showMessageDialog(this, "Player X won");
					board.restart();
				}
				else if(e.playerTwoisWinner()) {
					JOptionPane.showMessageDialog(this, "Player O won");
					board.restart();
				}
				else if(e.isTied()) {
					JOptionPane.showMessageDialog(this, "Tied match");
					board.restart();
				}
				
			});
		});
	}
}
