package edu.sjsu.cs.cs151.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

public class Cell {
    private JPanel panel;
	private JLabel label;
	
    public Cell(Color color) {
    	panel = new JPanel(new BorderLayout());
    	panel.setBackground(color);
    	label = null;
    }
    
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
		panel.removeAll();
		if (label != null)
			panel.add(label);
	}
}
