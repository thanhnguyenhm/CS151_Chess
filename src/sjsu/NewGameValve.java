package sjsu;

/**
* Handles Valve response to new game Message received from View to Model.
*/	
public abstract class NewGameValve implements Valve {
	public ValveResponse execute(Message message)
	{
		if(message.getClass() != NewGameMessage.class)
		{
			return ValveResponse.MISS;
		}
		// TODO: actions in Model
		// TODO: actions in View
		return ValveResponse.EXECUTED;
	}

}