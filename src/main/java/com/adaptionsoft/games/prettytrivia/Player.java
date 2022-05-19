package com.adaptionsoft.games.prettytrivia;

public class Player {

    private String name;
    private Integer prison_count;
    
    public Player(String name) {
    	this.name = name;
        this.prison_count = 0;
    }
    
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public Integer getPrisonCount() {
		return prison_count;
	}

	public void setPrisonCount(Integer prison_count) {
		this.prison_count = prison_count;
	}

	public double chanceOfGettingOutOfPrison() {
    	return 1/this.prison_count;
    }
}
