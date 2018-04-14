//

import java.util.*;

public class CloneGraph {
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    private static HashMap<UndirectedGraphNode, UndirectedGraphNode> createdNodes;

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        createdNodes = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(node);
        visited.add(node.label);

        UndirectedGraphNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (!createdNodes.containsKey(curr)) {
                createdNodes.put(curr, new UndirectedGraphNode(curr.label));
            }

            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!visited.contains(neighbor.label)) {
                    queue.add(neighbor);
                }
                if (!createdNodes.containsKey(neighbor)) {
                    createdNodes.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                createdNodes.get(curr).neighbors.add(createdNodes.get(neighbor));
                visited.add(neighbor.label);
            }
        }

        return createdNodes.get(node);
    }

    public static void printGraph(UndirectedGraphNode node) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(node);
        visited.add(node.label);

        UndirectedGraphNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            System.out.print("Node " + curr.label + ": ");
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!visited.contains(neighbor.label)) {
                    queue.add(neighbor);
                }
                System.out.print(neighbor.label + " ");
                visited.add(neighbor.label);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 703 [43 279 703 ]    43 [279 703 ]    279 [43 279 703 ]
        UndirectedGraphNode node1 = new UndirectedGraphNode(703);
        UndirectedGraphNode node2 = new UndirectedGraphNode(43);
        UndirectedGraphNode node3 = new UndirectedGraphNode(279);

        // node1.neighbors.add(node1);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        // node3.neighbors.add(node3);

        UndirectedGraphNode root = cloneGraph(node1);
        printGraph(root);
    }
}
