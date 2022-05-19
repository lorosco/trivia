package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeTest {

    @Test
    public void true_is_true(){
        assertTrue(true);
    }

    @Test
    public void do_escape_luck_increase_of_10_percent(){
        int numberOfEscapeSecondTurn = 0;
        int increase_percent = 60;
        int numberOfOccurence = 1000;
        for (int i = 0; i < numberOfOccurence; i++) {
            Game aGame = new Game();
            aGame.setLuckIncrease(10);

            aGame.add("Chet");
            aGame.add("Pat");

            Random rand = new Random();
            //Go to prison in first turn
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wrongAnswer();
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();

            //First turn in prison
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wrongAnswer();
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();

            //Second turn in prison
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();
            if(!aGame.isPlayerInPrison(0))
                numberOfEscapeSecondTurn++;
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();
        }
        double percent_increase = ((double)numberOfEscapeSecondTurn/(double)numberOfOccurence)*100;
        //Check with 2 percent error as random is fucked up
        assertTrue(increase_percent+3 >= Math.round(percent_increase) && increase_percent-3 <= Math.round(percent_increase));
    }
    @Test
    public void do_escape_luck_increase_of_15_percent(){
        int numberOfEscapeSecondTurn = 0;
        int increase_percent = 65;
        int numberOfOccurence = 1000;
        for (int i = 0; i < numberOfOccurence; i++) {
            Game aGame = new Game();
            aGame.setLuckIncrease(15);

            aGame.add("Chet");
            aGame.add("Pat");

            Random rand = new Random();
            //Go to prison in first turn
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wrongAnswer();
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();

            //First turn in prison
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wrongAnswer();
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();

            //Second turn in prison
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();
            if(!aGame.isPlayerInPrison(0))
                numberOfEscapeSecondTurn++;
            aGame.roll(rand.nextInt(5) + 1);
            aGame.wasCorrectlyAnswered();
        }
        double percent_increase = ((double)numberOfEscapeSecondTurn/(double)numberOfOccurence)*100;
        //Check with 2 percent error as random is fucked up
        assertTrue(increase_percent+3 >= Math.round(percent_increase) && increase_percent-3 <= Math.round(percent_increase));
    }

    @Test
    public void is_game_stop_if_too_few_player(){
        Game aGame = new Game();
        Random rand = new Random();
        aGame.add("Pat");
        aGame.roll(rand.nextInt(5) + 1);
    }

    @Test
    public void is_game_stop_if_too_many_player(){
        Game aGame = new Game();
        for (int i = 0; i <= 6; i++) {
            aGame.add("Pat"+i);
        }
    }

}
