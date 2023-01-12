package org.example.Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /* 1.
    * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
    * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
    * Write a function:
    *   class Solution { public int solution(int N); }
    * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
    * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
    * Write an efficient algorithm for the following assumptions:
    * N is an integer within the range [1..2,147,483,647].
    * */
    public static int findBinaryGap(int n){
        int maxGap = 0;
        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        int index = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                maxGap = Math.max(maxGap, i - index - 1);
                index = i;
            }
        }
        return maxGap;
    }

    /* 2. CyclicRotation
    * Rotate an array to the right by a given number of steps.
    * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place.
    * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
    * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
    *
    * For example, given
    A = [3, 8, 9, 7, 6]
    K = 3
    * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
    * */
    public static int[] cyclicRotation(int[] A, int K) {
        if (A.length == K || A.length == 0) {
            return A;
        }
        while (K > 0) {
            A = rotate(A);
            K--;
        }
        return A;
    }

    public static int[] rotate(int[] A) {
        int[] B = new int[A.length];
        B[0] = A[A.length -1];
        for (int i = 1; i < A.length; i++) {
            B[i] = A[i-1];
        }
        return B;
    }

    /* 3.OddOccurrencesInArray
    * A non-empty array A consisting of N integers is given.
    * The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value,
    * except for one element that is left unpaired.
    * For example, in array A such that: [9, 3, 9, 3, 9, 7, 9}]
    * the function should return 7
    * */

    // O(N**2) --> 67%
    public static int oddOccurrencesInArray(int[] A) {
        List<Integer> elements = new ArrayList<>();
        for (int i=0; i<A.length; i++) {
            if (elements.contains(A[i])) {
                elements.remove(elements.indexOf(A[i]));
            } else {
                elements.add(A[i]);
            }
        }
        return elements.get(0);
    }


    // O(N) or O(N*log(N)) --> 100%
    public static int oddOccurrencesInArray_v2(int[] A) {
        Map<Integer, Boolean> elements = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            if (elements.containsKey(A[i])) {
                elements.put(A[i], !elements.get(A[i]));
            } else {
                elements.put(A[i], false);
            }
        }
        for (Integer i: elements.keySet()) {
            if (!elements.get(i)) {
                return i;
            }
        }
        return 0;
    }

    /* 4. FrogImp
    * A small frog wants to get to the other side of the road.
    * The frog is currently located at position X and wants to get to a position greater than or equal to Y.
    * The small frog always jumps a fixed distance, D.
    * Count the minimal number of jumps that the small frog must perform to reach its target.
    * */
    // O(1)
    public static int minNumsOfFrogJump(int X, int Y, int D) {
        int n = (Y - X) / D;
        if (X + n*D < Y) {
            n++;
        }
        return n;
    }

    /* 5. PermMissingElem
    * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
    * Your goal is to find that missing element.
    * */
    // O(N) or O(N * log(N))
    public static int findMissingElement(int[] A) {
        int n = 1;
        if (A.length == 0) {
            return n;
        }
        int[] arr = Arrays.stream(A).sorted().toArray();
        int max = arr[arr.length-1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == n) {
                n++;
            } else if (n < max) {
                return n++;
            }
        }
        if (n == max) {
            n++;
        }
        return n;
    }

    /*
    * given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    * Given A = [1, 2, 3], the function should return 4.
    * Given A = [−1, −3], the function should return 1.
    * */
    public static int findSmallestPositiveInteger(int[] A) {
        int[] arr = Arrays.stream(A).sorted().toArray();
        int min = 1;
        int max = arr[arr.length -1];
        if ((max < 0) || (arr.length == 1 && max > 1)) {
            return min;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                continue;
            } else if (arr[i] == min) {
                min ++;
            } else if (arr[i] > min && min < max) {
                return min;
            }
        }
        if (min == max) {
            min ++;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestPositiveInteger(new int[] {1, 3, 6, 4, 1, 2}));

        // 5. PermMissingElem
        int missElement = findMissingElement(new int[] {});
        System.out.println(missElement);

        /*// 4. FrogImp
        int nums = minNumsOfFrogJump(10, 85, 30);
        System.out.println(nums);

        // 3. OddOccurrencesInArray
        int[] C = {5, 3, 9, 3, 9, 9, 9};
        int n = oddOccurrencesInArray_v2(C);
        System.out.println(n);

        // 2. CyclicRotation
        int[] A = {};
        printArray(A);
        int K = 4;
        System.out.println(K);
        int[] B = cyclicRotation(A, K);
        printArray(B);

        // 1. binary gap
        int result = findBinaryGap(2);
        System.out.println(result);*/
    }

    public static void printArray(int[] A) {
        for (int a: A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
