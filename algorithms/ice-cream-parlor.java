import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int flavors = in.nextInt();
            Map<Integer, Integer> complements = new HashMap<>();

            for(int i = 1; i <= flavors; i++) {
                int cost = in.nextInt();
                if(complements.containsKey(cost)) System.out.println(complements.get(cost) + " " + i);
                else complements.put(money - cost, i);
            }
        }
        in.close();
    }
}
