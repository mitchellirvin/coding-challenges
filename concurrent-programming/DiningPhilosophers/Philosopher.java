import java.util.Random;

public class Philosopher extends Thread {

  static private Random random = new Random();

  private String name;
  private Chopstick leftStick;
  private Chopstick rightStick;

  private int eatingTime = 0;
  private int thinkingTime = 0;
  private int eatCount = 0;
  private int thinkCount = 0;

  public Philosopher(String name, Chopstick leftStick, Chopstick rightStick) {
    this.name = name;
    this.leftStick = leftStick;
    this.rightStick = rightStick;
  }

  public String toString() {
    return name + " ate " + eatCount + " times (" +
        eatingTime + " ms) and pondered " + thinkCount + " times (" +
        thinkingTime + "ms)";
  }

  public void run() {
    try {
      while (true) {
        thinkCount++;
        thinkingTime += doAction("think");

        boolean hasBothChopsticks = pickupChopsticks();
        // if we have both chopsticks, eat. otherwise return to thinking
        if (hasBothChopsticks) {
          eatCount++;
          eatingTime += doAction("eat");
          putdownChopsticks();
        }
      }
    } catch (InterruptedException e) {
      System.out.println(name + " was interrupted.");
    }
  }

  private int doAction(String act) throws InterruptedException {
    int timeActing = random.nextInt(4000) + 1000; // between 1 and 5 seconds

    System.out.println(name + " is beginning to " + act + " for " + timeActing + " milliseconds");
    sleep(timeActing);
    System.out.println(name + " is done " + act + "ing");

    return timeActing;
  }

  private boolean pickupChopsticks() {
    System.out.println(name + " wants right " + rightStick);

    boolean hasLeftStick = false;
    boolean hasRightStick = rightStick.pickUp(this);

    if (hasRightStick) {
      System.out.println(name + " has right " + rightStick);
      System.out.println(name + " wants left " + leftStick);

      hasLeftStick = leftStick.pickUp(this);
      if (hasLeftStick) {
        System.out.println(name + " has both left " + leftStick + " and right " + rightStick);
        // should return true, if we have both sticks.
        return hasLeftStick && hasRightStick;
      } else {
        System.out.println(name + " was unable to get the left " + leftStick);
        System.out.println(name + " politely returned right " + rightStick);
        rightStick.putDown(this);
      }
    } else {
      System.out.println(name + " was unable to get the right " + rightStick);
    }

    return hasLeftStick && hasRightStick;
  }

  private void putdownChopsticks() {
    rightStick.putDown(this);
    System.out.println(name + " finished using right " + rightStick);
    leftStick.putDown(this);
    System.out.println(name + " finished using left " + leftStick);
  }
}
