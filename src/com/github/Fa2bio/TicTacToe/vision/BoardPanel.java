package com.github.Fa2bio.TicTacToe.vision;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.github.Fa2bio.TicTacToe.model.Board;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel{
	
	public BoardPanel(Board board) {
		setLayout(new GridLayout(board.getLines(),board.getColumns()));
		
		board.forEachFields(c -> add(new FieldButton(c))); 
		
		board.registerObserver(e -> {
			SwingUtilities.invokeLater(()-> {
				if(e.playerOneisWinner()) {
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 15)));
					JOptionPane.showMessageDialog(this, "Player X won");
					JOptionPane.showMessageDialog(this, String.format("Scoreboard \nX - %d \nO - %d", board.getPlacarX(), board.getPlacarO()));
					board.restart();
				}
				else if(e.playerTwoisWinner()) {
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 15)));
					JOptionPane.showMessageDialog(this, "Player O won");
					JOptionPane.showMessageDialog(this, String.format("Scoreboard \nX - %d \nO - %d", board.getPlacarX(), board.getPlacarO()));
					board.restart();
				}
				else if(e.isTied()) {
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 15)));
					JOptionPane.showMessageDialog(this, "Tied match");
					board.restart();
				}
				
			});
		});
	}
}
