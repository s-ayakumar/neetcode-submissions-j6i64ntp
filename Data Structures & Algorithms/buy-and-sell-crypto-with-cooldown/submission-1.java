class Solution {
    public int maxProfit(int[] prices) {
        // if buy -> i + 1
        // if sell -> i + 2
        // [[(0 or 1) -> buying/not buying, value]]
        Integer[][] dp = new Integer[prices.length][2];
        
        return dfs(prices, 1, dp, 0);
    }

    private int dfs (int[] prices, int buying, Integer[][] dp, int i)
    {
        if (i >= prices.length) return 0;
        
        if (dp[i][buying] != null) return dp[i][buying];

        if (buying == 1)
        {
            int buy = dfs(prices, 0, dp, i + 1) - prices[i];
            int hold = dfs(prices, 1, dp, i + 1);
            dp[i][buying] = Math.max(buy, hold);
        }
        else
        {
            int sell = dfs(prices, 1, dp, i + 2) + prices[i];
            int hold = dfs(prices, 0, dp, i + 1);
            dp[i][buying] = Math.max(sell, hold);
        }

        return dp[i][buying];
        
    }
}
