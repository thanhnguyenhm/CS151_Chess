package sjsu;

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
    public Bishop(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
