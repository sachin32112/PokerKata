package main.java.com.bitwise.poker;

import java.util.Vector;

/**
 * Created by sachind on 7/24/2016.
 */
public class Hand {
    Vector<Card1> cards;
    private int combination;
    private int highCard;
    public Hand(String[] input)
    {
        cards=new Vector<Card1>(5);
for(int i=0;i<input.length;i++)
{
    cards.add(new Card1(input[i]));
    sort();
}
    }

    private void sort() {
        for(int i=0;i<cards.capacity();i++)
        {
            int indexOfMin=i,min=getValue(i);
            for(int j=i+1;j<cards.capacity();j++)
            {
                if(getValue(j)<min)
                {
                    min=getValue(j);
                    indexOfMin=j;
                }
            }
            Card1 temp=getCard(i);
            cards.set(i,getCard(indexOfMin));
            cards.set(indexOfMin,temp);
        }
    }
public void printHand()
{
    for(int i=0;i<cards.capacity();i++)
        System.out.println(Integer.toString(getValue(i)) + getSuit(i));
}
    public int getValue(int i) {
        return cards.get(i).getValue();
    }

    public char getSuit(int i) {
        return cards.get(i).getSuit();
    }

    public int getCombination() {
        return combination;
    }

    public int getHighCard() {
        return highCard;
    }

    public Card1 getCard(int i) {
        return cards.get(i);
    }

    public void setCombination(int combination) {
        this.combination = combination;
    }

    public void setHighCard(int i) {
      highCard=i;
    }
}
