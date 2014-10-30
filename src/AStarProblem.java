import java.util.ArrayList;

/**
 * AStarProblem -- Implements the Problem interface for A* pathfinding. Successor function
 * is based on a connected graph of states with weighted edge costs, and a heuristic cost that
 * guesses the distance between a given state and the goal state.
 * @author andrew
 *
 */

public class AStarProblem implements Problem {
	
	AStarState startState;
	
	public AStarProblem() {
		// Construct the states for the problem graph
		AStarState a = new AStarState("A");
		AStarState b = new AStarState("B");
		AStarState c = new AStarState("C");
		AStarState d = new AStarState("D");
		AStarState e = new AStarState("E");
		AStarState f = new AStarState("F");
		AStarState g = new AStarState("G");
		AStarState h = new AStarState("H");
		AStarState i = new AStarState("I");
		AStarState j = new AStarState("J");
		AStarState k = new AStarState("K");
		AStarState l = new AStarState("L");
		AStarState m = new AStarState("M");
		
		// Sets the start state of the problem
		startState = a;
		
		// Create a list of State and edge costs
		ArrayList<Pair<AStarState, Integer>> nextStates = new ArrayList<Pair<AStarState, Integer>>();
		
		/*
		 * For each state, set what states are adjacent, and give their path costs.
		 */
		
		nextStates.add(new Pair<AStarState, Integer>(m, 75));
		nextStates.add(new Pair<AStarState, Integer>(l, 118));
		a.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(g, 90));
		nextStates.add(new Pair<AStarState, Integer>(e, 211));
		b.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(j, 146));
		nextStates.add(new Pair<AStarState, Integer>(i, 138));
		nextStates.add(new Pair<AStarState, Integer>(d, 120));
		c.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(c, 120));
		nextStates.add(new Pair<AStarState, Integer>(g, 75));
		d.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(k, 99));
		nextStates.add(new Pair<AStarState, Integer>(b, 211));
		e.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(g, 70));
		nextStates.add(new Pair<AStarState, Integer>(l, 111));
		f.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(f, 70));
		nextStates.add(new Pair<AStarState, Integer>(d, 75));
		g.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(m, 71));
		nextStates.add(new Pair<AStarState, Integer>(k, 151));
		h.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(b, 10));
		nextStates.add(new Pair<AStarState, Integer>(c, 128));
		nextStates.add(new Pair<AStarState, Integer>(j, 97));
		i.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(k, 80));
		nextStates.add(new Pair<AStarState, Integer>(i, 97));
		nextStates.add(new Pair<AStarState, Integer>(c, 146));
		j.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(h, 151));
		nextStates.add(new Pair<AStarState, Integer>(e, 99));
		nextStates.add(new Pair<AStarState, Integer>(j, 80));
		k.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(a, 118));
		nextStates.add(new Pair<AStarState, Integer>(f, 111));
		l.setNextStates(nextStates);
		nextStates.clear();
		
		nextStates.add(new Pair<AStarState, Integer>(a, 75));
		nextStates.add(new Pair<AStarState, Integer>(h, 71));
		m.setNextStates(nextStates);
		nextStates.clear();
	}
	
	// Tests a state to see if it is the goal state
	public boolean goalTest(State s) {
		// Cast state to an A* state (which it will be in our problem)
		AStarState as = (AStarState)s;
		if (as.getStateContents().equals("B")) {
			return true;
		}
		return false;
	}
	
	// Returns a list of Action/State pairs -- each state adjacent to the given state
	public ArrayList<Pair<Action, State>> SuccessorFn(State s) {
		// Cast state parameter to an A* state
		AStarState as = (AStarState) s;
		
		// get the total number of adjacent states, and initialize a list for them
		int numStates = as.totalNextStates();
		ArrayList<Pair<Action, State>> successors = new ArrayList<Pair<Action, State>>();
		
		// add next states to the list
		for (int i = 0; i < numStates; i++) {
			Pair<Action, State> p = new Pair(new Action("Move", 1), as.getNext(i).getL());
			successors.add(p);
		}
		// Return action/state pairs
		return successors;
	}
	
	// Calculates the path cost between two given adjacent states.
	// Returns -1 if states are not adjacent.
	public int pathCost(State s1, Action a, State s2) {
		AStarState as1 = (AStarState)s1;
		AStarState as2 = (AStarState)s2;
		
		// Find the index of the state in the next state array
		int nextState = as1.hasNext(as2);
		
		// If the states are adjacent, return their path cost
		if (nextState > -1) {
			return (((Integer)as1.getNext(nextState).getR()).intValue());
		}
		return -1;
	}
	
	// A list of heuristic costs (estimate distances from the goal state)
	// Simply a lookup table for each state
	public int heuristicCost(State s) {
		AStarState as = (AStarState) s;
		
		if (as.getStateContents().equals("A")) {
			return 366;
		}
		else if (as.getStateContents().equals("B")) {
			return 0;
		}
		else if (as.getStateContents().equals("C")) {
			return 160;
		}
		else if (as.getStateContents().equals("D")) {
			return 242;
		}
		else if (as.getStateContents().equals("E")) {
			return 176;
		}
		else if (as.getStateContents().equals("F")) {
			return 244;
		}
		else if (as.getStateContents().equals("G")) {
			return 241;
		}
		else if (as.getStateContents().equals("H")) {
			return 380;
		}
		else if (as.getStateContents().equals("I")) {
			return 10;
		}
		else if (as.getStateContents().equals("J")) {
			return 193;
		}
		else if (as.getStateContents().equals("K")) {
			return 253;
		}
		else if (as.getStateContents().equals("L")) {
			return 329;
		}
		else if (as.getStateContents().equals("M")) {
			return 374;
		}
		return -1;
	}
	
	// Returns the start state
	public State getStartState(String[] s) {
		return startState;
	}
}