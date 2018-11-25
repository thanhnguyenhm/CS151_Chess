package sjsu;

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
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public King(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-king.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-king.png"))));
    }
}
