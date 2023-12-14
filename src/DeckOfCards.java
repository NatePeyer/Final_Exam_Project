import java.util.*;

public class DeckOfCards {
    public Card deck[] = new Card[52];
    private String typeIn = "";
    private String suitIn = "";

    public DeckOfCards(Card cardIn) {
        int i = 0;
        for (int j = 0; j < 4; j++)
            {
                for (int k = 1; k <= 13; k++)
                {
                    deck[i] = new Card(Suit(j),k);
                    i++;
                }

            }

    }
}