import java.util.*;

public class E5 {
    public static Map<String, List<String>> graph = new TreeMap<>();
    public static Map<String, Integer> mapper;
    public static List<List<String>> edges;
    public static Set<String> visited;
    public static List<List<String>> edgesToRemove;
    public static boolean isCyclic;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        mapper = new HashMap<>();
        edgesToRemove = new ArrayList<>();
        edges = new ArrayList<>();
        int counter = 0;

        while (!line.equals("")) {

            String[] tokens = line.split(" -> ");
            String key = tokens[0];
            mapper.put(key, counter);
            String[] children = tokens[1].split("\\s+");
            Arrays.sort(children);
            graph.putIfAbsent(key, new ArrayList<>());
            for (String child : children) {
                graph.get(key).add(child);
            }
            counter++;

            line = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            for (String s : entry.getValue()) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(s);
                edges.add(list);
            }

        }


        for (List<String> edge : edges) {
            String start = edge.get(0);
            String end = edge.get(1);


            visited = new HashSet<>();

            graph.get(start).remove(end);
            graph.get(end).remove(start);

            isCyclic = false;

            dfs(start, end);

            if (isCyclic){
                List<String> toRemove = new ArrayList<>();
                toRemove.add(start);
                toRemove.add(end);
                edgesToRemove.add(toRemove);
            }

        }


        System.out.println("Edges to remove: " + edgesToRemove.size());
        for (List<String> list : edgesToRemove) {
            System.out.println(list.get(0) + " - " + list.get(1));
        }

    }

    private static void dfs(String start, String end) {
        visited.add(start);

        if (start.equals(end)){
            isCyclic = true;
            return;
        }

        for (String child : graph.get(start)) {
            if (!visited.contains(child)){
                dfs(child, end);
            }
        }


    }


}
