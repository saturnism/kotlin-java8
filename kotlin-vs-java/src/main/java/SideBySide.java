import java.nio.charset.StandardCharsets;

/**
 * Java Example
 */
public class SideBySide {
  public static void main(String[] args) {
    Car car = new Car("VW", "Passat", 2001);

    System.out.printf("%s, %s\n", car.getMake(), car.model);

    String name = "Ray";
    if (name == "Ray") {
      System.out.println("Your name is Ray!");
    }
  }

  // 1. Semicolons
  public void semicolons() {
    System.out.println("Hello from Java!");
  }

  // 2. Nullability
  public void nullpointers(String s) {
    byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
  }

  // 3. Data Class
  public static class Car {
    private final String make;
    private final String model;

    public String getMake() {
      return make;
    }

    public String getModel() {
      return model;
    }

    public int getYear() {
      return year;
    }

    private final int year;

    public Car(String make, String model, int year) {
      this.make = make;
      this.model = model;
      this.year = year;
    }
  }
}
