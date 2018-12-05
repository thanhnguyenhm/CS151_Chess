package edu.sjsu.cs.cs151.view;

import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.controller.Message;
import edu.sjsu.cs.cs151.controller.NewGameMessage;
import edu.sjsu.cs.cs151.controller.MoveMessage;
import edu.sjsu.cs.cs151.controller.EndGameMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

/**
 * View class is a GUI that receives input from users and forwards events to the Controller
 */
public class View extends JFrame implements MouseListener, MouseMotionListener {
	private static BlockingQueue<Message> queue;
	private JFrame frame;
	private JLayeredPane layer;
	private ViewBoard board;
	private JLabel label; // Temporary image for piece movement
    private JPanel topPanel;
    private JButton reset;
    private JButton quit;
	private static final int SQUARE_SIZE = 75; // Square size
	private static final int CURSOR_OFFSET = SQUARE_SIZE/2; // Cursor offset is half a cell square
	private Dimension boardSize = new Dimension(8 * SQUARE_SIZE, 8 * SQUARE_SIZE); // Board is 8x8 squares
	private int start, end;
	
    // View constructor
    public View(BlockingQueue<Message> queue) {
    	View.queue = queue;
    	startGame();

        // Add action listener to reset button
        reset.addActionListener(e -> {
        	try {
				queue.put(new NewGameMessage()); // Add to queue
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        });

        // Add action listener to quit button
        quit.addActionListener(e -> {
        	try {
				queue.put(new EndGameMessage()); // Add to queue
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}     
        });

        // Setup frame
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
     * Start Game: render buttons, add chess board to LayeredPane
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
        board = new ViewBoard(boardSize);
        layer.add(board.getPanel(), JLayeredPane.DEFAULT_LAYER);
    }
    /*
     * Draws the piece in new position
     */    
    public void viewMove(int start, int end) {
    	board.getCell(end).setLabel(label);
    	board.getCell(start).setLabel(null);
    	refreshBoard();
    }
    /*
     * Redraws the original pieces
     */
    public void dontMove(int start, int end) {
    	board.getCell(start).setLabel(label);
    	refreshBoard();
    }

    /**
     * Reset View to the initial state
     */
    public void resetBoard() {
        frame.remove(layer);
        startGame();
        frame.add(layer);
        frame.setVisible(true);
    }
    
    /**
     * End the game: exit the program
     */    
    void endGame() {
    	System.exit(0);	
    }

    /**
     * Update status of a chess board
     */
    public void refreshBoard() {
    	layer.removeAll(); //
        layer.add(board.getPanel(), JLayeredPane.DEFAULT_LAYER); // Updating the board
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label = null;
        start = (e.getX()/SQUARE_SIZE) + (8*(e.getY()/SQUARE_SIZE)); // Calculate cell index from mouse click
        if (start < 0 || start > 63) return; // Bounds check
        label = board.getCell(start).getLabel();
        if (label == null) return;
        label.setLocation(e.getX() - CURSOR_OFFSET, e.getY() - CURSOR_OFFSET);
        layer.add(label, JLayeredPane.DRAG_LAYER);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (label == null) return;
        label.setLocation(e.getX() - CURSOR_OFFSET, e.getY() - CURSOR_OFFSET);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (label == null) return;
        end = (e.getX()/SQUARE_SIZE) + (8*(e.getY()/SQUARE_SIZE));
        if (end >= 0 && end <= 63) {
        	try {
				queue.put(new MoveMessage(start, end));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}  
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
}