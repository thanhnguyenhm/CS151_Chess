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
    JLabel pieces;
    Dimension boardSize = new Dimension(600,600);
    int xAdjustment;
    int yAdjustment;

    // Constructor
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

        // add chess pieces to LayeredPane
        // Bishop by Demograph™ from the Noun Project
        JLabel piece = new JLabel(new ImageIcon("King.png"));
        JPanel panel = (JPanel)board.getComponent(0);
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
        pieces = null;
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        pieces = (JLabel) c;
        pieces.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        pieces.setSize(pieces.getWidth(), pieces.getHeight());
        layer.add(pieces, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(pieces == null) return;

        pieces.setVisible(false);
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( pieces );
        }
        else {
            Container parent = (Container)c;
            parent.add( pieces );
        }

        pieces.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (pieces == null) return;
        pieces.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
