package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Rook piece implementation
 */
public class Rook extends ChessPiece{
	
	private boolean hasMoved;
	
    /**
     * default constructor
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Rook(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png"))));
    }
}
