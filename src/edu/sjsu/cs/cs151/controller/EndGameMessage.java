package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.view.View;
import java.lang.reflect.*;

/**
* Represents an "end game" event sent from the View when the user presses "Quit" 
* or there is a checkmate
*/	

public class EndGameMessage extends Message {
	private static final long serialVersionUID = 1L;
	
	public EndGameMessage() {	
	View view = Controller.getView();
    Method m;
	try {
		m = View.class.getDeclaredMethod("endGame"); 
        m.setAccessible(true); // Use reflection to access private method
        m.invoke(view); // Close the program
        
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}	

}
