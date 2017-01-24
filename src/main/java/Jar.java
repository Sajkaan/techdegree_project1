import java.util.Random;

public class Jar {

  private String challenger;
  private String item;
  private int maxNumberOfItemsInTheJar;
  private int randomNumberOfItemsInTheJar;

  public Jar(String item, int maxNumberOfItemsInTheJar) {
    this.item = item;
    if (maxNumberOfItemsInTheJar <= 0) {
      throw new IllegalArgumentException("The number can't be negative or 0.");
    } else {
      this.maxNumberOfItemsInTheJar = maxNumberOfItemsInTheJar;
    }
  }

  public void setChallenger(String challenger) {
    this.challenger = challenger;
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


  // Inserts a random number in the jar
  public void fill() {
    Random random = new Random();
    this.randomNumberOfItemsInTheJar = random.nextInt(maxNumberOfItemsInTheJar) + 1;
  }
}
