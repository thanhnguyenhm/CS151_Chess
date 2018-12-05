package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

public class MoveValve implements Valve {
	private Model model;
	private View view;
	
	public MoveValve(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	public ValveResponse execute(Message message) {
		if(message.getClass() != MoveMessage.class)
			return ValveResponse.MISS;
		int s = ((MoveMessage) message).getStart();
		int e = ((MoveMessage) message).getEnd();
		model.setMove(s, e);
		Boolean x = model.getMove().tryMove();
		if (x == true)
			view.viewMove(s, e);
		else
			view.dontMove(s, e);
		return ValveResponse.EXECUTED;
	}	
}
