import java.util.*;

public class GetModeAfterUpdates  {
    public static ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, Integer> intToCountMap = buildMap(A);
        printMap(intToCountMap);
        ArrayList<Integer> modes = new ArrayList<>();

        for (ArrayList<Integer> update : B) {
            decrementMap(intToCountMap, A.get(update.get(0) - 1));
            A.set(update.get(0) - 1, update.get(1));
            incrementMap(intToCountMap, update.get(1));

            System.out.println("New map after update: ");
            printMap(intToCountMap);
            int mode = getMode(intToCountMap);
            System.out.println("mode: " + mode);
            modes.add(mode);
        }

        return modes;
    }

    public static void decrementMap(HashMap<Integer, Integer> intToCountMap, int oldKey) {
        intToCountMap.put(oldKey, intToCountMap.get(oldKey) - 1);
        if (intToCountMap.get(oldKey) == 0) {
            intToCountMap.remove(oldKey);
        }
    }

    public static void incrementMap(HashMap<Integer, Integer> intToCountMap, int newKey) {
        if (!intToCountMap.containsKey(newKey)) {
            intToCountMap.put(newKey, 1);
        } else {
            intToCountMap.put(newKey, intToCountMap.get(newKey) + 1);
        }
    }

    public static int getMode(HashMap<Integer, Integer> intToCountMap) {
        int min = Integer.MAX_VALUE;
        int mode = 0;

        for (int key : intToCountMap.keySet()) {
            if (intToCountMap.get(key) > mode) {
                min = key;
                mode = intToCountMap.get(key);
            } else if (intToCountMap.get(key) == mode) {
                if (key < min) {
                    min = key;
                    mode = intToCountMap.get(key);
                }
            }
        }

        return min;
    }

    public static HashMap<Integer, Integer> buildMap(ArrayList<Integer> A) {
        HashMap<Integer, Integer> intToCountMap = new HashMap<>();
        for (int n : A) {
            if (!intToCountMap.containsKey(n)) {
                intToCountMap.put(n, 1);
            } else {
                intToCountMap.put(n, intToCountMap.get(n) + 1);
            }
        }
        return intToCountMap;
    }

    public static void printMap(HashMap<Integer, Integer> intToCountMap) {
        for (int key : intToCountMap.keySet()) {
            System.out.println(key + ": " + intToCountMap.get(key));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
        ArrayList<Integer> update = new ArrayList<>();
        update.add(1);
        update.add(3);
        updates.add(new ArrayList<Integer>(update));
        update.clear();
        update.add(5);
        update.add(4);
        updates.add(new ArrayList<Integer>(update));
        update.clear();
        update.add(2);
        update.add(4);
        updates.add(new ArrayList<Integer>(update));

        getMode(list, updates);
    }
}
