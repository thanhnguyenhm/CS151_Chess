package edu.sjsu.cs.cs151.controller;

/** Interface that performs certain action in response to Message. 
 *  Each type of Message has corresponding Valve.
 *  See ValveResponse enum class.
 **/
public interface Valve {
	public ValveResponse execute(Message message);
}
