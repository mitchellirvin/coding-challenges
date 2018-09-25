// Dining Philosophers- a classic synchronization problem
// Built based on skeleton by Dave Small on 200506.15
// [based on DiningPhiliphers.java v4.0]

import java.util.Random;

class DiningPhilosophers {

  public static void main(String[] arg) {
    new DiningPhilosophers(5, 10000);
  }

  private String[] name = {"Seneca", "Aristotle", "Epicurius", "Voltaire",
      "Kant", "Machiavelli", "Nietzsche", "Socrates", "Frege", "Hume"};

  private Philosopher[] thinkers;
  private Chopstick[] chopsticks;

  public DiningPhilosophers(int numPhilosophers, int duration) {
    initialize(numPhilosophers);  // construct the philosophers & chopsticks
    startSimulation();
    sleep(duration);              // let simulation run for desired time
    shutdownPhilosophers();         // *gracefully* shut down the philosophers
    printResults();
  }

  // handles 2 to 10 philosophers
  private void initialize(int n) {
    if (n > 10) {
      n = 10;
    } else if (n < 2) {
      n = 2;
    }

    thinkers = new Philosopher[n];
    chopsticks = new Chopstick[n];

    for (int i = 0; i < n; i++) {
      chopsticks[i] = new Chopstick(i);
    }

    for (int i = 0; i < n; i++) {
      thinkers[i] = new Philosopher(name[i], chopsticks[i], chopsticks[(i + 1) % n]);
    }
  }

  private void startSimulation() {
    int n = thinkers.length; // the number of philosophers

    System.out.print("Our " + n + " philosophers (");
    for (int i = 0; i < (n - 1); i++) {
      System.out.print(name[i] + ", ");
    }
    System.out.println("and " + name[n - 1] + ") have gathered to think and dine");
    System.out.println("-----------------------------------------------");

    for (int i = 0; i < n; i++) {
      thinkers[i].start();
    }
  }

  private void sleep(int duration) {
    try {
      Thread.currentThread().sleep(duration);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void shutdownPhilosophers() {
    for (Philosopher p : thinkers) {
      p.interrupt();
    }
  }

  private void printResults() {
    System.out.println("-----------------------------------------------");

    int n = thinkers.length; // the number of philosophers

    for (int i = 0; i < n; i++) {
      System.out.println(thinkers[i]);
    }

    System.out.flush();
  }
}
