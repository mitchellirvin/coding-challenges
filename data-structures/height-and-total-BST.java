// problem: https://www.hackerrank.com/contests/rookierank-4/challenges/height-and-total-height-of-a-bst
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // assumes root not null
        public void insert(Node nodeToInsert) {
            if(this.value < nodeToInsert.value) {
                if(this.right != null) this.right.insert(nodeToInsert);
                else this.right = nodeToInsert;
            } else if(this.value > nodeToInsert.value) {
                if(this.left != null) this.left.insert(nodeToInsert);
                else this.left = nodeToInsert;
            }
        }
    }

    static void inOrderTraversal(Node root) {
        if(root.left != null) inOrderTraversal(root.left);
        System.out.print(root.value + ", ");
        if(root.right != null) inOrderTraversal(root.right);
    }

    static int height(Node root) {
        if(root.left == null && root.right == null) return 0;

        if(root.left != null && root.right != null) return Math.max(1 + height(root.left), 1 + height(root.right));
        else if(root.left != null) return 1 + height(root.left);
        else return 1 + height(root.right);
    }

    static int totalHeight(Node node) {
        int height = 0;
        if(node.left != null) height += totalHeight(node.left);
        height += height(node);
        if(node.right != null) height += totalHeight(node.right);
        return height;
    }

    static int[] heightAndTotalHeight(int[] arr) {
        // Write your code here.
        Node root = new Node(arr[0], null, null);
        for(int i = 1; i < arr.length; i++) {
            root.insert(new Node(arr[i], null, null));
        }
        // inOrderTraversal(root);
        // System.out.println(height(root));
        // System.out.println(totalHeight(root));
        int[] retArr = new int[2];
        retArr[0] = height(root);
        retArr[1] = totalHeight(root);
        return retArr;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int arrSize = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[arrSize];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrSize; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;

        }

        int[] result = heightAndTotalHeight(arr);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
