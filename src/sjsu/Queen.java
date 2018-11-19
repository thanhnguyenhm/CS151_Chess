package sjsu;

/**
 * Queen piece implementation
 */
public class Queen extends ChessPiece{
    /**
     * default constructor
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Queen(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
