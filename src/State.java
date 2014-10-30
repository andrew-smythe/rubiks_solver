
/**
 * State Interface --
 * 		A basic interface for state -- will contain a specific object that describes the
 * 		state.
 * @author andrew
 *
 * @param <StateContents> The object for which the state will contain.
 */
public interface State<StateContents> {
	
	public StateContents getStateContents();
}
