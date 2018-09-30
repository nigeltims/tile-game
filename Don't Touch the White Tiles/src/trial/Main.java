package trial;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame
{

	public Main(String name) {
		super(name); //set name of the game
		
	}

	public void initStatesList(GameContainer gc) throws SlickException {
	 		
		addState(new Menu ());
		
		addState(new Play ());	
		
		addState(new GameOver ());
		
		addState(new purchase ());
		
		addState(new HighScores ());
		
		addState(new About ());
		
		addState(new Instructions ());
				
	}
	
	public static void main(String [] args) throws SlickException{
		
	AppGameContainer app = new AppGameContainer(new Main("Don't Touch the White Tiles"), 404, 604, false); //4*4 grid of 100*150 rectangles + grid
		
	app.setVSync(true);
	
	app.setShowFPS(false);
	
	app.start();
	
	}
	
}
