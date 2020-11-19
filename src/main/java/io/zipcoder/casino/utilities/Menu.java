package io.zipcoder.casino.utilities;

import io.zipcoder.casino.cardstuff.Blackjack;
import io.zipcoder.casino.core.Player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

    Console console;
    Blackjack blackjack;

    public Menu(Console console) {
        this.console = console;
    }

    public void mainMenuLoop() {
        welcomeMessage();
        //createPlayer();
        selectGame();
    }

    public void welcomeMessage() {
        //System.out.println("Welcome to C2's casino");
        console.println("Welcome to C2's Casino");
    }

    public Player createPlayer() {
        Integer testInput = console.getIntegerInput("Are you gambling today? (1)yes (2)no");
        //console.println(String.valueOf(testInput));
        switch (testInput) {
            case 1:
                /**
                 * if they want to gamble create gambling player
                 */
                double startingWallet = console.getDoubleInput("How much would you like to gamble?");
                String gamblingPlayerName = console.getStringInput("What is your name?");
                Player gamblingPlayer = new Player(startingWallet, gamblingPlayerName);
                return gamblingPlayer;
            case 2:
                String nonGamblingPlayerName = console.getStringInput("What is your name?");
                Player nonGamblingPlayer = new Player(nonGamblingPlayerName);
                return nonGamblingPlayer;
            default:
                console.println("not a valid input");
                return null;
        }
    }

    public void selectGame() {
        Player newPlayer = createPlayer();
        Integer gameMenu = console.getIntegerInput("Which game would you like to play?\n" +
                "1: BlackJack\n2: Craps\n3: Go Fish\n4: Cee-Lo");
        switch (gameMenu) {
            case 1:
                blackjack = new Blackjack(newPlayer, console);
                blackjack.playBlackJack();
                console.println("After playing you now have $" + blackjack.displayPlayerWallet());
        }
    }


}
