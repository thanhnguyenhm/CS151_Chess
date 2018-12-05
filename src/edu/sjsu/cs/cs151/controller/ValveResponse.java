package edu.sjsu.cs.cs151.controller;

public enum ValveResponse {
	MISS, // Valve cannot process Message 
	EXECUTED, // Valve processed Message
	FINISH // User quit game, or a player has lost
};
