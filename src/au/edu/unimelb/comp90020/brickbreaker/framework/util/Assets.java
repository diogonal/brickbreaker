package au.edu.unimelb.comp90020.brickbreaker.framework.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/**
 * Handles all assets: Textures, sounds, music and Animations.
 * @author Diego
 *
 */
public class Assets {

	/* Textures - there must be less possible */
	public static TextureRegion gameBackground;
	public static Texture defaultBackground;
	public static Texture splashBackground;
	public static Texture menuBackground;
	public static Texture background;
	public static Texture items; //Main Texture with game sprites
	public static Texture errorMessageB; 
	public static Texture infoMessageB; 

	/*Message Screens*/
	public static TextureRegion errorMessage;
	public static TextureRegion infoMessage;
	
	/* Transparent Screens*/
	public static TextureRegion defaultNotification;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion win;
	public static TextureRegion pauseMenu;
	
	/*Here declare game Textures*/
	public static TextureRegion blueBall;
	public static TextureRegion redBall;
	public static TextureRegion paddleLarge;
	public static TextureRegion paddleSmall;
	//Variety of Bricks:
	public static TextureRegion smallGreenBrick;
	public static TextureRegion mediumGreenBrick;
	public static TextureRegion smallOrangeBrick;
	public static TextureRegion mediumOrangeBrick;
	public static TextureRegion smallBlueBrick;
	public static TextureRegion mediumBlueBrick;
	public static TextureRegion smallYellowBrick;
	public static TextureRegion smallPurpleBrick;
	public static TextureRegion smallPinkBrick;
	public static TextureRegion smallBlackBrick;
	public static TextureRegion lives;
	public static TextureRegion coin;
	public static TextureRegion virus;
	public static TextureRegion buttonMenu;
	
	/*Here declare buttons*/
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion musicOn;
	public static TextureRegion musicOff;
	public static TextureRegion accelOn;
	public static TextureRegion quit;
	public static TextureRegion back;
	public static TextureRegion pause;
	public static TextureRegion settings;
	public static TextureRegion help;
	public static TextureRegion arrowRight;
	public static TextureRegion arrowLeft;
	public static TextureRegion touchOn;
	public static TextureRegion soundGameOn;
	public static TextureRegion soundGameOff;
	public static TextureRegion pauseGame;
	
	/*Here declare buttons for locked levels*/
	public static TextureRegion levelLocked_1;
	public static TextureRegion levelLocked_2;
	public static TextureRegion levelLocked_3;
	public static TextureRegion levelLocked_4;
	public static TextureRegion levelLocked_5;
	public static TextureRegion levelLocked_6;
	public static TextureRegion levelLocked_7;
	public static TextureRegion levelLocked_8;
	public static TextureRegion levelLocked_9;
	
	public static TextureRegion levelUnlocked_1;
	public static TextureRegion levelUnlocked_2;
	public static TextureRegion levelUnlocked_3;
	public static TextureRegion levelUnlocked_4;
	public static TextureRegion levelUnlocked_5;
	public static TextureRegion levelUnlocked_6;
	public static TextureRegion levelUnlocked_7;
	public static TextureRegion levelUnlocked_8;
	public static TextureRegion levelUnlocked_9;

	/*Here declare Screens*/
	public static TextureRegion defaultScreen;
	public static TextureRegion helpScreen;
	public static TextureRegion menuScreen;
	public static TextureRegion optionScreen;
	public static TextureRegion scoresScreen;
	public static TextureRegion splashScreen;

	/* Animations */
	// public static Animation coinAnim; //example

	/* TextureRegionSets -> Something similar to Animations */
	public static TextureRegionSet brickTypeI;
	public static TextureRegionSet brickTypeII;
	public static TextureRegionSet brickTypeIII;
	
	/* BitmapFonts */
	public static BitmapFont font;
	
	/* Sounds & Music */
	public static Music music;

	public static Sound touchPaddleSound;
	public static Sound touchWallSound;
	public static Sound touchBrickSound;
	public static Sound touchHardBrickSound;
	public static Sound lifeLostSound;
	public static Sound gameOverSound;
	public static Sound winnerSound;
	public static Sound lifeBonusSound;
	public static Sound coinBonusSound;
	public static Sound badBonusSound;
	public static Sound clickSound;
	public static Sound toggleSound;

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	@SuppressWarnings("static-access")
	public static Texture loadTransparentTexture(int width, int height,
			String file) {

		Pixmap mask = new Pixmap(width, height, Pixmap.Format.Alpha);
		mask.fillRectangle(0, 0, width, height);

		Pixmap fg = new Pixmap(Gdx.files.internal(file));
		fg.drawPixmap(mask, fg.getWidth(), fg.getHeight());
		mask.setBlending(Pixmap.Blending.SourceOver);

		Texture texture = new Texture(fg);

		return texture;
	}

