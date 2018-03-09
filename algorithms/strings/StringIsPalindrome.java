public class StringIsPalindrome {
    // O(n)
    public static int isPalindrome(String A) {
        String forward = "";
        String reverse = "";
        char curr = ' ';
        for(int i = 0; i < A.length(); i++) {
            char c = Character.toLowerCase(A.charAt(i));
            if((97 <= c && c <= 122) || (48 <= c && c <= 57)) forward += c;
        }
        for(int i = A.length() - 1; i >= 0; i--) {
            char c = Character.toLowerCase(A.charAt(i));
            if((97 <= c && c <= 122) || (48 <= c && c <= 57)) reverse += c;
        }

        System.out.println("forward: " + forward + ", reverse: " + reverse);
        if(forward.equals(reverse)) return 1;
        else return 0;
    }

    public static int fastIsPalindrome(String A) {
        A = A.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        for(int i = 0; i < A.length() / 2; i++){
            if(A.charAt(i) != A.charAt(A.length() - 1 - i)) return 0;
        }
        
        return 1;
    }

    public static void main(String[] args) {
      isPalindrome("A man, a plan, a canal: Panama");
      isPalindrome("a racecar");
    }
}
