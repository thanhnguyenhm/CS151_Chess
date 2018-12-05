package edu.sjsu.cs.cs151.controller;

public class MoveMessage extends Message {
	private static final long serialVersionUID = 1L;
	private int start, end;
	
	public MoveMessage(int s, int e) {
		start = s;
		end = e;		
	}
	
	//test function, actually have Model tryMove() instead, and update View afterward if successful
	//this prints the start and end info from View, to show Controller has received the message and executed the correct valve
	//TODO - instantiate Move and have Model, View handle it
	public void ps() {
		System.out.println(start);
		System.out.println(end);
	}
}
