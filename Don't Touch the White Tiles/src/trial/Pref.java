package trial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.prefs.Preferences;

public class Pref {
	
	static String fileName = "res/highScores.txt";
	
	static Preferences pref = Preferences.userNodeForPackage(Pref.class);
	
	static int red = 100, green = 200, blue = 300, pink = 400, yellow = 500, orange = 1000;	
	
	StringBuilder scoreString = new StringBuilder();

	static public int purchaseScore;
	
	static boolean check;
	
	public Pref(){
		
	}
	
	public static void putScore(int score) {
		
		pref.putInt("score", score);
		
		purchaseScore = score;
		
	}
	
	public static int getScore() {
		
		return pref.getInt("score", 0);
		
	}
	
	public static String purchaseRed() {
		
		if((pref.getInt("score",0))>=(red) && !(pref.getBoolean("red", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 100);
			
			pref.putBoolean("red", true);
			
			return ("You have purchased 'red'.");
			
		}
		if(!(pref.getBoolean("red",false))) { //if red is already purchased, dont show "you cannot purchase red" only show this if they don't have enough points 
		return "You cannot purchase 'red'.";
		}
		return "";
		
	}

	public static String purchaseGreen() {
		
		if((pref.getInt("score",0))>=(green) && !(pref.getBoolean("green", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 200);
			
			pref.putBoolean("green", true);
			
			return ("You have purchased 'green'.");
			
		}
		if(!(pref.getBoolean("green",false))) { //if green is already purchased, dont show "you cannot purchase green" only show this if they don't have enough points 
		return "You cannot purchase 'green'.";
		}
		return "";
		
	}

	public static String purchaseBlue() {
		
		if((pref.getInt("score",0))>=(blue) && !(pref.getBoolean("blue", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 300);
			
			pref.putBoolean("blue", true);
			
			return ("You have purchased 'blue'.");
			
		}
		if(!(pref.getBoolean("blue",false))) { //if blue is already purchased, dont show "you cannot purchase blue" only show this if they don't have enough points 
		return "You cannot purchase 'blue'.";
		}
		return "";
		
	}

	public static String purchasePink() {
		
		if((pref.getInt("score",0))>=(pink) && !(pref.getBoolean("pink", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 400);
			
			pref.putBoolean("pink", true);
			
			return ("You have purchased 'pink'.");
			
		}
		if(!(pref.getBoolean("pink",false))) { //if pink is already purchased, dont show "you cannot purchase pink" only show this if they don't have enough points 
		return "You cannot purchase 'pink'.";
		}
		return "";
		
	}

	public static String purchaseYellow() {
		
		if((pref.getInt("score",0))>=(yellow) && !(pref.getBoolean("yellow", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 500);
			
			pref.putBoolean("yellow", true);
			
			return ("You have purchased 'yellow'.");
			
		}
		if(!(pref.getBoolean("yellow",false))) { //if yellow is already purchased, dont show "you cannot purchase yellow" only show this if they don't have enough points 
		return "You cannot purchase 'yellow'.";
		}
		return "";
		
	}

	public static String purchaseOrange() {
		
		if((pref.getInt("score",0))>=(orange) && !(pref.getBoolean("orange", false))) {
			
			pref.putInt("score", pref.getInt("score", 0) - 1000);
			
			pref.putBoolean("orange", true);
			
			return ("You have purchased 'orange'.");
			
		}
		if(!(pref.getBoolean("orange",false))) { //if orange is already purchased, dont show "you cannot purchase orange" only show this if they don't have enough points 
		return "You cannot purchase 'orange'.";
		}
		return "";
		
	}
	
	public static void resetColors() {
		
		pref.putBoolean("red", false);
		pref.putBoolean("green", false);
		pref.putBoolean("blue", false);
		pref.putBoolean("pink", false);
		pref.putBoolean("yellow", false);
		pref.putBoolean("orange", false);
		
	}
	
	public static void resetPoints() {
		
		pref.putInt("score", 0);
		
	}
	
	public static void storeScore(int score) throws IOException {
		
		java.io.PrintWriter pw = new PrintWriter(new FileWriter(fileName, true)); //initialies printwriter and makes it start a new line when it prints(appends it to the end)
				
		pw.print(score + "\r\n"); //prints the scores to highScores.txt
	
		pw.close();
		
		
		
	}
	
}
