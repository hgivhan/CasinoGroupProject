package io.zipcoder.casino.cardstuff;


import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish {

    public Random random = new Random();
    private Integer aiPairs = 0;
    private Integer playerPairs = 0;
    public Deck deck = new Deck();
    private Deck playerHand = new Deck();
    private Deck aiHand = new Deck();
    private Card card;
    public Scanner scanner = new Scanner(System.in);


    public GoFish(){

    }

    public void run(){
        createDeck();
        dealCards();

        while(playerPairs + aiPairs <= 26){
            System.out.println("Welcome to Go Fish. ");

        }


        winningMessage();
    }

    public void createDeck() {
        deck.createFullDeck(1);
        deck.shuffleDeck();
    }

    public void dealCards(){
        for(int i = 0; i < 5; i++){
            playerHand.drawCard(deck);
            aiHand.drawCard(deck);
        }

    }

    public void turnPlayer(){


        Card input = new Card(Suit.CLUB, Value.valueOf(scanner.next()));
        fish(playerHand);


    }

    public void turnAi(){


        fish(aiHand);
    }

    public Integer checkPairs(Deck deckT){
        int numOfPairs = 0;
        for(int i = 0; i < deckT.getNumCards() - 1; i++){
                for(int x = i + 1; x < deckT.getNumCards(); x++){
                    if(deckT.getCard(i).getValue() == deckT.getCard(x).getValue()){
                        deckT.removeCard(i);
                        deckT.removeCard(x);
                        numOfPairs++;
                    }
                }
        }
        return numOfPairs;
    }

    public Boolean checkCards(Deck checking, Deck checker, Card input){
        for(int i = 0; i < checking.getNumCards(); i++){
            if(checking.getCard(i).getValue() == input.getValue()){
                for(int x = 0; x < checker.getNumCards(); x++){
                    
                }
            }
        }

    }

    public Integer getAiPairs() {
        return aiPairs;
    }

    public Integer getPlayerPairs() {
        return playerPairs;
    }

    public void fish(Deck temp){
        if(deck.getNumCards() > 0){
            temp.drawCard(deck);
        } else {
            System.out.println("Looks like the Deck is empty!");
        }
    }

    public String winningMessage(){
        String winner = "";
        if(aiPairs < playerPairs){
            winner = "Player";
            System.out.println("Congrats, you beat the AI!");
        }
        winner = "AI";
        System.out.println("Wow you couldn't beat the AI....");
        return winner;
    }

}
