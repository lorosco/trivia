package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.prettytrivia.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
