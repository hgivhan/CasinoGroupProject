package io.zipcoder.casino.craps;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Menu;

public class CrapsEngine {
    Console console;
    Bets bets;
    Player player;
    Menu menu;
    Integer hasMoney;

    public void playerMoney() {
        hasMoney = 0;

        if(player.getPlayerMoney() >= 1) {
            hasMoney = 1;
            comeoutRollMenu();
        } else {
            console.println("You low on bills bruh");
            menu.mainMenuLoop();
        }
    }

    public Integer comeoutRollMenu() {
        Integer passDontPass = console.getIntegerInput("Would you like to place a pass bet or a don't pass bet?\n" +
                "1. Pass bet\n" +
                "2. Don't pass bet");
        return passDontPass;
    }

    public void betType(Integer bet) {
        bet = comeoutRollMenu();
        if(bet == 1) {
            //PASSBET getBetAmt
        } else if (bet == 2) {
            //DONTPASSBET getBetAmt
        } else {
            console.println("Select either 1 or 2 please");
            comeoutRollMenu();
        }
    }

    public Integer getBetAmt() {
        Integer betAmt = console.getIntegerInput("How many chips would you like to bet?");
        return betAmt;
    }
}
