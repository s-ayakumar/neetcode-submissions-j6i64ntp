class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums: [1, 2, 4, 6]
        
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] output = new int[nums.length];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);

        //prefix[0] = 1
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //prefix[1]: 2
            //prefix[2]: 8
            //prefix[3]: 48
            prefix[i] = nums[i] * prefix[i - 1];
        }

        //suffix[3] = 6
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            //suffix[2] = 24
            //suffix[1] = 48
            //suffix[0] = 48
            suffix[i] = nums[i] * suffix[i + 1];
        }
        //output[0] = 48
        output[0] = suffix[1];
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                //output[3] = 8
                output[i] = prefix[i - 1];
            }
            else {
                //output[1] = 24
                //output[2] = 12
                output[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return output;
           

    }
}  
