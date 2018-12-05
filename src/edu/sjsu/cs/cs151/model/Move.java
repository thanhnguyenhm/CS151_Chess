package edu.sjsu.cs.cs151.model;

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
	private static PlayerSide playerTurn = PlayerSide.WHITE; // white moves first

    /**
     *
     * @param board: current status of the board
     * @param start: start position when the mouse is pressed
     * @param end: end position when the mouse is released
     */
    public Move(int start, int end) {
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
    // Currently broken...
    //TODO: Add args for piece, start pos, end pos so this method can be passed through MoveValve
    // TODO!: Add board.setPiece(i) and board.setPiece(x,y) to handle updates to ChessBoard, use null for no piece
    public boolean tryMove() {
    	if (board.getPiece(start).getColor() == playerTurn) { // check if play turn is valid
			if (board.getPiece(start).validMove(this)) { // check if move is valid
				board.setPiece(end, board.getPiece(start)); // then place piece in end
				board.setPiece(start, null); // and remove piece in start

				if (board.getPiece(end) instanceof Pawn) // check if pawn has moved TODO: pawn special move
					((Pawn)board.getPiece(end)).setHasMoved(true); // type-cast an object
				if (board.getPiece(end) instanceof Rook) // check if rook has moved TODO: for castling
					((Rook)board.getPiece(end)).setHasMoved(true); // type-cast an object
				if (board.getPiece(end) instanceof King) // check if king has moved
					((King)board.getPiece(end)).setHasMoved(true); // type-cast an object

				// change player turn
				if (playerTurn == PlayerSide.WHITE) playerTurn = PlayerSide.BLACK;
				else playerTurn = PlayerSide.WHITE;

				return true;	
			}
		}
		// TODO: send a message to View to reset layer that has the piece label that we moved
		return false;
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

	/**
	 * Reset play turn when user click New Game
	 */
	public static void resetPlayTurn() {
    	playerTurn = PlayerSide.WHITE;
	}
}
