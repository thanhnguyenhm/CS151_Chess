package edu.sjsu.cs.cs151.model;

/**
 * Stores and validates the information of a potential move
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
     * Constructor for a Move
     * @param board: current status of the board
     * @param start: start position when the mouse is pressed
     * @param end: end position when the mouse is released
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
    * Check tryMove before moving piece, called in MoveValve move piece
    * @return whether move is valid 
    */   
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

				// change player turn after a successful move
				if (playerTurn == PlayerSide.WHITE) playerTurn = PlayerSide.BLACK;
				else playerTurn = PlayerSide.WHITE;

				return true;	
			}
		}
		return false;
    }
    
	/**
	 * Get x1 starting coordinate
	 * @return x1 position
	 */
	public int getX1() {
		return x1;
	}
	
	/**
	 * Get x2 ending coordinate
	 * @return x2 position
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * Get y1 starting coordinate
	 * @return y1 position
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * Get y1 ending coordinate
	 * @return y1 position
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * Getter for the chess board so that pieces can check for validMoves
	 * @return board 
	 */
	public Chessboard getBoard() {
		return board;
	}

	/**
	 * Get start position
	 * @return start 
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Get end position
	 * @return end 
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * Reset player turn when user clicks New Game button - white goes first
	 */
	public static void resetPlayTurn() {
    	playerTurn = PlayerSide.WHITE;
	}
}
