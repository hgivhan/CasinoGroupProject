package io.zipcoder.casino.cardstuff;

public class Card {
    private Suit suit;
    private Value value;

    /**
     * constructor for Card class
     * @param suit suit (Spade, Club, Heart, Diamond)
     * @param value value (2, ..., 10, J, Q, K, A)
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Overrides default toString method returning concatenation of suit and value in string format
     * @return string containing the suit and value a given card instance
     */
    public String toString() {
        return this.suit.toString() + " " + this.value.toString();
    }

    /**
     * Generic getter for value
     * @return value of given Card instance
     */
    public Value getValue() {
        return this.value;
    }
}
