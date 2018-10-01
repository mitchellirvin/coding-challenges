// Demo for Bounded buffer

public class Main {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Producer producer1 = new Producer(1, 20);
        Producer producer2 = new Producer(2, 20);
        Consumer consumer1 = new Consumer(1, 20);
        Consumer consumer2 = new Consumer(2, 20);
    }
}
