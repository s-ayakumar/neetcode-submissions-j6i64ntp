class Solution {
    public int lengthOfLIS(int[] nums) {
        // subsqe = derivative of a seq by deleting some or no elements
        // w/o changing order of remaining chars
        // cat is subseq of crabt

        // approach: using dp I can track the LIS at each index
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = dp[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(dp[i], maxLen);
        }

        
        return maxLen;
    }
}
