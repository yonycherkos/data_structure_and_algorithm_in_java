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
    // and without using any arrays or other data structures.
    public int reverseNum(int n) {
        int result = 0;
        while (n != 0) {
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
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
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
        long nfactorial10 = factorial(n);

        for (int x = 1; x <= n; x++) {
            long factorialX = factorial(x);
            for (int y = x; y <= n; y++) {
                long factorialY = factorial(y);
                if (factorialX + factorialY == nfactorial10) {
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

    // Question - 13: A simple pattern match on the elements of an array "A" can be
    // defined using another array "P". A = {1, 2, 3, -5, -5, 2, 3, 18}, can be
    // defined as P = {3, -2, 3} or {2, 1, -1, -1, 2, 1}
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

        int i = 0;
        while (i * i <= n) {
            if (i * i == n) {
                System.out.println(i + "x" + i + "=" + n);
                return 1;
            }
            i++;
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
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum == n)
                return 1;
            if (sum > n)
                return 0;
        }
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
        if (arr == null || arr.length == 0)
            return 0;

        int startIdx = 0;
        int endIdx = 0;
        int count = 1;
        while (endIdx < arr.length) {
            int sum = 0;
            for (int i = startIdx; i <= endIdx; i++) {
                sum += arr[i];
            }

            if (sum != arr[0])
                return 0;

            count++;
            startIdx = endIdx + 1;
            endIdx = endIdx + count;
        }

        return 1;
    }

    // Question - 21: Define a square pair to be a the tuple <x, y> where x and y
    // are positive, non-zero integers, x<y and x + y is a perfect square. A perfect
    // square is an integer whose square root is also an integer, eg. 4, 9, 16 are
    // perfect square but 3, 10, and 17 are not.
    // eg. {9, 0, 2, -5, 7}
    public int countSquarePairs(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] > 0 && arr[j] > 0) && isPerfectSquare(arr[i] + arr[j]) == 1) {
                    System.out.println("X: " + arr[i] + " Y: " + arr[j]);
                    count++;
                }
            }
        }

        return count;
    }

    // Question - 22: Write a function named nextPerfectSquare that returns the
    // first perfect square that is greater that argument. A perfect square is an
    // integer that is equal to some integer squared.
    // eg. 16 = 4 * 4
    public int nextPerfectSquare(int n) {
        if (n < 0)
            return 0;

        int curr = n + 1;
        while (true) {
            if (isPerfectSquare(curr) == 1) {
                return curr;
            }
            curr++;
        }
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

    // Question - 23: Define an array to be trivalent if all its elements are one of
    // three different values. For example, {22, 19, 10, 10, 19, 22, 22, 10} is
    // trivalent because all elements are either 10, 22, or 19. However, the array
    // {1, 2, 2, 2, 2, 2, 2} is not trivalent because it contains only two different
    // value (1, 2)
    public int isTrivalentArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean exist = false;
            for (int j = 0; j < result.length; j++) {
                if (arr[i] == result[j]) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
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
    // elemtn in an array. eg. {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3} => 4
    public int frequentlyOccure(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int maxNum = arr[0];
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxNum = arr[i];
            }
        }

        return maxNum;
    }

    // Question - 25: Write a function named largestPrimeFactor that will return the
    // largest prime factor of a number. If the number is <= 1 it should return 0.
    public int largestPrimeFactor(int n) {
        if (n <= 1)
            return 0;

        int maxPrime = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && isPrime(i) == 1) {
                maxPrime = i;
            }
        }

        return maxPrime;
    }

    // Question - 26: A perfect number is one that is the sum of its factors,
    // excluding itself. The 1st perfect number is 6 because 6 = 1 + 2 + 3. the 2nd
    // perfect number is 28 which is equals 1 + 2 + 4 + 7 + 14.
    // Write a method named henry that takes two integer arguments i and j and
    // return the sum of the ith and jth perfect numbers.
    public int henry(int i, int j) {
        int num = 0;
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
                }
            }
            if (count == 2)
                break;

            num++;
        }

        return sum;
    }

    public int isPerfectNumber(int n) {
        if (n <= 1)
            return 0;

        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum == n)
            return 1;
        return 0;
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
    // Not understood. Need to check again ??????
    int smallest(int n) {
        int mul = 1;
        int count = 0;
        while (true) {
            int result = n * mul;
            if (containsDigit2(result)) {
                System.out.println("result: " + result);
                count++;
            } else {
                break;
            }
            mul++;
        }
        return count;
    }

    public static boolean containsDigit2(int n) {
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 2) {
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
        int count = 0;
        int sum = 0;
        int prevSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prevSum = sum;
            sum += arr[i];
            if (prevSum <= n && sum > n)
                count++;
        }
        return count;
    }

    // Question - 30: defined an array to be sequentially bounded or not
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
                if (a[i] != a[j]) {
                    break; // If elements are different, no need to check further
                }

                count++;
                if (count >= a[i]) {
                    return 0; // Value occurs more than or equal to its value
                }
            }
        }

        return 1; // Sequentially bounded
    }

    // Question - 31: defined an array to be railroad tie array
    public int isRailroadTie(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int noZeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                noZeroCount++;
                if (i == 0) { // Check the first element
                    if (arr[i + 1] == 0)
                        return 0;
                } else if (i == arr.length - 1) { // Check the last element
                    if (arr[i - 1] == 0)
                        return 0;
                } else {
                    // The element should have exactly one non-zero neighbors
                    // The pattern must be either previous or next item should be non-zero
                    if (!(arr[i - 1] == 0 && arr[i + 1] != 0 ||
                            arr[i - 1] != 0 && arr[i + 1] == 0)) {
                        return 0;
                    }
                }

            }
        }

        if (noZeroCount == 0)
            return 0;

        return 1;
    }

    // Question - 32: Defined an array to be Packed or not
    // All values are positive.
    // Each value n appears exactly n times.
    // All occurrences of the same value are consecutive.
    // Eg. {2, 2, 3, 3, 3, 4, 4, 4, 4} is packed
    public int isPacked(int[] a) {
        // Check if array is empty
        if (a.length == 0) {
            return 0;
        }

        // Check for positive values and consecutive occurrences
        int count = 1;
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= 0) {
                return 0; // Not all values are positive
            }

            if (a[i] == prev) {
                count++;
                if (count > a[i]) {
                    return 0; // Value appears more than it should
                }
            } else {
                if (count != prev) {
                    return 0; // Previous value didn't appear the right number of times
                }
                prev = a[i];
                count = 1;
            }
        }

        // Check the last group of values
        if (count != prev) {
            return 0; // Last value didn't appear the right number of times
        }

        return 1; // Array is packed
    }

    // Question - 33: Defined an pattern matching that matches array of integers.
    // Eg. {1, 1, 1, 2, 2, 1, 1, 3} matches {1, 2, 1, 3}
    public int matchesPattern(int[] arr, int[] pattern) {
        if (arr.length == 0 || pattern.length == 0) {
            return 0; // Empty array or pattern cannot match
        }

        int i = 0, j = 0;
        while (i < arr.length && j < pattern.length) {
            if (arr[i] == pattern[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (i == arr.length && j == pattern.length) ? 1 : 0; // All elements of the pattern have been
                                                                 // matched
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
        boolean foundCurrent = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < m || arr[i] > n) {
                return 0;
            }

            if (i > 0 && arr[i] < arr[i - 1]) {
                return 0;
            }

            if (arr[i] == current) {
                foundCurrent = true;
            } else if (arr[i] > current) {
                if (!foundCurrent) {
                    return 0;
                }
                current++;
                i--;
                foundCurrent = false;
            }
        }

        return (current == n && foundCurrent) ? 1 : 0;
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
        return (sum == n) ? 1 : 0;
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
        return hasOdd ? 1 : 0;
    }

    // Question - 38: Define an array to be a 121 array if all elements are either 1
    // or 2 and it begins with one or more 1s followed by a one or more 2s and then
    // ends with the same number of 1s that it begins with. Write a method named
    // is121Array that returns 1 if its array argument is a 121 array, otherwise, it
    // returns 0.
    public int is121Array(int[] arr) {
        int n = arr.length;

        // Find and check initial 1s
        int i = 0;
        while (i < n && arr[i] == 1) {
            i++;
        }
        if (i == 0 || i == n) {
            return 0;
        }

        // Find and check the middle 2s
        int count2s = 0;
        while (i < n && arr[i] == 2) {
            i++;
            count2s++;
        }
        if (i == n || count2s == 0) {
            return 0;
        }

        // Check the last 1st
        int count1s = 0;
        while (i < n && arr[i] == 1) {
            i++;
            count1s++;
        }
        if (i != n || count1s == 0) {
            return 0;
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
        int[] a = new int[] { 1, 1, 2, 2, 2, 1, 1 };
        int[] p = new int[] { 1, 2, 1, 3 };
        System.out.println("is121Array: " + mee.is121Array(a));
    }
}
