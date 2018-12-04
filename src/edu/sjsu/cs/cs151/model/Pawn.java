package edu.sjsu.cs.cs151.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pawn piece implementation
 */
public class Pawn extends ChessPiece{

	private boolean hasMoved;
	//private boolean isPromoted;
	// instance field
	ArrayList<Integer> listOfValidMoves;

	/**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Pawn(PlayerSide side, int location) {
    	 super(side, location);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-pawn.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-pawn.png"))));
         hasMoved = false;

		// initialize valid moves
		if (side == PlayerSide.BLACK)
			listOfValidMoves = new ArrayList<>(Arrays.asList(location + 8, location + 16));
		else listOfValidMoves = new ArrayList<>(Arrays.asList(location - 8, location - 16));
    }
    
    /**
     * Implements the strategy for piece's move (Pawn)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
    public boolean validMove(Move m) {

		listOfValidMoves.clear(); //reset valid moves

		// find all moves from current position start
		int start = m.getStart();
		int x1 = start % 8;
		int y1 = start / 8;
		int x2, y2;
		int end;
		ChessPiece currentPiece;

		// Pawn's first move of the game
    	if (!hasMoved) {
    		if (getColor() == PlayerSide.BLACK) {
				// Case 0: black pawn special move without capture
				end = start + 16;
				currentPiece = m.getBoard().getCell(end).getPiece();
				if (end >= 0 && end <= 63) {
					if (currentPiece == null) listOfValidMoves.add(end);
				}

    		} else {
				// Case 0: white pawn special move without capture
				end = start - 16;
				currentPiece = m.getBoard().getCell(end).getPiece();
				if (end >= 0 && end <= 63) {
					if (currentPiece == null) listOfValidMoves.add(end);
				}
    		}
    	}

    	// Regular rules
		if (getColor() == PlayerSide.BLACK) {
			// Case 1: black pawn move without capture
			end = start + 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if (currentPiece == null) listOfValidMoves.add(end);
			}

			// Case 2: black pawn capture to the left
			end = start + 7;
			x2 = end % 8;
			y2 = end / 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if ((x1 - x2 == 1) && (y2 - y1 == 1))
					if (currentPiece != null && getColor() != currentPiece.getColor()) listOfValidMoves.add(end);
			}

			// Case 3: black pawn capture to the right
			end = start + 9;
			x2 = end % 8;
			y2 = end / 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if ((x2 - x1 == 1) && (y2 - y1 == 1))
					if (currentPiece != null && getColor() != currentPiece.getColor()) listOfValidMoves.add(end);
			}

		} else {
			// Case 1: white pawn move without capture
			end = start - 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if (currentPiece == null) listOfValidMoves.add(end);
			}

			// Case 2: white pawn capture to the left
			end = start - 9;
			x2 = end % 8;
			y2 = end / 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if ((x1 - x2 == 1) && (y1 - y2 == 1))
					if (currentPiece != null && getColor() != currentPiece.getColor()) listOfValidMoves.add(end);
			}

			// Case 3: white pawn capture to the right
			end = start - 7;
			x2 = end % 8;
			y2 = end / 8;
			currentPiece = m.getBoard().getCell(end).getPiece();
			if (end >= 0 && end <= 63) {
				if ((x2 - x1 == 1) && (y1 - y2 == 1))
					if (currentPiece != null && getColor() != currentPiece.getColor()) listOfValidMoves.add(end);
			}
		}

		return listOfValidMoves.contains(m.getEnd());

    	
//    	// Regular rules
//		if (getColor() == PlayerSide.BLACK) {
//			if (m.getY1() + 1 == m.getY2())
//				switch (m.getX2() - m.getX1()) {
//				// move
//				case 0:
//					if (m.getBoard().getCell(m.getEnd()).getPiece() == null)
//						return true;
//					break;
//				// capture
//				case 1:
//				case -1:
//					if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
//						if (m.getBoard().getCell(m.getEnd()).getPiece().getColor() != PlayerSide.BLACK)
//							return true;
//					break;
//				}
//		} else {
//			if (m.getY1() - 1 == m.getY2())
//				switch (m.getX2() - m.getX1()) {
//				// move
//				case 0:
//					if (m.getBoard().getCell(m.getEnd()).getPiece() == null)
//						return true;
//					break;
//				// capture
//				case 1:
//				case -1:
//					if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
//						if (m.getBoard().getCell(m.getEnd()).getPiece().getColor() != PlayerSide.WHITE)
//							return true;
//					break;
//				}
//		}
//		return false;
    }
    /**
     * @param hasMoved flags true or false
     */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
