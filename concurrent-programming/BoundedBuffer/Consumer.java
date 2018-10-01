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

public class Consumer extends Thread {

    private int id;
    private int quota;

    Consumer(int id, int quota) {
        this.id = id;
        this.quota = quota;
    }

    public String toString() {
        return "Consumer #" + id;
    }
}
