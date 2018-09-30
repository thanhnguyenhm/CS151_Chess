package sjsu;

/**
 * The Controller class uses Model and View classes to control the state of
 * the game
 */
public class Controller {
    Model model;
    View view;

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
}
