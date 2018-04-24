//

import java.util.*;

public class AllPalindromePartitions {
    static ArrayList<ArrayList<String>> palindromePartitions;

    public static ArrayList<ArrayList<String>> partition(String a) {
        palindromePartitions = new ArrayList<>();
        findParts(new ArrayList<String>(), a, 0, 1);
        return palindromePartitions;
    }

    public static void findParts(ArrayList<String> palindromes, String s,
        int lastPart, int curr) {

        if (curr > s.length() || lastPart >= s.length()) {
            palindromePartitions.add(new ArrayList<String>(palindromes));
            return;
        }

        for (int part = lastPart + 1; part <= s.length(); part++) {
            String next = s.substring(lastPart, part);
            if (isPalindrome(next)) {
                // choose
                palindromes.add(next);
                // explore
                findParts(new ArrayList<String>(palindromes), s, part, part + 1);
                // unchoose
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String A) {
        for(int i = 0; i < A.length() / 2; i++){
            if(A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void printPartitions() {
        for (ArrayList<String> palindromes : palindromePartitions) {
            for (String palindrome : palindromes) {
                System.out.print(palindrome + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        partition("aabbcee");
        printPartitions();
    }
}
