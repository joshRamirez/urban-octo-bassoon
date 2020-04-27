import org.junit.Test;
import util.ConversionUtil;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ConversionUtilTest {
    ConversionUtil conversionUtil = new ConversionUtil();

    @Test
    public void testConvertStringToRpnBasic() {
        String equation = "1+2";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("1");
        expectedResult.add("2");
        expectedResult.add("+");
        assertEquals("Simple equation test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnWhitespace() {
        String equation = "  1 +2    ";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("1");
        expectedResult.add("2");
        expectedResult.add("+");
        assertEquals("Whitespace test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnLargerNumbers() {
        String equation = "  11 +2    ";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("11");
        expectedResult.add("2");
        expectedResult.add("+");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnOperatorPrecedence() {
        String equation = "3 + 4 * 2 - 1";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("3");
        expectedResult.add("4");
        expectedResult.add("2");
        expectedResult.add("*");
        expectedResult.add("+");
        expectedResult.add("1");
        expectedResult.add("-");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnParenthesis() {
        String equation = "3 + 4 * (2 - 1)";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("3");
        expectedResult.add("4");
        expectedResult.add("2");
        expectedResult.add("1");
        expectedResult.add("-");
        expectedResult.add("*");
        expectedResult.add("+");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnParenthesis2() {
        String equation = "4 + 18 / (9 - 3)";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("4");
        expectedResult.add("18");
        expectedResult.add("9");
        expectedResult.add("3");
        expectedResult.add("-");
        expectedResult.add("/");
        expectedResult.add("+");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnParenthesisMiddle() {
        String equation = "3 + (4 + 2) * 1";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("3");
        expectedResult.add("4");
        expectedResult.add("2");
        expectedResult.add("+");
        expectedResult.add("1");
        expectedResult.add("*");
        expectedResult.add("+");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }

    @Test
    public void testConvertStringToRpnParenthesisDouble() {
        String equation = "((3 + 4) * 2) * 1";
        LinkedList<String> expectedResult = new LinkedList<String>();
        expectedResult.add("3");
        expectedResult.add("4");
        expectedResult.add("+");
        expectedResult.add("2");
        expectedResult.add("*");
        expectedResult.add("1");
        expectedResult.add("*");
        assertEquals("Larger numbers test fails", expectedResult, conversionUtil.convertStringToRpn(equation));
    }
}
