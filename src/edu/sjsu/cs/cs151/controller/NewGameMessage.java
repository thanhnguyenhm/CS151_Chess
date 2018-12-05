package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.view.View;
import java.lang.reflect.*;

/**
* Represents a "new game" event sent from the View
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
