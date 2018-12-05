package edu.sjsu.cs.cs151.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;


/**
 * A chess board with 32 black and 32 white cells
 */
public class ViewBoard {
	private JPanel panel;
	private Cell[] cell;
	
	public ViewBoard(Dimension boardSize) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		panel.setPreferredSize(boardSize);
		panel.setBounds(0, 0, boardSize.width, boardSize.height);
		cell = new Cell[64];
		for (int i = 0; i < 64; i++) {
			if ((i / 8) % 2 == 0) {
				 if (i % 2 == 0) {
				 	cell[i] = new Cell(Color.WHITE);
				 	panel.add(cell[i].getPanel());
				 } else {
				 	cell[i] = new Cell(Color.LIGHT_GRAY);
				 	panel.add(cell[i].getPanel());
				 }
			} else {
				 if (i % 2 == 0) {
				  	cell[i] = new Cell(Color.LIGHT_GRAY);
				  	panel.add(cell[i].getPanel());
				  } else {
				  	cell[i] = new Cell(Color.WHITE);
				  	panel.add(cell[i].getPanel());
				  }
			}
		}
		for (int i = 0; i < 64; i++) {
			switch(i) {
			case 0:
			case 7:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-rook.png"))));
				break;        		
			case 1:
			case 6:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-knight.png"))));
				break;
			case 2:
			case 5:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-bishop.png"))));
				break;
			case 3:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-queen.png"))));
				break;
			case 4:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-king.png"))));
				break;
			case 8:
				for (int j = 0; j < 8; j++)
					cell[j + i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("black-pawn.png"))));
				break;
			case 56:
			case 63:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-rook.png"))));
				break;        		
			case 57:
			case 62:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-knight.png"))));
				break;
			case 58:
			case 61:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-bishop.png"))));
				break;
			case 59:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-queen.png"))));
				break;
			case 60:
				cell[i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-king.png"))));
				break;
			case 48:
				for (int j = 0; j < 8; j++)
					cell[j + i].setLabel(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("white-pawn.png"))));
				break;
			}
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public Cell getCell(int i) {
		return cell[i];
	}
	
	public Cell getCell(int x, int y) {
		int i = 8 * y + x;
		return cell[i];
	}
}
