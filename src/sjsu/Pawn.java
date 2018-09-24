package sjsu;

public class Pawn extends ChessPiece{

    boolean firstMove;
    boolean isPromoted;

    /**
     * default constructor
     *
     * @param color black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Pawn(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
