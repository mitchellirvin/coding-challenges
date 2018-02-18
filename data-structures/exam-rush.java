// problem: https://www.hackerrank.com/contests/rookierank-4/challenges/exam-rush
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int examRush(int[] hoursPerChapter, int hoursLeft) {
        Arrays.sort(hoursPerChapter);

        int hoursStudied = 0;
        int chaptersStudied = 0;
        for(int i = 0; i < hoursPerChapter.length; i++) {
            if(hoursStudied + hoursPerChapter[i] <= hoursLeft) hoursStudied += hoursPerChapter[i];
            else {
                chaptersStudied = i;
                break;
            }
        }

        return chaptersStudied;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] tm = new int[n];
        for(int tm_i = 0; tm_i < n; tm_i++){
            tm[tm_i] = in.nextInt();
        }
        int result = examRush(tm, t);
        System.out.println(result);
        in.close();
    }
}
