package hust.soict.hedspi.lab02;

import java.util.Scanner;

public class NumericArray {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            int n = 0;

            do {
                System.out.print("Enter the number of elements in the array: ");
                n = keyboard.nextInt();
            } while (n <= 0);
            
            int[] arr = new int[n];
            System.out.print("Enter the elements of the array: \n");
            inputArr(arr, n, keyboard);

            System.out.print("Array after sorting: ");
            sortASC(arr);
            show(arr, n);

            int sum = sum(arr, n);
            System.out.println("\nThe sum of array: " + sum);

            System.out.println("Average value of array: " + String.format("%.2f", ((double)sum / n)));
        }
    }

    private static void inputArr(int[] arr, int n, Scanner keyboard) {
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = keyboard.nextInt();
        }
    }

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static void show(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static int sum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
