public class Main {
    public static void main(String[] args)
    {
        DeckOfCards deck = new DeckOfCards(null);
        System.out.println(deck);
        deck.shuffle();
        System.out.println();
        System.out.println(deck);
    }
}