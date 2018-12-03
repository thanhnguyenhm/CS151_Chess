package edu.sjsu.cs.cs151.controller;

public enum ValveResponse {
	MISS, // Valve cannot process Message 
	EXECUTED, // Valve processed message
	FINISH // Game was closed
};
