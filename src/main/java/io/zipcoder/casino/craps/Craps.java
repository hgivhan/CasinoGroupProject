package io.zipcoder.casino.craps;
import io.zipcoder.casino.core.DiceGame;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;

public class Craps extends DiceGame {
    DiceGame diceGame;
    Console console;
    private Integer extraDieVal;
    ArrayList<Integer> dieRolls;
    ArrayList<Integer> dieArr;
    private Boolean firstRoll;
    private Boolean extraRoll;


    public void Craps(Integer dieVal) {
        this.extraDieVal = dieVal;
    }

    //Check player balance. Player must have at least 1 chip to buy in
    public void gameOn() {
        firstRoll = true;
        while(firstRoll) {
            extraRoll = true;
            getDie();
            rollBet();

            while(extraRoll) {
                getDie();
                extraRollBet();
            }
        }
        //Call menu
    }

    public void getDie() {
        dieRolls = diceGame.tossAndList(2);
        extraDieVal = dieRolls.get(0) + dieRolls.get(1);
        dieArr.add(extraDieVal);
    }

    public void rollBet() {
        if(dieArr.get(0) == 7 || dieArr.get(0) == 11) {
            //win = index of passbet in enum add passbet value to player
            //lose = index of dontpassbet in enum to subtract dontpassbet value from player
            firstRoll = playAgainBoo();
        } else if (dieArr.get(0) == 2 || dieArr.get(0) == 3 || dieArr.get(0) == 12) {
            //lose passbet
            //win dontpassbet
            firstRoll = playAgainBoo();
        }
    }

    public void extraRollBet() {
        if(dieArr.get(0) == dieArr.get(dieArr.size() - 1)) {
            //Win passbet
            //lose dontpassbet
            extraRoll = false;
            firstRoll = playAgainBoo();
        } else if (dieArr.get(dieArr.size() - 1) == 7) {
            //lose passbet
            //win dontpassbet
            extraRoll = false;
            firstRoll = playAgainBoo();
        }
    }

    public String playAgainStr() {
        String play = console.getStringInput("Would you like to play again?  (Y or N)");
        return play;
    }

    public Boolean playAgainBoo() {
        String playStr = playAgainStr().toUpperCase();
        return !playStr.equals("N");
    }

}
