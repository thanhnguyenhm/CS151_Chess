package edu.sjsu.cs.cs151.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * King piece implementation
 */
public class King extends ChessPiece{

    private boolean underCheck;
    private boolean underCheckmate;
    private boolean hasMoved;

    /**
     * construct a King piece
     *
     *@param side Player's color, black or white
     */
    public King(PlayerSide side, int location) {
    	 super(side, location);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-king.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-king.png"))));
    }
    
    /**
     * Implements the strategy for piece's move (King)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
	public boolean validMove(Move m) {
	    	
	    	// Check that the end cell is empty or an opponent's piece
	    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
	    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;    	  	
	    	if ((Math.abs(m.getX2()-m.getX1())) <= 1 && Math.abs((m.getY2()-m.getY1())) <= 1)
	    		return true;	    	
	    	else
	    		return false;   	
	}

    public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
