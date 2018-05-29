
import java.util.*;

public class RotatedArraySearch {
    // DO NOT MODIFY THE LIST
    public static int search(final List<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a.get(mid) == b) {
                return mid;
            }

            // if array was shifted to somewhere left of mid
            if (a.get(mid) < a.get(low)) {
                // if b is in the range between mid and high, shift right
                if (a.get(mid) < b && b <= a.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // array was shifted to somewhere right of mid
            else {
                // if b is in the range between low and mid, shift left
                if (a.get(low) <= b && b < a.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;

        // initial solution attempt
        // find partition index
        // int p = getPartition(a, 0, a.size() - 1);
        // use partition index to binary search
        // if (a.get(p) <= b && b <= a.get(a.size() - 1)) {
        //     return binarySearch(a, b, p, a.size() - 1);
        // }
        // return binarySearch(a, b, 0, p - 1);
    }

    public static int binarySearch(List<Integer> list, int toFind, int low, int high) {
        System.out.println("low: " + low + ", high: " + high + ", toFind: " + toFind);
        if (low >= high) {
            if (list.get(low) == toFind) {
                return low;
            }
            return -1;
        }

        int mid = (high + low) / 2;

        // shift left
        if (toFind < list.get(mid)) {
            return binarySearch(list, toFind, low, mid);
        }
        // shift right
        if (toFind > list.get(mid)) {
            return binarySearch(list, toFind, mid + 1, high);
        }

        return mid;
    }

    public static int getPartition(List<Integer> list, int low, int high) {
        if (list.size() <= 1 || low >= high) {
            return low;
        }

        int mid = (high + low) / 2;
        // System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);

        // shift left
        if (list.get(mid) < list.get(low)) {
            return getPartition(list, low, mid);
        }
        // shift right
        else if (list.get(mid) > list.get(high)) {
            return getPartition(list, mid + 1, high);
        }

        return low;
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(0);
        test.add(1);
        printList(test);
        System.out.println("index of 3: " + search(test, 3));

        test.clear();
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        printList(test);
        System.out.println("index of 3: " + search(test, 3));
    }
}
