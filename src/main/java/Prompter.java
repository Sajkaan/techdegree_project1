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

    // Asks for your item nameOfItem input
    System.out.print("What type of item?  ");
    nameOfItem = input.nextLine();

    // Asks for the number of your items
    System.out.printf("What is the maximum amount of %s?  ",nameOfItem);

    max = input.nextInt();
    jar = new Jar(nameOfItem, max);
    jar.fill();
    System.out.printf("How many %s are in the jar? Pick a number between 1 and %d. \n",
        jar.getItem(),
        jar.getMaxNumberOfItemsInTheJar());
  }

  public void startTheGame() {
    jarSetup();
    //Creating a variable to check if it is guessed
    boolean isGuessed = false;

    // Checks the guess for a valid number and if your guess is right
    do {
      try {
        System.out.print("\nGuess: ");
        isGuessed = check(input.nextInt());
      } catch (IllegalArgumentException iae) {
        System.out.println("Please try again. " + iae.getMessage());
      }
    } while (!isGuessed);

    System.out.printf("You got it in %d attempt(s).", numberOfGuesses);
  }

  // Checks if the guess is higher or lower than the searched number
  public void higherOrLower(int guess) {
    if (guess > jar.getRandomNumberOfItemsInTheJar()) {
      System.out.println("Your guess is too high.  Try again.");
    } else {
      System.out.println("Your guess is too low.  Try again.");
    }
    System.out.println(numberOfGuesses + " attempts.");
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
