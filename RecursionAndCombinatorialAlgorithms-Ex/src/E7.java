import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E7 {

    public static String[] seats;
    public static String[] combinations;
    public static List<String> people;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        people = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        String line = scanner.nextLine();

        seats = new String[people.size()];

        while (!line.equals("generate")){
            String[] tokens = line.split(" - ");
            String name = tokens[0];
            int position = Integer.parseInt(tokens[1]) - 1;

            seats[position] = name;

            people.remove(name);

            line = scanner.nextLine();
        }
        combinations = new String[people.size()];
        used = new boolean[people.size()];
        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length){
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != null){
                System.out.print(seats[i] + " ");
            } else {
                System.out.print(combinations[index++] + " ");

            }
        }
        System.out.println();

    }
}
