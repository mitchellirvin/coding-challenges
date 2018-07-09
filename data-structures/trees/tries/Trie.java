// https://www.hackerrank.com/challenges/ctci-contacts/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Trie {

    static class Node {
        Character nodeChar;
        boolean isCompleteWord;
        int completeWordsBeyondHere;
        HashMap<Character, Node> children;
        public Node(Character nodeChar, boolean isCompleteWord, int completeWordsBeyondHere) {
            this.nodeChar = nodeChar;
            this.isCompleteWord = isCompleteWord;
            this.completeWordsBeyondHere = completeWordsBeyondHere;
            this.children = new HashMap<Character, Node>();
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public void putChild(char c, boolean isCompleteWord) {
            children.putIfAbsent(c, new Node(c, isCompleteWord, 0));
        }
    }

    static class ContactsTrie {
        Node contacts;

        public ContactsTrie() {
            contacts = new Node('_', false, 0);
        }

        public void addName(String name) {
            Node iter = contacts;
            for(int i = 0; i < name.length(); i++) {
                // blaze a new path with the new suffix
                iter.putChild(name.charAt(i), (i == name.length() - 1));
                // move iter to the new child
                iter = iter.getChild(name.charAt(i));
                iter.completeWordsBeyondHere++;
            }
        }

        public int findPartial(String partial) {
            Node iter = contacts;

            // set iter to Node for final character in partial, or return 0 because prefix doesn't exist
            for(Character c : partial.toCharArray()) {
                iter = iter.getChild(c);
                if(iter == null) return 0;
            }

            return iter.completeWordsBeyondHere;
        }

        public void printTrie() {
            Node start = contacts;
            printTrieHelper(start, "");
        }

        public void printTrieHelper(Node current, String s) {
            for(Character c : current.children.keySet()) {
                if(current.getChild(c).isCompleteWord == true) {
                    System.out.println(s + c);
                }
                if(!current.getChild(c).children.isEmpty()) {
                    printTrieHelper(current.getChild(c), s + c);
                }
            }
        }
    }

    public static void main(String[] args) {
        ContactsTrie contacts = new ContactsTrie();
        contacts.addName("mitch");
        contacts.addName("mike");
        contacts.addName("michelle");

        contacts.printTrie();
        System.out.println("There are: " + contacts.findPartial("mi") + " starting with mi");
        System.out.println("There is: " + contacts.findPartial("mic") + " starting with mic");
    }
}
