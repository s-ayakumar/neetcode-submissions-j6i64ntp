class Solution {
    /**
    [1, 2, 3, 4, 5, 6, 7, 8] -> rotate 3 times:
    --> [6, 7, 8, 1, 2, 3, 4, 5] --> nums[4] = 2 (target = 4)
    --> 
    **/
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (nums[pivot] == target) return pivot;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        if (nums[nums.length - 1] > target) return binarySearch(nums, target, pivot + 1, nums.length - 1);
        else 
        {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }

    private int findPivot(int[] nums, int start, int end)
    {
        if (start > end) return -1;
        int pivot = (start + end) / 2;

        if (start == end) return pivot;
        if (nums[pivot] > nums[end])
        {
            return findPivot(nums, pivot + 1, end);
        }
        else 
        {
            return findPivot(nums, start, pivot);
        }

    }

    private int binarySearch(int[] nums, int target, int start, int end)
    {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) return binarySearch(nums, target, mid + 1, end);
        else 
        {
            return binarySearch(nums, target, start, mid - 1);
        }
    }
}
