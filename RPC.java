/* This is my attempt to make a rock paper scissors game in Java. I'd say it's scuffed and still doesn't use a try-catch to catch for input errors.

To-Improve List:
1. Implement Try-Catch
2. Find another way to make line 47 not use System.exit


*/
import java.util.Random;
import java.util.Scanner;

public class RPC
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        Random randomNum = new Random();

        int botChoice;
        int gameMenuChoice;
        int userChoice;
        int retry;

        int userRounds = 0;
        int roundsWon = 0;
        int roundsLost;
        int score;

        int sentinel = -99;



        while (true) { // Start Menu (Asks user if they want to start the game)


            while (sentinel == -99) {
                System.out.println("Welcome to Rock Paper Scissors in Java v1.0");
                System.out.print("Would you like to start the game?\n1. Start\n2. Exit\nChoice: ");
                gameMenuChoice = userInput.nextInt();
                

                if (gameMenuChoice == 1) {
                    System.out.println("\f----- Game Starts! -----");
                    sentinel = 0;
                } else if (gameMenuChoice == 2) {
                    System.out.println("Thanks for playing!");
                    System.exit(0); // System exit but this code can be coded better so that it doesn't use System exit.
                } else {
                    System.out.println("Invalid Input. Try Again.");
                }
            }

            // Game Menu (When the game has started)

            System.out.print("How many rounds would you like to play: ");
            userRounds = userInput.nextInt();

            for (int turn = 1; turn <= userRounds; turn++) { // for loop for displaying the turn

                try { // Delay for 2 seconds
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.printf("\f\f\f----- Turn %d -----", turn); // Determines the turn n#


                //Player's turn
                
                System.out.print("\nPlayer's Turn!\nWhat is your choice?\n1. Rock\n2. Paper\n3. Scissors\nChoice: ");
                userChoice = userInput.nextInt() - 1;


                switch (userChoice) { // This switch statement displays the choice of the player
                    case 0: // 0 - Rock
                        System.out.println("Player has chosen Rock");
                        break;
                    case 1: // 1 - Paper
                        System.out.println("Player has chosen Paper");
                        break;
                    case 2: // 2 - Scissors
                        System.out.println("Player has chosen Scissors");
                        break;
                } 
            
                // End of player turn

                // Start of bot turn

                System.out.println("\n----- Bot's Turn -----");

                try { // Delay for 2 seconds
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                botChoice = randomNum.nextInt(3); //Bot's choice
                switch (botChoice) {    // This swtich statement displays the choice of the bot
                    case 0: // 0 - Rock
                        System.out.println("Bot has chosen Rock");
                        break;
                    case 1: // 1 - Paper
                        System.out.println("Bot has chosen Paper");
                        break;
                    case 2: // 2 - Scissors
                        System.out.println("Bot has chosen Scissors");
                        break;
                }


                roundsWon+= 1; // predetermines 1 win, if statement will minus 1 if player loses.

                if (userChoice == botChoice) { // technique just put the tie and winning conditions, then else will be losing.
                    System.out.println("It's a tie!");
                    roundsWon-= 1;
                } else if ((userChoice == 0) & (botChoice == 2)) { // Player Rock, Bot Scissors
                    System.out.println("You Win!");
                } else if ((userChoice == 1) & (botChoice == 0)) { // Player Paper, Bot Rock
                    System.out.println("You Win!");
                } else if ((userChoice == 2) & (botChoice == 1)) { // Player Scissors, Bot Paper
                    System.out.println("You Win!");
                } else {
                    System.out.println("You lose.");
                    roundsWon-= 1;
                }

            } // Game End

            roundsLost = userRounds - roundsWon;
            score = roundsWon - roundsLost;

            System.out.printf("\f----- Match Results -----\nRounds Won: %d\nRounds Lost: %d\nScore: %d\n", roundsWon, roundsLost, score);
            System.out.print("\nWould you like to play again?\n1. Yes\n2. No\nChoice: ");
            retry = userInput.nextInt();

            if (retry == 2) {
                System.out.println("Thank you for playing!");
                break;
            } else if (retry == 1) {
                System.out.println("Clearing Memory...");
                roundsWon = 0;
                roundsLost = 0;
            }

        } // Menu Loop End
        
       userInput.close();     
    }
        /* Testing:
        for (int i = 0; i < 5; i++) {
            botChoice = randomNum.nextInt(3);
            System.out.println(botChoice);
        } */
        

}
