package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    List<CategoryType> inGameCategories = new ArrayList<>();
    CategoryType currentTurnCategories = null;
    

	LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("He is the player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll, List<CategoryType> categories) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				System.out.println(players.get(currentPlayer) 
						+ "'s new location is " 
						+ places[currentPlayer]);
				selectNewCurrentCategory();

				System.out.println("The category is " + this.currentTurnCategories);
				askQuestion();
			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			System.out.println(players.get(currentPlayer) 
					+ "'s new location is " 
					+ places[currentPlayer]);
			selectNewCurrentCategory();
			System.out.println("The category is " + this.currentTurnCategories);
			askQuestion();
		}
		
	}

	private void askQuestion() {

		if (this.currentTurnCategories == CategoryType.POP)
			System.out.println(popQuestions.removeFirst());
		if (this.currentTurnCategories == CategoryType.POP)
			System.out.println(scienceQuestions.removeFirst());
		if (this.currentTurnCategories == CategoryType.POP)
			System.out.println(sportsQuestions.removeFirst());
		if (this.currentTurnCategories == CategoryType.POP)
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private void selectNewCurrentCategory() {
		Random rand = new Random();
		this.currentTurnCategories = this.inGameCategories.get(rand.nextInt(this.inGameCategories.size()));
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {

			System.out.println("Answer was correct!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
	
    public ArrayList getPlayers() {
		return players;
	}

	public List<CategoryType> getInGameCategories() {
		return inGameCategories;
	}
	
	public void selectCategories(List<Category> categories) {
		Scanner in = new Scanner(System.in);
		for(String player : this.players) {
			System.out.println("Player \"" + player + "\", please pick a category below :");
			for(int i = 0 ; i<categories.size() ; i ++) {
				System.out.println(i + 1 + ": " + categories.get(i).getCategoryType());
			}
			System.out.println("Your choice ? ");
			String choice = in.nextLine();
			System.out.println("0: No choice \n");
			if(Integer.parseInt(choice) > 0) {
				this.inGameCategories.add(categories.get(Integer.parseInt(choice) - 1).getCategoryType());
			}
		}
		
		
		
		
	}


}
