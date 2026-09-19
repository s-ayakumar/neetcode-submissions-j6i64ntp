class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int start, int end) {
        if (end < start) return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == target) return mid;

        else if (nums[mid] <= nums[end]) {
            if (target > nums[mid] && target <= nums[end]) {
                return searchHelper(nums, target, mid + 1, end);
            }
            else {
                return searchHelper(nums, target, start, mid - 1);
            }
        }
        else {
            if (target >= nums[start] && target < nums[mid]) {
                return searchHelper(nums, target, start, mid - 1);
            }
            else {
                return searchHelper(nums, target, mid + 1, end);
            }
        }
    }
}
