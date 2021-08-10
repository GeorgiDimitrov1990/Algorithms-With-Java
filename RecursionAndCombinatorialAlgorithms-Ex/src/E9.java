import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E9 {
    public static String[] girls;
    public static String[] boys;
    public static String[] combineGirls = new String[3];
    public static String[] combineBoys = new String[2];
    public static boolean[] usedGirls;
    public static boolean[] usedBoys;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");
        usedGirls = new boolean[girls.length];
        usedBoys = new boolean[boys.length];
        combine(0, 0);

    }

    private static void combine(int index, int start) {
        if (index == combineGirls.length){
            combineForBoys(0,0);
            return;
        }


        for (int i = start; i < girls.length; i++) {
            if (!usedGirls[i]) {
                usedGirls[i] = true;
                combineGirls[index] = girls[i];
                combine(index + 1, i);
                usedGirls[i] = false;
            }
        }
    }

    private static void combineForBoys(int index, int start) {
        if (index == combineBoys.length){
            print();
            return;
        }

        for (int i = start; i < boys.length; i++) {
            if (!usedBoys[i]) {
                usedBoys[i] = true;
                combineBoys[index] = boys[i];
                combineForBoys(index + 1, i);
                usedBoys[i] = false;
            }
        }
    }

    private static void print() {
        for (String combineGirl : combineGirls) {
            System.out.print(combineGirl + ", ");
        }
        System.out.println(String.join(", ", combineBoys));

    }
}
