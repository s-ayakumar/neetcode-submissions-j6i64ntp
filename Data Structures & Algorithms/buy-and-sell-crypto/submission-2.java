class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                profit = Math.max(prices[right] - prices[left], profit);
                right++;
                continue;
            } else if (prices[left] > prices[right]) {
                profit = Math.max(prices[right] - prices[left], profit);
                left = right;
                right++;
                continue;
            } else {
                right++;
            }
        }

        return profit;
    }
}
