package edu.sjsu.cs.cs151.model;



import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.ArrayList;

/**
 * Bishop piece implementation
 */
public class Bishop extends ChessPiece{

	// Thanh's work
	// instance field
	ArrayList<Integer> listOfValidMoves = new ArrayList<>();

    /**
     * construct a Bishop piece
     *
     * @param side Player's color, black or white
     */
    public Bishop(PlayerSide side, int location) {
        super(side, location);
    }
    
    /**
     * Implements the strategy for piece's move (Bishop)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
	@SuppressWarnings("Duplicates")
    public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves
		ArrayList<Integer> major = new ArrayList<>(); // major diagonal moves
		ArrayList<Integer> minor = new ArrayList<>(); // minor diagonal moves
		ArrayList<Integer> moves = new ArrayList<>(); // total valid moves
		ChessPiece piece;
		boolean isOccupied = false;

		// find x, y location of start
		int start = m.getStart();
		int x1 = start % 8;
		int y1 = start / 8;
		int x0, y0; // first cell in the major diagonal line
		int numCell;

		// Case 1: Bishop moves in major diagonal line-------------------------
		// Project to first cell in the major diagonal line
		if (x1 < y1) {
			x0 = 0;
			y0 = y1 - x1;
		} else if (x1 > y1) {
			x0 = x1 - y1;
			y0 = 0;
		} else {
			x0 = 0;
			y0 = 0;
		}

		// add all major diagonal cells
		for (int i = 0; i < 8 - Math.abs(x1 - y1); i++) {
			major.add((y0 * 8 + x0) + (9 * i));
		}

		moves.addAll(major);

		// remove major diagonal cells that current bishop can't jump to
		if (major.indexOf(start) != 0) {
			for (int i = major.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(major.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(major.get(i));

				piece = m.getBoard().getCell(major.get(i)).getPiece();
				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}

		if (major.indexOf(start) != major.size() - 1) {
			for (int i = major.indexOf(start) + 1; i < major.size(); i++) {
				if (isOccupied) {
					moves.remove(major.get(i));
					continue;
				}
				piece = m.getBoard().getCell(major.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}


		if (major.indexOf(start) != major.size() - 1) {
			for (int i = major.indexOf(start) + 1; i < major.size(); i++) {
				if (isOccupied) {
					moves.remove(major.get(i));
					continue;
				}
				piece = m.getBoard().getPiece(major.get(i));
				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}


		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		// Case 2: Bishop moves in minor diagonal line---------------------------
		// Project to first cell in the minor diagonal line
		if (x1 + y1 <= 7) {
			x0 = x1 + y1;
			y0 = 0;
		} else {
			x0 = 7;
			y0 = x1 + y1 - 7;
		}

		// calculate number of cell in the minor diagonal line
		if (x1 + y1 <= 7) {
			numCell = x1 + y1 + 1;
		} else {
			numCell = 15 - (x1 + y1);
		}

		// add all minor diagonal cells
		for (int i = 0; i < numCell; i++) {
			minor.add((y0 * 8 + x0) + (7 * i));
		}

		moves.addAll(minor);

		// remove minor diagonal cells that current bishop can't jump to
		if (minor.indexOf(start) != 0) {
			for (int i = minor.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(minor.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(minor.get(i));

				piece = m.getBoard().getCell(minor.get(i)).getPiece();
				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}

		if (minor.indexOf(start) != minor.size() - 1) {
			for (int i = minor.indexOf(start) + 1; i < minor.size(); i++) {
				if (isOccupied) {
					moves.remove(minor.get(i));
					continue;
				}
				piece = m.getBoard().getCell(minor.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}


		if (minor.indexOf(start) != minor.size() - 1) {
			for (int i = minor.indexOf(start) + 1; i < minor.size(); i++) {
				if (isOccupied) {
					moves.remove(minor.get(i));
					continue;
				}
				piece = m.getBoard().getPiece(minor.get(i));
				if (piece != null) isOccupied = true;
			}
		}

		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		for (int end : moves) {
			piece = m.getBoard().getPiece(end);

		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		for (int end : moves) {
			piece = m.getBoard().getCell(end).getPiece();
 

			if (piece == null) {// if cell is not occupied
				listOfValidMoves.add(end);
			}
			else if (getColor() != piece.getColor()) { // if capture other piece
				listOfValidMoves.add(end);
			}
		}

		return listOfValidMoves.contains(m.getEnd());

//		// Check that the end cell is empty or an opponent's piece
//    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
//    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;

//    	// Check that dX = dY
//    	if ((Math.abs(m.getX2()-m.getX1())) != Math.abs((m.getY2()-m.getY1()))) return false;
//
//    	// Check that any cells between start to end are all empty
//    	if (m.getX1() < m.getX2()) {
//			// Going right and down
//    		if (m.getY1() < m.getY2()) {
//				for (int i = 1; i < m.getY2() - m.getY1(); i++)
//					if (m.getBoard().getCell(m.getX1()+i, m.getY1()+i).getPiece() != null)
//						return false;
//				return true;
//			// Going right and up
//			} else {
//				for (int i = 1; i < m.getY1() - m.getY2(); i++)
//					if (m.getBoard().getCell(m.getX1()+i, m.getY1()-i).getPiece() != null)
//						return false;
//				return true;
//			}
//		} else {
//			// Going left and down
//			if (m.getY1() < m.getY2()) {
//				for (int i = 1; i < m.getX2() - m.getX1(); i++)
//					if (m.getBoard().getCell(m.getX1()-i, m.getY1()+i).getPiece() != null)
//						return false;
//				return true;
//			// Going left and up
//			} else {
//				for (int i = 1; i < m.getX1() - m.getX2(); i++)
//					if (m.getBoard().getCell(m.getX1()-i, m.getY1()-i).getPiece() != null)
//						return false;
//				return true;
//			}
//		}
    }
}