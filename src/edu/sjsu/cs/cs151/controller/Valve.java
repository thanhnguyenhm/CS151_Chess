package edu.sjsu.cs.cs151.controller;
// import com.sun.xml.internal.ws.api.message.Message;

/** Interface that performs certain action in response to Message. 
 *  Each type of Message has corresponding Valve.
 *  See ValveResponse enum class.
 **/
public interface Valve {
	
	public ValveResponse execute(Message message);

}
