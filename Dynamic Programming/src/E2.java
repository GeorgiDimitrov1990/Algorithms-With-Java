import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLenght = 0;
        int bestIndex = -1;
        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill(prev, -1);

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;

            for (int j = i - 1; j >= 0 ; j--) {
                if (sequence[j] < current && length[j] + 1 >= bestLength){
                    bestLength = length[j] + 1;
                    prev[i] = j;
                }
            }
            length[i] = bestLength;

            if(maxLenght < bestLength){
                maxLenght = bestLength;
                bestIndex = i;
            }
        }
        List<Integer> LIS = new ArrayList<>();


        int index = bestIndex;


        while (index != -1){

            LIS.add(sequence[index]);

            index = prev[index];
        }

        for (int i = LIS.size() -1 ; i >= 0 ; i--) {
            System.out.print(LIS.get(i) + " ");
        }

        System.out.println();

        System.out.println(Arrays.stream(length).max().getAsInt());
    }
}
