import java.lang.Math;
import java.util.*;

public class DeckOfCards {
    private Card deck[] = new Card[52];
    private Card deltDeck[] = new Card[52];

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
        for(int k = 0; k < deltDeck.length; k++)
        {
            deltDeck[k] = null;
        }
        System.out.println("New deck created.");
    }

    // The shuffle algorithum works by genrating a random number between 0 and 51 and then using that as a cards at i's
    // new postion from here the two cards swap and then the program moves on to the next card. This is done twice for
    // the whole deck as to ensure a complete and fair shuffle.
    public void shuffle()
    {
        boolean run = true;
        int count = 0;
        Card temp;

        while(run)
        {
            if(count == 1)
            {
                run = false;
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

    public String dealRemaining()
    {
        String returnString = DeckOfCards.toString;
        return returnString;
    }

    public String dealNum(int numCardsDeal)
    {
        String buildString = "";
        if(numCardsDeal > deck.length)
        {
            System.out.println("Error not enough cards left in the deck.")
            break;
        }
        for(int i = 0; i < numCardsDeal; i++)
        {
            deltDeck[i] = deck[i];
            buildString += deltDeck[i].toString + "\n";
        }
        for(int j = numCardsDeal; j < deck.length; j++)
        {
            deck[j - numCardsDeal] = deck[j];
        }
        private newCardDeck[] = new Card[deck.length - numCardsDeal];
        for(int k = 0; k < newCardDeck.length; k++)
        {
            newCardDeck[k] = deck[k];
        }
        deck = newCardDeck;
    }

    public String numCards()
    {
        String returnString = "There are " deck.length + " cards remaining in the deck.";
        return returnString;
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