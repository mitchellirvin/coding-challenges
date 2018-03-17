import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

    static abstract class Heap {
        public int capacity;
        public int size;
        public int[] items;

        public Heap() {
            this.capacity = 10;
            this.size = 0;
            this.items = new int[capacity];
        }

        public int getLeftChildIndex(int parentIndex) { return (2 * parentIndex) + 1; }
        public int getRightChildIndex(int parentIndex) { return (2 * parentIndex) + 2; }
        public int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

        public boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
        public boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
        public boolean hasParent(int index) { return getParentIndex(index) >= 0; }

        public int getLeftChild(int index) { return items[getLeftChildIndex(index)]; }
        public int getRightChild(int index) { return items[getRightChildIndex(index)]; }
        public int getParent(int index) { return items[getParentIndex(index)]; }

        public void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        public void ensureCapacity() {
            if(size == capacity) {
                items = Arrays.copyOf(items, capacity * 2);
                capacity *= 2;
            }
        }

        public int peek() {
            if(size == 0) throw new IllegalStateException("You're trying to peek at an empty heap, you chimp.");
            return items[0];
        }

        public int poll() {
            if(size == 0) throw new IllegalStateException("You're trying to poll an empty heap, you chimp.");
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        abstract public void heapifyUp();

        abstract public void heapifyDown();

        public void add(int item) {
            ensureCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }
    }

    static class MinHeap extends Heap {
        public MinHeap() { super(); }

        public void heapifyUp() {
            int index = size - 1;
            // System.out.println("Index: " + index);
            // System.out.println("has parent: " + hasParent(index));
            // System.out.println(getParent(index) + " > " + items[index]);
            while(hasParent(index) && getParent(index) > items[index]) {
                swap(index, getParentIndex(index));
                // System.out.println("Swapping: " + items[index] + " with " + items[getParentIndex(index)]);
                index = getParentIndex(index);
            }
        }

        public void heapifyDown() {
            int index = 0;
            while(hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if(hasRightChild(index) && getLeftChild(index) > getRightChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if(items[index] < items[smallerChildIndex]) break;
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    static class MaxHeap extends Heap {
        public MaxHeap() { super(); }

        public void heapifyUp() {
            int index = size - 1;
            // System.out.println("Index: " + index);
            // System.out.println("has parent: " + hasParent(index));
            // System.out.println(getParent(index) + " < " + items[index]);
            while(hasParent(index) && getParent(index) < items[index]) {
                swap(index, getParentIndex(index));
                // System.out.println("Swapping: " + items[index] + " with " + items[getParentIndex(index)]);
                index = getParentIndex(index);
            }
        }

        public void heapifyDown() {
            int index = 0;
            while(hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if(hasRightChild(index) && getLeftChild(index) < getRightChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if(items[index] > items[smallerChildIndex]) break;
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    public static double roundToSingleDecimal(double value) {
        return (double) Math.round(value * 10) / 10;
    }

    public static void addToSmallestHeap(int next, Heap smallHalf, Heap largeHalf) {
        if(smallHalf.size > largeHalf.size) largeHalf.add(next);
        else smallHalf.add(next);
    }

    public static void addToSmallHalf(int next, Heap smallHalf, Heap largeHalf) {
        if(smallHalf.size > largeHalf.size) largeHalf.add(smallHalf.poll());
        smallHalf.add(next);
    }

    public static void addToLargeHalf(int next, Heap smallHalf, Heap largeHalf) {
        if(largeHalf.size > smallHalf.size) smallHalf.add(largeHalf.poll());
        largeHalf.add(next);
    }

    public static double getMedian(Heap smallHalf, Heap largeHalf) {
        if(smallHalf.size == 0) return (double) largeHalf.peek();
        else if((largeHalf.size + smallHalf.size) % 2 == 1) {
            return roundToSingleDecimal((smallHalf.size < largeHalf.size) ?
                                 (double) largeHalf.peek() : (double) smallHalf.peek());
        }
        else return roundToSingleDecimal((double) (largeHalf.peek() + smallHalf.peek()) / 2);
    }

    public static void main(String[] args) {
        int[] array = new int[6];
        array[0] = 12;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 8;
        array[5] = 7;

        Heap smallHalf = new MaxHeap();
        Heap largeHalf = new MinHeap();
        double median = 0;

        for(int i = 0; i < 6; i++){
            int next = array[i];

            if(largeHalf.size == 0) largeHalf.add(next);
            else if(smallHalf.size == 0) {
                if(largeHalf.peek() < next) {
                    smallHalf.add(largeHalf.poll());
                    largeHalf.add(next);
                } else smallHalf.add(next);
            } else {
                if(next < median) {
                    addToSmallHalf(next, smallHalf, largeHalf);
                } else if(next > median) {
                    addToLargeHalf(next, smallHalf, largeHalf);
                } else addToSmallestHeap(next, smallHalf, largeHalf);
            }

            median = getMedian(smallHalf, largeHalf);

            System.out.println(median);
        }
    }
}
