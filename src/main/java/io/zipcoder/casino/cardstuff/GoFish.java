package io.zipcoder.casino.cardstuff;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish {

    public Random random = new Random();
    private Integer aiPairs = 0;
    private Integer playerPairs = 0;
    private Deck deck = new Deck();
    private Deck playerHand = new Deck();
    private Deck aiHand = new Deck();
    private Card card;
    public Scanner scanner = new Scanner(System.in);
//    Console console = new Console(System.in, System.out);
    private ArrayList<Card> aiGuesses = new ArrayList<Card>();
    private Integer ageOfGuesses = 0;


    public GoFish(){

    }

    public void run(){
        createDeck();
        dealCards();


        System.out.println("Welcome to Go Fish. ");

        while(playerPairs + aiPairs <= 26){

            turnPlayer();
            System.out.println("----------");
            playerPairs += checkPairs(playerHand);

            turnAi();
            System.out.println("----------");
            aiPairs += checkPairs(aiHand);
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
        Boolean playing = true;
        do{
            playerPairs += checkPairs(playerHand);

            System.out.println("You have " + getPlayerPairs() + " pairs.");

            if(playerHand.getNumCards() == 0){
                System.out.println("Looks like your hand is empty, draw five cards.");
                for(int x = 0; x < 5; x++){
                    fish(playerHand);
                }
            }
            System.out.println("Your hand is: ");
            for(int i = 0; i < playerHand.getNumCards(); i++){
                System.out.print(playerHand.getCard(i) + ", ");
            }

            System.out.println("\nWhich card would you like to ask for?");

            Card input;
            try{
                input = new Card(Suit.CLUB, Value.valueOf(scanner.next().toUpperCase()));
            }
            catch(IllegalArgumentException e){
                System.out.println("Card not valid or present, please try another. Try again: ");
                continue;
            }

            if(!checkCardAskedFor(playerHand, input)){
                System.out.println("You cannot ask for a card you do not have. Try again: ");
                continue;
            }

            System.out.println("You ask for a " + input.getValue());
            if(checkCards(aiHand, playerHand, input)){
                playerPairs++;
                playing = true;
            } else{
                playing = false;
                aiGuesses.add(input);
            }

        } while(playing);
        System.out.println("Go fish!");
        fish(playerHand);
    }

    public void turnAi(){
        Boolean playing = true;
        do{
            aiPairs += checkPairs(aiHand);

            System.out.println("Your opponent has " + getAiPairs() + " pairs.");

            if(aiHand.getNumCards() == 0){
                System.out.println("Looks like your opponent's is empty, drawing five cards.");
                for(int x = 0; x < 5; x++){
                    fish(aiHand);
                }
            }

            Card input = aiThoughts();

            System.out.println("Your opponent asks for a " + input.getValue());
            if(checkCards(playerHand, aiHand, input)){
                aiPairs++;
                playing = true;
            } else{
                playing = false;
            }
            ageOfGuesses++;
        } while(playing);
        System.out.println("Go fish!");
        fish(aiHand);
    }

    public Card aiThoughts(){
        if(ageOfGuesses > 2){
            aiGuesses.remove(aiGuesses.size()- 1);
            this.ageOfGuesses = 0;
        }
        for(int i = aiGuesses.size() - 1; i > -1; i--){
            if(checkCardAskedFor(aiHand, aiGuesses.get(i))){
                return aiGuesses.remove(i);
            }
        }
        return aiHand.getCard(random.nextInt(aiHand.getNumCards()));
    }

    public Integer checkPairs(Deck deckT){
        int numOfPairs = 0;
        for(int i = 0; i < deckT.getNumCards() - 1; i++){
                for(int x = i + 1; x < deckT.getNumCards() - 1; x++){
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
                    if(checker.getCard(x).getValue() == input.getValue()){
                        checker.removeCard(x);
                        checking.removeCard(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean checkCardAskedFor(Deck check, Card input){
        for(int i = 0; i < check.getNumCards(); i++){
            if(check.getCard(i).getValue() == input.getValue()){
                return true;
            }
        }
        return false;
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
