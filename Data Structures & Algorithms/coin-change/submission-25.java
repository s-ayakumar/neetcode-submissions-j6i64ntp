class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
        {
            int coinsIndex = 0;
            int storeMin = amount + 1;
            for (int cI = 0; cI < coins.length; cI++)
            {
                if (i - coins[cI] < 0) continue;
                storeMin = Math.min(storeMin, dp[i - coins[cI]] + 1);
            }

            dp[i] = storeMin;
           
        }
        if (dp[dp.length - 1] == amount + 1) return -1;

        return dp[dp.length - 1];
    }
}
