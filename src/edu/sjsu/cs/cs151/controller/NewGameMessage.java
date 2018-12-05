package edu.sjsu.cs.cs151.controller;

/**
* Represents new game event sent from View to Model.
*/	
public class NewGameMessage extends Message {
	private static final long serialVersionUID = 1L;
	public NewGameMessage() {
		// Do we need a real constructor to avoid this console message?
		// edu.sjsu.cs.cs151.controller.NewGameMessage@6440ea00
	}
	//test function, actually have Controller restart the Model and View instead
	//this just prints a string, to show Controller has received the message and executed the correct valve
	public void ps() {
		System.out.println("This is a new game message!");
	}
}
