/*
 * AIPlayer.java
 * 
 * A blueprint for objects that represent a computer player.
 * 
 * completed by: Shahnawaz Fakir
 */

import java.util.*;

public class AIPlayer extends Player
{
    /**
     *  Takes the name of the player as a parameter and call the constructor of the superclass 
     *  to initialize the inherited fields.
     */

    public AIPlayer(String name)
    {
        super(name);
    }

    /**
     * Overrides the inherited version of displayHand() method in the Player class. This version
     * only prints the number of cards in the ComputerPlayer‘s hand.
     */

    public void displayHand()
    {
        System.out.println(this.getName() + "'s hand:");

        if (this.getNumCards() == 1) {
            System.out.println(this.getNumCards() + " card");
        }
        else {
            System.out.println("  " + this.getNumCards() + " cards");
        }
    }

    /**
     * Overrides the inherited version of getPlay() method. This version of the method figures out if 
     * the computer has a card that matches the card at the top of the discard pile. If the computer 
     * doesn’t have a matching card, this method returns -1 so that the computer will end up drawing 
     * a card. If the computer does have one or more matching cards, the method should return the 
     * index of the card that should be played.
     */

    public int getPlay(Scanner input, Card card)
    {
        int index = -1;
        int max = 0;

        for (int i = 0; i < this.getNumCards(); i++) {
            if (this.getCard(i).matches(card) == true) {
                if (max < getCard(i).getValue()) {
                    max = getCard(i).getValue();
                    index = i;
                }
            }     
        }
        return index;
    }
 }