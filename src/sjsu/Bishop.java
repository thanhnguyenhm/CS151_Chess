package sjsu;

/**
 * Bishop piece implementation
 */
public class Bishop extends ChessPiece{
    /**
     * construct a Bishop piece
     *
     * @param color black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Bishop(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
