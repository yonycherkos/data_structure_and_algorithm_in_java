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

    public static void main(String[] args) {
        StackUtils stackUtils = new StackUtils();
        int[] arr = { 4, 7, 3, 4, 8, 1 };
        int[] result = stackUtils.nextGreaters(arr);
        System.out.println();
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}