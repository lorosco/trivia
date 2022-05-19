
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.prettytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		Player chet = new Player("Chet");
		Player pat = new Player("Pat");
		Player sue = new Player("Sue");

		aGame.add(chet);
		aGame.add(pat);
		aGame.add(sue);
		
		Random rand = new Random();
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}
}
