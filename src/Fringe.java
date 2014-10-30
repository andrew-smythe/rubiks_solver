import java.util.ArrayList;

/**
 * 
 * Fringe Interface --
 * 		Basic template for a Fringe interface -- specifies basic functions required
 * 		to make a problem-specific fringe
 * @author andrew
 * 
 *
 */
public interface Fringe {
	
	// insert a single node into the fringe
	public void insert(Node n);
	
	// insert several nodes into the fringe
	public void insertAll(ArrayList<Node> n);
	
	// check if the fringe is empty
	public boolean isEmpty();
	
	// get the first node from the fringe
	public Node getFirstNode();
}
