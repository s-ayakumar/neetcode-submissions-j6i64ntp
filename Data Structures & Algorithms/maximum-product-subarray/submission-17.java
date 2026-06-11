class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[2];

        dp[0] = nums[0];
        dp[1] = nums[0];
        int totalMax = 0;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                int temp = dp[0];
                dp[0] = dp[1];
                dp[1] = temp;
            }
            dp[0] = Math.max(nums[i], nums[i] * dp[0]);
            dp[1] = Math.min(nums[i], nums[i] * dp[1]);

            totalMax = Math.max(totalMax, dp[0]);
        }

        return totalMax;

    }
}
