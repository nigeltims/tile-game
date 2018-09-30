package trial;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.Font;
import java.io.IOException;



public class GameOver extends BasicGameState {
	
	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);

	private Circle circle;
	
	private int mouseX, mouseY, tempScore;
	
	Rectangle whiteBack, playAgain = new Rectangle( 202 - ((font.getWidth("Play Again")) / 2)-15, (302-(font.getHeight("Play Again") / 2) - 20), font.getWidth("Play Again") + 33, font.getHeight("Play Again")), menu;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		whiteBack = new Rectangle(0, 0, 404, 604);
				
		circle = new Circle(mouseX, mouseY, 2);
		tempScore = Pref.getScore() + Play.score;
		Pref.putScore(tempScore);
		
		menu = new Rectangle(202-(font.getWidth("Back")/2)-8, 550, font.getWidth("Back")+11, font.getHeight("Back"));
		
		System.out.println("hello your score is " +Pref.getScore());
		
		try {
			Pref.storeScore(Play.score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		mouseX = Mouse.getX();
		
		mouseY= Mouse.getY();
		
		circle = new Circle(mouseX, 604-mouseY, 2);
		
	if ((circle.intersects(playAgain)) && (Mouse.isButtonDown(0))) {
			
		sbg.getState( 1 ).init(gc, sbg);
        sbg.enterState( 1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
			
		}
	
	if ((circle.intersects(menu)) && (Mouse.isButtonDown(0))) {
		
		sbg.getState( 0 ).init(gc, sbg);
        sbg.enterState( 0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
		
		System.out.println("hello");
		
	}
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		g.setColor(Color.white);
		g.fill(whiteBack);
		
		g.setColor(Color.black); 
		g.drawString("Game Over", 202-(font.getWidth("Game Over") / 2)-7, 102-(font.getHeight("Game Over") / 2));
		
		g.fill(playAgain);
		
		g.setColor(Color.white);
		g.drawString("Play Again", 202-((font.getWidth("Play Again")) / 2)-15, (302-(font.getHeight("Play Again") / 2) - 20));

		g.setColor(Color.black);
		g.drawString("Your Score is " + Play.score,135, 400);
		g.fill(menu);
		g.setColor(Color.white);
		g.drawString("Menu", 202-(font.getWidth("Back")/2)-7, 550);


	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
