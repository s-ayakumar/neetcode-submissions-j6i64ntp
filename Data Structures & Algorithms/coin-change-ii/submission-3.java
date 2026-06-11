class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j - coins[i] < 0) continue;

                dp[j] += dp[j - coins[i]];  
            }
        }

        return dp[amount];

        //return dfs(amount, coins, dp);
    }

    private int dfs(int amount, int[] coins, int[][] dp)
    {
        //check if visited
        if (amount == 0) return 1;

        int count = 0;

        for(int i = 0; i < coins.length; i++)
        {
            if (amount - coins[i] < 0) continue;

            count += dfs(amount - coins[i], coins, dp);
        }

        return count;
    }
}
