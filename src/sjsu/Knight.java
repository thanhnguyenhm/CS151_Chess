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
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Knight(PlayerSide side) {
        super(side);
        if (side == PlayerSide.BLACK)
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-knight.png"))));
        else
        	this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-knight.png"))));
    }
}
