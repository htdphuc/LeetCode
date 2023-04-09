package org.example.Codility;

public class Medium {
    public static void main(String[] args) {
        int[] A = maxCounters(5, new int[] {3, 4, 4, 6, 1, 4, 4});
        printArray(A);
    }
    public static int[] maxCounters(int N, int[] A) {
        int[] counters = new int[N];
        int n = 0;
        for (int k = 0; k < A.length; k++) {
            for (int x=1; x <= N; x++) {
                if (A[k] == x) {
                    n++;
                    counters[x-1] = n;
                } else if (A[k] == N + 1) {
                    counters[x-1] = n;
                }
            }
        }
        return counters;
    }

    /*
    * To solve this problem, you can use two variables to keep track of the current max value and the last max counter operation.
    * You can iterate through the input array and for each increase(X) operation, you check if the current max value has been updated by a max counter operation.
    * If it has, you set the counter at index X to the current max value + 1.
    * If it hasn't, you simply increment the counter at index X. For a max counter operation, you set the last max counter variable to the current max value and set all counters to the current max value.
    * Finally, you return the counter array as the result.*/
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int lastMaxCounter = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                lastMaxCounter = max;
                counters = new int[N];
            } else {
                if (lastMaxCounter > counters[A[i]-1])
                    counters[A[i]-1] = lastMaxCounter;
                counters[A[i]-1]++;
                max = Math.max(max, counters[A[i]-1]);
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMaxCounter) {
                counters[i] = lastMaxCounter;
            }
        }

        return counters;
    }

    public static void printArray(int[] A) {
        for (int a: A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
