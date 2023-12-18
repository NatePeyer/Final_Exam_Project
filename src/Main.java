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
                        war(scan, deck);
                    } 
                    else
                    {
                        System.out.println("Please select option one to create a deck and then try again.");
                    }       
                    break;
                case 7:
                    if(deck != null)
                    {
                        blackJack(scan, deck);
                    }
                    else
                    {
                        System.out.println("Please select option one to create a deck and then try again.");
                    }
                    break;
                case 0:
                    System.out.println("You have left the casino.");
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

    public static void war(Scanner scan, DeckOfCards deckIn)
    {
        ArrayList<Card>playerCards = new ArrayList<Card>();
        ArrayList<Card>computerCards = new ArrayList<Card>();
        ArrayList<Card>cardsPlayed = new ArrayList<Card>();
        int rounds = 0;

        // cards delt face down so they inverse the order in the players hand ie first card delt is last card played
        while(deckIn.length() > 0)
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
    }

    public static int blackJackGame(Scanner scan, DeckOfCards deckIn)
    {
        ArrayList<Card> dealerCards = new ArrayList<Card>();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        int playerCardTotal = 0;
        int dealerCardTotal = 0;
        int gameResult = 0;
        boolean run = true;

        // dealing first two cards
        for(int i = 0; i < 2; i++)
        {
            playerCards.add(0, deckIn.dealCard());
            dealerCards.add(0, deckIn.dealCard());
        }

        while(run)
        {
            System.out.println("The house has: " + dealerCards.get(1).toString() + ".");
            System.out.println("You have: ");
            printCards(playerCards);
            playerCardTotal = blackJackSum(playerCards);
            dealerCardTotal = blackJackSum(dealerCards);
            System.out.println("They sum to: " + playerCardTotal);
            blackJackMenu();
            int in = scan.nextInt();
            scan.nextLine();
            switch(in)
            {
                case 1:
                    playerCards.add(deckIn.dealCard());
                    playerCardTotal = blackJackSum(playerCards);
                    printCards(playerCards);
                    System.out.println("Your cards sum to: " + playerCardTotal);
                    if(playerCardTotal > 21)
                    {
                        System.out.println("You went over 21 and lost your money, sorry.");
                        run = false;
                        gameResult = -1;
                    }
                    break;
                case 2:
                    //Stand
                    do
                    {
                        
                        if(dealerCardTotal < 17)
                        {
                            dealerCards.add(deckIn.dealCard());
                        }
                        dealerCardTotal = blackJackSum(dealerCards);
                    } while(dealerCardTotal < 17);
                    System.out.println("Your cards:");
                    printCards(playerCards);
                    System.out.println("You stand your cards total to: " + playerCardTotal);
                    System.out.println("Houses cards: ");
                    printCards(dealerCards);
                    System.out.println("The house's cards total to: " + dealerCardTotal);
                    if(dealerCardTotal > 21)
                    {
                        System.out.println("The house busted and you win. You have very good luck.");
                        gameResult = 1;
                    }
                    else if(playerCardTotal > dealerCardTotal)
                    {
                        System.out.println("Your cards were closer to 21 than the house. Good Job");
                        gameResult = 1;
                    }
                    else if(playerCardTotal < dealerCardTotal)
                    {
                        System.out.println("The house was closer to 21 than you, you lose. Better luck next time.");
                        gameResult = -1;
                    }
                    else
                    {
                        System.out.println("You and the house tied you get your money back yay!");
                        gameResult = 0;
                    }
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a correct option from the menu.");
                    break;
            }
        }
        return gameResult;
    }
    public static void blackJackMenu()
    {
        System.out.println("1. Hit.");
        System.out.println("2. Stand.");
    }

    public static int blackJackSum(ArrayList<Card> cards)
    {
        int cardTotal = 0;
        for(int i = 0; i < cards.size(); i++)
        {
            cardTotal += cards.get(i).value(11);
        }
        if(cardTotal > 21)
        {
            cardTotal = 0;
            for(int i = 0; i < cards.size(); i++)
            {
                cardTotal += cards.get(i).value(1);
            }
        }
        return cardTotal;
    }

    public static void printCards(ArrayList<Card> cards)
    {
        for(int i = 0; i < cards.size(); i++)
        {
            if(i < (cards.size()-1))
            {
                System.out.println(cards.get(i).toString() + ",");
            }
            else
            {
                System.out.println(cards.get(i).toString() +".");
            }
        }
    }

    public static void blackJack(Scanner scan, DeckOfCards deck)
    {
        int winCount = 0;
        int loseCount = 0;
        int games = 0;
        boolean run = true;
        double playerMoney = 0;
        double playerBeat = 0;
        String playAgain;
        
        System.out.println("How much money do you want to have avilable to bet?");
        playerMoney= scan.nextDouble();
        scan.nextLine();

        while(run)
        {
            System.out.println(String.format("You have $%.2f avilable to bet how much would you like to place on this game?", playerMoney));
            playerBeat = scan.nextDouble();
            scan.nextLine();
            deck.shuffle();
            int outcome = blackJackGame(scan, deck);
            games++;

            switch(outcome)
            {
                case -1:
                    //lose
                    loseCount++;
                    playerMoney -= playerBeat;
                    break;
                case 0:
                    //tie
                    break;
                case 1:
                    //win
                    winCount++;
                    playerMoney += playerBeat;
                    break;
            }
            System.out.println(String.format("You finsished this round with $%.2f.", playerMoney));
            System.out.println("You you have played " + games + " games, and won " + winCount + " games and lost " + loseCount + " games.");
            System.out.println("Do you want to play again? Y/N");
            playAgain = scan.nextLine();
            if(playAgain.toLowerCase().charAt(0) == 'n')
            {
                run = false;
            }
        }
    }
}