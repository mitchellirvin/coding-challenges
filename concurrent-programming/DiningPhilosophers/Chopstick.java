public class Chopstick {

  private final int id;
  private Philosopher heldBy = null;

  public Chopstick(int id) {
    this.id = id;
  }

  public String toString() {
    return "chopstick (" + id + ")";
  }

  synchronized public boolean pickUp(Philosopher p) {
    if (heldBy != null) {
      return false;
    }

    heldBy = p;
    return true;
  }

  synchronized public void putDown(Philosopher p) {
    if (heldBy != p) {
      throw new RuntimeException("Exception: " + p + " attempted to put " +
          "down a chopstick he wasn't holding.");
    }

    heldBy = null;
  }
}
