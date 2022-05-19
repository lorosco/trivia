
package com.adaptionsoft.games.trivia.runner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Category;
import com.adaptionsoft.games.uglytrivia.CategoryType;
import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {

		List<Category> categoryList = new ArrayList<>();

		System.out.println("New categories");
		for (CategoryType value : CategoryType.values()) {
			categoryList.add(new Category(value));
			System.out.println("Category " + value.getCategory());
		}

		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		aGame.selectCategories(categoryList);
		System.out.println("Categories selected :");

		for(CategoryType cat : aGame.getInGameCategories()) {
			System.out.println(cat);
		}
		
		
		Random rand = new Random();
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1,aGame.getInGameCategories());
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}
}
