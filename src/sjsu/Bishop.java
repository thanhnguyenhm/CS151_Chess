package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Bishop piece implementation
 */
public class Bishop extends ChessPiece{
    /**
     * construct a Bishop piece
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Bishop(PlayerSide side) {
        super(side);
        if (side == PlayerSide.BLACK)
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-bishop.png"))));
        else
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-bishop.png"))));
    }
}
