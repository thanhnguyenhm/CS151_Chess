package sjsu;

/**
 * a generic class that comprise 6 types of pieces
 */
public class ChessPiece {

    Color color;
    Cell location;
    boolean captured;

    /**
     * default constructor
     * @param color color of a piece
     * @param location location of a piece on chess board
     * @param captured false if the piece is still on the board
     */
    public ChessPiece(Color color, Cell location, boolean captured) {
        this.color = color;
        this.location = location;
        this.captured = captured;
    }

    /**
     * check if a move is valid
     * @return true if it is valid move
     */
    boolean validMove() {
        return true;
    }

    /**
     * A piece's ability to capture other piece
     */
    void capture() {

    }

    /**
     * TODO it should return boolean right?
     */
    void isCaptured() {

    }

    /**
     * TODO add description here
     */
    void movePiece() {

    }
}
