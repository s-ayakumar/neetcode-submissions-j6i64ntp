class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        // biggest difference
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMake(nums, p, mid)) {
                right = mid;

            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMake(int[] nums, int p, int maxDiff) {
        int i = 0;
        int pCount = 0;

        while (i < nums.length - 1) 
            if (nums[i + 1] - nums[i] <= maxDiff) {
                i += 2;
                pCount++;
            } else {
                i++;
            }
        

        return pCount >= p;
    }
}