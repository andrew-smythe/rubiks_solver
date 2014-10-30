import java.util.ArrayList;

public class RubiksCube {
	
	// Defines size of cube -- default will be 3.
	private int faceWidth;
	
	private ArrayList<String> whiteFace;
	private ArrayList<String> greenFace;
	private ArrayList<String> yellowFace;
	private ArrayList<String> blueFace;
	private ArrayList<String> redFace;
	private ArrayList<String> orangeFace;
	
	public RubiksCube() {
		this(3);
	}
	
	public RubiksCube(String[] cube) {
		// set size of cube
		int width = 3;
		faceWidth = width;
		int j = 0;
				
		// Initialize white face
		whiteFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			whiteFace.add(cube[i+(j*9)]);
		}
		j++;
		
		// Initialize green face
		greenFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			greenFace.add(cube[i+(j*9)]);
		}
		j++;
		
		// Initialize yellow face
		yellowFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			yellowFace.add(cube[i+(j*9)]);
		}
		j++;
		
		// Initialize blue face
		blueFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			blueFace.add(cube[i+(j*9)]);
		}
		j++;
		
		// Initialize red face
		redFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			redFace.add(cube[i+(j*9)]);
		}
		j++;
		
		// Initialize orange face
		orangeFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			orangeFace.add(cube[i+(j*9)]);
		}
		j++;
	}	
	public RubiksCube(int width) {
		
		// set size of cube
		faceWidth = width;
		
		// Initialize white face
		whiteFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			whiteFace.add("W"/*+i*/);
		}
		
		// Initialize green face
		greenFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			greenFace.add("G"/*+i*/);
		}
		
		// Initialize yellow face
		yellowFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			yellowFace.add("Y"/*+i*/);
		}
		
		// Initialize blue face
		blueFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			blueFace.add("B"/*+i*/);
		}
		
		// Initialize red face
		redFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			redFace.add("R"/*+i*/);
		}
		
		// Initialize orange face
		orangeFace = new ArrayList<String>();
		for (int i = 0; i < width*width; i++) {
			orangeFace.add("O"/*+i*/);
		}
	}
	
	// copy constructor
	public RubiksCube(RubiksCube r) {
		whiteFace = (ArrayList<String>)r.getWhiteFace().clone();
		greenFace = (ArrayList<String>)r.getGreenFace().clone();
		yellowFace = (ArrayList<String>)r.getYellowFace().clone();
		blueFace = (ArrayList<String>)r.getBlueFace().clone();
		redFace = (ArrayList<String>)r.getRedFace().clone();
		orangeFace = (ArrayList<String>)r.getOrangeFace().clone();
		faceWidth = r.faceWidth;
	}
	
	// Getters for each face
	public ArrayList<String> getWhiteFace() {
		return whiteFace;
	}
	public ArrayList<String> getGreenFace() {
		return greenFace;
	}
	public ArrayList<String> getYellowFace() {
		return yellowFace;
	}
	public ArrayList<String> getBlueFace() {
		return blueFace;
	}
	public ArrayList<String> getRedFace() {
		return redFace;
	}
	public ArrayList<String> getOrangeFace() {
		return orangeFace;
	}
	public int getWidth() {
		return faceWidth;
	}
	
	/* Rotations will be done with respect to the white face of the cube
	   There are 12 different possible rotations:
	
	   	1. Rotates the right third of the square up
	   	2. Rotates the right third of the square down
	   	
	   	3. Rotates the top third of the square left
	   	4. Rotates the top third of the square right
	   	
	   	5. Rotates the left third of the square up
	   	6. Rotates the left third of the square down
	   	
	   	7. Rotates the bottom third of the square left
	   	8. Rotates the bottom third of the square right
	   	
	   	For these rotations, no change will be seen on the white face:
	   	
	   	9. Rotates the entire square face to the right
	   	10. Rotates the entire square face to the left
	   	
	   	11. Rotates the back square face to the right
	   	12. Rotates the back square face to the left
	*/
	public void rotate(int action) {
		// Save the old state temporarily
		RubiksCube temp = new RubiksCube(this);
		int row = 0;
		int col = 0;
		
		switch (action) {

	   	// 1. Rotates the right third of the square up
		case 1:
			row = faceWidth;
			col = faceWidth;
			for (int i = 0; i < row; i++) {
				this.whiteFace.set((col-1)+faceWidth*i, temp.getOrangeFace().get((col-1)+faceWidth*i));
				this.redFace.set((col-1)+faceWidth*i, temp.getWhiteFace().get((col-1)+faceWidth*i));
				this.yellowFace.set(faceWidth*i, temp.getRedFace().get((faceWidth*faceWidth)-(i*faceWidth)-1));
				this.orangeFace.set((col-1)+faceWidth*i, temp.getYellowFace().get((faceWidth*faceWidth)-(faceWidth*(i+1))));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.greenFace.set(next, temp.getGreenFace().get(i));
			}
			break;
			
		// 2. Rotates the right third of the square down
		case 2:
			row = faceWidth;
			col = faceWidth;
			for (int i = 0; i < row; i++) {
				this.orangeFace.set((col-1)+faceWidth*i, temp.getWhiteFace().get((col-1)+faceWidth*i));
				this.whiteFace.set((col-1)+faceWidth*i, temp.getRedFace().get((col-1)+faceWidth*i));
				this.redFace.set((col-1)+faceWidth*i, temp.getYellowFace().get((faceWidth*(faceWidth-1))-(faceWidth*i)));
				this.yellowFace.set(faceWidth*i, temp.getOrangeFace().get((faceWidth*faceWidth)-(i*faceWidth)-1));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.greenFace.set(next, temp.getGreenFace().get(i));
			}
			break;
			
		// 3. Rotates the top third of the square left
		case 3:
			col = 0;
			for (int i = 0; i < faceWidth; i++) {
				this.whiteFace.set(col+i, temp.getGreenFace().get(col+i));
				this.greenFace.set(col+i, temp.getYellowFace().get(col+i));
				this.yellowFace.set(col+i, temp.getBlueFace().get(col+i));
				this.blueFace.set(col+i, temp.getWhiteFace().get(col+i));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.redFace.set(next, temp.getRedFace().get(i));
			}
			break;
			
		// 4. Rotates the top third of the square right
		case 4:
			col = 0;
			for (int i = 0; i < faceWidth; i++) {
				this.whiteFace.set(col+i, temp.getBlueFace().get(col+i));
				this.blueFace.set(col+i, temp.getYellowFace().get(col+i));
				this.yellowFace.set(col+i, temp.getGreenFace().get(col+i));
				this.greenFace.set(col+i, temp.getWhiteFace().get(col+i));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.redFace.set(next, temp.getRedFace().get(i));
			}
			break;
			
		// 5. Rotates the left third of the square up
		case 5:
			col = 1;
			row = faceWidth;
			for (int i = 0; i < row; i++) {
				this.whiteFace.set((col-1)+faceWidth*i, temp.getOrangeFace().get((col-1)+faceWidth*i));
				this.redFace.set((col-1)+faceWidth*i, temp.getWhiteFace().get((col-1)+faceWidth*i));
				this.yellowFace.set((faceWidth-1)+faceWidth*i, temp.getRedFace().get((faceWidth*faceWidth)-(faceWidth*(i+1))));
				this.orangeFace.set((col-1)+faceWidth*i, temp.getYellowFace().get((faceWidth*faceWidth)-(faceWidth*i)-1));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.blueFace.set(next, temp.getBlueFace().get(i));
			}
			break;
		
		// 6. Rotates the left third of the square down
		case 6:
			col = 1;
			row = faceWidth;
			for (int i = 0; i < row; i++) {
				this.orangeFace.set((col-1)+faceWidth*i, temp.getWhiteFace().get((col-1)+faceWidth*i));
				this.whiteFace.set((col-1)+faceWidth*i, temp.getRedFace().get((col-1)+faceWidth*i));
				this.redFace.set((col-1)+faceWidth*i, temp.getYellowFace().get((faceWidth*faceWidth)-(faceWidth*(i))-1));
				this.yellowFace.set((faceWidth-1)+(faceWidth*i), temp.getOrangeFace().get((faceWidth*faceWidth)-(faceWidth*(i+1))));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.blueFace.set(next, temp.getBlueFace().get(i));
			}
			break;
			
		// 7. Rotates the bottom third of the square left
		case 7:
			col = faceWidth-1;
			for (int i = 0; i < faceWidth; i++) {
				this.whiteFace.set((col*faceWidth)+i, temp.getGreenFace().get((col*faceWidth)+i));
				this.greenFace.set((col*faceWidth)+i, temp.getYellowFace().get((col*faceWidth)+i));
				this.yellowFace.set((col*faceWidth)+i, temp.getBlueFace().get((col*faceWidth)+i));
				this.blueFace.set((col*faceWidth)+i, temp.getWhiteFace().get((col*faceWidth)+i));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.orangeFace.set(next, temp.getOrangeFace().get(i));
			}
			break;

		// 8. Rotates the bottom third of the square right
		case 8:
			col = faceWidth-1;
			for (int i = 0; i < faceWidth; i++) {
				this.whiteFace.set((col*faceWidth)+i, temp.getBlueFace().get((col*faceWidth)+i));
				this.blueFace.set((col*faceWidth)+i, temp.getYellowFace().get((col*faceWidth)+i));
				this.yellowFace.set((col*faceWidth)+i, temp.getGreenFace().get((col*faceWidth)+i));
				this.greenFace.set((col*faceWidth)+i, temp.getWhiteFace().get((col*faceWidth)+i));
			}
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.orangeFace.set(next, temp.getOrangeFace().get(i));
			}
			break;
		
		// 9. Rotates the entire square face to the right
		case 9:
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.whiteFace.set(next, temp.getWhiteFace().get(i));
			}
			for (int i = 0; i < faceWidth; i++) {
				this.redFace.set((faceWidth*(faceWidth-1)+i), temp.getBlueFace().get((faceWidth-1)+i*faceWidth));
				this.greenFace.set(faceWidth*i, temp.getRedFace().get((faceWidth*(faceWidth-1)+i)));
				this.orangeFace.set(i, temp.getGreenFace().get((faceWidth*faceWidth)-faceWidth*(i+1)));
				this.blueFace.set((faceWidth-1)+i*faceWidth, temp.getOrangeFace().get(i));
			}
			break;	

		// 10. Rotates the entire square face to the left
		case 10:
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.whiteFace.set(next, temp.getWhiteFace().get(i));
			}
			for (int i = 0; i < faceWidth; i++) {
				this.redFace.set((faceWidth*(faceWidth-1)+i), temp.getGreenFace().get(i*faceWidth));
				this.blueFace.set((i*faceWidth)+(faceWidth-1), temp.getRedFace().get((faceWidth*faceWidth)-(i+1)));
				this.orangeFace.set(i, temp.getBlueFace().get((i*faceWidth)+(faceWidth-1)));
				this.greenFace.set(i*faceWidth, temp.getOrangeFace().get(faceWidth-(i+1)));
			}
			break;
		
		// 11. Rotates the back square face to the right
		case 11:
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = ((faceWidth*faceWidth) - (faceWidth - (i/faceWidth))) - (faceWidth*(i%faceWidth));
				this.yellowFace.set(next, temp.getYellowFace().get(i));
			}
			for (int i = 0; i < faceWidth; i++) {
				this.greenFace.set((faceWidth-1)+(i*faceWidth), temp.getRedFace().get(i));
				this.orangeFace.set(((faceWidth-1)*faceWidth)+i, temp.getGreenFace().get((faceWidth*faceWidth)-(faceWidth*i)-1));
				this.blueFace.set(faceWidth*i, temp.getOrangeFace().get((((faceWidth-1)*faceWidth)+i)));
				this.redFace.set(i, temp.getBlueFace().get((faceWidth*faceWidth)-(faceWidth*(i+1))));
			}
			break;

		// 12. Rotates the back square face to the left
		case 12:
			for (int i = 0; i < (faceWidth*faceWidth); i++) {
				int next = (((faceWidth-1) + (faceWidth*i)) % (faceWidth*faceWidth)) - (i / faceWidth);
				this.yellowFace.set(next, temp.getYellowFace().get(i));
			}
			for (int i = 0; i < faceWidth; i++) {
				this.blueFace.set(faceWidth*i, temp.getRedFace().get(faceWidth-(i+1)));
				this.orangeFace.set(((faceWidth-1)*faceWidth)+i, temp.getBlueFace().get(faceWidth*i));
				this.greenFace.set((faceWidth-1)+(i*faceWidth), temp.getOrangeFace().get((faceWidth*faceWidth)-(i+1)));
				this.redFace.set(i, temp.getGreenFace().get((faceWidth-1)+(i*faceWidth)));
			}
			break;
			
		default:
			break;
		}
		
	}
	@Override
	public String toString() {
		// Display the current state in a reasonable format, ie. "[[W,W,...], [G,G,...],...]"
		String start = "[";
		String comma = ", ";
		String end = "]";
		
		String white = "";
		white += start;
		for (int i = 0; i < whiteFace.size(); i++) {
			white += whiteFace.get(i);
			if (i != whiteFace.size()-1)
				white += comma;
		}
		white += end;
		
		String blue = "";
		blue += start;
		for (int i = 0; i < blueFace.size(); i++) {
			blue += blueFace.get(i);
			if (i != blueFace.size()-1)
				blue += comma;
		}
		blue += end;
		
		String yellow = "";
		yellow += start;
		for (int i = 0; i < yellowFace.size(); i++) {
			yellow += yellowFace.get(i);
			if (i != yellowFace.size()-1)
				yellow += comma;
		}
		yellow += end;
		
		String green = "";
		green += start;
		for (int i = 0; i < greenFace.size(); i++) {
			green += greenFace.get(i);
			if (i != greenFace.size()-1)
				green += comma;
		}
		green += end;
		
		String red = "";
		red += start;
		for (int i = 0; i < redFace.size(); i++) {
			red += redFace.get(i);
			if (i != redFace.size()-1)
				red += comma;
		}
		red += end;
		
		String orange = "";
		orange += start;
		for (int i = 0; i < orangeFace.size(); i++) {
			orange += orangeFace.get(i);
			if (i != orangeFace.size()-1)
				orange += comma;
		}
		orange += end;
		
		String cube = "";
		cube += start;
		cube +=white;
		cube += comma;
		cube += green;
		cube += comma;
		cube += yellow;
		cube += comma;
		cube += blue;
		cube += comma;
		cube += red;
		cube += comma;
		cube += orange;
		cube += end;
		
		return cube;
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		// Check if two rubik's cube states are equal by checking each side colour
		RubiksCube cube = (RubiksCube) o;
		for (int i =0; i < faceWidth*faceWidth; i++) {
			if (!whiteFace.get(i).equals(cube.getWhiteFace().get(i))) {
				return false;
			}
			if (!greenFace.get(i).equals(cube.getGreenFace().get(i))) {
				return false;
			}
			if (!yellowFace.get(i).equals(cube.getYellowFace().get(i))) {
				return false;
			}
			if (!blueFace.get(i).equals(cube.getBlueFace().get(i))) {
				return false;
			}
			if (!redFace.get(i).equals(cube.getRedFace().get(i))) {
				return false;
			}
			if (!orangeFace.get(i).equals(cube.getOrangeFace().get(i))) {
				return false;
			}
		}
		return true;
	}

}
