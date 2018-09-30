package trial;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Play extends BasicGameState

{
	public static int a = 0, b = 3, score;

	private static String currentColor = purchase.currentColor;

	protected static Random rand;  //a is lower(inlcusive), b is higher( exclusive)

	Rectangle whiteBack;

	public Line v1, v2 ,v3 ,v4 ,v5, h1, h2, h3, h4, h5;

	public int tileWidth = 100, tileHeight = 150, tileX, tileY;

	public float y = 100;
	
	public float speed = 1;

	private ArrayList<Rectangle> tiles;

	private float multiplier;

	private int[] index = new int[]{1,102,203,304}; //x values for new tiles
	
	private int timePassed,timePassedNew;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		currentColor = purchase.currentColor;

		timePassed = 0;
		timePassedNew = 0;
		score = 0;
		rand = new Random();

		tiles = new ArrayList<Rectangle>();

		v1 = new Line(0, 0, 0, 604);
		v2 = new Line(101, 0, 101, 604);
		v3 = new Line(202, 0, 202, 604);
		v4 = new Line(303, 0, 303, 604);
		v5 = new Line(404, 0, 404, 604);
		h1 = new Line(0, 0, 404, 0);
		h2 = new Line(0, 151, 404, 151);
		h3 = new Line(0, 302, 404, 302);
		h4 = new Line(0, 453, 404, 453);
		h5 = new Line(0, 604, 404, 604);

		whiteBack = new Rectangle(0,0,403,603);

		tiles.add(new Rectangle((index[rand.nextInt(4)]),-150,100,150));

	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{

		timePassed += delta;
		timePassedNew += delta;

		multiplier = (float) ((timePassedNew * 0.0001) + 1);

		System.out.println(multiplier);

		if (tiles.get(tiles.size()-1).getY()>0) {

			System.out.println("hi");

			tiles.add(new Rectangle((index[rand.nextInt(4)]),-150,100,150));

		}

		for(int i = 0; i < tiles.size() ; i++) {

			tiles.get(i).setY(tiles.get(i).getY() + (multiplier+1));

		}

		if ((gc.getInput().isKeyDown(Input.KEY_A)) && ((!(tiles.get(0).intersects(h4))) || (tiles.get(0).getX() != 1)) && (timePassed > 250) ){

			sbg.getState( 2 ).init(gc, sbg);
			sbg.enterState( 2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );			
		}

		if ((tiles.get(0).intersects(h4)) && (tiles.get(0).getX() == 1) && (gc.getInput().isKeyDown(Input.KEY_A))) {

			tiles.remove(0);
			score ++;
			timePassed = 0;
		}

		if ((gc.getInput().isKeyDown(Input.KEY_S)) && ((!(tiles.get(0).intersects(h4))) || (tiles.get(0).getX() != 102)) && (timePassed > 250) ){

			sbg.getState( 2 ).init(gc, sbg);
			sbg.enterState( 2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );			
		}

		if ((tiles.get(0).intersects(h4)) && (tiles.get(0).getX() == 102) && (gc.getInput().isKeyDown(Input.KEY_S))) {

			tiles.remove(0);
			score ++;
			timePassed = 0;
		}

		if ((gc.getInput().isKeyDown(Input.KEY_D)) && ((!(tiles.get(0).intersects(h4))) || (tiles.get(0).getX() != 203)) && (timePassed > 250) ){

			sbg.getState( 2 ).init(gc, sbg);
			sbg.enterState( 2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );

		}

		if ((tiles.get(0).intersects(h4)) && (tiles.get(0).getX() == 203) && (gc.getInput().isKeyDown(Input.KEY_D))) {

			tiles.remove(0);
			score ++;
			timePassed = 0;
		}

		if ((gc.getInput().isKeyDown(Input.KEY_F)) && ((!(tiles.get(0).intersects(h4))) || (tiles.get(0).getX() != 304)) && (timePassed > 250) ){

			sbg.getState( 2 ).init(gc, sbg);
			sbg.enterState( 2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );
		}

		if ((tiles.get(0).intersects(h4)) && (tiles.get(0).getX() == 304) && (gc.getInput().isKeyDown(Input.KEY_F))) {

			tiles.remove(0);
			score ++;
			timePassed=0;
		}

		if (tiles.get(0).getY()>453) {

			sbg.getState( 2 ).init(gc, sbg);
			sbg.enterState( 2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black) );

		}

	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{

		g.setColor(Color.white);

		g.fill(whiteBack);

		g.setColor(Color.black);

		g.draw(v1);
		g.draw(v2);
		g.draw(v3);
		g.draw(v4);
		g.draw(v5);
		g.draw(h1);
		g.draw(h2);
		g.draw(h3);

		g.setColor(Color.red);
		g.draw(h4);

		g.setColor(Color.black);
		g.draw(h5);

		g.setColor(Color.red);
		g.drawString("Score:" + score, 10, 10);

		if(currentColor.equals("red")) {

			g.setColor(Color.red);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}else if(currentColor.equals("green")) {

			g.setColor(Color.green);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		} else if(currentColor.equals("blue")) {

			g.setColor(Color.blue);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}else if(currentColor.equals("pink")) {

			g.setColor(Color.pink);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}else if(currentColor.equals("yellow")) {

			g.setColor(Color.yellow);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}else if(currentColor.equals("orange")) {

			g.setColor(Color.orange);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}else {

			g.setColor(Color.black);
			for(int i = 0; i < tiles.size() ; i++) {

				g.fill(tiles.get(i));

			}

		}

	}


	public int getID() {
		return 1;
	}
}