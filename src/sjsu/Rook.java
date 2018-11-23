package sjsu;

/**
 * Rook piece implementation
 */
public class Rook extends ChessPiece{
	
	boolean hasMoved;
	
    /**
     * default constructor
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Rook(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
