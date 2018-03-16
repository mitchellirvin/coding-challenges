import java.util.*;

public class GetCombinations {
    private static ArrayList<ArrayList<Integer>> combinations;

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        if(B > A) return new ArrayList<ArrayList<Integer>>();
        combinations = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= A; i++) list.add(i);
        ArrayList<Integer> chosen = new ArrayList<>();

        findCombinations(list, chosen, B);
        return combinations;
    }

    public static void printTab(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void findCombinations(ArrayList<Integer> list, ArrayList<Integer> chosen, int sizeOfCombo) {
        if(list.isEmpty()) {
            // add to beginning for lexicographical sorting
            if(chosen.size() == sizeOfCombo) combinations.add(0, chosen);
        } else {
            // choose
            int next = list.remove(0);

            // explore without current value
            findCombinations(new ArrayList<Integer>(list), new ArrayList<Integer>(chosen), sizeOfCombo);
            // explore with current value
            chosen.add(next);
            findCombinations(new ArrayList<Integer>(list), new ArrayList<Integer>(chosen), sizeOfCombo);

            // do not need to "unchoose" here
        }
    }

    public static void main(String[] args) {
        combine(4, 2);
        for(ArrayList<Integer> list : combinations) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.print(" | ");
        }
    }
}
