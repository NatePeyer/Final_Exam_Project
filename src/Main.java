import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        DeckOfCards deck = null;

        Scanner scan = new Scanner(System.in);
        
        boolean run = true;
        while(run)
        {
            showMenu();
            int input = scan.nextInt();
            scan.nextLine();
            switch(input)
            {
                case 1:
                    deck = new DeckOfCards();
                    break;
                case 2:
                    if(deck != null)
                    {
                        deck.shuffle();
                        System.out.println("The deck has been shuffled.");
                    }
                    else
                    {
                        System.out.println("Please select option one to create a deck and then try again.");
                    }   
                    break;
                case 3:
                    if(deck != null)
                    {
                        System.out.println(deck.dealRemaining());
                    } 
                    else
                    {
                        System.out.println("Please select option one to create a deck and then try again.");
                    }   
                    break;
                case 4:
                    System.out.println("How many cards would you like to deal?");
                    int cardIn = scan.nextInt();
                    scan.nextLine();
                    System.out.println(deck.dealNum(cardIn));
                    break;
                case 5:
                    System.out.println(deck.numCards());
                    break;
                case 6: 
                    if(deck != null)
                    {
                        war(deck);
                    } 
                    else
                    {
                        System.out.println("Please select option one to create a deck and then try again.");
                    }       
                    break;
                case 7:
                    //black jack
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a correct option from the menu.");
                    break;
            }
        }
        scan.close();
    }

    public static void showMenu()
    {
        System.out.println("1. Create a deck of cards.");
        System.out.println("2. Shuffle the cards.");
        System.out.println("3. Deal every card remaining in the deck.");
        System.out.println("4. Deal a specified number of cards.");
        System.out.println("5. Number of cards remaining in deck.");
        System.out.println("6. Play War against the computer.");
        System.out.println("7. Play Black Jack against the computer.");
        System.out.println("0. quit.");
    }

    public static void war(DeckOfCards deckIn)
    {
        ArrayList<Card>playerCards = new ArrayList<Card>();
        ArrayList<Card>computerCards = new ArrayList<Card>();
        ArrayList<Card>cardsPlayed = new ArrayList<Card>();
        int rounds = 0;
        Scanner scan = new Scanner(System.in);

        // cards delt face down so they inverse the order in the players hand ie first card delt is last card played
        for(int i = 0; deckIn.length() > 0; i++)
        {
            playerCards.add(0, deckIn.dealCard());
            computerCards.add(0, deckIn.dealCard());
        }

        while((playerCards.size() > 0) && (computerCards.size() > 0))
        {
            rounds++;
            System.out.println("Are you read to play round " + rounds + " of War against the computer? - Press enter to begin the round.");
            scan.nextLine();

            // cards placed up and stored in sperate list incase of tie.
            Card computerPlayed = computerCards.get(0);
            Card playerPlayed = playerCards.get(0);
            int ranSpot = (int)(Math.random()*2 + 1);
            
            if(ranSpot == 1)
            {
                cardsPlayed.add(0, computerPlayed);
                cardsPlayed.add(0, playerPlayed);
            }
            else
            {
                cardsPlayed.add(0, playerPlayed);
                cardsPlayed.add(0, computerPlayed);
            }
            computerCards.remove(0);
            playerCards.remove(0);
            
            System.out.println("You played a " + playerPlayed + "\nThe computer played a " + computerPlayed);
            if(playerPlayed.value(true) > computerPlayed.value(true))
            {
                System.out.println("You won this round.");
                playerCards.addAll((playerCards.size()),cardsPlayed);
                cardsPlayed.clear();
            }
            else if(playerPlayed.value(true) < computerPlayed.value(true))
            {
                System.out.println("The computer won this round.");
                computerCards.addAll((computerCards.size()),cardsPlayed);
                cardsPlayed.clear();
            }
            else
            {
                System.out.println("You tied cards remain in the middle for next round.");
            }
            //System.out.println("Players cards: " + playerCards.toString() + " number of cards in hand: " + playerCards.size());
            //System.out.println("Computers cards: " + computerCards.toString() + " number of cards in hand: " + computerCards.size());
        }
        if(playerCards.size() > 0)
        {
            System.out.println("You won in " + rounds + " rounds! Good job.");
        }
        else
        {
            System.out.println("The computer won in " + rounds + " rounds. Better luck next time.");
        }
        scan.close();
    }
}