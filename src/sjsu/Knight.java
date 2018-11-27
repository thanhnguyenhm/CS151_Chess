package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Knight piece implementation
 */
public class Knight extends ChessPiece{
    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Knight(PlayerSide side) {
        super(side);
        if (side == PlayerSide.BLACK)
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-knight.png"))));
        else
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-knight.png"))));
    }
    

    /**
     * Implements the strategy for piece's move (Knight)
     *
     * @param m a Chess move
     */
    public boolean validMove(Move m) {
    	
    	// Check that the end cell is empty or an opponent's piece
    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;    	  	
    	if ((Math.abs(m.getX2()-m.getX1())) == 2 && Math.abs((m.getY2()-m.getY1())) == 1)
    		return true;
    	else if ((Math.abs(m.getX2()-m.getX1())) == 1 && Math.abs((m.getY2()-m.getY1())) == 2)
    		return true;
    	else
    		return false;   	
    }
}
