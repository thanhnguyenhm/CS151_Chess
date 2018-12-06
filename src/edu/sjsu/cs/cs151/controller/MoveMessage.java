package edu.sjsu.cs.cs151.controller;

/**
* Represents an attempted move event sent from the View when the user drags a chess piece
*/

public class MoveMessage extends Message {
	private static final long serialVersionUID = 1L;
	private int start, end;
	
	/**
	* Message for an attempted move
	* @param s start position
	* @param e end position
	*/
	public MoveMessage(int s, int e) {
		start = s;
		end = e;		
	}

	/**
	* Start position getter method
	* @return start position
	*/
	public int getStart() {
		return start;
	}
	
	/**
	* End position getter method
	* @return end position
	*/
	public int getEnd() {
		return end;
	}	
}