	public static void load() {
		
		/*Here declare screen backgrounds*/
		defaultBackground = loadTexture("backgrounds/screens/default_background.png");
		defaultScreen = new TextureRegion(defaultBackground, 0, 0, 800, 1280);
		
		menuBackground = loadTexture("backgrounds/screens/screen_menu.png");
		menuScreen = new TextureRegion(menuBackground, 0, 0, 800, 1280);
		
		splashBackground = loadTexture("backgrounds/screens/screen_splash.png");
		splashScreen = new TextureRegion(splashBackground, 0, 0, 800, 1280);
		
		background = loadTexture("backgrounds/background.png");
		gameBackground = new TextureRegion(background, 0, 0, 800, 1280);
		
		errorMessageB = loadTexture("backgrounds/errorBackground.png");
		errorMessage = new TextureRegion(errorMessageB, 0, 0, 800, 1280);
		
		infoMessageB = loadTexture("backgrounds/infoBackground.png");
		infoMessage = new TextureRegion(infoMessageB, 0, 0, 800, 1280);
		
		
		/*Here you should put all textures that comes from items.png*/
		items = loadTexture("textures/items.png");
		blueBall = new TextureRegion(items, 0, 0, 64, 64);
		redBall = new TextureRegion(items, 0, 64, 64, 64);
		paddleLarge = new TextureRegion(items, 160, 0, 352, 96);
		paddleSmall = new TextureRegion(items, 96, 32, 128, 32);
		lives = new TextureRegion(items, 224, 0, 64, 64);
		coin = new TextureRegion(items, 224, 64, 64, 64);
		virus = new TextureRegion(items, 160, 64, 64, 64);
		smallGreenBrick = new TextureRegion(items, 64, 0, 32, 16);
		mediumGreenBrick = new TextureRegion(items, 80, 64, 32, 16);
		smallOrangeBrick = new TextureRegion(items, 64, 16, 32, 16);
		mediumOrangeBrick = new TextureRegion(items, 80, 80, 32, 16);
		smallBlueBrick = new TextureRegion(items, 64, 32, 32, 16);
		mediumBlueBrick  = new TextureRegion(items, 80, 96, 32, 16);
		smallYellowBrick = new TextureRegion(items, 64, 48, 32, 16);
		smallPurpleBrick = new TextureRegion(items, 64, 64, 32, 16);
		smallPinkBrick = new TextureRegion(items, 64, 80, 32, 16);
		smallBlackBrick = new TextureRegion(items, 64, 96, 32, 16);
		//Button template that goes behind text (used in menus):
		buttonMenu = new TextureRegion(items, 512, 769, 256, 64); //The button shown in the main menu
		
		/*Here you should load textures for locked levels*/
		levelLocked_1 = new TextureRegion(items, 0, 128, 128, 128);
		levelLocked_2 = new TextureRegion(items, 128, 128, 128, 128);
		levelLocked_3 = new TextureRegion(items, 256, 128, 128, 128);
		levelLocked_4 = new TextureRegion(items, 0, 256, 128, 128);
		levelLocked_5 = new TextureRegion(items, 128, 256, 128, 128);
		levelLocked_6 = new TextureRegion(items, 256, 256, 128, 128);
		levelLocked_7 = new TextureRegion(items, 0, 384, 128, 128);
		levelLocked_8 = new TextureRegion(items, 128, 384, 128, 128);
		levelLocked_9 = new TextureRegion(items, 256, 384, 128, 128);
		
		levelUnlocked_1 = new TextureRegion(items, 384, 128, 128, 128);
		levelUnlocked_2 = new TextureRegion(items, 512, 128, 128, 128);
		levelUnlocked_3 = new TextureRegion(items, 640, 128, 128, 128);
		levelUnlocked_4 = new TextureRegion(items, 384, 256, 128, 128);
		levelUnlocked_5 = new TextureRegion(items, 512, 256, 128, 128);
		levelUnlocked_6 = new TextureRegion(items, 640, 256, 128, 128);
		levelUnlocked_7 = new TextureRegion(items, 384, 384, 128, 128);
		levelUnlocked_8 = new TextureRegion(items, 512, 384, 128, 128);
		levelUnlocked_9 = new TextureRegion(items, 640, 384, 128, 128);
		
		/*Here you should put all textures that comes from itemsButtons.png*/
		musicOn = new TextureRegion(items, 0, 512, 128, 128);
		musicOff = new TextureRegion(items, 128, 512, 128, 128);
		accelOn = new TextureRegion(items, 256, 512, 128, 128);
		soundOn = new TextureRegion(items, 384, 512, 128, 128);
		soundOff = new TextureRegion(items, 512, 512, 128, 128);
		quit = new TextureRegion(items, 640, 512, 128, 128);
		
		settings = new TextureRegion(items, 0, 640, 128, 128);
		pause = new TextureRegion(items, 128, 640, 128, 128);
		back = new TextureRegion(items, 256, 640, 128, 128);
		help = new TextureRegion(items, 384, 640, 128, 128);
		arrowRight = new TextureRegion(items, 512, 640, 128, 128);
		arrowLeft = new TextureRegion(items, 640, 640, 128, 128);
		
		touchOn = new TextureRegion(items, 0, 768, 128, 128);
		soundGameOff = new TextureRegion(items, 128, 769, 128, 128);
		soundGameOn = new TextureRegion(items, 256, 769, 128, 128);
		pauseGame = new TextureRegion(items, 384, 769, 128, 128);
		
		/*Here load Transparent Textures*/
		Texture defaultNotificationR = loadTransparentTexture(320, 480, "backgrounds/default_notification.png");
		defaultNotification = new TextureRegion(defaultNotificationR, 0, 0, 320, 480);

		Texture readyR = loadTransparentTexture(320, 480, "backgrounds/ready.png");
		ready = new TextureRegion(readyR, 0, 0, 320, 480);
		
		Texture winR = loadTransparentTexture(800, 1280, "backgrounds/win.png");
		win = new TextureRegion(winR, 0, 0, 800, 1280);

		Texture gameOverR = loadTransparentTexture(800, 1280, "backgrounds/gameover.png");
		gameOver = new TextureRegion(gameOverR, 0, 0, 800, 1280);

		Texture pauseMenuR = loadTransparentTexture(800, 1280, "backgrounds/pausemenu.png");
		pauseMenu = new TextureRegion(pauseMenuR, 0, 0, 800, 1280);		
		
		
		/* TextureRegionSets */
		brickTypeI = new TextureRegionSet(smallOrangeBrick);
		brickTypeII = new TextureRegionSet(smallOrangeBrick, smallYellowBrick);
		brickTypeIII = new TextureRegionSet(smallOrangeBrick, smallYellowBrick, smallGreenBrick, smallPurpleBrick);

		// Animation example
		// brakingPlatform = new Animation(0.2f, new TextureRegion(items, 64,
		// 160, 64, 16), new TextureRegion(items, 64, 176, 64, 16),
		// new TextureRegion(items, 64, 192, 64, 16), new TextureRegion(items,
		// 64, 208, 64, 16));

		/* BitmapFont*/
		 FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
		 Gdx.files.internal("fonts/font.ttf"));
		 FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		 parameter.size = 40;
		 font = generator.generateFont(parameter); 
		 font.setColor(new Color(Color.PURPLE));
		 generator.dispose();

