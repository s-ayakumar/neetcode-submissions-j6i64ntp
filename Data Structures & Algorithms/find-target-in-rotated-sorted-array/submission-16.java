class Solution {
    public int search(int[] nums, int target) {
        // [1, 2, 3, 4, 5, 6] -> [3, 4, 5, 6, 1, 2] -> 4 (target = 1)
        // unique elements (no duplicates)
        // if a target does not exist return -1


        // compare start, mid, and end. if 
        // check val at pivot 
        // search on left and right of pivot with helper

        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int start, int end) {
        if (end < start) return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return searchHelper(nums, target, start, mid - 1);
            }
            else {
                return searchHelper(nums, target, mid + 1, end);
            }
        }
        else {
            if (target > nums[mid] && target <= nums[end]) {
                return searchHelper(nums, target, mid + 1, end);
            }
            else {
                return searchHelper(nums, target, start, mid - 1);
            }
        }
    }




}
