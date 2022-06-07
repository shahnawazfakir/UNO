/*
 * Player.java
 * 
 * A blueprint for objects that represent a single CardMatch player.
 * 
 */

import java.util.*;

public class Player
{
    // fields of Player object
    private String name; // keeps track of the player’s name.
    private Card[] hand; // array to hold the cards in the player’s hand.
    private int numCards; // keeps track of how many cards are currently in the player’s hand.

    /**
     * Constructor that takes a string of the player's name, and initializes the values 
     * of the fields.
     */
    public Player(String name)
    {
        this.name = name;
        Card[] hand = new Card[CardMatch.MAX_CARDS];
        this.hand = hand;
        this.numCards = 0;
    }

    /**
     * returns the player’s name.
     */
   
    public String getName()
    {
        return this.name;
    }

    /**
     * returns the current number of cards in the player’s hand.
     */

    public int getNumCards()
    {
        return this.numCards;
    }

    // returns the player's name.

    public String toString()
    {
        return getName();
    }

    /**
     *  Takes a Card object as a parameter and adds the specified card to the player’s hand, 
     * filling the array from left to right. It throws an IllegalArgumentException if the 
     *  parameter is null, or if the player already has the maximum number of cards.
     */

    public void addCard(Card card) 
    {
        if (card == null || this.numCards == CardMatch.MAX_CARDS) {
            throw new IllegalArgumentException();
        }

        this.hand[this.numCards] = card;
        this.numCards++;
    }

    /**
     * Takes an integer index as a parameter and returns the Card at the specified position 
     * in the player’s hand, without actually removing the card from the hand. If the specified 
     * index does not correspond to one of the cards in the hand, the method throws an 
     * IllegalArgumentException.
     */

    public Card getCard(int index) 
    {
        if (index < 0 || index >= this.numCards) {
            throw new IllegalArgumentException();
        }
        return this.hand[index];
    }

    /**
     * Computes and returns the total value of the player’s current hand plus an additional 
     * 20-point penalty if the hand has the maximum number of cards.
     */

    public int getHandValue() 
    {
        int handValue = 0;
        
        for (int i = 0; i < this.numCards; i++) {
            handValue += this.hand[i].getValue();
        }

        if (this.numCards == CardMatch.MAX_CARDS) {
            handValue += CardMatch.MAX_CARDS_PENALTY;
        }
        return handValue;
    }

    /**
     * Prints the current contents of the player’s hand, preceded by a heading that 
     * includes the player’s name.
     */

    public void displayHand() 
    {
        System.out.println(this.name + "'s hand:");

        for (int i = 0; i < this.numCards; i++) {
            System.out.println("  " + i + ": " + this.getCard(i));
        }
    }

    /**
     * Takes an integer index as a parameter and both removes and returns the Card at 
     * that position of the player’s hand. If the specified index does not correspond 
     * to one of the cards in the hand, the method throws an IndexOutOfBoundsException.
     */

    public Card removeCard(int index) 
    {
        if (index < 0 || index >= this.numCards) {
            throw new IndexOutOfBoundsException();
        }
        
        Card removedCard = this.hand[index];

        if (index == this.numCards - 1) {
            this.numCards--;
            return this.hand[index];
        } else {
            this.numCards--;
            for (int i = index; i < this.numCards; i++) {
                this.hand[i] = this.hand[i + 1]; 
            }
        }

        return removedCard;
    }

    /**
     * Determines and returns the number corresponding to the player’s next play: either -1 
     * if the player wants to draw a card, or the number/index of the card that the player 
     * wants to discard from his/her hand.
     */

    public int getPlay(Scanner input, Card card) 
    {
        
        int userInput;
        
        do {
            System.out.print(this.name + ": number of card to play (-1 to draw)? ");
            userInput = input.nextInt();
        } while (userInput < -1 || userInput >= this.numCards);

        return userInput;
    }
}