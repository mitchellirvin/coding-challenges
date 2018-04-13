// https://www.interviewbit.com/problems/word-ladder-i/

import java.util.*;

public class WordLadder {
    static class Node {
        int depth;
        String val;
        public Node(int depth, String val) { this.depth = depth; this.val = val; }
    }

	public static int ladderLength(String start, String end, ArrayList<String> dict) {
        if (start.length() == 0 || start.length() != end.length()) {
            return 0;
        } else if (start.equals(end)) {
            return 1;
        }

        Node node = null;
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.addAll(getSimilarStrings(new Node(1, start), dict, visited));

        while (queue.peekFirst() != null) {
            node = queue.pollFirst();
            visited.add(node.val);
            if (node.val.equals(end)) {
                return node.depth;
            }
            queue.addAll(getSimilarStrings(node, dict, visited));
        }

        return 0;
	}

	public static ArrayList<Node> getSimilarStrings(Node node, ArrayList<String> dict, HashSet<String> visited) {
        ArrayList<Node> similars = new ArrayList<>();
        for (String s : dict) {
            if (!visited.contains(s) && stringsAreSimilar(s, node.val)) {
                similars.add(new Node(node.depth + 1, s));
                visited.add(s);
            }
        }
        return similars;
	}

    // assumes strings are same length, constraint of problem statement
    // returns true if strings only have diff chars at a single index
    public static boolean stringsAreSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) != a.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static void printTabs(int n) {
        while (n > 0) {
            System.out.print("    ");
            n--;
        }
    }

    public static void printDict(ArrayList<String> dict) {
        System.out.println("\nDict: ");
        for (String s : dict) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        // dict.add("bb");
        // dict.add("ab");
        dict.add("hot");
        dict.add("hat");
        dict.add("dat");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("hit");
        dict.add("cog");

        // System.out.println("Similar to hit: ");
        // for (String s : getSimilarStrings("hit", dict, new HashSet<String>())) {
        //     System.out.print(s + " ");
        // }
        // System.out.println();

        printDict(dict);
        System.out.println("Distance from hit to cog: " + ladderLength("hit", "cog", dict));

        dict.clear();
        dict.add("bb");
        dict.add("bb");
        printDict(dict);
        System.out.println("Distance from bb to bb: " + ladderLength("bb", "bb", dict));

        dict.clear();
        dict.add("bb");
        dict.add("ab");
        printDict(dict);
        System.out.println("Distance from bb to ab: " + ladderLength("bb", "ab", dict));

        dict.clear();
        dict.add("baba");
        dict.add("abba");
        dict.add("aaba");
        dict.add("bbbb");
        dict.add("abaa");
        dict.add("abab");
        dict.add("aaab");
        dict.add("abba");
        dict.add("abba");
        dict.add("abba");
        dict.add("bbba");
        dict.add("aaab");
        dict.add("abaa");
        dict.add("baba");
        dict.add("baaa");
        dict.add("bbaa");
        dict.add("babb");
        printDict(dict);
        System.out.println("Distance from bbaa to babb: " + ladderLength("bbaa", "babb", dict));
    }
}
