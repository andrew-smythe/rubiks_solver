import java.util.ArrayList; 

/**
 * AStarState -- Implements the State interface for A* Pathfinding. A* states are graph nodes that
 * contain which states it is adjacent to, and the cost to get to that state.
 * @author andrew
 *
 * @param <String> State contents are of String type
 */

public class AStarState<String> implements State<String> {
	
	// Member variables
	private String stateName;
	private ArrayList<Pair<AStarState, Integer>> nextStates;
	private int totalNext;
	
	// Create the state, given a name
	public AStarState(String sn) {
		stateName = sn;
	}
	
	// Takes in a list of states, and sets those to the list of adjacent states
	public void setNextStates(ArrayList<Pair<AStarState, Integer>> ns) {
		nextStates = (ArrayList<Pair<AStarState, Integer>>)ns.clone();
		totalNext = nextStates.size();		
	}
	
	// Returns the name of the state
	public String getStateContents() {
		return stateName;
	}
	
	// Returns the total number of adjacent states
	public int totalNextStates() {
		return totalNext;
	}
	
	// Returns the state and cost of a specific adjacent state
	public Pair<AStarState, Integer> getNext(int nextState) {
		return this.nextStates.get(nextState);
	}
	
	// Returns the index of a given adjacent state if it exists, -1 otherwise.
	public int hasNext(AStarState as) {
		for (int i = 0; i < totalNext; i++) {
			if (as.equals(nextStates.get(i).getL())) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	// Override equals(Object o) to compare names of states to prove equivalency
	public boolean equals(Object o) {
		if (this.getStateContents().equals(((AStarState)o).getStateContents())) {
			return true;
		}
		return false;
	}
	
}
