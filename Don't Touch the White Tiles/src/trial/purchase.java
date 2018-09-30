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


public class purchase extends BasicGameState {
	
	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);
	
	static String currentColor = "black";
	
	String points = "Points :" + Pref.getScore();
	
	private String message = "Click a color to purhase it for your tile.", purchaseMessage = " ", red = "100", green = "200", blue = "300", pink = "400", yellow = "500", orange = "1000";
	
	private int mouseX, mouseY,timePassed;
	
	private Rectangle purchaseRed, purchaseGreen, purchaseBlue, purchasePink, purchaseYellow, purchaseOrange, setBlack, blackBorder, whiteBack = new Rectangle(0,0,403,603), back, resetColorsButton, resetScoreButton;
	
	private Circle circle;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		circle = new Circle(mouseX, mouseY, 100);
		
		whiteBack = new Rectangle(0,0,403,603);
		
		back = new Rectangle(202-(font.getWidth("Back")/2), 550, font.getWidth("Back")+10, font.getHeight("Back"));
		
		purchaseRed = new Rectangle(10,10,50,50);
		purchaseGreen = new Rectangle(10,70,50,50);
		purchaseBlue = new Rectangle(10,130,50,50);
		purchasePink = new Rectangle(10,190,50,50);
		purchaseYellow = new Rectangle(10,250,50,50);
		purchaseOrange = new Rectangle(10,310,50,50);
		setBlack = new Rectangle(10, 370, 50, 40);
		blackBorder = new Rectangle(9,369, 52, 52);
		resetColorsButton = new Rectangle(250, 10, 145, font.getHeight("Reset All Colors"));		
		resetScoreButton = new Rectangle(250, 40, 145, font.getHeight("Reset Your Score"));
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if (Pref.pref.getBoolean("red", true)) {
			red = "-Owned";
		} else {
			red = "100";
		}
		if (Pref.pref.getBoolean("green", true)) {
			green = "-Owned";
		} else {
			green = "200";
		}
		if (Pref.pref.getBoolean("blue", true)) {
			blue = "-Owned";
		} else {
			blue = "300";
		}
		if (Pref.pref.getBoolean("pink", true)) {
			pink = "-Owned";
		} else {
			pink = "400";
		}
		if (Pref.pref.getBoolean("yellow", true)) {
			yellow = "-Owned";
		} else {
			yellow = "500";
		}
		if (Pref.pref.getBoolean("orange", true)) {
			orange = "-Owned";
		} else {
			orange = "1000";
		}
			
			
		
		timePassed += delta;
		
		mouseX = Mouse.getX();
		
		mouseY= Mouse.getY();
		
		points = "Points: " + Integer.toString((Pref.getScore()));
		
		circle = new Circle(mouseX, 604-mouseY, 2);
		
		//System.out.println(Pref.pref.getBoolean("red", false));
		
		if((circle.intersects(back)) && (Mouse.isButtonDown(0))) {
		
			sbg.getState( 0 ).init(gc, sbg);

			sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			
		}
		
		if((circle.intersects(purchaseRed)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
		
			if((Pref.pref.getBoolean("red", false))) { //if the red value is true, it is already purchased
				
				currentColor = "red";
								
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchaseRed(); //gets message ready, and also tries to purchase it if they have enough points
			
		}
		
		if((circle.intersects(purchaseGreen)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			if(Pref.pref.getBoolean("green", false)) { //if the red value is true, it is already purchased
				
				currentColor = "green";
				
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchaseGreen(); //gets message ready, and also tries to purchase it if they have enough points
			
		}
		
		if((circle.intersects(purchaseBlue)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			if(Pref.pref.getBoolean("blue", false)) { //if the red value is true, it is already purchased
				
				currentColor = "blue";
				
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchaseBlue(); //gets message ready, and also tries to purchase it if they have enough points	
			
		}
		
		if((circle.intersects(purchasePink)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			if(Pref.pref.getBoolean("pink", false)) { //if the red value is true, it is already purchased
				
				currentColor = "pink";
				
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchasePink(); //gets message ready, and also tries to purchase it if they have enough points
			
		}
		
		if((circle.intersects(purchaseYellow)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			if(Pref.pref.getBoolean("yellow", false)) { //if the red value is true, it is already purchased
				
				currentColor = "yellow";
				
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchaseYellow(); //gets message ready, and also tries to purchase it if they have enough points		
			
		}
		
		if((circle.intersects(purchaseOrange)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			if(Pref.pref.getBoolean("orange", false)) { //if the red value is true, it is already purchased
				
				currentColor = "orange";
				
			}
			
			timePassed = 0;
			
			purchaseMessage = Pref.purchaseOrange(); //gets message ready, and also tries to purchase it if they have enough points		
			
		}
		
		if((circle.intersects(setBlack)) && (Mouse.isButtonDown(0)) && timePassed > 1000) { //can't make purchases 1 second away from each other, prevents accidental purchases
			
			currentColor = "black";
				
			timePassed = 0;
		
		}
		
		if ((circle.intersects(resetColorsButton)) && (Mouse.isButtonDown(0))){
			
			Pref.resetColors();
			
		}
		
		if ((circle.intersects(resetScoreButton)) && (Mouse.isButtonDown(0))){
			
			Pref.resetPoints();
			
		}
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		g.setColor(Color.black);
		g.fill(whiteBack);
		
		g.setColor(Color.red);
		g.fill(purchaseRed);
		g.drawString(""+red, 70, 35);
		
		g.setColor(Color.green);
		g.fill(purchaseGreen);
		g.drawString(""+green, 70, 105);
		
		g.setColor(Color.blue);
		g.fill(purchaseBlue);
		g.drawString(""+blue, 70, 165);
		
		g.setColor(Color.pink);
		g.fill(purchasePink);
		g.drawString(""+pink, 70, 225);
		
		g.setColor(Color.yellow);
		g.fill(purchaseYellow);
		g.drawString(""+yellow, 70, 285);
		
		g.setColor(Color.orange);
		g.fill(purchaseOrange);
		g.drawString(""+orange, 70, 345);
		
		g.setColor(Color.black);
		g.fill(setBlack);
		g.setColor(Color.white);
		g.draw(blackBorder);
		g.drawString("Black", 70, 405);
		
		g.setColor(Color.white);
		g.fill(back);
		g.drawString("Click an owned color to set tile color", 28, 425); /////////////////////////////////////////////////////////////////z
		g.fill(resetColorsButton);
		g.fill(resetScoreButton);
		
		
		g.drawString("Current Color: " + currentColor, 100, 450);
		g.drawString(purchaseMessage, 70, 475);
		g.drawString(message, 15, 500);
		g.drawString("Your " + points, 140 , 525);
		g.setColor(Color.black);
		g.drawString("Back", 202-(font.getWidth("Back")/2), 550);
		g.drawString("Reset All Colors", 250, 10);
		g.drawString("Reset Your Score", 250, 40);
	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
