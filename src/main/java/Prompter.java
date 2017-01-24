import java.io.IOException;
import java.util.Scanner;

public class Prompter {

  private String name;
  private String nameOfItem;
  private int max;
  private int numberOfGuesses = 0;
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
      System.out.printf("Maximum number of %s(s) in the jar: ", nameOfItem);
      try {
        max = input.nextInt();
        jar = new Jar(nameOfItem, max);
        isPositive = true;
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again." + iae.getMessage());
      }
    } while (!isPositive);

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
        "Your goal is to guess how many %s(s) are in the jar. Your guess should be between 1 and %d.\n",
        jar.getItem(),
        jar.getMaxNumberOfItemsInTheJar());
    promptEnterKey();

    // Checks the guess for a valid number and if your guess is right
    do {
      System.out.printf("How many %s(s) are in the jar? Pick a number between 1 and %d: ",
          jar.getItem(),
          jar.getMaxNumberOfItemsInTheJar());
      try {
        isGuessed = check(input.nextInt());
        isPositive = true;
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again. " + iae.getMessage());
      }
    } while (!isGuessed || !isPositive);

    System.out.printf("Congrats you needed %d attempt(s) to guess it.", numberOfGuesses);
  }

  // Checks if the guess is higher or lower than the searched number
  public void higherOrLower(int guess) {
    if (guess > jar.getRandomNumberOfItemsInTheJar()) {
      System.out.println("Your guess is too high.");
    } else {
      System.out.println("Your guess is too low.");
    }
  }


  public static void promptEnterKey() {
    System.out.println("Ready? (press \"ENTER\" to start guessing)");
    try {
      int read = System.in.read(new byte[2]);
    } catch (IOException e) {
      e.getMessage();
    }
  }

  // Checks if the guess is right, throws Exception if the input is bellow 0 or higher than the maximum
  public boolean check(int guess) {
    if (guess <= 0) {
      throw new IllegalArgumentException(
          "The guess should be a positive number and bigger than 0.");
    } else if (guess > jar.getMaxNumberOfItemsInTheJar()) {
      throw new IllegalArgumentException(
          "Your guess must be equal or less than " + jar.getMaxNumberOfItemsInTheJar() + " .");
    } else {
      numberOfGuesses++;
      if (guess == jar.getRandomNumberOfItemsInTheJar()) {
        return true;
      } else {
        higherOrLower(guess);
        return false;
      }
    }
  }
}
