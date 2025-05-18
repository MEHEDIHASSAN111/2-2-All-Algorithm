import java.util.*;

public class DFSExample {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, k -> new LinkedList<>()).add(w);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        List<Integer> neighbors = adjList.getOrDefault(vertex, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSExample g = new DFSExample();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS starting from vertex 2:");
        g.dfs(2);
    }
}
