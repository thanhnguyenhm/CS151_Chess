package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.view.View;
import java.lang.reflect.*;


public class EndGameMessage extends Message {
	private static final long serialVersionUID = 1L;
	
	public EndGameMessage() {	
	View view = Controller.getView();
    Method m;
	try {
		m = View.class.getDeclaredMethod("resetBoard"); //TODO Method for ending game
        m.setAccessible(true); // Use reflection to access private method
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

	@Override
	protected void ps() {
		// TODO Auto-generated method stub
		
	}

}
