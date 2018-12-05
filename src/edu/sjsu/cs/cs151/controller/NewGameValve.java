package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to new game Message received from View
*/	
public class NewGameValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != NewGameMessage.class) {
			return ValveResponse.MISS;
		}
		return ValveResponse.EXECUTED;
	}
}