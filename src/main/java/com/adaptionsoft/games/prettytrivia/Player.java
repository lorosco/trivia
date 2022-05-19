package com.adaptionsoft.games.prettytrivia;

import java.io.Console;

public class Player {

    private String name;
    private Integer prisonCount, coins;

	private boolean isJailed;

	public Player(String name) {
    	this.name = name;
        this.prisonCount = 0;
		this.coins = 0;
		this.isJailed = false;
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

	public void setPrisonCount(Integer prisonCount) {
		this.prisonCount = prisonCount;
	}
	
	public void resetPrisonCount() {
		setPrisonCount(0);
	}
	
	public void incrementPrisonCount(int incr) {
		this.prisonCount += incr;
	}
	
	public void incrementPrisonCount() {
		incrementPrisonCount(1);
	}

	public double chanceOfGettingOutOfPrison() throws IllegalArgumentException {
		if(prisonCount < 1) {
			throw new IllegalArgumentException();
		}
    	return (double) 1/this.prisonCount;
    }


	public boolean isJailed() {
		return isJailed;
	}

	public void setJailed(boolean jailed) {
		isJailed = jailed;
	}

	public Integer getCoins() {
		return coins;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}
}
