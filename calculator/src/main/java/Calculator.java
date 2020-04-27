import models.Calculation;
import util.ConversionUtil;
import util.SolutionUtil;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        ConversionUtil conversionUtil = new ConversionUtil();
        SolutionUtil solutionUtil = new SolutionUtil();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your equation. Only use parenthesis, base 10 positive integers and only the following operators: +,-,*,/");
        Calculation calculation = new Calculation();
        calculation.setInput(input.nextLine());
        calculation.setRpn(conversionUtil.convertStringToRpn(calculation.getInput()));
        calculation.setOutput(solutionUtil.solveEquation(calculation.getRpn()));
        System.out.println("Solution: " + calculation.getOutput());
    }
}
