package hust.soict.hedspi.lab02;

import java.util.Scanner;

public class AddTwoMatrices {
    // Function to print Matrix
    static void printMatrix(int M[][], int rowSize, int colSize)
    {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.printf("%-10d", M[i][j]);
 
            System.out.println();
        }
    }
 
    static int[][] add(int A[][], int B[][],
                       int rowSize, int colSize)
    {
        int i, j;
        int C[][] = new int[rowSize][colSize];
 
        for (i = 0; i < rowSize; i++)
            for (j = 0; j < colSize; j++)
                C[i][j] = A[i][j] + B[i][j];
 
        return C;
    }

    private static void inputArr(int[][] A, int rowSize, int colSize, Scanner keyboard) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                A[i][j] = keyboard.nextInt();
            }
        }
    }
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {
            int rowSize = 0, colSize = 0;
            do {
                System.out.print("rowSize = ");
                rowSize = scanner.nextInt();
            } while (rowSize <= 0);

            do {
                System.out.print("colSize = ");
                colSize = scanner.nextInt();
            } while (colSize <= 0);

            int[][] A = new int[rowSize][colSize];
            int[][] B = new int[rowSize][colSize];

            System.out.println("\nEnter the elements of array A:");
            inputArr(A, rowSize, colSize, scanner);
            System.out.println("\nEnter the elements of array B:");
            inputArr(B, rowSize, colSize, scanner);

            int[][] C = add(A, B, rowSize, colSize);

            System.out.println("\nResultant Matrix:");
            printMatrix(C, rowSize, colSize);
        } 
    }
}
