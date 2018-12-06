package edu.sjsu.cs.cs151.controller;

/**
* Represents an attempted move event sent from the View when the user drags a chess piece
*/

public class MoveMessage extends Message {
	private static final long serialVersionUID = 1L;
	private int start, end;
	
	public MoveMessage(int s, int e) {
		start = s;
		end = e;		
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}	
}
