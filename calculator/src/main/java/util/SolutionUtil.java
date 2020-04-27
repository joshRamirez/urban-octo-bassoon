package util;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;

public class SolutionUtil {
    public String solveEquation(LinkedList<String> tokens) {
        LinkedList<Integer> operands = new LinkedList<Integer>();

        for (String token : tokens) {
            if (NumberUtils.isNumber(token)) {
                operands.addLast(Integer.parseInt(token));
            } else {
                Integer secondOperand = operands.removeLast();
                Integer firstOperand = operands.removeLast();

                if (token.equals("+")) {
                    firstOperand += secondOperand;
                } else if (token.equals("-")) {
                    firstOperand -= secondOperand;
                } else if (token.equals("*")) {
                    firstOperand *= secondOperand;
                } else if (token.equals("/")) {
                    firstOperand /= secondOperand;
                }

                operands.addLast(firstOperand);
            }
        }

        return operands.getLast().toString();
    }
}
