package edu.sjsu.cs.cs151.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;


/**
 * Rook piece implementation
 */
public class Rook extends ChessPiece{

	// instance field
	ArrayList<Integer> listOfValidMoves = new ArrayList<>();
	private boolean hasMoved;

    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Rook(PlayerSide side, int location) {
    	 super(side, location);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png"))));                 
    }
    
    /**
     * Implements the strategy for piece's move (Rook)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
	@SuppressWarnings("Duplicates")
    public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves
		ArrayList<Integer> vMoves = new ArrayList<>();
		ArrayList<Integer> hMoves = new ArrayList<>();
		ArrayList<Integer> moves = new ArrayList<>();
		ChessPiece piece;
		boolean isOccupied = false;

		// find all possible moves from current position start
		int start = m.getStart();
		int x1 = start % 8;
		int y1 = start / 8;

		// vertical moves
		for (int i = 0; i < 8; i++) {
			vMoves.add((i * 8) + x1); // add all valid vertical cells
		}

		moves.addAll(vMoves);

		// remove vertical cells that current rook can't jump to
		if (vMoves.indexOf(start) != 0) {
			for (int i = vMoves.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(vMoves.get(i));
					continue;
				}
				piece = m.getBoard().getCell(vMoves.get(i)).getPiece();
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
				piece = m.getBoard().getCell(vMoves.get(i)).getPiece();
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

		// remove horizontal cells that current rook can't jump to
		if (hMoves.indexOf(start) != 0) {
			for (int i = hMoves.indexOf(start) - 1; i >= 0 ; i--) {
				if (isOccupied) {
					moves.remove(hMoves.get(i));
					continue;
				}
				piece = m.getBoard().getCell(hMoves.get(i)).getPiece();
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
				piece = m.getBoard().getCell(hMoves.get(i)).getPiece();
				if (piece != null) isOccupied = true;
			}
		}

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
//    	return false;
    }
    
    /**
     * Flags whether Rook has moved (for Castling)
     *
     * @param hasMoved flags true or false
     */
    public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
