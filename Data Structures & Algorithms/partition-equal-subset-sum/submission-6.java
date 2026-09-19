class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 == 1) return false;

        int targetSum = totalSum / 2;
        
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {

            for (int sum = targetSum; sum >= nums[i]; sum--) {
                if (dp[sum - nums[i]]) {
                    dp[sum] = true;
                }
            }
        }

        return dp[targetSum];

    }
}
