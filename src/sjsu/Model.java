package sjsu;

/**
 * Class Model stores all the information about the current state of the game
 */
public class Model {
    Chessboard chessboard;
    Cell cell;
    Game game;
    Player player;
    Move move;
    ChessPiece chesspiece;
    boolean isOver;
    
    /**
     * Initiate a chess game
     */
    void initiateGame() {

    }

    /**
     * Game over when checkmate or stalemate return true
     */
    void gameOver() {

    }    
    
    /**
     * A player selects a piece to try and move
     */
    void selectPiece() {

    }   
    
    /**
     * Check if a move is valid
     * @return true if it is valid move
     */
    boolean validMove() {
        return true;
    }
    
    // TODO Instructor-suggested method. What will it do?
    /**
     * Try and execute a proposed move
     */
    void tryAndExecuteMove() {

    }    

    /**
     * Move a piece and update its location
     */
    void movePiece() {

    }      

    /**
     * A piece's ability to capture other piece
     */
    void capture() {

    }

    /**
     * Check if piece is captured
     * @return true if it is captured
     */
    boolean isCaptured() {
        return true;
    }
    
    /**
     * Check if king is under checkmate
     * @return true if king is under checkmate
     */
    boolean checkForCheckmate() {
        return true;
    }
    
    /**
     * Check if king is under "check" by another piece
     * @return true if king is under "check"
     */
    boolean checkForCheck() {
        return true;
    }  
    
    /**
     * Check if pawn is eligible for promotion
     * @return true if pawn is promoted
     */
    boolean checkForPromotion() {
        return true;
    }
    
    /**
     * Check if no additional moves are possible (stalemate)
     * @return true if player is in stalemate
     */
    boolean checkForStalemate() {
        return true;
    }    
    
    /**
     * Check if the game is over
     * @return true if game is over
     */
    boolean checkIfGameOver() {
        return true;
    }       
       
}
