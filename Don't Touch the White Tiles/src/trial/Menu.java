package trial;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.lwjgl.input.Mouse;
import java.awt.Font;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState{

	public Rectangle menuBack= null;
	
	public String play = "PLAY", about = "ABOUT", purchase = "STORE", highScores = "HIGH SCORES", instructions = "INSTRUCTIONS";
	
	public Rectangle playButton, aboutButton, purchaseButton, highScoresButton, instructionsButton; 
	
	public Circle circle;
	
	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);
	
	private int mouseX, mouseY;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		circle = new Circle(mouseX, mouseY, 2);
		menuBack = new Rectangle(0,0,403,603);
		playButton = new Rectangle( ((404-(font.getWidth(play)))/2) , 100 , font.getWidth(play)+5 , font.getHeight(play) );
		aboutButton = new Rectangle(((404-(font.getWidth(about)))/2) , 150 , font.getWidth(about)+5 , font.getHeight(about));
		purchaseButton = new Rectangle( (404-(font.getWidth(purchase))) / 2, 200, font.getWidth(purchase)+5, font.getHeight(purchase));
		highScoresButton = new Rectangle(155,250,font.getWidth("HIGH SCORES")+12, font.getHeight("HIGH SCORES"));
		instructionsButton = new Rectangle(149, 300, font.getWidth("Instructions")+43, font.getHeight("Instructions"));

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.setColor(Color.white);
		
		g.fill(menuBack);
		
		g.setColor(Color.black);
		
		g.fillRect(25,50,350,20);
		g.setColor(Color.white);
		g.drawString("Welcome To Don't Touch the White Tiles", 30, 50);
		g.setColor(Color.black);
		g.fill(playButton);
		g.setColor(Color.white);
		g.drawString(play,((404-(font.getWidth(play)))/2) , 100);
		g.setColor(Color.black);
		circle = new Circle(mouseX, 604-mouseY, 2);
		g.draw(circle);
		g.fill(aboutButton);
		g.setColor(Color.white);
		g.drawString(about, ((404-(font.getWidth(about)))/2) + 2 , 150);
		g.setColor(Color.black);
		g.fill(purchaseButton);
		g.setColor(Color.black);
		g.fill(highScoresButton);
		g.setColor(Color.white);
		g.drawString(purchase, ((404-(font.getWidth(play)))/2) - 4 , 200);
		g.drawString(highScores, 155, 250);
		g.setColor(Color.black);
		g.fill(instructionsButton);
		g.setColor(Color.white);
		g.drawString(instructions, 149, 300);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		mouseX = Mouse.getX(); 
		
		mouseY= Mouse.getY();
		
		if ((circle.intersects(playButton)) && (Mouse.isButtonDown(0))) {
			
			sbg.getState( 1 ).init(gc, sbg);
	        sbg.enterState( 1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
			
		}		
		
		if ((circle.intersects(purchaseButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 3 ).init(gc, sbg);
	        sbg.enterState( 3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
			
		}
		
		if ((circle.intersects(highScoresButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 4 ).init(gc, sbg);
	        sbg.enterState( 4, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
			
		}
		
		if ((circle.intersects(aboutButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 5 ).init(gc, sbg);
	        sbg.enterState( 5, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );			
		}
		
		if ((circle.intersects(instructionsButton)) && (Mouse.isButtonDown(0))){
			
			sbg.getState( 6 ).init(gc, sbg);
	        sbg.enterState( 6, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );			
		}
		
		
	}

	@Override
	public int getID() {
		
		return 0;
		
	}
	
	
	
}