import java.util.HashMap;

public class TrieNode {
    Character nodeChar;
    boolean isCompleteWord;
    int completeWordsBeyondHere;
    HashMap<Character, TrieNode> children;

    public TrieNode(Character nodeChar, boolean isCompleteWord, int completeWordsBeyondHere) {
        this.nodeChar = nodeChar;
        this.isCompleteWord = isCompleteWord;
        this.completeWordsBeyondHere = completeWordsBeyondHere;
        this.children = new HashMap<Character, TrieNode>();
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public void putChild(char c, boolean isCompleteWord) {
        children.putIfAbsent(c, new TrieNode(c, isCompleteWord, 0));
    }
}
