package edu.sjsu.cs.cs151.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;

/**
 * Queen piece implementation
 */
public class Queen extends ChessPiece{

	// list of all possible moves
	ArrayList<Integer> listOfValidMoves = new ArrayList<>();

    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Queen(PlayerSide side, int location) {
    	 super(side, location);
         //if (side == PlayerSide.BLACK)
         	//this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-queen.png"))));
         //else
         	//this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-queen.png"))));
    }
    
    /**
     * Implements the strategy for piece's move (Queen)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
	@SuppressWarnings("Duplicates")
    public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves
		ArrayList<Integer> major = new ArrayList<>(); // major diagonal moves
		ArrayList<Integer> minor = new ArrayList<>(); // minor diagonal moves
		ArrayList<Integer> vMoves = new ArrayList<>(); // vertical moves
		ArrayList<Integer> hMoves = new ArrayList<>(); // horizontal moves
		ArrayList<Integer> moves = new ArrayList<>(); // total valid moves
		ChessPiece piece;
		boolean isOccupied = false;

		// Queen moves like Bishop---------------------
		// find x, y location of start
		int start = m.getStart();
		int x1 = start % 8;
		int y1 = start / 8;
		int x0, y0; // first cell in the major diagonal line
		int numCell;

		// Case 1: Queen moves in major diagonal line-------------------------
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

		// remove major diagonal cells that current queen can't jump to
		if (major.indexOf(start) != 0) {
			for (int i = major.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(major.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(major.get(i)) ;
        
				//piece = m.getBoard().getCell(major.get(i)).getPiece();
        
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

				piece = m.getBoard().getPiece(major.get(i)) ;
        
				//piece = m.getBoard().getCell(major.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}
		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		// Case 2: Queen moves in minor diagonal line---------------------------
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

		// remove minor diagonal cells that current queen can't jump to
		if (minor.indexOf(start) != 0) {
			for (int i = minor.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(minor.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(minor.get(i)) ;

				//piece = m.getBoard().getCell(minor.get(i)).getPiece();

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

				piece = m.getBoard().getPiece(minor.get(i)) ;

				//piece = m.getBoard().getCell(minor.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}

		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		for (int end : moves) {

			piece = m.getBoard().getPiece(end) ;

			//piece = m.getBoard().getCell(end).getPiece();

			if (piece == null) {// if cell is not occupied
				listOfValidMoves.add(end);
			}
			else if (getColor() != piece.getColor()) { // if capture other piece
				listOfValidMoves.add(end);
			}
		}

		// Queen moves like Rook--------------------
		// vertical moves
		for (int i = 0; i < 8; i++) {
			vMoves.add((i * 8) + x1); // add all valid vertical cells
		}

		moves.addAll(vMoves);

		// remove vertical cells that current queen can't jump to
		if (vMoves.indexOf(start) != 0) {
			for (int i = vMoves.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(vMoves.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(vMoves.get(i)) ;

				//piece = m.getBoard().getCell(vMoves.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}

		if (vMoves.indexOf(start) != vMoves.size() - 1) {
			for (int i = vMoves.indexOf(start) + 1; i < vMoves.size(); i++) {
				if (isOccupied) {
					moves.remove(vMoves.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(vMoves.get(i)) ;

				//piece = m.getBoard().getCell(vMoves.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}
		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		// horizontal moves
		for (int i = 0; i < 8; i++) {
			hMoves.add((y1 * 8) + i); // add all valid horizontal cells
		}

		moves.addAll(hMoves);

		// remove horizontal cells that current queen can't jump to
		if (hMoves.indexOf(start) != 0) {
			for (int i = hMoves.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(hMoves.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(hMoves.get(i)) ;

				//piece = m.getBoard().getCell(hMoves.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
			isOccupied = false; // reset
		}
		if (hMoves.indexOf(start) != vMoves.size() - 1) {
			for (int i = hMoves.indexOf(start) + 1; i < hMoves.size(); i++) {
				if (isOccupied) {
					moves.remove(hMoves.get(i));
					continue;
				}

				piece = m.getBoard().getPiece(hMoves.get(i)) ;

				//piece = m.getBoard().getCell(hMoves.get(i)).getPiece();

				if (piece != null) isOccupied = true;
			}
		}

		moves.remove(Integer.valueOf(start)); // remove cell that holds the piece itself

		for (int end : moves) {

			piece = m.getBoard().getPiece(end) ;
			//piece = m.getBoard().getCell(end).getPiece();


			if (piece == null) {// if cell is not occupied
				listOfValidMoves.add(end);
			}
			else if (getColor() != piece.getColor()) { // if capture other piece
				listOfValidMoves.add(end);
			}
		}

		return listOfValidMoves.contains(m.getEnd());

//    	// Check that the end cell is empty or an opponent's piece
//    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
//    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;
//
//    	// Check that any cells between start to end are all empty
//    	if (m.getY1() != m.getY2() && m.getX1() == m.getX2()) {
//			if (m.getY1() < m.getY2()) {
//				for (int i = m.getY1() + 1; i < m.getY2(); i++)
//					if (m.getBoard().getCell(m.getX1(), i).getPiece() != null)
//						return false;
//				return true;
//			} else {
//				for (int i = m.getY2() + 1; i < m.getY1(); i++)
//					if (m.getBoard().getCell(m.getX1(), i).getPiece() != null)
//						return false;
//				return true;
//			}
//		} else if (m.getY1() == m.getY2() && m.getX1() != m.getX2()) {
//			if (m.getX1() < m.getX2()) {
//				for (int i = m.getX1() + 1; i < m.getX2(); i++)
//					if (m.getBoard().getCell(i, m.getY1()).getPiece() != null)
//						return false;
//				return true;
//			} else {
//				for (int i = m.getX2() + 1; i < m.getX1(); i++)
//					if (m.getBoard().getCell(i, m.getY1()).getPiece() != null)
//						return false;
//				return true;
//			}
//		}
//
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