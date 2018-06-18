// https://www.interviewbit.com/problems/length-of-last-word/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String[] words = A.split(" ");
        if(words.length == 0) return 0;
        return words[words.length - 1].length();
    }
}
