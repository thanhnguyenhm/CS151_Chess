package sjsu;

public class King extends ChessPiece{

    boolean underCheck;
    boolean underCheckmate;

    /**
     * default constructor
     *
     * @param color
     * @param location
     * @param captured
     */
    public King(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
