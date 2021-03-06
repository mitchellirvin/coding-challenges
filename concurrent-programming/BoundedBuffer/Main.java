// Demo for Bounded buffer
public class Main {

    public static void main(String[] args) {
        BoundedBuffer<Item> buffer = new BoundedBuffer<Item>(5);
        Producer producer1 = new Producer(1, 20, buffer);
        Producer producer2 = new Producer(2, 20, buffer);
        Consumer consumer1 = new Consumer(1, 20, buffer);
        Consumer consumer2 = new Consumer(2, 20, buffer);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        // do not interrupt because each Producer/Consumer runs for a fixed quota
    }
}
