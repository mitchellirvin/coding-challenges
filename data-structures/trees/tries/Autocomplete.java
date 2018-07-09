/**
Implement an autocomplete system.
That is, given a query string s and a set of all possible query strings,
return all strings in the set that have s as a prefix.

For example, given the query string "de" and the set of strings
[dog, deer, deal], return [deer, deal].
*/

import java.util.HashMap;
import java.util.ArrayList;

public class Autocomplete {

    static class Trie {
        private TrieNode words;

        public Trie() {
            words = new TrieNode('_', false, 0);
        }

        public void insert(String s) {
            TrieNode iter = words;

            for (int i = 0; i < s.length(); i++) {
                // blaze a new path with the new suffix
                iter.putChild(s.charAt(i), (i == s.length() - 1));
                // move iter to the new child
                iter = iter.getChild(s.charAt(i));
                iter.completeWordsBeyondHere++;
            }
        }

        public ArrayList<String> wordsWithPrefix(String prefix) {
            ArrayList<String> wordsThatMatch = new ArrayList<>();

            TrieNode iter = words;

            // navigate to last character in prefix
            for (char c : prefix.toCharArray()) {
                iter = iter.getChild(c);

                if (iter == null) {
                    return wordsThatMatch;
                }
            }

            // add each word beneath iter to the arraylist
            wordsWithPrefixHelper(iter, prefix, wordsThatMatch);

            return wordsThatMatch;
        }

        public static void wordsWithPrefixHelper(TrieNode node, String word,
                ArrayList<String> wordsThatMatch) {
            TrieNode child = null;

            for (char c : node.children.keySet()) {
                child = node.children.get(c);
                wordsWithPrefixHelper(child, word + child.nodeChar, wordsThatMatch);
            }

            if (node.isCompleteWord) {
                wordsThatMatch.add(word);
            }
        }

        public void printTrie() {
            TrieNode start = words;
            System.out.println("Trie contains: ");
            printTrieHelper(start, "");
            System.out.println();
        }

        public void printTrieHelper(TrieNode current, String s) {
            for (Character c : current.children.keySet()) {
                if (current.getChild(c).isCompleteWord == true) {
                    System.out.println(s + c);
                }
                if (!current.getChild(c).children.isEmpty()) {
                    printTrieHelper(current.getChild(c), s + c);
                }
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dog");
        trie.insert("deal");
        trie.insert("deer");
        trie.printTrie();

        System.out.print("Words that match \"de\": ");
        System.out.println(trie.wordsWithPrefix("de"));

        System.out.print("Words that match \"deer\": ");
        System.out.println(trie.wordsWithPrefix("deer"));

        System.out.print("Words that match \"\": ");
        System.out.println(trie.wordsWithPrefix(""));
    }

}
