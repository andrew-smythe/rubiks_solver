
/*
 * Action Class --
 * 		Holds information that might be important for describing an action taken
 * 		by the AI Agent (contains an integer action code and a description in string
 * 		form.)
 */
public class Action {
	String actionDescription;
	int actionCode;
	
	public Action(String ad, int ac) {
		actionDescription = ad;
		actionCode = ac;
	}
	
	// returns the description
	public String getDescription() {
		return actionDescription;
	}
	
	// returns integer action code
	public int getCode() {
		return actionCode;
	}
}
