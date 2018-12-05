package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/** Interface that performs certain action in response to Message. 
 *  Each type of Message has corresponding Valve.
 *  See ValveResponse enum class.
 **/
public interface Valve {
	public ValveResponse execute(Message message);
}
