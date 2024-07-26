package exam;

public class MaharashiEntranceExam2 {
    // Maharish Question and Answer in Amharic - 2
    // https://www.youtube.com/watch?v=vaqmoDMqmnY&list=PLHK18USBY-PfYp_NwHJe3gpsbbaGWxm8u

    // Question - 1: Write a function to remove duplicates from a given array.
    public int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        int count = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean exists = false;
            for (int j = 0; j < result.length; j++) {
                if (arr[i] == result[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                result[i] = arr[i];
                count++;
            }
        }

        int[] output = new int[count];
        for (int i = 0; i < count; i++) {
            output[i] = result[i];
        }

        return output;
    }

    // Question - 2: Write a function to reverse an integer using numeric operators
    // and without
    // using any arrays or other data structures.
    public int reverseNum(int n) {
        int output = 0;
        while (n != 0) {
            output = output * 10 + n % 10;
            n /= 10;
        }
        return output;
    }

    // Question - 3: Write a function to return an array containing all elements
    // common to two
    // given arrays containing distinct positive integers. You should not use any
    // inbuilt methods. You are allowed to use any number of arrays.
    public int[] findCommonArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return null;
        }

        if (arr1.length == 0 || arr2.length == 0) {
            return new int[0];
        }

        int count = 0;
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    result[count] = arr1[i];
                    count++;
                    break;
                }
            }
        }

        int[] output = new int[count];
        for (int i = 0; i < count; i++) {
            output[i] = result[i];
        }

        return output;
    }

    // Question - 4: Write a function that takes an array of integers as an argument
    // and returns a
    // value based on the sum of the even and odd numbers in the array. Let X = the
    // sum of the odd numbers in the array and let Y = the sum of the even numbers.
    // The function should return X - Y
    public int diffOddEvenSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int oddSum = 0;
        int evenSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }

        return oddSum - evenSum;
    }

    // Question - 5: Write a method named isDivisible that takes an integer array
    // and a divisor
    // and return if all its elements are divided by the divisor with not remainder.
    // Otherwise it returns 0.
    public int isDivisible(int[] arr, int divisor) {
        for (int num : arr) {
            if (num % divisor != 0) {
                return 0;
            }
        }
        return 1;
    }

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaharashiEntranceExam2 mee = new MaharashiEntranceExam2();
        int[] arr = { 2, 8, 4, 2 };
        System.out.println("isDivisor: " + mee.isDivisible(arr, 2));
    }
}
