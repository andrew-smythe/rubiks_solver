import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * AStarFringe -- Implements Fringe interface for A* Pathfinding. Utilizes a Priority Queue of tree
 * nodes.
 * @author andrew
 *
 */

public class AStarFringe implements Fringe {
	
	// Inner workings of the A* Fringe -- a priority queue based on path cost
	private PriorityQueue<Node> fringeQueue;
	
	@SuppressWarnings("unchecked")
	
	// Constructor method -- creates the priority queue, and specifies its comparator
	public AStarFringe() {
		// Initialize queue, comparator based on path cost of nodes
		fringeQueue = new PriorityQueue<Node>(10, new Comparator() {
			public int compare(Object o1, Object o2) {
				// Cast objects to nodes for comparison
				Node n1 = (Node) o1;
				Node n2 = (Node) o2;
				
				// Return 0 for equal nodes
				if (n1.equals(n2)) {
					return 0;
				}
				else {
					// Determine which node has a greater path cost
					if (n1.getCost() < n2.getCost()) {
						return -1;
					}
					else {
						return 1;
					}
				}	
			}
		});
	}
	
	// Returns the first node in the fringe -- ie. the node with the lowest path cost
	public Node getFirstNode() {
		return (fringeQueue.poll());
	}
	
	// Checks if the fringe is empty
	public boolean isEmpty() {
		if (fringeQueue.size() == 0)
			return true;
		return false;
	}
	
	// Inserts a node into the fringe
	public void insert(Node n) {
		fringeQueue.offer(n);
	}
	
	// Inserts several nodes into the fringe -- must be in an ArrayList
	public void insertAll(ArrayList<Node> n) {
		for (int i = 0; i < n.size(); i++) {
			this.insert(n.get(i));
		}
	}
}
