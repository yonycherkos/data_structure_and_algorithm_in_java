package exam;

public class MaharashiEntranceExam3 {
    // Questions - 1
    public int isEvenDigits(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0)
                return 0;
            n /= 10;
        }
        return 1;
    }

    public int isMagicArray(int[] arr) {
        int primeSum = 0;
        for (int i : arr) {
            if (isPrime(i)) {
                primeSum += i;
            }
        }
        return primeSum == arr[0] ? 1 : 0;
    }

    public int isComplete(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                if (i < min)
                    min = i;
                if (i > max)
                    max = i;
                count++;
            }
        }
        if (count == 0)
            return 0;
        System.out.println("min: " + min + " max: " + max);

        if (min == max)
            return 0;

        for (int i = min + 1; i < max; i++) {
            boolean exist = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    exist = true;
                    break;
                }
            }
            if (!exist)
                return 0;
        }

        return 1;
    }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Questions - 2
    public int isPrimeProduct(int n) {
        if (n <= 2)
            return 0;

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i)) {
                for (int j = i; j <= n / 2; j++) {
                    if (isPrime(j) && i * j == n) {
                        System.out.println("i: " + i + ", j: " + j);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public int isBalanced(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] % 2 != 0)
                    return 0;
            } else {
                if (arr[i] % 2 == 0)
                    return 0;
            }
        }
        return 1;
    }

    public int isCentered(int[] arr) {
        if (arr.length == 0 || arr.length % 2 == 0)
            return 0;
        int midIdx = (int) arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (i == midIdx)
                continue;
            if (arr[i] <= arr[midIdx])
                return 0;
        }
        return 1;
    }

    // Questions - 3
    public int hasKSmallFactors(int k, int n) {
        for (int i = 2; i < k; i++) {
            for (int j = i; j < k; j++) {
                if (i * j == n)
                    return 1;
            }
        }
        return 0;
    }

    public int[] fill(int[] arr, int k, int n) {
        int[] arr2 = new int[n];
        int block = 0;
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i - block * k];
            if ((i + 1) % k == 0)
                block++;
        }
        return arr2;
    }

    public int isHallow(int[] arr) {
        int leftCount = 0;
        int rightCount = 0;
        int midCount = 0;
        for (int i : arr) {
            if (i == 0) {
                if (leftCount > 0 && rightCount == 0)
                    midCount++;
            } else {
                if (midCount == 0) {
                    leftCount++;
                } else {
                    rightCount++;
                }
            }
        }
        System.out.println("LeftCount: " + leftCount + ", MidCount: " + midCount + ", RightCount: " + rightCount);
        return (midCount >= 3 && leftCount == rightCount) ? 1 : 0;
    }

    // Questions - 4
    public int minDistance(int n) {
        int min = n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                for (int j = i + 1; j <= n / 2; j++) {
                    if (n % j == 0) {
                        if (min > j - i) {
                            min = j - i;
                            break;
                        }
                    }
                }
            }
        }
        return min;
    }

    public int isWave(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) || (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)) {
                return 0;
            }
        }
        return 1;
    }

    public int isBean(int[] arr) {
        boolean has9 = false;
        boolean has7 = false;
        boolean has13 = false;
        boolean has17 = false;

        for (int i : arr) {
            if (i == 9)
                has9 = true;
            else if (i == 7)
                has7 = true;
            else if (i == 13)
                has13 = true;
            else if (i == 17)
                has17 = true;
        }

        return (has9 ? has13 : false) && (has7 ? !has17 : false) ? 1 : 0;
    }

    // Questions - 5
    public int countDigit(int n, int digit) {
        int count = 0;
        while (n > 0) {
            int currDigit = n % 10;
            if (currDigit == digit)
                count++;
            n /= 10; // Becuase this is integere the decimal points wil be removed.
        }
        return count;
    }

    public int isBunkerArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 != 0 && isPrime(arr[i + 1]))
                return 1;
        }
        return 0;
    }

    public int isMeeraArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] * 2 == arr[j])
                    return 0;
            }
        }
        return 1;
    }

    // If the question says all the value should saticify a conding, find for where
    // it not satifify
    // If it says atleast one statify, find just one.

    // Questions - 6
    public int isMeeraNumber(int n) {
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                count++;
        }
        return n % count == 0 ? 1 : 0;
    }

    public int isBunkerArray2(int[] arr) {
        boolean has1 = false;
        boolean hasPrime = false;
        for (int i : arr) {
            if (i == 1)
                has1 = true;
            if (isPrime(i))
                hasPrime = true;
        }
        return has1 && hasPrime ? 1 : 0;
    }

    public int isNiceArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean exist = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] - 1 == arr[j] || arr[i] + 1 == arr[j]) {
                    exist = true;
                    break;
                }
            }
            if (!exist)
                return 0;
        }
        return 1;
    }

    // Questions - 7
    public int isContinuousFactored(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % 2 == 0) {
                int product = i;
                for (int j = i + 1; j <= n / 2; j++) {
                    if (n % j != 0) {
                        break;
                    } else {
                        product *= j;
                        if (product == n) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int isTwin(int[] arr) {
        for (int num1 : arr) {
            if (isPrime(num1)) {
                boolean foundTwin = false;
                for (int num2 : arr) {
                    if (num2 == num1 - 2 || num2 == num1 + 2) {
                        if (isPrime(num2)) {
                            foundTwin = true;
                            break;
                        }
                    }
                }
                if (!foundTwin)
                    return 0;
            }
        }
        return 1;
    }

    public int isSetEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return 0;

        for (int elementInA : a) {
            boolean foundInB = false;
            for (int elementInB : b) {
                if (elementInB == elementInA) {
                    foundInB = true;
                    break;
                }
            }
            if (!foundInB)
                return 0;
        }

        for (int elementInB : a) {
            boolean foundInA = false;
            for (int elementInA : b) {
                if (elementInA == elementInB) {
                    foundInA = true;
                    break;
                }
            }
            if (!foundInA)
                return 0;
        }

        return 1;
    }

    // Questions - 8
    public int isSmart(int n) {
        int k = 1;
        int kth = 1;
        while (kth <= n) {
            if (kth == n)
                return 1;
            kth += k;
            k++;
        }
        return 0;
    }

    public int isComplete2(int[] a) {
        int maxEven = 0;
        for (int num : a) {
            if (num <= 0)
                return 0;
            if (num % 2 == 0 && num > maxEven) {
                maxEven = num;
            }
        }

        for (int num1 = 2; num1 < maxEven; num1++) {
            if (num1 % 2 == 0) {
                boolean found = false;
                for (int num2 : a) {
                    if (num1 == num2)
                        found = true;
                }
                if (!found)
                    return 0;
            }
        }

        return 1;
    }

    // Questions - 9
    public int factorEqual(int n, int m) {
        int countNFactors = 0;
        int countMFactors = 0;
        for (int num = 2; num <= n; num++) {
            if (n % num == 0)
                countNFactors++;
        }
        for (int num = 2; num <= m; num++) {
            if (n % num == 0)
                countMFactors++;
        }

        return countNFactors == countMFactors ? 1 : 0;
    }

    public int isMeeraArray2(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= i)
                return 0;
            sum += a[i];
        }
        return sum == 0 ? 1 : 0;
    }

    public int isTripleArray(int[] arr) {
        for (int num1 : arr) {
            int count = 0;
            for (int num2 : arr) {
                if (num1 == num2)
                    count++;
            }
            if (count != 3)
                return 0;
        }
        return 1;
    }

    public int isFibonacci(int n) {
        if (n < 1)
            return 0;

        int a = 0, b = 1, c;
        System.out.println(b);
        while (b <= n) {
            c = a + b;
            if (c == n)
                return 1;
            a = b;
            b = c;
            System.out.println(b);
        }

        return 0;
    }

    // Questions - 10
    public int isMeeraArray3(int[] a) {
        boolean hasZero = false;
        boolean hasPrime = false;
        for (int num : a) {
            if (num == 0)
                hasZero = true;
            if (!hasPrime && isPrime(num))
                hasPrime = true;
            if (hasPrime && hasZero)
                return 1;
        }
        return (hasZero && hasPrime) || (!hasZero && !hasPrime) ? 1 : 0;
    }

    public int isBeenArray(int[] a) {
        for (int num1 : a) {
            boolean found = false;
            for (int num2 : a) {
                if (num2 == num1 - 1 || num2 == num1 + 1) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return 0;
        }
        return 1;
    }

    // Questions - 11
    public int isFancy(int n) {
        int a = 1, b = 1, c;
        while (b < n) {
            c = 2 * a + 3 * b;
            if (c == n)
                return 1;
            a = b;
            b = c;
        }
        return 0;
    }

    public int isMeeraArray4(int[] a) {
        boolean has1 = false;
        boolean has9 = false;
        for (int num : a) {
            if (num == 1)
                has1 = true;
            if (num == 9)
                has9 = true;
            if (has1 && has9)
                return 1;
        }
        return (has1 && has9) || !(has1 || has9) ? 1 : 0;
    }

    public int isBeanArray(int[] a) {
        for (int num1 : a) {
            boolean hasElement = false;
            for (int num2 : a) {
                if (2 * num1 == num2 || 2 * num1 + 1 == num2 || num1 / 2 == num2) {
                    hasElement = true;
                    break;
                }
            }
            if (!hasElement)
                return 0;
        }
        return 1;
    }

    // Questions - 12
    public int isBunker(int n) {
        int k = 1, kth = 1;
        while (kth <= n) {
            if (kth == n)
                return 1;
            kth += k;
            k++;
        }
        return 0;
    }

    public int isDualArray(int[] a) {
        for (int num1 : a) {
            int count = 0;
            for (int num2 : a) {
                if (num1 == num2)
                    count++;
                if (count == 2)
                    break;
            }
            if (count < 2)
                return 0;
        }
        return 1;
    }

    public int isFilterArray(int[] a) {
        boolean has9 = false;
        boolean has13 = false;
        boolean has7 = false;
        boolean has11 = false;
        for (int num : a) {
            if (num == 9)
                has9 = true;
            if (num == 13)
                has13 = true;
            if (num == 7)
                has7 = true;
            if (num == 11)
                has11 = true;
        }
        return ((has9 && has13) || !has9) && ((has7 && !has11) || !has7) ? 1 : 0;
    }

    // Questions - 13
    public int isBalancedArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                if (a[i] % 2 != 0)
                    return 0;
            } else {
                if (a[i] % 2 == 0)
                    return 0;
            }
        }
        return 1;
    }

    public int isOddheavy(int[] a) {
        boolean hasOdd = false;
        for (int num1 : a) {
            if (num1 % 2 != 0) {
                hasOdd = true;
                for (int num2 : a) {
                    if (num2 % 2 == 0 && num2 >= num1)
                        return 0;
                }
            }
        }
        if (!hasOdd)
            return 0;
        return 1;
    }

    public int isNormal(int n) {
        for (int i = 2; i < n; i++) {
            if (i % 2 != 0 && n % i == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        MaharashiEntranceExam3 mee = new MaharashiEntranceExam3();
        int[] arr = { 2, 5, 6, 9 };
        System.out.println(mee.isBalancedArray(arr));
    }
}
