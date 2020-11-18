package io.zipcoder.casino.utilities;

import io.zipcoder.casino.core.Player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    Console console;

    public Menu(Console console) {
        this.console = console;
    }

    public void mainMenuLoop() {
        welcomeMessage();
        createPlayer();
    }

    public void welcomeMessage() {
        //System.out.println("Welcome to C2's casino");
        console.println("Welcome to C2's Casino");
    }

    public void createPlayer() {
        Integer testInput = console.getIntegerInput("Are you gambling today? (1)yes (2)no");
        //console.println(String.valueOf(testInput));
        switch (testInput) {
            case 1:
                double startingWallet = console.getDoubleInput("How much would you like to gamble?");
                String newPlayerName = console.getStringInput("What is your name?");
                Player newPlayer = new Player(startingWallet, newPlayerName);
                /**
                 * if they want to gamble create gambling player
                 */
                //createGamblingPlayer();
                break;
            case 2:
                //createNonGamblingPlayer();
                break;
            default:
                console.println("not a valid input");
        }
    }


}
