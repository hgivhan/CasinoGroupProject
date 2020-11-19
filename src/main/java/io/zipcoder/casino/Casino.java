package io.zipcoder.casino;

import io.zipcoder.casino.craps.Bets;
import io.zipcoder.casino.craps.Craps;
import io.zipcoder.casino.yahtzee.ScoreCardYahtzee;


import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Menu;

public class Casino {

    public static void main(String[] args) {

        Console console = new Console(System.in, System.out);
        Menu menu = new Menu(console);
        menu.mainMenuLoop();
        // write your tests before you start
    }
}