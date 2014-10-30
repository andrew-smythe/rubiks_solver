
/**
 * 
 *	Pair Class --
 *		Used to store two objects as an ordered pair. In particular, used for Action/State
 *		pairs, as well as next states/path costs.
 *
 * @author andrew
 *
 *
 * @param <L>	Left ordered pair element
 * @param <R>	Right ordered pair element
 */
public class Pair<L, R> {
	private L left;
	private R right;
	
	public Pair(L l, R r) {
		this.left = l;
		this.right = r;
	}
	
	public L getL() {
		return left;
	}
	
	public R getR() {
		return right;
	}
	
	public void setL(L l) {
		left = l;
	}
	
	public void setR(R r) {
		right = r;
	}
}
