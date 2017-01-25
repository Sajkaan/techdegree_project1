import java.util.Random;

public class Jar {

  private String item;
  private int maxNumberOfItemsInTheJar;
  private int randomNumberOfItemsInTheJar;

  public Jar(String item, int maxNumberOfItemsInTheJar) {
    this.item = item;
    this.maxNumberOfItemsInTheJar = maxNumberOfItemsInTheJar;
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
