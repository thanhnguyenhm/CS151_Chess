package sjsu;

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
    public Knight(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
