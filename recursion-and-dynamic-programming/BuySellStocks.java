// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
// functionally the same as the max distance problem within the arrays category

import java.util.*;

public class BuySellStocks {
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

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(4);
        test.add(1);
        test.add(6);
        test.add(3);
        test.add(9);
        System.out.println("Max profit should be 8.");
        System.out.println("Max profit returned is: " + maxProfit(test));
    }
}
