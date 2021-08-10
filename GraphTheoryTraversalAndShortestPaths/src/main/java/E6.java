import java.awt.geom.Area;
import java.util.*;

public class E6 {
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Set<Integer> visited;
    public static List<List<Integer>> paths = new ArrayList<>();
    public static List<List<Integer>> importantStreets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int buildings = Integer.parseInt(scanner.nextLine());
        int streets = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        while (!line.equals("")) {


            String[] tokens = line.split(" - ");
            int building1 = Integer.parseInt(tokens[0]);
            int building2 = Integer.parseInt(tokens[1]);

            List<Integer> pathsList = new ArrayList<>();
            pathsList.add(building1);
            pathsList.add(building2);
            paths.add(pathsList);

            graph.putIfAbsent(building1, new ArrayList<>());
            graph.get(building1).add(building2);
            graph.putIfAbsent(building2, new ArrayList<>());
            graph.get(building2).add(building1);


            line = scanner.nextLine();

        }

        for (List<Integer> path : paths) {

            Integer start = path.get(0);
            Integer end = path.get(1);

            graph.get(start).remove(end);
            graph.get(end).remove(start);

            visited = new HashSet<>();

            dfs(start);

            if (visited.size() != buildings) {
                List<Integer> street = new ArrayList<>();
                street.add(start);
                street.add(end);
                importantStreets.add(street);
            }

            graph.get(start).add(end);
            graph.get(end).add(start);

        }


        System.out.println("Important streets:");
        for (List<Integer> importantStreet : importantStreets) {
            System.out.println(importantStreet.get(0) + " " + importantStreet.get(1));
        }

    }

    private static void dfs(Integer start) {
        visited.add(start);


        for (Integer child : graph.get(start)) {
            if (!visited.contains(child)) {
                dfs(child);
            }
        }

    }
}