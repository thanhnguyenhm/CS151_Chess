package edu.sjsu.cs.cs151.controller;

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
