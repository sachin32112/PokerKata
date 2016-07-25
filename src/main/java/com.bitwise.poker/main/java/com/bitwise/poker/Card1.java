package main.java.com.bitwise.poker;

/**
 * Created by sachind on 7/24/2016.
 */
public class Card1 {
private int value;
  private  char suit;
    private String name;
    public Card1(String input)
    {name=input;
       suit=input.charAt(input.length()-1);
        String temp=input.substring(0,input.length()-1);
        if(Character.isDigit(temp.charAt(0)))
            value=Integer.parseInt(temp);
        else
        {
            switch(temp.charAt(0))
            {
                case 'J':
                    value=11;
                    break;
                case 'Q':
                    value=12;
                    break;
                case 'K':
                    value=13;
                    break;
                case 'A':
                    value=14;
                    break;
                default:
                    value=0;
            }
        }

    }
    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }
    public String toString()
    {
        return name;
    }
}
