class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 == 1) return false;

        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;


        for (int i = 0; i < nums.length; i++) {
            for (int sum = subsetSum; sum >= nums[i]; sum--) {
                if (dp[sum - nums[i]]) {
                    dp[sum] = true;
                }
            }
        }

        return dp[subsetSum];
    }
}
