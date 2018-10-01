/*
the constructor takes a quota—the number of items that will be produced/consumed
    before terminating
each instance has a unique_id
has a toString() which returns a String of the form
    "Producerunique_id" or "Consumerunique_id"

run in a cycle until the quota has been reached
    produce an item and insert() it
    or
    remove() an item and consume it [consumption will do nothing]

before terminating
    print total number of items produced/consumed
        "Producerunique_id FINISHED producing quota items"
        or
        "Consumerunique_id FINISHED consuming quota items"
*/

public class Consumer<E> extends Thread {

    private int id;
    private int quota;
    private BoundedBuffer<Item> buffer;

    Consumer(int id, int quota, BoundedBuffer<Item> buffer) {
        this.id = id;
        this.quota = quota;
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (quota > 0) {
                Item item = buffer.remove(this);
                quota--;
            }
            System.out.println(toString() + " FINISHED consuming: " + 20 + " items");
        } catch (InterruptedException e) {
            System.out.println(this.toString() + " was interrupted");
        }
    }

    public String toString() {
        return "Consumer #" + id;
    }
}
