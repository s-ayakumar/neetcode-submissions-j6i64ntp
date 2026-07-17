class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int windowProduct = 0;
        int track = 0;

        if (k <= 1) return 0;


        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                windowProduct = nums[i];
            } else {
                windowProduct *= nums[i];
            }

            while (windowProduct >= k) {
                windowProduct /= nums[start];
                start++;
            }

            track += i - start + 1;
            

        }

        return track;
    }
}