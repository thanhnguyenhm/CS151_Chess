package sjsu;

/**
 * Stores the information of a move
 */
public class Move {
	private Chessboard board;
	private int start;
	private int end;
	private int x1;
	private int x2;
	private int y1;
	private int y2;

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
        y1 = start/8;
		y2 = end/8;
		x1 = start%8;
		x2 = end%8;
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
            if (board.getCell(end).getPiece() instanceof Rook)
            	((Rook)board.getCell(end).getPiece()).setHasMoved(true); // type-cast an object
            if (board.getCell(end).getPiece() instanceof King)
            	((King)board.getCell(end).getPiece()).setHasMoved(true); // type-cast an object
            return true;
        } else {
        	board.getCell(start).setPiece(board.getCell(start).getPiece()); // reset layer
        	return false;
        }
    }

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
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
