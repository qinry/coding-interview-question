package io.dure.coding.stack;

import java.util.Stack;

public class AsteroidCollision {
    // O(n) time | O(n) space
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.empty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            } else if (stack.empty() || stack.peek() < 0 || as > 0) {
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
