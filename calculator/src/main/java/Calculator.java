import models.Calculation;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your equation: ");
        calculation.setInput(input.nextLine());

    }
}
