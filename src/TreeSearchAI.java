import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class TreeSearchAI {
	
	// For text-input only
	private String[] cube;
	
	// For text-input only
	public TreeSearchAI(String[] c) {
		cube = c;
	}
	
	// Expands states into successor nodes, using the problem's successor function
	private ArrayList<Node> expand(Node n, Problem p) {
		
		// start with an empty list of successors
		ArrayList<Node> successors = new ArrayList<Node>();
		
		// Execute the successor function to populate the list
		for (Pair<Action, State> pair : p.SuccessorFn(n.getState())) {
			int pathCost = n.getDepth()+1 + p.heuristicCost(n.getState());
			Node s = new Node(n, pair.getL(), pair.getR(), n.getDepth()+1, pathCost);
			successors.add(s);			
		}
		// return all next states
		return successors;
	}
	
	public Node TreeSearch(Problem problem, Fringe fringe) {
		// Create a node from the start state
		Node startState;
		if (cube != null) {
			startState = new Node(problem.getStartState(cube));
		}
		else {
			startState = new Node(problem.getStartState(null));
		}
		startState.setDepth(0);
		startState.setCost(startState.getDepth()+problem.heuristicCost(startState.getState()));
		fringe.insert(startState);
		
		// Continue searching while the fringe is empty
		while (!fringe.isEmpty()) {
			Node n = fringe.getFirstNode();
			if (problem.goalTest(n.getState()))
				return n;
			else
				fringe.insertAll(expand(n, problem));
		}
		return null;
	}
	
	public static void main(String[] argv) {
		// Setup our problem space and A* Fringe
		RubiksProblem problem = new RubiksProblem();
		AStarFringe fringe = new AStarFringe();

		// Start the search
		TreeSearchAI search = new TreeSearchAI(null);
		System.out.println(argv[0]);
		
		// Give a welcome message, and scan the file if necessary
		if (argv[0].equals("text")) {
			try {
				String cube = new Scanner(new File("rubik.txt")).useDelimiter("\\A").next();
				String[] cubeParts = cube.split(",");
				search = new TreeSearchAI(cubeParts);
			}
			catch (FileNotFoundException f) {
				System.out.println("Could not find file -- reverting to random.");
			}
		}
		
		// Execute the search
		Node finalNode = search.TreeSearch(problem, fringe);
		Node n = finalNode;
		
		// reverse the nodes
		Stack<Node> s = new Stack<Node>();
		while (n != null) {
			s.push(n);
			n = n.getParent();
		}
		
		// Print out steps for solving the cube
		System.out.println("Steps for Solving the Cube (Looking at the white face, with the red face on top0:");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("\n");
		while (!s.empty()) {
			n = s.pop();
			if (n.getAction() != null)
				System.out.println(n.getAction().getDescription());
			System.out.println(n.getState().getStateContents());
			System.out.println("\n");
		}
		/*
		RubiksCube r = new RubiksCube(3);
		RubiksState s = new RubiksState(r);
		RubiksProblem rp = new RubiksProblem();
		r.rotate(1);
		r.rotate(3);
		r.rotate(6);
		System.out.println(r);*/
	}
}
