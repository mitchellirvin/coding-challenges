// Complete, non-busy waiting BoundedBuffer implementation
public class BoundedBuffer<E> {

    private E[] buffer;
    private int size = 0;

    BoundedBuffer(int length) {
        buffer = (E[]) new Object[length];
    }

    public synchronized void insert(E item, Producer producer) {
        waitUntilBufferIsNotFull(producer, item);
        insertItem(producer, item);
        notifyAll();
    }

    public synchronized E remove(Consumer consumer) {
        waitUntilBufferIsNotEmpty(consumer);
        E removedItem = removeItem(consumer);
        notifyAll();
        return removedItem;
    }

    private void waitUntilBufferIsNotFull(Producer producer, E item) {
        try {
            while (size == buffer.length) {
                System.out.println(producer.toString() + " waiting to insert "
                    + item.toString());
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(producer.toString() + " was interrupted");
        }
    }

    private void insertItem(Producer producer, E item) {
        buffer[size] = item;
        size++;
        System.out.println(producer.toString() + " inserted " + item.toString()
            + " (" + size + " of " + buffer.length + " slots full)");
    }

    private void waitUntilBufferIsNotEmpty(Consumer consumer) {
        try {
            while (size == 0) {
                System.out.println(consumer.toString() + " waiting to remove item");
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(consumer.toString() + " was interrupted");
        }
    }

    private E removeItem(Consumer consumer) {
        E removedItem = buffer[size - 1];
        size--;
        System.out.println(consumer.toString() + " removed " + removedItem.toString()
            + " (" + size + " of " + buffer.length + " slots full)");
        return removedItem;
    }

    public String toString() {
        String s = "[";
        for (E item : buffer) {
            s += item + ", ";
        }
        return s + "]";
    }
}
