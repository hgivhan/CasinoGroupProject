package io.zipcoder.casino.craps;
import io.zipcoder.casino.core.DiceGame;
//import io.zipcoder.casino.interfaces.GamblingGame;

import java.util.ArrayList;

public class Craps extends DiceGame /*implements GamblingGame*/{

    DiceGame diceGame;
    private Integer numOfDie = 2;
    private Integer dieVal;
    private Integer dieVal2;
    ArrayList<Integer> dieRolls;
    private Integer wagerAmt;

    public Integer crapsRoll() {


    }


    //While(true) {
    public Integer wager() {
        //switch for pass and dontpass
        //current balance
        //prompt player for wager amount and store it within
    }

    public void rollDice() {
        //roll dice and log value in dieVal
    }

    public void comeOutWin() {
        //if for 7 or 11
        //{passbet wins, dontpassbet loses}
    }
    public void comeOutLose() {
        //if - for 2, 3, or 12
        //{dontpassbet wins, passbet loses}
        //else - store point value = dieVal
        //
    }
    //While(true) {
    public void rollDice2() {
        //roll die and logs into dieVal2
        //will have methods rollAfterWin and rollAfterLose in here
    }
    public void rollAfterWin() {
        //if dieVal is == to dieVal2
        // {send winnings to player, break loop}
    }
    public void rollAfterLose() {
        //if dieVal2 == 7
        //{take money from player, break loop}
    }
    // }

    public void playAgain() {
        //ask to play again, if "n" is entered then the game will quit and go back to game selection screen, if
        //person presses enter or enters anything other than "n" the game will replay.
    }
    //}
}
