class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        return findMinIn(nums, 0, nums.length - 1, min);
        
    }

    private int findMinIn (int[] nums, int left, int right, int min) {
        if (right < left) return min;

        int mid = (left + right) / 2;

        min = Math.min(nums[mid], min);

        if (nums[mid] >= nums[right]) {
            return findMinIn(nums, mid + 1, right, min);
        }
        else {
            return findMinIn(nums, left, mid, min);
        }
    }
}
