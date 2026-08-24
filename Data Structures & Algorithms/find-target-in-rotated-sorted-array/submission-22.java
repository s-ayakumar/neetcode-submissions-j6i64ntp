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
    // mid = 2 -> 5 target = 1
    // 

    private int searchHelper(int[] nums, int target, int left, int end) {
        if (left > end) return -1;

        int mid = (left + end) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] <= nums[end]) {
            if (target > nums[mid] && target <= nums[end]) {
                return searchHelper(nums, target, mid + 1, end);
            }
            else {
                return searchHelper(nums, target, left, mid - 1);
            }
        }
        else {
            if (target < nums[mid] && target >= nums[left]) {
                return searchHelper(nums, target, left, mid - 1);
            }
            else {
                return searchHelper(nums, target, mid + 1, end);
            }
        }

    }





}
