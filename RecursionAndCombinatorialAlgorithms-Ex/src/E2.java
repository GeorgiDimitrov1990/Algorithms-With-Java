import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[i];
        nestedLoopsToRecursion(arr, 0);
    }

    private static void nestedLoopsToRecursion(int[] arr, int index) {
        if (index == arr.length) {
            print(arr);
            return;
        }
        for (int i = 1; i <= arr.length; i++) {
            arr[index] = i;
            nestedLoopsToRecursion(arr, index + 1);
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
