import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int evenTree(int n, int m, int[][] tree) {
        HashMap<Integer, ArrayList<Integer>> treeMap = buildTreeMap(tree);
        int edges = 0;

        for(Integer key : treeMap.keySet()) {
            // check if current node is a branch of even number
            if((getNodeChildren(key, treeMap) + 1) % 2 == 0 &&
               (getNodeChildren(key, treeMap) + 1) >= 2 &&
               hasParent(key, treeMap)) {
                edges++;
            }
        }

        return edges;
    }

    static int getNodeChildren(int key, HashMap<Integer, ArrayList<Integer>> treeMap) {
        int children = 0;

        if(treeMap.containsKey(key)) {
            for(int value : treeMap.get(key)) {
                if(!treeMap.containsKey(value)) children += 1;
                else children += 1 + getNodeChildren(value, treeMap);
            }
        }

        return children;
    }

    static HashMap<Integer, ArrayList<Integer>> buildTreeMap(int[][] tree) {
        HashMap<Integer, ArrayList<Integer>> treeMap = new HashMap<>();

        for(int i = 0; i < tree.length; i++) {
            if(treeMap.containsKey(tree[i][1])) treeMap.get(tree[i][1]).add(tree[i][0]);
            else {
                ArrayList<Integer> ithList = new ArrayList<>();
                ithList.add(tree[i][0]);
                treeMap.put(tree[i][1], ithList);
            }
        }

        return treeMap;
    }

    static boolean hasParent(int Node, HashMap<Integer, ArrayList<Integer>> treeMap) {
        for(Integer key : treeMap.keySet()) {
            for(Integer value : treeMap.get(key)) {
                if(Node == value) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] tree = new int[m][2];
        for(int tree_i = 0; tree_i < m; tree_i++){
            for(int tree_j = 0; tree_j < 2; tree_j++){
                tree[tree_i][tree_j] = in.nextInt();
            }
        }
        int result = evenTree(n, m, tree);
        System.out.println(result);
        in.close();
    }
}
