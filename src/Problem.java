import java.util.ArrayList;

/**
 * Problem Interface --
 * 		Basic template for a Problem interface -- specifies the required functions
 * 		to create a specific AI Search problem.
 * @author andrew
 *
 */

public interface Problem {
	
	// Tests if the goal state has been reached.
	public boolean goalTest(State s);
	
	// Returns a list of action/state pairs based on the current state
	public ArrayList<Pair<Action, State>> SuccessorFn(State s);
	
	// Determines the path cost between two states (if they are attached)
	public int pathCost(State s1, Action a, State s2);
	
	// Returns the heuristic cost of the current state
	public int heuristicCost(State s);
	
	// Returns the starting state of the problem
	public State getStartState(String[] s);
}
