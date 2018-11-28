package sjsu;

public abstract class MoveValve implements Valve {
	public ValveResponse execute(Message message)
	{
		if(message.getClass() != MoveMessage.class)
		{
			return ValveResponse.MISS;
		}
		// TODO: actions in Model
		// TODO: actions in View
		return ValveResponse.EXECUTED;
	}	
}
