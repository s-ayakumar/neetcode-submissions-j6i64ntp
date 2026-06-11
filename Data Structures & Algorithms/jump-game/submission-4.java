class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int target = n - 1;
        
        for (int start = n - 2; start >= 0; start--)
        {
            if (start + nums[start] >= target)
            {
                target = start;
            }
        }
        
        
        return target == 0;
    }
}
