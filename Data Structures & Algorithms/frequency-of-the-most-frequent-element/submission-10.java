class Solution {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int left = 0;
        long sum = nums[left];
        int max = 1;
        int curr = 0;

        for (int i = 1; i < nums.length; i++)
        {
            sum += nums[i];
            while (left < nums.length && (long)(i - left + 1) * nums[i] - sum > k)
            {
                sum -= nums[left];
                left++;
            }
            curr = i - left + 1;
            max = Math.max(max, curr);
        }

        return max;
    }
}