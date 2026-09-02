class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // pre: [1, 2, 8, 24]
        // suff: [48, 48, 24, 6]
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        suffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] output = new int[nums.length];
        output[0] = suffix[1];

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                output[i] = prefix[i - 1];
            }
            else {
                output[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return output;




    }
}  
