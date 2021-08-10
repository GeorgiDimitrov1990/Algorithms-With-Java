import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        String charToFill = scanner.nextLine();

        String[] tokens2 = scanner.nextLine().split("\\s+");

        int startRow = Integer.parseInt(tokens2[0]);
        int startCol = Integer.parseInt(tokens2[1]);
        String startChar = matrix[startRow][startCol];

        fillMatrix(startRow, startCol, matrix, charToFill,startChar);

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }


    }

    private static void fillMatrix(int row, int col, String[][] matrix, String charToFill, String startChar) {

        if (isOutOfBounds(row, col, matrix) || matrix[row][col].equals(charToFill) || !matrix[row][col].equals(startChar)) {
            return;
        }

        matrix[row][col] = charToFill;

        fillMatrix(row + 1, col, matrix, charToFill, startChar);
        fillMatrix(row - 1, col, matrix, charToFill,  startChar);
        fillMatrix(row, col + 1, matrix, charToFill,  startChar);
        fillMatrix(row, col - 1, matrix, charToFill,  startChar);

    }

    private static boolean isOutOfBounds(int row, int col, String[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;

    }


}
