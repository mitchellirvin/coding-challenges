import java.util.List;
import java.util.Arrays;
import java.util.*;

class Challenge {
  // root of morse code tree
  public static Node root;
  // arraylist to contain possiblities of String 'word'
  public static ArrayList<String> possibleNodes = new ArrayList<>();

  static class Node {
    String morse;
    String letter;
    Node left;
    Node right;

    // constructor
    public Node(String morse, String letter, Node left, Node right) {
      this.morse = morse;
      this.letter = letter;
      this.left = left;
      this.right = right;
    }

    // function to help create our morse code dichotomic search tree
    public void insert(Node nodeToInsert, int charIndex) {
      if(nodeToInsert.morse.charAt(charIndex) == '.') {
        if(this.left != null) this.left.insert(nodeToInsert, ++charIndex);
        else this.left = nodeToInsert;
      } else if(nodeToInsert.morse.charAt(charIndex) == '-') {
        if(this.right != null) this.right.insert(nodeToInsert, ++charIndex);
        else this.right = nodeToInsert;
      }
    }

    // function that will traverse morse tree, adding possible letters to our possibleNodes list
    public int findNode(Node currNode, String morse, int charIndex) {
      System.out.println("node: " + currNode.letter);

      // base case, end of morse string
      if(charIndex == morse.length() - 1) {
        if(morse.charAt(charIndex) == '.') possibleNodes.add(currNode.left.letter);
        else if(morse.charAt(charIndex) == '-') possibleNodes.add(currNode.right.letter);
        else {
          possibleNodes.add(currNode.left.letter);
          possibleNodes.add(currNode.right.letter);
        }

        return 0;
      }

      // traverse left
      else if(morse.charAt(charIndex) == '.' && currNode.left != null) {
        findNode(currNode.left, morse, ++charIndex);
      }
      // traverse right
      else if(morse.charAt(charIndex) == '-' && currNode.right != null) {
        findNode(currNode.right, morse, ++charIndex);
      }
      // hit a question mark, go both paths
      else {
        if(currNode.left != null) findNode(currNode.left, morse, ++charIndex);
        if(currNode.right != null) findNode(currNode.right, morse, charIndex);
      }

      return 0;
    }
  }

  // function to create a BST with the Morse Code dichotomic search table
  public static void populateMorseTree() {
    root = new Node("", "root", null, null);

    Node e = new Node(".", "E", null, null);
    Node a = new Node(".-", "A", null, null);
    Node r = new Node(".-.", "R", null, null);
    Node l = new Node(".-..", "L", null, null);
    Node w = new Node(".--", "W", null, null);
    Node p = new Node(".--.", "P", null, null);
    Node j = new Node(".---", "J", null, null);
    Node i = new Node("..", "I", null, null);
    Node s = new Node("...", "S", null, null);
    Node u = new Node("..-", "U", null, null);
    Node f = new Node("..-.", "F", null, null);
    Node h = new Node("....", "H", null, null);
    Node v = new Node("...-", "V", null, null);

    Node t = new Node("-", "T", null, null);
    Node n = new Node("-.", "N", null, null);
    Node d = new Node("-..", "D", null, null);
    Node b = new Node("-...", "B", null, null);
    Node x = new Node("-..-", "X", null, null);
    Node k = new Node("-.-", "K", null, null);
    Node c = new Node("-.-.", "C", null, null);
    Node y = new Node("-.--", "Y", null, null);
    Node m = new Node("--", "M", null, null);
    Node g = new Node("--.", "G", null, null);
    Node z = new Node("--..", "Z", null, null);
    Node q = new Node("--.-", "Q", null, null);
    Node o = new Node("---", "O", null, null);

    root.insert(e, 0);
    root.insert(i, 0);
    root.insert(a, 0);
    root.insert(s, 0);
    root.insert(u, 0);
    root.insert(f, 0);
    root.insert(h, 0);
    root.insert(v, 0);
    root.insert(r, 0);
    root.insert(l, 0);
    root.insert(w, 0);
    root.insert(p, 0);
    root.insert(j, 0);

    root.insert(t, 0);
    root.insert(n, 0);
    root.insert(d, 0);
    root.insert(b, 0);
    root.insert(x, 0);
    root.insert(k, 0);
    root.insert(c, 0);
    root.insert(y, 0);
    root.insert(m, 0);
    root.insert(g, 0);
    root.insert(o, 0);
    root.insert(z, 0);
    root.insert(q, 0);
  }

  // function to return List of characters that could be represented by the morse code input
  public static List<String> possibilities( String word ) {
    populateMorseTree();
    possibleNodes.clear();
    if(word.length() > 0) root.findNode(root, word, 0);
    return possibleNodes;
  }
}
