class Solution {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int left = 0;
        int right = 0;
        int jumps = 0;

        while (right < target)
        {
            int newRight = 0;
            while (left <= right)
            {
                newRight = Math.max(newRight, left + nums[left]);
                left++;
            }
            left = right + 1;
            right = newRight;
            jumps++;
        }

        return jumps;
    }
}
