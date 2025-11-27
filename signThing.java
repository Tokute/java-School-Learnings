import java.util.Scanner;
// This basically just let's you choose a border for something that you want to print


// I might've wasted 2 hours making this

public class signThing {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.print("What letter would you like to use for outer grid: ");
        char outerLetter = userInput.nextLine().charAt(0);

        System.out.print("\nWhat would you like to print inside: ");
        String userString = userInput.nextLine();

        userInput.close();

        for (int rows = 0; rows < 5; rows++){
            for (int column = 0; column < (userString.length() + 3); column++) {
                if (column == 0) { // prints first outer grid column
                    if (!(rows == 0 | rows == 4)) {
                        System.out.print(outerLetter);
                    } else {
                        System.out.print(outerLetter);
                    }
                }

                if (!(rows == 2)) { // prints out the outer grid
                    if (!(rows == 1 | rows == 3)) { // this avoids printing in the rows above and below the user's input. Leaves blank space
                        System.out.print(outerLetter);
                    } else {
                        System.out.print(" ");
                    }
                    if ((column == userString.length() + 1) & (rows == 1 | rows == 3)) { // This prints the other grid which what the if statement earlier was trying to avoid.
                        System.out.print(outerLetter);
                    }
                }
            
                if ((column <= userString.length()) & rows == 2) { // creates last column
                    if (column == userString.length()) {
                    System.out.print(outerLetter); // prints out the middle right last letter
                    continue;
                } else if (column == 0) { // display user input in the middle row
                    System.out.print(" ");
                    for (int i = 0; i < userString.length(); i++) {
                    char currentChar = userString.charAt(i);
                    System.out.print(currentChar);
                    }
                    System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }
    }
}
