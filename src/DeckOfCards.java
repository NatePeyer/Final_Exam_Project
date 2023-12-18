import java.lang.Math;
import java.util.*;

public class DeckOfCards {
    private Card[] deck = new Card[52];
    private ArrayList<Card> deltDeck = new ArrayList<Card>();

    public DeckOfCards() {
        int i = 0;
        for (Card.Suit j : Card.Suit.values())
        {
            for (int k = 1; k <= 13; k++)
            {
                deck[i] = new Card(j,k);
                i++;
            }
        }
        deltDeck.clear();
        System.out.println("New deck created.");
    }

    // The shuffle algorithm works by genrating a random number between 0 and 51 and then using that as a cards at i's
    // new postion from here the two cards swap and then the program moves on to the next card. This is done twice for
    // the whole deck as to ensure a complete and fair shuffle.
    public void shuffle()
    {
        boolean run = true;
        int count = 0;
        Card temp;

        // checks to see if deck is whole if not greats a new deck by adding the delt cards to the end of the current deck and then goes through shuffling algorithm
        if(deck.length != 52)
        {
            Card[] tempDeck = new Card[52];
            for(int i = 0; i < tempDeck.length; i++)
            {
                if(i >= deck.length)
                {
                    tempDeck[i] = deltDeck.get(0);
                    deltDeck.remove(0);
                }
                else
                {
                    tempDeck[i] = deck[i];
                }
            }
            deck = tempDeck;
        }
        
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
        return dealNum(deck.length);
    }

    public String dealNum(int numCardsDeal)
    {
        String buildString = "";
        if(numCardsDeal > deck.length)
        {
            System.out.println("Error not enough cards left in the deck.");
            return buildString;
        }
        for(int i = 0; i < numCardsDeal; i++)
        {
            deltDeck.add(i, deck[i]);
            buildString += deck[i].toString() + "\n";
        }
        for(int j = numCardsDeal; j < deck.length; j++)
        {
            deck[j - numCardsDeal] = deck[j];
        }
        Card[] newCardDeck = new Card[deck.length - numCardsDeal];
        for(int k = 0; k < newCardDeck.length; k++)
        {
            newCardDeck[k] = deck[k];
        }
        deck = newCardDeck;
        return buildString;
    }

    public Card dealCard()
    {
        Card deltCard = deck[0];
        Card[] newDeck = new Card[deck.length-1];
        for(int i = 0; i < newDeck.length; i++)
        {
            newDeck[i] = deck[i + 1];
        }
        deltDeck.add(0, deltCard);
        deck = newDeck;
        return deltCard;
    }
    
    public int length()
    {
        return deck.length; 
    }

    public String numCards()
    {
        String returnString = "There are " + deck.length + " cards remaining in the deck.";
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