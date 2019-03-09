/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
class Model {
	
	static Direction[] directions = {Direction.SOUTHEAST, Direction.SOUTHWEST, Direction.NORTHEAST, Direction.NORTHWEST, Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST};
	static Direction getDirection(int index) {
		return directions[index];
	}
	
	int xloc = 0;
	int yloc = 0;
	final int xDistance = 8;
	final int yDistance = 2;
	final int minloc = 0;
	Direction direction = Direction.SOUTHEAST;
	int width;
	int height;
	int objectwidth;
	int objectheight;
	Model(int myWidth, int myHeight, int myObjectWidth, int myObjectHeight) {
		width = myWidth;
		height = myHeight;
		objectwidth = myObjectWidth;
		objectheight = myObjectHeight;
	}
	
	/* Get function returns the x location of the orc. No inputs. */
	int getX() {
		return xloc;
	}
	
	/* Get function returns the y location of the orc. No inputs. */
	int getY() {
		return yloc;
	}
	
	/* Get function returns the direction of the orc. No inputs. */
	Direction getDirect() {
		return direction;
	}
	
	/* Function updates location and direction based on the orc's current travel, making it bounce off walls. No inputs. */
	void updateLocationAndDirection() {
		switch (direction) {
			case SOUTHEAST:
				if (xloc <= width - objectwidth && yloc <= height - objectheight) {
	    			xloc += xDistance;
					yloc += yDistance;
				} else if (xloc <= width - objectwidth) {
	    			direction = Direction.NORTHEAST;
	    			xloc += xDistance;
	    			yloc -= yDistance;
	    		}
	    		else if (yloc <= height - objectheight) {
	    			direction = Direction.SOUTHWEST;
	    			xloc -= xDistance;
	    			yloc += yDistance;
	    		}
	    		else {
	    			direction = Direction.NORTHWEST; 
	    			xloc -= xDistance; 
	    			yloc -= yDistance;
	    		}
				break;
			case SOUTHWEST:
				if (xloc >= minloc && yloc <= height - objectheight) {
	    			xloc -= xDistance;
	    			yloc += yDistance;
				} else if (xloc >= minloc) {
	    			direction = Direction.NORTHWEST;
	    			xloc -= xDistance;
	    			yloc -= yDistance;
	    		}
	    		else if (yloc <= height - objectheight) {
	    			direction = Direction.SOUTHEAST;
	    			xloc += xDistance;
	    			yloc += yDistance;
	    		}
	    		else {
	    			direction = Direction.NORTHEAST;
	    			xloc += xDistance;
	    			yloc -= yDistance;
	    		}
				break;
			case NORTHEAST:
				if (xloc <= width - objectwidth && yloc >= minloc) {
	    			xloc += xDistance;
	    			yloc -= yDistance;
				} else if (xloc <= width - objectwidth) {
	    			direction = Direction.SOUTHEAST;
	    			xloc += xDistance; 
	    			yloc -= yDistance;
	    		}
	    		else if (yloc >= minloc) {
	    			direction = Direction.NORTHWEST;
	    			xloc -= xDistance; 
	    			yloc -= yDistance;
	    		}
	    		else {
	    			direction = Direction.SOUTHWEST;
	    			xloc -= xDistance;
	    			yloc += yDistance;
	    		}
				break;
			case NORTHWEST:
				if (xloc >= minloc && yloc >= minloc) {
	    			xloc -= xDistance; 
	    			yloc -= yDistance;
				} else if (xloc >= minloc) {
	    			direction = Direction.WEST;
	    			xloc -= xDistance;
	    		}
	    		else if (yloc >= minloc) {
	    			direction = Direction.NORTH;
	    			yloc -= yDistance;
	    		}
	    		else {
	    			direction = Direction.SOUTH;
	    			yloc += yDistance;
	    		}
				break;
			case NORTH:
				if (yloc >= minloc) {
	    			yloc -= yDistance;
				} else if (xloc >= minloc) {
	    			direction = Direction.WEST;
	    			xloc -= xDistance;
	    		}
	    		else {
	    			direction = Direction.EAST;
	    			xloc += xDistance;
	    		}
				break;
			case WEST:
				if (xloc >= minloc) {
	    			xloc -= xDistance;
				} else if (yloc >= minloc) {
	    			direction = Direction.NORTH;
	    			yloc -= yDistance;
	    		}
	    		else {
	    			direction = Direction.SOUTH;
	    			yloc += yDistance;
	    		}
				break;
			case SOUTH:
				if (yloc <= height - objectheight) {
	    			yloc += yDistance;
				} else if (xloc >= minloc) {
	    			direction = Direction.WEST;
	    			xloc -= xDistance;
	    		}
	    		else {
	    			direction = Direction.EAST;
	    			xloc += xDistance;
	    		}
				break;
			case EAST:
				if (xloc <= width - objectwidth) {
	    			xloc += xDistance;
				} else if (yloc >= minloc) {
	    			direction = Direction.NORTHEAST;
	    			xloc += xDistance;
	    			yloc -= yDistance;
	    		}
	    		else {
	    			direction = Direction.SOUTHEAST;
	    			xloc += xDistance;
	    			yloc += yDistance;
	    		}
				break;
		}
	}
}
