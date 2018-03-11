public class Solution {
    // DO NOT MODIFY THE STRING. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if(A.length() == 0 || B.length() == 0 || A.length() < B.length()) return -1;

        for(int i = 0; i <= A.length() - B.length(); i++) {
            if(A.substring(i, i + B.length()).equals(B)) return i;
        }

        return -1;
    }

    // without java String library functions
    public int strStr(final String A, final String B) {
        if(A.length() == 0 || B.length() == 0 || A.length() < B.length()) return -1;

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == B.charAt(0)) {
                for(int j = 0; j < B.length() && (i + j) < A.length(); j++) {
                    if(A.charAt(j + i) != B.charAt(j)) break;
                    else if(j == B.length() - 1) return i;
                }
            }
        }

        return -1;
    }
}
