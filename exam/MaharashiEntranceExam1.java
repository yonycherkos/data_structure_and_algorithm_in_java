package exam;

public class MaharashiEntranceExam1 {
    // Maharish Question and Answer in Amharic - 1
    // https://www.youtube.com/watch?v=EGckbDgmLlg&list=PLxbPL7YBQN5SCAzUL-31bjebzTIyH0n68
    public int largestFactor(int n) {
        if (n <= 0)
            return 0;

        int max = 1;
        for (int num = 2; num < n; num++) {
            if (n % num == 0 && num > max) {
                max = num;
            }
        }
        return max;
    }

    public int isIdentical(int[] arr) {
        boolean isOdd = arr.length % 2 != 0;
        int mid = (int) (arr.length / 2);
        int midIdx = isOdd ? mid + 1 : mid;
        for (int i = 0, j = midIdx; i < mid && j < arr.length; i++, j++) {
            if (arr[i] != arr[j])
                return 0;

            if (isOdd) {
                if (arr[mid] == arr[i] || arr[mid] == arr[j])
                    return 0;
            }
        }
        return 1;
    }

    public int largestSubstract(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return max - min;
    }

    public int largestAdjacentSum(int[] arr) {
        int max = arr[0] + arr[1];
        for (int i = 1; i < arr.length - 1; i++) {
            int adjSum = arr[i] + arr[i + 1];
            if (adjSum > max)
                max = adjSum;
        }
        return max;
    }

    public int checkConcatenationSum(int n, int catLen) {
        int concSum = 0;
        int number = n;
        int digit = 0;
        while (number > 0) {
            digit = number % 10;
            for (int i = 0; i < catLen; i++) {
                concSum += digit * (int) Math.pow(10, i);
            }
            number /= 10;
        }
        return concSum == n ? 1 : 0;
    }

    public int isSequenceArray(int[] arr, int m, int n) {
        for (int i = m; i <= n; i++) {
            boolean isExist = false;
            for (int j = 0; j < arr.length; j++) {
                if (j > 0 && !(arr[j] >= arr[j - 1]))
                    return 0;
                if (arr[j] == i) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist)
                return 0;
        }
        return 1;
    }

    // Computer Professionals Master’s Program Sample Test
    // 3) Write a function that accepts a character array, a zero-based start
    // position and a length. It should return a character array containing
    // containing lengthcharacters starting with the startcharacter of the input
    // array. The function should do error checking on the start position and the
    // length and return null if the either value is not legal.
    public char[] getSubArray(char[] arr, int start, int length) {
        // Check if start position and length are valid
        if (start < 0 || start >= arr.length || length <= 0 || start + length > arr.length) {
            return null;
        }

        // Create a new array to store the result
        char[] result = new char[length];

        // Copy the characters from input array to result array
        for (int i = 0; i < length; i++) {
            result[i] = arr[start + i];
        }

        return result;
    }

    // 5) Write a function to return an array containing all elements common to two
    // given arrays containing distinct positive integers. You should not use any
    // inbuilt methods. You are allowed to use any number of arrays
    public int[] findCommonElements(int[] arr1, int[] arr2) {
        int[] commonElements = new int[Math.min(arr1.length, arr2.length)];
        int commonCount = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    commonElements[commonCount] = arr1[i];
                    commonCount++;
                    break;
                }
            }
        }

        int[] result = new int[commonCount];
        for (int i = 0; i < commonCount; i++) {
            result[i] = commonElements[i];
        }

        return result;
    }

    // 6) Consider an array arr with n of positive integers. An integer idx is
    // called a POE (point of equilibrium) of A, if A[0] + A[1] + … + A[idx – 1] is
    // equal to A[idx + 1] + A[idx + 2] + … + A[n – 1]. Write a function to return
    // POE of an array, if it exists and -1 otherwise.
    public int isEquilibrium(int[] arr) {
        if (arr == null || arr.length < 3)
            return -1;

        int index = 1;
        while (index < arr.length - 1) {
            int leftSum = 0;
            for (int i = 0; i < index; i++) {
                leftSum += arr[i];
            }

            int rightSum = 0;
            for (int j = index + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum)
                return 1;

            index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MaharashiEntranceExam1 mee = new MaharashiEntranceExam1();
        int[] arr = { 2, 4, 8, 4, 2 };
        System.out.println("isEquilibrium: " + mee.isEquilibrium(arr));
    }
}
