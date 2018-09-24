package sjsu;

public class Rook extends ChessPiece{
	
	boolean hasMoved;
	
    /**
     * default constructor
     *
     * @param color
     * @param location
     * @param captured
     */
    public Rook(Color color, Cell location, boolean captured) {
        super(color, location, captured);
    }
}
