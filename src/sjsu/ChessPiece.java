package sjsu;

//TODO Remove all methods: responsibility of Model?

/**
 * An abstract class that comprises 6 types of chess pieces
 */
abstract class ChessPiece {

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
     * A player selects a piece to try and move
     */
    void selectPiece() {

    }    

    /**
     * Move a piece and update its location
     */
    void movePiece() {

    }
}
