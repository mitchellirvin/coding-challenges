import java.util.*;

public class Subsets {
    private static ArrayList<ArrayList<Integer>> combinations;

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> list) {
        combinations = new ArrayList<>();
        if(list.size() == 0 || list == null) {
            // System.out.print("empty list");
            combinations.add(new ArrayList<>());
            return combinations;
        }

        ArrayList<Integer> chosen = new ArrayList<>();

        Collections.sort(list, Collections.reverseOrder());
        subsetsWithDup(list, chosen);

        Collections.sort(combinations, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return combinations;
    }

    public static void subsetsWithDup(ArrayList<Integer> list, ArrayList<Integer> chosen) {
        if(list.isEmpty()) {
            Collections.sort(chosen);
            if(!combinations.contains(chosen)) combinations.add(chosen);
        } else {
            // choose
            int next = list.remove(0);

            // explore with current value
            // chosen.add(next);
            subsetsWithDup(new ArrayList<Integer>(list), new ArrayList<Integer>(chosen));

            // explore without current value
            // chosen.remove(chosen.size() - 1);
            chosen.add(next);
            subsetsWithDup(new ArrayList<Integer>(list), new ArrayList<Integer>(chosen));


            // do not need to "unchoose" here
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        subsetsWithDup(test);

        for(ArrayList<Integer> list : combinations) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
