package sjsu;

public class Pawn extends ChessPiece{

    boolean firstMove;
    boolean isPromoted;

    /**
     * default constructor
     *
     * @param color
     * @param location
     * @param captured
     */
    public Pawn(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
