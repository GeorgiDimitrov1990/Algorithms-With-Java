import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elements = Integer.parseInt(scanner.nextLine());
        int arrLength = Integer.parseInt(scanner.nextLine());
        int [] arr = new int[arrLength];

        combinations(arr, elements, 0, 1);
    }

    private static void combinations(int[] arr, int elements, int index, int start) {
        if (index == arr.length){
            print(arr);
            return;
        }

        for (int i =start ; i <= elements ; i++) {
            arr[index] = i;
            combinations(arr, elements, index + 1, i + 1);
        }
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
    }
}
