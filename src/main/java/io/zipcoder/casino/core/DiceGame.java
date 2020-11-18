package io.zipcoder.casino.core;

import java.util.HashMap;

public class DiceGame {
    private Integer diceNum;

    public DiceGame(){
    }

    public DiceGame(Integer diceNum){
        this.diceNum = diceNum;
    }

    public Integer tossAndSum() {
        Integer tossSum = 0;
        for (int i = 1; i <= diceNum; i++) {
            tossSum += 1+(int)(Math.random()*6);
        }
        return tossSum;
    }

    //toss and creates a hashmap of <diceNum> # of dices
    public HashMap<Integer, Integer> tossAndList(){
        return null;
    }
    public Integer getDiceNum(){
        return diceNum;
    }

    public void setDiceNum(Integer diceNum){
        this.diceNum = diceNum;
    }

    //returns a new hashmap of the saved dices based on user input (dicedToSave), should also reset the diceNum
    public HashMap<Integer, Integer> saveDice(Integer[] diceToSaved){
        Integer[] userInput = {1,3}; //user selects dice #1 and #3 (not the value) to remove

    return null;
    }





}
