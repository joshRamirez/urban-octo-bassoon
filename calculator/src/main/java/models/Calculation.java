package models;

import java.util.LinkedList;

public class Calculation {
    private String input;
    private LinkedList<String> rpn;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public LinkedList<String> getRpn() {
        return rpn;
    }

    public void setRpn(LinkedList<String> rpn) {
        this.rpn = rpn;
    }
}
