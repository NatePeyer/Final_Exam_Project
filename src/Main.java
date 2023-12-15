import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        DeckOfCards deck = new DeckOfCards(null);
        System.out.println(deck);
        deck.shuffle();
        System.out.println();
        System.out.println(deck);

        Scanner scan = new Scanner(System.in);
        showMenu();
        boolean run = true;
        int input = scan.nextInt();
        scan.nextLine();
        while(run)
        {
            switch(input)
            {
                case 1:
                    DeckOfCards deck = new DeckOfCards(null);
                    break;
                case 2:
                    deck.shuffle();
                    break;
                case 3:
                    //deal every remaining card
                case 4:
                    //deal a specfic number of cards
                case 5:
                    //number of cards remainf in the deck
                case 0:
                    run = false;
                    break;

            }
        }

    }

    public static String showMenu()
    {
        System.out.println("1. Create a deck of cards.");
        System.out.println("2. Shuffle the cards.");
        System.out.println("3. Deal every card remaining in the deck");
        System.out.println("4. Deal a specified number of cards");
        System.out.println("5. Number of cards remaining in deck");
        System.out.println("0. quit.");
    }
}