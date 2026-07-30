class Solution {
    public int rob(int[] nums) {
        
        // each i = money it has
        // i = neighbor of i - 1 and i + 1
        // can NOT rob from two adjacent
        // thinking: at each i, you have the choice to rob (if last wasn't robbed)
        // or skip
        
        // ex: [1, 1, 3, 3] -> rob from 0 then rob from 2 -> 4
        //     [1, 1, 4, 4]
        // ex: [2, 9, 8, 3, 6] -> rob from 0 then 2 then 4 -> 2 + 8 + 6 = 16
        //     [2, 9, 10, 12, 16]

        //nums: [1, 2, 3, 1]
        //dp:   [1, 2, 4, 3]

        //nums: [0]
        //dp: [0]

        //[2, 1]
        //[2, 1]

        //[5, 1, 2, 10, 6, 2, 7, 9, 3, 1] = 27 -> 5 + 10 + 2 + 9 + 1 = 27
        //[5, 1, 7, 11, 13, 13, 20, 22, 23, 23]


        // use a dp[] where i is the max at that high 

        int[] dp = new int[nums.length];
        int current = 0;

        if (nums.length == 2) { return Math.max(nums[nums.length - 1], nums[nums.length - 2]); } 

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            }
            else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }

        return dp[nums.length - 1];

    }
}
