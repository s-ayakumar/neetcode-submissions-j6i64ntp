class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        return findMinInt(nums, 0, nums.length - 1, min);
    }

    private int findMinInt(int[] nums, int start, int end, int min) {
        if (end < start) {
            return min;
        }

        int mid = (start + end) / 2;
        min = Math.min(nums[mid], min);
        
        if (nums[mid] >= nums[end]) {
            return findMinInt(nums, mid + 1, end, min);
        }
        else {
            return findMinInt(nums, start, mid - 1, min);
        }
    }
}
