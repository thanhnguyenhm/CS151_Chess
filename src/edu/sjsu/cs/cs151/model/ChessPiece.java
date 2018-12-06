package edu.sjsu.cs.cs151.model;

import java.util.ArrayList;

/**
 * An abstract class that comprises 6 types of chess pieces
 */
public abstract class ChessPiece {
    private PlayerSide color;
    private int location;    

    /**
     * Default constructor
     * @param color: color of piece (BLACK, WHITE)
     */
    public ChessPiece(PlayerSide color, int location) {
        this.color = color;
        this.location = location;
    }

    /**
     * Check if a move is valid
     * @return true if it is valid move
     */
    public boolean validMove(Move m) {
        return false;
    }

    /**
     * Get color of a player's side
     * @return color
     */
	public PlayerSide getColor() {
		return color;
	}
}