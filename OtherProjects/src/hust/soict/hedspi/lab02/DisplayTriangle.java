package hust.soict.hedspi.lab02;

import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("n = ");
            int n = keyboard.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (2 * n + 1); j++) {
                    if (j > (n - i) && j <= (n + i + 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                    if (j == (2 * n)) {
                        System.out.print("\n");
                    }
                }
            }
        }
    }
}
