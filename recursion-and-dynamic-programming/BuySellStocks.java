import java.util.*;

public class BuySellStocks {
    // https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
    // functionally the same as the max distance problem within the arrays category
    public static int maxProfit(final List<Integer> A) {
        if (A.isEmpty() || A == null) {
            return 0;
        }

        int currentMin = A.get(0);
        int maxProfit = 0;
        for (int i = 0; i < A.size(); i++) {
            currentMin = Math.min(currentMin, A.get(i));
            maxProfit = Math.max(maxProfit, A.get(i) - currentMin);
        }

        return maxProfit;
    }

    // https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
    public static int maxProfitMultiTransaction(final List<Integer> A) {
        if (A.isEmpty() || A == null) {
            return 0;
        }

        int currentMin = A.get(0);
        int profit = 0;
        for (int i = 0; i < A.size(); i++) {
            int difference = A.get(i) - currentMin;
            if (difference > 0) {
                profit += difference;
                currentMin = A.get(i);
            }
            currentMin = Math.min(currentMin, A.get(i));
        }

        return profit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(4);
        test.add(1);
        test.add(6);
        test.add(3);
        test.add(9);
        // System.out.println("Max profit should be 8.");
        // System.out.println("Max profit returned is: " + maxProfit(test));

        test.clear();
        test.add(1);
        test.add(4);
        test.add(3);
        test.add(2);
        test.add(5);
        test.add(6);
        System.out.println("Max profit should be 7.");
        System.out.println("Max profit returned is: " + maxProfitMultiTransaction(test));
    }
}
