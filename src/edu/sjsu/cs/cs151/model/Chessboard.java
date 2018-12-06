package edu.sjsu.cs.cs151.model;

/**
 * A chess board with 64 piece (most are null)
 */
public class Chessboard {
	private ChessPiece[] piece;

    /**
     * Chess board constructor 
     */
	public Chessboard() {
		piece = new ChessPiece[64];
		for (int i = 0; i < 64; i++)
        	piece[i] = null;
        for (int i = 0; i < 64; i++) {
        	switch(i) {
        	case 0:
        	case 7:
        		piece[i] = new Rook(PlayerSide.BLACK, i);
        		break;        		
        	case 1:
        	case 6:
        		piece[i] = new Knight(PlayerSide.BLACK, i);
        		break;
        	case 2:
        	case 5:
        		piece[i] = new Bishop(PlayerSide.BLACK, i);
        		break;
        	case 3:
        		piece[i] = new Queen(PlayerSide.BLACK, i);
        		break;
        	case 4:
        		piece[i] = new King(PlayerSide.BLACK, i);
        		break;
        	case 8:
        		for (int j = 0; j < 8; j++)
        			piece[j + i] = new Pawn(PlayerSide.BLACK, j + i);
        		break;
        	case 56:
        	case 63:
        		piece[i] = new Rook(PlayerSide.WHITE, i);
        		break;        		
        	case 57:
        	case 62:
        		piece[i] = new Knight(PlayerSide.WHITE, i);
        		break;
        	case 58:
        	case 61:
        		piece[i] = new Bishop(PlayerSide.WHITE, i);
        		break;
        	case 59:
        		piece[i] = new Queen(PlayerSide.WHITE, i);
        		break;
        	case 60:
        		piece[i] = new King(PlayerSide.WHITE, i);
        		break;
        	case 48:
        		for (int j = 0; j < 8; j++)
        			piece[j + i] = new Pawn(PlayerSide.WHITE, j + i);
        		break;
        	}
    	}
    }

    /**
     * Get the chess piece
     * @param i index 
     * @return i index
     */
	public ChessPiece getPiece(int i) {
		return piece[i];
	}
	
	// Method for alternative logic saved for reference 
	public ChessPiece getPiece(int x, int y) {
		int i = 8 * y + x;
		return piece[i];
	}
	
    /**
     * Set the chess piece
     * @param i index 
     * @param piece the chess piece
     */
	public void setPiece(int i, ChessPiece piece) {
		this.piece[i] = piece;		
	}
}
