import java.io.IOException;
import java.util.Scanner;

public class Prompter {

  private Jar jar;
  Scanner input = new Scanner(System.in);

  public Prompter(Jar jar) {
    this.jar = jar;
  }

  public void jarSetup() {
    boolean isPositive = false;

    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("======================");

    // Asks for your username input
    System.out.print("Enter your username: ");
    jar.setChallenger(input.nextLine());

    // Asks for your item name input
    System.out.print("Name of items in the jar: ");
    jar.setItem(input.nextLine());

    // Asks for the number of your items, if the number is not valid it repeats
    do {
      System.out.printf("Maximum number of %s in the jar: ", jar.getItem());
      try {
        jar.setMaxNumberOfItemsInTheJar(input.nextInt());
        isPositive = true;
      } catch(IllegalArgumentException iae){
        System.out.println("Please try again." + iae.getMessage());
      }
    } while(!isPositive);

    jar.fill();
  }

  public void startTheGame(){
    //Creating a variable to check for the searched number,input,
    boolean isGuessed = false;
    boolean isPositive = false;

    // Explains the user the rules and starts with the guessing
    System.out.println("\n\n" + jar.getChallenger());
    System.out.println("======================");
    System.out.printf("Your goal is to guess how many %s are in the jar. Your guess should be between 1 and %d\n",
        jar.getItem(),
        jar.getMaxNumberOfItemsInTheJar());
    promptEnterKey();

    // Checks the guess for a valid number and if your guess is right
    do {
      System.out.print("Guess: ");
      try {
        isGuessed = jar.check(input.nextInt());
        isPositive = true;
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again. " + iae.getMessage());
      }
    } while (!isGuessed || !isPositive);

    System.out.printf("Congrats you needed %d attempts to guess it.", jar.getNumberOfGuesses());
  }


  public static void promptEnterKey(){
    System.out.println("Ready? (press \"ENTER\" to star guessing)");
    try {
      int read = System.in.read(new byte[2]);
    } catch (IOException e) {
      e.getMessage();
    }
  }
}
