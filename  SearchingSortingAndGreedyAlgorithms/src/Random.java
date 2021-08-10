import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static void main(String[] args) {
        int[] arr = {13,15,12,24,59};

        Arrays.sort(arr);

        int[] random = getAsRand(arr);

        for (int i : random) {
            System.out.println(i);
        }

    }

    private static int[] getAsRand(int[] arr) {

        int[] result = new int[arr.length];
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[threadLocalRandom.nextInt(arr.length)];
        }

        return result;
    }
}
