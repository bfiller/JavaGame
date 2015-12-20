package GameEngine;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import States.*;

public class Engine extends StateBasedGame{

	public static boolean _APPLET = true;

	public Engine(){
		super("Remorseless");
	}
	
	public static void main(String [] args){
		
		_APPLET = false;
		
		File file = new File("slickJARS");
		if (file.exists()){ 
			System.setProperty("org.lwjgl.librarypath", file.getAbsolutePath());
		}
		
		try {
			AppGameContainer agc = new AppGameContainer(new Engine());
			agc.setDisplayMode(GameWindow.WINDOW_WIDTH, GameWindow.WINDOW_HEIGHT, false);
			agc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setMaximumLogicUpdateInterval(60);
		gc.setVSync(true);
		gc.setShowFPS(false);
		
		this.addState(new MenuState());
		this.addState(new GameState());
	}
}


