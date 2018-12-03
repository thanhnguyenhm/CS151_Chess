package edu.sjsu.cs.cs151.controller;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

// import com.sun.xml.internal.ws.api.message.Message;

/**
 * The Controller class synchronizes information between the Model and View classes
 * to control the state of the game. Receives Messages from View, then updates Model
 */
public class Controller {
	private BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
    private List<Valve> valves = new LinkedList<Valve>();
    //private GameInfo gameInfo;  //from lecture slides, IDK how to use this
	
    /**
     * constructor
     * @param View, Model, and BlockingQueue 
     */
    public Controller(View v, Model m, BlockingQueue<Message> q)
    {
    	this.messageQueue = q;
    	this.view = v;
    	this.model = m;    	
    }

    /**
     * getter for model
     * @return model
     */
    public Model getModel() {
        return model;
    }

    /**
     * getter for view
     * @return view
     */
    public View getView() {
        return view;
    }
    
     /**
     * Takes Messages from queue and processes them in FIFO order
     */
	public void mainLoop() throws Exception {
		
		ValveResponse response = ValveResponse.EXECUTED;
		Message message= null;
		while(response != ValveResponse.FINISH){
			try{
				message = (Message)messageQueue.take(); // Takes next Message from queue
			}
			catch(InterruptedException e){
				e.printStackTrace();
				}		
		
		for(Valve valve: valves)
		{
			response = valve.execute(message); // TODO make execute methods for each Message
			if(response != ValveResponse.MISS) // If response processed or game is over, leave mainLoop
				break;
			}
		}
		}

	     /**
	     * Nhien's work in progress below, already was commented out
	     */		
		//Scanner s = new Scanner(System.in);
		//while(true) {			
			//System.out.println("Select a piece to move (0-63): ");
			//int ii = s.nextInt();
			//view.getBoard().getCell(ii).setPiece(new Pawn(PlayerSide.WHITE));
			//System.out.println();
			
			//System.out.println("Select a destination of piece (0-63): ");
			//int iii = s.nextInt();
			//view.getBoard().getCell(iii).setPiece(view.getBoard().getCell(ii).getPiece());	
		//}	
}
