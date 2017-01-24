import java.io.IOException;
import java.util.Scanner;

public class Prompter {

  private String name;
  private String nameOfItem;
  private int max;
  Scanner input = new Scanner(System.in);
  private Jar jar;

  public Prompter() {

  }

  public void jarSetup() {
    boolean isPositive = false;

    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("======================");

    // Asks for your username input
    System.out.print("Enter your username: ");
    name = input.nextLine();

    // Asks for your item nameOfItem input
    System.out.print("Name of items in the jar: ");
    nameOfItem = input.nextLine();

    // Asks for the number of your items, if the number is not valid it repeats
    do {
      System.out.printf("Maximum number of %s in the jar: ", nameOfItem);
      try {
        max = input.nextInt();
        isPositive = true;
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again." + iae.getMessage());
      }
    } while (!isPositive);
    jar = new Jar(nameOfItem, max);
    jar.setChallenger(name);
    jar.fill();
  }

  public void startTheGame() {
    //Creating a variable to check for the searched number,input,
    boolean isGuessed = false;
    boolean isPositive = false;

    // Explains the user the rules and starts with the guessing
    System.out.println("\n\n" + jar.getChallenger());
    System.out.println("======================");
    System.out.printf(
        "Your goal is to guess how many %s are in the jar. Your guess should be between 1 and %d\n",
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


  public static void promptEnterKey() {
    System.out.println("Ready? (press \"ENTER\" to star guessing)");
    try {
      int read = System.in.read(new byte[2]);
    } catch (IOException e) {
      e.getMessage();
    }
  }
}
