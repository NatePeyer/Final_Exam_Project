
public class Card
{
    public enum Suit
    {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    };
    private Suit suit;
    private int value;

    public Card(Suit suitIn, int valueIn)
    {
        suit = suitIn;
        value = valueIn;
    }

    public int value(boolean aceHigh)
    {
        if((aceHigh == true) && (value == 1))
        {
            return 14;
        }
        return value;
    }

    public int value(int aceValue)
    {
        if((aceValue != 1) && (aceValue != 11))
        {
            System.out.println("Please enter a valid value for your ace.");
        }
        if(value == 1)
        {
            return aceValue;
        }
        else
        {
            if((value == 11) || (value == 12) || (value == 13))
            {
                return 10;
            }
            else
            {
                return value;
            }
        }
    }
    
    public String toString()
    {
        final String CARDNAME[] = 
        {
            "None", //0
            "Ace", //1
            "2", //2
            "3", //3
            "4", //4
            "5", //5
            "6", //6
            "7", //7
            "8", //8
            "9", //9
            "10", //10
            "Jack", //11
            "Queen", //12
            "King" //13
        };
        final String CARDSUIT[] =
        {
            "Clubs",
            "Diamonds",
            "Hearts",
            "Spades"
        };

        if((suit.ordinal() < 0) || (suit.ordinal() > 4))
        {
            return "invalid card suit";
        }
        if((value < 1) || (value >= CARDNAME.length))
        {
            return "invalid card value";
        }
        return CARDNAME[value] + " of " + CARDSUIT[suit.ordinal()];
    } 
}