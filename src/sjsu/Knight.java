package sjsu;

public class Knight extends ChessPiece{
    /**
     * default constructor
     *
     * @param color black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Knight(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
