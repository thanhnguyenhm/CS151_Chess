package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.view.View;
import java.lang.reflect.*;

/**
* Represents new game event sent from View to Model.
*/	
public class NewGameMessage extends Message {
	private static final long serialVersionUID = 1L;

	public NewGameMessage() {

		View view = Controller.getView();
        Method m;
		try {
			m = View.class.getDeclaredMethod("resetBoard"); 
	        m.setAccessible(true); // Use reflection to access private resetBoard method
	        m.invoke(view); // Reset board in the View
	        System.out.println("Updating View from Controller");
	        
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
	//test function, actually have Controller restart the Model and View instead
	//this just prints a string, to show Controller has received the message and executed the correct valve
	public void ps() {	
		System.out.println("This is a new game message!");
	}
}
