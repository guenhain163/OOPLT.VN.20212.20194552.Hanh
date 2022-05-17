package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class Exercise06 {
    public static double inputNumber (String v) {
        String strNum;
        Integer checkNum = 0;
        Double number = 0.0;

        do {
            strNum = JOptionPane.showInputDialog(null,
                    "Please input " + (v != null ? v + ":" : "the number"), "Input number",
                    JOptionPane.INFORMATION_MESSAGE);
            try {
                number = Double.parseDouble(strNum);
                checkNum = 1;
            } catch (NumberFormatException e) {
                checkNum = 0;
            }
        } while (checkNum == 0);

        return number;
    }

    public static void showResult(String message, String title) {
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void linearQuation() {
        double a = inputNumber("a");
        double b = inputNumber("b");

        if (a == 0 && b == 0) {
            showResult("The equation has infinitely many solutions", "Show result");
        } else if (a == 0 && b != 0) {
            showResult("The equation has no solutions", "Show result");
        } else {
            showResult("The equation has a unique solution x = " + String.format("%.2f", (- b / a)),
                    "Show result");
        }
    }

    public static void quadraticEquation() {
        double a = inputNumber("a");
        double b = inputNumber("b");
        double c = inputNumber("c");

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            showResult("The equation has infinitely many solutions", "Show result");
        } else if (delta == 0) {
            showResult("The equation has a unique solution x = " + String.format("%.2f", (- b / (2 * a))),
                    "Show result");
        } else {
            showResult("The equation has 2 distinct solutions " + "\n" +
                            "\tx1 = " + String.format("%.2f", ((- b - Math.sqrt(delta)) / (2 * a))) + "\n" +
                            "\tx2 = " + String.format("%.2f", ((- b + Math.sqrt(delta)) / (2 * a))),
                    "Show result");
        }
    }

    public static void systemOfEquation() {
        double a1 = inputNumber("a1");
        double b1 = inputNumber("b1");
        double c1 = inputNumber("c1");
        double a2 = inputNumber("a2");
        double b2 = inputNumber("b2");
        double c2 = inputNumber("c2");

        double d = a1 * b2 - b1 * a2;
        double d1 = c1 * b2 - b1 * c2;
        double d2 = a1 * c2 - c1 * a2;

        if (d != 0) {
            String x, y;
            x = String.format("%.2f", (d1 / d));
            y = String.format("%.2f", (d2 / d));

            showResult("The system has a unique solution (x1, x2) = (" + x + ", " + y + ")",
                    "Show result");
        } else if (d == 0 && d1 == 0 && d2 == 0) {
            showResult("The system has infinitely many solutions", "Show result");
        } else {
            showResult("The system has no solutions", "Show result");
        }
    }

    public static void main(String args[]) {
        String selection;
        Integer key = 0;

        while (true) {
            do {
                selection = JOptionPane.showInputDialog(null,
                        "Menu\n" +
                        "1. Solve the linear quation.\n" +
                        "2. Solve the quadrantic equation.\n" +
                        "3. Solve the system of equation.\n" +
                        "4. Exit.\n" +
                        "Please input the number:", "Select function",
                        JOptionPane.INFORMATION_MESSAGE);
                key = Integer.parseInt(selection);
            } while (key < 1 || key > 4);
            switch (key) {
                case 1:
                    linearQuation();
                    break;
                case 2:
                    quadraticEquation();
                    break;
                case 3:
                    systemOfEquation();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}