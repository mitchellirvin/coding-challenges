public class Producer extends Thread {

    private int id;
    private int quota;
    private BoundedBuffer<Item> buffer;

    Producer(int id, int quota, BoundedBuffer<Item> buffer) {
        this.id = id;
        this.quota = quota;
        this.buffer = buffer;
    }

    public void run() {
        int quotaRemaining = quota;
        while (quotaRemaining > 0) {
            quotaRemaining--;
            // janky calculation to get incremental Item IDs across Producers
            // assuming producer IDs increment by 1... I'm sorry for this...
            buffer.insert(new Item(((id - 1) * quota) + quota - quotaRemaining), this);
        }
        System.out.println(toString() + " FINISHED producing: " + 20 + " items");
    }

    public String toString() {
        return "Producer #" + id;
    }
}
