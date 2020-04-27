package models;

import java.util.List;

public class Calculation {
    private String input;
    private List<String> rpn;
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

    public List<String> getRpn() {
        return rpn;
    }

    public void setRpn(List<String> rpn) {
        this.rpn = rpn;
    }
}
