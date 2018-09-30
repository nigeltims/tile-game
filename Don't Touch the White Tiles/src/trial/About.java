package trial;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class About extends BasicGameState {

	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);
	
	Rectangle background = new Rectangle (0,0,404,604), backButton = new Rectangle(202-(font.getWidth("Back")/2), 550, font.getWidth("Back")+10, font.getHeight("Back"));
	
	Circle circle;
	
	int mouseX, mouseY;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
				System.out.println("hi");
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		mouseX = Mouse.getX();
		
		mouseY= Mouse.getY();
		
		circle = new Circle(mouseX, 604-mouseY, 2);
		
		if ((circle.intersects(backButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 0 ).init(gc, sbg);

	        sbg.enterState( 0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) ); //go to the menu if they click it
	        
		}
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.setColor(Color.white);
		g.fill(background);
		
		g.setColor(Color.black);
		g.fill(backButton);
		g.drawString("Developed by Nigel Tims", 100, 302);
		g.drawString("tims.nigel@gmail.com", 115, 350);
		
		g.setColor(Color.white);
		g.drawString("Back", 202-(font.getWidth("Back")/2), 550);
		
	}

	public int getID() {
		return 5;
	}

}
