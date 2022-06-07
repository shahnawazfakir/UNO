/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card 
 * for a game in which cards have both colors and numeric values.
 
 */

public class Card {
    /* The smallest possible value that a Card can have. */
    public static final int MIN_VALUE = 0;
    
    /* The possible colors that a Card can have. */
    public static final String[] COLORS = {"blue", "green", "red", "yellow"};

    /* Define the third class constant here. */
    public static final int MAX_VALUE = 9;

    /* Put the rest of your class definition below. */

    public static boolean isValidColor(String color) 
    {
        /*  Take the name of a color as a parameter, and returns true if the specified color 
        is in the COLORS array and false otherwise.
        */

        for (int i = 0; i < COLORS.length; i++) {
            if (COLORS[i].equals(color)) {
                return true;
            }
        }
        return false;
    }

    // encapsulating color and value
    private String color; 
    private int value;

    public void setColor(String color) 
    {
        /* Takes a String representing a color and sets the value of the Card object’s color field 
        to the specified color. Attempts to assign an invalid color produces an IllegalArgumentException
        error.
        */

        if (isValidColor(color) == false) {
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public void setValue(int value) 
    {
        /* Takes an integer and sets the value of the Card object’s value field to the specified number. 
        Attempts to assign an invalid value produces an IllegalArgumentException error.
        */

        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public Card(String color, int value) 
    {
        /* Constructor that takes a string for the Card‘s color and an integer for the Card‘s value, and 
        initializes the values of the fields.
        */
        this.setColor(color);
        this.setValue(value);
    }

    public String getColor() 
    {
        // returns the string representing the Card object’s color.

        return this.color;
    }

    public int getValue() 
    {
        // returns the integer representing the Card object’s value.

        return this.value;
    }

    public String toString() 
    {
        /* returns a String representation of the Card object that can be used when printing it or 
        concatenating it to a String.
         */

        return this.color + " " + this.value; 
    }

    public boolean matches(Card other) 
    {
        /* Takes another Card object as a parameter and returns true if the called Card object matches
        the color and/or value of the other Card object, and false if it doesn’t match either the color 
        or the value. If a value of null is passed in for the parameter, the method returns false.
        */

        if (other != null && (this.color.equals(other.color) || this.value == other.value)) {
            return true;
        }
        return false;
    }

    public boolean equals(Card other) 
    {
        /* Takes another Card object as a parameter and determines if it is equivalent to the called object, 
        returning true if it is equivalent and false if it is not equivalent. If a value of null is passed 
        in for the parameter, the method returns false.
        */
        
        if (other != null && this.color.equals(other.color) && this.value == other.value ) {
            return true;
        }
        return false;
    }
    
}