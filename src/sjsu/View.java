package sjsu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * View class is a GUI that shows events and collects data from user
 */
public class View extends JFrame implements MouseListener, MouseMotionListener {
    JLayeredPane layer;
    JPanel board;
    JPanel panel;
    JLabel piece;
    Dimension boardSize = new Dimension(600,600);
    int xAdjustment; // Change name to dx?
    int yAdjustment; // Change name to dy?

    // View constructor
    View() {
        // add components to LayeredPane object
        layer = new JLayeredPane();
        getContentPane().add(layer);
        layer.setPreferredSize(boardSize);
        layer.addMouseListener(this);
        layer.addMouseMotionListener(this);

        // add chess board to LayeredPane
        board = new JPanel();
        layer.add(board, JLayeredPane.DEFAULT_LAYER);
        board.setLayout(new GridLayout(8, 8));
        board.setPreferredSize(boardSize);
        board.setBounds(0,0,boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel cell = new JPanel( new BorderLayout() );
            board.add(cell);
            if ((i / 8) % 2 == 0) {
                if (i % 2 == 0) cell.setBackground(Color.WHITE);
                else cell.setBackground(Color.LIGHT_GRAY);
            } else {
                if (i % 2 == 0) cell.setBackground(Color.LIGHT_GRAY);
                else cell.setBackground(Color.WHITE);
            }
        }

        // Initialize placement of chess piece on board
        
        // Black pawns
        for (int i = 8; i < 16; i++)
        {
            piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-pawn.png")));
            panel = (JPanel)board.getComponent(i);
            panel.add(piece);    
        }
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png")));
        panel = (JPanel)board.getComponent(0);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-knight.png")));
        panel = (JPanel)board.getComponent(1);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-knight.png")));
        panel = (JPanel)board.getComponent(6);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-bishop.png")));
        panel = (JPanel)board.getComponent(2);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-bishop.png")));
        panel = (JPanel)board.getComponent(5);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-queen.png")));
        panel = (JPanel)board.getComponent(3);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-king.png")));
        panel = (JPanel)board.getComponent(4);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png")));
        panel = (JPanel)board.getComponent(7);
        panel.add(piece);
            
        // White pawns
        for (int i = 48; i < 56; i++)
        {
            piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-pawn.png")));
            panel = (JPanel)board.getComponent(i);
            panel.add(piece);        
        }
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png")));
        panel = (JPanel)board.getComponent(56);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-knight.png")));
        panel = (JPanel)board.getComponent(57);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-knight.png")));
        panel = (JPanel)board.getComponent(62);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-bishop.png")));
        panel = (JPanel)board.getComponent(58);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-bishop.png")));
        panel = (JPanel)board.getComponent(61);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-queen.png")));
        panel = (JPanel)board.getComponent(59);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-king.png")));
        panel = (JPanel)board.getComponent(60);
        panel.add(piece);
        
        piece = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png")));
        panel = (JPanel)board.getComponent(63);
        panel.add(piece);              
        

        // Setup frame
        JFrame frame = new JFrame();
        frame.add(layer);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * update status of a chess board
     */
    void refreshBoard() {

    }

    /**
     * reset everything to the initial state
     */
    void resetBoard() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        piece = null;
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        piece = (JLabel) c;
        piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        piece.setSize(piece.getWidth(), piece.getHeight());
        layer.add(piece, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(piece == null) return;

        piece.setVisible(false);
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( piece );
        }
        else {
            Container parent = (Container)c;
            parent.add( piece );
        }

        piece.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (piece == null) return;
        piece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}