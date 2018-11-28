package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Pawn piece implementation
 */
public class Pawn extends ChessPiece{

	private boolean hasMoved;
	//private boolean isPromoted;

    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Pawn(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-pawn.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-pawn.png"))));
         hasMoved = false;
    }
    
    /**
     * Implements the strategy for piece's move (Pawn)
     *
     * @param m a Chess move
     * @return true or false for validMove of chess piece
     */
    public boolean validMove(Move m) {
    	
		// Special rules
    	if (hasMoved == false) {
    		if (getColor() == PlayerSide.BLACK) {
    			if (m.getY1() + 2 == m.getY2()) 			
    				if (m.getX1() == m.getX2())
    					return true;
    		} else {
    			if (m.getY1() - 2 == m.getY2()) 
    				if (m.getX1() == m.getX2()) 
    					return true;
    		}
    	}
    	
    	// Regular rules
		if (getColor() == PlayerSide.BLACK) {
			if (m.getY1() + 1 == m.getY2())
				switch (m.getX2() - m.getX1()) {
				// move
				case 0: 
					if (m.getBoard().getCell(m.getEnd()).getPiece() == null) 
						return true;
					break;
				// capture
				case 1:
				case -1:
					if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
						if (m.getBoard().getCell(m.getEnd()).getPiece().getColor() != PlayerSide.BLACK) 
							return true;
					break;
				}    			
		} else {        			     			
			if (m.getY1() - 1 == m.getY2())
				switch (m.getX2() - m.getX1()) {
				// move
				case 0: 
					if (m.getBoard().getCell(m.getEnd()).getPiece() == null) 
						return true;
					break;
				// capture
				case 1:
				case -1:
					if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
						if (m.getBoard().getCell(m.getEnd()).getPiece().getColor() != PlayerSide.WHITE) 
							return true;
					break;
				}
		}
		return false;
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
