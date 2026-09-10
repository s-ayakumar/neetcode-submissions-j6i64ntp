class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        return findMinIn(nums, 0, nums.length - 1, min);
    }

    private int findMinIn(int[] nums, int start, int end, int min) {
        if (start > end) return min;

        int mid = (start + end) / 2;
        min = Math.min(min, nums[mid]);

        if (nums[mid] >= nums[end]) {
            return findMinIn(nums, mid + 1, end, min);
        }
        else {
            return findMinIn(nums, start, mid - 1, min);
        }

    }
}
