package trial;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

public class HighScores extends BasicGameState {

	private TrueTypeFont font = new TrueTypeFont(new Font("Serif", Font.PLAIN, 14), true);
	
	private String fileName = "res/highScores.txt"; 
	
	BufferedReader reader = null;
	
	static ArrayList<Integer> scores = new ArrayList <Integer>();
		
	Rectangle back, backButton;
	
	Circle circle, gold, silver, bronze;
	
	String title = "Top 10 Scores";
	
	String[] topTen;
	
	int i, j, minIndex, tmp, mouseX, mouseY;
	
	boolean check = false;
    
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		scores = new ArrayList <Integer>();
		
		gold = new Circle(25, 83, 10);
		silver = new Circle(25, 133, 10);
		bronze = new Circle(25, 183, 10);
		
		
		back = new Rectangle(0,0,404,604);
		
		backButton = new Rectangle(202-(font.getWidth("Back")/2), 550, font.getWidth("Back")+10, font.getHeight("Back"));
		
		//get the data from the file into the ArrayList of scores
		
		try {
		    reader = new BufferedReader(new FileReader(fileName));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		        scores.add(Integer.parseInt(text));
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		check = true;
		System.out.println("unsorted: "+scores);
		
		
		//sort the data in the ArrayList using selection sort
		int n = scores.size();
	    for (i = 0; i < n - 1; i++) {
	          minIndex = i;
	          for (j = i + 1; j < n; j++)
	                if (scores.get(j) > scores.get(minIndex)) //switched inequality to sort from high to low
	                      minIndex = j;
	          if (minIndex != i) {
	                tmp = scores.get(i);
	                scores.set(i, scores.get(minIndex));
	                scores.set(minIndex, tmp);
	          }
	    }
		
	    System.out.println("sorted: "+scores);
		
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
		g.fill(back);
		
		g.setColor(Color.black);
		g.drawString(title, 145, 25);
		
		g.setColor(Color.yellow);
		g.fill(gold);
		g.setColor(Color.gray);
		g.fill(silver);
		g.setColor(Color.orange);
		g.fill(bronze);
		
		g.setColor(Color.black);
		g.drawString("1: " + scores.get(0), 50 , 75);
		g.drawString("2: " + scores.get(1), 50 , 125);
		g.drawString("3: " + scores.get(2), 50 , 175);
		g.drawString("4: " + scores.get(3), 50 , 225);
		g.drawString("5: " + scores.get(4), 50 , 275);
		g.drawString("6: " + scores.get(5), 50 , 325);
		g.drawString("7: " + scores.get(6), 50 , 375);
		g.drawString("8: " + scores.get(7), 50 , 425);
		g.drawString("9: " + scores.get(8), 50 , 475);
		g.drawString("10: " + scores.get(9), 50 , 525);
		
		g.setColor(Color.black);
		g.fill(backButton);
		
		g.setColor(Color.white);
		g.drawString("Back", 202-(font.getWidth("Back")/2), 550);
	}	

	public int getID() {
		return 4;
	}

}
