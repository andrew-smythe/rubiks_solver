
public class RubiksState<RubiksCube> implements State<RubiksCube> {
	
	// Hold the state information
	private RubiksCube cubeState;
	
	// Create a state with a cube
	public RubiksState(RubiksCube c) {
		cubeState = c;
	}
	
	// return the cube state
	public RubiksCube getStateContents() {
		return cubeState;
	}
	
	@Override
	public boolean equals(Object o) {
		// two rubik's cube states are equal if the cube contents are equal.
		RubiksState rstate = (RubiksState) o;
		if (this.getStateContents().equals(rstate.getStateContents())) {
			return true;
		}
		return false;
	}
}
