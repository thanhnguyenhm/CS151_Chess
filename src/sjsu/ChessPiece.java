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
     * check if the piece is captured
     * @return true if it is captured
     */
    boolean isCaptured() {
        return true;
    }

    /**
     * select a piece and update its location
     */
    void movePiece() {

    }

    /**
     * A player choose to select a piece before moving
     */
    void selectPiece() {

    }
}
