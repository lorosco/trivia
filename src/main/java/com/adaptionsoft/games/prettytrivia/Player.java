package com.adaptionsoft.games.prettytrivia;

public class Player {

    private String name;
    private Integer prison_count;

    public Player(String name){
        this.name = name;
        this.prison_count = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPrison_count() {
        return prison_count;
    }

    public void setPrison_count(Integer prison_count) {
        this.prison_count = prison_count;
    }
}
