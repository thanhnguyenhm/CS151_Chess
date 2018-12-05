package edu.sjsu.cs.cs151.model;

/**
 * Bishop piece implementation
 */
public class Bishop extends ChessPiece{
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
    	
    	// Check that the end cell is empty or an opponent's piece
    	if (m.getBoard().getPiece(m.getEnd()) != null)
    		if (getColor() == m.getBoard().getPiece(m.getEnd()).getColor()) return false;
    	
    	// Check that dX = dY
    	if ((Math.abs(m.getX2()-m.getX1())) != Math.abs((m.getY2()-m.getY1()))) return false;
    	    	
    	// Check that any cells between start to end are all empty
    	if (m.getX1() < m.getX2()) {
			// Going right and down
    		if (m.getY1() < m.getY2()) {
				for (int i = 1; i < m.getY2() - m.getY1(); i++)
					if (m.getBoard().getPiece(m.getX1()+i, m.getY1()+i) != null)
						return false;
				return true;
			// Going right and up
			} else {
				for (int i = 1; i < m.getY1() - m.getY2(); i++)
					if (m.getBoard().getPiece(m.getX1()+i, m.getY1()-i) != null)
						return false;
				return true;
			}
		} else {
			// Going left and down
			if (m.getY1() < m.getY2()) {
				for (int i = 1; i < m.getX2() - m.getX1(); i++)
					if (m.getBoard().getPiece(m.getX1()-i, m.getY1()+i) != null)
						return false;
				return true;
			// Going left and up
			} else {
				for (int i = 1; i < m.getX1() - m.getX2(); i++)
					if (m.getBoard().getPiece(m.getX1()-i, m.getY1()-i) != null)
						return false;
				return true;
			}
		}
    }
}
