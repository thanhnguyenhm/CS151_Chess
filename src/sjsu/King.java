package sjsu;

/**
 * King piece implementation
 */
public class King extends ChessPiece{

    boolean underCheck;
    boolean underCheckmate;

    /**
     * construct a King piece
     *
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public King(PlayerSide playerSide, Cell location, boolean captured) {
        super(playerSide, location, captured);
    }
}
