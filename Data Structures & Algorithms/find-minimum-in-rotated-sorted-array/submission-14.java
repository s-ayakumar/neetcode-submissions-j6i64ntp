class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        return findMin(nums, 0, nums.length - 1, min);
    }

    private int findMin(int[] nums, int left, int right, int min) {
        if (right < left) return min;
        int mid = (left + right)  / 2;

        min = Math.min(min, nums[mid]);

        if (nums[mid] > nums[right]) {
            return findMin(nums, mid + 1, right, min);
        }
        else {
            return findMin(nums, left, mid - 1, min);
        }
    }


}
