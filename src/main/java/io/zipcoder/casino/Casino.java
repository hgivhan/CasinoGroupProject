package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Menu;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.yahtzee.MenuYahtzee;
import io.zipcoder.casino.yahtzee.ScoreCardYahtzee;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {

        Console console = new Console(System.in, System.out);
        Menu menu = new Menu(console);
        menu.mainMenuLoop();
        // write your tests before you start
    }
}
