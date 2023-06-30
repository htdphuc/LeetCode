package org.example.BestPractices.EasyLeetCode;

public class MaxProfit {
    public static void main(String[] args) {
        int max = maxProfit(new int[] {2,4,1});
        System.out.println(max);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
