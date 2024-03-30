package stack;

import java.util.Stack;

public class StackUtils {
    public String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public int[] nextGreaters(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    nextGreater = arr[j];
                    break;
                }
            }
            result[i] = nextGreater;
        }
        return result;
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackUtils stackUtils = new StackUtils();
        String input = "[{()}]";
        boolean result = stackUtils.isValid(input);
        System.out.println("Is Valid: " + result);
    }
}