package org.example.Codility;

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

    public static void main(String[] args) {
        // 2. CyclicRotation
        int[] A = {};
        printArray(A);
        int K = 4;
        System.out.println(K);
        int[] B = cyclicRotation(A, K);
        printArray(B);


        // 1. binary gap
        int result = findBinaryGap(2);
        System.out.println(result);
    }

    public static void printArray(int[] A) {
        for (int a: A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
