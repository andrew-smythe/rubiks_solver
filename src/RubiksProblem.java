import java.util.ArrayList;
import java.util.Random;

public class RubiksProblem implements Problem {
	// Store the starting state
	RubiksState startState;
	
	// Initialize the problem by ccreating a default start state
	public RubiksProblem() {
		startState = new RubiksState(new RubiksCube(3));
	}
	
	// Constructor for the Problem -- setup the start state, and rotate it if random
	public State getStartState(String[] cube) {
		if (cube == null) {
			Random rand = new Random();
			for (int i = 0; i < 4; i++) {
				int randd = rand.nextInt((12-1) + 1) + 1;
				((RubiksCube)startState.getStateContents()).rotate(randd);			
			}			
		}
		else {
			startState = new RubiksState(new RubiksCube(cube));
		}
		return startState;
	}
	
	// Test if the current state is at the goal state
	public boolean goalTest(State s) {
		RubiksState goal = new RubiksState(new RubiksCube(3));
		if (goal.equals(s))
			return true;
		return false;
	}
	
	public int heuristicCost(State s) {
		// a semi-Manhattan-Distance heuristic based on edge colours
		RubiksState currentState = (RubiksState) s;
		RubiksCube cube = (RubiksCube) currentState.getStateContents();
		RubiksCube goal = new RubiksCube(cube.getWidth());
		
		int numWrong = 12;
		/*for (int i = 0; i < cube.getWidth()*cube.getWidth(); i++) {
			if (!cube.getWhiteFace().get(i).equals(goal.getWhiteFace().get(i))) {
				numWrong++;
			}
			if (!cube.getGreenFace().get(i).equals(goal.getGreenFace().get(i))) {
				numWrong++;
			}
			if (!cube.getYellowFace().get(i).equals(goal.getYellowFace().get(i))) {
				numWrong++;
			}
			if (!cube.getBlueFace().get(i).equals(goal.getBlueFace().get(i))) {
				numWrong++;
			}
			if (!cube.getRedFace().get(i).equals(goal.getRedFace().get(i))) {
				numWrong++;
			}
			if (!cube.getOrangeFace().get(i).equals(goal.getOrangeFace().get(i))) {
				numWrong++;
			}*/
		
		// Check each edge cube to see if it is correct -- ie. a Manhattan Distance-esque
		// calculation
		if (cube.getWhiteFace().get(1).equals("W") && cube.getRedFace().get(7).equals("R")) {
			numWrong--;
		}
		if (cube.getWhiteFace().get(4).equals("W") && cube.getBlueFace().get(5).equals("B")) {
			numWrong--;
		}
		if (cube.getWhiteFace().get(7).equals("W") && cube.getOrangeFace().get(1).equals("O")) {
			numWrong--;
		}
		if (cube.getWhiteFace().get(5).equals("W") && cube.getGreenFace().get(3).equals("G")) {
			numWrong--;
		}
		if (cube.getRedFace().get(1).equals("R") && cube.getYellowFace().get(1).equals("Y")) {
			numWrong--;
		}
		if (cube.getRedFace().get(3).equals("R") && cube.getBlueFace().get(1).equals("B")) {
			numWrong--;
		}
		if (cube.getRedFace().get(5).equals("W") && cube.getGreenFace().get(1).equals("R")) {
			numWrong--;
		}
		if (cube.getGreenFace().get(5).equals("G") && cube.getYellowFace().get(3).equals("R")) {
			numWrong--;
		}
		if (cube.getGreenFace().get(7).equals("G") && cube.getOrangeFace().get(5).equals("O")) {
			numWrong--;
		}
		if (cube.getOrangeFace().get(7).equals("O") && cube.getYellowFace().get(7).equals("Y")) {
			numWrong--;
		}
		if (cube.getOrangeFace().get(3).equals("O") && cube.getBlueFace().get(7).equals("B")) {
			numWrong--;
		}
		if (cube.getYellowFace().get(5).equals("Y") && cube.getBlueFace().get(3).equals("B")) {
			numWrong--;
		}
		
		return numWrong;
	}
	
	// simply return the heuristic cost of the first action
	public int pathCost(State s1, Action a, State s2) {
		return this.heuristicCost(s1);
	}
	
	public ArrayList<Pair<Action, State>> SuccessorFn(State s) {
		// Cast state parameter to an A* state
		RubiksState cubeState = (RubiksState) s;
		RubiksCube cube = (RubiksCube)cubeState.getStateContents();
		RubiksCube temp = new RubiksCube(cube);
			
		// total number of next states is 12 -- for 12 rotations
		int numStates = 12;
		ArrayList<Pair<Action, State>> successors = new ArrayList<Pair<Action, State>>();
		
		// perform every form of rotation on the state and add it to the list
		cube.rotate(1);
		RubiksState s1 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p1 = new Pair<Action, State>(new Action("Rotate right third of square up", 1), s1);
		cube.rotate(2);

		cube.rotate(2);
		RubiksState s2 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p2 = new Pair<Action, State>(new Action("Rotate right third of square down", 2), s2);
		cube.rotate(1);

		cube.rotate(3);
		RubiksState s3 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p3 = new Pair<Action, State>(new Action("Rotate top third of square left", 3), s3);
		cube.rotate(4);

		cube.rotate(4);
		RubiksState s4 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p4 = new Pair<Action, State>(new Action("Rotate top third of square right", 4), s4);
		cube.rotate(3);

		cube.rotate(5);
		RubiksState s5 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p5 = new Pair<Action, State>(new Action("Rotate left third of square up", 5), s5);
		cube.rotate(6);

		cube.rotate(6);
		RubiksState s6 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p6 = new Pair<Action, State>(new Action("Rotate left third of square down", 6), s6);
		cube.rotate(5);

		cube.rotate(7);
		RubiksState s7 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p7 = new Pair<Action, State>(new Action("Rotate bottom third of square left", 7), s7);
		cube.rotate(8);

		cube.rotate(8);
		RubiksState s8 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p8 = new Pair<Action, State>(new Action("Rotate bottom third of square right", 8), s8);
		cube.rotate(7);

		cube.rotate(9);
		RubiksState s9 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p9 = new Pair<Action, State>(new Action("Rotate white square to the right", 9), s9);
		cube.rotate(10);

		cube.rotate(10);
		RubiksState s10 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p10 = new Pair<Action, State>(new Action("Rotate white square to the left", 10), s10);
		cube.rotate(9);

		cube.rotate(11);
		RubiksState s11 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p11 = new Pair<Action, State>(new Action("Rotate yellow square to its left", 11), s11);
		cube.rotate(12);

		cube.rotate(12);
		RubiksState s12 = new RubiksState(new RubiksCube(cube));
		Pair<Action, State> p12 = new Pair<Action, State>(new Action("Rotate yellow square to its right", 12), s12);
		cube.rotate(11);
		
		// add each rotation to the successors
		successors.add(p1);
		successors.add(p2);
		successors.add(p3);
		successors.add(p4);
		successors.add(p5);
		successors.add(p6);
		successors.add(p7);
		successors.add(p8);
		successors.add(p9);
		successors.add(p10);
		successors.add(p11);
		successors.add(p12);
		
		return successors;
	}

}
