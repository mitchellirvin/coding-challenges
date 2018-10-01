/*
void insert( E item, Producer p )
    when there is no space available (before the producer blocks) print
        p.toString() waiting to insert item.toString()
    after adding the item to the backing store print
        p.toString() inserted item.toString() (m of n slots full)

E remove( Consumer c )
    when there is no item available (before the consumer blocks) print
        c.toString() waiting to remove an item
    after removing an item from the backing store print
        c.toString() removed item.toString() (m of n slots full)

String toString()
    returns a square bracketed, comma separated string representing the buffer
    and its contents. non-empty slots will be denoted by the toString() value
    of that slot, while empty slots will be denoted by the string "---"; for
    example:
        [Item #393, ---, Item #395]
*/

public class BoundedBuffer <T, E> {

    private E[] buffer;
    private int size;

    BoundedBuffer() {
        buffer = (E[]) new Object[3];
        size = 0;
    }

    // producer should insert until buffer is full
    public synchronized void insert(E item, Producer producer) {
        try {
            while (size == buffer.length) {
                System.out.println(producer.toString() + " waiting to insert item "
                    + item.toString());
                wait();
            }

            buffer[size] = item;
            size++;
            System.out.println(producer.toString() + " inserted item " + item.toString()
                + " (" + size + " of " + buffer.length + " slots full)");
            notify();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    // consumer should remove until buffer is empty
    public synchronized E remove(Consumer consumer) {
        try {
            while (size == 0) {
                System.out.println(consumer.toString() + " waiting to remove item");
                wait();
            }

            E removedItem = buffer[size];
            size--;
            System.out.println(consumer.toString() + " removed item " + removedItem.toString()
                + " (" + size + " of " + buffer.length + " slots full)");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        return removedItem;
    }

    public String toString() {
        return "";
    }
}
