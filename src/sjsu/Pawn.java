package sjsu;

/**
 * Pawn piece implementation
 */
public class Pawn extends ChessPiece{

    boolean firstMove;
    boolean isPromoted;

    /**
     * default constructor
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Pawn(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
