package sjsu;

public class King extends ChessPiece{

    boolean underCheck;
    boolean underCheckmate;

    /**
     * construct a King piece
     *
     * @param color black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public King(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
