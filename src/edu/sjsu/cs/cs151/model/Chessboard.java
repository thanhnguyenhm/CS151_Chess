package edu.sjsu.cs.cs151.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * A chess board with 32 black and 32 white cells
 */
public class Chessboard {
	private JPanel panel;
	private Cell[] cell;	

    /**
     * Constructs a chess board 
     */
	public Chessboard(Dimension boardSize) {
		// Construct a board panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		panel.setPreferredSize(boardSize);
		panel.setBounds(0, 0, boardSize.width, boardSize.height);
		
		// Construct the cells
		// Add each cell panel to board panel
		cell = new Cell[64];
		for (int i = 0; i < 64; i++) {
			 if ((i / 8) % 2 == 0) {
				 if (i % 2 == 0) {
				 	cell[i] = new Cell(null, Color.WHITE);
				 	panel.add(cell[i].getPanel());
				 } else {
				 	cell[i] = new Cell(null, Color.LIGHT_GRAY);
				 	panel.add(cell[i].getPanel());
				 }
			 } else {
				 if (i % 2 == 0) {
				  	cell[i] = new Cell(null, Color.LIGHT_GRAY);
				  	panel.add(cell[i].getPanel());
				  } else {
				  	cell[i] = new Cell(null, Color.WHITE);
				  	panel.add(cell[i].getPanel());
				  }
			 }
		}
		 
	    // Populate the board
        for (int i = 0; i < 64; i++) {
        	switch(i) {
        	
        	// Black pieces
        	case 0:
        	case 7:
        		cell[i].setPiece(new Rook(PlayerSide.BLACK, i));
        		break;        		
        	case 1:
        	case 6:
        		cell[i].setPiece(new Knight(PlayerSide.BLACK, i));
        		break;
        	case 2:
        	case 5:
        		cell[i].setPiece(new Bishop(PlayerSide.BLACK, i));
        		break;
        	case 3:
        		cell[i].setPiece(new Queen(PlayerSide.BLACK, i));
        		break;
        	case 4:
        		cell[i].setPiece(new King(PlayerSide.BLACK, i));
        		break;
        	case 8:
        		for (int j = 0; j < 8; j++)
        			cell[j + i].setPiece(new Pawn(PlayerSide.BLACK, i));
        		break;
        		
        	// White pieces
        	case 56:
        	case 63:
        		cell[i].setPiece(new Rook(PlayerSide.WHITE, i));
        		break;        		
        	case 57:
        	case 62:
        		cell[i].setPiece(new Knight(PlayerSide.WHITE, i));
        		break;
        	case 58:
        	case 61:
        		cell[i].setPiece(new Bishop(PlayerSide.WHITE, i));
        		break;
        	case 59:
        		cell[i].setPiece(new Queen(PlayerSide.WHITE, i));
        		break;
        	case 60:
        		cell[i].setPiece(new King(PlayerSide.WHITE, i));
        		break;
        	case 48:
        		for (int j = 0; j < 8; j++)
        			cell[j + i].setPiece(new Pawn(PlayerSide.WHITE, i));
        		break;
        	}
    	}        	
    }

    public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Cell getCell(int i) {
		return cell[i];
	}
	
	public Cell getCell(int x, int y) {
		int i = 8 * y + x;
		return cell[i];
	}
}
