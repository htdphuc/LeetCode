package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String result = findNumber(Arrays.asList(1, 2, 3, 5), 4);
    }

    public static String findNumber(List<Integer> arr, int k) {
        List<Integer> list = arr.stream().sorted().collect(Collectors.toList());
        if (findIndex(list, k)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean findIndex(List<Integer> arr, int k) {
        if (arr.size() == 1) {
            if (arr.get(0) == k) {
                return true;
            }
        } else {
            int midIndex = arr.size() / 2;
            Integer temp = arr.get(midIndex);
            if (temp == k) {
                return true;
            } else if (temp > k) {
                return findIndex(arr.subList(0, midIndex), k);
            } else if (temp < k) {
                return findIndex(arr.subList(midIndex, arr.size()), k);
            }
        }
        return false;
    }
}