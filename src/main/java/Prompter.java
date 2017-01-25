import java.util.Scanner;

public class Prompter {

  private String nameOfItem;
  private int max;
  private int numberOfGuesses = 0;
  Scanner input = new Scanner(System.in);
  private Jar jar;

  public Prompter() {
  }

  public void jarSetup() {

    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("======================");

    // Asks for your item nameOfItem input
    System.out.print("What type of item should go in the jar: ");
    nameOfItem = input.nextLine();

    // Asks for the number of your items
    System.out
        .printf("What is the maximum amount of %s(s) that should go in the jar: ", nameOfItem);

    max = input.nextInt();
    jar = new Jar(nameOfItem, max);
    jar.fill();
  }

  public void startTheGame() {
    jarSetup();
    //Creating a variable to check if it is guessed
    boolean isGuessed = false;

    // Explains the user the rules and starts with the guessing
    System.out.println("PLAYER");
    System.out.println("======================");
    System.out.print("Welcome to the guessing game!\n");

    // Checks the guess for a valid number and if your guess is right
    do {
      System.out.printf("How many %s(s) are in the jar? Pick a number between 1 and %d: ",
          jar.getItem(),
          jar.getMaxNumberOfItemsInTheJar());
      try {
        isGuessed = check(input.nextInt());
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again. " + iae.getMessage());
      }
    } while (!isGuessed);

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

  // Checks if the guess is right, throws Exception if the input higher than the maximum
  public boolean check(int guess) {
    if (guess > jar.getMaxNumberOfItemsInTheJar()) {
      throw new IllegalArgumentException(
          "Your guess must be less than " + jar.getMaxNumberOfItemsInTheJar() + " .");
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
