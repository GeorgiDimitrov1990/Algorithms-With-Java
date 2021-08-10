import java.util.Scanner;

public class E4 {
    public static String [] elements;
    public static String [] returnElements;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());
        returnElements = new String[k];
        variations(0);

    }
    private static void variations(int index) {
        if (index == returnElements.length) {
            print(returnElements);
            return;
        }

        for (int i = 0; i < elements.length; i++) {

            returnElements[index] = elements[i];
            variations(index + 1);

        }
    }

    private static void print(String[] variations) {
        System.out.println(String.join(" ", variations));
    }
}
