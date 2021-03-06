package au.edu.unimelb.comp90020.brickbreaker.screens;

import au.edu.unimelb.comp90020.brickbreaker.BrickBreaker;
import au.edu.unimelb.comp90020.brickbreaker.framework.util.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Splash screen shown at the begining of the game
 * @author Diego
 *
 */
public class SplashScreen extends ScreenAdapter implements TextInputListener {
	BrickBreaker game;
	@SuppressWarnings("unused")
	private long startTime;

	OrthographicCamera guiCam;

	public SplashScreen(BrickBreaker game) {
		// User user = null;

		this.game = game;
		guiCam = new OrthographicCamera(800, 1280);
		guiCam.position.set(800 / 2, 1280 / 2, 0);

		startTime = TimeUtils.millis();

		// return;
	}

	public void update() {
	}

	public void draw() {

		GL20 gl = Gdx.gl;

		gl.glViewport((int) game.viewport.x, (int) game.viewport.y,
				(int) game.viewport.width, (int) game.viewport.height);

		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		guiCam.update();

		game.batcher.setProjectionMatrix(guiCam.combined);
		game.batcher.disableBlending();
		game.batcher.begin();
		game.batcher.draw(Assets.splashScreen, 0, 0, 800, 1280);
		game.batcher.end();
	}

	@Override
	public void render(float delta) {
		draw();
		update();
	}

	@Override
	public void hide() {
		super.dispose();
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub

	}

	@Override
	public void input(String arg0) {
		// TODO Auto-generated method stub

	}

}
