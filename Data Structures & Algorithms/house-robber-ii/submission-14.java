class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int includeZero = robHelper(nums, 0, nums.length - 2);
        int includeFirst = robHelper(nums, 1, nums.length - 1);

        return Math.max(includeZero, includeFirst);

    }

    private int robHelper (int[] nums, int start, int end)
    {
        int[] dp = new int[end - start + 1];

        dp[0] = nums[start];
        dp[1] = nums[start + 1];
        int validMaxVal = Math.max(dp[0], dp[1]);


        for (int i = start + 2; i <= end; i++)
        {
            if (i - start >= 3)
            {
                validMaxVal = Math.max(validMaxVal, dp[i - start - 3]);
            }
            if (validMaxVal != nums[i - 1])
            {
                dp[i - start] = nums[i] + Math.max(validMaxVal, dp[i - start - 2]);
            }
            else 
            {
                dp[i - start] = nums[i] + dp[i - start - 2];
            }
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
