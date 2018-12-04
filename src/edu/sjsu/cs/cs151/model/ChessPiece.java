package edu.sjsu.cs.cs151.model;

import javax.swing.JLabel;
import java.util.ArrayList;


//TODO Remove all methods: responsibility of Model?

/**
 * An abstract class that comprises 6 types of chess pieces
 */
public abstract class ChessPiece {

	private JLabel label;
    private PlayerSide color;
    private int location;
    // private Cell location;  //should Chessboard have location instead?
    // private boolean captured;
    

    /**
     * default constructor
     * @param color: color of piece (BLACK, WHITE)
     */
    public ChessPiece(PlayerSide color, int location) {
        this.color = color;
        this.location = location;
        // this.captured = false;
    }

    /**
     * check if a move is valid
     * @return true if it is valid move
     */
    public boolean validMove(Move m) {
        return false;
    }

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public PlayerSide getColor() {
		return color;
	}
}
