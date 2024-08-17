package exam;

public class MaharashiEntranceExam2 {
    // Maharish Question and Answer in Amharic - 2
    // https://www.youtube.com/watch?v=vaqmoDMqmnY&list=PLHK18USBY-PfYp_NwHJe3gpsbbaGWxm8u

    // Consider the following three points when solving MUM entrance exam.
    // 1. Avoid time consuming and complex calculations. we should use the best
    // techniques to solve a problem.
    // 2. Our program should be easy to read and understand
    // 3. Choose the best techniques for solving a problem

    // NB. before implement a solution for the problem, try to solve the problem
    // manually. For example, using an array pointers.

    // Question - 1: Write a function to remove duplicates from an array of
    // integers.
    public int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int[] uniqueArr = new int[n];
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == uniqueArr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueArr[i];
        }

        return result;
    }

    // Question - 2: Write a function to reverse an integer using numeric operators
    // and without using any arrays or other data structures.
    public int reverseNum(int n) {
        int result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

    // Question - 3: Write a function to return an array containing all elements
    // common to two given arrays containing distinct positive integers. You should
    // not use any inbuilt methods. You are allowed to use any number of arrays.
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
    // and returns a value based on the sum of the even and odd numbers in the
    // array. Let X = the sum of the odd numbers in the array and let Y = the sum of
    // the even numbers. The function should return X - Y
    public int diffOddEvenSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int oddSum = 0;
        int evenSum = 0;
        for (int num : arr) {
            if (num % 2 == 0)
                evenSum += num;
            else
                oddSum += num;
        }

        return oddSum - evenSum;
    }

    // Question - 5: Write a method named isDivisible that takes an integer array
    // and a divisor and return if all its elements are divided by the divisor with
    // not remainder. Otherwise it returns 0.
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
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != n % 10) {
                return 0;
            }
            n /= 10;
        }

        if (n == 0)
            return 1;

        return 0;
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
            }

            lowerIndex--;
            upperIndex++;
        }

        return 0;
    }

    // Question - 8: find a guthrie sequence for a given array
    // - it starts with positve number n
    // - if n is even then divide by 2
    // - if n is odd then multiply by 3 and add 1
    // - continue this until n becomes 1
    // eg. {7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1}
    public int isGuthrieSequence(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int len = arr.length;
        if (arr[len - 1] != 1)
            return 0;

        for (int i = 1; i < len; i++) {
            int result;
            if (arr[i] % 2 == 0) {
                result = arr[i - 1] / 2;
            } else {
                result = 3 * arr[i - 1] + 1;
            }

            if (result != arr[i])
                return 0;
        }

        return 1;
    }

    // Question - 9: find a stanton sequence for a given array
    // - count number of 1's in the array. let this count be n.
    // - The stanton measure is the number of times that n appears in the array.
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
    // eg. {1, -1, 1, -1, 1, -1, 1}
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
    // X! + Y! = 10!
    public int[] factorialSum(int n) {
        long nfactorial = factorial(n);

        for (int x = 1; x <= n; x++) {
            long factorialX = factorial(x);
            for (int y = x; y <= n; y++) {
                long factorialY = factorial(y);
                if (factorialX + factorialY == nfactorial) {
                    System.out.println("X = " + x + ", Y = " + y);
                    return new int[] { x, y };
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
    // eg. {1, 0, 1, 1} base 2 = 11
    public int convertToBase10(int[] arr, int base) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= base)
                return 0;
            result += arr[i] * Math.pow(base, n - i - 1);
        }

        return result;
    }

    // Question - 13: A simple pattern match on the elements of an array "A" can be
    // defined using another array "P". A = {1, 2, 3, -5, -5, 2, 3, 18}, can be
    // defined as P = {3, -2, 3} or {2, 1, -1, -1, 2, 1}
    // NB. Math.abs() method has been used on the exam video. So we can use Math
    // module unless explicitly mentioned to not use it.
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

    // Question - 14: An array is defined to be n-unique if exactly on pair of its
    // elements sum to n. For example, the array {2, 7, 3, 4} is 5-unique because
    // only a[0] and a[2] sum to 5. But the array {2, 3, 3, 7} is not 5-unique
    // because a[0] + a[1] = 5 and a[0] + a[2] = 5.
    public int isNUnique(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n)
                    count++;

                if (count > 1)
                    return 0;
            }
        }

        return count == 1 ? 1 : 0;
    }

    // Question - 15: Write a function named isSquare that returns 1 if its integer
    // arguments is a square of some integer, otherwise it returns 0. Your function
    // must not use any function or method(eg. sqrt) that comes with a runtime
    // library or class library!
    public int isSquare(int n) {
        if (n < 0)
            return 0;

        int num = 0;
        while (num * num <= n) {
            if (num * num == n) {
                System.out.println(num + "x" + num + "=" + n);
                return 1;
            }
            num++;
        }

        return 0;
    }

    // Question - 16: Write a method called isLegalNumber that takes two arguments.
    // The first argument is an array whose elements are the digits of the number to
    // test. The second argument is the base of the number represented by the first
    // argument. The method should return 1 if the number is legal for the base,
    // otherwise it should return 0.
    public int isLegalNumber(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n)
                return 0;
        }
        return 1;
    }

    // Question - 17: Write a function named isStacked that returns 1 if its
    // argument is stacked. Otherwise it returns 0. A stacked number is defined to
    // be a number that is the sum of the first n positive integers for some n.
    // eg. 10 = 1 + 2 + 3 + 4
    public int isStacked(int n) {
        int sum = 0;
        int num = 1;
        while (sum < n) {
            sum += num;
            num++;
        }

        if (sum == num)
            return 1;
        return 0;
    }

    // Question - 18: Get Next Porcupine Number from the Given Integer. a porcupine
    // number is a prime number whose last digit is 9 and the next prime number that
    // follows it also ends with the digit 9.
    public int findPorcupineNumber(int n) {
        int curr = n + 1;
        while (true) {
            if (curr % 10 == 9 && isPrime(curr) == 1) {
                int next = curr + 1;
                boolean nextFound = false;
                while (true) {
                    if (isPrime(next) == 1) {
                        if (next % 10 == 9) {
                            nextFound = true;
                        }
                        break;
                    }
                    next++;
                }

                if (nextFound) {
                    return curr;
                }
            }
            curr++;
        }
    }

    public int isPrime(int n) {
        if (n < 2)
            return 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return 0;
        }

        return 1;
    }

    // Question - 19: Check an array to be a Madhav array. A Madhav array has the
    // following property. a[0] = a[1] + a[2] = a[3] + a[4] + a[5] = a[6] + a[7] +
    // a[8] + a[9] = ... The length of a Madhav array must be n*(n+1)/2 for some n.
    // {4, 2, 2, 1, 2, 1, 1, 1, 1, 1}
    public int isMadhavArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Check if the length of the array match with the form n*(n+1)/2
        int n = 1;
        while (n * (n + 1) / 2 < arr.length) {
            n++;
        }
        if (n * (n + 1) / 2 != arr.length) {
            return 0;
        }

        int index = 0;
        int elementsInGroup = 1;

        while (index < arr.length) {
            int currentSum = 0;
            for (int i = 0; i < elementsInGroup; i++) {
                currentSum += arr[index];
                index++;
            }
            if (currentSum != arr[0]) {
                return 0;
            }
            elementsInGroup++;
        }

        return 1;
    }

    // Question - 21: Define a square pair to be a the tuple <x, y> where x and y
    // are positive, non-zero integers, x<y and x + y is a perfect square. A perfect
    // square is an integer whose square root is also an integer, eg. 4, 9, 16 are
    // perfect square but 3, 10, and 17 are not.
    // eg. {9, 0, 2, -5, 7}
    // NB. start at j = i + 1 in the inner loop whenever possible.
    public int countSquarePairs(int[] arr) {
        if (arr == null || arr.length <= 1)
            return 0;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0)
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] > 0) && isPerfectSquare(arr[i] + arr[j]) == 1) {
                    System.out.println("X: " + arr[i] + " Y: " + arr[j]);
                    count++;
                }
            }
        }

        return count;
    }

    public int isPerfectSquare(int n) {
        int i = 0;
        while (i * i <= n) {
            if (i * i == n) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    // Question - 22: Write a function named nextPerfectSquare that returns the
    // first perfect square that is greater that argument. A perfect square is an
    // integer that is equal to some integer squared.
    // eg. 16 = 4 * 4
    public int nextPerfectSquare(int n) {
        if (n < 0)
            return 0;

        int next = n + 1;
        while (true) {
            if (isPerfectSquare(next) == 1) {
                return next;
            }
            next++;
        }
    }

    // Question - 23: Define an array to be trivalent if all its elements are one of
    // three different values. For example, {22, 19, 10, 10, 19, 22, 22, 10} is
    // trivalent because all elements are either 10, 22, or 19. However, the array
    // {1, 2, 2, 2, 2, 2, 2} is not trivalent because it contains only two different
    // value (1, 2)
    // NB. Iterate through the array and then add item to result array if it is not
    // exist and count unique items.
    public int isTrivalentArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < result.length; j++) {
                if (arr[i] == result[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result[count] = arr[i];
                count++;
            }
        }

        if (count == 3) {
            return 1;
        }

        return 0;
    }

    // Question - 24: Write a program which finds the most frequently occurring
    // element in an array. eg. {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3} => 4
    public int frequentlyOccure(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int mostFrequent = arr[0];
        int maxCount = 1;

        for (int i = 0; i < arr.length; i++) {
            int currentCount = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    currentCount++;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequent = arr[i];
            }
        }

        return mostFrequent;
    }

    // Question - 25: Write a function named largestPrimeFactor that will return the
    // largest prime factor of a number. If the number is <= 1 it should return 0.
    // NB. 2 is a prime number and 1 is not a prime number
    public int largestPrimeFactor(int n) {
        if (n <= 1)
            return 0;

        int maxPrime = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0 && isPrime(i) == 1) {
                maxPrime = i;
            }
        }

        return maxPrime;
    }

    // Question - 26: A perfect number is one that is the sum of its factors,
    // The 1st perfect number is 6 because 6 = 1 + 2 + 3.
    // the 2nd perfect number is 28 which is equals 1 + 2 + 4 + 7 + 14.
    // Write a method named henry that takes two integer arguments i and j and
    // return the sum of the ith and jth perfect numbers.
    public int henry(int i, int j) {
        int num = 2;
        int nth = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (isPerfectNumber(num) == 1) {
                nth++;
                if (nth == i || nth == j) {
                    System.out.println("nth: " + nth + " num: " + num);
                    sum += num;
                    count++;
                    if (count == 2) {
                        return sum;
                    }
                }
            }
            num++;
        }
    }

    public int isPerfectNumber(int n) {
        if (n <= 1) {
            return 0;
        }

        int sumOfFactors = 1; // Start with 1 as it's always a factor
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sumOfFactors += i;
            }
        }

        return (sumOfFactors == n) ? 1 : 0;
    }

    // Question - 27: The fundamental theorem of arithmetic states that every
    // natural number greater than 1 can be written as a unique product of prime
    // number. eg. 6936 = 2*2*2*3*17*17.
    // Write a method named encodeNumber that encode a number n as an array that
    // contains the prime numbers.
    public int[] encodeNumber(int num) {
        if (num <= 1)
            return null;

        int originalNum = num;

        int factor = 2;
        int product = 1;
        int count = 0;
        while (product < originalNum) {
            if (isPrime(factor) == 1 && num % factor == 0) {
                product *= factor;
                num /= factor;
                count++;
            } else {
                factor++;
            }
        }

        int[] results = new int[count];
        num = originalNum;
        int idx = 0;
        factor = 2;
        product = 1;
        while (product < originalNum) {
            if (isPrime(factor) == 1 && num % factor == 0) {
                product *= factor;
                num /= factor;
                results[idx] = factor;
                idx++;
            } else {
                factor++;
            }
        }

        return results;
    }

    // Question - 28: define a number to be smallest or not.
    // The number 124 has the property that it is the smallest number whose first
    // three multiples contain the digit 2. Observe that 124*1 = 124, 124*2 = 248,
    // 124*3 = 372 and that 124, 248, and 372 each contain the digit 2.
    // It is possible to generalize this property to be the smallest number whose
    // first n multiples each contain the digit 2.
    public int smallest(int n) {
        int num = 1;
        while (true) {
            boolean allContain2 = true;
            for (int i = 1; i <= n; i++) {
                if (!containsDigit2(num * i)) {
                    allContain2 = false;
                    break;
                }
            }
            if (allContain2) {
                return num;
            }
            num++;
        }
    }

    private boolean containsDigit2(int num) {
        while (num > 0) {
            if (num % 10 == 2) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    // Question - 29: define an array to be an up-count of an array to be the number
    // of times the partial sum goes from less than or equal to n greater than n
    // during the calculation of the sum of the elements of the array.
    // Eg. {2, 3, 1, -6, 8, -3, -1, 1} is an up-count array of n = 3.
    public int nUpCount(int[] arr, int n) {
        int sum = 0;
        int prevSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            prevSum = sum;
            sum += arr[i];
            if (prevSum <= n && sum > n)
                count++;
        }

        return count;
    }

    // Question - 30: defined an array to be sequentially bounded or not.
    // An integer array is defined to be sequentially bounded if it is in ascending
    // order and each value, n, in the array occurs less than n times in the array.
    // So {2, 3, 3, 99, 99, 99, 99, 99} is sequentially bounded because it is in
    // ascending order and the value 2 occurs the value less than 2 times, the value
    // 3 occurs less than 3 times, and 99 occurs 5 times which is less than 99.
    public int isSequentiallyBounded(int[] a) {
        if (a.length == 0) {
            return 1; // Empty array is sequentially bounded
        }

        // Check for ascending order
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                return 0; // Not in ascending order
            }
        }

        // Check for occurrences of each value
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = i; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= a[i]) {
                return 0; // Value occurs more than or equal to its value
            }
        }

        return 1; // Sequentially bounded
    }

    // Question - 31: defined an array to be railroad tie array
    // a. The array contains at least one non-zero element
    // b. Every non-zero element has exactly one non-zero neighbor
    // c. Every zero element has two non-zero neighbors
    // eg. {1, 2, 0, 3, -18, 0, 2, 2} is a railroad tie array
    // eg. {1, 2, 3, 0, 2, 2} is not a railroad tie array
    public int isRailroadTie(int[] arr) {
        if (arr.length < 2)
            return 0;

        boolean hasNonZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                hasNonZero = true;
                int nonZeroNeighbors = 0;
                if (i > 0 && arr[i - 1] != 0)
                    nonZeroNeighbors++;
                if (i < arr.length - 1 && arr[i + 1] != 0)
                    nonZeroNeighbors++;
                if (nonZeroNeighbors != 1)
                    return 0;
            } else {
                if (i == 0 || i == arr.length - 1)
                    return 0;
                if (arr[i - 1] == 0 || arr[i + 1] == 0)
                    return 0;
            }
        }

        return hasNonZero ? 1 : 0;
    }

    // Question - 32: Defined an array to be Packed or not
    // - All values are positive.
    // - Each value n appears exactly n times.
    // - All occurrences of the same value are consecutive.
    // Eg. {2, 2, 3, 3, 3, 4, 4, 4, 4} is packed

    // NB. The code uses a nested while loop to count consecutive occurrences of
    // each unique number. It then checks if the count matches the value.
    public int isPacked(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0;
        while (i < arr.length) {
            int currentValue = arr[i];

            // Check if the value is positive
            if (currentValue <= 0) {
                return 0;
            }

            // Count consecutive occurrences of the current value
            int count = 0;
            while (i < arr.length && arr[i] == currentValue) {
                count++;
                i++;
            }

            // Check if the count matches the value
            if (count != currentValue) {
                return 0;
            }
        }

        return 1;
    }

    // Question - 33: Defined an pattern matching that matches array of integers.
    // Eg. {1, 1, 1, 2, 2, 1, 1, 3} matches {1, 2, 1, 3}
    public int matchesPattern(int[] a, int[] pattern) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < pattern.length) {
            if (a[i] != pattern[j]) {
                return 0;
            }

            while (i < a.length && a[i] == pattern[j]) {
                i++;
            }

            j++;
        }

        return (i == a.length && j == pattern.length) ? 1 : 0;
    }

    // Question - 34: Define an m-n sequenced array to be an array that contains one
    // or more occurences of all the integers between m and n inclusive.
    // Furthermore, the array must be in ascending order and contain only those
    // integers. For example, {2, 2, 3, 4, 4, 4, 5} is a 2-5 sequenced array. The
    // array {2, 2, 3, 5, 5,5} is not a 2-5 sequenced array because it is missing a
    // 4. The array {0, 2, 2, 3, 3} is not a 2-3 sequenced array because the 0 is
    // out of range. And {1, 1, 3, 2, 2, 4} is not a 1-4 sequenced array because it
    // is not in ascending order.

    // 1. All numbers in the array should be between m and n.
    // 2. The array should be in ascending order.
    // 3. All numbers from m to n should appear at least once.

    public int isSequencedArray(int[] arr, int m, int n) {
        if (arr == null || arr.length == 0 || m > n) {
            return 0;
        }

        int current = m;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < m || arr[i] > n) {
                return 0;
            }

            if (i > 0 && arr[i] < arr[i - 1]) {
                return 0;
            }

            if (arr[i] == current && (i == 0 || arr[i] != arr[i - 1])) {
                current++;
            }
        }

        if (current == n + 1)
            return 1;

        return 0;
    }

    // Question - 35: The number 198 has the property that 198 = 11 + 99 + 88, i.e.,
    // if each of its digits is concatenated twice and the summed, the result will
    // be the original number. It turns out that 198 is the only number with this
    // property. However, the property also applies to the following numbers: 2997,
    // 3888, 4776, 5664, 6552, 7440, and 8328, and probably others. Write a function
    // named checkConcatenatedSum that returns 1 if its argument is a Guthrie
    // sequence, otherwise it returns 0.
    public int checkConcatenatedSum(int n, int catlen) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            int concat = digit;
            for (int i = 1; i < catlen; i++) {
                concat = concat * 10 + digit;
            }
            sum += concat;
            temp /= 10;
        }

        if (sum == n)
            return 1;

        return 0;
    }

    // Question - 36: Write a function named largestAdjacentSum that iterates
    // through an array computing the sum of adjacent elements and returning the
    // largest such sum. You may assume that the array has at least 2 elements.
    public int largestAdjacentSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int currentSum = arr[i] + arr[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    // Question - 37: An array is defined to be odd-heavy if it contains at least
    // one odd element and every element whose value is odd is greater than every
    // even-valued element. So {11, 4, 9, 2, 8} is odd-heavy because the two odd
    // elements (11 and 9) are greater than all the even elements. And {11, 4, 9, 2,
    // 3, 10} is not odd-heavy because the even element 10 is greater than the odd
    // element 9. Write a function called isOddHeavy that accepts an integer array
    // and returns 1 if the array is odd-heavy; otherwise it returns 0.
    public int isOddHeavy(int[] arr) {
        boolean hasOdd = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                hasOdd = true;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] % 2 == 0 && arr[j] > arr[i]) {
                        return 0;
                    }
                }
            }
        }

        if (hasOdd)
            return 1;

        return 0;
    }

    // Question - 38: Define an array to be a 121 array if all elements are either 1
    // or 2 and it begins with one or more 1s followed by a one or more 2s and then
    // ends with the same number of 1s that it begins with. Write a method named
    // is121Array that returns 1 if its array argument is a 121 array, otherwise, it
    // returns 0.
    public int is121Array(int[] arr) {
        int n = arr.length;
        int countStartOnes = 0;
        int index = 0;

        // Count starting 1s
        while (index < n && arr[index] == 1) {
            countStartOnes++;
            index++;
        }

        // Check for at least one 2
        if (index == n || arr[index] != 2) {
            return 0;
        }

        // Skip 2s
        while (index < n && arr[index] == 2) {
            index++;
        }

        // Count ending 1s
        int countEndOnes = 0;
        while (index < n && arr[index] == 1) {
            countEndOnes++;
            index++;
        }

        // Check if all elements are processed and counts match
        if (index == n && countStartOnes == countEndOnes && countStartOnes > 0) {
            return 1;
        }

        return 0;
    }

    // Question - 39: An array is defined to be minmax-disjoint if the following
    // conditions hold:
    // a. The minimum and maximum values of the array are not equal.
    // b. The minimum and maximum values of the array are not adjacent to one
    // another.
    // c. The minimum value occurs exactly once in the array.
    // d. The maximum value occurs exactly once in the array.
    // Eg. the array {5, 4, 1, 3, 2} is minmax-disjoint.
    // Write a function named isMinMaxDisjoint that returns 1 if its array argument
    // is minmax-disjoint, otherwise it returns 0.
    public int isMinMaxDisjoint(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                minCount++;
            }
            if (arr[i] == max) {
                maxCount++;
            }
        }

        if (min == max ||
                Math.abs(minIndex - maxIndex) == 1 ||
                minCount != 1 ||
                maxCount != 1) {
            return 0;
        }

        return 1;
    }

    // Question - 40: Define a cluster in an integer array to be a maximum sequence
    // of elements that are all the same value. For example, the array {3, 3, 3, 4,
    // 4, 3, 2, 2, 2, 2, 4} has six clusters, {3, 3, 3}, {4, 4}, {3}, {2, 2, 2, 2}
    // and {4}. A cluster-compression of an array replaces each cluster with the
    // number that is repeated in the cluster. So, the cluster compression of the
    // previous array would be {3, 4, 3, 2, 4}. The first cluster {3, 3, 3} is
    // replaced by a single 3, and the second cluster {2, 2, 2, 2} is replaced by
    // the number 2, and the number 4 is left unchanged. Write a function named
    // clusterCompression that returns the cluster compression of the parameter
    // array. The function signature is int[] clusterCompression(int[] a)
    public int[] clusterCompression(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int[] result = new int[a.length];
        int resultIndex = 0;
        int currentValue = a[0];
        result[resultIndex] = currentValue;
        resultIndex++;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != currentValue) {
                currentValue = a[i];
                result[resultIndex] = currentValue;
                resultIndex++;
            }
        }

        int[] compressedArray = new int[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            compressedArray[i] = result[i];
        }

        return compressedArray;
    }

    // Question - 41: Define a positive number to be isolated if none of the digits
    // in its square are in its cube. For example 168 is n isolated number because
    // 69*69 = 26569 and 69*69*69 = 4330747 and the square does not contain any of
    // the digits 0, 3, 4 and 7 which are the digits used in the cube. On the other
    // hand 162 is not an isolated number because 162*162 = 26244 and 162*162*162 =
    // 4251528 and the cube contains the digit 2 which is also in the square. Write
    // a function named isIsolated that returns 1 if its integer argument is an
    // isolated number, otherwise it returns 0.
    public int isIsolated(long n) {
        // The code efficiently checks for isolated numbers by using boolean arrays to
        // track digit occurrences. It iterates through the digits of the square and
        // cube of the input number, marking them as present in the square and cube
        // arrays. If any digit is found in both arrays, it indicates that the number is
        // not isolated, and the function returns 0. Otherwise, it returns 1, indicating
        // that the number is isolated.
        if (n <= 0) {
            return -1; // Invalid input
        }

        long square = n * n;
        long cube = n * n * n;

        boolean[] squareDigits = new boolean[10];
        boolean[] cubeDigits = new boolean[10];

        while (square > 0) {
            squareDigits[(int) (square % 10)] = true;
            square /= 10;
        }

        while (cube > 0) {
            if (squareDigits[(int) (cube % 10)]) {
                return 0; // Not isolated
            }
            cubeDigits[(int) (cube % 10)] = true;
            cube /= 10;
        }

        return 1; // Isolated
    }

    // Question - 42: Define an array to be a sum-safe if none of its elements is
    // equal to the sum of its elements. The array a = {5, -5, 0} is no sum-safe
    // because the sum of its elements is 0 and [2] == 0. However, the array a = {5,
    // -2, 1} is sum-safe because the sum of its elemtn is 4 and none of its
    // elements equal 4.

    // Write a function named isSumSafe that returns 1 if its array argument is
    // sum-safe, otherwise it returns 0.
    public int isSumSafe(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == sum) {
                return 0;
            }
        }

        return 1;
    }

    // Question - 43: An array is called vanilla if all its elements are made up of
    // the same digit. For example {1, 1, 11, 1111, 1111111} is a vanilla array
    // because all its elements use only the digit 1. However, the array {11, 101,
    // 1111, 11111} is not a vanilla array because its elements use the digits 0 and
    // 1. Write a method called isVanilla that returns 1 if its argument is a
    // vanilla array. Otherwise it returns 0.
    public int isVanilla(int[] a) {
        if (a.length == 0) {
            return 1;
        }

        int digit = a[0] % 10;
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            while (num > 0) {
                if (num % 10 != digit) {
                    return 0;
                }
                num /= 10;
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
        int[] a = new int[] { 2, 2, 3, 4, 4, 4, 5 };
        System.out.println("isSequencedArray: " + mee.isSequencedArray(a, 2, 5));
    }
}
