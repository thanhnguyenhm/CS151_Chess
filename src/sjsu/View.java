package sjsu;

import javax.swing.*;

//import com.sun.xml.internal.ws.api.message.Message;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.util.concurrent.BlockingQueue;

/**
 * View class is a GUI that shows events and collects data from user
 */
public class View extends JFrame implements MouseListener, MouseMotionListener {
    private JFrame frame;
	private JLayeredPane layer;
	private Chessboard board;
	private JLabel label; // Temporary image for piece movement
    private JPanel topPanel;
    private JButton reset;
    private JButton quit;
	private Move move;
	private int ss = 75; // Square size
	private int ds = ss/2; // Cursor offset is half a cell square
	private Dimension boardSize = new Dimension(8 * ss, 8 * ss); // Board is 8x8 squares

	private int start, end;
	
    // View constructor
    public View() {
        startGame();

        // Add action listener to reset button
        reset.addActionListener(e -> {
            resetBoard();
        });

        // Add action listener to quit button
        quit.addActionListener(e -> {
            System.exit(0);
        });

        // Setup frame---------------------------------------------------------
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(layer, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Start Game
     */
    void startGame() {
        // Add components to LayeredPane object
        layer = new JLayeredPane();
        getContentPane().add(layer);
        layer.setPreferredSize(boardSize);
        layer.addMouseListener(this);
        layer.addMouseMotionListener(this);

        // Set up button
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        reset = new JButton("New Game");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        topPanel.add(reset, c);

        quit = new JButton("Quit");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        topPanel.add(quit, c);

        // add chess board to LayeredPane
        board = new Chessboard(boardSize);
        layer.add(board.getPanel(), JLayeredPane.DEFAULT_LAYER);
    }

    /**
     * reset everything to the initial state
     */
    void resetBoard() {
        frame.remove(layer);
        startGame();
        frame.add(layer);
        frame.setVisible(true);
    }

    /**
     * update status of a chess board
     */
    void refreshBoard() {
    	layer.removeAll(); //
        layer.add(board.getPanel(), JLayeredPane.DEFAULT_LAYER); // Updating the board
    }

    //TODO Refactor so that Message events are added to queue and sent through valves to Controller
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label = null;
        start = (e.getX()/ss) + (8*(e.getY()/ss)); // Calculate cell index from mouse click
        if (start < 0 || start > 63) return; // Bounds check
        if (board.getCell(start).getPiece() == null) return;
        label = board.getCell(start).getPiece().getLabel();
        label.setLocation(e.getX() - ds, e.getY() - ds);
        layer.add(label, JLayeredPane.DRAG_LAYER);
               
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (label == null) return;
        label.setLocation(e.getX() - ds, e.getY() - ds);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (label == null) return;
        end = (e.getX()/ss) + (8*(e.getY()/ss));
        if (end >= 0 && end <= 63) {
	        move = new Move(board, start, end);
	        move.tryMove();
        }
        refreshBoard();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public Chessboard getBoard() {
		return board;
	}

	public void setBoard(Chessboard board) {
		this.board = board;
	}

}
    