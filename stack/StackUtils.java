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

    public static void main(String[] args) {
        StackUtils stackUtils = new StackUtils();
        String str = "Hello World!";
        System.out.println(stackUtils.reverseString(str));
    }
}
