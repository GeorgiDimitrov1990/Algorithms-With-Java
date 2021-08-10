import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int replace = Integer.parseInt(scanner.nextLine());
        int insert = Integer.parseInt(scanner.nextLine());
        int delete = Integer.parseInt(scanner.nextLine());

        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();


        int[][] dp = new int[string1.length() + 1][string2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = j * insert;//
                } else if (j == 0) {
                    dp[i][j] = i * delete;//
                }
            }
        }

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(insert + dp[i][j - 1],
                            Math.min(delete + dp[i - 1][j],
                                    replace + dp[i - 1][j - 1]));
                }
            }
        }

        System.out.println("Minimum edit distance: " + dp[string1.length()][string2.length()]);
    }
}
