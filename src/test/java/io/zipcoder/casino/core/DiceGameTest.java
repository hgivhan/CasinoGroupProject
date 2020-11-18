package io.zipcoder.casino.core;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DiceGameTest {
    DiceGame diceTossCrap;
    DiceGame diceTossYahtzee;
    HashMap<Integer, Integer> diceMap;
    Integer diceNum1 = 2;
    Integer diceNum2 = 5;

    @Before
    public void setup(){
    diceTossCrap = new DiceGame(diceNum1);
    diceTossYahtzee = new DiceGame(diceNum2);
    diceMap = new HashMap<Integer, Integer>();
    }

    @Test
    public void tossAndSum() {
        Integer expectedMax = diceNum1;
        Integer expectedMin = diceNum1*6;
        //when
        Integer toss = diceTossCrap.tossAndSum();
        //then
        assertTrue(toss <= expectedMax);
        assertTrue(toss >= expectedMin);
    }

    @Test //making sure the values are 1 to 6
    public void tossAndList1(){
        Integer expectedMin = 1;
        Integer expectedMax = 6;

        diceMap = diceTossYahtzee.tossAndList();
        for(Integer x: diceMap.values()){
            assertTrue(x>=expectedMin && x<=expectedMax);
        }
    }

    @Test //making sure the keys are 1 to 5
    public void tossAndList2() {
        diceMap = diceTossYahtzee.tossAndList();
        for (int i = 1; i <= 5; i++) {
            assertTrue(diceMap.containsKey(i));
        }
        assertTrue(diceMap.size()==5);
    }

    @Test
    public void saveDice(){
        diceMap = diceTossYahtzee.tossAndList();

    }


}

