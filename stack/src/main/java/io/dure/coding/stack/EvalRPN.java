package io.dure.coding.stack;

import java.util.Stack;

public class EvalRPN {
    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch(token) {
                case "*":
                case "/":
                case "+":
                case "-":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num2, num1, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private int calculate(int num2, int num1, String token) {
        switch(token) {
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            default:
                return 0;
        }
    }
}
