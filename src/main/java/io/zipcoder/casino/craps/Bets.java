package io.zipcoder.casino.craps;

import io.zipcoder.casino.core.GamblingGame;
import io.zipcoder.casino.utilities.Console;

public class Bets implements GamblingGame {
    Console console;
    Craps craps;
    GamblingGame gamblingGame;
    CrapsEngine crapsEngine;
    private Integer betAmt;



    public Integer passBet() {
        if(craps.dieVal == 7 || dieVal == 11) {


        }
        return null;
    }

    public Integer dontPassBetDie() {
        return null;
    }


    public void setBetAmt(Integer betAmt) {
        this.betAmt = betAmt;
    }


    public double getPlayerBet(double playerBet) {
        return ;
    }

    public Integer getBetAmt() {
        return betAmt;
    }
}
