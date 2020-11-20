package io.zipcoder.casino.cardstuff;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    //array list of cards representing an individual deck
    private ArrayList<Card> cards;

    /**
     * Constructor for the Deck class
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * method to generate a new deck of Cards represented by an array list of Card objects
     */
    public void createFullDeck(int DecksInChute) {
        //for every Suit value in Suit enum, iterate through every value in Value enum
        //4 Suits * 13 Values = 52 cards
        for(int i = 0; i < DecksInChute; i++) {
            for (Suit cardSuit : Suit.values()) {
                for (Value cardValue : Value.values()) {
                    //add a new card to the array list deck
                    this.cards.add(new Card(cardSuit, cardValue));
                }
            }
        }
    }

    /**
     * method to randomly shuffle deck once it has been created
     */
    public void shuffleDeck() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for(int i = 0; i < originalSize; i++) {
            //pick a card at random from original deck
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            //add the randomly selected card to temporary deck
            tempDeck.add(this.cards.get(randomCardIndex));
            //remove card from original deck
            this.cards.remove(randomCardIndex);
        }

        //repopulate original deck with shuffled cards from temp deck
        this.cards = tempDeck;

    }

    /**
     * method to remove a specific card from the deck
     * @param cardIndex array list index of the card that is to be removed
     */
    public void removeCard(int cardIndex) {
        this.cards.remove(cardIndex);
    }

    /**
     * method to select a specific card from the deck
     * @param cardIndex array list index of the card that is to be selected from the deck
     * @return returns an index-referenced Card object from arrayList cards
     */
    public Card getCard(int cardIndex) {
        return this.cards.get(cardIndex);
    }

    /**
     * method to add a distinct card into the deck
     * @param addCard Card this is to be added back into the deck
     */
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    /**
     * draws a card from array list of cards. By default cardIndex is 0 because that is the "top" of the deck
     * @param sourceDeck deck from which the card is being drawn
     */
    public void drawCard(Deck sourceDeck) {
        this.cards.add(sourceDeck.getCard(0));
        sourceDeck.removeCard(0);
    }

    /**
     * method to calculate and return the value of cards in player or dealer's hand
     * @return total value of cards in player or dealer's hand
     */
    public Integer handValue() {
        int totalValue = 0;
        int aces = 0;

        //for each card in hand add appropriate points value to totalValue
        for(Card aCard : this.cards) {
            switch(aCard.getValue()) {
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    totalValue += 10; break;
                //case ACE: keep track of aces separately and then determine whether or not to value at 1 or 11 points
                case ACE: aces += 1; break;
                default: break;
            }
        }

        //consider each ace in the player's hand
        for(int i = 0; i < aces; i++) {
            //if valuing ace at 11 would cause player to bust value at one
            if(totalValue > 10) {
                totalValue += 1;
                //if valuing ace at 11 will not cause player to bust value at 11
            } else {
                totalValue += 11;
            }
        }

        //total value of cards being evaluated
        return totalValue;
    }

    public void clearHand(Deck targetDeck) {
        //for each card in player or dealer's hand, make a copy in the discard pile
        for(Card aCard : this.cards) {
            targetDeck.addCard(aCard);
        }
        //delete all cards in hand
        this.cards.clear();
    }

    public Integer getNumCards() {
        return this.cards.size();
    }

    /**
     * method to print out every card in a deck of cards in string format
     * @return String containing all cards in a deck of cards with their index
     */
    public String toString() {
        //declare and initialize output string
        String cardListOutput = "";

        //for every card in array list of cards, append to output string
        for(Card aCard : this.cards) {
            cardListOutput += aCard.toString() + ", ";
        }

        //return output string
        return cardListOutput;
    }
}
