package com.adaptionsoft.games.prettytrivia;

public class Player {

    private String name;
    private Integer prison_count;
    
    public Player(String name) {
    	this.name = name;
    }
    
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public Integer getTimeInPrison() {
		return prison_count;
	}

	public void setTimeInPrison(Integer timeInPrison) {
		this.prison_count = timeInPrison;
	}

	public double chanceOfGettingOutOfPrison() {
    	return 1/this.prison_count;
    }
}
