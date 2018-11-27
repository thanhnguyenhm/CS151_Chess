package sjsu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * Rook piece implementation
 */
public class Rook extends ChessPiece{
	
	private boolean hasMoved;
	
    /**
     * default constructor
     *
     * @param side Player's color, black or white
     */
    public Rook(PlayerSide side) {
    	 super(side);
         if (side == PlayerSide.BLACK)
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png"))));
         else
        	 this.setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png"))));                 
    }
    
    /**
     * Implements the strategy for piece's move (Rook)
     *
     * @param m a Chess move
     */
    public boolean validMove(Move m) {
    	
    	// Check that the end cell is empty or an opponent's piece
    	if (m.getBoard().getCell(m.getEnd()).getPiece() != null)
    		if (getColor() == m.getBoard().getCell(m.getEnd()).getPiece().getColor()) return false;
    	
    	// Check that any cells between start to end are all empty
    	if (m.getY1() != m.getY2() && m.getX1() == m.getX2()) {
			if (m.getY1() < m.getY2()) {
				for (int i = m.getY1() + 1; i < m.getY2(); i++)
					if (m.getBoard().getCell(m.getX1(), i).getPiece() != null)
						return false;
				return true;
			} else {
				for (int i = m.getY2() + 1; i < m.getY1(); i++)
					if (m.getBoard().getCell(m.getX1(), i).getPiece() != null)
						return false;
				return true;
			}
		} else if (m.getY1() == m.getY2() && m.getX1() != m.getX2()) {
			if (m.getX1() < m.getX2()) {
				for (int i = m.getX1() + 1; i < m.getX2(); i++)
					if (m.getBoard().getCell(i, m.getY1()).getPiece() != null)
						return false;
				return true;
			} else {
				for (int i = m.getX2() + 1; i < m.getX1(); i++)
					if (m.getBoard().getCell(i, m.getY1()).getPiece() != null)
						return false;
				return true;
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
