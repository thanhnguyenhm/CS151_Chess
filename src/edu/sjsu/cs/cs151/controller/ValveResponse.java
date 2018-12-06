package edu.sjsu.cs.cs151.controller;
/** Interface for tagging whether messages have been processed yet or not. 
 * Checked in Controller mainLoop
 **/
public enum ValveResponse {
	MISS, // Valve cannot process Message 
	EXECUTED, // Valve processed Message
	FINISH // User quit game, or a player has lost
};
