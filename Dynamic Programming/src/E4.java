import java.util.Arrays;
import java.util.Scanner;

public class E4 {
    public static int[] bestPrices;
    public static int[] prices;
    public static int[] prevIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        prices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int length = Integer.parseInt(scanner.nextLine());
        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxProfit = cutRope(length);

        System.out.println(maxProfit);

        reconstructionSolution(length);

    }

    private static int cutRope(int length) {
        if (length == 0){
            return 0;
        }

        if (bestPrices[length] != 0){
            return bestPrices[length];
        }

        int currentBest = bestPrices[length];

        for (int i = 1; i <= length; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRope(length - i));
            if (currentBest > bestPrices[length]){
                bestPrices[length] = currentBest;
                prevIndex[length] = i;
            }
        }

        return bestPrices[length];
    }
    public static void reconstructionSolution(int lennght) {
        while (lennght - prevIndex[lennght] != 0){
            System.out.println(prevIndex[lennght] + " ");
            lennght = lennght - prevIndex[lennght];
        }
        System.out.println(prevIndex[lennght]);
    }
}
