import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static class Edge{
        public int parent;
        public int child;



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.equals("")){
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

                graph.add(nextNodes);
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component: ");
            for (Integer integer : connectedComponent) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components  = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                components.add(new ArrayDeque<>());
                /*dfs(i, components, graph, visited);*/
                bfs(i, components, graph, visited);
                System.out.println();
            }
        }

        return components;
    }

    private static void bfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);


        while (!queue.isEmpty()){
            int node = queue.poll();

            components.get(components.size() - 1).offer(node);

            for (Integer child : graph.get(node)) {
                if (!visited[child]){
                    visited[child] = true;
                    queue.offer(child);
                }
            }


        }
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {

        if (!visited[node]){
            visited[node] = true;

            for (Integer child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }

            components.get(components.size() -1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount  = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()){

            String current = graph.keySet().stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (current == null){
                break;
            }

            for (String child : graph.get(current)) {
                dependenciesCount.put(child, dependenciesCount.get(child) -1);
            }


            sorted.add(current);

            graph.remove(current);

        }

        if (!graph.isEmpty()){
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child,dependenciesCount.get(child) + 1);
            }

        }


        return dependenciesCount;
    }

}



















