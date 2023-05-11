package org.example;

import java.util.Arrays;

public class Test {
    // 1.
    /* there are N bulbs, numbered from 1 to N, arranged in a row.
    The fisrt buld is plugged into the power socket and each successive buld is connected to the previous one
    (the second buld to the first, the third buld to the second, etc). Initialy, all the bulds are turn off.
    At moment K (for K from 0 to N-1), we turn on the A[K]-th. A buld shines if it is on and all the previous bulbs are turned on too.
    Write a function that, given an array A of N diffence integers from 1 to N, returns the number of moments for which every turned on buld shines

    * */
    public int solution(int[] A) {
        int count = 0;
        boolean[] on = new boolean[A.length];
        for(int i = 0; i < A.length; i++) {
            on[A[i] - 1] = true;
            boolean allOn = true;
            for(int j = 0; j < A[i] - 1; j++) {
                if(!on[j]) {
                    allOn = false;
                    break;
                }
            }
            if(allOn) count++;
        }
        return count;
    }

    public static int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }

    public static int solution_fix(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X) {
                nX += 1;
            }
            if (A[i] == Y) {
                nY += 1;
            }
            if (nX == nY)
                result = i;
        }
        return result;
    }

    public static int solution_bai2(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }

    //3
    public static int solution(int[] X, int[] Y, int W) {
        int n = X.length;
        int maxPotholes = 0;
        for (int i = 0; i < n; i++) {
            int x = X[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (X[j] >= x && X[j] <= x + W)
                    count++;
            }
            maxPotholes = Math.max(maxPotholes, count);
        }
        return maxPotholes;
    }

    public int solution3(int[] X, int[] Y, int W) {
        int n = X.length;
        Arrays.sort(X);
        int i = 0, count = 0;
        while (i < n) {
            int x = X[i];
            count++;
            while (i < n && X[i] <= x + W) i++;
            while (i < n && X[i] <= X[i - 1] + W) i++;
        }
        return count;
    }


    /*
    There are N potholes on a straight road parallel to the y-axis. The positions of the potholes are described by two arrays of integers, X and Y.
    The K-th pothole (for K within the range [0...N-1]) is located at coordinates (X[K], Y[K]).
    In order to fix the potholes, a road roller of width W will be used. The road  roller can only drive along the street (parallel to the y-axis).
    It can start driving from any x coordinate at the beginning of the road (a point whose y coordinate is equal to 0).
    During one drive, for a chosen starting point (x, 0) of the road roller's left end, the road roller drives upwards and patches all potholes on its way that fall within the width of the road roller, W, and are to the right of its starting position, x.
    In other words, it patches all the potholes whose first coordinate is between x and x+W inclisive.
    what is the minimum number of road roller drives required to patch all the potholes?
    Write a function:
	    public int solution(int[] X, int[] Y, int W)
    that, given 2 arrays of intergers X and Y, describing the positions of the N potholes, and an integer W, specifying the width of the road roller, returns the minimum number of drives needed to patch all the potholes.
    *
    *
    Example test:   ([2, 4, 2, 6, 7, 1], [0, 5, 3, 2, 1, 5], 2)
    OK

    Example test:   ([4, 8, 2, 2, 1, 4], [1, 2, 3, 1, 2, 3], 3)
    OK

    Example test:   ([0, 3, 6, 5], [0, 3, 2, 4], 1)
    OK*/
    public static int minDrives(int[] X, int[] Y, int W) {
        int n = X.length;
        // sort the potholes based on their x-coordinates
        int[][] potholes = new int[n][2];
        for (int i = 0; i < n; i++) {
            potholes[i][0] = X[i];
            potholes[i][1] = Y[i];
        }
        Arrays.sort(potholes, (a, b) -> a[0] - b[0]);
        // initialize variables
        int drives = 1;
        int current = 0;
        // iterate through the potholes
        for (int i = 0; i < n; i++) {
            if (potholes[i][0] - potholes[current][0] > W) {
                drives++;
                current = i;
            }
        }
        return drives;
    }

    public static void main(String[] args) {
        int[] X = new int[] {2, 4, 2, 6, 7, 1};
        int[] Y = new int[] {0, 5, 3, 2, 1, 5};
        int x = minDrives(X, Y, 2);
        System.out.println(x);
    }

    /* giai thich bai 3
    *
    * The problem is to find the minimum number of road roller drives required to patch all the potholes on a straight road parallel to the y-axis.
    * The road roller can only drive along the street (parallel to the y-axis) and patch all potholes on its way that fall within the width of the road roller, W, and are to the right of its starting position, x.
    * To solve this problem, I used a greedy algorithm. The first step is to sort the potholes by their x-coordinates, this is done by creating a 2D array of potholes and storing their x and y coordinates in it,
    * then using the sort method of the Arrays class to sort the potholes based on their x-coordinates.
    * The next step is to initialize variables to keep track of the number of road roller drives needed and the current position of the roller.
    * After that, the main part of the solution is the for loop, it iterates through the potholes, and for each pothole,
    * it checks if the next pothole's x-coordinate is not within the width of the road roller (x-coordinate of next pothole - current pothole's x-coordinate > W) and if so,
    * it increments the number of drives needed and updates the current pothole to the next one.
    * This way, it considers the current position of the roller and the width of the roller to patch the potholes, and it doesn't take into account if the current position has already been visited or not,
    * it always chooses the next pothole that's out of the width of the roller, so it guarantees that all the potholes will be patched with the minimum number of drives.
    * At the end of the loop, the function returns the number of drives needed to patch all the potholes, which is the minimum number of drives required to patch all the potholes.
    * I hope this helps to understand the solution, please let me know if you have any other question or need more help.
    * */
}
