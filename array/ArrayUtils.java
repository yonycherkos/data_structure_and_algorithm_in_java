package array;

public class ArrayUtils {
    public int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }

        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx] = arr[i];
                idx++;
            }
        }

        return result;
    }

    public int[] reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public int findSecondMax(int[] arr) {
        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    public int[] moveZeros(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] == 0 && arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            if (arr[j] != 0) {
                j++;
            }
        }

        return arr;
    }

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    /**
     * Finds the missing number in the given integer array.
     * 
     * Assumes the array contains numbers from 1 to n where
     * n is the length of the array + 1. Sums all numbers
     * in the array and subtracts from sum of 1 to n to
     * find the missing number.
     * 
     * @param arr The input array with one number missing
     * @return The missing number
     */
    public int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = (n * (n + 1)) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }

    /**
     * Checks if the given word is a palindrome by comparing the first
     * and last characters while moving the start and end pointers
     * towards the middle.
     *
     * @param word The word to check if it is a palindrome.
     * @return True if the word is a palindrome, false otherwise.
     */
    public boolean isPalidrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        System.out.println("is palidrome: " + isPalidrome("madam"));
    }

    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.arrayDemo();
    }
}