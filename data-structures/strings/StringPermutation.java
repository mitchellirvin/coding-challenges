public class StringPermutation {
    public static void printTabs(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void permute(String s) {
        permute(s, "");
    }

    public static void permute(String s, String prefix) {
        printTabs(prefix.length());
        System.out.print(s + ", " + prefix);
        System.out.println();
        if(s.length() == 0) {
            printTabs(prefix.length());
            System.out.println(prefix);
        }
        else {
            for(int i = 0; i < s.length(); i++) {
                printTabs(prefix.length());
                // choose character i (by removing i chars from s)
                String remaining = s.substring(0, i) + s.substring(i + 1);
                permute(remaining, prefix + s.charAt(i));
                // replace first i characters
            }
        }
    }

    public static void main(String[] args) {
        permute("tori");
    }
}
