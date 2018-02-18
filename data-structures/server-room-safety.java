// problem: https://www.hackerrank.com/contests/rookierank-4/challenges/server-room-safety/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String checkAll(int numOfRacks, int[] heights, int[] positions) {
        boolean leftLiability = checkLeft(numOfRacks, heights, positions);
        boolean rightLiability = checkRight(numOfRacks, heights, positions);

        if(leftLiability && rightLiability) return "BOTH";
        else if(leftLiability) return "LEFT";
        else if(rightLiability) return "RIGHT";
        else return "NONE";
    }

    static boolean checkLeft(int numOfRacks, int[] heights, int[] positions) {
        int maxFall = positions[0] + heights[0];
        for(int i = 0; i < numOfRacks - 1; i++) {
            //System.out.println("maxfall: " + maxFall + ", position: " + positions[i]);
            if(maxFall < positions[i+1]) return false;
            if(positions[i+1] + heights[i+1] > maxFall) maxFall = positions[i+1] + heights[i+1];
        }
        return true;
    }

    static boolean checkRight(int numOfRacks, int[] heights, int[] positions) {
        int maxFall = positions[numOfRacks - 1] - heights[numOfRacks - 1];
        for(int i = numOfRacks - 1; i > 0; i--) {
            //System.out.println("maxfall: " + maxFall + ", position: " + positions[i]);
            if(maxFall > positions[i-1]) return false;
            if(positions[i-1] - heights[i-1] < maxFall) maxFall = positions[i-1] - heights[i-1];
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for(int position_i = 0; position_i < n; position_i++){
            position[position_i] = in.nextInt();
        }
        int[] height = new int[n];
        for(int height_i = 0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        String ret = checkAll(n, height, position);
        System.out.println(ret);
        in.close();
    }
}
