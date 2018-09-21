package sjsu;

/**
 * A cell from a chessboard
 */
public class Cell {

    int row;
    int column;
    boolean occupied;

    /**
     * Default constructor
     * @param row, col, isOccupied
     */
    public Cell(int row, int col, boolean isOccupied) {
        this.row = row;
        this.column = col;
        this.occupied = isOccupied;
    }
}
