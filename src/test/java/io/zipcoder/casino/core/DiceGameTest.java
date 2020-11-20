package io.zipcoder.casino.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DiceGameTest {
    DiceGame diceToss;
    Integer diceNum = 2;

    @Before
    public void setup() {
        diceToss = new DiceGame(diceNum);
        //diceTossYahtzee = new DiceGame(diceNum2);
        //diceMap = new HashMap<Integer, Integer>();
    }


    @Test
    public void constructorTest() {
        Integer givenDiceNum = 6;
        DiceGame newGame = new DiceGame(givenDiceNum);

        Integer actualDiceNum = newGame.getDiceNum();

        Assert.assertEquals(givenDiceNum, actualDiceNum);
    }


    @Test
    public void tossAndListTest() {
    }

//    public ArrayList<Integer> tossAndList(Integer diceNum){
//        ArrayList<Integer> tossList = new ArrayList<Integer>();
//        for (int i = 1; i <= diceNum; i++) {
//            tossList.add(1+(int)(Math.random()*6));
//        }
//        return tossList;
//    }

    @Test
    public void setDiceNumTest() {
        DiceGame newGame = new DiceGame();
        Integer expectedDiceNum = 3;

        newGame.setDiceNum(expectedDiceNum);

        Integer actualDiceNum = newGame.getDiceNum();

        Assert.assertEquals(expectedDiceNum, actualDiceNum);
    }
}