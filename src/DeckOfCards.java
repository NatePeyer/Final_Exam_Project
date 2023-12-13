import java.util.*;

public class DeckOfCards
{
    public Card deck[] = new Card[52];
    private String typeIn = "";
    private String suitIn = "";

    public DeckOfCards(Card cardIn)
    {
        for(int i = 0; i < deck.length; i++)
        {
            int s = 1;
            int t = 1;


            for(int j = 0; j < 4; j++)
            {
                 cardSuit(j);
                for(int k = 1; k < 13; k++)
                {
                    cardValue(k);
                    // add card object to area here
                }

            }

        }
    }


    private String cardSuit(int j)
    {
        if(j == 0)
        {
            suitIn = "Spades";
        }
        else if (j == 1)
        {
            suitIn = "Hearts";
        }
        else if(j == 2)
        {
            suitIn = "Diamonds";
        }
        else
        {
            suitIn = "Clubs";
        }
        for(int k = 1; k < 13; k++)
        {
            cardValue(k);
        }
    }
    private String cardValue(int k)
    {
        if(k == 1)
        {
            typeIn = "Ace";
        }
        else if (k == 10)
        {
            typeIn = "Jack";
        }
        else if (k == 11)
        {
            typeIn = "Queen";
        }
        else if (k == 12)
        {
            typeIn = "King";
        }
        else
        {
            typeIn = String.valueOf(k);
        }
    }
}
