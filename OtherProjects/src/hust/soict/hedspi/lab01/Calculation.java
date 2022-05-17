package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class Calculation {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null,
                "The sum of two numbers is: \t" + String.format("%.2f", (num1 + num2)) + "\n" +
                "The difference of two numbers is: \t" + String.format("%.2f", (num1 - num2)) + "\n" +
                "The product of two numbers is: \t" + String.format("%.2f", (num1 * num2)) + "\n" +
                "The quotient  of two numbers is: \t" + String.format("%.2f", (num1 / num2)),
                "Show result", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
