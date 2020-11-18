package io.zipcoder.casino.craps;

import io.zipcoder.casino.utilities.Console;

public class Bets {
    Console console;


    public Integer passBetDie() {
        return null;
    }

    public Integer dontPassBetDie() {
        return null;
    }

    public Integer wager() {
        Integer wagerAmt = 0;
        console.getIntegerInput("How much would you like to bet?", wagerAmt);
        return wagerAmt;
    }




}
