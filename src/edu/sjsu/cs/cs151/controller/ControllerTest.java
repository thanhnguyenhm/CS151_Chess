package edu.sjsu.cs.cs151.controller;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/**
 * A JUnit test to check whether valves are successfully added to List<Valve>
 */

public class ControllerTest {
	
    private List<Valve> valves = new LinkedList<Valve>();
	private static Model model;
	private static View view;
	
	@Test
	public void testController() {
    	valves.add(new NewGameValve());
    	valves.add(new MoveValve(model, view));
    	valves.add(new EndGameValve());
    	assertEquals(3, valves.size()); // Check that 3 valves are added to List<Valve>
	}
}
