package au.edu.unimelb.comp90020.brickbreaker.actors;

/**
 * Concrete brick class which needs TWO hits to be pulverised.
 * 
 */
public class BrickTypeII extends BrickAdapter implements Brick {

	static float WIDTH = 32;
	static float HEIGHT = 16;

	public BrickTypeII(float x, float y) {
		super(x, y, WIDTH, HEIGHT, 2);
	}

	@Override
	public boolean isPulverised() {
		return hitsLeftToPulverise == 0;
	}

	@Override
	public void hitMe() {
		hitsLeftToPulverise--;
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub

	}

}
