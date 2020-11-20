import io.zipcoder.casino.core.DiceGame;
import io.zipcoder.casino.core.GamblingGame;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Menu;
import java.util.ArrayList;
public class Craps extends DiceGame implements GamblingGame {
    DiceGame diceGame;
    Console console;
    Player player;
    Menu menu;
    private Integer extraDieVal;
    ArrayList<Integer> dieRolls;
    ArrayList<Integer> dieArr = new ArrayList<Integer>();
    private Boolean firstRoll;
    private Boolean extraRoll;
    Integer hasMoney;
    Double playerMoney;
    private Double betAmt;
    public Craps(Player player, Console console) {
        this.player = player;
        playerMoney = player.getPlayerMoney();
        this.console = console;
        diceGame = new DiceGame();
    }
    //Check player balance. Player must have at least 1 chip to buy in (Actual Game)
    public void gameOn() {
        firstRoll = true;
        while(firstRoll) {
            playerHasMoney();
            extraRoll = true;
            rollBet();
            while(extraRoll) {
                extraRollBet();
            }
        }
    }
    //getting value rolling die and storing in new array
    public void getDie() {
        dieRolls = diceGame.tossAndList(2);
        extraDieVal = dieRolls.get(0) + dieRolls.get(1);
        dieArr.add(extraDieVal);
    }
    //First roll and determines if your first win or loss
    public void rollBet() {
        getDie();
        if(dieArr.get(0) == 7 || dieArr.get(0) == 11) {
            console.println("You win on the first round with a " + dieArr.get(0).toString());
            youWin();
            firstRoll = playAgainBoo();
        } else if (dieArr.get(0) == 2 || dieArr.get(0) == 3 || dieArr.get(0) == 12) {
            console.println("You lose on the first roll with a " + dieArr.get(0).toString());
            youLose();
            firstRoll = playAgainBoo();
        }
    }
    //the roll after first roll 2nd 3rd 4th roll if first value of die= most recent toss then win or if roll 7 you lose
    public void extraRollBet() {
        getDie();
        if(dieArr.get(0) == dieArr.get(dieArr.size() - 1)) {
            console.println("Your first roll was a " + dieArr.get(0).toString() + ", you matched that roll to win in a later round.");
            youWin();
            extraRoll = false;
            firstRoll = playAgainBoo();
        } else if (dieArr.get(dieArr.size() - 1) == 7) {
            console.println("Your first roll was a " + dieArr.get(0).toString() + " but you rolled a 7 in a later round.");
            youLose();
            extraRoll = false;
            firstRoll = playAgainBoo();
        }
    }
    //receiving input if you would like to play again
    public String playAgainStr() {
        String play = console.getStringInput("Would you like to play again?  (Y or N)");
        return play;
    }
    //Takes value of playagainstStr and capitalizes and if they enter lower or upper case n becomes false if you press anything it is true
    public Boolean playAgainBoo() {
        String playStr = playAgainStr().toUpperCase();
        return !playStr.equals("N");
    }
    //Checking if player has over $1 then check player bet
    public void playerHasMoney() {
        //hasMoney = 0;
        if(playerMoney >= 1) {
            //hasMoney = 1;
            checkPlayerBet();
        } else {
        }
    }
    //Checks if player has more money than he is betting if not
    public void checkPlayerBet() {
        betAmt = getPlayerBet();
        if(betAmt > playerMoney) {
            firstRoll = false;
            console.println("need more cash");
        }
    }
    //getter for collecting bet amount
    public Double getBetAmt() {
        return betAmt;
    }
    //printer gets new bet
    public double getPlayerBet() {
        console.println("You currently have $" + player.getPlayerMoney());
        Double newBet = console.getDoubleInput("How much would you like to bet?");
        return newBet;
    }
    //displays player balance
    public double displayPlayerWallet() {
        return player.getPlayerMoney();
    }
    //sets money and adds money to the balance you bet and clears array
    public void youWin() {
        player.setPlayerMoney(player.getPlayerMoney() + getBetAmt());
        console.println("Congrats you won $" + getBetAmt());
        dieArr.clear();
    }
    //sets bet amount and then subtracts from the balance and clears array
    public void youLose() {
        player.setPlayerMoney(player.getPlayerMoney() - getBetAmt());
        console.println(" You Lose $" + getBetAmt());
        dieArr.clear();
    }
}