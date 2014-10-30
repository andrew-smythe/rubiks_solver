
/**
 * 
 * Node Class --
 * 		Nodes for use in the Tree Search. Nodes contain a state, parent node, action type
 * 		and a depth/path cost.
 * @author andrew
 *
 */

public class Node {
	
	// Member variables
	private State state;
	private Node parent;
	private int depth;
	private int pathCost;
	private Action action;
	
	// Constructor used for creating initial node (parent of tree)
	public Node(State s) {
		state = s;
		parent = null;
		depth = 0;
		pathCost = 0;
		action = null;
	}
	
	// Constructor for most cases -- creating a node based on a given action/state
	// pair, with path costs and tree depth
	public Node(Node p, Action a, State s, int d, int pc) {
		state = s;
		parent = p;
		depth = d;
		pathCost = pc;
		action = a;
	}
	
	// Returns the node's inner state
	public State getState() {
		return state;
	}
	
	// Returns the parent node
	public Node getParent() {
		return parent;
	}
	
	// Returns the node's path cost
	public int getCost() {
		return pathCost;
	}
	
	// Returns the node's depth
	public int getDepth() {
		return depth;
	}
	
	// set the node's depth
	public void setDepth(int d) {
		depth = d;
	}
	
	// set the node's path cost
	public void setCost(int c) {
		pathCost = c;
	}
	
	public Action getAction() {
		return action;
	}
}
