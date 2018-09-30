package trial;

import java.awt.Font;

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

public class Instructions extends BasicGameState{

	Circle circle;

	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);
	
	Rectangle background = new Rectangle(0,0,404,604), backButton = new Rectangle(202-(font.getWidth("Back")/2), 550, font.getWidth("Back")+10, font.getHeight("Back"));;
	
	int mouseX, mouseY;
	
	String one = "1. Dont let the black tiles touch the ", oneA = "bottom!", twoA = "2. Hit 'A', 'S', 'D', or 'F' on your ", twoB = "keyboard while the black tiles are touching ", twoC = "the red line to stay alive!";
	
	String threeA = "3. Accumulate points and buy new tile ", threeB = "colors in the Store!";
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		System.out.println("");
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		
		
		mouseX = Mouse.getX();
		
		mouseY= Mouse.getY();
		
		circle = new Circle(mouseX, 604-mouseY, 2);
		
		if ((circle.intersects(backButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 0 ).init(gc, sbg);

	        sbg.enterState( 0 , new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); //go to the menu if they click it
	        
		}
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setColor(Color.white);
		g.fill(background);
		
		g.setColor(Color.black);
		g.fill(backButton);
		g.drawString(one, 10, 150);
		g.drawString(oneA, 10, 180);
		g.drawString(twoA, 10, 210);
		g.drawString(twoB, 10, 240);
		g.drawString(twoC, 10, 270);
		g.drawString(threeA, 10, 300);
		g.drawString(threeB, 10, 330);
		
		g.setColor(Color.white);
		g.drawString("Back", 202-(font.getWidth("Back")/2), 550);
		
	}

	public int getID() {
		return 6;
	}
	
	

}
