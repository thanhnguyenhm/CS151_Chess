package sjsu;

/**
 *
 */
public class Move {
    ChessPiece piece;
    Cell startPosition;
    Cell endPosition;

    /**
     *
     * @param piece
     * @param startPosition
     * @param endPosition
     */
    public Move(ChessPiece piece, Cell startPosition, Cell endPosition) {
        this.piece = piece;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
