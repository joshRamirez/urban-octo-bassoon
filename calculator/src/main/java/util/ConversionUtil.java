package util;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConversionUtil {
    private Map<String, Integer> operatorPrecedence = new HashMap<String, Integer>();
    private String nonDigitPattern = "\\+|-|\\*|\\/|\\(|\\)";
    private Pattern pattern = Pattern.compile(nonDigitPattern);
    private Matcher matcher;

    /**
     * Using constructor to initialize operator precedence map. The values will never change which is why the variable
     * is private, and is only set here.
     */
    public ConversionUtil() {
        operatorPrecedence.put("+", 2);
        operatorPrecedence.put("-", 2);
        operatorPrecedence.put("*", 3);
        operatorPrecedence.put("/", 3);
    }

    /**
     * Takes in a string and converts it to reverse polish notation. The algorithm was developed based on these
     * articles.
     * https://brilliant.org/wiki/shunting-yard-algorithm/
     * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     *
     * @param input String equation which is in infix notation.
     * @return String equation in reverse polish notation.
     */
    public LinkedList<String> convertStringToRpn(String input) {
        LinkedList<String> outputTokens = new LinkedList<String>();
        LinkedList<String> operatorStack = new LinkedList<String>();

        String standardizedInput = input.replaceAll("\\s", "").trim();
        LinkedList<String> tokens = getTokens(standardizedInput);

        while (tokens.size() != 0) {
            String token = tokens.remove(0);

            if (NumberUtils.isNumber(token)) {
                outputTokens.addLast(token);
            } else if (token.matches("\\+|-|\\*|/")) {
                if (operatorStack.size() > 0) {
                    Integer tokenPrecedence = operatorPrecedence.get(token);
                    Integer operatorStackPrecedence = operatorPrecedence.get(operatorStack.getLast());

                    if (!operatorStack.getLast().equals("(")) {
                        while (operatorStack.size() > 0 && tokenPrecedence <= operatorStackPrecedence) {
                            outputTokens.addLast(operatorStack.removeLast());
                        }
                    }
                }

                operatorStack.addLast(token);
            } else if (token.equals("(")) {
                operatorStack.addLast(token);
            } else if (token.equals(")")) {
                while (operatorStack.size() > 0 && !operatorStack.getLast().equals("(")) {
                    outputTokens.addLast(operatorStack.removeLast());
                }

                operatorStack.removeLast();
            } else {
                // TODO(JOSH): Need to throw an exception saying there was an invalid character.
                System.out.println("Invalid character: " + token);
            }
        }

        while (operatorStack.size() != 0) {
            outputTokens.addLast(operatorStack.removeLast());
        }

        return outputTokens;
    }

    /**
     * Breaks a string down into the tokens that will be used for reverse polish notation.
     * @param standardizedInput Input with stripped out whitespaces.
     * @return Linked list of tokens in the order that they appear. The token is an operator, operand or parenthesis.
     */
    private LinkedList<String> getTokens(String standardizedInput) {
        LinkedList list = new LinkedList();
        Integer pointer = 0;
        Integer endPointer = 0;
        matcher = pattern.matcher(standardizedInput);

        while (matcher.find()) {
            endPointer = matcher.start();
            String token = standardizedInput.substring(pointer, endPointer);
            String operator = standardizedInput.substring(endPointer, endPointer + 1);
            if (!token.equals("")) {
                list.addLast(token);
            }
            list.addLast(operator);
            pointer = ++endPointer;
        }

        if (endPointer < standardizedInput.length()) {
            list.addLast(standardizedInput.substring(endPointer));
        }

        return list;
    }
}
