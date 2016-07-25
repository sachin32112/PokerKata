
import main.java.com.bitwise.poker.Card1;
import main.java.com.bitwise.poker.Hand;
import main.java.com.bitwise.poker.PokerHands;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sachind on 7/24/2016.
 */
public class PokerHandTest {
    String inputFile;
    @Before
    public void setUp() throws Exception
    {
        inputFile="test.txt";
    }
    @Test
    public void createCard() {
        String input="1S";
        Card1 card=new Card1(input);
        assertEquals(1,card.getValue());
        assertEquals('S',card.getSuit());
    }
    @Test
public void createHand() {

    String[] input={"2S","3S","4S","5S","6S"};
    Hand hand=new Hand(input);
    assertEquals(2,hand.getValue(0));
   assertEquals('S',hand.getSuit(0));
   assertEquals(3,hand.getValue(1));
    assertEquals('S',hand.getSuit(1));
   assertEquals(4,hand.getValue(2));
    assertEquals('S',hand.getSuit(2));
    assertEquals(5,hand.getValue(3));
    assertEquals('S',hand.getSuit(3));
   assertEquals(6,hand.getValue(4));
    assertEquals('S',hand.getSuit(4));

}
    @Test
    public void isPair() throws Exception
    {
//String inputFile="test.txt";
        String content="Black: 2H 5D 6S KC KD  White: 2C 3H 4S 8C AH";

        writeToFile(content);

        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(1,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());

    }
    @Test
    public void isTwoPair() throws Exception
    {
        String content="Black: 6H 5D 6S KC KD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(2,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    public void isThreeOfAKind() throws Exception
    {
        String content="Black: 2H 5D KS KC KD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(3,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    public void isStraight()
    {
        String content="Black: 2H 3D 4S 5C AD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(4,poker.player1.getCombination());
        assertEquals(5,poker.player1.getHighCard());
    }
    @Test
    public void isFlush()
    {
        String content="Black: 2D 3D 4D 6D AD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(5,poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    public void isFullHouse()
    {
        String content="Black: 3S 3D AC AS AD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(6,poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    public void isFourOfAKind()
    {
        String content="Black: 3S AH AC AS AD  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();
        assertEquals(7,poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    public void isStraightFlush()
    {
        String content="Black: 2D 3D 4D 5D 6D  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();


        assertEquals(8,poker.player1.getCombination());
        assertEquals(6,poker.player1.getHighCard());
    }
    @Test
    public void getWinner()
    {
        String content="Black: 2D 3D 4D 5D 6D  White: 2C 3H 4S 8C AH";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();


        assertEquals("Black",poker.getWinner());

    }
    @Test
    public void getTie()
    {
        String content="Black: 2D 3D 4D 5D 6D  White: 2H 3H 4H 5H 6H";
        //String inputFile="test.txt";
        writeToFile(content);


        PokerHands poker=new PokerHands(inputFile);
        poker.judgeHands();


        assertEquals("Tie",poker.getWinner());
    }
    private void writeToFile(String content) {
        BufferedWriter writer= null;
        try {
            writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
