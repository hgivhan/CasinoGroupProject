package io.zipcoder.casino.core;

public class Player implements GamblingPlayer {

    //amount of money player has to use at gambling games
    private double playerMoney;
    //player's name
    private String name;

    //constructor for Player object
    public Player(double startingWallet, String name) {
        //startingWallet parameter used to determine initial playerMoney
        this.playerMoney = startingWallet;
        //name set to name
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public double getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(double money) {
        this.playerMoney = money;
    }
}
