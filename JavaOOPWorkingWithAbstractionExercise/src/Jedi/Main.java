package Jedi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getsPositions(scanner.nextLine());
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        fillTheMatrix(row, col, matrix, 0);


        String positions = scanner.nextLine();
        long sum = 0;
        while (!positions.equals("Let the Force be with you")) {
            int[] playerPositions = getsPositions(positions);
            int[] evilPositions = getsPositions(scanner.nextLine());

            int rowEvil = evilPositions[0];
            int colEvil = evilPositions[1];

            while (rowEvil >= 0 && colEvil >= 0) {
                if (isInBounds(rowEvil,colEvil,matrix)) {
                    matrix[rowEvil][colEvil] = 0;
                }
                rowEvil--;
                colEvil--;
            }

            int rowPlayer = playerPositions[0];
            int colPlayer = playerPositions[1];

            while (rowPlayer >= 0 && colPlayer < matrix[1].length) {
                if (isInBounds(rowPlayer,colPlayer,matrix)) {
                    sum += matrix[rowPlayer][colPlayer];
                }
                colPlayer++;
                rowPlayer--;
            }

            positions = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static int[] getsPositions(String positions) {
        return Arrays.stream(positions.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fillTheMatrix(int row, int col, int[][] matrix, int value) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {

            return true;
        }
        return false;
    }
}
