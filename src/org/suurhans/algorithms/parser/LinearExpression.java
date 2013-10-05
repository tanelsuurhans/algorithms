package org.suurhans.algorithms.parser;

import com.sun.javafx.css.StyleableObjectProperty;
import sun.applet.resources.MsgAppletViewer_zh_CN;

import java.util.*;

public class LinearExpression {

    private final int START = 0;
    private final int OPERATOR = 1;
    private final int VARIABLE = 2;
    private final int NUMBER = 3;

    private final int LEFT = 100;
    private final int RIGHT = 200;

    private String equasion;
    private List<Integer> left;
    private List<Integer> right;

    double result = -1;

    public LinearExpression() {
    }

    public double solve(String expression) {

        equasion = expression;

        left = new ArrayList<Integer>();
        right = new ArrayList<Integer>();

        this.parse();
        this.calculate();

        return result;
    }

    public void parse() {

        String source = equasion + "$";
        StringBuffer buffer = new StringBuffer();
        Stack<StringBuffer> stack = new Stack<StringBuffer>();

        int state = START;
        int side = LEFT;

        for (int i = 0; i < source.length(); i++) {

            char token = source.charAt(i);

            switch (token) {

                case '$':
                    append(buffer, side);

                case ' ':
                    break;

                case '(':
                    // stash the current buffer and restart
                    stack.push(buffer);
                    buffer = new StringBuffer();
                    break;

                case ')':
                    StringBuffer stash = stack.pop();
                    break;

                case '+':
                case '-':
                    switch (state) {
                        case VARIABLE:
                        case NUMBER:
                            append(buffer, side);
                            buffer = new StringBuffer();
                            break;
                    }

                    if (token == '-')
                        buffer.append(token);

                    state = OPERATOR;
                    break;

                case '=':
                    append(buffer, side);
                    buffer = new StringBuffer();

                    side = RIGHT;
                    state = START;
                    break;

                case 'x':
                    buffer.append(token);

                    state = VARIABLE;
                    break;

                default:
                    switch(state) {
                        case OPERATOR:
                        case VARIABLE:
                        case NUMBER:
                        case START:
                            buffer.append(token);
                    }

                    state = NUMBER;
            }
        }
    }

    private void append(StringBuffer buffer, int side) {

        String token = buffer.toString();

        // detect token type and move to correct side, reversing operator if needed
        if (token.contains("x")) {

            // if Nx or -Nx
            if (token.length() > 1 && (Character.isDigit(token.charAt(0)) || Character.isDigit(token.charAt(1))))
                token = token.replace("x", "");
            else
                token = token.replace("x", "1");

            if (side == LEFT) {
                left.add(Integer.valueOf(token));
            } else {
                left.add(-Integer.valueOf(token));
            }

        } else {

            if (side == LEFT) {
                right.add(-Integer.valueOf(token));
            } else {
                right.add(Integer.valueOf(token));
            }

        }
    }


    private void calculate() {
        double left = 0;
        double right = 0;

        for (int n : this.left) {
            left += n;
        }

        for (int n : this.right) {
            right += n;
        }

        this.result = right / left;
    }

    public void print() {
        System.out.println("Linear expression: " + equasion);
        System.out.println("x = " + result);
        System.out.println();
    }

    public static void main(String[] args) {

        // x + 9 - 2 - 4 + x = - x + 5 - 1 + 3 - x => 1
        // x + 9 - 1 = 0 => -8
        // x + 4 = - 3 - x => -3.5

        // x + 9 – 2 - (4 + x) = – (x + 5 – 1 + 3) – x
        // x + 9 + (3 + – x – ( -x + (3 – (9 – x) + x))) = 9 -(5 +x )

        LinearExpression solver = new LinearExpression();

        solver.solve("x + 9 - 2 - 4 + x = - x + 5 - 1 + 3 - x");
        solver.print();

        solver.solve("x + 9 - 1 = 0");
        solver.print();

        solver.solve("x + 4 = - 3 - x");
        solver.print();

    }

}
