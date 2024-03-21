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

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] arr = { 8, 1, 0, 2, 1, 0, 3 };
        printArray(arr);
        moveZeros(arr);
        printArray(arr);
    }

    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.arrayDemo();
    }
}