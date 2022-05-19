package com.adaptionsoft.games.prettytrivia;

public class Player {

    private String name;
    private Integer prisonCount, coins;

	public Integer getCoins() {
		return coins;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public Player(String name) {
    	this.name = name;
        this.prisonCount = 0;
		this.coins = 0;
    }
    
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public Integer getPrisonCount() {
		return prisonCount;
	}

	public void setPrisonCount(Integer prison_count) {
		this.prisonCount = prison_count;
	}

	public double chanceOfGettingOutOfPrison() {
    	return 1/this.prisonCount;
    }
}
