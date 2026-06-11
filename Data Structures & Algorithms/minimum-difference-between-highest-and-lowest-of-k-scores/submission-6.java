class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++)
        {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }


        return minDiff;

    }
}