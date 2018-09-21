package sjsu;

/**
 * a chess piece
 */
public class ChessPiece {

    Color color;
    Cell location;
    boolean captured;

    /**
     * default constructor
     * @param color
     * @param location
     * @param captured
     */
    public ChessPiece(Color color, Cell location, boolean captured) {
        this.color = color;
        this.location = location;
        this.captured = captured;
    }

    /**
     * check if a move is valid
     * @return
     */
    boolean validMove() {
        return true;
    }

    /**
     *
     */
    void capture() {

    }

    /**
     *
     */
    void isCaptured() {

    }

    /**
     *
     */
    void movePiece() {

    }
}
