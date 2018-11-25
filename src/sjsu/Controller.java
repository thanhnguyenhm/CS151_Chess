package sjsu;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import com.sun.xml.internal.ws.api.message.Message;

/**
 * The Controller class uses Model and View classes to control the state of
 * the game
 */
public class Controller {
	private BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
    //private GameInfo gameInfo;  //from lecture slides, IDK how to use this
    //private List<Valve> valves = new LinkedList<Valve>();
	
    /**
     * constructor
     * @param 
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

	public void mainLoop() {
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
}
