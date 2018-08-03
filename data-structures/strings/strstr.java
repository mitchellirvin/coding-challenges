public class strStr {
    // DO NOT MODIFY THE STRING. IT IS READ ONLY
    // public int strStr(final String A, final String B) {
    //     if(A.length() == 0 || B.length() == 0 || A.length() < B.length()) return -1;
    //
    //     for(int i = 0; i <= A.length() - B.length(); i++) {
    //         if(A.substring(i, i + B.length()).equals(B)) return i;
    //     }
    //
    //     return -1;
    // }

    // without java String library functions
    public static int strStr(final String A, final String B) {
        if (A.length() == 0 || B.length() == 0 || A.length() < B.length()) {
            return -1;
        }

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                int end = 0;
                for (; end < B.length() && A.charAt(i + end) == B.charAt(end); end++);
                if (end == B.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String string = "mitchellest";
        String substring = "elle";
        System.out.println(string + ", searching for: " + substring);
        System.out.println("Found it: " + strStr(string, substring));
    }
}
