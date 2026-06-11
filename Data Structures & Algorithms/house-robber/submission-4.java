class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];
        int validMaxVal = Math.max(dp[0], dp[1]);


        for (int i = 2; i < nums.length; i++)
        {
            if (i >= 3)
            {
                validMaxVal = Math.max(validMaxVal, dp[i - 3]);
            }
            if (validMaxVal != nums[i - 1])
            {
                dp[i] = nums[i] + Math.max(validMaxVal, dp[i - 2]);
            }
            else
            {
                dp[i] = nums[i] + dp[i - 2];
            }
            

        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
