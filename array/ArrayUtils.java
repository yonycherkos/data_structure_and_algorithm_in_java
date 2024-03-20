package array;

public class ArrayUtils {

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5];
        myArray[0] = 5;
        myArray[1] = 6;
        myArray[2] = 7;
        myArray[3] = 8;
        myArray[4] = 9;
        printArray(myArray);
    }

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

    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        // arrayUtils.arrayDemo();
        int[] myArray = { 3, 4, 5, 6, 7, 8 };
        int[] result = arrayUtils.removeEven(myArray);
        arrayUtils.printArray(result);
    }
}