		music = Gdx.audio.newMusic(Gdx.files.internal("music/music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);

		if (Settings.musicEnabled){
			music.play();
		}else{
			music.pause();
		}

		
		touchPaddleSound = Gdx.audio.newSound(Gdx.files.internal("sound/touchPaddle.wav"));
		touchWallSound = Gdx.audio.newSound(Gdx.files.internal("sound/touchWall.ogg"));
		touchBrickSound = Gdx.audio.newSound(Gdx.files.internal("sound/touchBrick.ogg"));
		touchHardBrickSound = Gdx.audio.newSound(Gdx.files.internal("sound/touchHardBrick.wav"));
		lifeLostSound = Gdx.audio.newSound(Gdx.files.internal("sound/lifeLost.ogg"));
		gameOverSound = Gdx.audio.newSound(Gdx.files.internal("sound/gameOverSound.ogg"));
		winnerSound = Gdx.audio.newSound(Gdx.files.internal("sound/winnerSound.wav"));
		lifeBonusSound = Gdx.audio.newSound(Gdx.files.internal("sound/getLifeBonus.ogg"));
		coinBonusSound = Gdx.audio.newSound(Gdx.files.internal("sound/coin.wav"));
		//badBonusSound = Gdx.audio.newSound(Gdx.files.internal("sound/coin.wav"));
		clickSound = Gdx.audio.newSound(Gdx.files.internal("sound/click.wav"));
		toggleSound = Gdx.audio.newSound(Gdx.files.internal("sound/toggle.ogg"));
	}

	/**
	 * Play sound
	 * @param sound
	 */
	public static void playSound(Sound sound) {
		if (Settings.soundEnabled)
			sound.play(1);
	}
	
}
