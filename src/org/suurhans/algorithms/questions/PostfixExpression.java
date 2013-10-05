package org.suurhans.algorithms.questions;

import java.util.Stack;

/**
 * User: tarmo
 * Date: 26.02.12
 * Time: 21:25
 */
public class PostfixExpression {


    public PostfixExpression(String infix) {

        Stack<Character> stack = new Stack<Character>();
        Stack<Character> postfix = new Stack<Character>();

        infix += ')';

        stack.push('(');

        for (int i = 0; i < infix.length(); i++) {

            switch (infix.charAt(i)) {

                case ' ':
                    break;

                case '+':
                case '-':
                case '*':
                case '/':
                case '^':

                    while (priority(stack.peek()) >= priority(infix.charAt(i))) {

                        char c = stack.pop();

                        postfix.push(c);
                        postfix.push(' ');

                    }

                    stack.push(infix.charAt(i));

                    break;

                case '(':

                    stack.push(infix.charAt(i));
                    break;

                case ')':

                    while (true) {

                        char c = stack.pop();

                        if (c == '(') {
                            break;
                        }

                        postfix.push(c);
                        postfix.push(' ');

                    }

                    break;

                default:


                    if (Character.isDigit(infix.charAt(i))) {

                        while (Character.isDigit(infix.charAt(i))) {
                            postfix.push(infix.charAt(i));
                            i++;
                        }

                        postfix.push(' ');
                        i--;

                    } else {
                        throw new IllegalArgumentException("Incorrect character encountered in Infix experssion");
                    }

                    break;
            }

        }


        System.out.println(postfix);
    }

    private int priority(char c) {

        switch (c) {

            case '^':
                return 3;

            case '*':
                return 2;

            case '/':
                return 2;

            case '+':
                return 1;

            case '-':
                return 1;

            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        new PostfixExpression("(2 + 3) * 4 + (5 - 3) ^ 2");
    }


}
