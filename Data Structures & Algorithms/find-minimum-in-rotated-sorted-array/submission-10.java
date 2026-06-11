class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        return findMin(nums, 0, nums.length - 1, pivot);
    }

    private int findMin(int[] nums, int start, int end, int pivot)
    {
        if (nums.length == 0) return 0;
        if (end < start) return 0;
        if (pivot == nums.length) return nums[0];

        return nums[pivot];
    }   

    private int findPivot(int[] nums, int start, int end)
    {
        if (nums.length == 0) return 0;
        if (end < start) return nums.length;
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
}
