import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long changeCombinations(int total, int[] coins) {
        return changeCombinations(total, coins, 0, new HashMap<String, Long>());
    }

    public static long changeCombinations(int total, int[] coins, int index, HashMap<String, Long> memo) {
        if(total == 0) return 1;
        if(index >= coins.length) return 0;

        String key = total + ":" + index;
        if(memo.containsKey(key)) return memo.get(key);

        int sumOfCurrentCoin = 0;
        long ways = 0;
        while(sumOfCurrentCoin <= total) {
            ways += changeCombinations(total - sumOfCurrentCoin, coins, index + 1, memo);
            sumOfCurrentCoin += coins[index];
        }

        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(changeCombinations(n, coins));
    }
}
