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

    // Question - 6: An array can hold the digits of a number. For example the
    // digits of the number 32053 are stored in the array {3, 2, 0, 5, 3}. Write a
    // method call repsEqual that takes an array and an integer and returs 1 if the
    // array contains only the digits of the number in the same order that they
    // appear in the number. Otherwise it returns 0.
    public int repsEqual(int[] arr, int n) {
        int lastDigit;
        for (int i = arr.length - 1; i >= 0; i--) {
            lastDigit = n % 10;
            n /= 10;
            if (lastDigit != arr[i]) {
                return 0;
            }
        }
        return 1;
    }

    // Question - 7: An array is called centered-15 if some consecutive sequence of
    // elements of the array sum to 15 and this sequence is preceded and followed by
    // the same number of elements. For example {3, 2, 10, 4, 1, 6, 9} is
    // centered-15 because the sequence 10, 4, 1 sums to 15 and the sequence is
    // preceded by two elements (3, 2) and followed by two elements(6,9).
    public int isCentered15(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int lowerIndex = 0;
        int upperIndex = 0;
        if (arr.length % 2 == 0) {
            lowerIndex = arr.length / 2 - 1;
            upperIndex = arr.length / 2;
        } else {
            lowerIndex = (arr.length - 1) / 2;
            upperIndex = lowerIndex;
        }

        while (lowerIndex > 0 && upperIndex < arr.length) {
            int sum = 0;
            for (int i = lowerIndex; i <= upperIndex; i++) {
                sum += arr[i];
            }

            if (sum == 15) {
                return 1;
            } else {
                lowerIndex--;
                upperIndex++;
            }
        }

        return 0;
    }

    // Question - 8: find a guthrie sequence for a given array
    public int isGuthrieSequence(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int len = arr.length;
        if (arr[len - 1] != 1)
            return 0;

        int result = arr[0];
        for (int i = 1; i < len; i++) {
            if (result % 2 == 0) {
                result /= 2;
            } else {
                result = 3 * result + 1;
            }

            if (result != arr[i]) {
                return 0;
            }
        }

        return 1;
    }

    // Question - 9: find a stanton sequence for a given array
    public int isStantonSequence(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                n++;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                count++;
        }

        return count;
    }

    // Question - 10: find a sum factor of an array. the sum factor of an array is
    // defined to be the number of times that the sum of the array appear as element
    // of the array.
    public int sumFactor(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sum)
                count++;
        }

        return count;
    }

    // Question - 11: find two numbers with equal value with a factorial of ten
    public int[] factorialSum(int n) {
        int nFactorial = factorial(n);

        int xFactorial;
        int yFactorial;
        for (int i = 1; i <= n; i++) {
            xFactorial = factorial(i);
            for (int j = 1; j <= n; j++) {
                yFactorial = factorial(j);
                System.out.println(i + " " + j + ": " + (xFactorial + yFactorial) + "=" + nFactorial);
                if (xFactorial + yFactorial == nFactorial) {
                    System.out.println("x: " + i + " y: " + j);
                    return new int[] { i, j };
                }
            }

        }

        return new int[] { 0, 0 };
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Question - 12: Write a method called convertToBase10 that converts its
    // <array, base> arguments to a base 10 number if the input is legal for the
    // specific base. if not, it returns 0;
    public int convertToBase10(int[] arr, int base) {
        if (arr == null || arr.length == 0)
            return 0;

        int base10 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= base)
                return 0;
            base10 += arr[i] * Math.pow(base, arr.length - i - 1);
        }

        return base10;
    }

    // Question - 13: A simple pattern match on the elements of an rray "A" can be
    // defined using another array "P".
    // A = {1, 2, 3, -5, -5, 2, 3, 18}, can be defined as P = {3, -2, 3} or {2, 1,
    // -1, -1, 2, 1}
    public int matches(int[] a, int[] p) {
        int idx = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < Math.abs(p[i]); j++) {
                if (!((p[i] > 0 && a[idx] > 0) || (p[i] < 0 && a[idx] < 0))) {
                    return 0;
                }
                idx++;
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
        // mee.printArray(mee.factorialSum(10));
        int[] a = new int[] { 1, 2, 3, -5, -5, 2, 3, 18 };
        int[] p = new int[] { 2, 1, -1, -1, 2, 1 };
        System.out.println("matches: " + mee.matches(a, p));
    }
}
