package edu.sjsu.cs.cs151.controller;

public class MoveValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != MoveMessage.class)
			return ValveResponse.MISS;
		message.ps();
		return ValveResponse.EXECUTED;
	}	
}
