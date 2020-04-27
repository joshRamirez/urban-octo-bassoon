import org.junit.Test;
import util.SolutionUtil;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class SolutionUtilTest {
    SolutionUtil solutionUtil = new SolutionUtil();

    @Test
    public void testSolveEquationComplex() {
        LinkedList<String> input = new LinkedList<String>();
        input.add("3");
        input.add("4");
        input.add("+");
        input.add("2");
        input.add("*");
        input.add("1");
        input.add("*");
        String expectedResult = "14";
        assertEquals("Complex test fails", expectedResult, solutionUtil.solveEquation(input));
    }

    @Test
    public void testSolveEquationLargeNumbers() {
        LinkedList<String> input = new LinkedList<String>();
        input.add("13");
        input.add("44");
        input.add("+");
        String expectedResult = "57";
        assertEquals("Larger numbers test fails", expectedResult, solutionUtil.solveEquation(input));
    }

    @Test
    public void testSolveEquationSubtractDivide() {
        LinkedList<String> input = new LinkedList<String>();
        input.add("12");
        input.add("4");
        input.add("/");
        input.add("3");
        input.add("-");
        String expectedResult = "0";
        assertEquals("Subtract/Divide test fails", expectedResult, solutionUtil.solveEquation(input));
    }
}
