class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        if (amount == 0) return dp[0];

        // [0, x, 1, x]
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
                else continue;
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];


    }
}
