package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    ArrayList players = new ArrayList();
	ArrayList<Integer> luckToEscape = new ArrayList<>();
	int luckIncrease = 10;
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
	public LinkedList TechnoQuestions = new LinkedList();
	LinkedList RockQuestions = new LinkedList();
	boolean isRockReplaced = false;
	String resultReplaceRockQuestion;
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
		replaceRockQuestionByTechnoQuestion();
		if (resultReplaceRockQuestion.equals("y")) 
		{
			isRockReplaced = true;
		}
		else{
			isRockReplaced = false;
		}

    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));

			if (isRockReplaced) {
				TechnoQuestions.addLast(createTechnoQuestion(i));
			}
			else{
				RockQuestions.addLast(createRockQuestion(i));
			}
    	}

    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public void replaceRockQuestionByTechnoQuestion(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Remplacer la categorie Rock par Techno ? (y/n) :");
		String str = sc.nextLine();
		resultReplaceRockQuestion = str;
	}

	public String createTechnoQuestion(int index){
		return "Techno Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
		luckToEscape.add(0);
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

	public void roll(int roll) {
		if(!isPlayable()){
			System.out.println("There isn't enough player to start the game");
			System.exit(0);
		}
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]){
			if(doPlayerEscape(roll)) {
				isGettingOutOfPenaltyBox = true;
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				System.out.println(players.get(currentPlayer) 
						+ "'s new location is " 
						+ places[currentPlayer]);
				System.out.println("The category is " + currentCategory());
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
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	public boolean doPlayerEscape(int roll) {
		int luck = luckToEscape.get(currentPlayer);
		if(Math.random()*100 > luck && roll % 2 == 0){
			luckToEscape.set(currentPlayer,luck+luckIncrease);
			return false;
		}else{
			luckToEscape.set(currentPlayer,0);
			return true;
		}
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(RockQuestions.removeFirst());		
		if (currentCategory() == "Techno")
			System.out.println(TechnoQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if(resultReplaceRockQuestion.equals("y")) return "Techno";

		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				inPenaltyBox[currentPlayer] = false;
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

	public boolean isPlayerInPrison(int index){
		return inPenaltyBox[index];
	}

	public boolean[] getPenaltyBox(){
		return inPenaltyBox;
	}

	public void setLuckIncrease(int luck){
		luckIncrease = luck;
	}
}
