import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static int waysToClimb(int stairs) {
        if(stairs < 0) return 0;
        else if(stairs == 0) return 1;
        else if(!map.containsKey(stairs)) {
            map.put( stairs, (waysToClimb(stairs - 1) + waysToClimb(stairs - 2) + waysToClimb(stairs - 3)) );
        }
        return map.get(stairs);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(waysToClimb(n));
        }
    }
}
