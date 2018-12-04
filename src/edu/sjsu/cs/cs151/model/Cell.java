package edu.sjsu.cs.cs151.model;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A cell from a chess board
 */
public class Cell {

    private ChessPiece piece;
    private JPanel panel;

    /**
     * Default constructor
     * @param piece a ChessPiece
     * @param color background color of the square (cell)
     */
    public Cell(ChessPiece piece, Color color) {
    	panel = new JPanel(new BorderLayout());
    	panel.setBackground(color);
    	this.piece = piece;
    }
    
    public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		// check if cell is empty
		// if not, remove piece label before adding new
		if (this.piece != null)
			panel.removeAll();
		this.piece = piece;
		if (piece == null) return;
		panel.add(piece.getLabel());
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
