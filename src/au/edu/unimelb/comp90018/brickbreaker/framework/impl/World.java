package au.edu.unimelb.comp90018.brickbreaker.framework.impl;

import java.util.ArrayList;
import java.util.List;

import au.edu.unimelb.comp90018.brickbreaker.actors.Ball;
import au.edu.unimelb.comp90018.brickbreaker.actors.Brick;
import au.edu.unimelb.comp90018.brickbreaker.actors.Paddle;
import au.edu.unimelb.comp90018.brickbreaker.framework.WorldListener;
import au.edu.unimelb.comp90018.brickbreaker.framework.impl.Rectangle2.RectangleSide;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class World {

	public static final float WORLD_WIDTH = 20;
	public static final float WORLD_HEIGHT = 30;

	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;

	public Ball ball;
	public Paddle paddle;
	public List<Brick> bricks;

	public final WorldListener listener;
	public int score;
	public int state;

	public World(WorldListener listener) {

		// TODO: Ball's initial velocity must be a world's parameter. Even the
		// initial position of the ball and paddle.
		paddle = new Paddle(WORLD_WIDTH / 2, 2);
		ball = new Ball(WORLD_WIDTH / 2, paddle.position.y + Paddle.PADDLE_HEIGHT / 2 + Ball.BALL_HEIGHT / 2,
				new Vector2(5, 5));
		bricks = new ArrayList<Brick>();

		this.listener = listener;

		/*
		 * Generates the level, this method should include the call to a xml
		 * loader file
		 */
		generateLevel();
	}

	private void generateLevel() {

		float x = 5.5f;
		float y = 24.5f;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 8; j++) {
				bricks.add(new Brick(x, y));
				x += 1.25f;
			}
			x = 5.5f;
			y += 1.25f;
		}

		// this.ball = new Ball(Assets.red_ball,GAME_WIDTH/2 -
		// Assets.red_ball.getRegionWidth()/2,40+Assets.paddle.getRegionHeight()-3,100);
		// this.paddle = new Paddle(Assets.paddle,GAME_WIDTH/2 -
		// Assets.paddle.getRegionWidth()/2,40,600);
		// //Generate example bricks
		//
		// for (int y = 0; y < 3; y++) {
		// for (int x = 0; x < 8; x++) {
		// Brick brick = new
		// Brick(Assets.brick,5*(x+1)+(x*Assets.brick.getRegionWidth()),
		// GAME_HEIGHT - ((10*(y+1))+(y+1)*Assets.brick.getRegionHeight()));
		// this.bricks.add(brick);
		// }
		// }

		// LevelDownloader ld = new LevelDownloader();
		// GameLevel gameLevel = null;
		// try {
		// gameLevel = ld.downloadGame("brickbreaker_level1.xml");
		// /*Here you should generate the game level using the configurations
		// loaded from XMl file
		// * note that all parameters from paddle example are constants, some of
		// them could be part of the xml file.
		// */
		// this.ball = new Ball(Assets.red_ball,GAME_WIDTH/2 -
		// Assets.red_ball.getRegionWidth()/2,40+Assets.paddle.getRegionHeight()-3,gameLevel.getBall().getSpeed());
		// this.paddle = new Paddle(Assets.paddle,GAME_WIDTH/2 -
		// Assets.paddle.getRegionWidth()/2,40,gameLevel.getPaddle().getSpeed());
		//
		// au.edu.unimelb.comp90018.brickbreaker.framework.model.Brick
		// modelBricks[][] = gameLevel.getBricks();
		//
		// for ( int i = 0; i < modelBricks.length; i++ ){
		// for ( int j = 0; j < modelBricks[i].length; j++ ){
		// if (modelBricks[i][j]!=null){
		// int x = modelBricks[i][j].getX();
		// int y = modelBricks[i][j].getY();
		// Brick brick = new
		// Brick(Assets.brick,5*(x+1)+(x*Assets.brick.getRegionWidth()),
		// GAME_HEIGHT - ((10*(y+1))+(y+1)*Assets.brick.getRegionHeight()));
		// this.bricks.add(brick);
		// }
		// }
		// }
		//
		// } catch (IOException | XmlPullParserException | NullPointerException
		// e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// this.ball = new Ball(Assets.red_ball,GAME_WIDTH/2 -
		// Assets.red_ball.getRegionWidth()/2,40+Assets.paddle.getRegionHeight()-3,500);
		// this.paddle = new Paddle(Assets.paddle,GAME_WIDTH/2 -
		// Assets.paddle.getRegionWidth()/2,40,600);
		// //Generate example bricks
		//
		// for (int y = 0; y < 3; y++) {
		// for (int x = 0; x < 8; x++) {
		// Brick brick = new
		// Brick(Assets.brick,5*(x+1)+(x*Assets.brick.getRegionWidth()),
		// GAME_HEIGHT - ((10*(y+1))+(y+1)*Assets.brick.getRegionHeight()));
		// this.bricks.add(brick);
		// }
		// }
		//
		// }
	}

	public void update(float deltaTime, float accelX) {
		updateBall(deltaTime);
		updatePaddle(deltaTime, accelX);
		checkCollisions();
		checkGameOver();
	}

	private void updateBall(float deltaTime) {
		ball.update(deltaTime);
	}

	private void updatePaddle(float deltaTime, float accelX) {
		// TODO: Review factor of normalisation of the acceleration
		paddle.update(deltaTime, -accelX * 5);
	}

	private void checkGameOver() {
		// if (heightSoFar - 7.5f > bob.position.y) {
		// state = WORLD_STATE_GAME_OVER;
		// }
	}

	private void checkCollisions() {
		checkPaddleCollision();
		checkBrickCollision();
	}

	private void checkPaddleCollision() {

		if (ball.velocity.y > 0)
			return;
		
		if (ball.bounds.overlaps(paddle.bounds)) {			
//			List<RectangleSide> sides = ball.bounds.whichSidesOverlapMe(paddle.bounds);			
			ball.hitPaddle(paddle.velocity.x);
			// listener.jump();
			// if (rand.nextFloat() > 0.5f) {
			// platform.pulverize();
			// }

		}
	}

	private void checkBrickCollision() {

		int len = bricks.size();
		for (int i = 0; i < len; i++) {
			if (ball.bounds.overlaps(bricks.get(i).bounds)) {
				ball.hitBrick(bricks.get(i).bounds);
				bricks.remove(i);
				break;
			}
		}
	}
}
