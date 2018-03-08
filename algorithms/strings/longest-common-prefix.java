// https://www.interviewbit.com/problems/longest-common-prefix/

public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        String common = "";
        char c = '$';

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            for(int j = 0; j < A.size(); j++) {
                if(i >= A.get(j).length()) return common;
                // System.out.println(A.get(j).charAt(i));
                if(j == 0) c = A.get(j).charAt(i);
                else if(A.get(j).charAt(i) != c) return common;
            }
            common += c;
            // System.out.println(common);
        }

        return common;
    }
}
