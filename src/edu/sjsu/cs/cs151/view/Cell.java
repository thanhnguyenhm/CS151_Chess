package edu.sjsu.cs.cs151.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Cell class contains JPanels for the chess board grid and JLabels to represent pieces
 */
public class Cell {
    private JPanel panel;
	private JLabel label;
	
	/**
	 * Cell constructor
	 * @param color of the square
	 */
    public Cell(Color color) {
    	panel = new JPanel(new BorderLayout());
    	panel.setBackground(color);
    	label = null;
    }
    
	/**
	 * Get a panel
	 * @return panel
	 */
	public JPanel getPanel() {
		return panel;
	}
	
	/**
	 * Set a panel
	 * @param panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	/**
	 * Get a label
	 * @return label
	 */
	public JLabel getLabel() {
		return label;
	}
	
	/**
	 * Set a label (chess piece image)
	 * @param label image
	 */
	public void setLabel(JLabel label) {
		this.label = label;
		panel.removeAll();
		if (label != null)
			panel.add(label);
	}
}
