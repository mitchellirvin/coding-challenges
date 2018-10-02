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
        while (quota > 0) {
            Item item = buffer.remove(this);
            quota--;
        }
        System.out.println(toString() + " FINISHED consuming: " + 20 + " items");
    }

    public String toString() {
        return "Consumer #" + id;
    }
}
