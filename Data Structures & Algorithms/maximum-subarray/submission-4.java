class Solution {
    public int maxSubArray(int[] nums) {
        int runningTotal = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (runningTotal < 0)
            {
                runningTotal = nums[i];
                globalMax = Math.max(globalMax, runningTotal);
            }
            else 
            {
                runningTotal += nums[i];
                globalMax = Math.max(globalMax, runningTotal);
            }
        }

        return globalMax;
    }
}
