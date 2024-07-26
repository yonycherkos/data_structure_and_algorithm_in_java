package exam;

public class MeharashiEntranceExam1 {
    // Maharish Question and Answer in Amharic - 1
    public int largestFactor(int n) {
        if (n <= 0)
            return 0;

        int max = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && i > max) {
                max = i;
            }
        }
        return max;
    }

    public int isidentical(int[] arr) {
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

    // Maharish Question and Answer in Amharic - 2
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

    public int reverseNum(int n) {
        int output = 0;
        while (n != 0) {
            output = output * 10 + n % 10;
            n /= 10;
        }
        return output;
    }

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
        MeharashiEntranceExam1 mee = new MeharashiEntranceExam1();
        int[] arr = { 2, 8, 4, 2 };
        System.out.println("isDivisor: " + mee.isDivisible(arr, 2));
    }
}
