package edu.sjsu.cs.cs151.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Knight piece implementation
 */
public class Knight extends ChessPiece{
	ArrayList<Integer> listOfValidMoves;
    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Knight(PlayerSide side, int location) {
        super(side, location);
        // initialize valid moves
		if (side == PlayerSide.BLACK)
			listOfValidMoves = new ArrayList<>(Arrays.asList(location + 15, location + 17));
		else listOfValidMoves = new ArrayList<>(Arrays.asList(location - 15, location - 17));
    }
    

    /**
     * Implements the strategy for piece's move (Knight)
     *
     * @param m a Chess move
     * @return false if cell is occupied by other same side's piece, true if capture other piece or not occupied
     */
    public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves

		// find all moves from current position start
		int start = m.getStart();
		int moves[] = {start - 6, start + 6, start - 10, start + 10, start + 15, start - 15, start + 17, start - 17};

		for (int num : moves) {
			if (num >= 0 && num <= 63) { // check for valid board size
				ChessPiece currentPiece = m.getBoard().getPiece(num);
				int x1 = start % 8;
				int y1 = start / 8;
				int x2 = num % 8;
				int y2 = num / 8;

				if (currentPiece == null) {// if cell is not occupied
					if ((Math.abs(x2 - x1)) == 2 && Math.abs((y2 - y1)) == 1) // if move is valid for knight
						listOfValidMoves.add(num);
					else if ((Math.abs(x2 - x1)) == 1 && Math.abs((y2 - y1)) == 2)
						listOfValidMoves.add(num);
				}
				else if (getColor() != currentPiece.getColor()) { // if capture other piece
					if ((Math.abs(x2 - x1)) == 2 && Math.abs((y2 - y1)) == 1) // if move is valid for knight
						listOfValidMoves.add(num);
					else if ((Math.abs(x2 - x1)) == 1 && Math.abs((y2 - y1)) == 2)
						listOfValidMoves.add(num);
				}
			}
		}

		return listOfValidMoves.contains(m.getEnd());

//	Nhien's work
//    	// Check that the end cell is empty or an opponent's piece
//    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null) // if the cell is occupied
//    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;  // occupied by same side
//    	if ((Math.abs(m.getX2()-m.getX1())) == 2 && Math.abs((m.getY2()-m.getY1())) == 1) // if move is valid for knight
//    		return true;
//    	else if ((Math.abs(m.getX2()-m.getX1())) == 1 && Math.abs((m.getY2()-m.getY1())) == 2)
//    		return true;
//    	else
//    		return false;
//    }
	}
}
