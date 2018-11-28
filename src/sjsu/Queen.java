package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Queen piece implementation
 */
public class Queen extends ChessPiece{
    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Queen(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
         	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-queen.png"))));
         else
         	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-queen.png"))));
    }
    
    /**
     * Implements the strategy for piece's move (Queen)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
    public boolean validMove(Move m) {  
    	return false;
    }
}
