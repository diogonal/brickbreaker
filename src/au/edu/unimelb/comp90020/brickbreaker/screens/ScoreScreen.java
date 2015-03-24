package au.edu.unimelb.comp90020.brickbreaker.screens;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.xmlpull.v1.XmlPullParserException;

import au.edu.unimelb.comp90020.brickbreaker.BrickBreaker;
import au.edu.unimelb.comp90020.brickbreaker.actors.Button;
import au.edu.unimelb.comp90020.brickbreaker.actors.Button.ButtonSize;
import au.edu.unimelb.comp90020.brickbreaker.framework.network.LevelDownloader;
import au.edu.unimelb.comp90020.brickbreaker.framework.util.Assets;
import au.edu.unimelb.comp90020.brickbreaker.framework.util.Settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * Screen to display high scores
 *
 */
public class ScoreScreen extends ScreenAdapter {
	/**
	 * Brick Breaker Game
	 */
	BrickBreaker game;

	/**
	 * Otrhographic Camera
	 */
	OrthographicCamera guiCam;
	/**
	 * Vector to store the touch point for the back button
	 */
	Vector3 touchPoint;

	/**
	 * Message to be rendered
	 */
	String scoreString;
	
	/**
	 *  Back Button
	 */
	private Button btnBack;

	/**
	 * Screen Constructor
	 * @param game BrickBreaker Game
	 */
	public ScoreScreen(BrickBreaker game) {

		this.game = game;
		this.scoreString = "";
		
		guiCam = new OrthographicCamera(Settings.TARGET_WIDTH,
				Settings.TARGET_HEIGHT);
		guiCam.position.set(Settings.TARGET_WIDTH / 2,
				Settings.TARGET_HEIGHT / 2, 0);

		touchPoint = new Vector3();

		btnBack = new Button(20, 20, ButtonSize.MEDIUM_SQUARE);

		LevelDownloader ld = new LevelDownloader();
		Gdx.app.log("Score Screen", "Constructor called");
		try {
			String hs = ld.downloadHighScores();
			ld.persistScores(hs);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			scoreString = ld.loadHighScores();
		} catch (XmlPullParserException e) {
			scoreString = "Scores\n\n1.- 1000\n2.- 950\n3.- 940\n4.- 930\n5.- 920";
			e.printStackTrace();
		} catch (IOException e) {
			scoreString = "Scores\n\n1.- 1000\n2.- 950\n3.- 940\n4.- 930\n5.- 920";
			e.printStackTrace();
		} catch (GdxRuntimeException e){
			scoreString = "Scores\n\n1.- 1000\n2.- 950\n3.- 940\n4.- 930\n5.- 920";			
		}

		
	}

	/**
	 * Check whether the back button has been touched or not. If touched render the menu again
	 */
	public void update() {
		
		if (Gdx.input.justTouched()) {
			
			guiCam.unproject(
					touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0), 
					game.viewport.x, 
					game.viewport.y,
					game.viewport.width, 
					game.viewport.height
					);
			
			if (btnBack.bounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new MenuScreen(game));
				dispose();
				Gdx.app.log("", "click para regresar");

				return;
			}

		}
	}

	/**
	 * Draw the screen with the high scores
	 */
	public void draw() {
		
		GL20 gl = Gdx.gl;

		gl.glViewport(
				(int) game.viewport.x, 
				(int) game.viewport.y, 
				(int) game.viewport.width,
				(int) game.viewport.height
				);
		
		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		guiCam.update();
		
		Assets.font.setScale(0.7f, 0.7f);
		Assets.font.setColor(new Color(Color.WHITE));

		game.batcher.setProjectionMatrix(guiCam.combined);
		game.batcher.enableBlending();
		game.batcher.begin();

		game.batcher.draw(Assets.defaultScreen, 0, 0, Settings.TARGET_WIDTH,
				Settings.TARGET_HEIGHT);
		game.batcher.draw(Assets.defaultNotification, 0, 0, Settings.TARGET_WIDTH,
				Settings.TARGET_HEIGHT);

		game.batcher.draw(Assets.back, btnBack.position.x
				- ButtonSize.MEDIUM_SQUARE.getButtonWidth() / 2,
				btnBack.position.y - ButtonSize.MEDIUM_SQUARE.getButtonHeight()
						/ 2, ButtonSize.MEDIUM_SQUARE.getButtonWidth(),
				ButtonSize.MEDIUM_SQUARE.getButtonHeight());

		Assets.font.setScale(0.6f, 0.6f);
		Assets.font.drawMultiLine(game.batcher, scoreString, 100, 400);

		game.batcher.end();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ScreenAdapter#render(float)
	 */
	@Override
	public void render(float delta) {
		draw();
		update();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ScreenAdapter#hide()
	 */
	@Override
	public void hide() {
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ScreenAdapter#show()
	 */
	@Override
	public void show() {
		super.show();

	}	
	
	
}
