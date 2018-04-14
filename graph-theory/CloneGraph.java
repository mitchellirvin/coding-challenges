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
        System.out.println("Cloning graph...");
        createdNodes = new HashMap<>();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(node);

        UndirectedGraphNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (!createdNodes.containsKey(curr)) {
                createdNodes.put(curr, new UndirectedGraphNode(curr.label));
            }

            System.out.print("Node " + curr.label + ", neighbors: ");
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!createdNodes.containsKey(neighbor)) {
                    queue.add(neighbor);
                    createdNodes.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                System.out.print(neighbor.label + " ");
                createdNodes.get(curr).neighbors.add(createdNodes.get(neighbor));
            }
            System.out.println();
        }

        return createdNodes.get(node);
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
    }
}
