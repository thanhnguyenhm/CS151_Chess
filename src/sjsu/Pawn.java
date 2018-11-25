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
     * @param playerSide black or white
     * @param location location on the chess board
     * @param captured false if the piece is still on the board
     */
    public Pawn(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-pawn.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-pawn.png"))));
         hasMoved = false;
    }
    
    boolean validMove(Move m) {
    	int startingRow = m.getStart()/8;
		int endingRow = m.getEnd()/8;
		int startingCol = m.getStart()%8;
		int endingCol = m.getEnd()%8;
		
		// Special rules
    	if (hasMoved == false) {
    		if (getColor() == PlayerSide.BLACK) {
    			if (startingRow + 2 == endingRow) 			
    				if (startingCol == endingCol)
    					return true;
    		} else {
    			if (startingRow - 2 == endingRow) 
    				if (startingCol == endingCol) 
    					return true;
    		}
    	}
    	
    	// Regular rules
		if (getColor() == PlayerSide.BLACK) {
			if (startingRow + 1 == endingRow)
				switch (endingCol - startingCol) {
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
			if (startingRow - 1 == endingRow)
				switch (endingCol - startingCol) {
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

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
