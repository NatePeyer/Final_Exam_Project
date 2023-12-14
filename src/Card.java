public class Card
{
    public enum Suit 
    {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES,
        _LENGTH
    };
    private Suit suit;
    private int value;

    public Card(Suit suitIn, int valueIn)
    {
        suit = suitIn;
        value = valueIn;
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
        final String CARDSUIT[_LENGTH] =
        {
            "Clubs",
            "Diamonds",
            "Hearts",
            "Spades"
        };

        if((suit < 0) || (suit >= _LENGTH))
        {
            return "invalid card suit";
        }
        if((value < 1) || (value >= CARDNAME.length))
        {
            return "invalid card value";
        }
        return CARDNAME[value] + " of " + CARDSUIT[suit];
    } 
}
