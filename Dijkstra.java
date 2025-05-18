import java.util.*;

public class Dijkstra {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(int vertices, List<List<Edge>> adjList, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : adjList.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("Node " + i + ": Unreachable");
            else
                System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter edges in format: u v weight (0-based index)");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            adjList.get(u).add(new Edge(v, weight));
            // For undirected graph, also add: adjList.get(v).add(new Edge(u, weight));
        }

        System.out.print("Enter source node (0-based index): ");
        int source = scanner.nextInt();

        dijkstra(vertices, adjList, source);

        scanner.close();
    }
}
