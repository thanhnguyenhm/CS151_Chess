package sjsu;

/**
 * Stores the information of a move
 */
public class Move {
	private Chessboard board;
	private int start;
	private int end;

    /**
     *
     * @param piece
     * @param startPosition
     * @param endPosition
     */
    public Move(Chessboard board, int start, int end) {
        this.board = board;
        this.start = start;
        this.end = end;
    }
    
    /**
    * 
    * Check validMove, move piece 
    */
    public boolean tryMove() {
        if (board.getCell(start).getPiece().validMove(this) == true) {
        	board.getCell(end).setPiece(board.getCell(start).getPiece()); 
            board.getCell(start).setPiece(null);
            if (board.getCell(end).getPiece() instanceof Pawn)
            	((Pawn)board.getCell(end).getPiece()).setHasMoved(true); // type-cast an object
            /* TODOs
            if (board.getCell(start).getPiece() instanceof Rook)
            	((Rook)board.getCell(start).getPiece()).setHasMoved(true); // type-cast an object
            if (board.getCell(start).getPiece() instanceof King)
            	((King)board.getCell(start).getPiece()).setHasMoved(true); // type-cast an object
        	*/
            return true;
        } else {
        	board.getCell(start).setPiece(board.getCell(start).getPiece()); // reset layer
        	return false;
        }
    }

	public Chessboard getBoard() {
		return board;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
}
