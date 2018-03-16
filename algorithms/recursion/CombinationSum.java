public class CombinationSum {
    private static int sumToFind;
    private static ArrayList<ArrayList<Integer>> combinations;

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> listToSearch, int target) {
        if(listToSearch == null || listToSearch.size() < 1) return new ArrayList<>();
        combinations = new ArrayList<>();
        Collections.sort(listToSearch);
        combinationSum(listToSearch, new ArrayList<Integer>(), 0, target);
        return combinations;
    }

    public static void combinationSum(ArrayList<Integer> listToSearch, ArrayList<Integer> chosen, int index, int target) {
        // printTab(chosen.size());
        // System.out.print("listToSearch: ");
        // for(int n : listToSearch) {
        //     System.out.print(n + " ");
        // }
        // System.out.print(", chosen: ");
        // for(int n : chosen) {
        //     System.out.print(n + " ");
        // }
        // System.out.println(", target: " + target);

        // base case
        if(target == 0) {
            if(!combinations.contains(chosen)) combinations.add(new ArrayList<Integer>(chosen));
            return;
        }

        for(int i = index; i < listToSearch.size(); i++) {
            if(target < listToSearch.get(i)) return;

            // choose
            // remove() instead of get() if you don't want to reuse values
            // and 'unchoose' the element from list to search
            Integer next = listToSearch.get(i);
            chosen.add(next);

            // explore
            combinationSum(new ArrayList<Integer>(listToSearch), new ArrayList<Integer>(chosen), i, target - next);

            // listToSearch.add(i, next);
            chosen.remove(chosen.size() - 1);
        }
    }

    public static void printTab(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(7);
        combinationSum(test, 7);
        for(ArrayList<Integer> list : combinations) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
}
