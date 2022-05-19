package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.prettytrivia.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

public class SomeTest {

    @Test
    public void prison_count_and_coins_starts_at_0() throws Exception {
        Player player = new Player("michel");
        assertEquals(0,player.getPrisonCount());
        assertEquals(0,player.getCoins());
    }

    @Test
    public void isJailed_starts_at_false() throws Exception{
        Player player = new Player("Gontran");
        assertEquals(false,player.isJailed());
    }
    
    @Test
    public void chance_getting_out_of_prison_works() throws Exception{
    	Player player = new Player("Hubert");
    	
    	player.setPrisonCount(2);
    	double calc = player.chanceOfGettingOutOfPrison();
    	assertEquals(0.5,calc);
    	
    	player.setPrisonCount(4);
    	calc = player.chanceOfGettingOutOfPrison();
    	assertEquals(0.25,calc);
    	
    	//vérifier que l'exception soit bien lancée si prisonCount=0
    	player.resetPrisonCount();
    	Assertions.assertThrows(IllegalArgumentException.class, () -> player.chanceOfGettingOutOfPrison());
    }
}
