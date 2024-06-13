// https://leetcode.com/problems/buy-two-chocolates

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int len = prices.length;
        int res = money-prices[0]-prices[1];
        return res>=0 ? res : money;
    }
}