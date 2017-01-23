import java.util.Random;

public class Jar {

  private String challenger;
  private String item;
  private int maxNumberOfItemsInTheJar;
  private int randomNumberOfItemsInTheJar;
  private int numberOfGuesses = 0;

  public Jar() {
  }

  public void setChallenger(String challenger) {
    this.challenger = challenger;
  }

  public void setItem(String item) {
    this.item = item;
  }

  // Sets the maximum number and disables a negative number or 0
  public void setMaxNumberOfItemsInTheJar(int maxNumberOfItemsInTheJar) {
    if (maxNumberOfItemsInTheJar <= 0) {
      throw new IllegalArgumentException("The number can't be negative or 0.");
    } else {
      this.maxNumberOfItemsInTheJar = maxNumberOfItemsInTheJar;
    }
  }

  public String getChallenger() {
    return challenger;
  }

  public String getItem() {
    return item;
  }

  public int getMaxNumberOfItemsInTheJar() {
    return maxNumberOfItemsInTheJar;
  }

  public int getRandomNumberOfItemsInTheJar() {
    return randomNumberOfItemsInTheJar;
  }

  public int getNumberOfGuesses() {
    return numberOfGuesses;
  }

  // Inserts a random number in the jar
  public void fill() {
    Random random = new Random();
    this.randomNumberOfItemsInTheJar = random.nextInt(maxNumberOfItemsInTheJar) + 1;
  }

  // Checks if the guess is right, throws Exception if the input is bellow 0 or higher than the maximum
  public boolean check(int guess) {
    if (guess <= 0) {
       throw new IllegalArgumentException("The guess should be a positive number and bigger than 0.");
    } else if (guess > maxNumberOfItemsInTheJar) {
      throw new IllegalArgumentException("Your guess must be less than " + maxNumberOfItemsInTheJar);
    }
    else {
      numberOfGuesses++;
      if (guess == randomNumberOfItemsInTheJar) {
        return true;
      } else {
        higherOrLower(guess);
        return false;
      }
    }
  }

  // Checks if the guess is higher or lower than the searched number
  public void higherOrLower(int guess) {
    if (guess > randomNumberOfItemsInTheJar) {
      System.out.println("Your guess is too high.");
    } else {
      System.out.println("Your guess is too low.");
    }
  }
}
