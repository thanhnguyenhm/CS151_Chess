package edu.sjsu.cs.cs151.model;

import java.util.ArrayList;

/**
 * King piece implementation
 */
public class King extends ChessPiece{
    private boolean hasMoved;
    private boolean underCheck;
    private boolean underCheckmate;
	ArrayList<Integer> listOfValidMoves = new ArrayList<>();

    /**
     * construct a King piece
     *
     *@param side Player's color, black or white
     */
    public King(PlayerSide side, int location) {
    	 super(side, location);
         hasMoved = false;
         underCheck = false;
         underCheckmate = false;
    }
    
    /**
     * Implements the strategy for piece's move (King)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
	public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves

		int start = m.getStart();

		ChessPiece currentPiece;

		// find all moves from current position start
		int[] moves = {start - 9, start - 8, start - 7, start - 1, start + 1, start + 7, start + 8, start + 9};

		for (int num : moves) {
			if (num >= 0 && num <= 63) { // check for valid board size
				currentPiece = m.getBoard().getPiece(num);
				int x1 = start % 8;
				int y1 = start / 8;
				int x2 = num % 8;
				int y2 = num / 8;

				if (currentPiece == null) {// if cell is not occupied
					if ((Math.abs(x2 - x1)) <= 1 && Math.abs((y2 - y1)) <= 1) // if move is valid for king
						listOfValidMoves.add(num);
				}
				else if (getColor() != currentPiece.getColor()) { // if capture other piece
					if ((Math.abs(x2 - x1)) <= 1 && Math.abs((y2 - y1)) <= 1) // if move is valid for king
						listOfValidMoves.add(num);
				}
			}
		}

		return listOfValidMoves.contains(m.getEnd());

//		// Check that the end cell is empty or an opponent's piece
//		if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
//			if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;
//		if ((Math.abs(m.getX2()-m.getX1())) <= 1 && Math.abs((m.getY2()-m.getY1())) <= 1)
//			return true;
//		else
//			return false;
	}

    public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
