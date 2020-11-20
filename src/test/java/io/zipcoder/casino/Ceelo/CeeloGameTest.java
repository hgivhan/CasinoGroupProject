package io.zipcoder.casino.Ceelo;

import io.zipcoder.casino.ceelo.CeeloGame;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CeeloGameTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorTest(){
        Integer givenDiceNum = 4;
        CeeloGame ceeloGame = new CeeloGame(givenDiceNum);
        Integer actualDiceNum = ceeloGame.getDiceNum();
        Assert.assertEquals(givenDiceNum,actualDiceNum);
    }

    @Test
    public void checkAutoWinTrue() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList <Integer> expectedDiceTossed = new ArrayList<Integer>();
        expectedDiceTossed.add(4);
        expectedDiceTossed.add(5);
        expectedDiceTossed.add(6);

        boolean outcome = newCeelo.checkAutoWin(expectedDiceTossed);

        Assert.assertTrue(outcome);
    }

    @Test
    public void checkAutoWinFalse() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList <Integer> expectedDiceTossed = new ArrayList<Integer>();
        expectedDiceTossed.add(4);
        expectedDiceTossed.add(3);
        expectedDiceTossed.add(6);
        boolean outcome = newCeelo.checkAutoWin(expectedDiceTossed);

        Assert.assertFalse(outcome);
    }

    @Test
    public void checkAutoLoseTrue() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList <Integer> expectedDiceTossed = new ArrayList<Integer>();
        expectedDiceTossed.add(1);
        expectedDiceTossed.add(2);
        expectedDiceTossed.add(3);
        boolean outcome = newCeelo.checkAutoLose(expectedDiceTossed);

        Assert.assertTrue(outcome);
    }

    @Test
    public void checkAutoLoseFalse() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList <Integer> expectedDiceTossed = new ArrayList<Integer>();
        expectedDiceTossed.add(1);
        expectedDiceTossed.add(3);
        expectedDiceTossed.add(3);
        boolean outcome = newCeelo.checkAutoLose(expectedDiceTossed);

        Assert.assertFalse(outcome);
    }

    @Test
    public void checkTripleTrue() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList<Integer> tripleThreat = new ArrayList<Integer>();
        tripleThreat.add(1);
        tripleThreat.add(1);
        tripleThreat.add(1);

        Assert.assertTrue(newCeelo.checkTriple(tripleThreat));
    }

    @Test
    public void checkTripleFalse() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList<Integer> tripleThreat = new ArrayList<Integer>();
        tripleThreat.add(1);
        tripleThreat.add(2);
        tripleThreat.add(1);

        Assert.assertFalse(newCeelo.checkTriple(tripleThreat));
    }


    @Test
    public void checkPointTrue() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList<Integer> point = new ArrayList<Integer>();
        point.add(1);
        point.add(1);
        point.add(2);

        Assert.assertTrue(newCeelo.checkPoint(point));
    }

    @Test
    public void checkPointFalse() {
        CeeloGame newCeelo = new CeeloGame(3);
        ArrayList<Integer> point = new ArrayList<Integer>();
        point.add(1);
        point.add(5);
        point.add(2);

        Assert.assertFalse(newCeelo.checkPoint(point));
    }
}
//public boolean checkPoint(ArrayList<Integer> diceTossed){
//        //Integer test = Collections.frequency(diceTossed,diceTossed.get(0));
//        boolean notAllSame = Collections.frequency(diceTossed,diceTossed.get(0))!=diceTossed.size();
//        if((diceTossed.get(0) == diceTossed.get(1) || diceTossed.get(0) == diceTossed.get(2) || diceTossed.get(1) == diceTossed.get(2)) && notAllSame ){
//            return true;
//        }
//        else{
//            return false;
//        }
