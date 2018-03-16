import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class FindDistancesBFS {

    public static class Node {
        private int id;
        private ArrayList<Node> neighbors;
        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    public static class Graph {
        private int size;
        private ArrayList<Node> graph;

        public Graph(int size) {
            this.size = size;
            this.graph = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                // System.out.println("Adding node for: " + i);
                graph.add(new Node(i));
            }
        }

        public Node getNode(int id) {
            // System.out.println("Fetching: " + graph.get(id).id);
            return graph.get(id);
        }

        public void addEdge(int first, int second) {
            // System.out.println("Adding bidirectional edges: " + first + ", " + second);
            graph.get(first).neighbors.add(getNode(second));
            graph.get(second).neighbors.add(getNode(first));
        }

        public int[] shortestReach(int startId) {
            // array to maintain distances at each node, initialized to all -1 (index == to node id)
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            distances[startId] = 0; // distance from self is 0, this index is not printed in output

            // hashset to maintain visited nodes
            HashSet<Node> visitedNodes = new HashSet<>();
            visitedNodes.add(getNode(startId));

            // queue to maintain next nodes to traverse
            LinkedList<Node> nodeQueue = new LinkedList<>();
            nodeQueue.add(getNode(startId));

            // BFS loop
            while(!nodeQueue.isEmpty()) {
                Node current = nodeQueue.remove();
                for(Node neighbor : current.neighbors) {
                    if(visitedNodes.contains(neighbor)) continue;
                    visitedNodes.add(neighbor);
                    distances[neighbor.id] = distances[current.id] + 6;
                    nodeQueue.add(neighbor);
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
