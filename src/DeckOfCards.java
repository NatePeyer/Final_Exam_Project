import java.lang.Math;
import java.util.*;

public class DeckOfCards {
    public Card deck[] = new Card[52];

    public DeckOfCards(Card cardIn) {
        int i = 0;
        for (Card.Suit j : Card.Suit.values())
            {
                for (int k = 1; k <= 13; k++)
                {
                    deck[i] = new Card(j,k);
                    i++;
                }
            }
    }

    public void shuffle()
    {
        boolean run = true;
        int count = 0;
        Card temp;

        while(run)
        {
            if(count == 2)
            {
                break;
            }

            for(int i = 0; i < deck.length; i++)
            {
                int ranSpot = (int)(Math.random() * 52);
                temp = deck[ranSpot];
                deck[ranSpot] = deck[i];
                deck[i] = temp;
            }
            count++;
        }
    }
    
    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < deck.length; i++)
        {
            returnString += deck[i].toString() + "\n";
        }
        return returnString;
    }
}