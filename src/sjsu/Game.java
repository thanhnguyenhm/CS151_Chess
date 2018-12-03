package sjsu;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// import com.sun.xml.internal.ws.api.message.Message; //is this the right one?

/**
 * This program is to create a 2-player Chess game
 * Team project for SJSU CS151
 */
public class Game {
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	
    public static void main(String[] args) throws Exception {
        view = new View(); // view = View.init(queue);
        model = new Model();
        Controller game = new Controller(view, model, queue);
        game.mainLoop();
        view.dispose();
        view.dispose();
        queue.clear();
    }
}


